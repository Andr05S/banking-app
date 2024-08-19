package bankingapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewUserMenu extends JFrame {
	static void menuNewUser() {
		try {
			
			 JFrame frame = new JFrame();
			 JPanel pane = new JPanel(new FlowLayout());
			 pane.setPreferredSize(new Dimension(500,500));
			 pane.setBackground(Color.WHITE);
			 pane.setOpaque(true);
			 frame.getContentPane().add(pane, BorderLayout.CENTER);
			   JLabel label1 = new JLabel("Please create your username and password");
			   JButton createButton = new JButton("create");
			   JButton exitButton = new JButton("Cancel");
			   pane.add(label1);
			   createButton.setFocusable(false);
			   
			   exitButton.setFocusable(false);
			   createButton.setPreferredSize(new Dimension(100,100));
			   
			   exitButton.setPreferredSize(new Dimension(100,100));
			   JTextField userField = new JTextField(10);
			   JTextField passwordField = new JTextField(10);
			   pane.add(createButton);
			   pane.add(exitButton);
			   pane.add(userField, BorderLayout.SOUTH);
			   pane.add(passwordField, BorderLayout.SOUTH);
			   createButton.addActionListener(e -> {
					try {
						newUser.newUserCreator(userField.getText(), passwordField.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}});
			   exitButton.addActionListener(e -> frame.dispose());
			   frame.getRootPane().setDefaultButton(createButton);
			   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   frame.setLocationRelativeTo(null);
			   frame.pack();
			   frame.setVisible(true);
			   
			   
			
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
