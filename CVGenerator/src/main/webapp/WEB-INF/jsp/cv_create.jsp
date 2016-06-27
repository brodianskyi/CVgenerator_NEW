<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CV Creator</title>
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
<jsp:include page="/resources/includedPage/logout.jsp"></jsp:include>
<jsp:include page="/resources/includedPage/search_navigationbar.jsp"></jsp:include>
<div class="container_16">
          <div class="grid_13 push_3" id="whiteBox">
                <div  class="grid_13">
                    <h1  style ="text-align: center; padding: 10px 0px 0px 0px;">Create you CV now</h1>  
                    <p  style ="text-align: center;"> 
                       Enter in the personal information for your Account to have quick checkouts during any transaction 
                    </p>
                </div>
            </div>
            <div class="grid_13 push_3" id="whiteBox">
                <div  class="grid_13">
                    <h1  style ="text-align: center; padding: 10px 0px 0px 0px;">Enter you personal information</h1>  
                    <p  style ="text-align: center;"> 
                      
                    </p>
                </div>
            </div>
            <script>
 var anzahl = 0;
 
 function remove_0() {
 
	 var popo0 = document.getElementById('popo0new-' + anzahl);
     popo0.remove();
     anzahl = anzahl -1;
  }
 
  function go() {
      
	anzahl = anzahl + 1; 
	var papaTable = document.getElementById('popo0-parent') 
	var sd = document.createElement('div'); 
	sd.innerHTML = '<table id="popo0new-'+ anzahl +' ';
	cnt = papaTable.childElementCount - 2 
	console.log(papaTable)
	papaTable.appendChild(sd)
 }
</script>
   <div id="whiteBox" class="grid_13 push_3">
    <div class="clear"></div>
      <div  style ="text-align: center; border-top: 20px #444 solid; padding: 10px 0px 10px 0px;" class="grid_9 push_1 Account">
             <h1 style ="padding: 10px 0px 10px 0px;">Ausbildung/Universität</h1>
                <form:form method="POST" action="/user_create" modelAttribute="user_created_form">
                    
                       
                          
                             <div class="grid_3">
                                Ausbildung Begin
                            </div>
                            <div class="grid_5">
                                <form:input type="date" path="ausbildung_begin" value="${vacancy.date}" pattern="DD-MM-YYYY"/>
                                <form:errors path="ausbildung_begin" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                             <div class="grid_3">
                                Ausbildung End
                            </div>
                            <div class="grid_5">
                                <form:input type="date" path="ausbildung_end" value="${vacancy.date}" pattern="DD-MM-YYYY"/>
                                <form:errors path="ausbildung_end" cssClass="error"/>
                            </div>
                             <div class="clear"></div><br/>
                             <div class="grid_3">
                                Ausbildung  Stelle
                            </div>
                            <div class="grid_5">
                                <form:input path="ausbildung_stelle"/>
                                <form:errors path="ausbildung_stelle" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                             <div class="grid_3">
                                Ausbildung Ort
                            </div>
                            <div class="grid_5">
                                <form:input path="ausbildung_ort"/>
                                <form:errors path="ausbildung_ort" cssClass="error"/>
                            </div>
                            
                            <div class="grid_7">
                                <button class="plus" type="button"  onclick="go()"> Add </button>
						        <button class="delete" type="button" onclick="remove_0()"> Delete </button>
                                <input type="submit" id="greenBtn" value="Register"/>
                            </div>
                          
                           
                      </div>//end of loop div
                            <div class="clear"></div><br/>
                          </div>
                     <!--Part for button-->
                <div class="clear"></div><br/>     
           
                          
                     <div class="clear"></div>
                     <div class="clear"></div>
               

          </div>
        
     </div>     
        

 
 