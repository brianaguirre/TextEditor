package Assignment1;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SecondGUI extends JFrame implements ActionListener
{
    public JMenuBar mainMenu;
    public JMenu fileMenu;
    public JMenuItem searchMenuItem;
    public JMenuItem openItem;
    public JMenuItem saveItem;
    public JMenuItem exitItem;
    public JMenuItem miscItem;
    public JMenuItem aItem;
    public JMenuItem bItem;
    public JMenuItem cItem;
    public Container contentPane;
    String inputStream;

    JTextArea displayArea;
    JScrollPane scrollPane;
    SecondGUI copyOfMainWindow;

    public static void main (String [ ]args)
    {
      SecondGUI mainWindow = new SecondGUI ();
      mainWindow.setVisible (true);

    }

    public SecondGUI ()
    {
        setSize (400,600);
        contentPane = getContentPane ( );
        setDefaultCloseOperation (EXIT_ON_CLOSE);

        mainMenu = new JMenuBar ();
        fileMenu = new JMenu ("file");
        searchMenuItem = new JMenuItem ("search");
        searchMenuItem.addActionListener(this);

        mainMenu.add (fileMenu);


        openItem = new JMenuItem ("open");
        openItem.addActionListener(this);
        saveItem = new JMenuItem ("save");
        exitItem = new JMenuItem ("exit");

        miscItem = new JMenu ("misc");
        aItem = new JMenuItem ("a");
        bItem = new JMenuItem ("b");
        cItem = new JMenuItem ("c");
        miscItem.add (aItem);
        miscItem.add (bItem);
        miscItem.add (cItem);

        fileMenu.add (openItem);
        fileMenu.add (saveItem);
        fileMenu.add (searchMenuItem);
        fileMenu.add (exitItem);
        fileMenu.add (miscItem);

        setJMenuBar (mainMenu);

        displayArea = new JTextArea ("",40,50);
        scrollPane = new JScrollPane (displayArea);
        contentPane.add (scrollPane); //default: FlowLayout



    }

    public void actionPerformed (ActionEvent ex)
    {
        String whichOne = ex.getActionCommand();
        if (whichOne.equals ("open"))
            openAndDisplay ();
        else if (whichOne.equals ("search"))
            searchAndReplace ();





    }

    public void searchAndReplace ()
    {

        DialogBox a = new DialogBox (inputStream, displayArea);



    }

    public void openAndDisplay ()
    {
        File aFile = null;
        JFileChooser fileChooser = new JFileChooser ( );
	if (fileChooser.showOpenDialog (null) == JFileChooser.APPROVE_OPTION)
		aFile = fileChooser.getSelectedFile ( );

        Scanner inFile = null;
        boolean fileOK = false;

        try
        {
            inFile = new Scanner (aFile);
            fileOK = true;
        }
        catch (FileNotFoundException ex)
        {
            inputStream = "";
        }

        if (fileOK)
        {
            while (inFile.hasNext ( ))
		inputStream += (inFile.nextLine ( ) + "\n");

        }

        displayArea.setText (inputStream);
        inFile.close ();

    }


}
