# Pull base image
FROM 10.19.13.18:5000/tomcat:7
MAINTAINER gucl<gucl@asiainfo.com>

# Install tomcat7
RUN rm -rf /opt/apache-tomcat-7.0.72/webapps/* && mkdir /opt/apache-tomcat-7.0.72/webapps/ROOT
# 此处的uac.war 各中心要根据情况自己修改，
# 如仓库中心的为portal-1.2.7.war
COPY ./build/libs/portal-1.2.7.war /opt/apache-tomcat-7.0.72/webapps/ROOT/ROOT.war
RUN cd /opt/apache-tomcat-7.0.72/webapps/ROOT && jar -xf ROOT.war && rm -rf /opt/apache-tomcat-7.0.72/webapps/ROOT.war

ADD ./script/start-web.sh /start-web.sh
RUN chmod 755 /*.sh
ENV         LANG         en_US.UTF-8
# Define default command.
CMD ["/start-web.sh"]