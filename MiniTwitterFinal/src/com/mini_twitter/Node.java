// Programmer: Kulvir Singh Virk
// Date: August 27, 2015
// Class: CS356
//-----------------------------------------------------------------------------
package com.mini_twitter;

import java.awt.event.ActionEvent;

//Node used in the visitor pattern
public interface Node {

	public void accept(Visitor vis);

	public void followUserActionPerformed(ActionEvent evt);

	public void postTweetActionPerformed(ActionEvent evt);
}
