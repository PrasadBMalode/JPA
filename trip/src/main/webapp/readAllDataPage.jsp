<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

    <div class="container mt-5">

        <div class="card shadow-lg">
            <div class="card-header bg-primary text-white text-center">
                <h1 class="h3 mb-0">Get Entitys list from DB...!</h1>
            </div>

            <div class="card-body">

                <div class="table-responsive">
                    <table class="table table-bordered table-striped table-hover align-middle text-center">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Age</th>
                                <th>Name</th>
                                <th>School/College</th>
                                <th>Location</th>
                                <th>Gender</th>
                                <th>Class</th>
                                <th>Email</th>
                                <th>Contact Number</th>
                                <th>Updata here</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${tripDtos}" var="singleDTO">
                                <tr>
                                    <td>${singleDTO.id}</td>
                                    <td>${singleDTO.age}</td>
                                    <td>${singleDTO.name}</td>
                                    <td>${singleDTO.cllgName}</td>
                                    <td>${singleDTO.location}</td>
                                    <td>${singleDTO.gender}</td>
                                    <td>${singleDTO.className}</td>
                                    <td>${singleDTO.email}</td>
                                    <td>${singleDTO.contactNumber}</td>
                                    <td><a href="readData?id=${singleDTO.id}">update</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>

            </div>
        </div>

    </div>


</body>

</html>