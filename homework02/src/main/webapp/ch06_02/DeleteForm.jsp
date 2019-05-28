<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab06_02 刪除會員</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body onload="javascript:document.insertMemberFormA.mId.focus();">
	<div class="allpage">
		<header>
		</header>
	</div>
	<form name="insertMemberFormA" action="delete.do" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center">刪除資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">ID:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="eId" value="${param.eId}"
						type="text" size="14">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.Id}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center">
						<input type="submit" value="送出">
						<input type="button" value="新增" onclick="location.href='/jspExercise/ch06_02/InsertMemberForm.jsp'">
						<input type="button" value="查詢資料" onclick="location.href='/jspExercise/ch06_02/SearchForm.jsp'"></td>
				</tr>
			</tbody>
		</table>
	
		<div style="color:#FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>

</body>
</html>