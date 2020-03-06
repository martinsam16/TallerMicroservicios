FROM alpine

RUN apk update \
	&& apk add openjdk8-jre \
	&& java -version

EXPOSE 3011

COPY target/consumer-0.0.1-SNAPSHOT.jar consumer.jar

CMD ["java", "-jar", "consumer.jar"]
#sudo docker build -t consumer .
#sudo docker run -d --name consumer consumer