package reflectTest.proxyByInvocationHandlerTest;
/**
 * 实现ManagerInterface接口
 * @author Administrator
 *
 */
public class UserManager implements ManagerInterface{

	@Override
	public void add() {
		System.out.println("添加用户UserManager！");
	}

	@Override
	public void delete() {
		System.out.println("删除用户UserManager！");
	}

	@Override
	public void update() {
		System.out.println("修改用户UserManager！");
	}

	@Override
	public void find() {
		System.out.println("查找用户UserManager！");
	}

}
