
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.codecentric.cvgenerator.api.entities.User"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title> Lebenslauf </title>
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

<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
	/* set variables locally for increased performance */
	var scroll_timer;
	var displayed = false;
	var $message = $('#message a');
	var $window = $(window);
	var top = $(document.body).children(0).position().top;
	/* react to scroll event on window */
	$window.scroll(function () {
	window.clearTimeout(scroll_timer);
	scroll_timer = window.setTimeout(function () {
	if($window.scrollTop() <= top)
	{
	displayed = false;
	$message.fadeOut(500);
	}
	else if(displayed == false)
	{
	displayed = true;
	$message.stop(true, true).show().click(function () { $message.fadeOut(500); });
	}
	}, 100);
	});
});
</script>


<script src="jquery/jquery-1.4.2.js"></script>
<script src="jquery/autoresize.jquery.js"></script>

<script>
jQuery(function()
{
jQuery('textarea').autoResize();	    
});
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
        %>

</head>
<body>
   
	<div id="top"></div>
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
                    <h1  style ="text-align: center; padding: 10px 0px 0px 0px;"></h1> 
                     <h1  style ="text-align: center; padding: 10px 0px 0px 0px;">  </h1>  
                    <p  style ="text-align: center;"> 
                       Enter in the personal information for your Account to have quick checkouts during any transaction 
                    </p>
                </div>
            </div>
             
             <div id="whiteBox" class="grid_13 push_3">
                <form action="result" method="post" >
                 <div  style ="text-align: center; border-top: 20px #444 solid; padding: 10px 0px 10px 0px;" class="grid_12 MyCV">
                  <h1 style ="padding: 10px 0px 10px 40px;">Ausbildung</h1>
                         <div class="clear"></div><br/>
                <script>
			 
			    var anzahl = 0;
			    function remove_0() {
			 
			    var popo0 = document.getElementById('popo0new-' + anzahl);
			    //var sd = document.createElement('table_2');
			 
			    popo0.remove();
			    anzahl = anzahl -1;
			    
			}
			  function go() {
			      
				
				anzahl = anzahl + 1; 
				var papaTable = document.getElementById('popo0-parent') 
				var sd = document.createElement('div'); 
				sd.innerHTML = '<div id="popo0new-'+ anzahl +'"<div> <div name="loop_bildung" <div class="grid_3"> Ausbildung Begin   </div><div class="grid_8"> Ausbildung End </div> <div class="grid_6"><input type="date" id="ausbildung_begin" name="ausbildung_begin" placeholder="Anfangsjahr, DD-MM-YYYY"></div> <div class="grid_3"><input type="date" id="ausbildung_end" name="ausbildung_end" placeholder="Endungsjahr, DD-MM-YYYY"></div><div class="clear"></div><br/><div class="grid_3">Ausbildung Stelle</div><div class="grid_8">Ausbildung Ort</div><div class="grid_6"><textarea class="span8" placeholder="Ausbildungs-, Studiumsstelle" name="ausbildung_stelle" rows="1" cols="31"></textarea></div><div class="grid_3"><textarea class="span8"  placeholder="Ort" name="ausbildung_ort" rows="1" cols="31"></textarea></div><div class="clear"></div><br/></div></div> ';
				
				cnt = papaTable.childElementCount - 2 
				console.log(papaTable)
				papaTable.appendChild(sd)
			}
			 </script>
			 
			 
						 <div id="popo0-parent">
					      <div>     
                          <div name="loop_bildung"> 
                          
                          <div class="grid_3">
                                Ausbildung Begin
                         </div>
                          <div class="grid_8">
                                Ausbildung End
                         </div>
                           
                            <div class="grid_6">
                               <input type="date" id="ausbildung_begin" name="ausbildung_begin" placeholder="Anfangsjahr, DD-MM-YYYY">
                            </div>
                            <div class="grid_3">
                            <input type="date" id="ausbildung_end" name="ausbildung_end" placeholder="Endungsjahr, DD-MM-YYYY">
                            </div>
                             <div class="clear"></div><br/>
                           
                            <div class="grid_3">
                                Ausbildung Stelle
                            </div>
                            <div class="grid_8">
                                Ausbildung Ort
                            </div>
                            <div class="grid_6">
                            <textarea class="span8" placeholder="Ausbildungs-, Studiumsstelle" name="ausbildung_stelle" rows="1" cols="31"></textarea>
                            </div>
                            <div class="grid_3">
                            <textarea class="span8"  placeholder="Ort" name="ausbildung_ort" rows="1" cols="31"></textarea>
                            </div>
                             <div class="clear"></div><br/>
                            </div>
                            </div>    
                      </div>       
               
               
               <div id="pop">    
                     <div class="clear"></div><br/>
                        <div style ="padding: 0px 0px 50px 10px;" class="grid_3">
                                <button type="button" id="greenBtn"   onclick="go()"><h3 style ="padding: 0px 0px 0px 0px;">Add Ausbildung</h3>   </button>
                            </div>
                            <div style ="padding: 0px 0px 0px 168px;" class="grid_3">
                               <button type="button" id="greenBtn"   onclick="remove_0()"><h3 style ="padding: 0px 0px 0px 0px;">Delete Ausbildung</h3>   </button>
                            </div>
                    </div>   
                    
                    
                    
                     </div> 
                     </form>     
              </div> 
           </div>        
              
	   
	   <%
         }        
       %>
</body>
</html>
