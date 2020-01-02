

## Openssl是Linux下的基础安全工具

Openssl功能主要有：

* 对称加密（DES、3DES、AES等）

* 非对称加密（RSA）

* 散列（MD5、SHA1等）

* 证书的相关操作（创建、申请、颁发、吊销等）

PKI体系成为公钥加密体系，组成部分包括：
* 认证中心
* 注册中心
* 证书库
* 证书废止列表

Openssl常用证书格式：
* X509
* PKCS7
* PKCS12

证书文件常用存储格式：
* PEM（BASE64）
* PFX
* P12(二进制）

### 根CA相关操作

私钥生成、生成自认证证书

```bash
 cat rootca.sh
export CUR_DIR=$(cd "$(dirname "$0")";pwd)
export ROOT_DIR=$CUR_DIR/rootca

rm -rf $ROOT_DIR/
mkdir -p $ROOT_DIR/
echo `pwgen -Bs 10 1`>$ROOT_DIR/password
export PW=`cat $ROOT_DIR/password`
#export PW="123456"
cd $ROOT_DIR/
cp /etc/pki/tls/openssl.cnf .


export DIR="dir=."
sed -i "42 a$DIR" openssl.cnf
#创建证书数据库文件
touch index.txt
#创建证书序号文件
echo "01">serial


#生成ROOTCA私钥，rootca.key格式为PEM
openssl genrsa -des3 -out rootca.key -passout pass:$PW 2048

#生成ROOTCA证书（类型为X509），rootca.crt格式为PEM
openssl req -new -x509 -key rootca.key -out rootca.crt -config openssl.cnf -passin pass:$PW -subj '                                                       /C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com' -days 36                                                       50
#查看证书和私钥可以用以下命令
openssl rsa -in rootca.key -text -noout -passin pass:$PW
#basicConstraint称为基础约束，若有CA：TRUE，证明该证书具有CA效力。
openssl x509 -in rootca.crt -text -noout -passin pass:$PW

cd $CUR_DIR
```

### 用户证书相关操作

私钥生成、生成证书签发请求文件、根CA同意请求签发该证书

```bash
#cat middle.sh
export CUR_DIR=$(cd "$(dirname "$0")";pwd)
export CA_DIR=$CUR_DIR/rootca
export ROOT_DIR=$CUR_DIR/middle

rm -rf $ROOT_DIR/
mkdir -p $ROOT_DIR/
echo `pwgen -Bs 10 1`>$ROOT_DIR/password
export PW=`cat $ROOT_DIR/password`
export CA_PW=`cat $CA_DIR/password`
#export PW="123456"
cd $ROOT_DIR/
cp /etc/pki/tls/openssl.cnf .
echo `pwd`

export DIR="dir=."
sed -i "42 a$DIR" openssl.cnf
#创建证书数据库文件
touch index.txt
#创建证书序号文件
echo "01">serial


#生成middle私钥，middle.key格式为PEM
openssl genrsa -des3 -out middle.key -passout pass:$PW 2048

#生成用户请求文件
openssl req -new -key middle.key -out middle.csr -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=tom authority ca/emailAddress=tom@tom.com' -passin pass:$PW -config openssl.cnf

#查看证书和私钥可以用以下命令
openssl rsa -in middle.key -text -noout -passin pass:$PW




#生成middle证书（类型为X509），middle.crt格式为PEM
cd $CA_DIR
openssl ca -config openssl.cnf -cert rootca.crt -keyfile rootca.key  -extensions v3_ca -days 3650 -in $ROOT_DIR/middle.csr -out $ROOT_DIR/middle.crt -outdir $ROOT_DIR -passin pass:$CA_PW -batch

#basicConstraint称为基础约束，若有CA：TRUE，证明该证书具有CA效力。
openssl x509 -in $ROOT_DIR/middle.crt -text -noout -passin pass:$PW

cd $CUR_ROOT

#命令验证中间证书
openssl x509 -noout -text -in $ROOT_DIR/middle.crt

openssl verify -CAfile $CA_DIR/rootca.crt $ROOT_DIR/middle.crt

#创建证书链文件
cat $ROOT_DIR/middle.crt $CA_DIR/rootca.crt > $ROOT_DIR/middle-chain.crt
#PEM convert p12
openssl pkcs12 -export  -name "middle" -inkey $ROOT_DIR/middle.key -in $ROOT_DIR/middle.crt -certfile $ROOT_DIR/middle-chain.crt -out $ROOT_DIR/middle-chain.p12 -passout pass:$PW -passin pass:$PW
```

### 次级CA证书相关操作

从根CA得到次级CA证书和次级CA私钥之后，再给下属用户签发证书

```bash
cat app.sh
export CUR_DIR=$(cd "$(dirname "$0")";pwd)
export CA_DIR=$CUR_DIR/rootca
export MID_DIR=$CUR_DIR/middle
export ROOT_DIR=$CUR_DIR/app

rm -rf $ROOT_DIR/
mkdir -p $ROOT_DIR/
echo `pwgen -Bs 10 1`>$ROOT_DIR/password
export PW=`cat $ROOT_DIR/password`
export CA_PW=`cat $CA_DIR/password`
export MID_PW=`cat $MID_DIR/password`
#export PW="123456"
cd $ROOT_DIR/
cp /etc/pki/tls/openssl.cnf .
echo `pwd`

export DIR="dir=."
sed -i "42 a$DIR" openssl.cnf
#创建证书数据库文件
touch index.txt
#创建证书序号文件
echo "01">serial

#生成app私钥，app.key格式为PEM(实际情况是在网站本身做)
openssl genrsa -des3 -out app.key -passout pass:$PW 2048

#生成用户请求文件(实际情况是在网站本身做)
openssl req -new -key app.key -out app.csr -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=wwww.tom.com/emailAddress=tom@tom.com' -passin pass:$PW -config openssl.cnf

#查看证书和私钥可以用以下命令(实际情况是在网站本身做)
openssl req -text -noout -in app.csr
openssl rsa -in app.key -text -noout -passin pass:$PW

#生成app证书（类型为X509），app.crt格式为PEM
cd $MID_DIR
openssl ca -config openssl.cnf -cert middle.crt -keyfile middle.key  -extensions usr_cert -days 3650 -in $ROOT_DIR/app.csr -out $ROOT_DIR/app.crt -outdir $ROOT_DIR -passin pass:$MID_PW -batch

#basicConstraint称为基础约束，若有CA：TRUE，证明该证书具有CA效力。
openssl x509 -in $ROOT_DIR/app.crt -text -noout -passin pass:$PW

cd $CUR_ROOT

#命令验证中间证书
openssl x509 -noout -text -in $ROOT_DIR/app.crt

openssl verify -CAfile $MID_DIR/middle-chain.crt $ROOT_DIR/app.crt

#转换用户证书为PKCS12
openssl pkcs12 -export -in $ROOT_DIR/app.crt -inkey $ROOT_DIR/app.key -out $ROOT_DIR/app.pfx -chain -CAfile $MID_DIR/middle-chain.crt -passin pass:$PW -passout pass:$PW
```



## 自签名的证书有两程格式

- PKCS12: [Public Key Cryptographic Standards](https://en.wikipedia.org/wiki/PKCS_12) is a password protected format that can contain multiple certificates and keys; it's an industry-wide used format
- JKS: [Java KeyStore](https://en.wikipedia.org/wiki/Keystore) is similar to PKCS12; it's a proprietary format and is limited to the Java environment.
##  生成自签名证书
```bash
echo `pwgen -Bs 10 1`>password
export PW=`cat password`

export ALIAS_NAME="tom"
#生成PKCS12 keystore format
keytool -genkeypair -alias:env ALIAS_NAME -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore tom.p12 -validity 3650 -dname "CN=www.com.com, OU=tom Org, O=tom Company, L=ShenZhen, ST=GuangDong, C=CN"  -storepass:env PW -keypass:env PW
#生成JKS format
keytool -genkeypair -alias:env ALIAS_NAME -keyalg RSA -keysize 2048 -storetype JKS -keystore tom.jks -validity 3650 -dname "CN=www.com.com, OU=tom Org, O=tom Company, L=ShenZhen, ST=GuangDong, C=CN" -storepass:env PW -keypass:env PW
#convert JKS to PKCS12 format 
keytool -importkeystore -srcalias:env ALIAS_NAME -srckeystore tom.jks -destkeystore tom1.p12 -destalias:env ALIAS_NAME -deststoretype pkcs12 -srcstorepass:env PW -srckeypass:env PW -deststorepass:env PW -destkeypass:env PW
```
## spring boot中的配置 `application.properties`

```properties
server.ssl.key-store-type=PKCS12
# The path to the keystore containing the certificate
#server.ssl.key-store=classpath:keystore/Server_wc.p12
server.ssl.key-store=classpath:keystore/Server_tom.p12
# The password used to generate the certificate
server.ssl.key-store-password=4zFhYW7mdY
```

## `openssl.cnf`配置说明

### ca段

```properties
[ ca ]
# `man ca`
default_ca = CA_default
```

ca是必段的，我们告诉openssl使用的是`CA_default`

### CA_default段

包括了许多默认的配置，其中dir为你生成根证书的目标

```properties
[ CA_default ]
# Directory and file locations.
dir               = /root/ca
certs             = $dir/certs
crl_dir           = $dir/crl
new_certs_dir     = $dir/newcerts
database          = $dir/index.txt
serial            = $dir/serial
RANDFILE          = $dir/private/.rand

# The root key and root certificate.
private_key       = $dir/private/ca.key.pem
certificate       = $dir/certs/ca.cert.pem

# For certificate revocation lists.
crlnumber         = $dir/crlnumber
crl               = $dir/crl/ca.crl.pem
crl_extensions    = crl_ext
default_crl_days  = 30

# SHA-1 is deprecated, so use SHA-2 instead.
default_md        = sha256

name_opt          = ca_default
cert_opt          = ca_default
default_days      = 375
preserve          = no
policy            = policy_strict
```

> `index.txt` 和 `serial`作为平面文件数据库，用于记录跟踪签名证书

### policy_strict

我们将对所有根CA签名应用policy_strict，因为根CA仅用于创建中间CA。

```properties
[ policy_strict ]
# The root CA should only sign intermediate certificates that match.
# See the POLICY FORMAT section of `man ca`.
countryName             = match
stateOrProvinceName     = match
organizationName        = match
organizationalUnitName  = optional
commonName              = supplied
emailAddress            = optional
```

### policy_loose

我们将对所有中间CA签名应用policy_loose，因为中间CA是对可能来自各种第三方的服务器和客户端证书进行签名的。

```properties
[ policy_loose ]
# Allow the intermediate CA to sign a more diverse range of certificates.
# See the POLICY FORMAT section of the `ca` man page.
countryName             = optional
stateOrProvinceName     = optional
localityName            = optional
organizationName        = optional
organizationalUnitName  = optional
commonName              = supplied
emailAddress            = optional
```

### req

创建证书或证书签名请求时应用[req]部分中的选项。

```properties
[ req ]
# Options for the `req` tool (`man req`).
default_bits        = 2048
distinguished_name  = req_distinguished_name
string_mask         = utf8only

# SHA-1 is deprecated, so use SHA-2 instead.
default_md          = sha256

# Extension to add when the -x509 option is used.
x509_extensions     = v3_ca
```

### req_distinguished_name

`[ req_distinguished_name ]`部分声明了证书签名请求中通常需要的信息。您可以选择指定一些默认值。

```properties
[ req_distinguished_name ]
# See <https://en.wikipedia.org/wiki/Certificate_signing_request>.
countryName                     = Country Name (2 letter code)
stateOrProvinceName             = State or Province Name
localityName                    = Locality Name
0.organizationName              = Organization Name
organizationalUnitName          = Organizational Unit Name
commonName                      = Common Name
emailAddress                    = Email Address

# Optionally, specify some defaults.
countryName_default             = CN
stateOrProvinceName_default     = GuangDong
localityName_default            = ShenZhen
0.organizationName_default      = Tom company Ltd
#organizationalUnitName_default =
#emailAddress_default           =
```

### v3_ca

我们将在创建根证书时应用v3_ca扩展。

```properties
[ v3_ca ]
# Extensions for a typical CA (`man x509v3_config`).
subjectKeyIdentifier = hash
authorityKeyIdentifier = keyid:always,issuer
basicConstraints = critical, CA:true
keyUsage = critical, digitalSignature, cRLSign, keyCertSign
```

### v3_intermediate_ca

在创建中间证书时，我们将应用v3_ca_intermediate扩展。`pathlen:0`确保中间CA之下不能有其他证书颁发机构。

```properties
[ v3_intermediate_ca ]
# Extensions for a typical intermediate CA (`man x509v3_config`).
subjectKeyIdentifier = hash
authorityKeyIdentifier = keyid:always,issuer
basicConstraints = critical, CA:true, pathlen:0
keyUsage = critical, digitalSignature, cRLSign, keyCertSign
```

### usr_cert

在签署客户端证书(例如用于远程用户身份验证的证书)时，我们将应用usr_cert扩展。

```properties
[ usr_cert ]
# Extensions for client certificates (`man x509v3_config`).
basicConstraints = CA:FALSE
nsCertType = client, email
nsComment = "OpenSSL Generated Client Certificate"
subjectKeyIdentifier = hash
authorityKeyIdentifier = keyid,issuer
keyUsage = critical, nonRepudiation, digitalSignature, keyEncipherment
extendedKeyUsage = clientAuth, emailProtection
```

### server_cert

在签署服务器证书(如用于web服务器的证书)时，我们将应用server_cert扩展。

```properties
[ server_cert ]
# Extensions for server certificates (`man x509v3_config`).
basicConstraints = CA:FALSE
nsCertType = server
nsComment = "OpenSSL Generated Server Certificate"
subjectKeyIdentifier = hash
authorityKeyIdentifier = keyid,issuer:always
keyUsage = critical, digitalSignature, keyEncipherment
extendedKeyUsage = serverAuth
```

### crl_ext

crl_ext扩展在创建证书撤销列表时自动应用。

```properties
[ crl_ext ]
# Extension for CRLs (`man x509v3_config`).
authorityKeyIdentifier=keyid:always
```

### ocsp

我们将在签署在线证书状态协议(ocsp)证书时应用ocsp扩展。

```properties
[ ocsp ]
# Extension for OCSP signing certificates (`man ocsp`).
basicConstraints = CA:FALSE
subjectKeyIdentifier = hash
authorityKeyIdentifier = keyid,issuer
keyUsage = critical, digitalSignature
extendedKeyUsage = critical, OCSPSigning
```

## 创建根证书

### 创建根密钥

创建根密钥(ca.key.pem)并保证绝对安全。任何拥有根密钥的人都可以颁发受信任的证书。使用AES 256位加密和强密码加密根密钥。

```bash
cd /root/ca
openssl genrsa -aes256 -out private/ca.key.pem -passout pass:123456 2048
chmod 400 private/ca.key.pem
```

### 创建根证书

使用根密钥(ca.key.pem)创建根证书(ca.cert.pem)。给根证书一个很长的有效期，比如20年。一旦根证书过期，CA签署的所有证书都将无效。

```bash
openssl req -config openssl.cnf -key private/ca.key.pem  -new -x509 -days 7300 -sha256 -extensions v3_ca  -out certs/ca.cert.pem -passin pass:123456 -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Tom company Ltd/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com'
chmod 444 certs/ca.cert.pem
```

> 无论何时使用req工具，都必须指定一个配置文件与-config选项一起使用，否则OpenSSL将默认为/etc/pki/tls/openssl.cnf。

### 验证根证书

```bash
openssl x509 -noout -text -in certs/ca.cert.pem
```

输出显示了:

` Signature Algorithm`签名算法

`Validity`使用证书的有效日期，

`Public-Key`公钥长度

`Issuer`该公钥位长是签发证书的主体实体

`Subject`指的是证书本身

`X509v3 extensions`输出还显示了X509v3扩展。我们应用了v3_ca扩展，因此`[v3_ca]`中的选项应该反映在输出中。

> `Issuer`发行者和`Subject`主体是相同的，因为是自签名证书。注意，所有根证书都是自签名的。

```
Certificate:
    Data:
        Version: 3 (0x2)
        Serial Number:
            87:98:93:37:24:cd:46:cb
    Signature Algorithm: sha256WithRSAEncryption # 
        Issuer: C=CN, ST=GuangDong, L=ShenZhen, O=Tom company Ltd, OU=IT Dept, CN=TOM roo                                                                                       t CA/emailAddress=tom@tom.com
        Validity
            Not Before: Jan  1 17:43:58 2020 GMT
            Not After : Dec 27 17:43:58 2039 GMT
        Subject: C=CN, ST=GuangDong, L=ShenZhen, O=Tom company Ltd, OU=IT Dept, CN=TOM ro                                                                                       ot CA/emailAddress=tom@tom.com
        Subject Public Key Info:
            Public Key Algorithm: rsaEncryption
                Public-Key: (2048 bit)
                Modulus:
                    ...
                Exponent: 65537 (0x10001)
        X509v3 extensions:
            X509v3 Subject Key Identifier:
                6F:6C:B5:82:5A:AE:52:77:C7:E3:0F:2A:66:51:30:2A:CA:F7:19:2B
            X509v3 Authority Key Identifier:
                keyid:6F:6C:B5:82:5A:AE:52:77:C7:E3:0F:2A:66:51:30:2A:CA:F7:19:2B

            X509v3 Basic Constraints: critical
                CA:TRUE
            X509v3 Key Usage: critical
                Digital Signature, Certificate Sign, CRL Sign
    Signature Algorithm: sha256WithRSAEncryption
         ...
```

## 创建中间证书

中间证书颁发机构(CA)是代表根证书颁发机构签署证书的实体。根证书颁发机构签署中间证书，形成信任链。

使用中间CA的目的主要是为了安全。根密钥可以保持脱机状态，并尽可能少地使用。如果中间密钥被破坏，根CA可以撤销中间证书并创建一个新的中间证书。

### 请求文件目录

```bash
mkdir /root/intermediate
cd /root/intermediate
mkdir certs crl csr newcerts private
chmod 700 private
touch index.txt
echo 1000 > serial
echo 1000 > crlnumber
```

`csr`创建用于根CA文件的相同目录结构。还可以方便地创建一个csr目录来保存证书签名请求。

将`crlnumber`文件添加到中间的CA目录树中。crlnumber用于跟踪证书撤销列表。

修改`CA_default`这这样

```properties
[ CA_default ]
dir             = /root/intermediate
private_key     = $dir/private/intermediate.key.pem
certificate     = $dir/certs/intermediate.cert.pem
crl             = $dir/crl/intermediate.crl.pem
policy          = policy_loose
```

### 生成证书请求文件

创建中间密钥(intermediate.key.pem)。使用AES 256位加密和强密码加密中间密钥。

```bash
openssl genrsa -aes256 -out private/intermediate.key.pem -passout pass:123456  4096
chmod 400 private/intermediate.key.pem
openssl req -config openssl.cnf -new -sha256 -key private/intermediate.key.pem -out csr/intermediate.csr.pem -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Tom company Ltd/OU=Tom Ltd Certificate Authority/CN=Tom Ltd Intermediate CA/emailAddress=tom@tom.com' -passin pass:123456
```

> 使用中间密钥创建证书签名请求(CSR)。详细信息通常应与根CA匹配。但是，通用名称必须不同。
>
> 确保您指定了中间CA配置文件(intermediate/openssl.cnf)

### 生成中间证书

到ca目录签署中间证书

要创建中间证书，使用根CA和v3_intermediate_ca扩展来签署中间CSR。中间证书的有效期应该比根证书短。十年是合理的。

```bash
openssl ca -config openssl.cnf -extensions v3_intermediate_ca -days 3650 -notext -md sha256 -in $CA_DIR/csr/intermediate.csr.pem -out $CA_DIR/certs/intermediate.cert.pem -passin pass:123456 -batch
chmod 444 $CA_DIR/certs/intermediate.cert.pem
```

> 这一次，指定根CA配置文件(ca/openssl.cnf)。

`index.txt`文件是OpenSSL `ca`工具存储证书数据库的地方。不要手动删除或编辑此文件。它现在应该包含引用中间证书的行。

```bash
cat ca/index.txt
V  291229184856Z 1000  unknown /C=CN/ST=GuangDong/O=Tom company Ltd/OU=Tom Ltd Certificate Authority/CN=Tom Ltd Intermediate CA/emailAddress=tom@tom.com
```

### 验证中间证书

与我们对根证书所做的一样，检查中间证书的详细信息是否正确。

```bash
openssl x509 -noout -text -in certs/intermediate.cert.pem
```

根据根证书验证中间证书。OK表示信任链是完整的。

```bash
openssl verify -CAfile certs/cacert.pem $CA_DIR/certs/intermediate.cert.pem
```

### 创建证书链文件

当应用程序(例如，web浏览器)试图验证由中间CA签名的证书时，它还必须根据根证书验证中间证书。要完成信任链，请创建一个CA证书链来呈现给应用程序。

要创建CA证书链，请将中间证书和根证书连接在一起。稍后，我们将使用这个文件来验证由中间CA签名的证书。

```bash
# 创建证书链文件
cat $CA_DIR/certs/intermediate.cert.pem $ROOT_DIR/certs/cacert.pem > $CA_DIR/certs/ca-chain.cert.pem
chmod 444 $CA_DIR/certs/ca-chain.cert.pem
```

> 我们的证书链文件必须包含根证书，因为还没有客户端应用程序知道它。更好的选择是在需要连接的每个客户机上安装根证书，尤其是在管理内部网时。在这种情况下，链文件只需要包含您的中间证书。

## 签署服务器和客户端证书

我们将使用我们的中间CA对证书进行签名。您可以在各种情况下使用这些签名证书，例如受保护到web服务器的连接，或验证连接到服务的客户端。

> 下面的步骤是从您作为证书颁发机构的角度来看的。但是，第三方可以创建自己的私有密匙和证书签名请求(CSR)，而不必向您显示它们的私有密匙。他们把他们的CSR给你，你再把签署过的证书还给他们。在这个场景中，跳过genrsa和req命令。

### 创建私钥和证书请求文件

我们的根和中间对是4096位。服务器和客户端证书通常在一年后到期，所以我们可以安全地使用2048位。

```bash
openssl genrsa -aes256 -out private/www.example.com.key.pem -passout pass:123456  2048
chmod 400 private/www.example.com.key.pem

openssl req -config openssl.cnf -new -sha256 -key private/www.example.com.key.pem -out csr/www.example.com.csr.pem -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Tom company Ltd/OU=Tom Ltd Web Services/CN=www.example.com/emailAddress=tom@tom.com' -passin pass:123456
```

> 尽管4096位比2048位稍微安全一些，但它减慢了TLS握手的速度，并显著增加了握手过程中的处理器负载。因此，大多数网站使用2048位对。

如果您正在创建用于web服务器(例如Apache)的密码对，那么每次重新启动web服务器时都需要输入此密码。您可能想要忽略-aes256选项来创建没有密码的密钥。

### 产生证书

使用私钥创建证书签名请求(CSR)。CSR细节不需要与中间CA匹配。对于服务器证书，公共名称必须是一个完全限定的域名(如www.example.com)，而对于客户端证书，它可以是任何唯一标识符(如电子邮件地址)。注意，通用名称不能与您的根证书或中间证书相同。

```bash
openssl ca -config $ROOT_DIR/openssl.cnf -extensions server_cert -days 365 -notext -md sha256 -in $CA_DIR/csr/www.example.com.csr.pem -out $CA_DIR/certs/www.example.com.cert.pem -passin pass:123456 -batch
```

要创建证书，请使用中间CA来签署CSR。如果证书将在服务器上使用，请使用server_cert扩展名。如果证书将用于用户身份验证，请使用usr_cert扩展名。证书的有效期通常为一年，而CA通常会为了方便多给几天时间。

中间/index.txt文件应该包含引用这个新证书的行。

```bash
cat intermediate/index.txt
V 201231233804Z 1000 unknown /C=CN/ST=GuangDong/L=ShenZhen/O=Tom company Ltd/OU=Tom Ltd Web Services/CN=www.example.com/emailAddress=tom@tom.com
```

### 检查、验证证书

```bash
openssl x509 -noout -text -in $CA_DIR/certs/www.example.com.cert.pem
```

发行者是中间CA。主体是指证书本身。

```bash
Certificate:
    Data:
        Version: 3 (0x2)
        Serial Number: 4096 (0x1000)
    Signature Algorithm: sha256WithRSAEncryption
        Issuer: C=CN, ST=GuangDong, O=Tom company Ltd, OU=Tom Ltd Certificate Authority, CN=Tom Ltd Intermediate CA/emailAddress=tom@tom.com
        Validity
            Not Before: Jan  1 23:38:04 2020 GMT
            Not After : Dec 31 23:38:04 2020 GMT
        Subject: C=CN, ST=GuangDong, L=ShenZhen, O=Tom company Ltd, OU=Tom Ltd Web Services, CN=www.example.com/emailAddress=tom@tom.com
        Subject Public Key Info:
            Public Key Algorithm: rsaEncryption
                Public-Key: (2048 bit)
                Modulus:
                    ...
                Exponent: 65537 (0x10001)
        X509v3 extensions:
            X509v3 Basic Constraints:
                CA:FALSE
            Netscape Cert Type:
                SSL Server
            Netscape Comment:
                OpenSSL Generated Server Certificate
            X509v3 Subject Key Identifier:
                8F:11:49:29:90:62:FF:AE:9C:6F:B4:2D:AA:33:54:39:AF:13:AB:AB
            X509v3 Authority Key Identifier:
                keyid:AB:47:67:BE:B6:BD:2A:A4:52:64:AE:92:6E:76:39:E0:1E:8A:62:48
                DirName:/C=CN/ST=GuangDong/L=ShenZhen/O=Tom company Ltd/OU=Tom Ltd Certificate Authority/CN=Tom Ltd Root CA/emailAddress=tom@tom.com
                serial:10:00

            X509v3 Key Usage: critical
                Digital Signature, Key Encipherment
            X509v3 Extended Key Usage:
                TLS Web Server Authentication
    Signature Algorithm: sha256WithRSAEncryption
         ...
```

输出还将显示X509v3扩展。在创建证书时，您使用server_cert或usr_cert扩展。相应配置部分中的选项将反映在输出中。

```bash
openssl verify -CAfile $ROOT_DIR/certs/ca-chain.cert.pem $CA_DIR/certs/www.example.com.cert.pem
```

使用我们前面创建的CA证书链文件(`ca-chain.cert.pem`)来验证新证书具有有效的信任链。

```bash
openssl verify -CAfile intermediate/certs/ca-chain.cert.pem svr/certs/www.example.com.cert.pem
svr/certs/www.example.com.cert.pem: OK
```

## 部署证书

现在，您可以将新证书部署到服务器，或者将证书分发到客户机。当部署到服务器应用程序(如Apache)，你需要使下列文件可用:

- `ca-chain.cert.pem`
- `www.example.com.key.pem`
- `www.example.com.cert.pem`

> 如果您从第三方签署CSR，您无法访问他们的私钥，因此您只需将链文件(ca-chain.cert.pem)和证书(www.example.com.cert.pem)交还给他们。



## Issuers:

### vi 替换

` :%s/\/root\//\$CUR_DIR\/ `

表示将`/root/`替换为`$CUR_DIR/`

替换的语法为  

`:$s/old_value/new_value/`

 对替换/、$等字符需转义

## References

1. https://jamielinux.com/docs/openssl-certificate-authority/index.html