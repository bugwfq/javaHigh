package FrameTest.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuBarTest {
	public static void main(String[] args) {
		Frame f = getFrame("�˵���");
	}
	public static void setMenuBar(Frame f){
		MenuBar mb1 = new MenuBar();
		Menu m1 = new Menu("�ļ�"); 
		Menu m2 = new Menu("�½�"); 
		Menu m3 = new Menu("���Ϊ"); 
		MenuItem mit = new MenuItem("�ļ�-zi");
		m1.add(m2);
		m1.add(m3);
		m1.add(mit);
		mb1.add(m1);
		f.setMenuBar(mb1);
	}
	//��������
	public static Frame getFrame(String frameName){
		Frame f = new Frame(frameName);
		//���ô��ڴ�С
		f.setSize(600, 800);
		//���ô���Ĳ���
		f.setLayout(new FlowLayout());
		//���ó��򵯿����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//��ȡ��Ļ�� ����
		Dimension screen = toolkit.getScreenSize();
		//��ȡ���������
		Dimension procedure = f.getSize();
		//����Ļ�Ŀ��ȥ����Ŀ����2  ��Ϊ����λ�õ�x
		int width = (int) ((screen.getWidth()-procedure.getWidth())/2);
		//����Ļ�ĸ߼�ȥ����ĸ߳���2 ��Ϊ����λ�õ�y
		int height = (int) ((screen.getHeight()-procedure.getHeight())/2);
		//���ó����λ��
		f.setLocation(width,height);
	
		//���ô��ڵĹر��¼�
		
		f.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				//���ô��ڹر�
				f.dispose();
			}
		});
		
		//���ô��ڵĿ��ӻ�    ���ӻ������ڶԴ��ڵ�����֮��
		setMenuBar(f);
		f.setVisible(true);
		
		return f;
	}
}
