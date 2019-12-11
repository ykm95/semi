<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp"></jsp:include>


<style type="text/css">
#mainpic{
   width: 600px;
   height: 400px;
   border-radius:20px;
   
}

#pic {
   width: 400px;
   height: 250px;
}

body {
   padding-top: 20px;
   padding-bottom: 40px;
}

/* 전체 내용을 감쌈 */
.container-narrow {
   margin: 0 auto;
   max-width: 700px;
}

.container-narrow>hr {
   margin: 30px 0;
}

/* 핵심 마케팅 문구와 가입 버튼 */
.jumbotron {
   margin: 60px 0;
   text-align: center;
}

.jumbotron h1 {
   font-size: 72px;
   line-height: 1;
}

.jumbotron .btn {
   font-size: 21px;
   padding: 14px 24px;
}

/* 부수적인 마케팅 내용 */
.marketing {
   margin: 60px 0;
}

.marketing p+h4 {
   margin-top: 28px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
   
function chk() {
      
      $.ajax({
         type: "get"
         , url: "/recipe/scrap/chk"
         , data: {
            "recipeno": "${recipe.recipeno}"
         }
         , dataType: "json"
         , success: function(data) {
            
            if (data.result) {
               $("#btnScrap").html("스크랩취소");
            } else {
               $("#btnScrap").html("스크랩");
            }
            
         }
         
         , error: function(data) {
            console.log("실패")
         }
      })
            
   }
   
   
   chk();

   
   //스크랩버튼 동작
   $("#btnScrap").click(function(){
      $.ajax({
         type: "get"
         , url: "/recipe/scrap"
         , data: {
            "recipeno": "${recipe.recipeno}"
         }
         , dataType: "json"
         , success: function(data) {
            
            if (data.result) {
               $("#btnScrap").html("스크랩취소");
            } else {
               $("#btnScrap").html("스크랩");
            }
            
         }
         
         , error: function(data) {
            console.log("실패")
         }
      })
      
   });
   
   // 댓글 입력
   $("#btnCommInsert").click(function() {      
      $form = $("<form>").attr({
         action: "/comment/insert",
         method: "post"
      }).append(
         $("<input>").attr({
            type:"hidden",
            name:"recipeno",
            value:"${recipe.recipeno }"
         })
         ).append(
         $("<input>").attr({
            type:"hidden",
            name:"userno",
            value:"${sessionScope.userno }"
         })
      ).append(
         $("<textarea>")
            .attr("name", "comcontent")
            .css("display", "none")
            .text($("#commentContent").val())
      );
      $(document.body).append($form);
      
      if($.trim($("#commentContent").val()) == "" ){
          alert("입력하세요");
          return false;
      }    
      
      $form.submit();
      
   });
   
});

function deleteComment(commentno) {
   $.ajax({
      type: "post"
      , url: "/comment/delete"
      , dataType: "json"
      , data: {
         commentno: commentno
      }
      , success: function(data){
         if(data.success) {
            
            $("[data-commentno='"+commentno+"']").remove();
            
         } else {
            alert("댓글 삭제 실패");
         }
      }
      , error: function() {
         console.log("error");
      }
   });
}
</script>

<script type="text/javascript">

$(document).ready(function() {
   
   $.ajax({
      type: "GET"
      , url: "/recipe/process"
      , data : {recipeno:'${recipeno }'}
      , dataType: "html"
      , success: function(data){
         console.log("성공");

         $("#processDiv").html(data);
         
      }
      , error: function(){
         console.log("실패");
      }
   })
})
</script>

<script type="text/javascript">

$(document).ready(function() {
   if(${isRecommend}) {
      $("#btnRecommend")
         .addClass("btn-warning")         
         .html('♥');
      
   } else {
      $("#btnRecommend")
         .addClass("btn-primary")
         .html('♡');
   }
   
   $("#btnRecommend").click(function() {
      
      $.ajax({
         type: "get"
         , url: "/recipe/recommend"
         , data: { "recipeno": "${recipe.recipeno }" }
         , dataType: "json"
         , success: function( data ) {
            console.log("성공");
            console.log(data);

            if( data.result ) { //추천 성공
               $("#btnRecommend")
               .removeClass("btn-primary")
               .addClass("btn-warning")               
               .html('♥');
            
            } else { //추천 취소 성공
               $("#btnRecommend")
               .removeClass("btn-warning")
               .addClass("btn-primary")
               .html('♡');
            
            }
                        
            //추천수 적용
            $("#recommend").html("이 레시피를 " + data.cnt +"명이 좋아합니다");
            
         }
         , error: function() {
            console.log("실패");
            
         }
      });/* ajax */
      
   }); /* btn */
   
   //신고버튼 동작
   $("#btnReport").click(function(){
      $(location).attr("href", "/recipe/report?recipeno=${recipe.recipeno}");
   });
   
   
   //삭제버튼 동작
   $("#btnDelete").click(function(){
      $(location).attr("href", "/mypage/myrecipe/delete?recipeno=${recipe.recipeno}");
   });
   
   
   
}); /* ready */
</script>

<body style="background-color:#EEE">
<div class="container" >

<div>
<a href="/main"><button type="button" class="btn btn-sm">메인</button></a>
<a href="/recipe/list"><button type="button" class="btn btn-sm">목록</button></a>
</div>

