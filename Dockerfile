FROM tomcat:9-jdk11-openjdk
MAINTAINER Goose From Rome <sanchoskorch765@gmail.com>
ADD target/aurosks.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]