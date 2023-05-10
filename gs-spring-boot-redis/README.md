
## 1.2 wget获取
wget https://download.redis.io/releases/redis-7.0.7.tar.gz
## 2 编译安装
```bash
tar -zxf redis-7.0.7.tar.gz -C /tools
cd redis-7.0.7
make
make install PREFIX=/tools/redis
```
## 3添加环境变量设置
### 3.1配置环境变量
```bash
vi ~/.bash_profile
REDIS_HOME=/tools/redis
PATH=$PATH:$REDIS_HOME/bin
source ~/.bash_profile
```

### 3.2 启动和停止
```bash
#实际是去找/tools/redis/bin的这个启动语句,并使用redis配置文件
redis-server /tools/redis-7.0.7/redis.conf
#/tools/redis/bin的这个预计进行停止
redis-cli shutdown
```

## 3.3 测试
```bash
redis-cli
set name potato
get name
```
### 3.4 redis.conf文件说明
```bash
#设置后台启动，如果不是后台启动，每次推出redis就关闭了
daemonize yes
#开启密码保护，注释则不需要密码
requirepass 密码
#设置端口号
port 端口号
#允许访问的ip，改为0.0.0.0就是所有ip均可
bind 127.0.0.1 -::1
bind 0.0.0.0
```
## 3.5设开机置自启 
```bash
touch /usr/lib/systemd/system
vi /usr/lib/systemd/system/redis.service
[Unit]
Description=redis-server
After=network.target

[Service]
Type=forking

ExecStart=/tools/redis/bin/redis-server /tools/redis-7.0.7/redis.conf
PrivateTmp=true

[Install]
WantedBy=multi-user.target
```
```bash
#重载系统服务
systemctl daemon-reload
#设置开机自启
systemctl enable redis.service
#取消开机自启
systemctl disable redis.service
#启动服务
systemctl start redis.service
#停止服务
systemctl stop redis.service
#查看服务状态
systemctl status redis.service
```
4 可能存在的问题
```bash
service iptables stop
firewall-cmd --zone=public --add-port=6379/tcp --permanent
firewall-cmd --reload
systemctl status firewalld
systemctl stop firewalld
./redis-cli shutdown -a redis
./redis-cli -a redis shutdown
```

# [20种 Redis 的妙用场景](Redis 只会用缓存？20种妙用让同事直呼牛X.md)


# Reference

## 菜鸟教程：https://www.runoob.com/redis

