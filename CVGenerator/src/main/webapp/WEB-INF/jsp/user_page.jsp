
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.codecentric.cvgenerator.api.entities.User"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>User Page</title>
        <jsp:useBean id="user" scope="session" class="com.codecentric.cvgenerator.api.entities.User"/>
		<link rel="shortcut icon" href="/resources/images/codecentric-ag.gif"/>
		 <link rel="stylesheet" type="text/css" href="/resources/css/reset.css"/>
		 <link rel="stylesheet" type="text/css" href="/resources/css/text.css"/>
		 <link rel="stylesheet" type="text/css" href="/resources/css/960_16.css"/>
		 <link rel="stylesheet" type="text/css" href="/resources/css/product.css"  />
		 <link rel="stylesheet" type="text/css" href="/resources/css/lightbox.css"  />
		 <link rel="stylesheet" type="text/css" href="/resources/css/styles.css"/>
        <script src="/resources/jquery/jquery-1.7.2.min.js"></script>
        <script src="/resources/jquery/lightbox.js"></script>
        <script src="/resources/jquery/myScript.js"></script>
        
        <style type="text/css">
            
            #leftside {
                cursor: pointer;
                position: fixed;
            }
            .error { 
		       color: red; font-weight: bold; 
	       }
        </style>
        <script type="text/javascript">
            $(document).ready(function (){
                var MyCV = $('#MyCV');
                var MyAccount = $('#Account');
                var MySettings = $('#Settings');
                var MyUserInfo = $('#userInfo');
                
                var CV = $('.MyCV');
                var Account = $('.Account');
                var Settings = $('.Settings');
                
                MyCV.click(function (){
                    CV.slideDown(700);
                    Account.slideUp(700);
                    Settings.slideUp(700);
                });
                MyAccount.click(function (){
                    CV.slideUp(700);
                    Account.slideDown(700);
                    Settings.slideUp(700);
                });
                MySettings.click(function (){
                    CV.slideUp(700);
                    Account.slideUp(700);
                    Settings.slideDown(700);
                });
                MyUserInfo.click(function (){
                	
                	CV.slideDown(700);
                    Account.slideDown(700);
                    Settings.slideDown(700);
                });
                
            });
            
         
            
            
        </script>
        
    </head>
    <body>
    
