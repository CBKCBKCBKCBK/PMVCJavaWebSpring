<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container text-center"
	style="background-color: #e9ecef; padding: 0 0 100% 0; max-width: unset;">
	<h3>新增訂單</h3>

	<div class="container">
		<form:form action="saveorder" method="post" modelAttribute="order"
			class="form-horizontal">
			
			<input type="hidden" name="id" value="${order.order_id }">
			<div class="row form-group">
				<div class="col text-left align-self-start">使用者ID:</div>
				<form:input path="id_user" type="text" name="userid" readonly="true"
					value="${order.id_user.id }" cssClass="form-control align-self-end"
					cssStyle="width:64rem;" />
				
				<form:errors path="id_user.id" cssClass="error-color" />
			</div>
			<div class="row form-group">
				<div class="col text-left align-self-start">商品名稱:</div>
				<form:input path="orderName" type="text" name="orderName"
					value="${order.orderName }" cssClass="form-control align-self-end"
					cssStyle="width:64rem;" />
				<form:errors path="orderName" cssClass="error-color" />
			</div>

			<div class="row form-group">
				<div class="col text-left align-self-start">訂購日期:</div>
				<form:input path="orderDate" type="date" name="orderDate"
					value="${order.orderDate }" cssClass="form-control align-self-end datepicker"
					cssStyle="width:64rem;"
					placeholder="yyyy-mm-dd (西元年份-月份-日期)"/>
				<form:errors path="orderDate" cssClass="error-color" />
			</div>
			<div class="row">
				<div class="col">
					<input class="btn btn-primary" type="submit" value="新增訂單">
				</div>
			</div>

		</form:form>
	</div>

</div>
<script src="/js/jquery/jquery-ui.min.js"></script>
<script src="/js/jquery/datepicker-zh-TW.js"></script>
<script src="/js/self/datepicker.js"></script>