FROM java:8
VOLUME /tmp
ADD ./target/spark-task-*.jar /spark-task.jar
RUN bash -c 'touch /spark-task.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spark-task.jar"]
