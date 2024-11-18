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
  	register.jsp
  </xmp>
  <form action="/board/register" method="post">
     <table>  
       <tbody>
         <tr>
           <th>����</th>
           <td><input type="text" name="title" class="full" autofocus="autofocus"></td>        
         </tr> 
         <tr>
           <th>����</th>
           <td><textarea  name="content" class="full"></textarea></td>        
         </tr> 
         <tr>
           <th>�ۼ���</th>
           <td><input type="text" name="writer" class="short"></td>        
         </tr>  
       </tbody> 
       <tfoot>
         <tr>
           <td colspan="2">
             <button type="submit">Submit</button>
             <button type="reset">Reset</button>
             <button type="button" class="back" onclick="history.back();">back</button>
           </td>
         </tr>
       </tfoot>
     </table>
     
     <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
       
  </form>  
</div> 
</body>
</html>