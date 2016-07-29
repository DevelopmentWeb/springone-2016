FROM java:8
VOLUME /tmp
ADD ./target/data-ingest-*-kafka.jar /data-ingest.jar
RUN bash -c 'touch /data-ingest.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data-ingest.jar"]
