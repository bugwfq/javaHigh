package reflectTest.reflectOOP.modifier;
/**
 * 对象类字段有姓名和年龄两个属性
 * @author Administrator
 *
 */
public class User {
	private String name;//姓名
	private int age;//年龄
	public User() {}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}
