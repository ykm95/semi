<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include><br>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<script type ="text/javascript">
$(document).ready(function() {

	   $("#btnWrite").click(function() {

//	       console.log(111);

	      //스마트에디터의 내용을 <textarea>에 적용
	      submitContents($("#btnWrite"));

	      //form submit
	      $("#write").submit();
	   })

	});

</script>
<style type="text/css">
div{
	margin:10px;
}

</style>
<jsp:include page="/WEB-INF/views/layout/menu.jsp"></jsp:include>

<h1>문의합니다</h1>
<hr>
	<div style="width:1092px; height:200px; text-align:center; 
	 font-size:16px; border: 1px solid black;">
	test
	</div>
	<textarea id ="contents"></textarea>
	
<script type="text/javascript">
 CKEDITOR.replace('contents', {height: 400});
</script><br>
	<div class="text-center">
	<button type="button" id ="btnwrite" class="btn btn-success">작성</button>
	</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>