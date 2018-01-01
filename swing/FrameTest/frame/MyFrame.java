package FrameTest.frame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame {
	public static void main(String[] args) {
		Frame f = window("����һ������");
		setButton(f);
	}
	//���ð�ť����
	public static void setButton(Frame f){
		Button button1 = new Button("����һ����ť");
		button1.setSize(20, 10);
		//��ť����ͨ�¼�
//		button1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				f.setBackground(Color.BLUE);
//			}
//		});
		//��ư�ť�����ʱ��
		
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				f.setBackground(Color.BLUE);
			}
		});
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				f.setBackground(Color.red);
			}
		});
		f.add(button1);
	}
	//���ô�������
	public static Frame window(String windowName){
		//����һ������
		Frame f = new Frame(windowName);
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
		f.setVisible(true);
		return f;
	}
}

