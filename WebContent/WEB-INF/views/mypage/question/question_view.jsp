<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp"/>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#btnList').click(function(){
		
		$(location).attr('href', '/mypage/question');
	})
	
	$('#btnDel').click(function(){
		
		$(location).attr('href', '/mypage/question/delete?questionno=${question.questionno}');
	})
	
	//알림 색상 변경
	$('#notice').mouseenter(function(){
		
		$(this).css('background', '#EEE')
		
	});
	$('#notice').mouseleave(function(){
		
		$(this).css('background', '#FFFFFF')
		
	});
	
	
	//문의 색상 변경
	$('#myrecipe').mouseenter(function(){
		
		$(this).css('background', '#EEE')
		
	});
	$('#myrecipe').mouseleave(function(){
		
		$(this).css('background', '#FFFFFF')
		
	});
	
	
	//스크랩 색상 변경
	$('#scrap').mouseenter(function(){
		
		$(this).css('background', '#EEE')
		
	});
	$('#scrap').mouseleave(function(){
		
		$(this).css('background', '#FFFFFF')
		
	});
	
	//행 색상 변경
	$('tr').mouseenter(function(){
		
		$(this).find('#name').css('background', '#EEE')
		
	});
	$('tr').mouseleave(function(){
		
		$(this).find('#name').css('background', '#FFFFFF')
		
	});
	
	//인사말 수정 버튼
	$('#usercom').mouseenter(function(){
		
		$(this).css('background', '#EEE');
		$('#comUpdate').removeAttr('hidden');
		
	});
	$('#usercom').mouseleave(function(){
		
		$(this).css('background', '#FFFFFF')
		$('#comUpdate').attr('hidden', 'hidden');
		
		$('#comment').removeAttr('hidden');
		$('#textarea').attr('hidden', 'hidden');
		
	});
	
	$('#btnComUpdate').click(function(){
	
		$('#comment').attr('hidden', 'hidden');
		$('#comUpdate').attr('hidden', 'hidden');
		
		$('#textarea').removeAttr('hidden');
	});
	
	
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

</style>

<div class="container">

	<div class="row">
	
		<div class="col-md-3" style="text-align: center;">
			<div>
			<img style="border: 2px solid #ccc" width="200px" height="200px" src="${member.userpic }" class="img-circle">
			</div>
			<br>
			
			<h3>${member.nick }</h3>
			<br><br>
			
			<div style="height: 100px; padding-top: 30px" id="usercom" >
			<p id="comment">${member.usercom }</p><p hidden="hidden" id="comUpdate"><button id="btnComUpdate" class="btn btn-xs">인사말 변경</button></p>
				<form id="textarea" hidden="hidden" action="/mypage/user/comupdate" method="post">
				<textarea style="height: 60px; width: 150px;" name="usercom">${member.usercom }</textarea>
				<button class="btn btn-xs">변경</button>
				</form>
			</div>
			
			<br>
			
			<div style="text-align: right">
			<a href="/mypage/user/secession"><button class="btn btn-danger btn-xs">회원 탈퇴</button></a>
			</div>
			
			<hr>
			
			<div id="myrecipe">
			<a href="/mypage/myrecipe" style="font-size: x-large; color: black;">마이레시피</a>
			</div>
			<hr>
			
			<div id="notice">
			<a href="/mypage/notice" style="font-size: x-large; color: black;">알림</a>
			</div>
			<hr>
			
			<div id="scrap">
			<a href="/mypage/scrap" style="font-size: x-large; color: black;">스크랩</a>
			</div>
		</div>
		
		<div class="col-md-1">
			<div class="col-md-6" style="border-right: 1px #ccc solid;height: 800px;"></div>
			<div class="col-md-6"></div>
		</div>
		
		<div class="col-md-8">
		
			<div style="margin-bottom: 50px;">
				<h1 style="text-align: center; padding: 10px;
			 		margin: 0 auto 0; background: #AED584; color: white; ">
					문의글
				</h1>
			</div>
			
			<div>
				
				<div class="col-md-12">
					<div style="background: #ccc;">
					<h3>${question.questitle }</h3>
					<hr>
					</div>
						
					<div>
					${question.question }
					</div>
					<br><br><br><br><br><br>
				</div>
				
				
				<c:if test="${not empty question.answer }">
				<div class="col-md-12">
					<div style="background: #ccc;">
					<h3>답변</h3>
					<hr>
					</div>
					
					<div>
					${question.answer }
					</div>
					<br><br><br><br><br><br>
				</div>
				</c:if>
			
			<button id="btnList" class="btn btn-md btn-info">목록</button>
			<button id="btnDel" class="btn btn-md btn-danger">삭제</button>
			</div>
	
		</div>
		
	</div> <!-- row -->
	
</div> <!-- container -->




<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>