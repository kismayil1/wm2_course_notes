<%@ page import = "ada.wm2.helper.Counter" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Greetings!</title>
</head>
<body>
	<h2>Welcome</h2>
<b> You are the visitor no
	<%
	out.print(Counter.getCount());
    %>
 ! </b>

</body>
</html>