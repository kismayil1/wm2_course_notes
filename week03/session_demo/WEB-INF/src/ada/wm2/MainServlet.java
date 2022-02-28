package ada.wm2;

import javax.servlet.*;  
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class MainServlet extends HttpServlet{

	private static List<String> users = new ArrayList<>();

	static{
		users.add("Ali");
		users.add("John");
		users.add("Nargiz");
		users.add("Mahammad");
		users.add("Sveta");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try{
		PrintWriter pw = res.getWriter();

		pw.write("<html><body>Welcome!</body></html>");
	}catch(IOException ex){  
		System.out.println(ex);
	}
	}
}

