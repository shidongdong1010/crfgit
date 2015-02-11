package org.dd.activiti;

import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class Day2 {

	@Test
	public void test() throws Exception{
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();

	}
	
	// 创建发布流程
	@Test
	public void deployFlow() throws Exception{
		// 加载流程核心
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取资源库服务
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 构建发对象
		DeploymentBuilder builder = repositoryService.createDeployment();
		builder.addClasspathResource("leave.bpmn").addClasspathResource("leave.png");
		// 发布
		builder.deploy();
	}
	
	// 启动任务
	@Test
	public void startFlow() throws Exception{
		// 加载流程核心
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到运行时服务
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 启动任务
		runtimeService.startProcessInstanceByKey("myProcess");
	}
	
	// 查询任务
	@Test
	public void queryTask() throws Exception {
		// 加载流程核心
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到任务服务
		TaskService taskService = processEngine.getTaskService();
		// 查询条件
		String userId = "张三";
		// 得到查询对象
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).list();
		for (Task task : tasks) {
			System.out.println("id:" + task.getId() + ", name:" + task.getName() + ", assignee:" + task.getAssignee() + ", createTime:" + task.getCreateTime());
		}
		System.out.println("-----------------");
		// 查询条件
		String userId2 = "李四";
		// 得到查询对象
		List<Task> tasks2 = taskService.createTaskQuery().taskAssignee(userId2).list();
		for (Task task : tasks2) {
			System.out.println("id:" + task.getId() + ", name:" + task.getName() + ", assignee:" + task.getAssignee() + ", createTime:" + task.getCreateTime());
		}
	}
	
	// 办理任务
	@Test
	public void completeTask() throws Exception {
		// 加载流程核心
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到任务服务
		TaskService taskService = processEngine.getTaskService();
		// 办理任务
		String taskId = "202";
		taskService.complete(taskId);
	}
}
