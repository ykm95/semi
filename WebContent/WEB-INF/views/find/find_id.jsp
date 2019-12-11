
    <%@ page language="java" contentType="text/html; charset=EUC-KR"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>ID_find</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<style>
tr {
 border: 0px solid none;
}

 

k:hover {
 text-decoration: none;
 color: #9354ED
}</style> <script>
 function gohome() {
  var frm = document.idfindscreen;
  frm.method = "post";
  frm.action = "./home.jsp"; //넘어간화면
  frm.submit(); //등록이 될수 있는 조건이면, 정보를 보내겠다.
 }

 function gojoin() {
  var frm = document.idfindscreen;
  frm.method = "post";
  frm.action = "./join.jsp"; //넘어간화면
  frm.submit(); //등록이 될수 있는 조건이면, 정보를 보내겠다.
 }

 function gologin() {
  var frm = document.idfindscreen;
  frm.method = "post";
  frm.action = "./login.jsp";
  frm.submit();
 }

 function goidfind() {
  var frm = document.idfindscreen;
  frm.method = "post";
  frm.action = "./id_find.jsp";
  frm.submit();
 }

 function gopwfind() {
  var frm = document.idfindscreen;
  frm.method = "post";
  frm.action = "./pw_find.jsp";
  frm.submit();
 }
 function logout() {
  var frm = document.idfindscreen;
  frm.method = "post";
  frm.action = "./logoutCtl.jsp";
  frm.submit();
 }
 

 function id_search2() { //이름,이메일로 '찾기' 버튼

  var frm = document.idfindscreen;

  if (frm.name2.value.length < 1) {
   alert("이름을 입력해주세요");
   return;
  }
  if (frm.email.value.length < 1 || frm.e_domain.value.length < 1) {
   alert("이메일을 입력해주세요");
   return;
  }

  frm.method = "post";
  frm.action = "./id_searchCtl2.jsp"; //넘어간화면
  frm.submit();  }

​

 //이메일 부분

 function checkid() {

  var frm = document.idfindscreen;

  var regExp = '/^([/\w/g\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/';

  if (!regExp.test(frm.email.value)) {

   alert('올바른 email을 입력해주세요.');

   frm.email.focus();

  }

 }

 function domainCheck() {

  var frm = document.idfindscreen;

  if (frm.domain.value == 0) {
   frm.e_domain.value = "";
   frm.e_domain.disabled = false;

  } else {
   frm.e_domain.value = frm.domain.value;
   frm.e_domain.disabled = true;

  }

 }
 
 </script>
</head>
<body>



</body>
</html>