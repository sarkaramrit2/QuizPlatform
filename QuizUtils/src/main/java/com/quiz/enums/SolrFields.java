package com.quiz.enums;

public enum SolrFields {

	ID("id"), 
	QUESTION("question"),
	QUES_URL("question_url"),
	ANSWER_TYPE("answer_type"),
	CATEGORY("category"),
	DIFFICULTY_LEVEL("difficulty_level"),
	SUB_CATEGORY("sub_category"),
	SUBMITTED_BY("submitted_by"),
	ANSWER_OPTION("answer_option"),
	HINTS("hints"),
	IS_ANSWER("is_answer"),
	IS_LIVE("is_live"),;

	private String value;

	private SolrFields(String value) {
		this.value = value;
	}

	public String getPropertyValue() {
		return this.value;
	}


}
