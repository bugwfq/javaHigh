package reflectTest.reflectOOP.byProperties;

public class 耳机 implements USB{

	@Override
	public void run() {
		System.out.println("插入耳机");
	}

	@Override
	public void close() {
		System.out.println("拔出耳机");
		
	}

}
