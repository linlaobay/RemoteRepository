<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertSuccess</title>
</head>
<body>
<h1>病例新增成功</h1>
編號:${ memberBean.id }<br>
年份: ${ memberBean.year }<br>
週數: ${ memberBean.week }<br>
類型: ${ memberBean.type }<br>
年齡: ${ memberBean.age }<br>
縣市: ${ memberBean.county }<br>
就診人數: ${ memberBean.visit }<br>
總就診人數: ${ memberBean.tatlevisits }<br>
<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center">
						<input type="button" value="新增" onclick="location.href='/jspExercise/ch06_02/InsertMemberForm.jsp'">
						<input type="button" value="刪除" onclick="location.href='/jspExercise/ch06_02/DeleteForm.jsp'">
						<input type="button" value="查詢" onclick="location.href='/jspExercise/ch06_02/SearchForm.jsp'">
						</td>
				</tr>
</body>
</html>