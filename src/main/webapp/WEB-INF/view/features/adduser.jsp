<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container text-center"
	style="background-color: #e9ecef; padding: 0 0 100% 0; max-width: unset;">
	
	<h3>用戶註冊</h3>

	<div class="container" style="">
		<form:form action="saveuser" method="post" modelAttribute="user"
			class="form-horizontal">
			
			<input type="hidden" name="id" value="${user.id }">
			<div class="row form-group">
				<div class="col text-left align-self-start">帳號:</div>
				<form:input path="username" type="text" name="username"
					value="${user.username }" cssClass="form-control align-self-end"
					cssStyle="width:64rem;" />
				<%-- width: auto;display: flex;--%>
				<form:errors path="username" cssClass="error-color" />
			</div>
			<div class="row form-group">
				<div class="col text-left align-self-start">密碼:</div>
				<form:input path="pass" type="password" name="pass"
					value="${user.pass }" cssClass="form-control align-self-end"
					cssStyle="width:64rem;" />
				<form:errors path="pass" cssClass="error-color" />
			</div>

			<div class="row form-group">
				<div class="col text-left align-self-start">電子郵件:</div>
				<form:input path="email" type="email" name="email"
					value="${user.email }" cssClass="form-control align-self-end"
					cssStyle="width:64rem;" />
				<form:errors path="email" cssClass="error-color" />
			</div>

			<div class="row form-group">
				<div class="col text-left align-self-start">住址:</div>
				<form:input path="address" type="text" name="address"
					value="${user.address }" cssClass="form-control align-self-end"
					cssStyle="width:64rem;" />
				<form:errors path="address" cssClass="error-color" />
			</div>

			<div class="row form-group">
				<div class="col text-left align-self-start">電話:</div>
				<form:input path="phone" type="text" name="phone"
					value="${user.phone }" cssClass="form-control align-self-end"
					cssStyle="width:64rem;" />
				<form:errors path="phone" cssClass="error-color" />
			</div>

			<div class="row form-group">
				<div class="col text-left align-self-start">出生日期:</div>
				<form:input path="birthday" type="date" name="birthday"
					value="${user.birthday }" cssClass="form-control align-self-end datepicker"
					cssStyle="width:64rem;" onfocus="dateonclick();" 
					placeholder="yyyy-mm-dd (西元年份-月份-日期)"/>
				<form:errors path="birthday" cssClass="error-color" />
			</div>
			
			<div class="row">
				<div class="col">
					<input class="btn btn-primary" type="submit" value="註冊用戶">
				</div>
			</div>

		</form:form>
	</div>

</div>
<script src="js/jquery/jquery-ui.min.js"></script>
<script src="js/jquery/datepicker-zh-TW.js"></script>
<script src="js/self/datepicker.js"></script>