<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp"/>

<script type="text/javascript">

var inputidx = 1;
function addFileInput() {
	var html = '';
	html += '<div id="filediv['+inputidx+']">';
	html += '<span>'+inputidx+' 번째</span>';
	html += '<input type="file" name="processPic['+inputidx+']" data-idx="'+inputidx+'"/>';
	html += '<img id="inputImg['+inputidx+']" class="recipepic" src="#" />';
	html += '<textarea style="margin-left: 70px; width: 520px; height: 180px;" name="processText['+inputidx+']"></textarea>';
	html += '<br><br>';
	html += '</div>';
	
	$("#processDiv").append(html);
	
	inputidx++;
}

$(document).ready(function() {
	addFileInput();
	$("#btnAdd").click(addFileInput);
	
	$("#processDiv").on("change", "input[name^='processPic']", readURL);
	
	$("#subButton").on('click',function(){
		
		var html = '';
		html += '<input type="number" name="idxcount" value="'+(inputidx-1)+'" hidden="hidden"/>';
		
// 		console.log(html);
		$("#processDiv").append(html);
		$("#regform").submit();
	});
	
	$("#cancelButton").on('click',function(){
		location.href="/main";
	})
});
</script>

<script type="text/javascript">
$(document).ready(function() {
	$("#main").chosen({
		max_selected_options : 3
		, no_results_text: "검색결과가 없습니다"
		, allow_single_deselect: true
	});
	
	$(".chosen-select").chosen({
		no_results_text: "검색결과가 없습니다"
		, allow_single_deselect:true
	});
})

</script>

<script type="text/javascript">
function readURL(input) {
	
	var idx = $(this).attr("data-idx");
	
	if (this.files && this.files[0]) {
		var reader = new FileReader();
		
		reader.onload = function(e) {
			var url = reader.result;
			var outputid = "inputImg["+ idx +"]";
			var output = document.getElementById(outputid);

// 			console.log("---outputid, output---------")
// 			console.log(outputid);
// 			console.log(output);
// 			console.log("------------")
			
			output.src = url;
// 			$('#inputImg[]').attr('src', e.target.result);
		}
		
		reader.readAsDataURL(input.target.files[0]);
	}
}
</script>

<style type="text/css">
.recipepic{
	width: 300px;
	height: 180px;
}
</style>


<div style="background-color: #afd485; text-align: center; font-size: 30px; width: 100%; height: 80px; display: table; ">
<h1 style="display: table-cell; vertical-align: middle;">레시피등록</h1>
</div>
<hr>

<form action="/recipe/reg" method="post" id="regform" enctype="multipart/form-data">
	
<div id="recipenamediv">
<label for="recipename" style="width:100%">레시피제목
	<input type="text" class="form-control" id ="recipename" name="recipename" placeholder="제목을입력해주세요." style="width:100%" required="required"/>
</label>
</div>
<hr>

<div id="recipeexdiv">
<label>레시피설명</label>
<textarea class="form-control" id="content" name="recipeex" required="required"></textarea>
</div>
<hr>

<div id="categorydiv">
<label>종류별</label>
	<select name="category" class="form-control">
		<option value=1>한식</option>
		<option value=2>양식</option>
		<option value=3>중식</option>
		<option value=4>일식</option>
		<option value=5>디저트</option>
		<option value=6>음료</option>
	</select>
</div>
<hr>


<div id="ocassiondiv">
<label>상황별</label>
	<select name="ocassion" class="form-control">
		<option value=1>일상</option>
		<option value=2>초간단</option>
		<option value=3>간식</option>
		<option value=4>야식</option>
		<option value=5>다이어트</option>
		<option value=6>해장</option>
	</select>
</div>
<hr>

<div id="ingredientdiv">
	<jsp:include page="/WEB-INF/views/recipe/addIngredient.jsp"/>
</div>
<br>
	
<p>조리과정</p>
	
<div id="processDiv"></div>
	
<c:if test="${!processText }">
	<input type="button" id="btnAdd" value="+"/>
</c:if>
<br><br>
	



<div id="recipicdiv">
<label>완성사진</label><br>
	<input type="file" name="recipic" required="required"/>
</div>

<br>
<!-- <a href="/main"><button type="button">취소</button></a> -->
	<input type="button" id="subButton" value="작성" class="btn" style="background-color: #AED584;"/>
	&nbsp;
	<input type="button" id="cancelButton" value="취소" class="btn" style="background-color: #F16B6F;">
</form>

<br><br><br><br>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>