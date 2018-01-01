package reflectTest.proxyByInvocationHandlerTest;

import java.lang.reflect.Proxy;

public class InvocationHandlerTest {
	public static void main(String[] args) {
		//创建需要使用代理的原类对象
		ManagerInterface um = new UserManager();
		//创建代理器   那个类需要代理就把那个类传进去  当调用代理对象的方法时会调用原方法
		MyInvocationHandlerManager my = new MyInvocationHandlerManager(um);
		
		//通过Proxy代理类中的newProxyInstance（）返回代理对象
		/*
		 * Proxy.newProxyInstance();方法中的三个值
		 * 1.代理器的my.getClass().getClassLoader()返回该类的类加载器。
		 * 2.本类的超类接口    um.getClass().getInterfaces();
		 * 3.代理器对象 my
		 */
		//代理器对象必须父接口
		ManagerInterface newUM = (ManagerInterface) Proxy.newProxyInstance(my.getClass().getClassLoader(), um.getClass().getInterfaces(), my);
		newUM.add();
		newUM.delete();
		newUM.find();
		newUM.update();
		
		//创建需要使用代理的原类
		ManagerInterface sm = new StudentManager();
		//创建代理器
		MyInvocationHandlerManager mystu = new MyInvocationHandlerManager(sm);
		//创建代理对象
		ManagerInterface newSM = (ManagerInterface) Proxy.newProxyInstance(mystu.getClass().getClassLoader(), sm.getClass().getInterfaces(), mystu);
		newSM.add();
		newSM.delete();
		newSM.find();
		newSM.update();
	}
}
