<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

  <!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript">

// //경고 모달 호출 메서드
// function warningModal(content) {
//    $(".modal-contents").text(content);
//    $("#defaultModal").modal('show');
// }


$(document).ready(function() {
	
//아이디 찾기 버튼 클릭
$("#emailcheck").click(function() {
   

      //이메일 검사
      if($('#emailcheckinput').val()==""){
    	  alert('인증번호를 입력해 주세요');
           
          return false;
      }
   // 둘다 입력한 경우
      else{
      var emailcheckinput = $("#emailcheckinput").val();
		
      if(emailcheckinput == '${member.emailCheckNo}'){
    	  $(location).attr('href', '/main');
      }
      else{
    	  alert('번호 다름!');
      }
      }
   })
})

</script>


</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>




<body style="background-color:#F7F7F4">
<div class="container" style="width:400px;">
<div class="page-header" style="text-align: center; padding-bottom: 28px; margin: 60px 2px 56px;" >
<h2> 이메일 인증 번호를<br>입력하세요</h2>
</div>

	<div style="text-align:center; height: 124px;">
		<label for="userid"></label>
		<input type="text" id="emailcheckinput" name="emailcheckinput" placeholder="인증번호 입력" maxlength="10" class="form-control" />
		<br><br>
		<button style="text-align:center" class="btn" type="button" id="emailcheck" style="position: relative; left: -144px;" > 인증하기 </button>
		<div id="message" style="position: relative;  top: -27px;" ></div>
		<br>	
	</div>
	</div>
	
	
<!-- <!-- 경고 모달창 --> -->
<!--             <div class="modal fade" id="defaultModal"> -->
<!--                <div class="modal-dialog"> -->
<!--                     <div class="modal-content panel-danger"> -->
<!--                         <div class="modal-header panel-heading"> -->
<!--                             <h4 class="modal-title">오류 메시지</h4> -->
<!--                         </div> -->
<!--                         <div class="modal-body"> -->
<!--                             <p class="modal-contents"></p> -->
<!--                         </div> -->
<!--                         <div class="modal-footer"> -->
<!--                            <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button> -->
<!--                         </div> -->
<!--                     </div>/.modal-content -->
<!--                 </div>/.modal-dialog -->
<!--             </div>/.modal -->
       
<!--             // 경고 모달창 -->
	
</body>
</html>