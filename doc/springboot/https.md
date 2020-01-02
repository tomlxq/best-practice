

# HTTPS实践
## https相关知识
### CA是什么
CA（Certificate Authority）证书颁发机构主要负责证书的颁发、管理以及归档和吊销。证书内包含了拥有证书者的姓名、地址、电子邮件帐号、公钥、证书有效期、发放证书的CA、CA的数字签名等信息。证书主要有三大功能：加密、签名、身份验证。

Openssl是Linux下的基础安全工具



### 相关命令含义解析
#### 生成自签名根证书（即顶级CA）

##### 命令选项和参数解读

`openssl req -new -x509 -days 5480 -keyout cakey.pem -out cacert.pem`

>* req              使用openssl的req子命令
>
>* -new             生成新的证书请求
>
>* -x509            生成自签名证书
>
>* -days 5480      自签名证书的有效期5480天（15年）【仅当使用了 -x509 选项后有效】
>
>* -keyout  cakey.pem   私钥文件名指定为 `cakey.pem`【此选项的一般作用是新生成文件命名；但若同时使用了-key选项，则此选项用于原私钥文件的更名】
>
>* -out cacert.pem  指定输出所生成自签名证书的信息到文件，且文件名为cacert.pem【建议不要省略】
>
>其中，-days，-keyout 两个选项可以省略，省略的话使用默认值，有效期默认为 30 天【由程序内部在变量初始化的时候指定，与配置文件无关】，私钥文件名的默认值由配置文件 openssl.cnf 中相关条目指定，没改过的话为 `$dir/private/cakey.pem`。
>选项 -out 若是省略的话，openssl不会以文件形式输出生成的 证书/证书请求，而是会默认将文件的信息直接打印到屏幕上，这在大多数情况下，是不符合我们要求的。所以建议这个选项最好不要省略！
>req子命令可以通过 -key 选项为证书请求指定使用一个已存在的私钥文件。但在示例中的情况下，虽然使用了-new 和 -x509两个选项，但没有使用 -key 选项，这时，req子命令会自动为自签名证书生成一个RSA私钥，密钥长度的默认值由配置文件 openssl.cnf 中的相关条目指定，没改过的话为 1024 bits。

上面一个命令可以分成以两个命令：

```
openssl genrsa -out private/cakey.pem 2048
openssl req -new -x509 -key private/cakey.pem -out cacert.pem -days 365 -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com'
```

##### 关于私钥文件加密口令的指定

`openssl req -new -x509 -days 5480 -keyout cakey.pem -out cacert.pem  -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com' -passout pass:123456`

选项 -passout 的使用形式为：

-passout arg

其中，arg是选项 -passout 的参数，其格式有多种，详参《OpenSSL官方文档》中关于"PASS_PHRASE_ARGUMENTS"的介绍。

 可以用选项 -passout 改造如下：`-passout pass:123456`

> 由于Linux系统中可以使用history命令查看历史指令记录，所以出于安全方面的考量，一般如非必要，不建议在命令中直接指定口令。这与mysql登录的时候不在 -p 选项里直接指定登录口令的原因是一致的。
>
> `mysql -uroot -proot`

##### 关于证书请求文件中的DN字段

 运行中会提示输入一些 Distinguished Name fields，即证书的识别名信息字段，简称为DN字段，如下：

这些DN字段大部分有默认值，默认值由配置文件 openssl.cnf中相关条目指定。如要在某一个DN字段使用默认值，则无需输入任何信息，直接点击"Enter"键；如果确实某个DN字段的值要置为空，则输入一个 '.' 后，点击"Enter"键。

这些DN字段主要是拿来识别证书持有者身份的，下表是关于它们的缩写、说明和一些填写说明。

| DN字段名                                                     | 缩写 | 说明 | 填写要求 |
| ------------------------------------------------------------ | ---- | ---- | -------- |
|Country Name|C|证书持有者所在国家|要求填写国家代码，用2个字母表示|
|State or Province Name|ST|	证书持有者所在州或省份|填写全称，可省略不填|
|Locality Name|L	|证书持有者所在城市	|可省略不填|
|Organization Name	|O	|证书持有者所属组织或公司	|最好还是填一下|
|Organizational Unit Name	|OU	|证书持有者所属部门	|可省略不填|
|Common Name|CN	|证书持有者的通用名	|必填。<BR>对于非应用证书，它应该在一程度上具有惟一性；<BR>对于应用证书，一般填写服务器域名或通配符样式的域名。|
|Email Address	| 	|证书持有者的通信邮箱	|可省略不填|

