package tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hero.Hero;
import hero.HeroMapper;

public class SQLReader
{
	public SQLReader() 
    {

    }
	public void read(String [] dividedName,String [] dividedPro)
	{
		try 
		{
	        SqlSessionFactory factory = new SqlSessionFactoryBuilder()
	                .build(Resources.getResourceAsReader("tools/config.xml"));

	        // 一次会话
	        // Connection
	        SqlSession session = factory.openSession();

	        // 获得了接口的一个具体实现（实例）
	        // mybatis 根据注解创建了接口的实力
	        HeroMapper mapper = session.getMapper(HeroMapper.class);
	        List<Hero> heroList = new ArrayList<Hero>();
			for(String name:dividedName)
			{
				if(name.equals("-a"))
				{
					heroList = mapper.findAll();
					break;
				}
				else
				{
					if(mapper.find(name) != null)
					{
						heroList.addAll(mapper.find(name));
					}
				}
			}
			String pro = dividedPro[0];
			if(pro.equals("-a"))
			{
				for (Hero i : heroList) 
				{
					System.out.println(i);
			    }
			}
			else
			{
				for (Hero i : heroList) 
				{
					System.out.println(i.partToString(dividedPro));
			    }
			}
		
	        // 会话提交
	        session.commit();
	        System.out.println("查询完毕，共找到"+heroList.size()+"条结果");

	    } 
		catch (IOException e) 
		{
	        e.printStackTrace();
	    }
	}
}
