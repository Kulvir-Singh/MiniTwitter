// Programmer: Kulvir Singh Virk
// Date: August 27, 2015
// Class: CS356
//-----------------------------------------------------------------------------
package com.mini_twitter;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

@SuppressWarnings({ "rawtypes", "serial", "unused", "unchecked" })
public class User extends javax.swing.JFrame implements Node {

	// singleton pattern
	// these objects are created only once.
	private DefaultListModel listModel1;
	private DefaultListModel listModel2;
	private String id;
	private ArrayList<User> followers = new ArrayList<User>();
	private ArrayList<User> followings = new ArrayList<User>();
	private ArrayList<String> newsFeedMessages = new ArrayList<String>();
	private ArrayList<String> positiveMessages = new ArrayList<String>();
	private long creationTime;
	private long lastUpdateTime;

	// Constructor takes in the id and the creation time of the user
	// sets the label at the bottom of the UI to show the creation time
	public User(String id, long creationTime) {
		initComponents();
		this.listModel1 = new DefaultListModel();
		this.listModel2 = new DefaultListModel();
		this.currentFollowing.setModel(listModel1);
		this.newsFeed.setModel(listModel2);
		this.listModel1.addElement(ConstantMessages.Following);
		this.listModel2.addElement(ConstantMessages.NewsFeed);
		this.id = id;
	}

	public long getUpdateTime() {
		return lastUpdateTime;
	}

	public long getTime() {
		return creationTime;
	}

	// Returns user ID
	public String getId() {
		return id;
	}

	// Sets user ID
	public void setId(String id) {
		this.id = id;
	}

	// Gets the total messages from user
	public ArrayList<String> getMessages() {
		return newsFeedMessages;
	}

	// Gets the positive messages from the user
	public ArrayList<String> getPosMessages() {
		return positiveMessages;
	}

	// method used as part of the visitor design pattern
	public void accept(Visitor vis) {
		vis.addUser(this);
	}

	private void initComponents() {

		followUser = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		currentFollowing = new javax.swing.JList();
		postTweet = new javax.swing.JButton();
		jScrollPane4 = new javax.swing.JScrollPane();
		newsFeed = new javax.swing.JList();
		userId = new javax.swing.JTextField();
		tweetMessage = new javax.swing.JTextField();
		cTime = new javax.swing.JLabel();
		lUTime = new javax.swing.JLabel();

		followUser.setText(ConstantMessages.FollowUser);
		followUser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				followUserActionPerformed(evt);
			}
		});

		currentFollowing.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { ConstantMessages.CurrentFollowing };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane2.setViewportView(currentFollowing);

		postTweet.setText(ConstantMessages.PostTweet);
		postTweet.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				postTweetActionPerformed(evt);
			}
		});

		newsFeed.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { ConstantMessages.NewsFeed };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane4.setViewportView(newsFeed);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane4).addComponent(jScrollPane2)
						.addGroup(layout.createSequentialGroup()
								.addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(followUser, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(tweetMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(postTweet, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(cTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lUTime, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(followUser).addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(postTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(tweetMessage, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lUTime).addGap(18, 18, 18)
				.addComponent(cTime)));

		pack();
	}// </editor-fold>

	// use of factory pattern
	// This method follows users by their given ID
	@Override
	public void followUserActionPerformed(java.awt.event.ActionEvent evt) {
		String follow = this.userId.getText();
		this.listModel1.addElement(follow);
	}

	// use of factory pattern
	@Override
	public void postTweetActionPerformed(java.awt.event.ActionEvent evt) {
		// This method posts tweets
		String news = this.tweetMessage.getText();
		newsFeedMessages.add(news);

		boolean isPositive = PositiveMessageVisitor.checkMsgIsPositiveOrNot(news);

		if (isPositive)
			positiveMessages.add(news);

		this.listModel2.addElement(news);

		// Whenever a new element is added to the list of news
		// The time is taken and printed to the bottom of the UI
		lastUpdateTime = System.currentTimeMillis();
		lUTime.setText("Last update: " + String.valueOf(lastUpdateTime));
	}

	// Variables declaration
	private javax.swing.JLabel cTime;
	private javax.swing.JList currentFollowing;
	private javax.swing.JButton followUser;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JLabel lUTime;
	private javax.swing.JList newsFeed;
	private javax.swing.JButton postTweet;
	private javax.swing.JTextField tweetMessage;
	private javax.swing.JTextField userId;
	// End of variables declaration
}
