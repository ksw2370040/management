<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
	<%@include file="menu.jsp"%>
</div>
<div class="border"></div>
<div class="main">
<!-- 学生情報追加フォーム -->
<form action="StudentAdd.action" method="post">
	<!-- 学生番号入力欄 -->
	学生番号:<input id="radius" type="text" name="student_id" required><br>
	<!-- 学生名入力欄 -->
	学生名  :<input id="radius" type="text" name="student_name" required><br>
	<!-- コース選択 -->
	コース名:<select id="radius" name="course_id" required>
		<option value="">選択してください</option>
		<option value="1">システム開発</option>
		<option value="2">AIシステム・データサイエンス</option>
	</select><br>
	<!-- 送信ボタン -->
	<input id="radius" type="submit" value="送信">
</form>
</div>
<%@ include file="../footer.html" %>
