<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/layout/headerAdmin.jsp"></jsp:include><br>

<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	//게시글 삭제
	$(".btndelete").click(function(){
		
 		if (confirm('게시물을 삭제 할까요?')){
		$(location).attr("href", "/adminrecipe/delete?recipeno=" + $(this).data("recipeno"));
 		}
	})
	
});
</script>

<style type="text/css">
table, th {
	text-align: center;
}

tr td:nth-child(2) {
	text-align: center;
}

.table>tbody>tr>td {
	padding: 10px;
	line-height: 1.428571;
	vertical-align: top;
	border-top: 1px solid #ccc;
}

.thumbnail {
	margin-bottom: 0px;
}

#main, #notice, #profile {
 	border:1px #e9e9e9 solid; 
	background-color:white;
	width: 250px;
	padding: 15px;

}

#list {
	border:1px #e9e9e9 solid;
	background-color:white;
	width: 500px;
	
}

</style>
<body style="background-color: #f1f1f1;">

	<div class="container">
		<div class="row">
			<div id="profile" class="col-md-3" style="text-align: center;">
				<div id="profile">
					<img width="200px" height="200px" src="${member.userpic }"
						class="img-circle">
				</div>
				<br>
				<h3>${member.userid }</h3>
				<br> <br>
				<p>'${member.usercom }'</p>
				<br>
				<div id="main" style="background-color:#afd485;">
					<a onclick="location.href='/admin/admain'"
						style="font-size: large; color: black; cursor: pointer; ">메인</a>
				</div>
				<br>
				<div id="notice" style="background-color: #82c2ff;">
					<a
						onclick="location.href='/adminnotice/list?userno=${member.userno }'"
						style="font-size: large; color: black; cursor: pointer;">알림</a>
				</div>
				
			</div>

			
			<div class="col-md-8" id="list">
			<br><br>
				<table class="table table-hover">


					<c:forEach items="${list }" var="i">
						<tr >
							<td width="200px"><img class="thumbnail" width="200px"
								height="200px" src="${i.recipic }"></td>
							<td onclick="location.href='/recipe/view?recipeno=${i.recipeno }'" style="cursor:pointer"><h4>${i.recipename }</h4></td>
							
							<td><button id="btndelete" class="btn btndelete" data-recipeno="${i.recipeno }"
										style="background-color:#FA5858">삭제</button>
							</td>
						</tr>
					</c:forEach>

				</table>
				<jsp:include page="/WEB-INF/views/admin/recipe/recipe_paging.jsp" />

			</div>




		</div>
		<!-- row -->


	</div>



</body>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>