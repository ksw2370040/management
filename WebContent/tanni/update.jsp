<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
	<%@include file="menu.jsp"%>
</div>
<div class="border"></div>
<div class="main">
<!-- 学生情報更新フォーム -->
<form action="StudentUpdate.action" method="post">
<!-- 学生情報を表示・編集するためのループ -->
<c:forEach var="p" items="${list}">
	<!-- 学生IDを隠した状態で送信 -->
	<input id="radius" type="hidden" name="student_id" value="${p.student_id}" required>
	<!-- 学生名の入力欄 -->
	お名前  :<input id="radius" type="text" name="student_name" value="${p.student_name}" required><br>
	<!-- コース名の選択 -->
	コース名:<select id="radius" name="course_id" required>
		<option value="1" <c:if test="${p.course_id == '1'}">selected</c:if>>システム開発</option>
		<option value="2" <c:if test="${p.course_id == '2'}">selected</c:if>>AIシステム・データサイエンス</option>
	</select><br>
</c:forEach>
	<!-- 送信ボタン -->
	<input id="radius" id="button" type="submit" value="送信">
</form>
</div>
<%@ include file="../footer.html" %>
