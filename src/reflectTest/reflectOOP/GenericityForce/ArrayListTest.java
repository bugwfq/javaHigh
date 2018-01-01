package reflectTest.reflectOOP.GenericityForce;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//��ȡ�ü����ֽ����ļ�����
		Class<?> arrClass = arr.getClass();
		Method method = null;
		try {
			//ͨ���ֽ����ļ������ȡ��䷽��
			method = arrClass.getMethod("add", Object.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			//���и÷���
			method.invoke(arr, "�����ַ���");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//�ɹ�Խ�����        
		System.out.println(arr);
		//������ݣ�[�����ַ���]
	}
}
