package tools;

public class ArgsHandler
{
	String args[];
	final String VERSION = "0.0.1";
	public ArgsHandler()
	{
		
	}
	public ArgsHandler(String mainArgs[])
	{
		args = new String[mainArgs.length];
		System.arraycopy(mainArgs, 0, args, 0, mainArgs.length);
	}
	public void printHelp()
	{
		System.out.println("-s name properties 搜索模式");
		System.out.println("多个name和properties用,连接 查询全部为-a");
		System.out.println("properties名称:姓名name,武器weaponName,生日birthday,卒日deathday,"
				+ "介绍introduction,ID ID,血量bloodValue,攻击力attackValue");
		System.out.println("例： -s 刘备,曹操 ID,bloodValue");
		System.out.println("例： -s -a ID");
		System.out.println("-v 显示版本");
		return;
	}
	public void switchModel()
	{
		switch(args.length)
		{
		case 0:
		{
			System.out.println("三国人物查找系统");
			System.out.println("命令后缀名：");
			printHelp();
			return;
		}
		case 1:
		{
			if(args[0].equals("-v"))
			{
				System.out.println("version:"+VERSION);
				return;
			}
			else
			{
				System.out.println("后缀名输入错误");
				printHelp();
				return;
			}	
		}
		case 3:
		{
			if(args[0].equals("-s"))
			{
				ArgsDivider argsDivider = new ArgsDivider(args[1],args[2]);
				argsDivider.divideName();
				argsDivider.dividePro();
				SQLReader sqlReader = new SQLReader();
				sqlReader.read(argsDivider.dividedName, argsDivider.dividedProperties);
				return;
			}
			else
			{
				System.out.println("后缀名输入错误");
				printHelp();
				return;
			}
		}
		default:
		{
			System.out.println("后缀名数目输入错误");
			printHelp();
			return;
		}	
	}
	}
}
