package reflectTest.proxyByInvocationHandlerTest;
/**
 * ʵ��ManagerInterface�ӿ�
 * @author Administrator
 *
 */
public class UserManager implements ManagerInterface{

	@Override
	public void add() {
		System.out.println("����û�UserManager��");
	}

	@Override
	public void delete() {
		System.out.println("ɾ���û�UserManager��");
	}

	@Override
	public void update() {
		System.out.println("�޸��û�UserManager��");
	}

	@Override
	public void find() {
		System.out.println("�����û�UserManager��");
	}

}
