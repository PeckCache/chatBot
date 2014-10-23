package chatBot.view;

import javax.swing.JFrame;
import chatBot.controller.ChatBotController;

public class ChatBotFrame extends JFrame
{
	private ChatBotPanel basePanel;
	
	/**
	 * 
	 * @param baseController
	 */
	public ChatBotFrame(ChatBotController baseController)
	{
		basePanel = new ChatBotPanel(baseController);	
		
		setupFrame();
	}
	
	/**
	 * sets the window size and other components of the window.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(800, 400);;
		setVisible(true);
		setResizable(false);
	}

}
