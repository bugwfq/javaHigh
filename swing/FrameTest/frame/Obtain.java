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
		Frame f = setFrame("��ȡ��Ϣ");
		
		
	}
	public static void set(Frame f){
		TextField txtwrite = new TextField(10);
		
		Button button1 = new Button("�ύ");
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
	//��������
	public static Frame setFrame(String frameName){
		//���ô���
		Frame f = new Frame(frameName);
		//���ô����С
		f.setSize(600,400);
		//���ò��ַ�ʽ
		f.setLayout(new FlowLayout());
		//��ȡλ�õĿ�
		int width = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-f.getWidth())/2);
		//��ȡλ�õĸ�
		int height = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-f.getHeight())/2);
		//����λ��
		f.setLocation(width, height);
		
		
		//���ô��ڹر��¼�
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				//���ô��ڹر�
				System.exit(0);
			}
		});
		set(f);
		f.setVisible(true);
		return f;
	}
}
