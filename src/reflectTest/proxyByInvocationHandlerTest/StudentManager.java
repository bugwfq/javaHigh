package reflectTest.proxyByInvocationHandlerTest;

public class StudentManager implements ManagerInterface {

	@Override
	public void add() {
		System.out.println("添加学生StudentManager");
	}

	@Override
	public void delete() {
		System.out.println("删除学生StudentManager");
	}

	@Override
	public void update() {
		System.out.println("修改学生StudentManager");
	}

	@Override
	public void find() {
		System.out.println("查找学生StudentManager");
	}

}