>**DN字段的说明**
>
>**注**：表中所谓，证书不是应用证书时，其持有者的通用名要有“唯一性”，是指其通用名不要与一般主机上常见的信任证书列表或撤销证书列表中的证书产生重复。

如果不想在运行过程中逐个输入这些DN字段的值，则可以使用 -subj 选项在命令中直接指定。选项 -subj 的使用形式为：

-**subj** arg

如 `-subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com'`

需要特别注意的是，如果您设定的DN字段的值如果存在一些特殊字符【比如  （空格）、(（半角左括号）、)（半角右括号）……】，必须经过\（反斜杆）转义。

##### 如何指定自签名证书的密钥长度和类型

如果要生成密钥长度不为1024bits的RSA公私钥对，或是其他类型的【比如DSA、EC】公私钥对，则必须使用选项 -newkey 来代替 -new 。选项 -newkey 的用法比较复杂，如需详细了解，请参看《OpenSSL官方文档》的相关页面。

要生成一个密钥长度为2048bits的RSA公私钥对，命令为：

`openssl req -newkey rsa:2048 -x509 -days 5480 -keyout CA2048.key -out CA2048.crt`
#### 为顶级CA的私钥文件去除加密保护

顶级CA的私钥文件是经过加密保护的，以后每当需读取 CA.key 文件中的私钥信息时，都需输入解密口令。这种做法适合有安全需求的场合，但如果觉得不方便，也可以去除这个口令。

典型示例：`openssl rsa -in CA.key -out CA.key`

##### 命令选项和参数解读

1. `rsa`           *//使用openssl的rsa子命令*
2. `-in CA.key`   *//经加密保护的私钥文件*
3. `-out CA.key`   *//解除加密保护后的私钥文件【可以改名】*

##### 关于私钥文件解密口令的指定

如果不想在运行过程中还要输入解密口令，则可以使用选项 -passin 在命令中直接指定。选项 -passin 的使用形式为：

`-passin arg`

其中，arg是选项 -passin 的参数，其格式同选项 -passout 的参数，详参《OpenSSL官方文档》中关于"PASS_PHRASE_ARGUMENTS"的介绍。

可以用选项 -passin 改造如下：

`openssl rsa -in CA.key -out CA.key -passin pass:1314`

基于同选项 `-passout` 一样的考量，一般不建议直接在命令中指定解密口令。

#### 为 csr 文件签名，生成应用证书/中级证书

典型示例：`openssl ca -in app.csr -out app.crt -cert CA.crt -keyfile CA.key -days 1826 -policy policy_anything`

* ca                        //使用openssl的ca子命令
* -in app.csr               //指定待签发证书的 CSR文件为 app.csr
* -out app.crt              //指定输出所签发证书的信息到文件，且文件名为app.crt【建议不要省略】 
* -cert CA.crt              //指定为应用/中级证书签名的CA的公钥证书为CA.crt【用到CA证书的持有者信息】
* -keyfile CA.key           //指定为应用/中级证书签名的CA的私钥文件为CA.key【用CA私钥实际执行签名】
* -days 1826                //指定所签发证书的有效期为1826天（5年）
* -policy policy_anything   //指定签发策略为 policy_anything 【即，允许所签发证书的持有者信息和颁发者信息之间不遵守任何匹配策略】

其中，选项 -out 若是省略的话，openssl不会以文件形式输出生成的 应用证书/中级证书信息，而是会默认将证书的信息直接打印到屏幕上，这一般不符合我们的要求。所以建议这个选项不要省略！

##### 关于签发策略

在本节的典型示例中，我们使用了选项-policy来指定签发策略为 policy_anything。如果没有使用此选项，则签发策略使用由配置文件 openssl.cnf 中相关条目指定的默认策略。如果您没动过该配置文件的话，则默认策略为 policy_match。此策略要求CA的公钥证书和应用证书请求文件中的Country Name、State or Province Name、Organization Name这三个字段必须 match 【也就是一样】。

`openssl.cnf`

```
[ policy_match ]
countryName             = match
stateOrProvinceName     = match
organizationName        = match
organizationalUnitName  = optional
commonName              = supplied
emailAddress            = optional
```

所以若是您要在应用证书请求文件中指定和CA的公钥证书不一样的C/ST/O，且要签名成功，则有以下三种方式：

* 加上-policy选项，指定本次使用的签发策略为 policy_anything；
* 将配置文件 openssl.cnf 中的默认策略由 policy_match改成 policy_anything；
* 将策略 policy_match 中的相关条目由 match改成 optional ；
  

##### 关于签发中级证书（二级/三级CA，子CA）

