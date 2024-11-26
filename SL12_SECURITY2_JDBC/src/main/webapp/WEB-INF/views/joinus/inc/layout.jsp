<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <title><tiles:getAsString name="title" /></title>
      <link href='<tiles:getAsString name="css" />' type="text/css" rel="stylesheet" />
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   </head>
   <body>
   	  <!-- header -->
   	  <tiles:insertAttribute name="header" />
	  <!-- header -->
      <!-- visual -->
      <tiles:insertAttribute name="visual" />
      <!-- visual -->
      <div id="main">
         <div class="top-wrapper clear">
         	<tiles:insertAttribute name="content" />
            <!-- navi -->
            <tiles:insertAttribute name="aside" />
            <!-- navi -->
            </div>
      </div>
      <!-- footer -->
      <tiles:insertAttribute name="footer" />
      <!-- footer -->

</body>
</html>