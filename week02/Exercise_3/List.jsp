<%@ page import="myapp.bean.*"%> 
<jsp:useBean id="st" scope="session" class="myapp.bean.StudentBean"> </jsp:useBean>
<jsp:setProperty name="st" property="name" value ="Lazim"/>
<jsp:setProperty name="st" property="surname" value ="Geldi"/>
<jsp:setProperty name="st" property="ID" value ="12"/>

<a href="./Auth.jsp">hello</a>