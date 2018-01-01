package reflectTest.reflectOOP.modifier;

public class ToolTest {
	public static void main(String[] args) {
		//要修改的对象
		User u = new User("强哥",666);
		//调用修改的方法
		Tools.update(u, "name", "王福强");
		System.out.println(u);
	}
}
