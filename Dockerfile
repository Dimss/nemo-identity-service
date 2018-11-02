FROM openjdk
ARG VERSION
RUN mkdir /app
COPY target/identity-${VERSION}.jar /app
RUN mv /app/identity-${VERSION}.jar /app/identity-SNAPSHOT.jar
CMD java -jar /app/identity-SNAPSHOT.jar