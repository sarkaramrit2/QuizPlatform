package com.quiz.utils.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.quiz.enums.SystemProperty;

public class SolrServer {
	public static SolrClient getSolrClientServer(SystemProperty property) throws SolrServerException, IOException {
		CloudSolrClient cloudSolr =  new CloudSolrClient(property.getPropertyValue());
		cloudSolr.setDefaultCollection("quizQuestions");
		return cloudSolr;
	}
	public static SolrClient getSolrServer(SystemProperty property) throws SolrServerException, IOException {
		return new HttpSolrClient(property.getPropertyValue());
	}
}
