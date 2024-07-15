<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="menu">
    <%@ include file="menu.jsp" %>
</div>
<div class="border"></div>
<div class="main">
<!-- データ削除フォーム -->
データを削除する学生を選んでください。
<form action="StudentDelete.action" method="post">
	<!-- 学生名選択 -->
	<select id="radius" id="radius" name="student_name" required>
	<!-- 初期値 -->
		<option value=""></option>
		<!-- 学生名リスト -->
		<c:forEach var="p" items="${list}">
			<option value="${p.student_name}">${p.student_name}</option>
		</c:forEach>
	</select><br>
<!-- 送信ボタン -->
	<input id="radius" type="submit" value="送信">
</form>
</div>
<%@include file="../footer.html" %>
