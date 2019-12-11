<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<jsp:include page="/WEB-INF/views/layout/headerMain.jsp"></jsp:include>


<script type="text/javascript">
$(document).ready(btnhandler);

function btnhandler() {
	$(".btnRandonMenu").on("click", execajax);
}

function execajax() {
	$.ajax({
		type: "GET"
		, url: "/random/menu"
		, dataType: "html"
		, success: function(data){
			console.log("성공");

			$("#resultLayout").html(data);
			btnhandler();
		}
		, error: function(){
			console.log("실패");
		}
	})
}
</script>


<style type="text/css">
#searchbox {
	width: 500px;
}
.thumbnail{
	height: 300px; 
}
.thumbnail img{ 
	height: 200px;  
	margin-top: 10px;
}
.caption p {
	text-align: right;
}
</style>

<%-- <c:if test="${not empty login }"> --%>
<%-- <a href="/mypage/myrecipe?userno=${userno }"><button>마이페이지</button></a> --%>
<%-- </c:if> --%>

<!-- <div class="searchDiv"> -->
<!-- 	<form action="/recipe/list" method="get"> -->
<!-- 		<select name="condition"> -->
<!-- 			<option value="name">제목</option> -->
<!-- 			<option value="ingredient">재료</option> -->
<!-- 		</select> -->
<!-- 		<input type="text" id="search" name="search"/> -->
<!-- 		<button id="btnSearch">검색</button> -->
<!-- 	</form> -->
<!-- </div> -->
<br>	

<div>
<a href="/recipe/list"><button class="btn">목록</button></a>
&nbsp;
<a href="recipe/reg"><button class="btn">레시피등록</button></a>
</div>

<br>
<div id="resultLayout" style="text-align: center;">
<input type="button" class="btnRandonMenu btn" value="오늘의 메뉴"/>
</div>

<br>

<div id="todaysMenu">
<!-- <table style="text-align: center; margin: auto;"> -->
<!-- <tr> -->
<%-- <c:forEach var="menu" items="${todaysmenu }" varStatus="status"> --%>
<%-- 	<td><img src="${menu.recipic }" style="margin:15px;" width="300px" height="200px"></td> --%>
<%-- </c:forEach> --%>
<!-- </tr> -->
<!-- <tr> -->
<%-- <c:forEach var="menu" items="${todaysmenu }" varStatus="status"> --%>
<%-- 	<td style="text-align: center"><p><a href="/recipe/view?recipeno=${menu.recipeno }">${status.count }등: ${menu.recipename }</a></p></td> --%>
<%-- </c:forEach> --%>
<!-- </tr> -->
<!-- </table> -->

<div><h1 style="text-align: center;
    background-color: #afd485;
    padding: 15px;
    color: white;
    font-weight: bolder;">오늘의 추천 레시피</h1></div>

<br>
<div class="row">
<c:forEach items="${todaysmenu }" var="recipe">
  <div class="col-sm-6 col-md-4" onclick="location.href='/recipe/view?recipeno=${recipe.recipeno }'">
    <div class="thumbnail" style="height: 350px">
	    <c:choose>
	    	<c:when test="${recipe.recipic ne '/upload/null'}">
			<img src="${recipe.recipic }">
			</c:when>
	    	<c:when test="${recipe.recipic eq '/upload/null'}">
			<img src="/upload/default.jpg">
			</c:when>
		</c:choose>
      <div class="caption">
        <h3>${recipe.recipename }</h3>
        <p>by. ${recipe.nick }</p>        
      </div>
    </div>
  </div>
</c:forEach>
</div>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>