<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Driver List</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-warning-subtle">

<div class="container mt-5">

    <div class="card shadow-lg border-warning">
        <div class="card-header bg-warning text-dark text-center fw-bold fs-4">
            Drivers Information
        </div>

        <div class="card-body">

            <table class="table table-bordered table-hover table-warning text-center align-middle">
                <thead class="table-warning">
                <tr class="table-warning">
                    <th class="bg-warning text-dark">Name</th>
                    <th class="bg-warning text-dark">Age</th>
                    <th class="bg-warning text-dark">Email</th>
                    <th class="bg-warning text-dark">Contact Number</th>
                    <th class="bg-warning text-dark">Vehicle Name</th>
                    <th class="bg-warning text-dark">Update</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${driverDTOS}" var="singleDTO">
                    <tr>
                        <td>${singleDTO.name}</td>
                        <td>${singleDTO.age}</td>
                        <td>${singleDTO.email}</td>
                        <td>${singleDTO.contactNumber}</td>
                        <td>${singleDTO.vehical}</td>
                        <td><a href="fetchingForUpdate?id=${singleDTO.id}">UPDATE</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>

        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>