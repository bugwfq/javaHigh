package reflectTest.reflectOOP.byProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * 该类模仿USB插卡口利用配置文件改变运行内容
 * @author Administrator
 *
 */
public class mainComputer {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//获取配置文件
		File file = new File("src/reflectTest/reflectOOP/byProperties/equipment.properties");
		//创建读取流
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<String> keys = p.stringPropertyNames();
		for(Iterator<String> iter = keys.iterator(); iter.hasNext();){
			String key = iter.next();
			//获取字节码文件对象
			Class<?> classs = Class.forName(p.getProperty(key));
			//创建对象
			Object obj = classs.newInstance();
			if(obj instanceof USB){
				USB usb = (USB)obj;
				//遍历配置文件中所添加的类名并且调用
				read(usb);
			}
			
		}
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 只要传入设备实现USB接口就能用行
	 * @param equipment
	 */
	public static void read(USB equipment){
		if(equipment!=null){
			equipment.run();
			equipment.close();
		}
		
	}
	
}
