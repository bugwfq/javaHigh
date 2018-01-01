package reflectTest.reflectOOP.byProperties;
/**
 *实现USB接口使该类成为该体系中的一员
 * @author Administrator
 *
 */
public class Keyboard implements USB {

	@Override
	public void run() {
		System.out.println("键盘运行");
	}

	@Override
	public void close() {
		System.out.println("键盘关闭");
	}

}
