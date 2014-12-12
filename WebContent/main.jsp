<html>
<head>
<title>Using GET and POST Method to Read Form Data</title>
</head>
<body>
<h1>Using GET Method to Read Form Data</h1>
<ul>
<li><p><b>First Name:</b>
   <%= request.getParameter("name")%>
</p></li>
<li><p><b>Last  Name:</b>
   <%= request.getParameter("surname")%>
</p></li>
</ul>
</body>
</html>