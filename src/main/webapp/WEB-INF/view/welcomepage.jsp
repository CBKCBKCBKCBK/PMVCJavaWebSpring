<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="welcomepage/header.jsp"></jsp:include>
</head>
<body>
	
<nav class="navbar navbar-expand-sm navbar-light bg-light">
  <a class="navbar-brand" href="/index">資料庫編輯系統</a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent"><%--隱藏按鈕 --%>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/listuser">首頁 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/adduser">新增用戶</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/listuser">所有用戶</a>
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

<%--c:choose>
<c:when test="${mode=='MODE_HOME' }"><jsp:include page="features/listuser.jsp"/></c:when>
<c:when test="${mode=='MODE_REGISTER' }"><jsp:include page="features/adduser.jsp"/></c:when>
<c:when test="${mode=='MODE_UPDATE' }"><jsp:include page="features/updateuser.jsp"/></c:when>
<c:when test="${mode=='MODE_INDEX' }"><jsp:include page="features/welcome.jsp"/></c:when>
<c:when test="${mode=='MODE_ADDORDER' }"><jsp:include page="features/adduserorder.jsp"/></c:when>
<c:when test="${mode=='MODE_LISTORDER' }"><jsp:include page="features/listuserorder.jsp"/></c:when>
<c:when test="${mode=='MODE_UPDATEORDER' }"><jsp:include page="features/updateuserorder.jsp"/></c:when>
</c:choose--%>
<jsp:include page="${location }"></jsp:include>

<jsp:include page="welcomepage/footer.jsp"></jsp:include>
</body>
</html>