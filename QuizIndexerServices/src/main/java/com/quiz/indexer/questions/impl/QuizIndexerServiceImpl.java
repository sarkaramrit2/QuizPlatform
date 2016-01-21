package com.quiz.indexer.questions.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.core.dto.QuestionDTO;
import com.quiz.indexer.questions.IQuestionMongoIndexer;
import com.quiz.indexer.questions.IQuestionSolrIndexer;
import com.quiz.indexer.questions.IQuizIndexerService;

@Service("quizIndexerService")
public class QuizIndexerServiceImpl implements IQuizIndexerService{

	@Autowired
	private IQuestionMongoIndexer quesMongoIndexer;
	
	@Autowired
	private IQuestionSolrIndexer quesSolrIndexer;

	@Override
	public List<QuestionDTO> getAllQuestionsFromMongo() {
		return quesMongoIndexer.getAllQuestions();
	}

	@Override
	public void indexQuesInSolr(List<QuestionDTO> quesDTOs) throws IOException, SolrServerException {
		quesSolrIndexer.indexQuesInSolr(quesDTOs);
	}

	@Override
	public List<QuestionDTO> getQuesByUserId(String userId) {
		return quesMongoIndexer.getQuesByUserId(userId);
	}

	@Override
	public void saveQuesByUserId(QuestionDTO dto) {		
		quesMongoIndexer.saveQuesByUserId(dto);
	}
}
