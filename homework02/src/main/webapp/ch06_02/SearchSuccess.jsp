<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
<link rel="stylesheet" href="st1.css">
<style>
form {
	margin: 0 auto;
	width: 1020px;
}
</style>
</head>
<body>
	<div class="allpage">
		<header>
		</header>
	</div>
	<form name="insert" action="#" method="POST">
		<span
			style="font-size: 1em; text-align: center; display: -moz-inline-box; display: inline-block; width: 1020px;">${SearchInfo}</span>
			<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center">
						<input type="button" value="新增" onclick="location.href='/jspExercise/ch06_02/InsertMemberForm.jsp'">
						<input type="button" value="刪除" onclick="location.href='/jspExercise/ch06_02/DeleteForm.jsp'">
						<input type="button" value="查詢" onclick="location.href='/jspExercise/ch06_02/SearchForm.jsp'">
						</td>
				</tr>
		<br>
		<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>
</body>
</html>