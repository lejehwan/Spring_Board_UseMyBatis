<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, board.dto.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>�Խñ�</title>
</head>
<body>
	<div align="center">
		<b>�� �� ��</b>
		<table border="0" width="800">
			<tr bgcolor="yellow">
				<td align="right"><a href="board_write.do">�۾���</a></td>
			</tr>
		</table>
		<table border="1" width="800">
			<tr bgcolor="green">
				<th>��ȣ</th>
				<th>����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ</th>
				<th>IP</th>
			</tr>
		<c:if test="${empty list }">
			<tr>
				<td colspan="6">�Խõ� ���� �����ϴ�.</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.num }</td>
				<td><a href="board_content.do?num=${dto.num }">${dto.subject }</a></td>
				<td>${dto.writer }</td>
				<td>${dto.reg_date }</td>
				<td>${dto.readcount }</td>
				<td>${dto.ip }</td>
			</tr>
		</c:forEach>	
		</table>
	</div>
</body>
</html>




