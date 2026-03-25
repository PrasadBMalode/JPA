<%@ page isELIgnored="false" %>


    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Profile</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

        <style>
            body {
                background-image: url("https://images.unsplash.com/photo-1507525428034-b723cf961d3e");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                min-height: 100vh;
            }

            .card {
                background: rgba(255, 255, 255, 0.2);
                backdrop-filter: blur(10px);
                border-radius: 15px;
                border: 1px solid rgba(255, 255, 255, 0.3);
            }

            .form-control,
            .form-select {
                background: rgba(255, 255, 255, 0.8);
            }

            .nav-logo {
                height: 70px;
            }
        </style>

    </head>

    <body>

        <!-- NAVBAR -->

        <nav class="navbar navbar-dark bg-dark">
            <div class="container d-flex align-items-center">

                <!-- Xworkz Logo Left -->
                <a class="navbar-brand d-flex align-items-center">
                    <img src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
                        class="nav-logo" alt="Xworkz Logo">
                </a>

                <!-- Right Side Buttons -->
                <div class="position-absolute  end-0 d-flex gap-3 m-3">


                    <!-- Home Button -->
                    <form action="home" method="post">
                        <button class="btn btn-primary btn-outline-light">Home</button>
                    </form>

                    <!-- Logout Button -->
                    <form action="logout" method="post">
                        <button class="btn btn-danger btn-outline-light">Logout</button>
                    </form>

                </div>

            </div>
        </nav>


        <!-- PROFILE FORM -->

        <div class="container d-flex justify-content-center align-items-center vh-100">

            <div class="card shadow-lg p-4" style="max-width:600px;width:200%;">

                <h3 class="text-center mb-4 fw-bold">
                    <i class="bi bi-person-circle text-primary"></i> View / Update Profile
                </h3>

                <h5 class="text-center text-success">${updateSuccess}</h5>
                <h5 class="text-center text-danger">${updateFailed}</h5>

                <form action="updateProfile" method="post">

                    <div class="row">


                        <input type="number" class="form-control" name="id" value="${dto.id}" hidden>


                        <div class="col-md-6 mb-3">
                            <label class="form-label text-primary">Name</label>
                            <input type="text" class="form-control" name="name" value="${dto.name}">
                        </div>

                        <div class="col-md-6 mb-3">
                            <label class="form-label text-primary">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="dob" value="${dto.dob}">
                        </div>

                        <div class="col-md-6 mb-3">
                            <label class="form-label text-primary">Age</label>
                            <input type="number" class="form-control" id="age" name="age" value="${dto.age}" readonly>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label class="form-label text-primary">Gender</label>

                            <select class="form-select" name="gender" disabled>

                                <option ${dto.gender=='Male' ? 'selected' :''}>Male</option>
                                <option ${dto.gender=='Female' ? 'selected' :''}>Female</option>
                                <option ${dto.gender=='Other' ? 'selected' :''}>Other</option>

                            </select>

                        </div>

                        <div class="col-12 mb-3">
                            <label class="form-label text-primary">Location</label>
                            <input type="text" class="form-control" name="location" value="${dto.location}">
                        </div>


                        <div class="col-md-6 mb-3">
                            <label class="form-label text-primary">Email</label>

                            <input type="email" class="form-control" name="email" value="${dto.email}" readonly>

                        </div>


                        <div class="col-md-6 mb-3">
                            <label class="form-label text-primary">Phone Number</label>

                            <input type="tel" class="form-control" name="phNumber" value="${dto.phNumber}" readonly>
                        </div>


                        <input type="password" class="form-control" name="password" value="${dto.password}" hidden>


                    </div>

                    <div class="d-grid mt-3">

                        <button class="btn btn-primary btn-lg">
                            Update Profile
                        </button>

                    </div>

                </form>

            </div>
        </div>

        <script>
            document.getElementById("dob").addEventListener("change", function () {

                let dob = new Date(this.value);
                let today = new Date();

                let age = today.getFullYear() - dob.getFullYear();

                let monthDiff = today.getMonth() - dob.getMonth();

                // Adjust age if birthday not yet reached this year
                if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
                    age--;
                }

                document.getElementById("age").value = age;
            });
        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    </html>