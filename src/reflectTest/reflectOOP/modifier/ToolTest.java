package reflectTest.reflectOOP.modifier;

public class ToolTest {
	public static void main(String[] args) {
		//Ҫ�޸ĵĶ���
		User u = new User("ǿ��",666);
		//�����޸ĵķ���
		Tools.update(u, "name", "����ǿ");
		System.out.println(u);
	}
}
