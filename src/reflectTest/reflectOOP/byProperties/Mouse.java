package reflectTest.reflectOOP.byProperties;
/**
 *实现USB接口使该类成为该体系中的一员
 * @author Administrator
 *
 */
public class Mouse implements USB{

	@Override
	public void run() {
		System.out.println("运行鼠标");
	}

	@Override
	public void close() {
		System.out.println("关闭鼠标");
	}

}