<script>
function click_user_info() {
	document.getElementById("message").value="Info Changed";
	alert("Info Changed");
}
function change_user_password() {
	document.getElementById("message").value="Password Changed";
	alert("Password Changed");
}
    </script>
        
        <%
        if (session.getAttribute("user") == null ){// Then new user, show join now
        %>
            <jsp:include page="/resources/includedPage/logout.jsp"></jsp:include>
        <%
        }else {
        %>
            <jsp:include page="/resources/includedPage/logout.jsp"></jsp:include>
        <%
        }
        
        if ((session.getAttribute("user") == null)){
            response.sendRedirect("test.jsp");
        } else {
        user = (User) session.getAttribute("user");

      
        String name = user.getName();
        String vorname = user.getVorname();
        String gebur_date = user.getGeburtsdatum();
        String wohnort = user.getWohnort();
        String national = user.getNationalitaet();
        String sprachen = user.getSprachen();
        String telefon = user.getTelefon();
        String email = user.getEmail();
        
           
        %>

        <jsp:include page="/resources/includedPage/search_navigationbar.jsp"></jsp:include>
        

        <div class="container_16">
            <div id="leftside" class="grid_3">
                    <ul id="leftsideNav">
                        <li><a id="userInfo"><strong>User Profile</strong></a></li>
                        
                        <li><a id="Account">Account</a></li>
                        <li><a id="MyCV">My CV</a></li>
                        <li><a id="Settings">Settings</a></li>
                    </ul>
                </div>
            <div class="grid_13 push_3" id="whiteBox">
                <div  class="grid_13">
                    <h1  style ="text-align: center; padding: 10px 0px 0px 0px;">Hello <%= name %> <%= vorname %> </h1> 
                     <h1  style ="text-align: center; padding: 10px 0px 0px 0px;"> ${message} </h1>  
                    <p  style ="text-align: center;"> 
                       Enter in the personal information for your Account to have quick checkouts during any transaction 
                    </p>
                </div>
            </div>
                
            
                <div id="whiteBox" class="grid_13 push_3">
               
                 <div  style ="text-align: center; border-top: 20px #444 solid; padding: 10px 0px 10px 0px;" class="grid_12 MyCV">
                        
                     <h1 style ="padding: 10px 0px 10px 60px;">My CV</h1>  
                    
                        <div id="CartTable" style="padding:10px 00px" class="grid_12">
                        </div>
                                   
                            <div class="clear"></div>
                          
               </div>
                 <div class="clear"></div>
                    <div  style ="text-align: center; border-top: 20px #444 solid; padding: 10px 0px 10px 0px;" class="grid_9 push_1 Account">
                        <div class="clear"></div>
                        <h1 style ="padding: 10px 0px 30px 0px;">Create CV now</h1> 
                         <div class="clear"></div>
                         <form:form method="GET" action="cv_creator">  
                               <div class="grid_7">
                              
		                             <input type="submit" id="greenBtn"  value="Create CV"/>
				                
				               </div>
				                </form:form>  
                        
                        
                       </div>   
                        
                 <div class="clear"></div>
                    <div  style ="text-align: center; border-top: 20px #444 solid; padding: 10px 0px 10px 0px;" class="grid_9 push_1 Account">
                        <h1 style ="padding: 10px 0px 10px 0px;">User Account</h1>  
                    
                     <form:form method="POST" action="/user_page" modelAttribute="user_page_form">
                            <div class="grid_3">
                                Name
                            </div>
                            <div class="grid_5">
                                <form:input path="name" value="<%= name %>"/>
                                <form:errors path="name" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                             <div class="grid_3">
                                Vorname
                            </div>
                            <div class="grid_5">
                                <form:input path="vorname"/>
                                <form:errors path="vorname" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                             <div class="grid_3">
                                Geburtsdatum
                            </div>
                            <div class="grid_5">
                                <form:input type="date" path="geburtsdatum" value="${vacancy.date}" pattern="DD-MM-YYYY"/>
                                <form:errors path="geburtsdatum" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                            <div class="grid_3">
                                Wohnort
                            </div>
                            <div class="grid_5">
                                <form:input path="wohnort"/>
                                <form:errors path="wohnort" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                            <div class="grid_3">
                               Nationalität
                            </div>
                            <div class="grid_5">
                                <form:input path="nationalitaet"/>
                                <form:errors path="nationalitaet" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                            <div class="grid_3">
                               Sprachen
                            </div>
                            <div class="grid_5">
                                <form:input path="sprachen"/>
                                <form:errors path="sprachen" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                            <div class="grid_3">
                               Telefon
                            </div>
                            <div class="grid_5">
                                <form:input path="telefon"/>
                                <form:errors path="telefon" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                            <div class="grid_3">
                               Email
                            </div>
                            <div class="grid_5">
                                <form:input path="email"/>
                                <form:errors path="email" cssClass="error"/>
                            </div>
                            <input type="hidden" id="message"  name="message" >
                            <div class="clear"></div><br/>
                            <div class="grid_7">
                                <input type="submit"  id="greenBtn" name="change_info" value="Change Information" onclick="click_user_info();"/>
                            </div>
                            </form:form>
                            <div class="clear"></div><br/>
                       </div>
                 <div class="clear"></div>
                 <div  style ="text-align: center; border-top: 20px #444 solid; padding: 10px 0px 10px 0px;" class="grid_9 push_1 Settings">
                     <h1 style ="padding: 10px 0px 10px 0px;">Passwort ändern</h1>  
                      <form:form method="POST" action="/change_password" modelAttribute="password_form">
                           <div class="clear"></div><br/>
                             <div class="grid_3">
                                Password erstellen
                            </div>
                            <div class="grid_5">
                                <form:input  type="password" path="password_one"/>
                                <form:errors path="password_one" cssClass="error"/>
                            </div>
                            <div class="clear"></div><br/>
                            <div class="grid_3">
                                Password bestätigen
                            </div>
                            <div class="grid_5">
                                <form:input  type="password" path="password_two"/>
                                <form:errors path="password_two" cssClass="error"/>
                            </div>
                            <input type="hidden" id="message"  name="message" >
                            <div class="clear"></div><br/>
                            <div class="grid_7">
                                <input type="submit"  id="greenBtn" name="change_password" value = "Change password" onclick="change_user_password();"/>
                            </div>
                          </form:form>
                         </div>
                      
                       
                    </div>
                     
                    </div>
                 <div class="clear"></div>
            
           
        
        <%
         }        
       %>
        
    </body>
</html>
