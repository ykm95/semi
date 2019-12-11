<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="row" style="display: inline;">
  <div style="display: inline-block;">
    <div class="thumbnail" style="height: 310px">
<!--     	<div style="width: 320x; height: 180px; overflow: hidden"> -->
<%--     		<img src="/resources/img/${randomrecipe.ranmenupic }"> --%>
<!-- 		</div> -->
      <img alt="img_${randomrecipe.ranmenuno }.png" src="/resources/img/${randomrecipe.ranmenupic }" width="300px" height="200px" style="margin: 5px 7px">
      	<div class="caption">
        <p>오늘 '${randomrecipe.ranmenuname }' 은(는) 어떠세요?</p>
        <a href="/recipe/list?search=${randomrecipe.ranmenuname }"><button class="btn">메뉴 검색</button></a>
        &nbsp;
		<input type="button" class="btnRandonMenu btn" value="다시 추천받기"/>
      </div>
    </div>
  </div>
</div>

<%-- <p>오늘 '${randomrecipe.ranmenuname }' 은(는) 어떠세요?</p> --%>
<%-- <a href="/recipe/list?search=${randomrecipe.ranmenuname }"><button class="btn">메뉴 검색</button></a> --%>
<!-- <input type="button" class="btnRandonMenu btn" value="다시 추천받기"/> -->