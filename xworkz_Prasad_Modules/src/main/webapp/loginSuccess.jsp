<%@ page isELIgnored="false" %>

    <% String email=(String) session.getAttribute("loggedInEmail"); String firstLetter="" ; if (email !=null &&
        !email.isEmpty()) { firstLetter=email.substring(0, 1).toUpperCase(); } %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <title>Login Success</title>

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Font Awesome -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

            <style>
                body {
                    background: linear-gradient(135deg, #f5f7fa, #e4ecf5);
                }

                .success-card {
                    padding: 40px;
                    border-radius: 15px;
                    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
                    background: black;
                    animation: fadeIn 0.8s ease-in-out;
                }

                .logo {
                    width: 220px;
                }

                .nav-logo {
                    height: 70px;
                    padding-left: 2rem;
                }

                .success-icon {
                    font-size: 60px;
                    color: #28a745;
                    animation: pop 0.6s ease;
                }

                /* Avatar Circle */
                .avatar-btn {
                    width: 50px;
                    height: 50px;
                    background-color: #f47113;
                    color: black;
                    font-weight: bold;
                    font-size: 20px;
                    border: none;
                }

                /* Hover effect */
                .avatar-btn:hover {
                    background-color: #0cc7ed;
                    color: rgb(12, 12, 12);
                }

                @keyframes pop {
                    0% {
                        transform: scale(0.5);
                        opacity: 0;
                    }

                    100% {
                        transform: scale(1);
                        opacity: 1;
                    }
                }

                @keyframes fadeIn {
                    from {
                        opacity: 0;
                        transform: translateY(20px);
                    }

                    to {
                        opacity: 1;
                        transform: translateY(0);
                    }
                }
            </style>

        </head>

        <body>

            <!-- Navbar Start -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container-fluid">

                    <!-- Logo Left -->
                    <a class="navbar-brand" href="#">
                        <img src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
                            class="nav-logo">
                    </a>

                    <!-- Avatar Dropdown Right -->
                    <div class="ms-auto dropdown">

                        <!-- Circle Avatar -->
                        <button
                            class="btn dropdown-toggle d-flex align-items-center justify-content-center rounded-circle avatar-btn"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            <%= firstLetter %>
                        </button>

                        <!-- Dropdown Menu -->
                        <ul class="dropdown-menu dropdown-menu-dark dropdown-menu-end">
                            <li class="dropdown-item-text text-warning fw-bold">
                                <%= email %>
                            </li>

                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <a class="dropdown-item" href="profileUpdate?email=<%= email %>">
                                    Profile
                                </a>
                            </li>

                            <li>
                                <a class="dropdown-item" href="dashboard">
                                    Dashboard
                                </a>
                            </li>

                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <form action="logout" method="post" class="d-inline">
                                    <button type="submit" class="dropdown-item text-warning">
                                        Logout
                                    </button>
                                </form>
                            </li>
                        </ul>

                    </div>

                </div>
            </nav>
            <!-- Navbar End -->

            <!-- Success Section -->
            <div class="container vh-100 d-flex justify-content-center align-items-center">

                <div class="success-card text-center">

                    <img src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
                        class="logo mb-3">

                    <div class="success-icon mb-3">
                        <i class="fa-solid fa-circle-check"></i>
                    </div>

                    <h2 class="text-success fw-bold">Home Page, Login Successful</h2>

                    <p class="text-white">Welcome to the Xworkz System</p>

                </div>

            </div>

            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        </body>

        </html>
        ```