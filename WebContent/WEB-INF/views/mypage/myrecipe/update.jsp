<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

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
	
	
	if(${recipe.category}=='1'){
		$('#c1').attr('selected', 'selected');
	}
	
	if(${recipe.category}=='2'){
		$('#c2').attr('selected', 'selected');
	}
	
	if(${recipe.category}=='3'){
		$('#c3').attr('selected', 'selected');
	}
	
	if(${recipe.category}=='4'){
		$('#c4').attr('selected', 'selected');
	}
	
	if(${recipe.category}=='5'){
		$('#c5').attr('selected', 'selected');
	}
	
	if(${recipe.category}==6){
		$('#c6').attr('selected', 'selected');
	}
	
	
	if(${recipe.ocassion}=='1'){
		$('#o1').attr('selected', 'selected');
	}
	
	if(${recipe.ocassion}=='2'){
		$('#o2').attr('selected', 'selected');
	}
	
	if(${recipe.ocassion}=='3'){
		$('#o3').attr('selected', 'selected');
	}
	
	if(${recipe.ocassion}=='4'){
		$('#o4').attr('selected', 'selected');
	}
	
	if(${recipe.ocassion}=='5'){
		$('#o5').attr('selected', 'selected');
	}
	
	if(${recipe.ocassion}==6){
		$('#o6').attr('selected', 'selected');
	}
	
	
	
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
<label for="recipename">레시피제목
	<input type="text" value="${recipe.recipename }" class="form-control" id ="recipename" name="recipename" placeholder="제목을입력해주세요." style="width:100%"/>
</label>
</div>
<hr>

<div id="recipeexdiv">
<label>레시피설명</label>
<textarea class="form-control" id="content" name="recipeex">${recipe.recipeex }</textarea>
</div>
<hr>

<div id="categorydiv">
<label>종류별</label>
	<select name="category" class="form-control" >
		<option value=1 id=c1>1(한식)</option>
		<option value=2 id=c2>2(양식)</option>
		<option value=3 id=c3>3(중식)</option>
		<option value=4 id=c4>4(일식)</option>
		<option value=5 id=c5>5(디저트)</option>
		<option value=6 id=c6>6(음료)</option>
	</select>
</div>
<hr>


<div id="ocassiondiv">
<label>상황별</label>
	<select name="ocassion" class="form-control">
		<option value=1 id=o1>1(일상)</option>
		<option value=2 id=o2>2(초간단)</option>
		<option value=3 id=o3>3(간식)</option>
		<option value=4 id=o4>4(야식)</option>
		<option value=5 id=o5>5(다이어트)</option>
		<option value=6 id=o6>6(해장)</option>
	</select>
</div>
<hr>

<div id="ingredientdiv">
	<jsp:include page="/WEB-INF/views/recipe/updateIngredient.jsp"/>
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
	<input type="file" name="recipic"/>
</div>

<br>
<!-- <a href="/main"><button type="button">취소</button></a> -->
	<input type="button" id="subButton" value="작성" class="btn" style="background-color: #AED584;"/>
	&nbsp;
	<input type="button" id="cancelButton" value="취소" class="btn" style="background-color: #F16B6F;">
</form>

<br><br><br><br>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>