二者主要是在证书的扩展字段Subject Type的取值有所不同。中级证书该字段取值为"CA"，表明此证书依然可以作为CA，继续签发下级证书；一般应用证书该字段的取值为"End Entity"，表明这已经是证书链的最后一个结点，自然也就不能继续签发下级证书。

```

[ usr_cert ]

# These extensions are added when 'ca' signs a request.

# This goes against PKIX guidelines but some CAs do it and some software
# requires this to avoid interpreting an end user certificate as a CA.

basicConstraints=CA:FALSE
...
[ v3_ca ]


# Extensions for a typical CA


# PKIX recommendation.

subjectKeyIdentifier=hash

authorityKeyIdentifier=keyid:always,issuer

# This is what PKIX recommends but some broken software chokes on critical
# extensions.
#basicConstraints = critical,CA:true
# So we do this instead.
basicConstraints = CA:true

```



若要生成中级证书（一般是出于信任关系建立的便利），则有以下方式：

* 上级CA在签署此证书时，加上 -extensions 选项，且选项参数设为 v3_ca （如步骤简记中所示）；
* 将 CA_default 条目中 x509_extensions 的值由 usr_cert改为 v3_ca；
* 将 usr_cert 条目中 basicConstraints的值由 CA:FALSE 改为 CA:true；

##### 关于批处理模式

如果你不想有交互，那么可以使用 -batch 选项。本小节典型示例中的命令，可以用选项 -batch  改造如下：
`openssl ca -in app.csr -out app.crt -cert CA.crt -keyfile CA.key -days 1826 -policy policy_anything -batch`

## 搭建CA服务器

### 配置文件查看

`cp /etc/pki/tls/openssl.cnf ./`

### 生成秘钥

```shell
(umask 077; openssl genrsa -out private/cakey.pem 2048)  #调用openssl子命令genrsa生成私钥
```

> 注：上述命令使用（）扩着，表示在当前shell的子shell执行,()内的设定只在子shell内生效，每个命令使用“；”分割 ， umask指定掩码， -out选项指定了生成的私钥存放位置，不指定是输出到终端的。2048 指定秘钥的长度，默认是1024。

### 生成自签证书

```shell
openssl req -new -x509 -key private/cakey.pem -out cacert.pem -days 365 -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com'
```

>- req：生成证书签署请求,使用openssl的req子命令
>- -x509：生成自签名证书
>- -days n：证书的有效天数,【仅当使用了 -x509 选项后有效】
>- -new：生成新的证书请求
>- -key /path/to/keyfile：指定私钥文件
>- -out /path/to/somefile：输出证书文件位置



### 查看自己的证书

```shell
openssl x509 -in cacert.pem  -noout -text
```
### 初始化工作环境
```
touch index.txt serial   #创建index.txt,serial文件
echo 01 >serial          #写入初始值
mkdir csr crl newcerts        #创建目录csr,crl newcerts
```

>- index.txt：索引文件，用于匹配证书编号
>- serial：证书序列号文件，只在首次生成证书时赋值
>- csr:证书请求目录
>- crl:吊销列表目标
>- newcerts：证书目录

## 用户申请证书

### 用户证书请求

```shell
#生成密钥对
(umask 077; openssl genrsa -out private/www.tom.com.key 2048)
#生成证书请求
openssl req -new -key private/www.tom.com.key  -out private/www.tom.com.csr -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=www.tom.com/emailAddress=tom@tom.com'
```

证书请求文件`private/www.tom.com.csr`发送到服务器

### CA服务器签署证书

`openssl ca -in private/www.tom.com.csr  -out www.tom.com.crt -days 365 -config ../rootca/openssl.cnf `

将证书`www.tom.com.crt`发送给请求者

### 查看证书

`openssl x509 -in www.tom.com.crt  -noout -serial -subject`

>- x509：证书格式
>- -in：要吊销的证书
>- -noout：不输出额外信息
>- -serial：显示序列号
>- -subject：显示subject信息

## 吊销证书

### 吊销证书 

`openssl ca -revoke ../rootca/newcerts/01.pem -config ../rootca/openssl.cnf`

### 生成吊销证书的编号（如果是第一次吊销）

`echo 00 > ../rootca/crlnumber`

### 更新吊销证书列表

我们虽然上面已经吊销了证书， 但是别人是无法知道的。 只能通过crl来让别人知道谁谁谁的证书被吊销了

`openssl ca -gencrl -out ../rootca/crl/ca.crl -config ../rootca/openssl.cnf`

查看crl文件内容

`openssl crl -in crl/ca.crl -noout -text`

## 多级证书

### 生成密码文件

```bash
cat password.sh 
export PW=`pwgen -Bs 10 1`
echo $PW > password
```

### 手动签发证书 `rootca.sh`

