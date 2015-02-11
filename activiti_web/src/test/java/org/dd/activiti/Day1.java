package org.dd.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class Day1 {

	@Test
	public void test() throws Exception{
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
/*		configuration.setJdbcDriver("com.mysql.jdbc.Driver");
		configuration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?createDatabaseIfNotExist=true");
		configuration.setJdbcUsername("root");
		configuration.setJdbcPassword("111111");*/
		
		configuration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
		configuration.setJdbcUrl("jdbc:oracle:thin:@192.168.50.193:1521:kaifa");
		configuration.setJdbcUsername("salarydev");
		configuration.setJdbcPassword("salary");
		
		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		ProcessEngine processEngine = configuration.buildProcessEngine();
	}
}
