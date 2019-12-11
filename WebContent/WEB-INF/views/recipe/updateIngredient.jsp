<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="/js/chosen_v1.8.7/chosen.jquery.js" type="text/javascript"></script>
<script src="/js/chosen_v1.8.7/docsupport/prism.js"
	type="text/javascript" charset="utf-8"></script>
<script src="/js/chosen_v1.8.7/docsupport/init.js"
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" href="/js/chosen_v1.8.7/docsupport/style.css">
<link rel="stylesheet" href="/js/chosen_v1.8.7/docsupport/prism.css">
<link rel="stylesheet" href="/js/chosen_v1.8.7/chosen.css">


<style type="text/css">
.chosen-container{
	width: 100%;
}
</style>

<h5>주 재료 (최대 3개)</h5>
<select name="mainIngre" data-placeholder="골라보세요" id="main"
	class="chosen-select form-control" multiple="multiple" required="required">
	<option value="1" selected="selected">주재료 1</option>
	<c:forEach var="i" begin="1" end="70">
		<option value="${i }">주재료 ${i } 입니다</option>
	</c:forEach>
</select>
<br>
<br>

<h5>부 재료</h5>
<select name="subIngre" data-placeholder="골라보세요" class="chosen-select"
	multiple="multiple" required="required" class="form-control">
	<c:forEach var="i" begin="1" end="70">
		<option value="${i }">부재료 ${i } 입니다</option>
	</c:forEach>
</select>
<br>
<br>

<h5>양념</h5>
<select name="seasoning" data-placeholder="골라보세요" class="chosen-select"
	multiple="multiple" required="required" >
	<c:forEach var="i" begin="1" end="30">
		<option value="${i }">양념 ${i } 입니다</option>
	</c:forEach>
</select>
<br>