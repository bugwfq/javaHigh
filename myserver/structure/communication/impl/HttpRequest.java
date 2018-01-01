package structure.communication.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;

import structure.communication.Request;

public class HttpRequest implements Request{
	private BufferedReader br;
	private String httpFirstLine;
	private HashMap<String,String> users = new HashMap<>();
	public HttpRequest(){}
	public HttpRequest(Socket socket){
		try {
			br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String httpFirstLine = null;
		try {
			httpFirstLine = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.httpFirstLine = httpFirstLine;
		
	}
	@Override
	public String getUrl() {
		String url = httpFirstLine.split(" ")[1];
		if(!url.equals("/")){
			url = url.substring(1, url.length());
			if(url.contains(".do?")){
				String[] newUrl = url.split("\\?");
				String newUser = newUrl[1];
				loginUser(newUser);
				return newUrl[0];
			}else if(url.matches("(.+/.*)*.+\\..\\w+")){
				return url;
			}
		}
		return url;
	}
	private void loginUser(String str){
		String[] userStr = str.split("&");
		for(String u:userStr){
			String[] user = u.split("=");
			users.put(user[0], user[1]);
		}
	}
	@Override
	public String GetParameter(String key) {
		return users.get(key);
	}
}
