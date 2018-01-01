package reflectTest.reflectOOP.modifier;

import java.lang.reflect.Field;

public class Tools {
	/**
	 * 修改某个类的某个属性直接修改
	 * @param updateClass  要修改的对象
	 * @param fieldName  修改的属性名
	 * @param updateField   修改后的对象
	 */
	public static void update(Object updateClass,String fieldName,Object updateField){
		//获取要修改的属性的字节码文件对象
		Class uClass = updateClass.getClass();
		Field field = null;
		try {
			//获取要修改的对象方法
			field = uClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		//暴力访问
		field.setAccessible(true);
	
		try {
			//修改对应的属性
			field.set(updateClass, updateField);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
