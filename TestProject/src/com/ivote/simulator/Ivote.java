// Programmer: Kulvir Singh Virk
// Date: August12, 2015
// Class: CS356
//-----------------------------------------------------------------------------
package com.ivote.simulator;

import java.util.Hashtable;

public class Ivote implements IvoteService {

	Hashtable<Integer, String> table = new Hashtable<Integer, String>();

	private int[] IDs;
	
	private int noOfSubmition = 0;
	
	public Ivote(int[] IDs) {
		this.IDs = IDs;
	}

	public void answerCount(int answers) {
		
		int A = 0 ,B = 0 ,C = 0 , D = 0;

		for (int a = 0; a < IDs.length; a++) {
			for (int b = 0; b < table.get(IDs[a]).length(); b++){
				if (table.get(IDs[a]).charAt(b) == 'A') {
					A++;
				}
				if (table.get(IDs[a]).charAt(b) == 'B') {
					B++;
				}
				if (table.get(IDs[a]).charAt(b) == 'C') {
					C++;
				}
				if (table.get(IDs[a]).charAt(b) == 'D') {
					D++;
				}
			}
		}
		
		if (answers == 3){
			System.out.println("Total answers: ");
			System.out.println("A: " + A + "\nB: " + B + "\nC: " + C + "\n");
		} 
		
		if (answers == 4){
			System.out.println("Total answers: ");
			System.out.println("A: " + A + "\nB: " + B + "\nC: " + C + "\nD: " + D + "\n");
		} 
	}

	public void displayCorrectAnswer(Question question, int numberOfStudents) {
		int right = 0;
		int wrong = 0;
		for (int a = 0; a < numberOfStudents; a++) {
			if (question.getAnswer().equals(table.get(IDs[a]))) {
				System.out.println("Student" + " " + (a + 1) + ": " + IDs[a] + " is select " + table.get(IDs[a]) + ". Right.\n");
				right++;
			} else {
				System.out.println("Student" + " " + (a + 1) + ": ID " + IDs[a] + " is select " + table.get(IDs[a]) + ". Wrong.\n");
				wrong++;
			}
		}
	
		System.out.println("Total right answers: " + right + "\n");
		System.out.println("Total wrong answers: " + wrong + "\n");
	}

	public void submitedAnswers(Hashtable<Integer, String> studentAnswers) {
		this.table = studentAnswers;
	}

	public void displayQuestion(Question question) {
		System.out.println(question.getQuestion());
	}

	public void countNumberOfSubmition(int number) {
		this.noOfSubmition = number;
	}

	public void displaySubmissions(int ID) {
		if (noOfSubmition == 1){
			System.out.println("Student ID(" + ID + ") is submit answer : " + noOfSubmition + " time.\n");
		} else {
			System.out.println("Student ID(" + ID + ") is submit answer : "  + noOfSubmition + " times.\n");
		}
	}

}
//-----------------------------------------------------------------------------
