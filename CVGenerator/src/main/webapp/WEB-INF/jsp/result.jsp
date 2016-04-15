<%@taglib uri= "http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Result</title>
</head>
<body>
  <h1>Submitted Student Information</h1>
  <table>
      <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${age}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${id}</td>
    </tr> 
  
  </table>
</body>

</html>