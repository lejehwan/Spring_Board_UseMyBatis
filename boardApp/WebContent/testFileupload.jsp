<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- testFileupload.jsp -->
<html>
<head>
	<title>파일업로드</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>파 일 업 로 드 테 스 트</h2>
		<hr color="green" width="300">
		<form name="f" action="fileupload.do" method="post" enctype="multipart/form-data">
			<table border="1" width="500">
				<tr>
					<th>올린이</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>파일명</th>
					<td><input type="file" name="filename"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="업로드">
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>







