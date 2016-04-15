<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
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
   
   button{ color:#0DECDC }
   
   body{ background-color:#FCFEFC; color:#000000; }
   
   img{ 
   
  </style>
  
</head>
<body>
	<img src="/home/alena/Desktop/Lebenslauf/codecentric-ag.gif" style="float:all;padding:0 5px 5px 30px;" />
  <ul>
	<form action="result" method="POST" >
    
      <h2>Zur Person</h2> 
  <table name="table_1">         
       <tr>
          <td width="25%">Name
          <div class="row">
    <div class="small-12 columns">
		<label for="name"></label></td>
          <td width="25%">
          <input type="text" name="name" />
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
          <input type="text" name="vorname" />
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
          <input type="date" name="geburtsdatum" placeholder="DD-MM-YYYY" />
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
          <input type="text" name="wohnort" />
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
          <input type="text" name="nationalitaet" />
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
          <input type="text" name="sprachen" />
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
          <input type="text" name="telefon" />
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
          <input type="text" name="email" />
    </div>
          </td>
          <td width="25%"></td>
          <td width="25%"></td>
       </tr>
  </table>         
        <h2>Ausbildung/Universität</h2> 
  <script>
  function go() {
  var papaTr = document.getElementById('popo').parentNode //Получаем родителя элемента ПЕРЕД которым будем вставлять новую строку
  var sd = document.createElement('tr'); //<- Создаем новую строку. А строкой нижи хардкорно заполняем(лень было делать нормально)
  sd.innerHTML = '<td width="25%"><div class="row"><div class="small-12 columns"><label for="ausbildung_datum_1"></label><input type="date" id="ausbildung_datum_1" name="ausbildung_datum_1" placeholder="Anfangsjahr, DD-MM-YYYY" ></td>          <td width="25%">        <label for="ausbildung_datum_2"></label>        <input type="date" id="ausbildung_datum_2" name="ausbildung_datum_2" placeholder="Endungsjahr, DD-MM-YYYY" ></td><td width="25%"><label for="ausbildung_stelle"></label><input type="text" name="ausbildung_stelle" placeholder="Ausbildungs-, Studiumsstelle" ></td><td width="25%"><label for="ausbildung_ort"></label><input type="text" name="ausbildung_ort" placeholder="Ort" ></td></div></td>';
  cnt = papaTr.childElementCount - 1 //смотрим сколько потомков и элемента и отнимаем один, чтобы записать строку перед последней строкой где кнопка
  papaTr.insertBefore(sd, papaTr.children[cnt]) //записываем строку в родителя перед последней строкой
}
  </script>
  <table name="table_2">          
         <tr>
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
        <label for="ausbildung_datum_1"></label>
        <input type="date" id="ausbildung_datum_1" name="ausbildung_datum_1" placeholder="Anfangsjahr, DD-MM-YYYY" ></td>
          <td width="25%">
        <label for="usbildung_datum_2"></label>
        <input type="date" id="ausbildung_datum_2" name="ausbildung_datum_2" placeholder="Endungsjahr, DD-MM-YYYY" ></td>
          <td width="25%">
        <label for="ausbildung_stelle"></label>
        <input type="text" name="ausbildung_stelle" placeholder="Ausbildungs-, Studiumsstelle" ></td>
          <td width="25%">
        <label for="ausbildung_ort"></label>
        <input type="text" name="ausbildung_ort" placeholder="Ort" ></td>    
 </div>
          </td>
       </tr>
        <tr id="popo">
		  <td width="25%"> 
		  <button class="plus" type="button" onclick="go()">Add
		  </button>
		  </td>
		  <td width="25%"></td>
          <td width="25%"></td>
          <td width="25%"></td> 
	   </tr> 
  </table>  
    <h2>Berufserfahrung</h2> 
    <script>
  function go_1() {
  var papaTr = document.getElementById('popo1').parentNode //Получаем родителя элемента ПЕРЕД которым будем вставлять новую строку
  var sd = document.createElement('tr'); //<- Создаем новую строку. А строкой нижи хардкорно заполняем(лень было делать нормально)
  sd.innerHTML ='<td width="25%"><div class="row"><div class="small-12 columns"><label for="beruf_datum_1"></label><input type="date" id="beruf_datum_1" name="beruf_datum_1" placeholder="Anfangsjahr, DD-MM-YYYY" ></td><td width="25%"><label for="beruf_datum_2"></label><input type="date" id="beruf_datum_2" name="beruf_datum_2" placeholder="Endungsjahr, DD-MM-YYYY" ></td><td width="25%"><label for="beruf_stelle"></label><input type="text" name="beruf_stelle" placeholder="Arbeitsstelle" ></td><td width="25%"><label for="beruf_ort"></label><input type="text" name="beruf_ort" placeholder="Ort" ></td></div></td>';
  cnt = papaTr.childElementCount - 1 //смотрим сколько потомков и элемента и отнимаем один, чтобы записать строку перед последней строкой где кнопка
  papaTr.insertBefore(sd, papaTr.children[cnt]) //записываем строку в родителя перед последней строкой
}
  </script>
  <table name="table_3">          
         <tr>
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
        <label for="beruf_datum_1"></label>
        <input type="date" id="beruf_datum_1" name="beruf_datum_1" placeholder="Anfangsjahr, DD-MM-YYYY" ></td>
          <td width="25%">
        <label for="beruf_datum_2"></label>
        <input type="date" id="beruf_datum_2" name="beruf_datum_2" placeholder="Endungsjahr, DD-MM-YYYY" ></td>
          <td width="25%">
        <label for="beruf_stelle"></label>
        <input type="text" name="beruf_stelle" placeholder="Arbeitsstelle" ></td>
          <td width="25%">
        <label for="beruf_ort"></label>
        <input type="text" name="beruf_ort" placeholder="Ort" ></td>    
 </div>
          </td>
       </tr>
        <tr id="popo1">
		  <td width="25%"> 
		  <button class="plus" type="button" onclick="go_1()">Add
		  </button>
		  </td>
		  <td width="25%"></td>
          <td width="25%"></td>
          <td width="25%"></td> 
	   </tr>
  </table>	   
       <h2>Fachkenntnisse</h2> 
  <script>
  function go_2() {
  var papaTr = document.getElementById('popo2').parentNode //Получаем родителя элемента ПЕРЕД которым будем вставлять новую строку
  var sd = document.createElement('tr'); //<- Создаем новую строку. А строкой нижи хардкорно заполняем(лень было делать нормально)
  sd.innerHTML ='<td width="25%"><div class="row"><div class="small-12 columns"><label for="gebiet"></label><input type="text" name="gebiet" placeholder="Gebiet" /></td></div><td width="25%"><div class="row"><div class="small-12 columns"><label for="kenntnisse"></label><input type="text" name="kenntnisse" placeholder="Kenntnisse" /></td></div><td width="25%"></td><td width="25%"></td>';
  cnt = papaTr.childElementCount - 1 //смотрим сколько потомков и элемента и отнимаем один, чтобы записать строку перед последней строкой где кнопка
  papaTr.insertBefore(sd, papaTr.children[cnt]) //записываем строку в родителя перед последней строкой
}
  </script>
  <table name="table_4"> 
       <tr>
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
		<label for="fach_gebiet"></label>
		<input type="text" name="fach_gebiet" placeholder="Gebiet" />
		</td>        
    </div>
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
		<label for="kenntnisse"></label>
		<input type="text" name="kenntnisse" placeholder="Kenntnisse" />
		</td>        
    </div>
          <td width="25%"></td>
          <td width="25%"></td>
       </tr>
       <tr id="popo2">
		  <td width="25%"> 
		  <button class="plus" type="button" onclick="go_2()">Add
		  </button>
		  </td>
		  <td width="25%"></td>
          <td width="25%"></td>
          <td width="25%"></td> 
	   </tr>
  </table>	   
	   <h2>Projekte</h2> 
  <table name="table_5"> 
       <tr>
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
		<label for="datum_3"></label>
        <input type="date" id="datum_3" name="datum_3" placeholder="Datum, MM-YYYY" ></td>     
    </div>
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
		<label for="kunde">Kunde</label>
		</td>        
          <td width="25%">
          <input type="text" name="kunde" />
          </td>
          </div>
          <td width="25%"></td>
       </tr>
       <tr>
          <td width="25%"></td>     
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
		<label for="thematik">Thematik</label>
		</td>        
          <td width="25%">
          <input type="text" name="thematik" />
          </div>
          </td>
          <td width="25%"></td>
       </tr>
       <tr>
          <td width="25%">
          <div class="row"></td>     
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
		<label for="rolle">Rolle</label>
		</td>        
          <td width="25%">
          <input type="text" name="rolle" />
          </div>
          </td>
          <td width="25%"></td>
       </tr>
       <tr>
          <td width="25%"></td>
          <td width="25%">
          <div class="row">
    <div class="small-12 columns">
		<label for="technologie">Technologie</label>
		</td>        
          <td width="25%">
          <input type="text" name="technologie" />
          </div>
          </td>
          <td width="25%"></td>
        </tr>
        <tr>
		  <td width="25%"> 
		  <button class="plus" type="button">Add</button>
		  </td>
		  <td width="25%"></td>
          <td width="25%"></td>
          <td width="25%"></td> 
	   </tr>
 </table name="table_5">
 <table name="table_6">
  <tr>
      <td width="25%">  
      <input type="submit" value="Download PDF File"/>
     </td>
     <td width="25%"></td>
     <td width="25%"></td>
     <td width="25%"></td>
  </tr>
 </table name="table_6">
</form>
</ul>
</body>
</html>
