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
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if("admin".equals(username) && "admin".equals(password)){

			HttpSession session = req.getSession();
			session.setAttribute("current_user", username);
			session.setAttribute("user_list", users);
		
		try{
			RequestDispatcher disp = req.getRequestDispatcher("user.jsp");
			disp.forward(req,res);
	}catch(Exception ex){  
		System.out.println("Forward failed: " + ex);
	}
	}
	else{

		try{
			res.sendRedirect("index.html");
		}catch(Exception ex){
			System.out.println("Redirect failed: " + ex);
		}		
}
