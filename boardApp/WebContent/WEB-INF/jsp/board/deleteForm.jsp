<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<div align="center">
	<b>�� �� ��</b>
	<form name="f" action="board_delete.do" method="post">
		<input type="hidden" name="num" value="${param.num }"/>
		<table border="1">
			<tr bgcolor="yellow">
				<th>��й�ȣ�� �Է��� �ּ���.</th>
			</tr>
			<tr>
				<td align="center">��й�ȣ : <input type="password" name="passwd"></td> 
			</tr>
			<tr bgcolor="yellow">
				<td>
					<input type="submit" value="�ۻ���">
					<input type="button" value="��Ϻ���" onClick="window.location='board_list.do'">
				</td>
			</tr>
		</table>
	</form>
</div>
