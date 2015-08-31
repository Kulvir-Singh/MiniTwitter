// Programmer: Kulvir Singh Virk
// Date: August 27, 2015
// Class: CS356
//-----------------------------------------------------------------------------
package com.mini_twitter;

import java.util.ArrayList;

//Used in the Visitor design pattern
public class RegularMessageVisitor implements Visitor {

	ArrayList<String> regularMessages = new ArrayList<String>();

	@Override
	public void addUser(User u) {
		regularMessages = u.getMessages();
	}

}
