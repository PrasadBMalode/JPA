<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Email Verification</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background-image: url("https://images.unsplash.com/photo-1507525428034-b723cf961d3e");
            background-size: cover;
            background-position: center;
            min-height: 100vh;
        }

        .nav-logo {
            height: 70px;
        }

        .card {
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            border: 1px solid rgba(255, 255, 255, 0.3);
        }
    </style>

</head>

<body>

    <!-- ✅ NAVBAR -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">

            <a class="navbar-brand" href="#">
                <img src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
                    class="nav-logo">
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <div class="d-flex">
                    <form action="loginButton" method="post">
                        <button class="btn btn-success btn-outline-light">Log In</button>
                    </form>
                </div>
            </div>

        </div>
    </nav>

    <!-- ✅ CENTERED CONTENT -->
    <div class="container d-flex justify-content-center align-items-center vh-100">

        <div class="card shadow p-4" style="width: 100%; max-width: 400px;">

            <h4 class="text-center mb-3">Email Verification</h4>

            <!-- Optional error message -->
            <!--<h6 class="text-danger text-center">${error}</h6>-->

            <form action="emailCheck" method="post">

                <div class="mb-3">
                    <label class="form-label">Email address</label>
                    <input type="email" name="email" class="form-control" placeholder="Enter your email" required>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>

            </form>

        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>