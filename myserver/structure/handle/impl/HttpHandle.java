package structure.handle.impl;

import structure.communication.Request;
import structure.communication.Response;
import structure.handle.Handle;

public class HttpHandle implements Handle{

	@Override
	public void alternating(Request request, Response response) {
		String url = request.getUrl();
		response.response(url);
	}
	
}
