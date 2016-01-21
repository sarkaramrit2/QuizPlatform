package com.quiz.indexer.questions;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.quiz.core.dto.QuestionDTO;

public interface IQuizIndexerService {
	
	List<QuestionDTO> getAllQuestionsFromMongo();
	void indexQuesInSolr(List<QuestionDTO> quesDTOs) throws IOException, SolrServerException;
	List<QuestionDTO> getQuesByUserId(String userId);
	void saveQuesByUserId(QuestionDTO dto);
}