```bash
cat rootca.sh
#!/bin/bash
NAME=rootca
ROOT_DIR=/opt/certificate
DIR=$ROOT_DIR/rootca
export PW=`cat $ROOT_DIR/password`
ALIAS_NAME=rootca
rm -rf $DIR
mkdir -p $DIR
mkdir -p $DIR/{private,newcerts}
touch $DIR/index.txt
echo 01 > $DIR/serial
#生成顶级CA的公钥证书careq.pem和私钥文件cakey.pem，有效期10年（RSA 1024bits，默认）
#openssl req -new -x509 -days 3650 -keyout $DIR/private/$NAME.pem -out $DIR/$NAME.pem -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com'
#生成顶级CA的公钥证书和私钥文件，有效期15年（RSA 2048bits，指定）
openssl req   -newkey rsa:2048  -x509 -days 3650 -keyout $DIR/$NAME.key -out $DIR/$NAME.crt -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com' -passout pass:$PW
#同下面是一样的
#openssl genrsa -des3 -out $DIR/$NAME.key 2048
#openssl req -new -x509 -days 3650 -key $DIR/$NAME.key -out $DIR/$NAME.crt -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM root CA/emailAddress=tom@tom.com'
#转为x509
openssl x509 -in $DIR/$NAME.crt -out $DIR/$NAME.cer
#生成p12
openssl pkcs12 -export -clcerts -name $ALIAS_NAME -in $DIR/$NAME.crt -inkey $DIR/$NAME.key -out $DIR/$NAME.p12  -passin pass:$PW -passout pass:$PW -password pass:$PW
#p12转jks
keytool -importkeystore -alias $ALIAS_NAME -srckeystore $DIR/$NAME.p12 -srcstoretype PKCS12 -srcstorepass:env PW -deststoretype JKS -destkeystore $DIR/$NAME.jks -destkeypass:env PW  -deststorepass:env PW
```

### 签发二级CA `second.sh` 

```bash
cat second.sh
#!/bin/bash
NAME=second
ROOT_DIR=/opt/certificate
CA_DIR=$ROOT_DIR/rootca
DIR=$ROOT_DIR/second
ALIAS_NAME=secondca
export PW=`cat $ROOT_DIR/password`
rm -rf $DIR
mkdir -p $DIR
openssl genrsa -des3 -out $DIR/$NAME.key -passout pass:$PW 2048
#openssl rsa -in $DIR/$NAME.key -out $DIR/$NAME.key
openssl req -new -days 3650 -key $DIR/$NAME.key -out $DIR/$NAME.csr -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM second CA/emailAddress=tom@tom.com' -passin pass:$PW -passout pass:$PW
openssl ca -extensions v3_ca -in $DIR/$NAME.csr -config ./openssl.cnf -days 3000 -out $DIR/$NAME.crt -cert $CA_DIR/rootca.crt -keyfile $CA_DIR/rootca.key -passin pass:$PW -batch

#转为x509
openssl x509 -in $DIR/$NAME.crt -out $DIR/$NAME.cer
#生成p12
openssl pkcs12 -export -clcerts -name $ALIAS_NAME -in $DIR/$NAME.crt -inkey $DIR/$NAME.key -out $DIR/$NAME.p12  -passin pass:$PW -passout pass:$PW -password pass:$PW
#p12转jks
keytool -importkeystore -alias $ALIAS_NAME -srckeystore $DIR/$NAME.p12 -srcstoretype PKCS12 -srcstorepass:env PW -deststoretype JKS -destkeystore $DIR/$NAME.jks -destkeypass:env PW  -deststorepass:env PW
keytool -import -alias rootca -file $CA_DIR/rootca.cer -keystore $DIR/$NAME.jks -keypass:env PW -storepass:env PW<<EOF
yes
EOF
keytool -list -v -keystore $DIR/$NAME.jks  -storepass:env PW
```

### 签发三级CA`third.sh`

