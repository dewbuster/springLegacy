<%@ page contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">KenIk HOme</a></h1>
  <ul>  
    <li><a href="#">�α���</a></li>
    <li><a href="#">ȸ������</a></li>
  </ul>
</header>
<div>
  <xmp class="code">
    emp.jsp
  </xmp>
  
  <form action="/scott/dept" method="get">
     <table id="tbl-emp">
     <caption></caption>
      <thead>
      <tr>
        <th></th>
        <th>Empno</th>
        <th>Ename</th>
        <th>Job</th>
        <th>Mgr</th>
        <th>Hiredate</th>
        <th>Sal</th>
        <th>Comm</th>
        <th>Deptno</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="dto">
    	 <tr>
           <td><input type="checkbox" value="${ dto.empno }" name="empno"></td>
           <td>${ dto.empno }</td>
           <td>${ dto.ename }</td>
           <td>${ dto.job }</td>
           <td>${ dto.mgr }</td>
           <td>${ dto.hiredate }</td>
           <td>${ dto.sal }</td>
           <td>${ dto.comm }</td>
           <td>${ dto.deptno }</td> 
         </tr>
    </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="9">
        <button id="home" clss="home">Home</button>
        </td>
      </tr>
    </tfoot>
     </table>  
  </form>
  
</div> 
</body>
</html>