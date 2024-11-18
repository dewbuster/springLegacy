<%@ page contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
  	list.jsp
  </xmp>
  
<table>
	<caption style="text-align:right;">
	<a href="/board/register">�۾���</a>
	</caption>
	<thead>
         <tr>
           <th>#��ȣ</th>
           <th>����</th>
           <th>�ۼ���</th>
           <th>�ۼ���</th>
           <th>������</th>        
         </tr>
      </thead>
      <tbody>
      	<c:choose>
      		<c:when test="${empty list}">
      		  <tr>
      		    <td colspan="5">no board...</td>
      		  </tr>
      		</c:when>
      		<c:otherwise>
      			<c:forEach items="${list}" var="board">
      				<tr>
      					<td><c:out value="${board.bno}"/></td>
      					<td><a href="/board/get?bno=${board.bno}"><c:out value="${board.title}"/></a></td>
      					<%-- <td><a href="/board/get/${board.bno}"><c:out value="${board.title}"/></a></td> --%>
      					<td><c:out value="${board.writer}"/></td>
      					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>
      					<td><fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd" /></td>
      				</tr>
      			</c:forEach>
      		</c:otherwise>
      	</c:choose>
      </tbody>
</table>
<script>
	$(function() {
		var result = '<c:out value="${result}" />';
		checkModal(result);
		
		//�ڷΰ���
		history.replaceState({},null,null);
		
		function checkModal(result) {
			if ( result === ''|| history.state) return;
			if ( parseInt(result) > 0 ){
				alert(`\${result} ���� ��ϵǾ����ϴ�.`);
			}
		} // checkModal
	});
</script>
</div> 
</body>
</html>