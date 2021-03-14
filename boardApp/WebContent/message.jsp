<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- message.jsp -->
<%
	String url = (String)request.getAttribute("url");
	String msg = (String)request.getAttribute("msg");
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>