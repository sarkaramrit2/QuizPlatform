package com.quiz.indexer.questions.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.quiz.core.dto.CategoryDTO;
import com.quiz.core.dto.QuestionDTO;
import com.quiz.indexer.questions.IQuestionMongoIndexer;

@Service("quesMongoIndexer")
public class QuestionMongoIndexerImpl implements IQuestionMongoIndexer{

	private static final Logger LOG = LoggerFactory.getLogger(QuestionMongoIndexerImpl.class);

	@Autowired
	@Qualifier("quizMongo")
	private MongoOperations quizMongo;
	
	@Override
	public List<QuestionDTO> getAllQuestions(){
		return quizMongo.findAll(QuestionDTO.class);
	}
	
	@Override
	public List<QuestionDTO> getAllQuestionsForCategory(String category){
		Query q = new Query(Criteria.where("category").is(category));
		return quizMongo.find(q,QuestionDTO.class);
	}

	@Override
	public List<QuestionDTO> getAllQuestionsForSubCategory(String Subcategory){
		Query q = new Query(Criteria.where("subCategory").is(Subcategory));
		return quizMongo.find(q,QuestionDTO.class);
	}
	
	@Override
	public List<CategoryDTO> getAllCategories(){
		return quizMongo.findAll(CategoryDTO.class);
	}
	
	@Override
	public void insertQuestion(QuestionDTO quesDTO){
		LOG.info("Saving question :: "+quesDTO);
		quizMongo.save(quesDTO);
	}
	
	@Override
	public void insertAllQuestions(List<QuestionDTO> quesDTOs){
		LOG.info("Saving questions :: "+quesDTOs);
		quizMongo.insertAll(quesDTOs);
	}
	
	@Override
	public void insertCategory(CategoryDTO catDTO){
		LOG.info("Saving category :: "+catDTO);
		quizMongo.save(catDTO);
	}

	@Override
	public List<QuestionDTO> getQuesByUserId(String user) {
		Query q = new Query(Criteria.where("submiited_by").is(user));
		return quizMongo.find(q,QuestionDTO.class);
	}

	@Override
	public void saveQuesByUserId(QuestionDTO dto) {
		LOG.info("Save Question :: "+dto);
		quizMongo.save(dto);
	}
	
}
