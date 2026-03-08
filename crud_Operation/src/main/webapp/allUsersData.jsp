<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Details</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg">

        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">

            <h4 class="mb-0">
                <i class="bi bi-people-fill"></i> User Details
            </h4>

            <!-- Search Bar -->
            <div class="input-group w-50">
                <span class="input-group-text">
                    <i class="bi bi-search"></i>
                </span>
                <input type="text" id="searchInput" onkeyup="searchTable()" class="form-control" placeholder="Search users...">
            </div>

        </div>

        <div class="card-body">

            <!-- Responsive Table -->
            <div class="table-responsive">

                <table class="table table-striped table-hover table-bordered text-center align-middle" id="userTable">

                    <thead class="table-dark">
                        <tr>
                            <th><i class="bi bi-hash"></i> ID</th>
                            <th><i class="bi bi-person"></i> Name</th>
                            <th><i class="bi bi-calendar"></i> Age</th>
                            <th><i class="bi bi-geo-alt"></i> Location</th>
                            <th><i class="bi bi-telephone"></i> Phone Number</th>
                            <th><i class="bi bi-pencil-square"></i> Update</th>
                            <th><i class="btn btn-danger btn-sm"></i> Delete</th>
                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach items="${dto}" var="singleDto">
                            <tr>
                                <td>${singleDto.id}</td>
                                <td>${singleDto.name}</td>
                                <td>${singleDto.age}</td>
                                <td>${singleDto.location}</td>
                                <td>${singleDto.phNumber}</td>
                                <td><a href="fetchingData?id=${singleDto.id}">UPDATE</a></td>
                                <td><a href="delteUser?phNumber=${singleDto.phNumber}">DELETE</a></td>

                            </tr>
                        </c:forEach>

                    </tbody>

                </table>

            </div>

        </div>

    </div>

</div>


<script>

function searchTable() {

    let input = document.getElementById("searchInput").value.toLowerCase();
    let table = document.getElementById("userTable");
    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {

        let rowText = tr[i].textContent.toLowerCase();

        if (rowText.includes(input)) {
            tr[i].style.display = "";
        } else {
            tr[i].style.display = "none";
        }

    }
}

</script>

</body>
</html>