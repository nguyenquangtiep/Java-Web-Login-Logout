<html>
<%@ include file="header.jsp"%>
<body>
<h2>Image Uploading example in JSP and Servlet</h2>
<form action="<%=request.getContextPath()%>/ImageUploadCTL" enctype="multipart/form-data" method="post">
  <input type="file" id="myFile" name="filename" multiple>
  <input type="submit">
</form>
</body>
<%@ include file="footer.jsp"%>
</html>