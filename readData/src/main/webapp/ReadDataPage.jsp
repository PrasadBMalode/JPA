<%@ page isELIgnored="false" %>

    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <h1>Get Entitys list from DB...!</h1><br>

    <table border="2">
        <tr>
            <th>Age</th>
             <th>Name</th>
              <th>Location</th>
               <th>Number</th>
        </tr>

        <c:forEach items="${dtos}" var="singleDTO">
            <tr>
                <td>${singleDTO.age}</td>
                <td>${singleDTO.name}</td>
                <td>${singleDTO.location}</td>
                <td>${singleDTO.number}</td>
            </tr>
    
    </c:forEach>
      
    </table>


</body>
</html>