package xml.dom4j;

import java.util.Scanner;

public class MainTest {
	private static Scanner input = new Scanner(System.in);
	private static dom4jTest dom = new dom4jTest();
	public static void main(String[] args) {
		
		while(true){
			System.out.println("��ѡ��1.���   2.ɾ��  3.�޸�  4.���ҵ���  5.�鿴�û��б�  0.�˳�");
			int menu = input.nextInt();
			if(menu == 1){
				dom.add();
			}else if(menu == 2){
				dom.delete();
			}else if(menu == 3){
				dom.update();
			}else if(menu == 4){
				dom.find();
			}else if(menu == 5){
				dom.userList();
			}else{
				System.exit(0);
			}
		}
	}
}
