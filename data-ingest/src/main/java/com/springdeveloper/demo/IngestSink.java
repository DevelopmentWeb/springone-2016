/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
