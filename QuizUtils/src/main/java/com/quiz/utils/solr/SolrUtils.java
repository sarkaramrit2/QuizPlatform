package com.quiz.utils.solr;

import org.apache.http.client.methods.HttpPost;
import org.apache.solr.common.SolrInputDocument;

import com.quiz.core.dto.AnswerDTO;
import com.quiz.core.dto.QuestionDTO;
import com.quiz.enums.SolrFields;
import com.quiz.enums.SystemProperty;

public class SolrUtils {
	
	public static HttpPost getHttpPost(SystemProperty property){
		return new HttpPost(property.getPropertyValue()+"/solr/update");
	}

	public static SolrInputDocument buildSolrDoc(QuestionDTO quesDTO) {
		SolrInputDocument solrDoc = new SolrInputDocument();
		solrDoc.addField(SolrFields.ID.getPropertyValue(), quesDTO.getQuesId());
		solrDoc.addField(SolrFields.QUESTION.getPropertyValue(), quesDTO.getQuestion());
		solrDoc.addField(SolrFields.QUES_URL.getPropertyValue(), quesDTO.getQuestionUrl());
		solrDoc.addField(SolrFields.ANSWER_TYPE.getPropertyValue(), quesDTO.getAnswerType());
		solrDoc.addField(SolrFields.CATEGORY.getPropertyValue(), quesDTO.getCategory());
		solrDoc.addField(SolrFields.DIFFICULTY_LEVEL.getPropertyValue(), quesDTO.getDifficulyLevel());
		solrDoc.addField(SolrFields.SUB_CATEGORY.getPropertyValue(), quesDTO.getSubCategory());
		solrDoc.addField(SolrFields.SUBMITTED_BY.getPropertyValue(), quesDTO.getSubmittedBy());
		for(AnswerDTO answer:  quesDTO.getAnwsers()){
			solrDoc.addField(SolrFields.ANSWER_OPTION.getPropertyValue(), answer.getAnswerOption());
			solrDoc.addField(SolrFields.IS_ANSWER.getPropertyValue(), answer.isAnswer());
		}
		solrDoc.addField(SolrFields.HINTS.getPropertyValue(), quesDTO.getHints());
		solrDoc.addField(SolrFields.IS_LIVE.getPropertyValue(), true);//MULTI-VALUED
		return solrDoc;
	}
}
