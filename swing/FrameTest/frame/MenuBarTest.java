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
		Frame f = getFrame("菜单栏");
	}
	public static void setMenuBar(Frame f){
		MenuBar mb1 = new MenuBar();
		Menu m1 = new Menu("文件"); 
		Menu m2 = new Menu("新建"); 
		Menu m3 = new Menu("另存为"); 
		MenuItem mit = new MenuItem("文件-zi");
		m1.add(m2);
		m1.add(m3);
		m1.add(mit);
		mb1.add(m1);
		f.setMenuBar(mb1);
	}
	//创建窗口
	public static Frame getFrame(String frameName){
		Frame f = new Frame(frameName);
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
		setMenuBar(f);
		f.setVisible(true);
		
		return f;
	}
}
