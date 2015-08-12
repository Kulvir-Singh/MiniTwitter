package com.ivote.simulator;

import java.util.ArrayList;
import java.util.Hashtable;

public class SimulationDriver {
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		final int totalStudents = 5;
		
		int count = 0;
		
		for (int a = 0; a < totalStudents; a++) {
			// add student in student list with random Id
			studentList.add(new Student((int) ((Math.random() * 100000))));
		}
		
		int[] studentID = new int[studentList.size()];
		
		for (int a = 0; a < totalStudents; a++) {
			studentID[a] = studentList.get(a).getId();
		}

		Ivote ivote = new Ivote(studentID);
		System.out.println("Welcome to the iVote Simulator.\n");
		
		//Question1
		Question question1 = new Question("1. Does this poll work?\n A: Yes \n B: No \n C: What poll?", "A");
		System.out.println(question1.getQuestion());
		
		int randomNumber = (int) ((Math.random() * 10) + 1);
		
		for (int a = 0; a < totalStudents; a++) {
			while (true){
				if (randomNumber != 0 ){
					ivote.submitedAnswers(random(studentList, totalStudents, question1, 3));
					randomNumber--;
					count++;
				} else {
					ivote.countNumberOfSubmition(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}		
		ivote.displayCorrectAnswer(question1, totalStudents);
		ivote.answerCount(3);
		System.out.println("---------------------------------------------------------------\n");
		
		//Question2
		Question question2 = new Question("2. How are you today?\n A: Great \n B: Not Great \n C: Don't Ask \n", "A");
		System.out.println(question2.getQuestion());
		for (int a = 0; a < totalStudents; a++) {
			while (true){
				if (randomNumber != 0){
					ivote.submitedAnswers(random(studentList, totalStudents, question2, 3));
					randomNumber--;
					count++;
				} else {
					ivote.countNumberOfSubmition(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}		
		ivote.displayCorrectAnswer(question2, totalStudents);
		ivote.answerCount(3);
		System.out.println("---------------------------------------------------------------\n");
		
		//Question3
		Question question3 = new Question("3. What is 1 + 1?\n A: 1 \n B: 2 \n C: 3 \n D: 4", "B");
		System.out.println(question3.getQuestion());
		for (int a = 0; a < totalStudents; a++) {
			while (true){
				if (randomNumber != 0){
					ivote.submitedAnswers(random(studentList, totalStudents, question3, 4));
					randomNumber--;
					count++;
				} else {
					ivote.countNumberOfSubmition(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 20) + 1);
		}		
		ivote.displayCorrectAnswer(question3, totalStudents);
		ivote.answerCount(4);
		System.out.println("---------------------------------------------------------------\n");
		
		//Question4
		Question question4 = new Question("4. Who was the 3rd President of the United States?\n A: John Adams \n B: Thomas Jefferson \n C: Monica Lewinsky \n D: Harry S. Truman", "B");
		System.out.println(question4.getQuestion());
		for (int a = 0; a < totalStudents; a++) {
			while (true){
				if (randomNumber != 0){
					ivote.submitedAnswers(random(studentList, totalStudents, question4, 4));
					randomNumber--;
					count++;
				} else {
					ivote.countNumberOfSubmition(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 20) + 1);
		}		
		ivote.displayCorrectAnswer(question4, totalStudents);
		ivote.answerCount(4);
		System.out.println("---------------------------------------------------------------\n");
		
	}
	
	// generate random answer.
	private static Hashtable<Integer, String> random (ArrayList<Student> studentList, int numberOfStudents, Question question, int numberOfAnswers){
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		
		for (int a = 0; a < numberOfStudents; a++) {
			if (question.getAnswer().length() == 1){
				studentList.get(a).chooseAnswer(numberOfAnswers);
			} else {
				studentList.get(a).chooseMultiple(numberOfAnswers);
			}
		}
		for (int a = 0; a < numberOfStudents; a++) {
			hash.put(studentList.get(a).getId(), studentList.get(a).answer);
		}
		return hash;
	}
	
}
