<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
${param.count+2 } 번째
<input type="number" value="${param.count+2 }" hidden="hidden"/>
<input type="file" name="processPic[${param.count+1 }]"/>
<img class="inputImg[${param.count+1 }]"src="#" />
<textarea name="processText[${param.count+1 }]"></textarea>
<br><br>