// Programmer: Kulvir Singh Virk
// Date: August 27, 2015
// Class: CS356
//-----------------------------------------------------------------------------
package com.mini_twitter;

import java.util.List;

public class AdminService {

	/**
	 * Total tweet counts
	 * 
	 * @param totalTweets
	 * @param users
	 * @param userNames
	 */
	public int totalTweetCount(List<String> userNames, List<User> users, int totalTweets) {
		RegularMessageVisitor rmv = new RegularMessageVisitor();
		for (int i = 0; i < userNames.size(); i++) {
			users.get(i).accept(rmv);
			totalTweets += rmv.regularMessages.size();
		}
		return totalTweets;
	}

	/**
	 * total tweet with positive percentage
	 * 
	 * @param userNames
	 * @param users
	 * @param totalTweets
	 * @param posTweets
	 * @param percPosTweets
	 * @return
	 */
	public int totalTweetWithPositivePercentage(List<String> userNames, List<User> users, int totalTweets,
			int posTweets, int percPosTweets) {

		PositiveMessageVisitor pmv = new PositiveMessageVisitor();
		RegularMessageVisitor rmv = new RegularMessageVisitor();
		for (int i = 0; i < userNames.size(); i++) {
			users.get(i).accept(pmv);
			users.get(i).accept(rmv);
			totalTweets += rmv.regularMessages.size();
			posTweets += pmv.positiveMessages.size();
		}
		if (posTweets != 0 && totalTweets != 0)
			percPosTweets = posTweets / totalTweets;

		return percPosTweets;
	}

	/**
	 * get all group names
	 * 
	 * @param groupNames
	 * @return
	 */
	public String getAllGroupNames(List<String> groupNames) {
		String msg = "Total Groups are :" + groupNames.size();
		for (String grpnm : groupNames) {
			msg = msg + "\n" + grpnm;
		}
		return msg;
	}

	/**
	 * get all usernames
	 */
	public String getAllUserNames(List<String> userNames) {
		String msg = "Total Users are :" + userNames.size();
		for (String usernm : userNames) {
			msg = msg + "\n" + usernm;
		}
		return msg;
	}

}
