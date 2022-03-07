<%@ page import="myapp.bean.*"%> 
<jsp:useBean id="st" scope="session" class="myapp.bean.StudentBean"> </jsp:useBean>
<%
    st.setName(request.getParameter("name"));
    st.setSurname(request.getParameter("surname"));

 %>
<jsp:setProperty name="st" property="ID" value ="12"/>

<jsp:useBean id="ate" scope="session" class="myapp.bean.StudentBean"> </jsp:useBean>
<jsp:setProperty name="ate" property="name" value ="Otherly"/>
<jsp:setProperty name="ate" property="surname" value ="Guysson"/>
<jsp:setProperty name="ate" property="ID" value ="12"/>

Hello,

<jsp:getProperty name="st" property="name"/>
<jsp:getProperty name="st" property="surname"/>
<br>
<a href="./Auth.jsp">The other guy</a>
<br>
<br>
<a href="./index.html"> back </a>