<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<div class="container text-center" id="taskDiv" style="background-color: #e9ecef; padding: 0px 0px 100% 0px;max-width: unset;">
	<h3>所有訂單</h3>
	<hr>
	<div class="table-responsive">

		<table class="table">
			<thead>
				<tr style="">
					<th>ID</th>
					<th>使用者ID</th>
					<th>訂單名稱</th>
					<th>訂購日期</th>
					<th>建立日期</th>
					<th>修改日期</th>
					<th>修改訂單</th>
					<th>刪除訂單</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders }">
					<tr>
						<td>${order.order_id }</td>
						<td>${order.id_user.id }</td>
						<td>${order.orderName }</td>
						<td><fmt:formatDate value="${order.orderDate }" pattern="yyyy年MM月dd日"/></td>
						<td><fmt:formatDate value="${order.timeBuild }" pattern="yyyy年MM月dd日"/><br>
						<fmt:formatDate value="${order.timeBuild }" pattern="hh時mm分ss秒"/></td>
						<td><fmt:formatDate value="${order.timeModify }" pattern="yyyy年MM月dd日"/><br>
						<fmt:formatDate value="${order.timeModify }" pattern="hh時mm分ss秒"/></td>
						<td><form action="update" method="post">
						<input type="hidden" name="id" value="${order.order_id }">
						<button class="btn btn-warning" type="submit">編輯</button></form></td>
						<td><form action="delete" method="post">
						<input type="hidden" name="id" value="${order.order_id }">
						<button class="btn btn-danger" type="submit">刪除</button></form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script src="js/self/listuser.js"></script>