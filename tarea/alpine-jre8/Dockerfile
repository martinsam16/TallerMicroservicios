FROM alpine

MAINTAINER Martín Alexis Samán Arata

EXPOSE 3030

RUN apk add --no-cache ca-certificates openjdk8-jre-base bash

COPY demo.jar demo.jar

CMD ["java", "-jar", "demo.jar"]

#chmod +x demo.jar
#docker build -t malditoidealismo/alpine-jre8:0.1 .
#docker run -d -p 3030:3030 malditoidealismo/alpine-jre8:0.1