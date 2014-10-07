package chatBot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulating Strings
 * 
 * @author James Peck
 * @version 1.2 10/2/2014
 */
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
	 * 
	 * @param name
	 *            the name of the created chatbot
	 */
	public ChatBot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
	}

	/**
	 * give the chatbot's name
	 * 
	 * @return the name of chatbot
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * give the amount of chats that have happened
	 * 
	 * @return amount of chats
	 */
	public int getchatCount()
	{
		return chatCount;
	}

	/**
	 * changes the name of the chatbot
	 * 
	 * @param name
	 *            the name the chatbot is changed to
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	private void fillTheMemeList()
	{
		memeList.add("kitties");
		memeList.add("dog");
		memeList.add("hello world");
		memeList.add("bacon");
		memeList.add("why");
		memeList.add("who are you");
	}

	/**
	 * processes input from the user against the checker methods. Returns the
	 * next output for the view.
	 * 
	 * @param currentInput
	 *            The supplied text.
	 * @return The processed text based on checker or other methods
	 */
	public String processText(String currentInput)
	{
		String result = "";

		if (memeChecker(currentInput))
		{
			result = "wow, " + currentInput + " is a meme. Wahoo!";
		}
		else
		{
			result = "not a meme, try again";
		}

		return result;
	}

	/**
	 * Increases the amount of chats by one
	 */
	private void updateChatCount()
	{
		chatCount++;
	}

	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	private String stringChecker(String input)
	{
		String response = "";
		
		/*Finish*/
		
		return response;
	}

	/**
	 * Checks if quitting is desired and returns it in the form of okToQuit
	 * 
	 * @param input
	 *            user input
	 * @return true or false if quitting is ok
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equalsIgnoreCase("Goodbye"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}
}