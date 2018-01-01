package reflectTest.reflectOOP.dynamicMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * ����ͨ�������ļ��Բ�ͬ��Ķ�̬����
 * @author Administrator
 *
 */
public class Main {
	public static void main(String[] args) {
		//��ȡ�����ļ������ļ����������̶��ļ�   className , methodName
		File file = new File("src/reflectTest/reflectOOP/dynamicMain/Configuration.properties");
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��ȡҪ���е�����
		String className = p.getProperty("className");
		//��ȡҪ���еķ�����
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
