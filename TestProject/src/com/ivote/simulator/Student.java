// Programmer: Kulvir Singh Virk
// Date: August12, 2015
// Class: CS356
//-----------------------------------------------------------------------------

package com.ivote.simulator;

public class Student {

	private int id;
	protected String answer;
	
	public Student(int id){
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void chooseAnswer(int number){
		this.answer = "" + (char) ((int) (Math.random() * number) + 65);	
	}

	public void chooseMultiple(int number){
		String s = "";
		for (int a = 0; a < number; a++){
			if (headsOrTails()){
				s += (char)(a + 65);
			}
		}
		answer = s;
	}
	
	public boolean headsOrTails(){
		int randomNumber = (int) (Math.random() * 2);
		return randomNumber == 0;
	}
}
//-----------------------------------------------------------------------------
