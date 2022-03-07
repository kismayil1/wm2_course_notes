<%@ page import = "myapp.bean.StudentBean" %> 
<% 

StudentBean st = (StudentBean) session.getAttribute("loginBean");

%>

Hello, <% out.print(st.getName());
out.print(" ");
out.print(st.getSurname()); %>