```bash
cat third.sh
#!/bin/bash
NAME=third
ROOT_DIR=/opt/certificate
CA_DIR=$ROOT_DIR/rootca
DIR=$ROOT_DIR/third
ALIAS_NAME=thirdca
SECOND_DIR=$ROOT_DIR/second
export PW=`cat $ROOT_DIR/password`
rm -rf $DIR
mkdir -p $DIR
openssl genrsa -des3 -out $DIR/$NAME.key -passout pass:$PW 2048
#openssl rsa -in $DIR/$NAME.key -out $DIR/$NAME.key
openssl req -new -days 3650 -key $DIR/$NAME.key -out $DIR/$NAME.csr -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=TOM third CA/emailAddress=tom@tom.com' -passin pass:$PW -passout pass:$PW
openssl ca -in $DIR/$NAME.csr -extensions v3_ca -config ./openssl.cnf -days 3000 -out $DIR/$NAME.crt -cert $SECOND_DIR/second.crt -keyfile $SECOND_DIR/second.key -passin pass:$PW -batch
#转为x509
openssl x509 -in $DIR/$NAME.crt -out $DIR/$NAME.cer
#生成p12
openssl pkcs12 -export -clcerts -name $ALIAS_NAME -in $DIR/$NAME.crt -inkey $DIR/$NAME.key -out $DIR/$NAME.p12  -passin pass:$PW -passout pass:$PW -password pass:$PW
#p12转jks
keytool -importkeystore -alias $ALIAS_NAME -srckeystore $DIR/$NAME.p12 -srcstoretype PKCS12 -srcstorepass:env PW -deststoretype JKS -destkeystore $DIR/$NAME.jks -destkeypass:env PW  -deststorepass:env PW

keytool -import -alias rootca -file $CA_DIR/rootca.cer -keystore $DIR/$NAME.jks -keypass:env PW -storepass:env PW<<EOF
yes
EOF
keytool -import -alias secondca -file $SECOND_DIR/second.cer -keystore $DIR/$NAME.jks -keypass:env PW -storepass:env PW<<EOF
yes
EOF
keytool -list -v -keystore $DIR/$NAME.jks  -storepass:env PW
```

### 签发应用CA`app.sh`

```bash
cat app.sh
#!/bin/bash
NAME=www.tom.com
ROOT_DIR=/opt/certificate
DIR=$ROOT_DIR/app
CA_DIR=$ROOT_DIR/rootca
SECOND_DIR=$ROOT_DIR/second
THIRD_DIR=$ROOT_DIR/third
ALIAS_NAME=tom
export PW=`cat $ROOT_DIR/password`
rm -rf $DIR
mkdir -p $DIR
openssl genrsa -des3 -out $DIR/$NAME.key -passout pass:$PW 2048
#openssl rsa -in $DIR/$NAME.key -out $DIR/$NAME.key
openssl req -new -days 3650 -key $DIR/$NAME.key -out $DIR/$NAME.csr -subj '/C=CN/ST=GuangDong/L=ShenZhen/O=Huawei/OU=IT Dept/CN=www.tom.com/emailAddress=tom@tom.com' -passin pass:$PW -passout pass:$PW
openssl ca -in $DIR/$NAME.csr -config ./openssl.cnf -days 3000 -out $DIR/$NAME.crt -cert $THIRD_DIR/third.crt -keyfile $THIRD_DIR/third.key -passin pass:$PW -batch

#转为x509
openssl x509 -in $DIR/$NAME.crt -out $DIR/$NAME.cer
#生成p12
openssl pkcs12 -export -clcerts -name $ALIAS_NAME -in $DIR/$NAME.crt -inkey $DIR/$NAME.key -out $DIR/$NAME.p12  -passin pass:$PW -passout pass:$PW -password pass:$PW
#p12转jks
keytool -importkeystore -alias $ALIAS_NAME -srckeystore $DIR/$NAME.p12 -srcstoretype PKCS12 -srcstorepass:env PW -deststoretype JKS -destkeystore $DIR/$NAME.jks -destkeypass:env PW  -deststorepass:env PW

keytool -import -alias rootca -file $CA_DIR/rootca.cer -keystore $DIR/$NAME.jks -keypass:env PW -storepass:env PW<<EOF
yes
EOF
keytool -import -alias secondca -file $SECOND_DIR/second.cer -keystore $DIR/$NAME.jks -keypass:env PW -storepass:env PW<<EOF
yes
EOF
keytool -import -alias thirdca -file $THIRD_DIR/third.cer -keystore $DIR/$NAME.jks -keypass:env PW -storepass:env PW<<EOF
yes
EOF
keytool -list -v -keystore $DIR/$NAME.jks  -storepass:env PW
```

> 中级证书，是具有继续颁发下级证书权限的子CA
>
> 顶级CA在签发二者的时候，只是多少一个 `-extensions v3_ca` 选项的区别，这个选项赋予被签发的证书继续签发下级证书的权力。
>
> 应用证书，特指不能用来继续颁发下级证书，只能用来证明个体身份的证书

## 自动化生成多级脚本`mkcert.sh`

