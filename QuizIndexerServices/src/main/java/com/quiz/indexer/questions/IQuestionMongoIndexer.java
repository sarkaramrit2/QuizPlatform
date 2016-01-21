package com.quiz.indexer.questions;

import java.util.List;

import com.quiz.core.dto.CategoryDTO;
import com.quiz.core.dto.QuestionDTO;

public interface IQuestionMongoIndexer {

	List<QuestionDTO> getAllQuestions();

	List<QuestionDTO> getAllQuestionsForCategory(String category);

	List<QuestionDTO> getAllQuestionsForSubCategory(String Subcategory);

	List<CategoryDTO> getAllCategories();

	void insertQuestion(QuestionDTO quesDTO);

	void insertAllQuestions(List<QuestionDTO> quesDTOs);

	void insertCategory(CategoryDTO catDTO);
	
	List<QuestionDTO> getQuesByUserId(String user);
	
	void saveQuesByUserId(QuestionDTO dto);
}
