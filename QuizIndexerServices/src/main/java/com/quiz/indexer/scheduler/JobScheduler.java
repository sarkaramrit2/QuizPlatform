package com.quiz.indexer.scheduler;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.quiz.indexer.questions.IQuizIndexerService;

public class JobScheduler extends QuartzJobBean {
	
	@Autowired
	private IQuizIndexerService quesService;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		try {
			quesService.indexQuesInSolr(quesService.getAllQuestionsFromMongo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
