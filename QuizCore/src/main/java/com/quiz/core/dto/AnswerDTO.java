package com.quiz.core.dto;

public class AnswerDTO {

	private String answerOption;
	private boolean isAnswer = false;
	public String getAnswerOption() {
		return answerOption;
	}
	public void setAnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}
	public boolean isAnswer() {
		return isAnswer;
	}
	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	@Override
	public String toString() {
		return "AnswerDTO [answerOption=" + answerOption + ", isAnswer=" + isAnswer + "]";
	}
}
