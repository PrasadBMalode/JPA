<%@ page isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>XworkZ Registration</title>

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
          -webkit-backdrop-filter: blur(10px);
          border-radius: 15px;
          border: 1px solid rgba(255, 255, 255, 0.3);
        }

        .form-control,
        .form-select {
          background: rgba(255, 255, 255, 0.8);
        }

        small {
          font-size: 13px;
        }

        .nav-logo {
          height: 60px;
        }
      </style>

    </head>

    <body>

      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">

          <a class="navbar-brand" href="#">
            <img
              src="https://media.licdn.com/dms/image/v2/C5112AQHkJieIgr_a7A/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1569825714486?e=2147483647&v=beta&t=EWt2sBbhUOHhU_GuIDFBUtnw9tFRpam6Ofb-Hze-lJ4"
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


      <div class="container d-flex justify-content-center align-items-center vh-100">

        <div class="card shadow-lg p-4" style="max-width:600px;width:200%;">

          <h3 class="text-center mb-4 fw-bold">
            <i class="bi bi-person-plus text-primary"></i> User Registration
          </h3>

          <h5 style="color:green" class="text-center">${registerSuccess}</h5>
          <h5 style="color:red" class="text-center">${registerFailed}</h5>
          <h5 style="color:red" class="text-center">${existData}</h5>

          <form action="register" method="post" id="registerForm">

            <div class="row">

              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name"
                  oninput="this.value=this.value.replace(/[^A-Za-z\s]/g,'')" value="${userDTO.name}">
                <small class="text-danger" id="nameError">${nameError}</small>
              </div>


              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Date of Birth</label>
                <input type="date" id="dob" class="form-control" name="dob" value="${userDTO.dob}">
                <small class="text-danger" id="dobError">${dobError}</small>
              </div>



              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Age</label>
                <input type="number" id="age" class="form-control" name="age" placeholder="Enter Age"
                  value="${userDTO.age}" readonly>
                <small class="text-danger" id="ageError">${ageError}</small>
              </div>


              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Gender</label>
                <select class="form-select" name="gender">
                  <option value="">Select Gender</option>
                  <option value="Male" ${userDTO.gender=='Male' ? 'selected' : '' }>Male</option>
                  <option value="Female" ${userDTO.gender=='Female' ? 'selected' : '' }>Female</option>
                  <option value="Other" ${userDTO.gender=='Other' ? 'selected' : '' }>Other</option>
                </select>
                <small class="text-danger">${genderError}</small>
              </div>


              <div class="col-12 mb-3">
                <label class="form-label text-primary">Location</label>
                <input type="text" class="form-control" id="location" name="location" placeholder="Enter Location"
                  oninput="this.value=this.value.replace(/[^A-Za-z\s]/g,'')" value="${userDTO.location}">
                <small class="text-danger" id="locationError">${locationError}</small>
              </div>



              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email"
                  value="${userDTO.email}">
                <small class="text-danger" id="emailError">${emailError}</small>
              </div>



              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Phone Number</label>
                <input type="tel" class="form-control" id="phNumber" name="phNumber" placeholder="Enter Phone Number"
                  maxlength="10" oninput="this.value=this.value.replace(/[^0-9]/g,'')" value="${userDTO.phNumber}">
                <small class="text-danger" id="phoneError">${phoneError}</small>
              </div>



              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Password</label>
                <div class="input-group">
                  <input type="password" class="form-control" id="password" name="password" placeholder="Password"
                    value="${userDTO.password}">
                  <span class="input-group-text" onclick="togglePassword('password','eye1')" style="cursor:pointer;">
                    <i class="bi bi-eye" id="eye1"></i>
                  </span>
                </div>
                <small class="text-danger" id="passwordError">${passwordError}</small>
              </div>



              <div class="col-md-6 mb-3">
                <label class="form-label text-primary">Confirm Password</label>
                <div class="input-group">
                  <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                    placeholder="Confirm Password" value="${userDTO.confirmPassword}">
                  <span class="input-group-text" onclick="togglePassword('confirmPassword','eye2')"
                    style="cursor:pointer;">
                    <i class="bi bi-eye" id="eye2"></i>
                  </span>
                </div>
                <small class="text-danger" id="confirmPasswordError">${confirmPasswordError}</small>
              </div>


            </div>

            <div class="d-grid mt-3">
              <button class="btn btn-primary btn-lg">Register</button>
            </div>

          </form>

        </div>

      </div>




      <script>
        document.getElementById("dob").addEventListener("change", function () {

          let dobValue = this.value;
          let dobError = document.getElementById("dobError");

          if (!dobValue) {
            document.getElementById("age").value = "";
            return;
          }

          let dob = new Date(dobValue);
          let today = new Date();

          let age = today.getFullYear() - dob.getFullYear();
          let monthDiff = today.getMonth() - dob.getMonth();

          // Adjust if birthday not yet occurred this year//
          if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
            age--;
          }

          // Validation//
          if (age < 0) {
            document.getElementById("ageError").innerText = "Invalid Date of Birth";
            document.getElementById("age").value = "";
          } else {
            document.getElementById("ageError").innerText = "";
            document.getElementById("age").value = age;
          }
        });




        // document.getElementById("dob").addEventListener("change", function () {

        //   let dobValue = this.value;
        //   let dobError = document.getElementById("dobError");
        //   let ageField = document.getElementById("age");

        //   // Empty DOB check
        //   if (!dobValue) {
        //     dobError.innerText = "Please select Date of Birth";
        //     ageField.value = "";
        //     return;
        //   }

        //   let dob = new Date(dobValue);
        //   let today = new Date();

        //   // Remove time part
        //   today.setHours(0, 0, 0, 0);

        //   // FUTURE DATE CHECK (@Past equivalent)
        //   if (dob >= today) {
        //     dobError.innerText = "DOB must be in the past";
        //     ageField.value = "";
        //     return;
        //   }

        //   // Calculate age
        //   let age = today.getFullYear() - dob.getFullYear();
        //   let monthDiff = today.getMonth() - dob.getMonth();

        //   if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
        //     age--;
        //   }

        //   // Age validation
        //   if (age < 18) {
        //     dobError.innerText = "Age must be 18 or above";
        //     ageField.value = "";
        //   } else {
        //     dobError.innerText = "";
        //     ageField.value = age;
        //   }

        // });
      </script>


      <script>

        const nameInput = document.getElementById("name");
        const ageInput = document.getElementById("age");
        const locationInput = document.getElementById("location");
        const emailInput = document.getElementById("email");
        const phoneInput = document.getElementById("phNumber");
        const passwordInput = document.getElementById("password");
        const confirmPasswordInput = document.getElementById("confirmPassword");

        nameInput.addEventListener("blur", validateName);
        ageInput.addEventListener("blur", validateAge);
        locationInput.addEventListener("blur", validateLocation);
        emailInput.addEventListener("blur", validateEmail);
        phoneInput.addEventListener("blur", validatePhone);
        passwordInput.addEventListener("blur", validatePassword);
        confirmPasswordInput.addEventListener("blur", validateConfirmPassword);

        function validateName() {

          let name = nameInput.value.trim();
          let pattern = /^[A-Za-z\s]{3,}$/;

          if (!pattern.test(name)) {
            document.getElementById("nameError").innerText = "Name must contain only letters (minimum 3)";
            return false;
          } else {
            document.getElementById("nameError").innerText = "";
            return true;
          }

        }

        function validateAge() {

          let age = ageInput.value;

          if (age < 18) {
            document.getElementById("ageError").innerText = "Age must be 18 or above";
            return false;
          } else {
            document.getElementById("ageError").innerText = "";
            return true;
          }

        }

        function validateLocation() {

          let location = locationInput.value.trim();
          let pattern = /^[A-Za-z\s]{4,}$/;

          if (!pattern.test(location)) {
            document.getElementById("locationError").innerText = "Location must contain minimum 4 letters";
            return false;
          } else {
            document.getElementById("locationError").innerText = "";
            return true;
          }

        }

        function validateEmail() {

          let email = emailInput.value.trim();
          let pattern = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;

          if (!pattern.test(email)) {
            document.getElementById("emailError").innerText = "Email must be Gmail address";
            return false;
          } else {
            document.getElementById("emailError").innerText = "";
            return true;
          }

        }

        function validatePhone() {

          let phone = phoneInput.value.trim();
          let pattern = /^[6-9][0-9]{9}$/;

          if (!pattern.test(phone)) {
            document.getElementById("phoneError").innerText = "Phone must start with 6,7,8,9 and be 10 digits";
            return false;
          } else {
            document.getElementById("phoneError").innerText = "";
            return true;
          }

        }

        function validatePassword() {

          let password = passwordInput.value;
          let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,12}$/;

          if (!pattern.test(password)) {
            document.getElementById("passwordError").innerText = "Password must be 8-12 chars with uppercase, lowercase, number & special char";
            return false;
          } else {
            document.getElementById("passwordError").innerText = "";
            return true;
          }

        }

        function validateConfirmPassword() {

          let password = passwordInput.value;
          let confirmPassword = confirmPasswordInput.value;

          if (password !== confirmPassword) {
            document.getElementById("confirmPasswordError").innerText = "Passwords do not match";
            return false;
          } else {
            document.getElementById("confirmPasswordError").innerText = "";
            return true;
          }

        }

        function togglePassword(fieldId, eyeId) {

          const passwordField = document.getElementById(fieldId);
          const eyeIcon = document.getElementById(eyeId);

          if (passwordField.type === "password") {
            passwordField.type = "text";
            eyeIcon.classList.remove("bi-eye");
            eyeIcon.classList.add("bi-eye-slash");
          } else {
            passwordField.type = "password";
            eyeIcon.classList.remove("bi-eye-slash");
            eyeIcon.classList.add("bi-eye");
          }

        }

        document.getElementById("registerForm").addEventListener("submit", function (event) {

          let valid = true;

          if (!validateName()) valid = false;
          if (!validateAge()) valid = false;
          if (!validateLocation()) valid = false;
          if (!validateEmail()) valid = false;
          if (!validatePhone()) valid = false;
          if (!validatePassword()) valid = false;
          if (!validateConfirmPassword()) valid = false;

          if (!valid) {
            event.preventDefault();
          }

        });

      </script>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    </html>