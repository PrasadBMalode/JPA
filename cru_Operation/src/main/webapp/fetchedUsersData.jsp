<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">
        <div class="col-lg-10">

            <div class="card shadow">
                <div class="card-body">

                <!-- Page Title -->
                    <div class="text-center mb-4">
                        <h2 class="fw-bold text-primary">Registered Users</h2>
                        <p class="text-muted">List of all users stored in database</p>
                    </div>

                    <table class="table table-bordered table-striped table-hover text-center align-middle">
                        <thead class="table-primary ">
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th>Contact Number</th>
                                <th>Update</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${usersDTOS}" var="singleDto">
                                <tr>
                                    <td>${singleDto.name}</td>
                                    <td>${singleDto.email}</td>
                                    <td>${singleDto.age}</td>
                                    <td>${singleDto.gender}</td>
                                    <td>${singleDto.contactNumber}</td>
                                    <td><a href="updatExistUser?id=${singleDto.id}">Update </a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                </div>
            </div>

        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>