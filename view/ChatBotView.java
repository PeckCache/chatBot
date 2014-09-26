package chatBot.view;

import javax.swing.JOptionPane;

import chatBot.controller.ChatBotController;

/**
 * 
 * @author James Peck
 *@version 1.1 9/26/14
 */
public class ChatBotView
{

	private ChatBotController baseController;

	public ChatBotView(ChatBotController baseController)
	{
		this.baseController = baseController;
	}

	/**
	 * starting dialogue
	 * @param currentInput user input
	 * @return chatbot output
	 */
	public String showChatBot(String currentInput)
	{
		String result = "";

		JOptionPane.showMessageDialog(null, "Hello, "+ currentInput);
		result = JOptionPane.showInputDialog(null, "are you done?");
		return result;
	}
}
