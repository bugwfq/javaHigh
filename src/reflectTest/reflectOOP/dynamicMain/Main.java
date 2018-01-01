package reflectTest.reflectOOP.dynamicMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 测试通过配置文件对不同类的动态运行
 * @author Administrator
 *
 */
public class Main {
	public static void main(String[] args) {
		//获取配置文件配置文件中有两个固定的键   className , methodName
		File file = new File("src/reflectTest/reflectOOP/dynamicMain/Configuration.properties");
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取要运行的类名
		String className = p.getProperty("className");
		//获取要运行的方法名
		String methodName = p.getProperty("methodName");
		
		Class runClass = null;
		try {
			runClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object obj = null;
		try {
			obj = runClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Method method = null;
		try {
			method = runClass.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		method.setAccessible(true);
		try {
			method.invoke(obj);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
