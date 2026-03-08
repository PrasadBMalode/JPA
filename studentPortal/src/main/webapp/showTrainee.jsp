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
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Contact Number</th>
        <th>Age</th>
        <th>College Name</th>
        <th>Location</th>
        <th>Update</th>
        <th>delete</th>
    </tr>

//iterate
   <c:forEach items="${list}" var="singleDto">
   <tr>
   <td>${singleDto.name}</td>
   <td>${singleDto.email}</td>
   <td>${singleDto.contactNumber}</td>
   <td>${singleDto.age}</td>
   <td>${singleDto.cllgName}</td>
   <td>${singleDto.location}</td>
   <td><a href="getData?email=${singleDto.email}">update</a></td>
   <td><a href="deleteData?email=${singleDto.email}">delete</a></td>
   </tr>
    </c:forEach>

</table>

</body>
</html>