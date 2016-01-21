package com.quiz.indexer.scheduler;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IndexScheduler {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring-job-scheduler.xml");
	}
}