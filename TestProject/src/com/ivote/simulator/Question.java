// Programmer: Kulvir Singh Virk
// Date: August12, 2015
// Class: CS356

//-----------------------------------------------------------------------------

package com.ivote.simulator;

public class Question {
	
	private String question;
	private String answer;
	
	public Question(String question, String answer){
		this.setQuestion(question);
		this.setAnswer(answer);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
//-----------------------------------------------------------------------------
