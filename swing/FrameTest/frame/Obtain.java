package FrameTest.frame;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Obtain {
	public static void main(String[] args) {
		Frame f = setFrame("获取信息");
		
		
	}
	public static void set(Frame f){
		TextField txtwrite = new TextField(10);
		
		Button button1 = new Button("提交");
		button1.setSize(10,10);
		TextArea txt1 = new TextArea();
		txt1.setEditable(false);
		f.add(txtwrite);
		f.add(button1);
		f.add(txt1);
		txtwrite.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==(KeyEvent.VK_ENTER)){
					String text = txtwrite.getText();
					txtwrite.setText("");
					txtwrite.requestFocus();
					text +="\r\n";
					
					txt1.append(text);
					txt1.setVisible(true);
				}
			}
			
		});
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = txtwrite.getText();
				txtwrite.setText("");
				txtwrite.requestFocus();
				text +="\r\n";
				
				txt1.append(text);
				txt1.setVisible(true);
			}
		});
		
		
	}
	//创建窗体
	public static Frame setFrame(String frameName){
		//设置窗口
		Frame f = new Frame(frameName);
		//设置窗体大小
		f.setSize(600,400);
		//设置布局方式
		f.setLayout(new FlowLayout());
		//获取位置的宽
		int width = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-f.getWidth())/2);
		//获取位置的高
		int height = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-f.getHeight())/2);
		//设置位置
		f.setLocation(width, height);
		
		
		//设置窗口关闭事件
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				//设置窗口关闭
				System.exit(0);
			}
		});
		set(f);
		f.setVisible(true);
		return f;
	}
}
