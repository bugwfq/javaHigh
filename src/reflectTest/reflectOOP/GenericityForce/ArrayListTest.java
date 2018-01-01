package reflectTest.reflectOOP.GenericityForce;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//获取该集合字节码文件对象
		Class<?> arrClass = arr.getClass();
		Method method = null;
		try {
			//通过字节码文件对象获取田间方法
			method = arrClass.getMethod("add", Object.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			//运行该方法
			method.invoke(arr, "我是字符串");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//成功越过检查        
		System.out.println(arr);
		//输出内容：[我是字符串]
	}
}
