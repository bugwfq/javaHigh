package reflectTest.proxyByInvocationHandlerTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 要使用动态代理对象必须实现InvocationHandler接口
 * @author Administrator
 *
 */
public class MyInvocationHandlerManager implements InvocationHandler{
	public Object official;//需要使用代理的本类
	public MyInvocationHandlerManager(Object official){
		this.official = official;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//添加需要代理增加的方法
		System.out.println("添加功能！");
		//调用原方法   原理是代理对象调用该方法后会依次执行该方法中的执行语句
		 //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		method.invoke(official,args);//传入本类
		return null;
	}

}
