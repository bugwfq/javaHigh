package reflectTest.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class newUser {
	public static void main(String[] args) throws Exception {
		//获取无参数的构造函数
		mainClassGetConstructor();  
		//获取有参数的构造方法
		mainClassGetConstructorToParameterTypes();
		//获取某个类中的字段（getField（）只能获取所有公有对象字段）
		mainClassGetField();
		//获取某个类中任何字段包括私有的
		mainClassGetDeclaredField();
		//获取某个类中公有的方法   getMethod()/getMethods();
		mainClassGetMethods();
		//获取某个类中的任意方法包括私有方法getDeclaredMethod
		mainClassGetDeclaredMethod();
		//获取某个类中的所有方法
		mainClasssGetMethodAll();
		//获取某个类中所有的字段
		mainClassGetFields();
		
	}
	
	//获取某个类中所有字段
	private static void mainClassGetFields() throws ClassNotFoundException {
		//该类全类名
		String className = "reflectTest.Class.User";
		//获取该字节码文件对象
		Class<?> classs = Class.forName(className);
		//获取该类所有公有字段
		Field[] fields = classs.getFields();
		for(Field field:fields){
			System.out.println(field);
		}
		//获取本类所有字段  包括私有
		Field[] declaredFields = classs.getDeclaredFields();
		for(Field declaredField : declaredFields){
			System.out.println(declaredField);
		}
	}
	/**
	 * 获取某个类中的所有方法   getMethods();
	 * @throws ClassNotFoundException 
	 */
	private static void mainClasssGetMethodAll() throws ClassNotFoundException {
		//获取全类名
		String className = "reflectTest.Class.User";
		//获取字节码文件对象
		Class<?> classs = Class.forName(className);
		
		//获取所有公有的方法
		Method[] methods = classs.getMethods();
		for(Method method : methods){
			System.out.println(method);
		}
		//获取本类所有方法
		Method[] declaredMethods = classs.getDeclaredMethods();
		
		for(Method method : declaredMethods){
			System.out.println(method);
		}
	}
	/**
	 * 获取某个类中的任意方法
	 * @throws Exception 
	 * @throws NoSuchMethodException 
	 */
	private static void mainClassGetDeclaredMethod() throws NoSuchMethodException, Exception {
		//设置全类名
		String className = "reflectTest.Class.User";
		//获取字节码文件对象
		Class<?> classs = Class.forName(className);
		//获取私有方法
		Method methodNull = classs.getDeclaredMethod("test");
		Method methodStringAndInt = classs.getDeclaredMethod("test", String.class,int.class);
		//设置暴力访问
		methodNull.setAccessible(true);
		methodStringAndInt.setAccessible(true);	
		//创建对象才能调用方法
		Object obj = classs.newInstance();

		//调用方法
		methodNull.invoke(obj);
		methodStringAndInt.invoke(obj, "强哥",666);	
	}
	/**
	 * 获取某个类中的成员方法  利用getMethod()或getMethods();
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	private static void mainClassGetMethods() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//全类名
		String className = "reflectTest.Class.User";
		//获取字节码文件对象
		Class<?> classs = Class.forName(className);
		//获取需要的方法 不包括私有的空参方法
		Method methodNull = classs.getDeclaredMethod("run");
		//获取需要的方法 不包括私有的带参数的方法
		Method methodStringAndInt = classs.getDeclaredMethod("run", String.class,int.class);

		//创建对象才能调用方法
		Object obj = classs.newInstance();
		
		//设置暴力访问
		methodNull.setAccessible(true);
		methodStringAndInt.setAccessible(true);
		
		//调用方法  用invoke
		methodNull.invoke(obj);
		methodStringAndInt.invoke(obj, "强哥",666);
	}

	/**
	 * 获取某个类中的字段（getDeclaredField()）包括私有的
	 * @throws Exception 
	 */
	private static void mainClassGetDeclaredField() throws Exception {
		//获取要使用的类的全包名+类名
		String className = "reflectTest.Class.User";
		//获取字节码文件对象
		Class<?> classs = Class.forName(className);
		Field field = classs.getDeclaredField("age");
		//设置暴力访问访问该对象字段
		// 不添加暴力访问就会抛java.lang.IllegalAccessException: Class reflect.Class.newUser can not access a member of class reflectTest.Class.User with modifiers "private"
		field.setAccessible(true);
		Object obj = classs.newInstance();
		field.set(obj, 666);
		System.out.println(field.get(obj));
	}

	/**
	 * 获取某个类中的字段（getField（）只能获取所有公有的对象字段）
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void mainClassGetField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		//该类的具体包名加类名
		String className = "reflectTest.Class.User";
		//获取该字节码文件对象
		Class<?> classs = Class.forName(className);
		Field field = classs.getField("name");//不能获取私有的
		//也可以使用  classs.getFields();可以获取所有除私有的字段
		//必须 通过对象才能调用字段
		Object obj = classs.newInstance();
		field.set(obj, "wang");
		System.out.println(field.get(obj));
	}
	/**
	 * 获取某个字节码文件的带参数的构造方法
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void mainClassGetConstructorToParameterTypes() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//该类的包名加类名
		String className = "reflectTest.Class.User";
		//获取该字节码文件对象
		Class<?> classs = Class.forName(className);
		//调用getConstructor(Class<?>...parameterType)方法获取该构造器
		Constructor<?> constructor = classs.getConstructor(String.class,int.class);
		//创建对象
		Object obj = constructor.newInstance("强哥",666);
		System.out.println(obj);
	}
	/**
	 * 获取一个字节码文件对象的方式一通过Class类中的无参数的构造器
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	public static void mainClassGetConstructor() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		//获取字节码文件对象
		String className = "reflectTest.Class.User";//该类的包名加类名
		Class<?> classs = Class.forName(className);
		//获取无参数的构造函数
		Object obj = classs.newInstance();
		System.out.println(obj);
	}
}
