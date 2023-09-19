<%@page import="javawebapplication.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>

<%=ServletUtility.getSuccessMessage(request) %>

<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Login</th>
			<th scope="col">Date Of Birth</th>
			<th scope="col">Mobile No</th>
			<th scope="col">Action</th>
		</tr>
	</thead>
	<tbody>
		<%
			int index=1;
			List list=ServletUtility.getList(request);
			Iterator it=list.iterator();
			while(it.hasNext()){
			UserBean user=(UserBean)it.next();
		%>
		<tr>
			<th scope="row"><%=user.getId() %></th>
			<td><%=user.getFirstName() %></td>
			<td><%=user.getLastName() %></td>
			<td><%=user.getLogin() %></td>
			<td><%=user.getDob() %></td>
			<td><%=user.getMobileNo() %></td>
			<td><a href="UserCTL?id=<%=user.getId()%>">Edit</a></td>
			<td><a href="UserListCTL?id=<%=user.getId()%>">Delete</a></td>
		</tr>
		<%} %>
	</tbody>
</table>
<%@ include file="footer.jsp"%>