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
<select name="mainIngre" data-placeholder="재료를 선택해주세요." id="main"
	class="chosen-select form-control" multiple="multiple" required="required">		
		<option value="1">돼지고기</option>
		<option value="2">소고기</option>
		<option value="3">닭고기</option>
		<option value="4">양파</option>
		<option value="5">무</option>
		<option value="6">어묵</option>
		<option value="7">고추</option>
		<option value="8">스팸</option>
		<option value="9">떡</option>
		<option value="10">콩나물</option>
		<option value="11">두부</option>
		<option value="12">만두</option>
		<option value="13">대파</option>
		<option value="14">미역</option>
		<option value="15">오징어</option>
		<option value="16">스파게티면</option>
		<option value="17">베이컨</option>
		<option value="18">우유</option>
		<option value="19">표고버섯</option>
		<option value="20">라면</option>
		<option value="21">당면</option>
		<option value="22">시금치</option>
		<option value="23">파프리카</option>
		<option value="24">당근</option>
		<option value="25">밥</option>
		<option value="26">김</option>
		<option value="27">김치</option>
		<option value="28">가지</option>
		<option value="29">부추</option>
		<option value="30">새우젓</option>
		<option value="31">고구마</option>
		<option value="32">꽁치통조림</option>
		<option value="33">토마토</option>
		<option value="34">순대</option>
		<option value="35">양배추</option>
		<option value="36">깻잎</option>
		<option value="37">참치</option>
		<option value="38">호박</option>
		<option value="39">검은콩</option>
		<option value="40">알타리</option>
		<option value="41">밀가루</option>
		<option value="42">땅콩</option>
		<option value="43">메추리알</option>
		<option value="44">비엔나소세지</option>
		<option value="45">도토리묵</option>
		<option value="46">상추</option>
		<option value="47">훈제오리</option>
		<option value="48">굴</option>
		<option value="49">팽이버섯</option>
		<option value="50">꼬막</option>
		<option value="51">쪽파</option>
		<option value="52">냉동새우</option>
		<option value="53">옥수수콘</option>
		<option value="54">치즈</option>
		<option value="55">파슬리</option>
		<option value="56">식빵</option>
		<option value="57">호두</option>
		<option value="58">숙주나물</option>
		<option value="59">귤</option>
		<option value="60">사과</option>
		<option value="61">피망</option>
		<option value="62">쭈꾸미</option>
		<option value="63">전복</option>
		<option value="64">방울토마토</option>
		<option value="65">딸기</option>
		<option value="66">파인애플</option>
		<option value="67">오렌지</option>
		<option value="68">홍합</option>
		<option value="69">꽃게</option>
		<option value="70">조개</option>	
</select>
<br>
<br>

<h5>부 재료</h5>
<select name="subIngre" data-placeholder="재료를 선택해주세요." class="chosen-select"
	multiple="multiple" required="required" class="form-control">
		<option value="1">돼지고기</option>
		<option value="2">소고기</option>
		<option value="3">닭고기</option>
		<option value="4">양파</option>
		<option value="5">무</option>
		<option value="6">어묵</option>
		<option value="7">고추</option>
		<option value="8">스팸</option>
		<option value="9">떡</option>
		<option value="10">콩나물</option>
		<option value="11">두부</option>
		<option value="12">만두</option>
		<option value="13">대파</option>
		<option value="14">미역</option>
		<option value="15">오징어</option>
		<option value="16">스파게티면</option>
		<option value="17">베이컨</option>
		<option value="18">우유</option>
		<option value="19">표고버섯</option>
		<option value="20">라면</option>
		<option value="21">당면</option>
		<option value="22">시금치</option>
		<option value="23">파프리카</option>
		<option value="24">당근</option>
		<option value="25">밥</option>
		<option value="26">김</option>
		<option value="27">김치</option>
		<option value="28">가지</option>
		<option value="29">부추</option>
		<option value="30">새우젓</option>
		<option value="31">고구마</option>
		<option value="32">꽁치통조림</option>
		<option value="33">토마토</option>
		<option value="34">순대</option>
		<option value="35">양배추</option>
		<option value="36">깻잎</option>
		<option value="37">참치</option>
		<option value="38">호박</option>
		<option value="39">검은콩</option>
		<option value="40">알타리</option>
		<option value="41">밀가루</option>
		<option value="42">땅콩</option>
		<option value="43">메추리알</option>
		<option value="44">비엔나소세지</option>
		<option value="45">도토리묵</option>
		<option value="46">상추</option>
		<option value="47">훈제오리</option>
		<option value="48">굴</option>
		<option value="49">팽이버섯</option>
		<option value="50">꼬막</option>
		<option value="51">쪽파</option>
		<option value="52">냉동새우</option>
		<option value="53">옥수수콘</option>
		<option value="54">치즈</option>
		<option value="55">파슬리</option>
		<option value="56">식빵</option>
		<option value="57">호두</option>
		<option value="58">숙주나물</option>
		<option value="59">귤</option>
		<option value="60">사과</option>
		<option value="61">피망</option>
		<option value="62">쭈꾸미</option>
		<option value="63">전복</option>
		<option value="64">방울토마토</option>
		<option value="65">딸기</option>
		<option value="66">파인애플</option>
		<option value="67">오렌지</option>
		<option value="68">홍합</option>
		<option value="69">꽃게</option>
		<option value="70">조개</option>
</select>
<br>
<br>

<h5>양념</h5>
<select name="seasoning" data-placeholder="재료를 선택해주세요." class="chosen-select"
	multiple="multiple" required="required" >
		<option value="1">소금</option>
		<option value="2">설탕</option>
		<option value="3">후추</option>
		<option value="4">간장</option>
		<option value="5">올리고당</option>
		<option value="6">고춧가루</option>
		<option value="7">고추장</option>
		<option value="8">된장</option>
		<option value="9">참기름</option>
		<option value="10">들기름</option>
		<option value="11">매실액</option>
		<option value="12">물엿</option>
		<option value="13">맛술</option>
		<option value="14">식초</option>
		<option value="15">마요네즈</option>
		<option value="16">케첩</option>
		<option value="17">머스터드</option>
		<option value="18">멸치액젓</option>
		<option value="19">통깨</option>
		<option value="20">계피가루</option>
		<option value="21">올리브유</option>
		<option value="22">연유</option>
		<option value="23">고추기름</option>
		<option value="24">조청</option>
		<option value="25">다진마늘</option>
		<option value="26">굴소스</option>
		<option value="27">토마토소스</option>
		<option value="28">버터</option>
		<option value="29">레몬즙</option>
		<option value="30">쌈장</option>
</select>
<br>