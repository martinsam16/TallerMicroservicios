FROM alpine

RUN apk update \
	&& apk add openjdk8-jre \
	&& java -version

EXPOSE 3011

COPY target/cassandra-0.0.1-SNAPSHOT.jar cassandra.jar

CMD ["java", "-jar", "cassandra.jar"]
#sudo docker build -t cassandra .
#sudo docker run -d --name cassandra cassandra