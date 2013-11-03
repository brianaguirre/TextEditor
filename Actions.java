package Assignment1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Actions implements ActionListener {
	private final static String newline = "\n";
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Content from text fields:
		String name = ContactsApp.nameField.getText();
		String address = ContactsApp.addressField.getText();
		String [] phone = ContactsApp.phoneField.getText().split(" ");
		String email = ContactsApp.emailField.getText();
		
		//NOTIFY USER:
		//ContactsApp.textArea.append(name + newline);
		//ContactsApp.textArea.append(address + newline);
		//for (int i = 0; i<phone.length; i++){
		//	ContactsApp.textArea.append(phone[i] + newline);
		//}
		//ContactsApp.textArea.append(email + newline);
		
		PrintWriter out = null;
		 
		String button = event.getActionCommand();
		
		
			//------------------------------------------------------------------
			//WHEN "ADD" BUTTON IS CLICKED: ADD THE CONTACT INFORMATION OF THE PERSON TO THE FILE:
			//------------------------------------------------------------------
			if (button.equals("Add")){
				//Writes to File:
				//Appends 
				
				try {
				
				    out = new PrintWriter(new BufferedWriter(new FileWriter("ContactList.xml", true)));
			
				    
				    //**********MAKE IT SO THAT IF IT ISN'T EMPTY, IT WILL WRITE IT, IF EMPTY, IT DOESN'T WRITE THE TAG:*********
				 
				    out.println("  <contact>");
				    out.println("    <name>" + name +"</name>");
				    out.println("    <address>" + address + "</address>");
				    for(int i=0;i<phone.length;i++){
				    	out.println("    <phone>" + phone[i] + "</phone>");
				    }
				    out.println("    <email>" + email + "</email>");
				    out.println("  </contact>");
				    
				    //Informs user of the action that was done:
				    ContactsApp.textArea.append(newline);
				    ContactsApp.textArea.append("The following contact was added to file: 'ContactList.xml'" + newline + newline);
				    ContactsApp.textArea.append(name + newline);
					ContactsApp.textArea.append(address + newline);
					for (int i = 0; i<phone.length; i++){
						ContactsApp.textArea.append(phone[i] + newline);
					}
					ContactsApp.textArea.append(email + newline);
					ContactsApp.textArea.append(newline);
				    
				    //Reset to content description:
				    ContactsApp.nameField.setText("Name:");
				    ContactsApp.addressField.setText("Address:");
				    ContactsApp.phoneField.setText("Phone Number:");
				    ContactsApp.emailField.setText("Email:");
				    
				    out.close();
				    
				} catch (IOException e) {
				    e.getMessage();				
				 } 
			}
			
			
			
			//------------------------------------------------------------------
			//WHEN "EDIT" BUTTON IS CLICKED: PULL UP CONTACT INFO AND ASK IF IT SHOULD BE
			//REPLACED OR SIMPLY ADDED TO THE PERSON.
			//OR DELETED:
			//------------------------------------------------------------------
			if(button.equals("Edit")){
				//Edits the contact associated with the given name
			}
			
			
			//------------------------------------------------------------------
			//WHEN "SEARCH" BUTTON IS CLICKED: PULL UP COMPLETE PROFILE OF CONTACT
			//CAN SEARCH BASED ON ALL PARAMETERS, PRINTS TO textArea:
			//------------------------------------------------------------------
			if(button.equals("Search")){
				//searches and prints the contact info for the given contact name.
				//Prints it to the console first: MAKE IT PRINT TO WINDOW:
				BufferedReader bufferedReader = null;
				BufferedReader bufferedReader2 = null;
				StringBuilder stringBuilder = null;
				
				
				//Search by name:
				if(!ContactsApp.nameField.getText().equals("Name:")){
					
					//Reads file, sees if names match, if so, 
					try{
						bufferedReader = new BufferedReader(new FileReader("ContactList.xml")); 
						stringBuilder = new StringBuilder();
				        String line = bufferedReader.readLine();

				        while (line != null) {
				        	if(line.equalsIgnoreCase("    <name>" + ContactsApp.nameField.getText() +"</name>")){
				        		stringBuilder.append(newline);
				            	while (!line.equalsIgnoreCase("  </contact>")){
				            		stringBuilder.append(line);
				            		stringBuilder.append(newline);
				            		line = bufferedReader.readLine();
				            	}
				        	}
				        	line = bufferedReader.readLine();
				        	
				        }
				        	line = bufferedReader.readLine();
				        	
				        	String everything = stringBuilder.toString();
				        	if(everything.length()>0){
				        		ContactsApp.textArea.append(newline);
				        		ContactsApp.textArea.append("Search result:"+newline);
				        		ContactsApp.textArea.append(everything);
				        	}
				        	else{
				        		ContactsApp.textArea.append(newline);
				        		ContactsApp.textArea.append("Your search for: " + "\"" + ContactsApp.nameField.getText() + "\"" + " did not return any results." );
				        		ContactsApp.textArea.append(newline);
				        	}
				        	bufferedReader.close();
				        	
				        	//Reset to content description:
							ContactsApp.nameField.setText("Name:");
						    ContactsApp.addressField.setText("Address:");
						    ContactsApp.phoneField.setText("Phone Number:");
						    ContactsApp.emailField.setText("Email:");
				        
					}
					catch(IOException e){
						e.getMessage();
					}
				}
					
					
				
				//SEARCH BY ADDRESS:
				else if(!ContactsApp.addressField.getText().equals("Address:")){
					
					//Reads file, sees if names match, if so, 
					try{
						bufferedReader = new BufferedReader(new FileReader("ContactList.xml"));
						bufferedReader2 = new BufferedReader(new FileReader("ContactList.xml"));
						stringBuilder = new StringBuilder();
						
				        String line = bufferedReader.readLine();
				        String line2 = bufferedReader2.readLine();
				        
				        int count1 = 0;
				        int count2 = 0;
				       
				        while (line != null) {
				        	count1++;
				        	if(line.equalsIgnoreCase("    <address>" + ContactsApp.addressField.getText() +"</address>")){
				        		stringBuilder.append('\n');
				        		
				        		//FIND OUT THE NAME OF CONTACT:
				        		while(line2 != null){
				        			count2++;
				        			line2 = bufferedReader2.readLine();
				        			if(count2 == count1-2){
				        				stringBuilder.append(line2);
				        				stringBuilder.append('\n');
				        			}
				        		}
				        		
				        		System.out.println(count1);
				            	while (!line.equalsIgnoreCase("  </contact>")){
				            		stringBuilder.append(line);
				            		stringBuilder.append('\n');
				            		line = bufferedReader.readLine();
				            	}
				        	}
				        	line = bufferedReader.readLine();
				        	
				        }
				        	line = bufferedReader.readLine();
				        	String everything = stringBuilder.toString();
				        	if(everything.length()>0){
				        		ContactsApp.textArea.append(newline);
				        		ContactsApp.textArea.append("Search result:"+newline);
				        		ContactsApp.textArea.append(everything);
				        	}
				        	else{
				        		ContactsApp.textArea.append("\n");
				        		ContactsApp.textArea.append("Your search for: " + "\"" + ContactsApp.addressField.getText() + "\"" + " did not return any results." );
				        		ContactsApp.textArea.append("\n");
				        	}
				        	bufferedReader.close();
				        	bufferedReader2.close();
				        	
				        	//Reset to content description:
							ContactsApp.nameField.setText("Name:");
						    ContactsApp.addressField.setText("Address:");
						    ContactsApp.phoneField.setText("Phone Number:");
						    ContactsApp.emailField.setText("Email:");
					}
					
					catch(IOException e){
						e.getMessage();
					}
				}
				
				//SEARCH BY PHONE NUMBER:
				else if (!ContactsApp.phoneField.getText().equals("Phone Number:")){
					
					//Reads file, sees if names match, if so, 
					try{
						bufferedReader = new BufferedReader(new FileReader("ContactList.xml"));
						bufferedReader2 = new BufferedReader(new FileReader("ContactList.xml"));
						stringBuilder = new StringBuilder();
						
				        String line = bufferedReader.readLine();
				        String line2 = bufferedReader2.readLine();
				        
				        int count1 = 0;
				        int count2 = 0;
				       
				        while (line != null) {
				        	count1++;
				        	if(line.equalsIgnoreCase("    <phone>" + ContactsApp.phoneField.getText() +"</phone>")){
				        		stringBuilder.append('\n');
				        		
				        		//FIND OUT THE NAME OF CONTACT:
				        		while(line2 != null){
				        			count2++;
				        			line2 = bufferedReader2.readLine();
				        			if(count2 == count1-3 || count2 == count1-2){
				        				stringBuilder.append(line2);
				        				stringBuilder.append('\n');
				        			}
				        		}
				        		
				        		System.out.println(count1);
				            	while (!line.equalsIgnoreCase("  </contact>")){
				            		stringBuilder.append(line);
				            		stringBuilder.append('\n');
				            		line = bufferedReader.readLine();
				            	}
				        	}
				        	line = bufferedReader.readLine();
				        	
				        }
				        	line = bufferedReader.readLine();
				        	String everything = stringBuilder.toString();
				        	if(everything.length()>0){
				        		ContactsApp.textArea.append(newline);
				        		ContactsApp.textArea.append("Search result:"+newline);
				        		ContactsApp.textArea.append(everything);
				        	}
				        	else{
				        		ContactsApp.textArea.append("\n");
				        		ContactsApp.textArea.append("Your search for: " + "\"" + ContactsApp.phoneField.getText() + "\"" + " did not return any results." );
				        		ContactsApp.textArea.append("\n");
				        	}
				        	bufferedReader.close();
				        	bufferedReader2.close();
				        	
				        	//Reset to content description:
							ContactsApp.nameField.setText("Name:");
						    ContactsApp.addressField.setText("Address:");
						    ContactsApp.phoneField.setText("Phone Number:");
						    ContactsApp.emailField.setText("Email:");
					}
					
					catch(IOException e){
						e.getMessage();
					}
				}
				
				//SEARCH BY EMAIL:
				else if (!ContactsApp.emailField.getText().equals("Email:")){
					
					//Reads file, sees if names match, if so, 
					try{
						bufferedReader = new BufferedReader(new FileReader("ContactList.xml"));
						bufferedReader2 = new BufferedReader(new FileReader("ContactList.xml"));
						stringBuilder = new StringBuilder();
						
				        String line = bufferedReader.readLine();
				        String line2 = bufferedReader2.readLine();
				        
				        int count1 = 0;
				        int count2 = 0;
				       
				        while (line != null) {
				        	count1++;
				        	if(line.equalsIgnoreCase("    <email>" + ContactsApp.emailField.getText() +"</email>")){
				        		stringBuilder.append('\n');
				        		
				        		//FIND OUT THE NAME OF CONTACT:
				        		while(line2 != null){
				        			count2++;
				        			line2 = bufferedReader2.readLine();
				        			if(count2 == count1-4 || count2 == count1-3 || count2 == count1-2){
				        				stringBuilder.append(line2);
				        				stringBuilder.append('\n');
				        			}
				        		}
				        		
				        		System.out.println(count1);
				            	while (!line.equalsIgnoreCase("  </contact>")){
				            		stringBuilder.append(line);
				            		stringBuilder.append('\n');
				            		line = bufferedReader.readLine();
				            	}
				        	}
				        	line = bufferedReader.readLine();
				        	
				        }
				        	line = bufferedReader.readLine();
				        	String everything = stringBuilder.toString();
				        	if(everything.length()>0){
				        		ContactsApp.textArea.append(newline);
				        		ContactsApp.textArea.append("Search result:"+newline);
				        		ContactsApp.textArea.append(everything);
				        	}
				        	else{
				        		ContactsApp.textArea.append("\n");
				        		ContactsApp.textArea.append("Your search for: " + "\"" + ContactsApp.emailField.getText() + "\"" + " did not return any results." );
				        		ContactsApp.textArea.append("\n");
				        	}
				        	bufferedReader.close();
				        	bufferedReader2.close();
				        	
				        	//Reset to content description:
							ContactsApp.nameField.setText("Name:");
						    ContactsApp.addressField.setText("Address:");
						    ContactsApp.phoneField.setText("Phone Number:");
						    ContactsApp.emailField.setText("Email:");
					}
					
					catch(IOException e){
						e.getMessage();
					}
				}
				else{
					ContactsApp.textArea.append("\n");
					ContactsApp.textArea.append("You have not input something to search.");
					ContactsApp.textArea.append("\n");
					ContactsApp.textArea.append("Please enter what to search for in the text bars above.");
					ContactsApp.textArea.append("\n");
					ContactsApp.textArea.append("\n");
				}
			}
			
			
			//------------------------------------------------------------------
			//DELETE BUTTON: If the input is a name, the whole contact is deleted
			//If the input is the address, phone number or email, only that is deleted:
			//------------------------------------------------------------------
			if (button.equals("Delete")){
				
			}
				
			
	}

}
