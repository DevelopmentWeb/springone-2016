package com.springdeveloper.demo;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.yarn.test.context.MiniYarnCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SparkTaskApplication.class)
@MiniYarnCluster(configName="yarnConfiguration", clusterName="yarnCluster", nodes=1, id="default")
@IntegrationTest({"app-jar=hdfs:///app/spark/spark-hashtags_2.10-0.1.0.jar",
		"app-class=Hashtags",
		"app-name=test",
		"sparkAssemblyJar=hdfs:///app/spark/spark-assembly-1.6.2-hadoop2.6.0.jar"})
public class SparkTaskApplicationTests {

	@Test
	public void contextLoads() {
	}

}
