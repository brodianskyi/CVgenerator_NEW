
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta charset="utf-8">
    <title>HTML5 Lebenslauf</title>
    <link rel="stylesheet" media="screen" href="styles.css" >
    
      <style type="text/css">
         table {
         width: 300px;
         border-collapse: collapse;
         }
         td, th {
         padding: 3px;
         border: 0px solid black; }
    
         th{ background: #b0e0e6; }
   
         h2{ color:#0DECDC }  
   
         button{ 
         color: #0DECDC;
         width: 10em;  
         height: 2em;
          }
   
         body{ background-color:#FCFEFC; color:#000000; }
   
         img{ 
			 
		 #message a
		 {
		 /* display: block before hiding */
		 display: block;
		 display: none;
		 /* link is above all other elements */
		 z-index: 999;
		 /* link doesn't hide text behind it */
		 opacity: .8;
		 /* link stays at same place on page */
		 position: fixed;
		 /* link goes at the bottom of the page */
		 top: 100%;
		 margin-top: -80px; /* = height + preferred bottom margin */
		 /* link is centered */
		 left: 50%;
		 margin-left: -160px; /* = half of width */
		 /* round the corners (to your preference) */
		 -moz-border-radius: 24px;
		 -webkit-border-radius: 24px;
		 /* make it big and easy to see (size, style to preferences) */
		 width: 300px;
		 line-height: 48px;
		 height: 48px;
		 padding: 10px;
		 background-color: #000;
		 font-size: 24px;
		 text-align: center;
		 color: #fff;
	     }
	     
	     textarea{
	     width:400px;
	     height:70px;
	     color: #0DECDC;
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
  
</head>
    <body>
	   <div id="top"></div>
	     <img src="/resources/images/codecentric-ag.gif" style="float:all;padding:0 5px 5px 30px;" />
	<ul> 
	  <form class="lebenslauf" action="result" method="post" name="lebenslauf">
      
    <h2>Zur Person</h2> 
      <table name="table_1">         
          <tr>
             <td width="25%">Name
                 <div class="row">
                 <div class="small-12 columns">
		         <label for="name"></label></td>
             <td width="25%">
                 <textarea class="span8" type="text" name="name" rows="1" cols="17"></textarea>
                 </div>
             </td>
             <td width="25%"></td>
             <td width="25%"></td>
          </tr>
          <tr>
             <td width="25%">Vorname
                  <div class="row">
                  <div class="small-12 columns">
		          <label for="vorname"></label></td>
             <td width="25%">
                  <textarea class="span8" type="text" name="vorname" rows="1" cols="17" ></textarea>
                  </div>
             </td>
             <td width="25%"></td>
             <td width="25%"></td>
          <tr>
             <td width="25%">Geburtsdatum
                   <div class="row">
                   <div class="small-12 columns">
		           <label for="geburtsdatum"></label></td>
             <td width="25%">
                   <input type="date"  name="geburtsdatum" placeholder="DD-MM-YYYY" cols="17" />
                   </div>
             </td>
             <td width="25%"></td>
             <td width="25%"></td>
          </tr>
          <tr>
             <td width="25%">Wohnort
                   <div class="row">
                   <div class="small-12 columns">
		           <label for="wohnort"></label></td>
             <td width="25%">
                   <textarea class="span8" type="text" name="wohnort" rows="1" cols="17"></textarea>
                   </div>
              </td>
              <td width="25%"></td>
              <td width="25%"></td>
            </tr>
            <tr>
               <td width="25%">Nationalität
                   <div class="row">
                   <div class="small-12 columns">
		           <label for="nationalitaet"></label></td>
               <td width="25%">
                   <textarea class="span8" type="text" name="nationalitaet" rows="1" cols="17"></textarea> 
                   </div>
               </td>
               <td width="25%"></td>
               <td width="25%"></td>
            </tr>
            <tr>
               <td width="25%">Sprachen
                   <div class="row">
                   <div class="small-12 columns">
		           <label for="sprachen"></label></td>
               <td width="25%">
                   <textarea class="span8" type="text" name="sprachen" rows="1" cols="17" title="Füllen Sie diese Feld durch das Komma aus"></textarea> 
		       <td width="25%"></td>
		       <td width="25%"></td>
	        </tr>
                   </div>
               </td>
               <td width="25%"></td>
               <td width="25%"></td>
            </tr>
            <tr>
               <td width="25%">Telefon
                   <div class="row">
                   <div class="small-12 columns">
		           <label for="telefon"></label></td>
               <td width="25%">
                   <textarea class="span8" type="text" name="telefon" rows="1" cols="17"></textarea> 
                   </div>
               </td>
               <td width="25%"></td>
               <td width="25%"></td>
            </tr>
            <tr>
               <td width="25%">Email
                   <div class="row">
                   <div class="small-12 columns">
		           <label for="email"></label></td>
               <td width="25%">
                   <textarea class="span8" type="text" name="email" rows="1" cols="17"></textarea>
                   </div>
               </td>
               <td width="25%"></td>
               <td width="25%"></td>
            </tr>
        </table>         
    <h2>Ausbildung/Universität</h2> 
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
	sd.innerHTML = '<table id="popo0new-'+ anzahl +'" name="table_2"><tr><td width="25%"><div class="row"><div class="small-12 columns"><label for="ausbildung_begin"></label><input type="date" id="ausbildung_begin" name="ausbildung_begin" placeholder="Anfangsjahr, DD-MM-YYYY" ></td><td width="25%"><label for="ausbildung_end"></label><input type="date" id="ausbildung_end" name="ausbildung_end" placeholder="Endungsjahr, DD-MM-YYYY" ></td><td width="25%"><label for="ausbildung_stelle"></label><textarea class="span8" type="text" placeholder="Ausbildungs-, Studiumsstelle" name="ausbildung_stelle" rows="1" cols="31"></textarea></td> <td width="25%"><label for="ausbildung_ort"></label><textarea class="span8" type="text" placeholder="Ort" name="ausbildung_ort" rows="1" cols="31"></textarea></td>    </div></td></tr></table>';
	cnt = papaTable.childElementCount - 2 
	console.log(papaTable)
	papaTable.appendChild(sd)
}

 </script>
    <div id="popo0-parent">
        <table name="table_2">          
            <tr>
               <td width="25%">
                    <div class="row">
                    <div class="small-12 columns">
                    <label for="ausbildung_begin"></label>
                    <input type="date" id="ausbildung_begin" name="ausbildung_begin" placeholder="Anfangsjahr, DD-MM-YYYY" ></td>
               <td width="25%">
                    <label for="ausbildung_end"></label>
                    <input type="date" id="ausbildung_end" name="ausbildung_end" placeholder="Endungsjahr, DD-MM-YYYY" ></td>
               <td width="25%">
                    <label for="ausbildung_stelle"></label>
                    <textarea class="span8" type="text" placeholder="Ausbildungs-, Studiumsstelle" name="ausbildung_stelle" rows="1" cols="31"></textarea></td> 
               <td width="25%">
                    <label for="ausbildung_ort"></label>
                    <textarea class="span8" type="text" placeholder="Ort" name="ausbildung_ort" rows="1" cols="31"></textarea></td>    
                    </div>
               </td>
             </tr>
         </table>
     </div>
         <table name="table_2_0">
             <tr>
		       <td width="25%"> 
		  <button class="plus" type="button" onclick="go()">Add
		  </button>
		  <button class="delete" type="button" onclick="remove_0()">Delete
		  </button></td>
		       <td width="25%"></td>
               <td width="25%"></td>
               <td width="25%"></td> 
	         </tr> 
         </table>  
    <h2>Berufserfahrung</h2> 
 <script>
 
 var anzahl = 0;
 function remove_1() {
 
 var popo1 = document.getElementById('popo1new-' + anzahl);
 //var sd = document.createElement('table_3');
 
 popo1.remove();
 anzahl = anzahl -1;
}
  function go_1() {
	 
  
  anzahl = anzahl + 1;  
	  
  var papaTable = document.getElementById('popo1-parent') 
  var sd = document.createElement('div'); 
  sd.innerHTML ='<table id="popo1new-'+ anzahl +'" name="table_3"><tr><td width="25%"> <div class="row"><div class="small-12 columns"><label for="beruf_begin"></label><input type="date" id="beruf_begin" name="beruf_begin" placeholder="Anfangsjahr, DD-MM-YYYY" ></td><td width="25%"><label for="beruf_end"></label><input type="date" id="beruf_end" name="beruf_end" placeholder="Endungsjahr, DD-MM-YYYY" ></td><td width="25%"><label for="beruf_stelle"></label><textarea class="span8" type="text" placeholder="Arbeitsstelle" name="beruf_stelle" rows="1" cols="31"></textarea></td><td width="25%"> <label for="beruf_position"></label><textarea class="span8" type="text" placeholder="Position" name="beruf_position" rows="1" cols="31"></textarea></td>  </div></tr></table>';
  cnt = papaTable.childElementCount - 2 
  console.log(papaTable)
  papaTable.appendChild(sd)
}
  
 </script>
     <div id="popo1-parent">
         <table name="table_3">          
             <tr>
                <td width="25%">
                     <div class="row">
                     <div class="small-12 columns">
                     <label for="beruf_begin"></label>
                     <input type="date" id="beruf_begin" name="beruf_begin" placeholder="Anfangsjahr, DD-MM-YYYY" ></td>
                <td width="25%">
                     <label for="beruf_end"></label>
                     <input type="date" id="beruf_end" name="beruf_end" placeholder="Endungsjahr, DD-MM-YYYY" ></td>
                <td width="25%">
                     <label for="beruf_stelle"></label>
                     <textarea class="span8" type="text" placeholder="Arbeitsstelle" name="beruf_stelle" rows="1" cols="31"></textarea></td>
                <td width="25%">
                     <label for="beruf_position"></label>
                     <textarea class="span8" type="text" placeholder="Position" name="beruf_position" rows="1" cols="31"></textarea></td>    
                     </div>  
             </tr>
         </table>
     </div>
         <table name="table_3_0">
             <tr>
		        <td width="25%"> 
		  <button class="plus" type="button" onclick="go_1()">Add
		  </button>
		  <button class="delete" type="button" onclick="remove_1()">Delete
		  </button></td>
		        <td width="25%"></td>
                <td width="25%"></td>
                <td width="25%"></td> 
	         </tr>
         </table>	   
    <h2>Fachkenntnisse</h2> 
 <script>
 
 var anzahl = 0;
 function remove_2() {
 
 var popo2 = document.getElementById('popo2new-' + anzahl);
 //var sd = document.createElement('table_4');
 
 popo2.remove();
 anzahl = anzahl -1;
}
  	 
  function go_2() {
	  
  anzahl = anzahl + 1;  
  
  var papaTable = document.getElementById('popo2-parent') 
  var sd = document.createElement('div'); 
  sd.innerHTML ='<table id="popo2new-'+ anzahl +'" name="table_4"><tr><td width="25%"> <div class="row"><div class="small-12 columns"><label for="fach_gebiet"></label><textarea id="gebiet" class="span8" type="text" placeholder="Gebiet" name="fach_gebiet" rows="1" cols="31"></textarea></td>   </div><td width="25%"><div class="row"> <div class="small-12 columns"> <label for="fach_kenntnisse"></label> <textarea id="kenntnisse" class="span8" type="text" placeholder="Kenntnisse" name="fach_kenntnisse" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea> </td>  </div> <td width="25%"></td><td width="25%"></td></tr></table>';
  cnt = papaTable.childElementCount - 2 
  console.log(papaTable)
  papaTable.appendChild(sd)
}
       
 </script>
 <div id="popo2-parent">
         <table id="popo2-0" name="table_4"> 
             <tr>
                <td width="25%">
                     <div class="row">
                     <div class="small-12 columns">
		             <label for="fach_gebiet"></label>
		             <textarea id="gebiet" class="span8" type="text" placeholder="Gebiet" name="fach_gebiet" rows="1" cols="31"></textarea>
		        </td>        
                     </div>
                <td width="25%">
                     <div class="row">
                     <div class="small-12 columns">
		             <label for="fach_kenntnisse"></label>
		             <textarea id="kenntnisse" class="span8" type="text" placeholder="Kenntnisse" name="fach_kenntnisse" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea>
		        </td>        
                     </div>    
                <td width="25%"></td>
                <td width="25%"></td>
             </tr>
         </table>
            </div> 
         <table name="table_4_0">
             <tr>
		        <td width="25%"> 
		  <button class="plus" type="button" onclick="go_2()">Add
		  </button>
		  <button class="delete" type="button" onclick="remove_2()">Delete
		  </button></td>
		        <td width="25%"></td>
                <td width="25%"></td>
                <td width="25%"></td> 
	         </tr>
         </table>	
        
	<h2>Projekte</h2>
 <script>
  var anzahl = 0;
  function remove_3() {
  
  var popo3 = document.getElementById('popo3new-' + anzahl);
  //var sd = document.createElement('table_5');
  
  popo3.remove();
  anzahl = anzahl -1;
}
  function go_3() {
	  
  anzahl = anzahl + 1;
  var papaTable = document.getElementById('popo3-0').parentNode
  var sd = document.createElement('div');
  sd.innerHTML ='<table id="popo3new-' + anzahl +'" name="table_5"><tr> <td width="25%"><div class="row"> <div class="small-12 columns"><label for="projekte_datum1"></label><input type="date" id="projekte_datum1" name="projekte_datum1" placeholder="Anfang, MM-YYYY" ></td> </div> <td width="25%"><div class="row"><div class="small-12 columns"><label for="projekte_kunde">Kunde</label> </td><td width="25%"><textarea class="span8" type="text" name="projekte_kunde" rows="1" cols="31"></textarea>  </div></td><td width="25%"></td> </tr><tr><td width="25%"><div class="row"><div class="small-12 columns"> <label for="projekte_datum2"></label> <input type="date" id="projekte_datum2" name="projekte_datum2" placeholder="Endung, MM-YYYY" ></td></div> <td width="25%"> <div class="row"><div class="small-12 columns"><label for="projekte_thematik">Thematik</label> </td> <td width="25%"> <textarea class="span8" type="text" name="projekte_thematik" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea> </div></td><td width="25%"></td> </tr> <tr><td width="25%"></td> <td width="25%"> <div class="row"><div class="small-12 columns"> <label for="projekte_rolle">Rolle</label></td><td width="25%"><textarea class="span8" type="text" name="projekte_rolle" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea>  </div> </td> <td width="25%"></td> </tr><tr><td width="25%"></td><td width="25%"> <div class="row"><div class="small-12 columns"> <label for="projekte_technologie">Technologie</label></td><td width="25%"><textarea class="span8" type="text" name="projekte_technologie" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea></div> </td><td width="25%"></td></tr></table>';
  cnt = papaTable.childElementCount -2
  papaTable.insertBefore(sd, papaTable.children[cnt])
}
 </script>
          <table id="popo3-0" name="table_5">
               <tr>
                 <td width="25%">
                    <div class="row">
                     <div class="small-12 columns">
                     <label for="projekte_datum1"></label>
                     <input type="date" id="projekte_datum1" name="projekte_datum1" placeholder="Anfang, MM-YYYY" ></td>
                     </div> 
                 <td width="25%">
                     <div class="row">
                     <div class="small-12 columns">
                     <label for="projekte_kunde">Kunde</label>
                 </td>
                 <td width="25%">
                     <textarea class="span8" type="text" name="projekte_kunde" rows="1" cols="31"></textarea> 
                     </div>
                 </td>
                 <td width="25%"></td>
              </tr>
              <tr>
                 <td width="25%">
					 <div class="row">
                     <div class="small-12 columns">
                     <label for="projekte_datum1"></label>
                     <input type="date" id="projekte_datum2" name="projekte_datum2" placeholder="Endung, MM-YYYY" ></td>
                     </div>
                 <td width="25%">
                     <div class="row">
                     <div class="small-12 columns">
                     <label for="projekte_thematik">Thematik</label>
                 </td>
                 <td width="25%">
                     <textarea class="span8" type="text" name="projekte_thematik" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea> 
                     </div>
                 </td>
                 <td width="25%"></td>
              </tr>
               <tr>
                 <td width="25%"></td>
                 <td width="25%">
                     <div class="row">
                     <div class="small-12 columns">
                     <label for="projekte_rolle">Rolle</label>
                 </td>
                 <td width="25%">
                     <textarea class="span8" type="text" name="projekte_rolle" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea> 
                     </div>
                 </td>
                 <td width="25%"></td>
              </tr>
                <tr>
                 <td width="25%"></td>
                 <td width="25%">
                     <div class="row">
                     <div class="small-12 columns">
                     <label for="projekte_technologie">Technologie</label>
                 </td>
                 <td width="25%">
                     <textarea class="span8" type="text" name="projekte_technologie" rows="1" cols="31" title="Füllen Sie diese Feld durch das Komma aus"></textarea>
                     </div>
                 </td>
                 <td width="25%"></td>
              </tr>
        </table>
        <table name="table_6">
             <tr>
                 <td width="25%">
         <button class="plus" type="button"  onclick="go_3()">Add
         </button>
         <button class="delete" type="button" onclick="remove_3()">Delete
         </button>
                 <td width="25%"></td>
                 <td width="25%"></td>
                 <td width="25%"></td>
             </tr>
        </table>
        <table name="table_7">
              <tr>
                  <td width="25%">  
        <input type="submit" value="Download PDF File"/>
                  </td>
                  <td width="25%"></td>
                  <td width="25%"></td>
                  <td width="25%"></td>
              </tr>
            </table>
          </form>
      </ul>
    <div id="message"><a href="#top">Scroll to top</a></div>     
    </body>
</html>
