1.编译打包
#一定要先clean
gradle clean
#然后再打包
gradle build -x test

2.生成镜像
#在本地生成带私服前缀的镜像  (每次打镜像前版本号要更新)
docker build -t 10.19.13.18:5000/general-mgmt-portal:v1.0 .
#将镜像推送到私服
docker push 10.19.13.18:5000/general-mgmt-portal:v1.0

3. 运行镜像
#--net=host  表示为主机(host)模式  去掉该配置，默认为桥接(bridge)模式
#-e 代表需要设置的环境变量
docker run -d --name general-mgmt-portal  -p 14131:8080  -e "casServerLoginUrl=http://10.19.13.19:14125/login"  -e "casServerUrlPrefix=http://10.19.13.19:14125"   -e "serverName=http://10.19.13.19:14131"   -e "logOutServerUrl=http://10.19.13.19:14125/logout"   -e "logOutBackUrl=http://10.19.13.19:14131"   -e "casServerLoginUrl_Inner=http://10.19.13.19:14125/login"  -e "casServerUrlPrefix_Inner=http://10.19.13.19:14125"   -e "serverName_Inner=http://10.19.13.19:14131"   -e "logOutServerUrl_Inner=http://10.19.13.19:14125/logout"   -e "logOutBackUrl_Inner=http://10.19.13.19:14131/"    -e "innerDomains=changhong.com" -e "SDK_MODE=0" -e "CCS_NAME=aiopt-aiplatform" -e "ZK_ADDR=10.19.13.13:29181" -e "serverContextPath=" -e "ftp_ip =10.1.55.15" -e "ftp_userName =root" -e "ftp_userPwd =root" -e "ftp_port =21" -e "ftp_path =/" -e "jobs.scheduled=0 59 23 ? * *"   10.19.13.18:5000/general-mgmt-portal:v1.0  
#查看镜像启动日志
docker logs general-mgmt-portal
#进入容器，查看镜像内部的情况
docker exec -it general-mgmt-portal /bin/bash
#删除运行的容器
docker rm -fv general-mgmt-portal

#=============更新日志========================#
*2016-09-23
1）初始打包
