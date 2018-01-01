package structure.handle;

import structure.communication.Request;
import structure.communication.Response;

public interface Handle {
	void alternating(Request request,Response response);
}