```bash
#!/bin/bash
 
if [ $# -ne 1 ];then
    echo "usage ./mkcert.sh level"
    exit
fi

#生成密码文件
echo `pwgen -Bs 10 1` > pwd_private 
echo `pwgen -Bs 10 1` > pwd_keystore
#常用变量
COUNTRY_NAME="CN"
STATE_OR_PROVINCE="GuangDong"
LOCALITY_NAME="ShenZhen"
ORG_NAME="Tom company"
ORG_UNIT_NAME="IT Dept"
EMAIL_ADDRESS="tom@tom.com"

SER_COUNTRY_NAME="CN"
SER_STATE_OR_PROVINCE="GuangDong"
SER_LOCALITY_NAME="ShenZhen"
SER_ORG_NAME="Tom company"
SER_ORG_UNIT_NAME="IT Dept"
SER_EMAIL_ADDRESS="tom@tom.com" 
SER_COMMON_NAME="wwww.tom.com"

CLI_COUNTRY_NAME="CN"
CLI_STATE_OR_PROVINCE="HongKong"
CLI_LOCALITY_NAME="HongKong"
CLI_ORG_NAME="OCL company"
CLI_ORG_UNIT_NAME="IT Dept"
CLI_EMAIL_ADDRESS="ocl@ocl.com" 
CLI_COMMON_NAME="wwww.ocl.com"

CLI_COUNTRY_NAME="CN"
CLI_STATE_OR_PROVINCE="HongKong"
CLI_LOCALITY_NAME="HongKong"
CLI_ORG_NAME="OCL company"
CLI_ORG_UNIT_NAME="IT Dept"
CLI_EMAIL_ADDRESS="ocl@ocl.com" 
CLI_COMMON_NAME="wwww.ocl.com"

#是否给private key设定密码
PRIVATE_KEY_WITH_PASSWORD="true"
PASSWORD=`cat ./pwd_private`
DAYS=3650
SUBJECT=""
POLICY="policy_anything"


 
if [ $PRIVATE_KEY_WITH_PASSWORD == "true" ];then
PASSOUT="-aes256 -passout pass:$PASSWORD"
PASSIN="-passin pass:$PASSWORD"
else
PASSOUT=""
PASSIN=""
fi
 
#keystore密码
KEYSTORE_PASSWORD=`cat ./pwd_keystore` 
PKCSPASSOUT="-passout pass:$KEYSTORE_PASSWORD"
 
rm -rf RootCA* newCert openssl.cnf
cp /etc/pki/tls/openssl.cnf  ./
LV=0
while [ $LV -lt $1 ]
do
    mkdir RootCA$LV
    touch RootCA$LV/index.txt RootCA$LV/serial
    echo "01" > RootCA$LV/serial
    CERT_DIR="dir            = ."
    CERTIFICATE="certificate     = \$dir/RootCA$LV.pem"
    PRIVATE_KEY="private_key     = \$dir/private/RootCA$LV.key"
    cp openssl.cnf openssl.cnf.tmp
    sed -i "42 a$CERT_DIR" openssl.cnf.tmp
    sed -i "52 a$CERTIFICATE" openssl.cnf.tmp
    sed -i "57 a$PRIVATE_KEY" openssl.cnf.tmp
    mv openssl.cnf.tmp RootCA$LV/openssl.cnf
    ((LV=LV+1))
done


LV=0
while [ $LV -lt $1 ]
do
    echo
    echo "======= creating RootCA$LV ======="
    echo
    if [ $LV -eq 0 ];then
        cd RootCA$LV
        openssl genrsa $PASSOUT -out RootCA$LV.key 2048
        openssl req -new -x509 -days $DAYS -key RootCA$LV.key $PASSIN -out RootCA$LV.pem -subj "/C=$COUNTRY_NAME/ST=$STATE_OR_PROVINCE/L=$LOCALITY_NAME/O=$ORG_NAME/OU=$ORG_UNIT_NAME/CN=RootCA$LV/emailAddress=$EMAIL_ADDRESS" -config openssl.cnf -sha256
    else
        cd ..; cd RootCA$LV
        openssl genrsa $PASSOUT -out RootCA$LV.key 2048
        openssl req -new -x509 -days $DAYS -key RootCA$LV.key $PASSIN -out RootCA$LV.crt -subj "/C=$COUNTRY_NAME/ST=$STATE_OR_PROVINCE/L=$LOCALITY_NAME/O=$ORG_NAME/OU=$ORG_UNIT_NAME/CN=RootCA$LV/emailAddress=$EMAIL_ADDRESS" -config openssl.cnf
        openssl ca -ss_cert RootCA$LV.crt -cert ../RootCA$[$LV-1]/RootCA$[$LV-1].pem -keyfile ../RootCA$[$LV-1]/RootCA$[$LV-1].key $PASSIN -config openssl.cnf -policy $POLICY -out RootCA$LV.pem -outdir ./ -extensions v3_ca -batch
    fi
    ((LV=LV+1))
done
 
((LV=LV-1))


echo
echo "======= creating Server.pem ======="
echo
openssl genrsa $PASSOUT -out Server.key 2048
openssl req -new -x509 -days $DAYS -key Server.key $PASSIN -out Server.crt -subj "/C=$SER_COUNTRY_NAME/ST=$SER_STATE_OR_PROVINCE/L=$SER_LOCALITY_NAME/O=$SER_ORG_NAME/OU=$SER_ORG_UNIT_NAME/CN=$SER_COMMON_NAME/emailAddress=$SER_EMAIL_ADDRESS" -config openssl.cnf
openssl ca -ss_cert Server.crt -cert RootCA$LV.pem -keyfile RootCA$LV.key $PASSIN -config openssl.cnf -policy $POLICY -out Server.pem -outdir ./ -batch


echo
echo "======= creating Client.pem ======="
echo
openssl genrsa $PASSOUT -out Client.key 2048
openssl req -new -x509 -days $DAYS -key Client.key $PASSIN -out Client.crt -subj "/C=$CLI_COUNTRY_NAME/ST=$CLI_STATE_OR_PROVINCE/L=$CLI_LOCALITY_NAME/O=$CLI_ORG_NAME/OU=$CLI_ORG_UNIT_NAME/CN=$CLI_COMMON_NAME/emailAddress=$CLI_COMMON_NAME" -config openssl.cnf
openssl ca -ss_cert Client.crt -cert RootCA$LV.pem -keyfile RootCA$LV.key $PASSIN -config openssl.cnf -policy $POLICY -out Client.pem -outdir ./  -batch
echo
echo "======= verify Server.pem Client.pem ======="
echo
cp RootCA$LV.pem RootCA$LV.pem.bak
ROOTS=0
while [ $ROOTS -lt $LV ]
do
    cat ../RootCA$ROOTS/RootCA$ROOTS.pem >> RootCA$LV.pem
    ((ROOTS+=1))
done
openssl verify -CAfile RootCA$LV.pem Server.pem Client.pem
echo
echo "======= collect cert ======="
echo
cd ..;mkdir newCert
mv RootCA$LV/Server.key RootCA$LV/Server.pem RootCA$LV/Client.key RootCA$LV/Client.pem RootCA$LV/RootCA$LV.key RootCA$LV/RootCA$LV.pem newCert
 
 
echo
echo "======= verify the cert and private key ======="
echo
cd newCert
openssl rsa -modulus -noout -in Server.key $PASSIN| openssl md5
openssl x509 -modulus -noout -in Server.pem $PASSIN| openssl md5
openssl rsa -modulus -noout -in Client.key $PASSIN| openssl md5
openssl x509 -modulus -noout -in Client.pem $PASSIN| openssl md5
 
#generate pkcs12 for java program
echo
echo "======= generate pkcs12 without chain for java program ======="
echo
openssl pkcs12 -export -in Server.pem -inkey Server.key -name Server $PASSIN $PASSOUT  -out Server.p12
openssl pkcs12 -export -in Client.pem -inkey Client.key -name Client $PASSIN $PASSOUT  -out Client.p12
keytool -import -alias Client -keystore ServerTrust.p12 -storepass $KEYSTORE_PASSWORD -keypass $KEYSTORE_PASSWORD -noprompt -file Client.pem
keytool -import -alias Server -keystore ClientTrust.p12 -storepass $KEYSTORE_PASSWORD -keypass $KEYSTORE_PASSWORD -noprompt -file Server.pem
 
echo
echo "======= generate pkcs12 with chain for java program ======="
echo
echo $PASSOUT
echo $PASSIN
echo $KEYSTORE_PASSWORD
openssl pkcs12 -export -chain -CAfile RootCA$LV.pem -in Server.pem -inkey Server.key -name Server $PASSIN  $PASSOUT  -out Server_wc.p12
openssl pkcs12 -export -chain -CAfile RootCA$LV.pem -in Client.pem -inkey Client.key -name Client $PASSIN  $PASSOUT  -out Client_wc.p12
```

