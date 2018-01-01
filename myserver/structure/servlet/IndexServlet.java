package structure.servlet;

import java.io.BufferedOutputStream;
import java.io.File;

public class IndexServlet implements ServletInterfaces{
	private File file;
	public IndexServlet(File file){
		this.file = file;
	}
	@Override
	public void writer(BufferedOutputStream ot) {
		
		ResponseMode servlet = new ResponseMode(file);
		servlet.writer(ot);
	}

}
