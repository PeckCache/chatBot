package chatBot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulating Strings
 * 
 * @author James Peck
 * @version 1.4 10/9/2014
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
	private ChatBotUser myUser;
	private ArrayList<String> userInputList;

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
		myUser = new ChatBotUser();
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
	public int getChatCount()
	{
		return chatCount;
	}

	public ChatBotUser getMyUser()
	{
		return myUser;
	}

	public void setMyUser(ChatBotUser myUser)
	{
		this.myUser = myUser;
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

		if (getChatCount() < 7)
		{
			introduceUser(currentInput);
		}

		int randomPosition = (int) (Math.random() * 7);
		if (currentInput != null)
		{
			if (randomPosition == 0)
			{
				// stringChecker
				if (stringChecker(currentInput))
				{
					result = "Slow down!!!!";
				}
				else
				{
					result = "Stop talking so slow!";
				}
			}
			else if (randomPosition == 1)
			{
				// content checker
				if (contentChecker(currentInput))
				{
					result = "yep thats my name, don't wear it out.";
				}
				else
				{
					result = "who are you taking to?";
				}
			}
			else if (randomPosition == 2)
			{
				if (memeChecker(currentInput))
				{
					result = "wow, " + currentInput + " is a meme. Wahoo!";
				}
				else
				{
					result = "Wait, sorry what?";
				}
			}
			else if (randomPosition == 3)
			{
				// talk about the user here
			}
			else if (randomPosition == 4)
			{
				// add to our list
				userInputList.add(currentInput);
			}
			else if (randomPosition == 5)
			{
				if (mashChecker(currentInput))
				{
					result = mashingDetected(currentInput);
				}
				else
				{
					result = noMashing(currentInput);
				}
			}
			else
			{
				// list checker and removal
			}
		}
		else
		{
			result = "so are you going to talk soon?";
			chatCount--;
		}
		updateChatCount();
		return result;
	}

	private boolean listChecker(String userInput)
	{
		boolean matchesInput = false;

		for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if (userInput.equalsIgnoreCase(userInputList.get(loopCount)))
				;
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}

		return matchesInput;
	}

	/**
	 * Increases the amount of chats by one every time it is called
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

	private boolean stringChecker(String input)

	{
		boolean response = false;

		if (input.length() >= 20)
		{
			response = true;
		}

		return response;
	}

	private boolean contentChecker(String input)
	{
		boolean result = false;

		if (input.contains(name))
		{
			result = true;
		}

		return result;
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

	/**
	 * Checker for keyboard mashing
	 * 
	 * @param input
	 *            The supplied text, normally a user input
	 * @return Whether mashing has been found
	 */
	private boolean mashChecker(String input)
	{
		boolean isMashing = false;

		if (input.indexOf("jhg") < -1)
		{
			isMashing = true;
		}

		return isMashing;
	}

	private String mashingDetected(String input)
	{
		String mashed = "";

		mashed = input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);

		return mashed;
	}

	private String noMashing(String input)
	{
		String noMashing = "Thank you for typing..";
		if (input.length() > 2)
		{
			noMashing += input.substring(input.length() / 3, input.length() / 2);
		}
		return noMashing;
	}

	private String introduceUser(String input)
	{
		String output = "";
		if (getChatCount() == 0)
		{
			myUser.setUserName(input);
			output = myUser.getUserName() + " is a good name!     How old are you?";
		}
		else if (getChatCount() == 1)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
			output = myUser.getAge() + " is much older than i am.  hey are you one of those persons";
		}
		else if (getChatCount() == 2)
		{
			Boolean isPerson = false;
			if (input.contains("yes") || input.contains("Yes") || Boolean.parseBoolean(input))
			{
				isPerson = true;
			}
			myUser.setPerson(isPerson);
			output = "ok noted";
		}
		return output;
	}
}