FROM alpine

RUN apk update \
	&& apk add openjdk8-jre \
	&& java -version

EXPOSE 3000

COPY target/producerkafka-0.0.1-SNAPSHOT.jar producerkafka.jar

CMD ["java", "-jar", "producerkafka.jar"]
#sudo docker build -t producerkafka .
#sudo docker run -d --name producerkafka producerkafka