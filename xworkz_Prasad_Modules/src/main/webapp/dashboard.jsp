<%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>XworkZ Team Dashboard</title>

            <!-- Bootstrap 5 CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
            <!-- Bootstrap Icons -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

            <style>
                body {
                    background-color: #f4f6f9;
                    /* Soft light gray background */
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                }

                /* Sidebar Styling */
                .sidebar {
                    min-height: 100vh;
                    background: #212529;
                    /* Dark background */
                    color: #ffffff;
                    box-shadow: 4px 0 10px rgba(0, 0, 0, 0.1);
                }

                .sidebar .nav-link {
                    color: #adb5bd;
                    /* Light gray text */
                    padding: 12px 20px;
                    margin-bottom: 5px;
                    border-radius: 5px;
                    transition: all 0.3s;
                    font-weight: 500;
                }

                .sidebar .nav-link:hover,
                .sidebar .nav-link.active {
                    background-color: #0d6efd;
                    /* Bootstrap Primary Blue */
                    color: white;
                    transform: translateX(5px);
                }

                .sidebar .nav-link i {
                    margin-right: 10px;
                }

                /* Navbar Logo */
                .nav-logo {
                    height: 70px;
                    border-radius: 5px;
                }

                /* Card Hover Effects */
                .stat-card {
                    transition: transform 0.2s, box-shadow 0.2s;
                    border: none;
                    border-radius: 12px;
                }

                .stat-card:hover {
                    transform: translateY(-5px);
                    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1) !important;
                }

                /* Table Styling */
                .table-card {
                    border: none;
                    border-radius: 12px;
                    overflow: hidden;
                }

                .table thead th {
                    background-color: #e9ecef;
                    border-bottom: 2px solid #dee2e6;
                    font-weight: 600;
                    text-transform: uppercase;
                    font-size: 0.85rem;
                    letter-spacing: 0.5px;
                }

                .table td {
                    vertical-align: middle;
                }

                #dashboardEmail:hover{
                    color: #f47113;
                }
            </style>
        </head>

        <body>

            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top shadow-sm">
                <div class="container-fluid">
                    <a class="navbar-brand d-flex align-items-center" href="#">
                        <img src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
                            class="nav-logo me-2" alt="Xworkz Logo">
                        <!-- <span class="fw-bold fs-5 d-none d-sm-inline">XworkZ Admin</span> -->
                    </a>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ms-auto align-items-center">

                            <li class="nav-item">
                                <form action="home" method="post" class="d-inline">
                                    <button type="submit" class="nav-link btn btn-link active p-0">
                                        <i class="bi bi-speedometer2 me-1"></i> Home
                                    </button>
                                </form>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" id="dashboardEmail" href="profileUpdate?email=${sessionScope.loggedInEmail}"><i class="bi bi-person-circle me-1"></i> ${sessionScope.loggedInEmail}</a>
                            </li>

                            <!-- <li class="nav-item">
                                <a class="nav-link" href="#"><i class="bi bi-gear me-1"></i> Settings</a>
                            </li> -->

                            <li class="nav-item ms-lg-3">
                                <form action="logout" method="post" class="d-inline">
                                    <button type="submit" class="btn btn-outline-danger btn-sm px-3">
                                        <i class="bi bi-box-arrow-right"></i> Logout
                                    </button>
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="container-fluid">
                <div class="row">

                    <!-- Sidebar -->
                    <div class="col-md-2 sidebar d-md-block collapse p-3 pt-4">
                        <h6 class="text-uppercase text-muted small fw-bold mb-4 px-2">Main Menu</h6>

                        <nav class="nav flex-column">
                            <a class="nav-link" href="dashboardLeftHome"><i class="bi bi-house-door"></i> Home</a>
                            <a class="nav-link" href="#"><i class="bi bi-people-fill"></i> Employees</a>
                            <a class="nav-link" href="#"><i class="bi bi-briefcase-fill"></i> Projects</a>
                            <!-- <a class="nav-link" href="#"><i class="bi bi-file-earmark-bar-graph-fill"></i> Reports</a> -->
                            <!-- <a class="nav-link" href="#"><i class="bi bi-sliders"></i> Settings</a> -->
                        </nav>
                    </div>

                    <!-- Dashboard Content -->
                    <div class="col-md-10 p-4">

                        <h2 class="mb-4 fw-bold text-dark">Dashboard Overview</h2>

                        <!-- Stats Cards Row -->
                        <div class="row g-4 mb-5">

                            <!-- Card 1 -->
                            <div class="col-md-4">
                                <div class="card stat-card shadow h-100">
                                    <div class="card-body d-flex align-items-center">
                                        <div class="bg-primary bg-opacity-10 p-3 rounded-circle me-3 text-primary">
                                            <i class="bi bi-people-fill fs-3"></i>
                                        </div>
                                        <div>
                                            <h5 class="card-title text-muted mb-1">Total Users</h5>
                                            <h3 class="fw-bold mb-0">${fn:length(usersList)}</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Card 2 -->
                            <div class="col-md-4">
                                <div class="card stat-card shadow h-100">
                                    <div class="card-body d-flex align-items-center">
                                        <div class="bg-success bg-opacity-10 p-3 rounded-circle me-3 text-success">
                                            <i class="bi bi-kanban-fill fs-3"></i>
                                        </div>
                                        <div>
                                            <h5 class="card-title text-muted mb-1">Active Projects</h5>
                                            <h3 class="fw-bold mb-0">0</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Card 3 -->
                            <div class="col-md-4">
                                <div class="card stat-card shadow h-100">
                                    <div class="card-body d-flex align-items-center">
                                        <div class="bg-warning bg-opacity-10 p-3 rounded-circle me-3 text-warning">
                                            <i class="bi bi-check-circle-fill fs-3"></i>
                                        </div>
                                        <div>
                                            <h5 class="card-title text-muted mb-1">Completed Tasks</h5>
                                            <h3 class="fw-bold mb-0">0</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <!-- Users Table Section -->
                        <div class="card table-card shadow-sm">
                            <div class="card-header bg-white border-bottom-0 pt-4 pb-0 px-4">
                                <div class="d-flex justify-content-between align-items-center">
                                    <h5 class="fw-bold text-dark mb-3"><i
                                            class="bi bi-table me-2 text-primary"></i>Users List</h5>
                                    <!-- <button class="btn btn-primary btn-sm"><i class="bi bi-download"></i>
                                        Export</button> -->
                                </div>
                            </div>

                            <div class="card-body p-0">
                                <div class="table-responsive">
                                    <table class="table table-hover table-striped text-center align-middle mb-0">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>DOB</th>
                                                <th>Age</th>
                                                <th>Gender</th>
                                                <th>Location</th>
                                                <th>Email</th>
                                                <th>Contact</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${usersList}" var="singleDTO">
                                                <tr>
                                                    <td class="fw-bold text-dark">${singleDTO.name}</td>
                                                    <td>${singleDTO.dob}</td>
                                                    <td><span class="badge bg-secondary">${singleDTO.age}</span></td>
                                                    <td>${singleDTO.gender}</td>
                                                    <td>${singleDTO.location}</td>
                                                    <td class="text-muted small">${singleDTO.email}</td>
                                                    <td class="text-success fw-bold">${singleDTO.phNumber}</td>
                                                </tr>
                                            </c:forEach>
                                            <!-- Empty state logic (optional) can be added here if list is empty -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        </body>

        </html>