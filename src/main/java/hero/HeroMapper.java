package hero;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/*
 * 映射 SQL方法
 */
public interface HeroMapper 
{
	/*int ID,
	int bloodValue,
	int attackValue,
	String name,
	String weaponName,
	String birthday,
	String deathday,
	String introduction*/
	@Insert("insert into heros(ID,bloodValue,attackValue,name,weaponName,birthday,deathday,introduction) "
			+ "values(#{ID}, #{bloodValue}, #{attackValue},#{name},#{weaponName},#{birthday},#{deathday},#{introduction})")
    void save(Hero b);
	@Select("SELECT * FROM heros WHERE name = #{name}")
	List<Hero> find(@Param("name") String name);
	@Select("SELECT * FROM heros")
    List<Hero> findAll();
	@Delete("")
    void remove(String title);
	@Update("")
    void update(Hero b);
}