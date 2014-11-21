package chatBot.model;

public class ChatBotUser
{
//four data members
	//at least two different types (String, int, boolean, double....)
	private String userName;
	private int age;
	private boolean isPerson;
	private boolean canThink;
	
	public ChatBotUser()
	{
		this.userName = "";
		this.age = -1;
		this.isPerson = false;
		this.canThink = false;
		
	}

	public String getUserName()
	{
		return userName;
	}

	public int getAge()
	{
		return age;
	}

	public boolean isPerson()
	{
		return isPerson;
	}

	public boolean CanThink()
	{
		return canThink;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void setPerson(boolean isPerson)
	{
		this.isPerson = isPerson;
	}

	public void setCanThink(boolean canThink)
	{
		this.canThink = canThink;
	}
	
}
