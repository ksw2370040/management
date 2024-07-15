<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="menu">
    <%@ include file="menu.jsp" %>
</div>
<div class="border"></div>
<div class="main">
データを更新する学生を選んでください
<form action="StudentUpdateSelect.action" method="post">
	<select id="radius" name="student_name" required>
	<option value=""></option>
		<c:forEach var="p" items="${list}">
			<option value="${p.student_name}">${p.student_name}</option>
		</c:forEach>
	</select><br>
<input id="radius" type="submit" value="送信">
</form>
</div>
<%@include file="../footer.html" %>
