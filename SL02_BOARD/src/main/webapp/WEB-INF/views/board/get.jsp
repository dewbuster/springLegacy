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
  	get.jsp
  </xmp>
<form action="/board/register" method="post">
     <table>  
       <tbody>
         <tr>
           <th>�۹�ȣ</th>
           <td><input type="text" name="bno" class="full"  readonly="readonly"  value="${ boardVO.bno }"></td>        
         </tr> 
         <tr>
           <th>����</th>
           <td><input type="text" name="title" class="full"  readonly="readonly"  value="${ boardVO.title }"></td>        
         </tr> 
         <tr>
           <th>����</th>
           <td><textarea  name="content" class="full" readonly="readonly"><c:out value="${ boardVO.content }"></c:out></textarea></td>        
         </tr> 
         <tr>
           <th>�ۼ���</th>
           <td><input type="text" name="writer" class="short" readonly="readonly" value="${ boardVO.writer }"></td>        
         </tr>  
       </tbody> 
       <tfoot>
         <tr>
           <td colspan="2">
             <button type="button"  data-oper="modify" class="edit">Modify</button>
             <button type="button"  data-oper="remove" class="delete">Delete</button>
             <button type="button" data-oper="list"  class="list">List</button>
           </td>
         </tr>
       </tfoot>
     </table>
     
     <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
       
  </form> 

<script>
  $(function() {
	var formObj = $("form");
	$("tfoot button").on("click", function () {
		let operation = $(this).data("oper");
		if(operation === 'modify'){
			//location.href = "/board/modify?bno=2"
			//location.href = "/board/modify/2"
			formObj
			.attr({
				"action":"/board/modify",
				"method":"get"
			})
			.submit();
		} else if(operation === 'remove'){
			formObj
			.attr({
				"action":"/board/remove",
				"method":"get"
			})
			.submit();
		} else if(operation === 'list'){
			//location.href = "/board/list"
			formObj
				.attr({
					"action":"/board/list",
					"method":"get"
				})
				.empty()
				.submit();
		}
	}); // click
}); // document.ready
</script>
</div> 
</body>
</html>