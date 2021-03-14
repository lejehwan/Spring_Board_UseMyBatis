<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<div align="center">
	<b>글 삭 제</b>
	<form name="f" action="board_delete.do" method="post">
		<input type="hidden" name="num" value="${param.num }"/>
		<table border="1">
			<tr bgcolor="yellow">
				<th>비밀번호를 입력해 주세요.</th>
			</tr>
			<tr>
				<td align="center">비밀번호 : <input type="password" name="passwd"></td> 
			</tr>
			<tr bgcolor="yellow">
				<td>
					<input type="submit" value="글삭제">
					<input type="button" value="목록보기" onClick="window.location='board_list.do'">
				</td>
			</tr>
		</table>
	</form>
</div>
