package reflectTest.proxyByInvocationHandlerTest;

public class StudentManager implements ManagerInterface {

	@Override
	public void add() {
		System.out.println("���ѧ��StudentManager");
	}

	@Override
	public void delete() {
		System.out.println("ɾ��ѧ��StudentManager");
	}

	@Override
	public void update() {
		System.out.println("�޸�ѧ��StudentManager");
	}

	@Override
	public void find() {
		System.out.println("����ѧ��StudentManager");
	}

}
