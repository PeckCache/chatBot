package chatBot.model;

import java.util.ArrayList;

public class ChatBot
{
	private ArrayList<String> memeList;
	/**
	 * name of the chatbot
	 */
	private String name;
	/**
	 * amount of chats that have happened this session
	 */
	private int chatCount;

	/**
	 * creates a chatbot and sets the amount of chats to zero
	 * @param name the name of the created chatbot
	 */
	public ChatBot(String name)
	{
		this.name = name;
		chatCount = 0;
	}

	/**
	 *give the chatbot's name
	 * @return the name of chatbot
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * give the amount of chats that have happened
	 * @return amount of chats
	 */
	public int getchatCount()
	{
		return chatCount;
	}

	/**
	 * changes the name of the chatbot
	 * @param name the name the chatbot is changed to
	 */
	public void setName(String name)
	{
		this.name = name;
	} 

	/**
	 * Increases the amount of chats by one
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	/**
	 * Checks if quitting is desired and returns it in the form of okToQuit
	 * @param input user input
	 * @return true or false if quitting is ok
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input.equalsIgnoreCase("Goodbye"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}