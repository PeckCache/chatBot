package chatBot.controller;

import javax.swing.JOptionPane;

import chatBot.view.ChatBotView;

public class ChatBotController
{
	private ChatBotView botView;

	public ChatBotController()
	{
		botView = new ChatBotView(this);
	}

	public void start()
	{
		String result = botView.showChatBot("James");
		
		if (result.equalsIgnoreCase("exit"));
		{
			quit();
		} 
		if (result.equalsIgnoreCase("yes"));
		{
			quit();
		}
	}

	private void quit()
	{
		JOptionPane.showMessageDialog(null, "good bye cruel world");
		;
		System.exit(0);
		;
	}
}
