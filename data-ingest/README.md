data-ingest
===========

Spring Boot app for HDFS ingestion

### Build with:

    ./mvn clean install

### Start Hadoop and Kafka

Follow instructions here [Configuring and starting services needed to run demos](/README.md#configuring-and-starting-services-needed-to-run-demos)

### Run local with:

    export HDFS_URL=<your-hdfs-namenode-uri>
    export KAFKA_HOST=<your-kafka-host>
    java -jar target/data-ingest-0.0.1-kafka.jar --spring.hadoop.fsUri=$HDFS_URI --spring.cloud.stream.kafka.binder.brokers=$KAFKA_HOST:9092 --spring.cloud.stream.kafka.binder.zkNodes=$KAFKA_HOST:2181

