<%@ page isELIgnored="false" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>XworkZ Login</title>

        <!-- Bootstrap CDN -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap Icons CDN -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

        <style>
            body {
                background-image: url("https://images.unsplash.com/photo-1507525428034-b723cf961d3e");
                background-size: cover;
                background-position: center;
                height: 100vh;
            }

            .glass {
                background: rgba(255, 255, 255, 0.2);
                backdrop-filter: blur(10px);
                border-radius: 50px;
                color: black;
            }

            /* Navbar Logo */
            .nav-logo {
                height: 70px;
                padding-left: 2rem;
            }

            /* Eye icon styling */
            .eye-icon {
                position: absolute;
                right: 15px;
                top: 50%;
                transform: translateY(-50%);
                cursor: pointer;
                font-size: 20px;
            }
        </style>

    </head>

    <body>

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <img src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
                    class="nav-logo" alt="XworkZ Logo">
            </a>
        </nav>

        <!-- Login Section -->
        <div class="container d-flex justify-content-center align-items-center vh-100">

            <div class="card glass shadow-lg p-4" style="width:500px;">

                <h4 class="text-center mb-4 fw-bold">Welcome to XworkZ Team</h4>

                <h5 style="color:red" id="loginFaile" class="text-center">${loginFailed}</h5>

                <form action="loginPage" method="post">

                    <div class="mb-3">
                        <input type="email" class="form-control" name="email" placeholder="Enter Email" required>
                    </div>

                    <!-- Password Field with Eye Icon -->
                    <div class="mb-3 position-relative">
                        <input type="password" class="form-control" id="password" name="password"
                            placeholder="Enter Password" style="padding-right:40px;" required>

                        <i class="bi bi-eye eye-icon" id="togglePassword" onclick="togglePassword()"></i>
                    </div>

                    <button type="submit" class="btn btn-primary w-100">Login</button>

                </form>

                <p class="text-end mt-3">
                    If you don't forgot password?
                    <a href="forgotPassword" class="text-primary fw-bold">Try another Way </a>
                </p>

                <p class="text-center mt-3">
                    If you don't have an account?
                    <a href="registerFirst" class="text-primary fw-bold">Register</a>
                </p>

            </div>

        </div>

        <!-- Password Toggle(Eye icon) Script -->

        <script>
            function togglePassword() {

                const password = document.getElementById("password");
                const icon = document.getElementById("togglePassword");

                if (password.type === "password") {
                    password.type = "text";
                    icon.classList.remove("bi-eye");
                    icon.classList.add("bi-eye-slash");
                } else {
                    password.type = "password";
                    icon.classList.remove("bi-eye-slash");
                    icon.classList.add("bi-eye");
                }

            }
            // Hide login error after 3 seconds//

                window.onload = function () {
                    const msg = document.getElementById("loginFaile");

                    if (msg && msg.innerText.trim() !== "") {
                        setTimeout(() => {
                            msg.style.display = "none";
                        }, 3000); // 3000 ms = 3 seconds//
                    }
                };
        </script>

    </body>

    </html>