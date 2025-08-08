package classes1;

import java.util.Scanner;
public class chat_bot {
	    void respond(String message) {
	    	
	        if (message.equalsIgnoreCase("hi") || message.equalsIgnoreCase("hello")) {
	            System.out.println("Bot: Hello! How can I help you?");
	        } else if (message.equalsIgnoreCase("bye")) {
	            System.out.println("Bot: Goodbye! Have a nice day!");
	        } else if (message.equalsIgnoreCase("how are you")) {
	            System.out.println("Bot: I'm just a bot, but I'm doing great!");
	        } else {
	            System.out.println("Bot: Sorry, I didn't understand that.");
	            
	        }}
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        chat_bot bot = new chat_bot();
	        System.out.println("You can type: hi, hello, how are you, bye");
	        System.out.print("You: ");
	        String userInput = sc.nextLine();
	        bot.respond(userInput);
	        sc.close();
	        
	    }}
