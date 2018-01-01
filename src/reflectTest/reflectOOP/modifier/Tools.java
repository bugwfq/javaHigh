package reflectTest.reflectOOP.modifier;

import java.lang.reflect.Field;

public class Tools {
	/**
	 * �޸�ĳ�����ĳ������ֱ���޸�
	 * @param updateClass  Ҫ�޸ĵĶ���
	 * @param fieldName  �޸ĵ�������
	 * @param updateField   �޸ĺ�Ķ���
	 */
	public static void update(Object updateClass,String fieldName,Object updateField){
		//��ȡҪ�޸ĵ����Ե��ֽ����ļ�����
		Class uClass = updateClass.getClass();
		Field field = null;
		try {
			//��ȡҪ�޸ĵĶ��󷽷�
			field = uClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		//��������
		field.setAccessible(true);
	
		try {
			//�޸Ķ�Ӧ������
			field.set(updateClass, updateField);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
