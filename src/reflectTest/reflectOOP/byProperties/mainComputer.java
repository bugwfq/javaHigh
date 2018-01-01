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
 * ����ģ��USB�忨�����������ļ��ı���������
 * @author Administrator
 *
 */
public class mainComputer {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//��ȡ�����ļ�
		File file = new File("src/reflectTest/reflectOOP/byProperties/equipment.properties");
		//������ȡ��
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
			//��ȡ�ֽ����ļ�����
			Class<?> classs = Class.forName(p.getProperty(key));
			//��������
			Object obj = classs.newInstance();
			if(obj instanceof USB){
				USB usb = (USB)obj;
				//���������ļ�������ӵ��������ҵ���
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
	 * ֻҪ�����豸ʵ��USB�ӿھ�������
	 * @param equipment
	 */
	public static void read(USB equipment){
		if(equipment!=null){
			equipment.run();
			equipment.close();
		}
		
	}
	
}
