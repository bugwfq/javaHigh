package reflectTest.Class;
/**
 * ������ϰ����Զ����ֽ����ļ�����Ļ�ȡ
 * @author Administrator
 *
 */
public class User {
	public String name;
	@SuppressWarnings("unused")
	private int age;
	/**
	 * �޲����Ĺ�����
	 */
	public User() {
		System.out.println("����һ���޲����Ĺ��캯��");
	}
	public User(String name,int age){
		this.name = name ;
		this.age = age;
		System.out.println("��ֵ�ɹ��� name:"+name+"age:"+age);
	}
	public void run(){
		System.out.println("�޲����� run  ����");
	}
	public void run(String name ,int age){
		System.out.println("�������� run ����  name��"+name+"age:"+age);
	}
	@SuppressWarnings("unused")
	private void test(){
		System.out.println("�ղ� ��˽�з���test");
	}
	@SuppressWarnings("unused")
	private void test(String name,int age){
		System.out.println("��������˽�з���test  name��"+name+"age:"+age);
	}
}