### Spring Boot配置`application.properties`

```properties
# Define a custom port instead of the default 8080
server.port=8443
# Tell Spring Security (if used) to require requests over HTTPS
# The format used for the keystore
server.ssl.key-store-type=PKCS12
# The path to the keystore containing the certificate
server.ssl.key-store=classpath:keystore/Server_wc.p12
# The password used to generate the certificate
server.ssl.key-store-password=4zFhYW7mdY
# The alias mapped to the certificate
server.ssl.key-alias=Server
#enable/diable https
server.ssl.enabled=true
#ssl ciphers
server.ssl.ciphers=TLS_RSA_WITH_AES_128_CBC_SHA256, ADD_OTHER_CIPHERS_IF_REQUIRED,TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384
# SSL protocol to use.
server.ssl.protocol=TLS
# Enabled SSL protocols.
server.ssl.enabled-protocols=TLSv1.2,TLSv1.1,TLSv1
```

### host配置

`C:\Windows\System32\drivers\etc\hosts`

192.168.238.160 www.tom.com
192.168.238.155 www.ocl.com

### Curl访问

`keytool -printcert -sslserver www.tom.com:8443`

`keytool -printcert -sslserver www.tom.com -rfc`

访问https的网站

`echo quit | openssl s_client -showcerts -servername www.tom.com -connect www.tom.com:8443 > cacert.pem`
`curl --cacert cacert.pem https://www.tom.com:8443`
` curl https://www.tom.com:8443 -k`

