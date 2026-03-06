<%@ page isELIgnored="false" %>


    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Registration Form</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body class="bg-warning bg-opacity-25">

        <div class="container d-flex justify-content-center align-items-center min-vh-100">
            <div class="card shadow-lg border-0 rounded-4" style="width: 100%; max-width: 500px;">

                <div class="card-header bg-warning text-dark text-center rounded-top-4">
                    <h3 class="fw-bold">Update Form</h3>
                </div>

                <div class="card-body p-4 bg-light">

                   <form action="update" method="post">

                    <!-- ID -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">ID</label>
                            <input type="number" class="form-control border-warning focus-ring focus-ring-warning"
                                name="id" placeholder="Enter your full name" value="${byID.id}" required readonly>
                        </div>

                        <!-- Full Name -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Full Name</label>
                            <input type="text" class="form-control border-warning focus-ring focus-ring-warning"
                                name="name" placeholder="Enter your full name" value="${byID.name}" required>
                        </div>

                        <!-- Age -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Age</label>
                            <input type="number" class="form-control border-warning" name="age"
                                placeholder="Enter your age" min="1" value="${byID.age}" required>
                        </div>

                        <!-- Vehicle -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Vehicle Name</label>
                            <input type="text" class="form-control border-warning" name="vehical"
                                placeholder="Enter your vehicle name" value="${byID.vehical}" required >
                        </div>

                        <!-- Email -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Email Address</label>
                            <input type="email" class="form-control border-warning" name="email"
                                placeholder="Enter your email" value="${byID.email}" required readonly>
                        </div>

                        <!-- Contact Number -->
                        <div class="mb-4">
                            <label class="form-label fw-semibold">Contact Number</label>
                            <input type="tel" class="form-control border-warning" name="contactNumber"
                                placeholder="Enter your contact number" value="${byID.contactNumber}" required readonly>
                        </div>

                        <!-- Submit Button -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-warning btn-lg fw-bold rounded-pill shadow-sm">
                                Update
                            </button>
                        </div>

                    </form>

                </div>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    </html>