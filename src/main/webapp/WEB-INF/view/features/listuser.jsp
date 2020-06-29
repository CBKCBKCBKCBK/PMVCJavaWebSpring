<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<div class="container text-center" id="taskDiv" style="background-color: #e9ecef; padding: 0px 0px 100% 0px;max-width: unset;">
<%--  --%>
	<h3>所有使用者</h3>
	<hr>
	<div class="table-responsive">

		<table class="table">
			<thead>
				<tr style="">
					<th>ID</th>
					<th>帳號名稱</th>
					<th>電子郵件</th>
					<th>地址</th>
					<th>電話</th>
					<th>生日</th>
					</tr><tr>
					<th>建立日期</th>
					<th>修改日期</th>
					<th>修改</th>
					<th>刪除</th>
					<th>新增訂單</th>
					<th>修改訂單</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users }">
					<tr>
						<td>${user.id }</td>
						<td>${user.username }</td>
						<td>${user.email }</td>
						<td>${user.address }</td>
						<td>${user.phone }</td>
						<td><fmt:formatDate value="${user.birthday }" pattern="yyyy年MM月dd日"/></td>
						</tr><tr>
						<td><fmt:formatDate value="${user.timeBuild }" pattern="yyyy年MM月dd日"/><br>
						<fmt:formatDate value="${user.timeBuild }" pattern="hh時mm分ss秒"/></td>
						<td><fmt:formatDate value="${user.timeModify }" pattern="yyyy年MM月dd日"/><br>
						<fmt:formatDate value="${user.timeModify }" pattern="hh時mm分ss秒"/></td>
						<td><form action="update" method="post">
						<input type="hidden" name="id" value="${user.id }">
						<button class="btn btn-warning" type="submit">編輯</button></form></td>
						<td><form action="deleteuser" method="post">
						<input type="hidden" name="id" value="${user.id }">
						<button class="btn btn-danger" type="submit">刪除</button></form></td>
						<td><form action="order/add" method="post">
						<input type="hidden" name="id" value="${user.id }">
						<button class="btn btn-success" type="submit">新增訂單</button></form></td>
						<td><form action="order/queryorder" method="post">
						<input type="hidden" name="id" value="${user.id }">
						<button class="btn btn-warning" type="submit">修改訂單</button></form></td>
					</tr>
					<tr><td></td><td></td><td></td>
				<td class="error-color"><c:if test="${user.id == deleteid && not empty foreignerror }">${foreignerror }</c:if></td></tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script src="js/self/listuser.js"></script>
