<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

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
    <div class="container d-flex align-items-center justify-content-center vh-100">

        <div class="card shadow p-4" style="width: 400px;">

            <h3 class="text-center mb-4">Reset Password</h3>

            <h6 class="text-success text-center">${updatedSuccessfully}</h6>
            <h6 class="text-danger text-center">${updateFail}</h6>

            <form action="updatePassword" method="post" onsubmit="return validatePassword()">

                <!-- ✅ Hidden Email -->
                <input type="hidden" name="email" value="${email}">

                <!-- New Password -->
                <div class="mb-3">
                    <label class="form-label">New Password</label>
                    <div class="input-group">
                        <input type="password" id="newPassword" name="password" class="form-control" required onkeyup="checkPasswords()">
                        <button class="btn btn-outline-secondary" type="button" onclick="togglePassword('newPassword', this)">
                            <i class="bi bi-eye"></i>
                        </button>
                    </div>
                </div>

                <!-- Confirm Password -->
                <div class="mb-3">
                    <label class="form-label">Confirm Password</label>
                    <div class="input-group">
                        <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required onkeyup="checkPasswords()">
                        <button class="btn btn-outline-secondary" type="button" onclick="togglePassword('confirmPassword', this)">
                            <i class="bi bi-eye"></i>
                        </button>
                    </div>
                </div>

                <!-- Live Message -->
                <div id="message" class="mb-3"></div>

                <button type="submit" class="btn btn-primary w-100">Update Password</button>

            </form>
        </div>
    </div>

    <!-- JS -->
    <script>
        function togglePassword(fieldId, btn) {
            const input = document.getElementById(fieldId);
            const icon = btn.querySelector("i");

            if (input.type === "password") {
                input.type = "text";
                icon.classList.replace("bi-eye", "bi-eye-slash");
            } else {
                input.type = "password";
                icon.classList.replace("bi-eye-slash", "bi-eye");
            }
        }

        function checkPasswords() {
            let password = document.getElementById("newPassword").value;
            let confirm = document.getElementById("confirmPassword").value;
            let message = document.getElementById("message");

            if (confirm === "") {
                message.innerHTML = "";
                return;
            }

            if (password === confirm) {
                message.innerHTML = '<div class="alert alert-success p-2">Passwords match</div>';
            } else {
                message.innerHTML = '<div class="alert alert-danger p-2">Passwords do not match</div>';
            }
        }

        function validatePassword() {
            let password = document.getElementById("newPassword").value;
            let confirm = document.getElementById("confirmPassword").value;

            if (password !== confirm) {
                return false;
            }
            return true;
        }
    </script>

</body>
</html>