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
		Frame f = window("这是一个窗口");
		setButton(f);
	}
	//设置按钮属性
	public static void setButton(Frame f){
		Button button1 = new Button("这是一个按钮");
		button1.setSize(20, 10);
		//按钮的普通事件
//		button1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				f.setBackground(Color.BLUE);
//			}
//		});
		//设计按钮的鼠标时间
		
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
	//设置窗体属性
	public static Frame window(String windowName){
		//创建一个窗口
		Frame f = new Frame(windowName);
		//设置窗口大小
		f.setSize(600, 800);
		//设置窗体的布局
		f.setLayout(new FlowLayout());
		//设置程序弹框居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//获取屏幕的 像素
		Dimension screen = toolkit.getScreenSize();
		//获取程序的像素
		Dimension procedure = f.getSize();
		//用屏幕的宽减去程序的宽除以2  作为程序位置的x
		int width = (int) ((screen.getWidth()-procedure.getWidth())/2);
		//用屏幕的高减去程序的高除以2 作为程序位置的y
		int height = (int) ((screen.getHeight()-procedure.getHeight())/2);
		//设置程序的位置
		f.setLocation(width,height);
	
		//设置窗口的关闭事件
		
		f.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				//设置窗口关闭
				f.dispose();
			}
		});
		
		//设置窗口的可视化    可视化必须在对窗口的设置之后
		f.setVisible(true);
		return f;
	}
}

