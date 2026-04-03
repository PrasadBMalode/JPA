<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
                 class="nav-logo">
        </a>

        <div class="collapse navbar-collapse justify-content-end">
            <form action="loginButton" method="post">
                <button class="btn btn-success btn-outline-light">Log In</button>
            </form>
        </div>
    </div>
</nav>

<!-- MAIN CARD -->
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow p-4" style="width: 100%; max-width: 400px;">

        <h4 class="text-center mb-3">Email Verification</h4>

        <form id="emailForm" action="emailCheck" method="post">
            <div class="mb-3">
                <label class="form-label">Email address</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="Enter your email" required>
                <small class="text-danger">${emailError}</small>
            </div>

            <div class="d-grid">
                <button type="button" class="btn btn-primary" onclick="sendOtp()">Send OTP</button>
            </div>
        </form>

    </div>
</div>

<!-- OTP MODAL -->
<div class="modal fade" id="otpModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title">Enter OTP</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                <form action="verifyOtp" method="post">
                    <input type="hidden" name="email" id="otpEmail">

                    <div class="mb-3">
                        <label class="form-label">OTP</label>
                        <input type="text" name="otp" class="form-control" maxlength="6" pattern="\d{6}" placeholder="Enter 6-digit OTP" required>
                        <small class="text-danger">${otpError}</small>
                    </div>

                    <div class="d-grid mb-2">
                        <button type="submit" class="btn btn-success">Verify OTP</button>
                    </div>
                </form>

                <!-- RESEND OTP -->
                <div class="text-center mt-2">
                    <button type="button" id="resendBtn" class="btn btn-link" onclick="resendOtp()" disabled>
                        Resend OTP
                    </button>
                    <p id="timer" class="text-muted mb-0"></p>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- OTP SCRIPT -->
<script>
let countdown = 30;
let timerInterval;

function startTimer() {
    let timer = document.getElementById("timer");
    let resendBtn = document.getElementById("resendBtn");

    resendBtn.disabled = true;

    timerInterval = setInterval(() => {
        if (countdown <= 0) {
            clearInterval(timerInterval);
            timer.innerHTML = "You can resend OTP now";
            resendBtn.disabled = false;
            return;
        }

        timer.innerHTML = "Resend in " + countdown + " sec";
        countdown--;
    }, 1000);
}

function sendOtp() {
    let email = document.getElementById("email").value;

    if (email === "") {
        alert("Please enter email first");
        return;
    }

    fetch("emailCheck", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "email=" + encodeURIComponent(email)
    })
    .then(response => response.text())
    .then(data => {
        if (data.includes("OTP sent successfully")) {
            document.getElementById("otpEmail").value = email;

            let otpModal = new bootstrap.Modal(document.getElementById('otpModal'));
            otpModal.show();

            countdown = 30;
            startTimer();
        } else {
            document.body.innerHTML = data;
        }
    })
    .catch(error => console.error("Error:", error));
}

function resendOtp() {
    if (countdown > 0) {
        alert("Please wait " + countdown + " seconds");
        return;
    }

    let email = document.getElementById("otpEmail").value;

    fetch("resendOtp", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "email=" + encodeURIComponent(email)
    })
    .then(response => response.text())
    .then(() => {
        alert("OTP resent successfully!");
        countdown = 30;
        startTimer();
    })
    .catch(error => console.error(error));
}
</script>

</body>
</html>