<hr>
   <div style="text-align: center; background: #EEE; border-radius:20px">
      <img src="${recipe.recipic }"  style="margin: 50px" id="mainpic">
      <h1>${recipe.recipename }</h1>
      <em><span class="text-muted">${recipe.recipeex }</span></em>
      
      <br><br><br>
   <c:if test="${login }">
      <br><button id="btnRecommend" class="btn btn-large btn-success"  >좋아요!</button>
   </c:if>
      <br><br>
      <b id="recommend">이 레시피를 ${cnt }명이 좋아합니다</b><br><br>
   </div>
      <hr>
      
      
   <div style="background: #EEE; border-radius:20px">
   <br>   
      <div>      
         <b  style="font-size: 30px; text-align:left; margin-left: 20px;">재료</b>
<!--          <em><span>ingredients</span></em> -->
         <br>
      </div>
   <br>
      <div id="igredientDiv" style="display: inline-flex; margin-left: 20px;">
      
         <div id="mainIngre" style="margin:0 10px;  width: 353px;">
            <h5>[주 재료]</h5> <br>
            <c:forEach var="main" items="${main}">
            <p>${main.ingrename }</p>
            </c:forEach>
         </div>
      
         <div id="mainIngre" style="margin:0 10px;  width: 353px;">
            <h5>[부 재료]</h5> <br>
            <c:forEach var="sub" items="${sub }">
            <p>${sub.ingrename }</p>
            </c:forEach>
         </div>
         
         <div id="mainIngre" style="margin:0 10px;  width: 3530px;">
            <h5>[양념]</h5> <br>
            <c:forEach var="seas" items="${seas }">
            <p>${seas.ingrename }</p>
            </c:forEach>
         </div>
      </div><br><br>
   </div>
   
   
   <hr>
      <div style="background: #EEE; border-radius:20px">
      <br>
         <b style="font-size: 30px; text-align:left; margin-left:20px;">요리순서</b>
         <em><span>Cooking order</span></em>
         <br>
         
         <div class="row-fluid marketing" style="margin-left: 20px">
            <div id="processDiv" class="row"></div>            
         </div>   
      </div>
      <hr>

      
      <!-- 완성사진 -->       
      <div style="background: #EEE; border-radius:20px; margin-top: -40px;">
         <div><br>      
            <b style="font-size: 30px; text-align:left; margin-left: 20px;">완성</b>
            <em><span>completion</span></em>
            <br><br><br>
         </div>      
         <div>
            <img src="${recipe.recipic }"  style="margin-left: 220px;" id="mainpic">
            <br><br><br>
         </div>
      </div>
      
      <br><br><br><br>
      <!-- 입력하고 새로고침되는 위치 -->
      <hr>
      
      <br><br>
      <div style="text-align: center">
      
      <c:if test="${login }">
         
         <c:if test="${recipe.userno eq userno }" >
            <button id="btnDelete" class="btn btn-default" style="background: #EEF392">삭제</button>&emsp;
         </c:if>
               
         <c:if test="${recipe.userno ne userno }">
            <button id="btnReport" class="btn btn-default" style="background: #EEF392">신고</button>
            <button id="btnScrap" class="btn btn-default" style="background: #EEF392"></button>
         </c:if>&emsp;
      </c:if>
      
      
      <div id="commentbody">
         
      </div>
      
   <br><br><br>


      <!-- 비로그인상태 -->
      <c:if test="${not login }">
         <strong>로그인이 필요합니다</strong>
         <br>
         <button onclick='location.href="/member/login";'>로그인</button>
         <button onclick='location.href="/member/join";'>회원가입</button>
      </c:if>

      <div style="background: #EEE; border-radius:20px;">
      
      <div><br>
         <b style="font-size: 30px; text-align:left; margin-left:-910px;">댓글</b>
         <br><br>
      <!-- 댓글 리스트 -->
      <table class="table table-striped table-hover table-condensed">

         <thead>
            <tr>
               <th style="width: 15%;">댓글 번호</th>
               <th style="width: 15%;">작성자 id</th>
               <th style="width: 65%;">댓글</th>
               <th style="width: 5%;"></th>
            </tr>
         </thead>

         <tbody id="commentBody">

            <c:forEach items="${commentList }" var="comment">
               <tr data-commentno="${comment.commentno }">
                  <td>${comment.rownum }</td>
                  <td>${comment.userid }</td>
                  <td>${comment.comcontent }</td>

                  <td>
                  <c:if test="${sessionScope.userno eq comment.userno }">
                  <button class="btn btn-default btn-xs"
                     onclick="deleteComment(${comment.commentno });">x</button>
                  </c:if>
                  </td>
               </tr>
            </c:forEach>

         </tbody>

      </table>
      <!-- 댓글 리스트 end -->
      <!-- 로그인상태 -->
      <c:if test="${login }">
         <!-- 댓글 입력 -->
         <div class="form-inline text-center" id="commentbody">
            <textarea style="margin-left: 35px;" placeholder="댓글을 남겨주세요"
               rows="3" cols="90" class="form-control"   id="commentContent"></textarea>&emsp;
            <button id="btnCommInsert" class="btn btn-sm">입력</button>
         </div>
         <br>
         <!-- 댓글 입력 end -->
      </c:if>

   </div>
   </div>
   <!-- 댓글 처리 end -->
   
   </div>
   
   <hr>
   <div class="footer">
      <p>&copy; 세모레 2019</p>
   </div>
   <!-- /container -->

   <hr>
   
</div>
   
</body>
   
<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>