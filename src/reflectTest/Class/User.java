package reflectTest.Class;
/**
 * 用于练习反射对对象字节码文件对象的获取
 * @author Administrator
 *
 */
public class User {
	public String name;
	@SuppressWarnings("unused")
	private int age;
	/**
	 * 无参数的构造器
	 */
	public User() {
		System.out.println("这是一个无参数的构造函数");
	}
	public User(String name,int age){
		this.name = name ;
		this.age = age;
		System.out.println("赋值成功！ name:"+name+"age:"+age);
	}
	public void run(){
		System.out.println("无参数的 run  方法");
	}
	public void run(String name ,int age){
		System.out.println("带参数的 run 方法  name："+name+"age:"+age);
	}
	@SuppressWarnings("unused")
	private void test(){
		System.out.println("空参 的私有方法test");
	}
	@SuppressWarnings("unused")
	private void test(String name,int age){
		System.out.println("带参数的私有方法test  name："+name+"age:"+age);
	}
}
