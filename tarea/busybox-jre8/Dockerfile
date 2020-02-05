FROM ofayau/ejre

MAINTAINER Martín Alexis Samán Arata
#80mb

RUN java -version

EXPOSE 3030

COPY demo.jar demo.jar

CMD ["java", "-jar", "demo.jar"]

#chmod +x demo.jar
#docker build -t malditoidealismo/busybox-jre8:0.1 .
#docker run -d -p 3030:3030 malditoidealismo/busybox-jre8:0.1