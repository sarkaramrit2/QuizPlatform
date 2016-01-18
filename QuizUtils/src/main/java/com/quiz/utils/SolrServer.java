package com.quiz.utils;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;


import com.quiz.enums.SystemProperty;

@SuppressWarnings("deprecation")
public class SolrServer {
	public static HttpSolrServer getSolrServer(SystemProperty property) throws SolrServerException, IOException {
		return new HttpSolrServer(property.getPropertyValue());
	}
}
