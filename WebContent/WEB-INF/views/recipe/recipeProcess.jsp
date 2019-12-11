<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table>
<c:forEach var="processList" items="${processList }" varStatus="status">

<div class="col-sm-6" style="height: 300px;">
   <img src="${processList.processpic }" id="pic" style="border-radius:30px">   
</div>


<div class="col-sm-1">
<h4><span>${status.count }.</span> </h4>
</div>
<div class="col-sm-5" style="margin-left: -35px;">
   <h4>${processList.processex }</h4>
</div>
</c:forEach>
</table>