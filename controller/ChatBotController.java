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

	public ChatBotController()
	{
		botView = new ChatBotView(this);
		myCrazyChatBot = new ChatBot("Bob");
	}

	public void start()
	{
		String result = botView.showChatBot("James");

		if (myCrazyChatBot.quitChecker(result))
		{
			quit();
		}
	}

	private void quit()
	{
		JOptionPane.showMessageDialog(null, "goodbye cruel world");
		;
		System.exit(0);
		;
	}
}