### pks转换为cer

```bash
openssl pkcs12 -in Server_wc.p12 -out Server_wc.crt -nokeys -openssl x509 -inform pem -in Server_wc.crt -outform der -out Server_wc.cer
```

## Issuers

### 1. curl: (51) Unable to communicate securely with peer: requested domain name does not match the server's certificate.报错

   解决办法：

   You can use the domain name as usual but override the resolver like so:

    curl -v --resolve subdomain.example.com:443:x.x.x.x https://subdomain.example.com/
It might be awkward to maintain a lot of such mappings though. You might prefer to just ignore the cert 	mismatch:

 `curl --insecure https://subdomain.example.com/`

### 2. pwgen安装

```bash
mkdir -p /opt/tools
scp root@192.168.238.150:/opt/tools/pwgen-2.08.tar.gz /opt/tools/
tar -zxvf pwgen-2.08.tar.gz 
cd pwgen-2.08
./configure
make
make install
```

### 3. spring boot 使用spring.profiles.active来分区配置

`java -jar https-demo.jar --spring.profiles.active=tom`

`application.properties`

```properties
# Define a custom port instead of the default 8080
http.port=8080
# Define a custom port instead of the default 8080
server.port=8443
```

`application-tom.properties`

```properties
# Tell Spring Security (if used) to require requests over HTTPS
# The format used for the keystore
server.ssl.key-store-type=PKCS12
# The path to the keystore containing the certificate
server.ssl.key-store=classpath:keystore/Server_wc.p12
# The password used to generate the certificate
server.ssl.key-store-password=4zFhYW7mdY
# The alias mapped to the certificate
server.ssl.key-alias=Server
#enable/diable https
server.ssl.enabled=true
#ssl ciphers
server.ssl.ciphers=TLS_RSA_WITH_AES_128_CBC_SHA256, ADD_OTHER_CIPHERS_IF_REQUIRED,TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384
# SSL protocol to use.
server.ssl.protocol=TLS
# Enabled SSL protocols.
server.ssl.enabled-protocols=TLSv1.2,TLSv1.1,TLSv1
springstudy.domain=www.tom.com
```

## 参考文档：

* Generating X.509 Certificates

  https://lightbend.github.io/ssl-config/CertificateGeneration.html

* Generating a Self-Signed Certificate
  https://www.baeldung.com/spring-boot-https-self-signed-certificate

* [搭建私有CA服务器](https://www.cnblogs.com/zhaojiedi1992/p/zhaojiedi_linux_011_ca.html)

* 《OpenSSL编程》（赵春平 著）【一本难得的中文资料，未出版】

* 《OpenSSL官方文档---OpenSSL命令》（英文）

* 《互动百科---SSL》，说明了证书中各DN字段的含义

一些前辈的博文，也对我快速定位问题提供了很大的帮助，在此表示感谢！并列举如下：
* 博客园 - rusty，《Openssl使用生成CA总结》 ，提到了需要提前建好一些目录和文件

* 百度空间 - mars208，《使用openssl创建CA》，提到了签发策略的问题

* ChinaUnix - ehyyngp，《使用openssl签发证书》，提到了中级证书的签发问题

*  [P12,JKS,CER,RFX,PEM转换速记](https://www.cnblogs.com/cherrychen-cakuta/p/8028020.html)

* 证书格式转换

  https://myssl.com/cert_convert.html
  
* 使用openssl生成多级证书

  [http://mowblog.com/%e4%bd%bf%e7%94%a8openssl%e7%94%9f%e6%88%90%e5%a4%9a%e7%ba%a7%e8%af%81%e4%b9%a6/](http://mowblog.com/使用openssl生成多级证书/)
  
* OpenSSL 创建私有 CA 三部曲

  https://www.cnblogs.com/sparkdev/p/10369313.html

