package chatBot.view;

import javax.swing.JOptionPane;

import chatBot.controller.ChatBotController;

/**
 * displays messages to the user.
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
	 * Shows a String from the Chatbot with the availability of user input.
	 * @param currentInput The supplied String.
	 * @return The typed response.
	 */
	public String showChatBotDialog(String currentInput)
	{
		String result = "";

		result = JOptionPane.showInputDialog(null, baseController.getMyCrazyChatBot().getName() + " says: " + currentInput);
		
		return result;
	}
	
	/**
	 * Show a String from the ChatBot as a popup window
	 * @param currentInput The String rom the Chatbot
	 */
	public void showChatBotMessage(String currentInput)
	{
		JOptionPane.showMessageDialog(null, baseController.getMyCrazyChatBot().getName() + " says: " + currentInput);
	}
}
