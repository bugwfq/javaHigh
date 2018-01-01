package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.serverThread.SocketThread;

public class Server {
	public static void main(String[] args){
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9999);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("������������");
		ExecutorService executor = Executors.newFixedThreadPool(10);
		while(true){
			Socket s;
			try {
				s = ss.accept();
				System.out.println(s+"���ӳɹ�");
				executor.submit(new SocketThread(s));
				System.out.println("������ϣ�");
			
			} catch (Exception e) {
				
			
				try {
					ss.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
		}
	}
}
