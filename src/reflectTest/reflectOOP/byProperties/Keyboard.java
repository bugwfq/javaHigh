package reflectTest.reflectOOP.byProperties;
/**
 *ʵ��USB�ӿ�ʹ�����Ϊ����ϵ�е�һԱ
 * @author Administrator
 *
 */
public class Keyboard implements USB {

	@Override
	public void run() {
		System.out.println("��������");
	}

	@Override
	public void close() {
		System.out.println("���̹ر�");
	}

}
