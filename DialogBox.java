package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogBox extends JFrame implements ActionListener
{
    private JTextField searchField;
    private JTextField replaceField;
    private JLabel searchLabel;
    private JLabel replaceLabel;
    private Container contentPane;
    private JMenuBar mainMenu;
    private JMenuItem okMenuItem;
    private JMenuItem clearMenuItem;
    private JMenu actionMenu;

    private String copyOfInputStream;
    private JTextArea copyOfDisplayArea;


    public DialogBox (String inputStream, JTextArea displayArea)
    {
        setSize (200,50);
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);       
        contentPane = getContentPane ();

        
        mainMenu = new JMenuBar ();
        actionMenu = new JMenu ("action");
        mainMenu.add (actionMenu);
        okMenuItem = new JMenuItem ("ok");
        clearMenuItem = new JMenuItem ("clear");
        okMenuItem.addActionListener(this);
        clearMenuItem.addActionListener(this);

        actionMenu.add (okMenuItem);
        actionMenu.add (clearMenuItem);
        setJMenuBar (mainMenu);
        
        searchLabel = new JLabel ("search for:");
        replaceLabel = new JLabel ("replace with:");
        searchField  = new JTextField (20);
        replaceField = new JTextField (20);

        searchField.setText ("");
        replaceField.setText ("");

        contentPane.setLayout (new FlowLayout ());
        contentPane.add (searchLabel);
        contentPane.add (searchField);
        contentPane.add (replaceLabel);
        contentPane.add (replaceField);
        
        copyOfInputStream = inputStream;
        copyOfDisplayArea = displayArea;
        
        this.setVisible (true);
        
        
        
    }
    
    public void actionPerformed (ActionEvent ex)
    {
        String whichOne = ex.getActionCommand();
        
        if (whichOne.equals ("clear"))
        {
            searchField.setText ("");
            replaceField.setText ("");
        }
        else if (whichOne.equals ("ok"))
        {
            String toSearch = searchField.getText ();
            String toReplace =  replaceField.getText ();
            
            copyOfInputStream = copyOfInputStream.replaceAll(toSearch, toReplace);
            
            copyOfDisplayArea.setText (copyOfInputStream);
            
            
        }
        
        
        
        
    }
    
 



}
