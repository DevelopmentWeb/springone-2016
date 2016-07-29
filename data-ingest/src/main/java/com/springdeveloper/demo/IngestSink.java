package com.springdeveloper.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.data.hadoop.store.DataStoreWriter;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(Sink.class)
public class IngestSink {
	
	@Autowired
	private DataStoreWriter<String> writer;

	private long counter = 0;

	@ServiceActivator(inputChannel=Sink.INPUT)
	public void writeData(String payload) {
		System.out.println("*** PROCESSING ... " + ++counter);
		try {
			writer.write(payload);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException("Unable to write to HDFS", e);
		}
	}
	
}
