package reflectTest.proxyByInvocationHandlerTest;

import java.lang.reflect.Proxy;

public class InvocationHandlerTest {
	public static void main(String[] args) {
		//������Ҫʹ�ô����ԭ�����
		ManagerInterface um = new UserManager();
		//����������   �Ǹ�����Ҫ����Ͱ��Ǹ��ഫ��ȥ  �����ô������ķ���ʱ�����ԭ����
		MyInvocationHandlerManager my = new MyInvocationHandlerManager(um);
		
		//ͨ��Proxy�������е�newProxyInstance�������ش������
		/*
		 * Proxy.newProxyInstance();�����е�����ֵ
		 * 1.��������my.getClass().getClassLoader()���ظ�������������
		 * 2.����ĳ���ӿ�    um.getClass().getInterfaces();
		 * 3.���������� my
		 */
		//������������븸�ӿ�
		ManagerInterface newUM = (ManagerInterface) Proxy.newProxyInstance(my.getClass().getClassLoader(), um.getClass().getInterfaces(), my);
		newUM.add();
		newUM.delete();
		newUM.find();
		newUM.update();
		
		//������Ҫʹ�ô����ԭ��
		ManagerInterface sm = new StudentManager();
		//����������
		MyInvocationHandlerManager mystu = new MyInvocationHandlerManager(sm);
		//�����������
		ManagerInterface newSM = (ManagerInterface) Proxy.newProxyInstance(mystu.getClass().getClassLoader(), sm.getClass().getInterfaces(), mystu);
		newSM.add();
		newSM.delete();
		newSM.find();
		newSM.update();
	}
}
