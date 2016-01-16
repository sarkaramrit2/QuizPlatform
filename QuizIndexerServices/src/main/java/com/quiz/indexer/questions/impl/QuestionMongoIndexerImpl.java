package com.quiz.indexer.questions.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.quiz.core.dto.CategoryDTO;
import com.quiz.core.dto.QuestionDTO;

public class QuestionMongoIndexerImpl {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionMongoIndexerImpl.class);

	@Autowired
	@Qualifier("quizMongo")
	private MongoOperations quizMongo;
	
	public List<QuestionDTO> getAllQuestions(){
		return quizMongo.findAll(QuestionDTO.class);
	}
	
	public List<QuestionDTO> getAllQuestionsForCategory(String category){
		Query q = new Query(Criteria.where("category").is(category));
		return quizMongo.find(q,QuestionDTO.class);
	}

	public List<QuestionDTO> getAllQuestionsForSubCategory(String Subcategory){
		Query q = new Query(Criteria.where("subCategory").is(Subcategory));
		return quizMongo.find(q,QuestionDTO.class);
	}
	
	public List<CategoryDTO> getAllCategories(){
		return quizMongo.findAll(CategoryDTO.class);
	}
	
	public void insertQuestion(QuestionDTO quesDTO){
		LOG.info("Saving question :: "+quesDTO);
		quizMongo.save(quesDTO);
	}
	
	public void insertAllQuestions(List<QuestionDTO> quesDTOs){
		LOG.info("Saving questions :: "+quesDTOs);
		quizMongo.insertAll(quesDTOs);
	}
	
	public void insertCategory(CategoryDTO catDTO){
		LOG.info("Saving category :: "+catDTO);
		quizMongo.save(catDTO);
	}
	
	
	
}
