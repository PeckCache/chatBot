package chatBot.controller;

import chatBot.model.ChatBot;
import chatBot.view.ChatBotFrame;
import chatBot.view.ChatBotPanel;
import chatBot.view.ChatBotView;

/**
 * Controller of what is sent where and when to quit.
 * 
 * @author James Peck
 * @version 1.2 9/26/14
 */
public class ChatBotController
{
	private ChatBotView botView;
	private ChatBot myCrazyChatBot;
	private String startMessage;
	private String quitMessage;
	private ChatBotFrame appFrame;

	/**
	 * Constructors are here
	 */
	public ChatBotController()
	{
		appFrame = new ChatBotFrame(this);
		botView = new ChatBotView(this);
		myCrazyChatBot = new ChatBot("Bob");
		startMessage = "Welcome to the " + myCrazyChatBot.getName() + " chatbot. What is your name?";
		quitMessage = "goodbye cruel user :(";
	}

	public ChatBot getMyCrazyChatBot()
	{
		return myCrazyChatBot;
	}

	/**
	 * Stating Function also main function
	 */
	public void start()
	{
		((ChatBotPanel) appFrame.getContentPane()).showMessage(startMessage);

		//ChatBotPanel testPanel = (ChatBotPanel) appFrame.getContentPane();
		//testPanel.showTextMessage(startMessage);
	}
	
	public String getChatBotDialog(String input)
	{
		String result = "";
		if(myCrazyChatBot.quitChecker(input))
		{
			quit();
		}
		result = myCrazyChatBot.processText(input);
		return result;
	}

	/**
	 * Called when the result of the start function returns true
	 */
	private void quit()
	{
		botView.showChatBotMessage(quitMessage);
		System.exit(0);
	}
}
