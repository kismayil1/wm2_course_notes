<%@ page import = "java.util.*"%>

<html>
<head>
	<title>User Listing</title>
</head>
<body>
<h2>Welcome home, ${sessionScope.current_user}.</h2>
<%
   List<String> users =(List)session.getAttribute("user-list");
   for(String user : users){
   	out.println(user);
   }
   //comment
%>
	
</body>
</html>