package com.quiz.indexer.questions.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.quiz.core.dto.AnswerDTO;
import com.quiz.core.dto.QuestionDTO;
import com.quiz.enums.SystemProperty;
import com.quiz.indexer.questions.IQuestionSolrIndexer;
import com.quiz.utils.solr.SolrServer;
import com.quiz.utils.solr.SolrUtils;

@Service("quesSolrIndexer")
public class QuestionSolrIndexerImpl implements IQuestionSolrIndexer {

	@Override
	public int indexQuesInSolr(List<QuestionDTO> questions) throws SolrServerException, IOException {
		SolrClient server = SolrServer.getSolrServer(SystemProperty.SOLR_MASTER_SERVER);
		List<SolrInputDocument> solrDocs = new ArrayList<SolrInputDocument>();
		for (QuestionDTO quesDTO : questions) {
			SolrInputDocument doc = SolrUtils.buildSolrDoc(quesDTO);
			solrDocs.add(doc);
			if (solrDocs.size() == 100) {
				server.add(solrDocs);
				server.commit();
				solrDocs = new ArrayList<SolrInputDocument>();
			}
		}
		server.add(solrDocs);
		server.commit();
		return 0;
	}

	public static void main(String[] args) throws SolrServerException, IOException {
		
		QuestionDTO dto = new QuestionDTO();
		AnswerDTO ansDto = new AnswerDTO();
		ansDto.setAnswer(true);
		ansDto.setAnswerOption("answer1");
		List<AnswerDTO>	answers = new ArrayList<AnswerDTO>();
		answers.add(ansDto);
		answers.add(ansDto);
		dto.setAnswerType("option");
		dto.setAnwsers(answers);
		dto.setCategory("cat1");
		dto.setDifficulyLevel("EASY");
		dto.setLive(true);
		dto.setQuesId("ques3");
		dto.setQuestion("question?");
		dto.setQuestionUrl("ques_url");
		dto.setSubCategory("sub_cat1");
		dto.setSubmittedBy("amrit");
		List<String> hints =  new ArrayList<String>();
		hints.add("hint1"); hints.add("hint2");
		dto.setHints(hints);
		List<QuestionDTO> questions = new ArrayList<QuestionDTO>();
		questions.add(dto);
		new QuestionSolrIndexerImpl().indexQuesInSolr(questions);
	}
}