<%@ page isELIgnored="false" %>

<!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Update Form</title>

            <!-- Bootstrap CDN -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body class="bg-light">

            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-6">

                        <div class="card shadow">
                            <div class="card-header text-center">
                                <h4>Update Form</h4>
                            </div>

                            <div class="card-body">

                                <form action="update" method="post">

                                 <div class="mb-3">
                                        <label class="form-label">ID</label>
                                        <input type="number" class="form-control" name="id" value="${userDTO.id}" required readonly>
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Name</label>
                                        <input type="text" class="form-control" name="name" value="${userDTO.name}" required>
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Age</label>
                                        <input type="number" class="form-control" name="age" value="${userDTO.age}" required>
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Location</label>
                                        <input type="text" class="form-control" name="location" value="${userDTO.location}" required>
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Phone Number</label>
                                        <input type="tel" class="form-control" name="phNumber" value="${userDTO.phNumber}" required readonly>
                                    </div>

                                    <div class="d-grid">
                                        <button type="submit" class="btn btn-primary">
                                            Update
                                        </button>
                                    </div>

                                </form>
                            </div>

                        </div>

                    </div>
                </div>
            </div>

       </body>

</html>