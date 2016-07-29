data-ingest
===========

Spring Boot app for HDFS ingestion

### Build with:

    ./mvn clean install

### Start Hadoop and Kafka

Follow instructions here [Configuring and starting services needed to run demos](/README.md#configuring-and-starting-services-needed-to-run-demos)

### Run local with:

    export HDFS_URI=<hdfs-namenode-uri>
    export YARN_HOST=<yarn-rm-host>
    java -jar target/spark-task-0.0.1-SNAPSHOT.jar --spring.hadoop.fs-uri=$HDFS_URI --spring.hadoop.resource-manager-host=$YARN_HOST --spring.hadoop.resource-manager-port=8032 --spring.hadoop.job-history-address=$YARN_HOST:10020 --app-args='/demo/input,/demo/testout'


