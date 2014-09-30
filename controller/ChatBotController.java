package chatBot.controller;

import javax.swing.JOptionPane;

import chatBot.model.ChatBot;
import chatBot.view.ChatBotView;

/**
 * 
 * @author James Peck
 *@version 1.1 9/26/14
 */
public class ChatBotController
{
	private ChatBotView botView;
	private ChatBot myCrazyChatBot;

	/**
	 * Constructors are here
	 */
	public ChatBotController()
	{
		botView = new ChatBotView(this);
		myCrazyChatBot = new ChatBot("Bob");
	}

	/**
	 * Stating Function
	 * also main function
	 */
	public void start()
	{
		String result = botView.showChatBot("James");
		
		while(!myCrazyChatBot.quitChecker(result))
		{
			result = botView.showChatBot(result);
		}

		quit();
	}

	/**
	 * Called when the result of the start function returns true
	 */
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "goodbye cruel world");
		;
		System.exit(0);
		;
	}
}
