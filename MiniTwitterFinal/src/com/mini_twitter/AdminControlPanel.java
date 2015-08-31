// Programmer: Kulvir Singh Virk
// Date: August 27, 2015
// Class: CS356
//-----------------------------------------------------------------------------
package com.mini_twitter;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class AdminControlPanel extends JFrame {

	// part of singleton design pattern
	private JPanel contentPane;
	private static final AdminControlPanel instance = new AdminControlPanel();
	private AdminService adminService = new AdminService();
	private JTextField userName;
	private JTextField groupName;
	private JButton btnAddGroup;
	private int totalTweets = 0;
	private List<User> users = new ArrayList<User>();
	private List<String> userNames = new ArrayList<String>();

	private List<String> groupNames = new ArrayList<String>();
	private JTree tree = new JTree();
	private JButton showUserBtn;
	private JButton totalUserBtn;
	private JButton btnTotalGroups;
	private JButton btnNewButton_1;
	private JButton btnPossitiveP;
	private int posTweets = 0;
	private int percPosTweets = 0;

	/**
	 * Create the application.
	 */
	public static AdminControlPanel getInstance() {
		return instance;
	}

	/**
	 * Launch the application.
	 */
	protected void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControlPanel frame = new AdminControlPanel();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminControlPanel() {
		setResizable(false);
		setMinimumSize(new Dimension(400, 400));
		setMaximumSize(new Dimension(400, 400));
		setTitle("Mini Twitter\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Root") {
			{
			}
		}));

		tree.setBounds(10, 11, 135, 340);
		contentPane.add(tree);

		userName = new JTextField();
		userName.setBounds(155, 11, 167, 25);
		contentPane.add(userName);
		userName.setColumns(10);

		JButton btnAddUser = new JButton(ConstantMessages.AddUser);
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (userName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, ConstantMessages.UsernameNotEmpty, "", 0, null);
				} else {
					User nUser = new User(userName.getText(), new Random().nextInt(5));
					users.add(nUser);
					DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					DefaultMutableTreeNode newUser = new DefaultMutableTreeNode(userName.getText());

					if (userNames.contains(userName.getText())) {
						JOptionPane.showMessageDialog(null, ConstantMessages.UsernameAlreadyExist, "", 0, null);
					} else {
						if (selectedNode != null) {
							if (!userName.getText().trim().equals("")) {
								model.insertNodeInto(newUser, selectedNode, selectedNode.getChildCount());
								model.reload();
							}
						} else {
							selectedNode = (DefaultMutableTreeNode) model.getRoot();
							if (!userName.getText().trim().equals("")) {
								model.insertNodeInto(newUser, selectedNode, selectedNode.getChildCount());
								model.reload();
							}
						}
					}
					userNames.add(userName.getText());
				}
			}
		});
		btnAddUser.setBounds(347, 8, 137, 23);
		contentPane.add(btnAddUser);

		groupName = new JTextField();
		groupName.setBounds(155, 64, 167, 25);
		contentPane.add(groupName);
		groupName.setColumns(10);

		btnAddGroup = new JButton(ConstantMessages.AddGroup);
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (groupNames.contains(groupName.getText())) {
					JOptionPane.showMessageDialog(null, ConstantMessages.GroupAlreadyExist, "", 0, null);
				} else {
					DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
					DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
					model.insertNodeInto(new DefaultMutableTreeNode(groupName.getText()), root, root.getChildCount());
				}
				groupNames.add(groupName.getText());
			}
		});
		btnAddGroup.setBounds(347, 64, 137, 23);
		contentPane.add(btnAddGroup);

		showUserBtn = new JButton(ConstantMessages.ShowUser);
		showUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String username = "";
				if (selectedNode != null) {
					username = selectedNode.getUserObject().toString();
					User selectedUser = users.get(0);
					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getId().equals(selectedNode.toString()))
							selectedUser = users.get(i);
					}
					selectedUser.setVisible(true);
				}

				if (!userNames.contains(username)) {
					JOptionPane.showMessageDialog(null, ConstantMessages.SelectUsername, "", 0, null);
				}

			}
		});
		showUserBtn.setBounds(155, 130, 327, 40);
		contentPane.add(showUserBtn);

		totalUserBtn = new JButton(ConstantMessages.TotalUsers);
		totalUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = adminService.getAllUserNames(userNames);
				JOptionPane.showMessageDialog(null, message, "", 1, null);
			}
		});
		totalUserBtn.setBounds(155, 208, 167, 51);
		contentPane.add(totalUserBtn);

		btnTotalGroups = new JButton(ConstantMessages.TotalGroups);
		btnTotalGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = adminService.getAllGroupNames(groupNames);
				JOptionPane.showMessageDialog(null, message, "", 1, null);
			}
		});
		btnTotalGroups.setBounds(332, 208, 152, 51);
		contentPane.add(btnTotalGroups);

		btnNewButton_1 = new JButton(ConstantMessages.TotalMessages);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalTweets = adminService.totalTweetCount(userNames, users, totalTweets);
				JOptionPane.showMessageDialog(null, "Total messages :- " + totalTweets, "", 1, null);
				totalTweets = 0;
			}
		});
		btnNewButton_1.setBounds(155, 290, 167, 51);
		contentPane.add(btnNewButton_1);

		btnPossitiveP = new JButton(ConstantMessages.PositivePercentage);
		btnPossitiveP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				percPosTweets = adminService.totalTweetWithPositivePercentage(userNames, users, totalTweets, posTweets,
						percPosTweets);
				JOptionPane.showMessageDialog(null, "Positive Percentage messages :- " + percPosTweets * 100 + " %", "",
						1, null);
				totalTweets = 0;
				posTweets = 0;
			}
		});
		btnPossitiveP.setBounds(332, 290, 152, 51);
		contentPane.add(btnPossitiveP);
	}
}
