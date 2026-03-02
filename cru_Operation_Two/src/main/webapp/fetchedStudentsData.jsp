<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student List</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h4 class="mb-0">Student Details</h4>
        </div>

        <div class="card-body">

            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered align-middle text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Name</th>
                            <th>Age</th>
                            <th>College Name</th>
                            <th>Contact Number</th>
                            <th>Update<th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${studentDTOS}" var="singledto">
                            <tr>
                                <td>${singledto.name}</td>
                                <td>${singledto.age}</td>
                                <td>${singledto.cllgName}</td>
                                <td>${singledto.contactNumber}</td>
                                <td><a href="getDTO?id=${singledto.id}">Update</a></td>
                            </tr>
                        </c:forEach>

                        <!-- Optional: Show message if list is empty -->
                        <c:if test="${empty studentDTOS}">
                            <tr>
                                <td colspan="4" class="text-muted">No student records available</td>
                            </tr>
                        </c:if>

                    </tbody>
                </table>
            </div>

        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>