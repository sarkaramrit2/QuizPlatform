package com.quiz.indexer.scheduler;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.quiz.indexer.questions.IQuizIndexerService;

public class JobScheduler extends QuartzJobBean {
	
	@Autowired
	private IQuizIndexerService quesService;
	
	private static final Logger LOG = LoggerFactory.getLogger(JobScheduler.class);

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		try {
			quesService.indexQuesInSolr(quesService.getAllQuestionsFromMongo());
		} catch (IOException e) {
			LOG.error("Error while indexing",e);
		} catch (SolrServerException e) {
			LOG.error("Error while indexing",e);
		}
	}
}
