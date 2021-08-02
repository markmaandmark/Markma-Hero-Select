package tools;
/**
 * Args分离函数
 * 将用户输入的带逗号的查询方式分离到数组中去
 * 例子:“刘备,曹操”->dividedName[0]="刘备",dividedName[1]="曹操"
 * 例子:“ID,attackValue”->dividedProperties[0]="ID",dividedName[1]="attackValue"
 * @author markma
 * @date 修改时间:2021年8月2日 上午11:36:50
 */
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
