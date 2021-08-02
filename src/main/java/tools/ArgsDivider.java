package tools;
public class ArgsDivider
{
	final int MAX_NAME = 1000,MAX_PRO = 1000;
	String undividedName,undividedProperties;
	String dividedName[],dividedProperties[];
	public ArgsDivider()
	{
		
	}
	public ArgsDivider(String mainUndName,String mainUndProperties)
	{
		undividedName = mainUndName;
		undividedProperties = mainUndProperties;
	}
	public void divideName()
	{
		dividedName = new String[MAX_NAME];
		dividedName = undividedName.split(",");
	}
	public void dividePro()
	{
		dividedProperties = new String[MAX_PRO];
		dividedProperties = undividedProperties.split(",");
	}

}
