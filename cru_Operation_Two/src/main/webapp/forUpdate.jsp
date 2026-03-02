<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-body">
                    <h3 class="text-center mb-4">Student Registration</h3>



                    <form action="update" method="post">

                        <div class="mb-3">
                        <label class="form-label">ID</label>
                        <input type="number" class="form-control" name="id" value="${studentDTO.id}" required readonly>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="name" value="${studentDTO.name}" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Age</label>
                            <input type="number" class="form-control" name="age" value="${studentDTO.age}" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">College Name</label>
                            <input type="text" class="form-control" name="cllgName" value="${studentDTO.cllgName}" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Contact Number</label>
                            <input type="tel" class="form-control" name="contactNumber" value="${studentDTO.contactNumber}" required readonly>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">
                                Update
                            </button><br><br>
                        </div>

                    </form>


                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>