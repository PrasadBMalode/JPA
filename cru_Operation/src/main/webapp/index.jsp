<%@ page isELIgnored="false" %>


    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>User Registration</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap 5 CSS CDN -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body class="bg-light">

        <div class="container mt-5 mb-5">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">

                    <div class="card shadow-lg border-0 rounded-4">
                        <div class="card-header bg-primary text-white text-center rounded-top-4">
                            <h3 class="mb-0">Registration Form</h3>
                        </div>

                        <div class="card-footer text-center bg-white border-0">
                            <small class="text-muted">
                                If you want to  all users details? click here... <a href="fetchData" class="text-decoration-none">Read All</a>
                            </small>
                        </div>

                        <div class="card-body p-4">
                            <h6 style="color:green">${savedDB}</h6>
                            <h6 style="color:red">${registerFail}</h6>
                            <h6 style="color:red">${existUser}</h6>
                            <h6 style="color:red">${notValidData}</h6>

                            <form action="register" method="post">

                                <!-- Name -->
                                <div class="mb-3">
                                    <label class="form-label">Full Name</label>
                                    <input type="text" class="form-control" name="name"
                                        placeholder="Enter your full name" required>
                                </div>

                                <!-- Email -->
                                <div class="mb-3">
                                    <label class="form-label">Email Address</label>
                                    <input type="email" class="form-control" name="email" placeholder="Enter your email"
                                        required>
                                </div>

                                <!-- Age -->
                                <div class="mb-3">
                                    <label class="form-label">Age</label>
                                    <input type="number" class="form-control" name="age" placeholder="Enter your age"
                                        min="1" required>
                                </div>

                                <!-- Gender -->
                                <div class="mb-3">
                                    <label class="form-label d-block">Gender</label>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" value="Male"
                                            required>
                                        <label class="form-check-label">Male</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" value="Female">
                                        <label class="form-check-label">Female</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" value="Other">
                                        <label class="form-check-label">Other</label>
                                    </div>
                                </div>

                                <!-- Contact Number -->
                                <div class="mb-3">
                                    <label class="form-label">Contact Number</label>
                                    <input type="tel" class="form-control" name="contactNumber"
                                        placeholder="Enter your contact number" required>
                                </div>

                                <!-- Submit Button -->
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-primary btn-lg rounded-pill">
                                        Register
                                    </button>
                                </div>

                            </form>
                        </div>

                        <div class="card-footer text-center bg-white border-0">
                            <small class="text-muted">
                                Already have an account? <a href="#" class="text-decoration-none">Login here</a>
                            </small>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    </html>