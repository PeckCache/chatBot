package chatBot.view;

import java.awt.Color;

import javax.swing.*;

import chatBot.controller.ChatBotController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatBotPanel extends JPanel
{

	private ChatBotController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JScrollPane chatPane;
	private JTextArea chatArea;

	/**
	 * The constructor of this class
	 * 
	 * @param basePanel
	 */
	public ChatBotPanel(ChatBotController basePanel)
	{
		this.baseController = baseController;

		firstButton = new JButton("Click Me you know you want to!");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		chatPane = new JScrollPane();


		setupPane()
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPane()
	{
		chatArea.setLineWrap(true);;
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * Sets the panel's background and contains the element.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
		chatArea = new JTextArea(5, 20);
		
		add(chatArea);
	}

	/**
	 * contains the layout of the panel
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 113, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -107, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 171, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, 194, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 77, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, 100, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, 0, SpringLayout.EAST, firstTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, -101, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, 0, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, firstButton);
	}

	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				firstTextField.setText(firstTextField.getText()+ " :)");
			}
		});

	}

}
