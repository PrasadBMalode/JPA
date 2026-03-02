<%@ page isELIgnored="false" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>User Registration</title>

        <!-- Bootstrap 5 CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body class="bg-light">

        <div class="container mt-5 mb-5">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">

                    <div class="card shadow-lg border-0 rounded-4">
                        <div class="card-header bg-primary text-white text-center rounded-top-4">
                            <h4 class="mb-0">User Details Update Here</h4>
                        </div>

                        <div class="card-body p-4">

                            <form action="update" method="post">

                                <!-- ID -->
                                <div class="mb-3">
                                    <label class="form-label fw-semibold">ID</label>
                                    <input type="number" class="form-control" name="id"
                                        placeholder="Your ID" value="${byID.id}" required readonly>
                                </div>

                                <!-- Name -->
                                <div class="mb-3">
                                    <label class="form-label fw-semibold">Full Name</label>
                                    <input type="text" class="form-control" name="name"
                                        placeholder="Enter your full name" value="${byID.name}" required>
                                </div>

                                <!-- Email -->
                                <div class="mb-3">
                                    <label class="form-label fw-semibold">Email Address</label>
                                    <input type="email" class="form-control" name="email" placeholder="Enter your email"
                                       value="${byID.email}" required readonly>
                                </div>

                                <!-- Age -->
                                <div class="mb-3">
                                    <label class="form-label fw-semibold">Age</label>
                                    <input type="number" class="form-control" name="age" placeholder="Enter your age" value="${byID.age}"
                                         required>
                                </div>

                                <!-- Gender -->
                                <div class="mb-3">
                                    <label class="form-label fw-semibold d-block">Gender</label>

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
                                <div class="mb-4">
                                    <label class="form-label fw-semibold">Contact Number</label>
                                    <input type="tel" class="form-control" name="contactNumber"
                                        placeholder="Enter your contact number" value="${byID.contactNumber}" required readonly>
                                </div>

                                <!-- Submit Button -->
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-primary btn-lg rounded-pill">
                                        Update
                                    </button>
                                </div>

                            </form>

                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    </html>