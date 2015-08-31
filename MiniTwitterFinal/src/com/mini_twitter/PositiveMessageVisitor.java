// Programmer: Kulvir Singh Virk
// Date: August 27, 2015
// Class: CS356
//-----------------------------------------------------------------------------
package com.mini_twitter;

import java.util.ArrayList;

//Used in the visitor design pattern
public class PositiveMessageVisitor implements Visitor {

	ArrayList<String> positiveMessages = new ArrayList<String>();

	// gets the positive messages from the user
	public void addUser(User u) {

		positiveMessages = u.getPosMessages();
	}

	/**
	 * check msg is positive or not
	 * 
	 * @param news
	 * @return
	 */
	public static boolean checkMsgIsPositiveOrNot(String news) {
		if (news.contains(ConstantMessages.Good) || news.contains(ConstantMessages.Great)
				|| news.contains(ConstantMessages.Excellent))
			return true;
		else
			return false;
	}

}
