<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp"/>

<script type="text/javascript">

$(document).ready(function(){
	
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#foo').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#userpic").change(function() {
        readURL(this);
    });
})
</script>

<form action ="<%=response.encodeUrl("/mypage/userinfo") %>" method="post">

<div>
	유저 아이디 : ${userid }
</div>

<br>

<div>
	<label for="email">이메일</label>
	<input type="email" value="${member.email }" id="email" name="email" style= "margin-left: 16px;"><br>	
</div>

<br>

<div>
	<label for="nick">닉네임</label>
	<input type="text" value="${member.nick }" id="nick" name="nick" placeholder="anything"
	style="text-align: left;  margin-left: 16px;"></input>
</div>

<br>

<div>
	<label for="userpic">이미지</label>
	<input type="file" id="userpic" name="userpic"><br>
	
	<img id="foo" width="100px" height="100px" src="${member.userpic }">

</div>

<br>

<div>
	<label for="useremail">인사말</label>
	<input type="text" value="${member.usercom }" id="usercom" name="usercom"><br>	
</div>



<div><br><br><br><br>
<button>정보 수정</button>
</div>
</form>	


<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>