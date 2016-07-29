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

import java.util.Arrays;

import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.store.DataStoreWriter;
import org.springframework.data.hadoop.store.output.TextFileWriter;
import org.springframework.data.hadoop.store.strategy.naming.ChainedFileNamingStrategy;
import org.springframework.data.hadoop.store.strategy.naming.FileNamingStrategy;
import org.springframework.data.hadoop.store.strategy.naming.StaticFileNamingStrategy;
import org.springframework.data.hadoop.store.strategy.naming.UuidFileNamingStrategy;

@Configuration
public class IngestConfiguration {

	@Value("${app.basePath:/tmp/demo}")
	private String basePath;

	@Value("${app.fileName:data}")
	private String fileName;

	@Value("${app.fileExtension:dat}")
	private String fileExtension;

	@Bean
	DataStoreWriter<String> dataStoreWriter(org.apache.hadoop.conf.Configuration hadoopConfiguration) {
		TextFileWriter writer = new TextFileWriter(hadoopConfiguration, new Path(basePath), null);
		ChainedFileNamingStrategy namingStrategy = new ChainedFileNamingStrategy(
				Arrays.asList(new FileNamingStrategy[] {
						new StaticFileNamingStrategy(fileName),
						new UuidFileNamingStrategy(),
						new StaticFileNamingStrategy(fileExtension, ".")}));
		writer.setFileNamingStrategy(namingStrategy);
		return writer;
	}
}
