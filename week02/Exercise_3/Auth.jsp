<%@ page import = "myapp.bean.StudentBean" %> 

<jsp:useBean id="ate" scope="session" class="myapp.bean.StudentBean"> </jsp:useBean>


<jsp:getProperty  name="ate" property="name"/>
<jsp:getProperty name="ate" property="surname"/>