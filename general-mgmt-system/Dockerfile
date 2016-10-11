# Pull base image
FROM 10.19.13.18:5000/tomcat:7
MAINTAINER gucl<gucl@asiainfo.com>
# 设置语言环境变量
RUN  yum -y groupinstall "Chinese Support"
RUN  export LANG=zh_CN.UTF-8  
RUN  echo 'LANG=zh_CN.UTF-8' > /etc/environment && echo 'LC_ALL=' >> /etc/environment  
RUN  source /etc/environment  
#RUN  localedef -v -c -i zh_CN -f UTF-8 zh_CN.UTF-8 > /dev/null 2>&1 

# 设置语言环境变量
ENV LANG zh_CN.UTF-8
ENV LANGUAGE zh_CN:zh
# Install tomcat7
RUN rm -rf /opt/apache-tomcat-7.0.72/webapps/* && mkdir /opt/apache-tomcat-7.0.72/webapps/ROOT
# 此处的uac.war 各中心要根据情况自己修改，
# 如仓库中心的为portal-1.2.7.war
COPY ./build/libs/portal-1.2.7.war /opt/apache-tomcat-7.0.72/webapps/ROOT/ROOT.war
RUN cd /opt/apache-tomcat-7.0.72/webapps/ROOT && jar -xf ROOT.war && rm -rf /opt/apache-tomcat-7.0.72/webapps/ROOT.war

ADD ./script/start-web.sh /start-web.sh
RUN chmod 755 /*.sh

# Define default command.
CMD ["/start-web.sh"]