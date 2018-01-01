package structure.servlet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import structure.entity.Constant;
/**
 * ���ͻ��˵���Ӧҳ��
 * @author Administrator
 *
 */
public class ResponseMode implements ServletInterfaces{
	
	private File file;
	private FileInputStream in;
	public ResponseMode(File file) {
		this.file = file;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void writer(BufferedOutputStream out) {
		if(file.isFile()){
			//��ȡ���ļ���չ��
			String fileName = file.getName();
			fileName = fileName.substring((fileName.lastIndexOf(".")+1), fileName.length());
			if(fileName.endsWith("jpg")||fileName.endsWith("gif")||fileName.endsWith("png")||fileName.endsWith("jpeg")||fileName.endsWith("ico")){
				String format = "image/"+fileName;
				try {
					out.write(general(format));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				Properties pro = new Properties();
				try {
					pro.load(new FileInputStream(new File(Constant.CONFIGURATION)));
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				String notfound = pro.getProperty("notfound");
				String format = "text/"+fileName;
				if(file.getName().equals(notfound)){
					try {
						out.write(notfound(format));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					//�����ļ�����������ĸ�ʽ
					try {
						out.write(general(format));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		//��Ӧ��Ӧ��ҳ��
		content(out);
		
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void content(BufferedOutputStream out) {
		
		//��ȡ�ļ��е����ݲ����ͻ�����Ӧ
		int length = 0;
		byte[] message = new byte[1024*1024*3];
		
		try {
			while((length = in.read(message))!= -1){
				
				out.write(message,0,length);
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	private byte[] general(String format){
		//�����ļ������ļ���ʽ������Ӧ
		String message = "HTTP/1.1 200 OK\r\nContent-Type:"+format+"\r\nConent-Length: "+file.length()+"\r\n\r\n";
		
		return message.getBytes();
	}
	private byte[] notfound(String format){
		//�����ļ������ļ���ʽ������Ӧ
		String message = "HTTP/1.1 404 file not found\r\nContent-Type:"+format+"\r\nConent-Length: "+file.length()+"\r\n\r\n";
		
		return message.getBytes();
	}
	
	
}
