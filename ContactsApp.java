/**
 * @author BrianAguirre
 * Date: 08/29/2013
 * Contact Application which creates files with contacts' info
 * Applies GUI components.
 */


package Assignment1;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class ContactsApp extends JFrame{
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	private JButton [] buttons;
	public static JTextField nameField;
	public static JTextField addressField;
	public static JTextField phoneField;
	public static JTextField emailField;
	public static TextArea textArea;
	private Container contentPane;
	
	public static void main(String[]args){
		ContactsApp mainWindow = new ContactsApp();
		mainWindow.setVisible(true);
	}
	
	public ContactsApp(){
	
	{

		//Dimensions and Layout of App:
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,400);
		
		//Creates and modifies the top panel
		//Adding 5 buttons: Add, Edit, Search, Remove contact:
		topPanel = new JPanel();
		contentPane.add(topPanel,BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout());
		buttons = new JButton[4];
		for (int i=0; i<4; i++){
			if(i==0)
				buttons[i] = new JButton ("Add");
			else if (i==1)
				buttons[i] = new JButton ("Edit");
			else if (i==2)
				buttons[i] = new JButton ("Search");
			else if (i==3)
				buttons[i] = new JButton ("Delete");
			topPanel.add(buttons[i]);
			buttons[i].addActionListener(new Actions());
			
		}
		
		//CREATES MIDDLE PANEL: ADDS TEXT FIELDS:
		//FIRST NAME LAST NAME
		//ADDRESS
		//PHONE NUMBERS
		//EMAIL
		middlePanel = new JPanel();
		contentPane.add(middlePanel,BorderLayout.CENTER);
		middlePanel.setLayout(new FlowLayout());
		//Name:
		nameField= new JTextField("Name:",30);
		nameField.addActionListener(new Actions());
		middlePanel.add(nameField);
		//Address:
		addressField= new JTextField("Address:",30);
		addressField.addActionListener(new Actions());
		middlePanel.add(addressField);
		//Phone Number:
		phoneField= new JTextField("Phone Number:",30);
		phoneField.addActionListener(new Actions());
		middlePanel.add(phoneField);
		//Email:
		emailField= new JTextField("Email:",30);
		emailField.addActionListener(new Actions());
		middlePanel.add(emailField);
		
		
		
		
		//TEXT AREAD: Returns what the user has done (Add, Search Results, Deletes, Edits)
		textArea = new TextArea(10,60);
		textArea.setEditable(false);
		bottomPanel = new JPanel();
		bottomPanel.add(textArea);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
	}
	
	
	}
}
