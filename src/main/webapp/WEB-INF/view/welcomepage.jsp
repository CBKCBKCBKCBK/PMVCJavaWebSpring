<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title>Insert title here</title>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/self/listuser.css">
<link rel="stylesheet" href="/css/jquery/jquery-ui.min.css">
<style type="text/css">
.custom-container{max-width: unset;}
.error-color{color:red}
.custom-align{display: inline;}
</style>
<script src="/js/jquery/jquery-3.5.1.min.js"></script>
</head>
<body style="background-color: white;
	background:url(/img/database_bg.jpg);
	opacity: 0.9;
	z-index: -999;
	background-position: center 0;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	background-color: white;">
<%--body--%>
<nav class="navbar navbar-expand-sm navbar-light bg-light" style="background-color: #e9ecef;">
  <a class="navbar-brand" href="/index">資料庫編輯系統</a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent" "><%--隱藏按鈕 --%>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/welcome">首頁 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/register">新增用戶</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/welcome">所有用戶</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/order/list">所有訂單</a>
      </li>
      <%--li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li--%>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<c:choose>
<c:when test="${mode=='MODE_HOME' }"><jsp:include page="features/listuser.jsp"/></c:when>
<c:when test="${mode=='MODE_REGISTER' }"><jsp:include page="features/adduser.jsp"/></c:when>
<c:when test="${mode=='MODE_UPDATE' }"><jsp:include page="features/updateuser.jsp"/></c:when>
<c:when test="${mode=='MODE_INDEX' }"><jsp:include page="features/welcome.jsp"/></c:when>
<c:when test="${mode=='MODE_ADDORDER' }"><jsp:include page="features/adduserorder.jsp"/></c:when>
<c:when test="${mode=='MODE_LISTORDER' }"><jsp:include page="features/listuserorder.jsp"/></c:when>
<c:when test="${mode=='MODE_UPDATEORDER' }"><jsp:include page="features/updateuserorder.jsp"/></c:when>
</c:choose>


<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<%--script type="text/javascript">
$(window).load(alert($(window).width()));
</script--%>
</body>
</html>