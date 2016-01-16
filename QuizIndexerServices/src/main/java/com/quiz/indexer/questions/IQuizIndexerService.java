package com.quiz.indexer.questions;

import java.util.List;

import com.quiz.core.dto.QuestionDTO;

public interface IQuizIndexerService {

	public List<QuestionDTO> getQuesByUserId(String userId);
	
	public void saveQuesByUserId(QuestionDTO quesDTO);
	
	public List<QuestionDTO> getAllUnReviewQues();
	
	public List<QuestionDTO> getAllLiveQues();
	
}

