<%
	request.getSession().getAttribute("admin");
	request.getSession().invalidate();
	response.sendRedirect("index.jsp");
%>