# Jenkins+Docker 实现一键自动化部署项目
## 一、安装docker
```shell
# 确保yum包更新到最新
yum update
# 卸载旧版本(如果安装过旧版本的话)
yum remove docker  docker-common docker-selinux docker-engine
# 安装需要的软件包
yum install -y yum-utils device-mapper-persistent-data lvm2
# 设置yum源
cd /etc/yum.repos.d
mkdir repo_bak
mv *.repo repo_bak/
curl -o /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
wget -O /etc/yum.repos.d/epel-7.repo  http://mirrors.aliyun.com/repo/epel-7.repo
wget -O /etc/yum.repos.d/CentOS-Base.repo https://repo.huaweicloud.com/repository/conf/CentOS-7-reg.repo

yum clean all 
yum makecache

yum list | grep epel-release
yum repolist enabled
yum repolist all

#安装docker
yum install docker-ce  #由于repo中默认只开启stable仓库，故这里安装的是最新稳定版17.12.0
#yum install <自己的版本>  # 例如：sudo yum install docker-ce-17.12.0.ce

# 启动和开机启动
systemctl start docker
systemctl enable docker

# 验证安装是否成功
docker version
```
## 二、安装Jenkins
Jenkins中文官网：

https://www.jenkins.io/zh/

```shell
# 注意检查8080是否已经占用
lsof -i:8080
netstat -nltp|grep 8085
docker run --name jenkins -u root --rm -d -p 8080:8080 -p 50000:50000 -v /var/jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkinsci/blueocean
```

> 访问地址-> http://{部署Jenkins所在服务IP}:8080    http://192.168.238.150:8080

## Jenkins无法访问解决方法-防火墙
```shell
# 在终端输入以下命令，（默认为空）
systemctl status firewalld   #查看防火墙状态
firewall-cmd --list-ports --permanent #查看所有永久开放的端口
# 看一下里面有没有8080，如果没有就没放行
# 添加永久开放的端口
firewall-cmd --add-port=8080/tcp --permanent
# 重启一下防火墙
systemctl restart firewalld
# 端口被占用 可以停掉占用端口的程序，或者换个端口，同样需要在安全组放行
# 查看某个端口被占用  lsof -i:端口号
lsof -i:8080
# 如果有的话就kill对应进程的pid
kill -9 PID
# 关防火墙
service firewalld.service stop
sudo systemctl disable firewalld.service
```
service jenkins start
service jenkins restart