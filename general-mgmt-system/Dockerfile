# Pull base image
FROM 10.19.13.36:5000/tomcat:7.x
MAINTAINER gucl<gucl@asiainfo.com>

#调整jvm内存大小（会覆盖tomcat基础镜像中的jvm内存大小）
RUN sed -i '/\# OS/i JAVA_OPTS="$JAVA_OPTS -server -Xms4096M -Xmx4096M -XX:PermSize=128M -XX:MaxPermSize=256M " '  /opt/tomcat/bin/catalina.sh


# 设置语言环境变量
RUN  yum -y groupinstall "Chinese Support"
RUN  yum -y install kde-l10n-Chinese
RUN  yum -y reinstall glibc-common
RUN  export LANG=zh_CN.utf8  
RUN  echo 'LANG=zh_CN.utf8' > /etc/environment && echo 'LC_ALL=' >> /etc/environment  
RUN  source /etc/environment  
#RUN  localedef -v -c -i zh_CN -f UTF-8 zh_CN.utf8 > /dev/null 2>&1 

# 设置语言环境变量
ENV LANG zh_CN.utf8
ENV LANGUAGE zh_CN:zh
# Install tomcat7
RUN rm -rf /opt/tomcat/webapps/* && mkdir /opt/tomcat/webapps/ROOT
# 此处的uac.war 各中心要根据情况自己修改，
# 如仓库中心的为portal-1.2.7.war
COPY ./build/libs/portal-1.2.7.war /opt/tomcat/webapps/ROOT/ROOT.war
RUN cd /opt/tomcat/webapps/ROOT && jar -xf ROOT.war && rm -rf /opt/tomcat/webapps/ROOT.war

ADD ./script/start-web.sh /start-web.sh
RUN chmod 755 /*.sh

# Define default command.

CMD ["/start-web.sh"]