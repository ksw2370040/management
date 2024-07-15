<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
	<%@include file="menu.jsp"%>
</div>
<div class="border"></div>
<div class="main">
	<table border="1">
		<tr>
			<th>学生番号</th>
			<th>学生名</th>
			<th>コース名</th>
		</tr>
		<!-- 学生情報のリストを表示 -->
		<c:forEach var="p" items="${list}">
			<tr>
				<td>${p.student_id}</td>
				<td>${p.student_name}</td>
				<td>${p.course_name}</td>
			</tr>
		</c:forEach>
	</table>
<!-- Topページへのリンク -->
<a href="index.jsp">Topページへ</a>
</div>
<%@ include file="../footer.html" %>
