package reflectTest.proxyByInvocationHandlerTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * Ҫʹ�ö�̬����������ʵ��InvocationHandler�ӿ�
 * @author Administrator
 *
 */
public class MyInvocationHandlerManager implements InvocationHandler{
	public Object official;//��Ҫʹ�ô���ı���
	public MyInvocationHandlerManager(Object official){
		this.official = official;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//�����Ҫ�������ӵķ���
		System.out.println("��ӹ��ܣ�");
		//����ԭ����   ԭ���Ǵ��������ø÷����������ִ�и÷����е�ִ�����
		 //    ��������������ʵ����ķ���ʱ������Զ�����ת��������������handler�����invoke���������е���
		method.invoke(official,args);//���뱾��
		return null;
	}

}
