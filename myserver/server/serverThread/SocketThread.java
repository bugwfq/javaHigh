package server.serverThread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.Properties;

import structure.communication.Request;
import structure.communication.Response;
import structure.entity.Constant;
import structure.handle.Handle;

public class SocketThread extends Thread{
	private Socket socket;
	public SocketThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		Properties runClass = new Properties();
		try{
		runClass.load(new FileInputStream(new File(Constant.CONFIGURATION)));
		Class<?> requestClass = Class.forName(runClass.getProperty("request"));
		Class<?> responseClass = Class.forName(runClass.getProperty("response"));
		Class<?> handleClass = Class.forName(runClass.getProperty("handle"));
		Request request = null;
		Response response = null;
		try {
			request = (Request) requestClass.getConstructor(Socket.class).newInstance(socket);
			response = (Response) responseClass.getConstructor(Socket.class).newInstance(socket);
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		Handle handle = (Handle) handleClass.newInstance();
		handle.alternating(request, response);
		}catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
