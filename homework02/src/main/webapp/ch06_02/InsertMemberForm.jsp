<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>病例資料</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>

<body onload="javascript:document.insertMemberFormA.mId.focus();">
<!-- 	<form name="insertMemberFormA" action="member.do" method="POST"> -->
	<form name="insertMemberFormA" action="<c:url value='member.do' />" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center">新增病例資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">編號:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="eId" value="${param.eId}" type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.Id}</div>
					</td>	
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">年份:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="eyear" value="${param.eyear}" type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.year}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">週數:</td>
					<td width="600" height="40" align="left"><input name="eweek" value="${param.eweek}"
						type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.week}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">類型:</td>
					<td width="600" height="40" align="left"><input
						name="etype" value="${param.etype}" type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.type}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">年齡:</td>
					<td width="600" height="40" align="left"><input
						name="eage" value="${param.eage}" type="text" size="14">
						<div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.age}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">縣市:</td>
					<td width="600" height="40" align="left"><input
						name="ecounty" value="${param.ecounty}" type="text" size="14">
						<div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.county}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">就診人數:</td>
					<td width="600" height="40" align="left"><input name="evisit" value="${param.evisit}"
						type="text" size="14">
						<div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.visit}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">總就診人數:</td>
					<td width="600" height="40" align="left"><input name="etatlevisits" value="${param.etatlevisits}"
						type="text" size="14">
						<div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.tatlevisits}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center">
						<input type="submit" value="新增">
						<input type="button" value="刪除" onclick="location.href='/jspExercise/ch06_02/DeleteForm.jsp'">
						<input type="button" value="查詢" onclick="location.href='/jspExercise/ch06_02/SearchForm.jsp'">
						</td>
				</tr>

			</tbody>
		</table>
		<div style="color:#FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>
</body>
</html>