
import tools.ArgsHandler;
/**
 * main函数
 * 直接调用args处理
 * @author markma
 * @date 修改时间:2021年8月2日 上午11:39:27
 */
public class Main {

    public static void main(String[] args) 
    {
    	ArgsHandler argsHandler = new ArgsHandler(args);
    	argsHandler.switchModel();
    }
}