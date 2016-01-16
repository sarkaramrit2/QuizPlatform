package com.quiz.core.dto;

public class FeedbackDTO {

	private String feedbackId;
	private String submittedBy;
	private String email;
	private String feedback;
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "FeedbackDTO [feedbackId=" + feedbackId + ", submittedBy=" + submittedBy + ", email=" + email
				+ ", feedback=" + feedback + "]";
	}
}
