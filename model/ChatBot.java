package chatBot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulating Strings
 * 
 * @author James Peck
 * @version 1.5 10/9/2014
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
	 * next result for the view.
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
			result = introduceUser(currentInput);
		}
		else
		{
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
				result = userTopic(currentInput);
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
				if (listChecker(currentInput))
				{
					result = "how nice, now we don't have to talk about that again";
				}
				else
				{
					result = "Why are you bring something new up? oh well lets talk about it";
				}
			}
		}
		else
		{
			result = "so are you going to talk soon?";
			chatCount--;
		}
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
	
	private String userTopic(String userInput)
	{
		String userBackTalk = "";
		
		int randomUserTopic = (int) (Math.random() * 6);
		
		switch (randomUserTopic)
		{
		case 1:
				userBackTalk = myUser.getUserName() + "is a really old name";
				break;
		case 2:
				userBackTalk = myUser.getAge() + "is a way long time to live";
				break;
		default:
				if (myUser.CanThink())
				{
					userBackTalk = "are you sure you are good at thinking?";
				}
				else
				{
					userBackTalk = "so about that thinking... or lack thereof";
				}
				break;
		}
		
		return userBackTalk;
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
		String result = "";
		if (getChatCount() == 0)
		{
			myUser.setUserName(input);
			result = myUser.getUserName() + " is a good name!     How old are you?";
		}
		else if (getChatCount() == 1)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
			result = myUser.getAge() + " is much older than i am.  hey are you one of those persons?  you know,   a Human?";
		}
		else if (getChatCount() == 2)
		{
			Boolean isPerson = false;
			if (input.contains("yes") || input.contains("Yes") || Boolean.parseBoolean(input))
			{
				isPerson = true;
				myUser.setPerson(isPerson);
			}
			result = "so " + myUser.getUserName() +  " true or false are you a good thinker?";
			myUser.setPerson(isPerson);
		}
		else if (getChatCount() == 3)
		{
			Boolean canThink = false;
			if (Boolean.parseBoolean(input))
			{
				canThink = true;
				myUser.setCanThink(canThink);
				result = "So a thinker you are!";
			}
			
		}
		return result;
	}
}