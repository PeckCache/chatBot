package chatBot.view;

import javax.swing.JPanel;

import chatBot.controller.ChatBotController;

public class ChatBotPanel extends JPanel
{
	
	private ChatBotController baseController;
	public ChatBotPanel(ChatBotController basePanel) 
	{
		this.baseController = baseController;
	}

}
