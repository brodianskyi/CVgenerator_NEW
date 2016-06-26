<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="shortcut icon" href="/resources/images/codecentric-ag.gif"/>
 <link rel="stylesheet" type="text/css" href="/resources/css/reset.css"/>
 <link rel="stylesheet" type="text/css" href="/resources/css/text.css"/>
 <link rel="stylesheet" type="text/css" href="/resources/css/960_16.css"/>
 <link rel="stylesheet" type="text/css" href="/resources/css/product.css"  />
 <link rel="stylesheet" type="text/css" href="/resources/css/lightbox.css"  />
 <link rel="stylesheet" type="text/css" href="/resources/css/styles.css"/>
 <script src="js/jquery-1.7.2.min.js"></script>
 <script src="js/lightbox.js"></script>
 <script src="js/myScript.js"></script>
 <style type="text/css">
            
            #leftside {
                cursor: pointer;
                position: fixed;
            }
            .error { 
		color: red; font-weight: bold; 
	}
</style>
</head>
<body>
<!-- <img src="/resources/images/codecentric-ag.gif" style="float: all; padding: 0 5px 5px 30px;" /> -->

<jsp:include page="/resources/includedPage/logout.jsp"></jsp:include>
<jsp:include page="/resources/includedPage/search_navigationbar.jsp"></jsp:include>
<div class="container_16">
      
            <div class="grid_13 push_3" id="whiteBox">
                <div  class="grid_13">
                    <h1  style ="text-align: center; padding: 10px 0px 0px 0px;">Login now</h1>  
                    <p  style ="text-align: center;"> 
                       Enter in the personal information for your Account to have quick checkouts during any transaction 
                    </p>
                </div>
            </div>
            <div class="grid_13 push_3" id="whiteBox">
                <div  class="grid_13">
                    <h1  style ="text-align: center; padding: 10px 0px 0px 0px;">Enter you login information</h1>  
                    <p  style ="text-align: center;"> 
                      
                    </p>
                </div>
            </div>
            
             
<div id="whiteBox" class="grid_13 push_3">
<div class="clear"></div>
   <div  style ="text-align: center; border-top: 20px #444 solid; padding: 10px 0px 10px 0px;" class="grid_9 push_1 Account">
             <h1 style ="padding: 10px 0px 10px 0px;"></h1>
                           <form:form method="POST" action="/user_login" modelAttribute="user_login_form">
                            <div class="clear"></div><br/>
                            <div class="grid_3">
                               Email
                            </div>
                            <div class="grid_5">
                                <form:input path="email"/>
                                <form:errors path="email" cssClass="error"/>
                            </div>
                             <div class="clear"></div><br/>
                            <div class="grid_3">
                                Password 
                            </div>
                            <div class="grid_5">
                                <form:input  type="password" path="password"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                          
                           
                            <div class="clear"></div><br/>
                            <div class="grid_7">
                                <input type="submit" id="greenBtn" value="Login"/>
                            </div>
                           </form:form>
                            <div class="clear"></div><br/>
                            <div class="grid_7">
                            <form:form method="GET" action="user_create">  
		                        <input type="submit" id="greenBtn" value="Registration"/>
					        </form:form>
					        </div>  
                          </div>
                     <!--Part for button-->
                <div class="clear"></div><br/>     
           
                          
                     <div class="clear"></div>
                     <div class="clear"></div>
               

</div>
</div>


</body>
</html>
