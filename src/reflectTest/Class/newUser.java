package reflectTest.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class newUser {
	public static void main(String[] args) throws Exception {
		//��ȡ�޲����Ĺ��캯��
		mainClassGetConstructor();  
		//��ȡ�в����Ĺ��췽��
		mainClassGetConstructorToParameterTypes();
		//��ȡĳ�����е��ֶΣ�getField����ֻ�ܻ�ȡ���й��ж����ֶΣ�
		mainClassGetField();
		//��ȡĳ�������κ��ֶΰ���˽�е�
		mainClassGetDeclaredField();
		//��ȡĳ�����й��еķ���   getMethod()/getMethods();
		mainClassGetMethods();
		//��ȡĳ�����е����ⷽ������˽�з���getDeclaredMethod
		mainClassGetDeclaredMethod();
		//��ȡĳ�����е����з���
		mainClasssGetMethodAll();
		//��ȡĳ���������е��ֶ�
		mainClassGetFields();
		
	}
	
	//��ȡĳ�����������ֶ�
	private static void mainClassGetFields() throws ClassNotFoundException {
		//����ȫ����
		String className = "reflectTest.Class.User";
		//��ȡ���ֽ����ļ�����
		Class<?> classs = Class.forName(className);
		//��ȡ�������й����ֶ�
		Field[] fields = classs.getFields();
		for(Field field:fields){
			System.out.println(field);
		}
		//��ȡ���������ֶ�  ����˽��
		Field[] declaredFields = classs.getDeclaredFields();
		for(Field declaredField : declaredFields){
			System.out.println(declaredField);
		}
	}
	/**
	 * ��ȡĳ�����е����з���   getMethods();
	 * @throws ClassNotFoundException 
	 */
	private static void mainClasssGetMethodAll() throws ClassNotFoundException {
		//��ȡȫ����
		String className = "reflectTest.Class.User";
		//��ȡ�ֽ����ļ�����
		Class<?> classs = Class.forName(className);
		
		//��ȡ���й��еķ���
		Method[] methods = classs.getMethods();
		for(Method method : methods){
			System.out.println(method);
		}
		//��ȡ�������з���
		Method[] declaredMethods = classs.getDeclaredMethods();
		
		for(Method method : declaredMethods){
			System.out.println(method);
		}
	}
	/**
	 * ��ȡĳ�����е����ⷽ��
	 * @throws Exception 
	 * @throws NoSuchMethodException 
	 */
	private static void mainClassGetDeclaredMethod() throws NoSuchMethodException, Exception {
		//����ȫ����
		String className = "reflectTest.Class.User";
		//��ȡ�ֽ����ļ�����
		Class<?> classs = Class.forName(className);
		//��ȡ˽�з���
		Method methodNull = classs.getDeclaredMethod("test");
		Method methodStringAndInt = classs.getDeclaredMethod("test", String.class,int.class);
		//���ñ�������
		methodNull.setAccessible(true);
		methodStringAndInt.setAccessible(true);	
		//����������ܵ��÷���
		Object obj = classs.newInstance();

		//���÷���
		methodNull.invoke(obj);
		methodStringAndInt.invoke(obj, "ǿ��",666);	
	}
	/**
	 * ��ȡĳ�����еĳ�Ա����  ����getMethod()��getMethods();
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	private static void mainClassGetMethods() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//ȫ����
		String className = "reflectTest.Class.User";
		//��ȡ�ֽ����ļ�����
		Class<?> classs = Class.forName(className);
		//��ȡ��Ҫ�ķ��� ������˽�еĿղη���
		Method methodNull = classs.getDeclaredMethod("run");
		//��ȡ��Ҫ�ķ��� ������˽�еĴ������ķ���
		Method methodStringAndInt = classs.getDeclaredMethod("run", String.class,int.class);

		//����������ܵ��÷���
		Object obj = classs.newInstance();
		
		//���ñ�������
		methodNull.setAccessible(true);
		methodStringAndInt.setAccessible(true);
		
		//���÷���  ��invoke
		methodNull.invoke(obj);
		methodStringAndInt.invoke(obj, "ǿ��",666);
	}

	/**
	 * ��ȡĳ�����е��ֶΣ�getDeclaredField()������˽�е�
	 * @throws Exception 
	 */
	private static void mainClassGetDeclaredField() throws Exception {
		//��ȡҪʹ�õ����ȫ����+����
		String className = "reflectTest.Class.User";
		//��ȡ�ֽ����ļ�����
		Class<?> classs = Class.forName(className);
		Field field = classs.getDeclaredField("age");
		//���ñ������ʷ��ʸö����ֶ�
		// ����ӱ������ʾͻ���java.lang.IllegalAccessException: Class reflect.Class.newUser can not access a member of class reflectTest.Class.User with modifiers "private"
		field.setAccessible(true);
		Object obj = classs.newInstance();
		field.set(obj, 666);
		System.out.println(field.get(obj));
	}

	/**
	 * ��ȡĳ�����е��ֶΣ�getField����ֻ�ܻ�ȡ���й��еĶ����ֶΣ�
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void mainClassGetField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		//����ľ������������
		String className = "reflectTest.Class.User";
		//��ȡ���ֽ����ļ�����
		Class<?> classs = Class.forName(className);
		Field field = classs.getField("name");//���ܻ�ȡ˽�е�
		//Ҳ����ʹ��  classs.getFields();���Ի�ȡ���г�˽�е��ֶ�
		//���� ͨ��������ܵ����ֶ�
		Object obj = classs.newInstance();
		field.set(obj, "wang");
		System.out.println(field.get(obj));
	}
	/**
	 * ��ȡĳ���ֽ����ļ��Ĵ������Ĺ��췽��
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void mainClassGetConstructorToParameterTypes() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//����İ���������
		String className = "reflectTest.Class.User";
		//��ȡ���ֽ����ļ�����
		Class<?> classs = Class.forName(className);
		//����getConstructor(Class<?>...parameterType)������ȡ�ù�����
		Constructor<?> constructor = classs.getConstructor(String.class,int.class);
		//��������
		Object obj = constructor.newInstance("ǿ��",666);
		System.out.println(obj);
	}
	/**
	 * ��ȡһ���ֽ����ļ�����ķ�ʽһͨ��Class���е��޲����Ĺ�����
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	public static void mainClassGetConstructor() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		//��ȡ�ֽ����ļ�����
		String className = "reflectTest.Class.User";//����İ���������
		Class<?> classs = Class.forName(className);
		//��ȡ�޲����Ĺ��캯��
		Object obj = classs.newInstance();
		System.out.println(obj);
	}
}
