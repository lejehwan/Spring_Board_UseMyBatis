<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.dto.*"%>
<html>
<head>
	<title>�۳���</title>
</head>
<body>
<div align="center">
	<b>�۳��� ����</b><br><br>
	<table border="1" width="600">
		<tr>
			<th bgcolor="yellow" width="20%">�۹�ȣ</th>
			<td align="center">${getBoard.num }</td>
			<th bgcolor="yellow" width="20%">��ȸ��</th>
			<td align="center">${getBoard.readcount }</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�ۼ���</th>
			<td align="center">${getBoard.writer }</td>
			<th bgcolor="yellow" width="20%">�ۼ���</th>
			<td align="center">${getBoard.reg_date }</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">������</th>
			<td align="left" colspan="3">${getBoard.subject }</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�̸���</th>
			<td align="left" colspan="3">${getBoard.email }</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�۳���</th>
			<td align="left" colspan="3">${getBoard.content }</td>
		</tr>
    	<tr>
			<td colspan="4" align="right" bgcolor="yellow">
				<input type="button" value="�ۼ���" 
				onclick="window.location='board_update.do?num=${getBoard.num }'" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="�ۻ���" 
				onclick="window.location='board_delete.do?num=${getBoard.num }'">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="�۸��" 
				onclick="window.location='board_list.do'">
			</td>
		</tr> 
	</table>
</div>    



















