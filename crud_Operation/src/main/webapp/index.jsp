<%@ page isELIgnored="false" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>User Form</title>

        <!-- Bootstrap CDN -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body class="bg-light">

        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">

                    <div class="card shadow">
                        <div class="card-header text-center">
                            <h4>User Form</h4>
                        </div>

                        <div class="card-body">

                            <h6 style="color:green">${registerDone}</h6>
                            <h6 style="color:red">${failed}</h6>
                            <h6 style="color:red">${exist}</h6>
                            <form action="registration" method="post">

                                <div class="card-footer text-center bg-white border-0">
                                    <small class="text-muted">
                                        If you want to all users details? click here... <a href="readAllData"
                                            class="text-decoration-none">Read All</a>
                                    </small>
                                </div>

                                <!-- <div class="mb-3">
                            <label class="form-label">ID</label>
                            <input type="number" class="form-control" name="id" required onlyread>
                        </div> -->

                                <div class="mb-3">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" name="name" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Age</label>
                                    <input type="number" class="form-control" name="age" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Location</label>
                                    <input type="text" class="form-control" name="location" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Phone Number</label>
                                    <input type="tel" class="form-control" name="phNumber" required>
                                </div>

                                <div class="d-grid">
                                    <button type="submit" class="btn btn-primary">
                                        Register
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