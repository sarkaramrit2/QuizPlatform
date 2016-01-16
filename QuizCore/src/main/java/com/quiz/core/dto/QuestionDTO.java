package com.quiz.core.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {

	@Indexed
	@Id
	private String quesId;
	private String category;
	private String subCategory;
	private String question;
	private String questionUrl;
	private String answerType;
	private List<AnswerDTO> anwsers = new ArrayList<AnswerDTO>();
	private List<String> hints = new ArrayList<String>();
	private String difficulyLevel;
	private String submittedBy;
	private boolean isLive = false;
	
	public String getQuesId() {
		return quesId;
	}
	public void setQuesId(String quesId) {
		this.quesId = quesId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionUrl() {
		return questionUrl;
	}
	public void setQuestionUrl(String questionUrl) {
		this.questionUrl = questionUrl;
	}
	public String getAnswerType() {
		return answerType;
	}
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
	public List<AnswerDTO> getAnwsers() {
		return anwsers;
	}
	public void setAnwsers(List<AnswerDTO> anwsers) {
		this.anwsers = anwsers;
	}
	public List<String> getHints() {
		return hints;
	}
	public void setHints(List<String> hints) {
		this.hints = hints;
	}
	public String getDifficulyLevel() {
		return difficulyLevel;
	}
	public void setDifficulyLevel(String difficulyLevel) {
		this.difficulyLevel = difficulyLevel;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	@Override
	public String toString() {
		return "QuestionDTO [quesId=" + quesId + ", category=" + category + ", subCategory=" + subCategory
				+ ", question=" + question + ", questionUrl=" + questionUrl + ", answerType=" + answerType
				+ ", anwsers=" + anwsers + ", hints=" + hints + ", difficulyLevel=" + difficulyLevel + ", submittedBy="
				+ submittedBy + ", isLive=" + isLive + "]";
	}
	
}
