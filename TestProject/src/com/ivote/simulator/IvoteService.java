// Programmer: Kulvir Singh Virk
// Date: August12, 2015
// Class: CS356
//-----------------------------------------------------------------------------

package com.ivote.simulator;

import java.util.Hashtable;

public interface IvoteService {
	
	public void answerCount(int answers);
	public void displayCorrectAnswer(Question question, int numberOfStudents);
	public void submitedAnswers(Hashtable<Integer, String> table);
	public void displayQuestion(Question question);
	public void countNumberOfSubmition(int number);
	public void displaySubmissions(int ID);
}
//-----------------------------------------------------------------------------
