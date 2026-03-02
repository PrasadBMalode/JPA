<%@ page isELIgnored="false" %>


    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Registration Form</title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>

    <body class="bg-light">

        <div class="container d-flex justify-content-center align-items-center min-vh-100">
            <div class="card shadow-lg p-4" style="width: 100%; max-width: 500px;">
                <h3 class="text-center mb-1">Student Registration</h3>

              <h6 style="color:green">${success}</h6>
              <h6 style="color:red">${errorMsg}</h6>
              <h6 style="color:red">${dbWrong}</h6>

                <form action="register" method="post">

                    <div class="mb-1">
                        <label for="age" class="form-label">Age:</label>
                        <input type="number" id="age" name="age" required class="form-control">
                    </div>

                    <div class="mb-1">
                        <label for="name" class="form-label">Name:</label>
                        <input type="text" id="name" name="name" required class="form-control">
                    </div>

                    <div class="mb-1">
                        <label for="cllgName" class="form-label">School/College Name:</label>
                        <input type="text" id="cllgName" name="cllgName" required class="form-control">
                    </div>

                    <div class="mb-1">
                        <label for="location" class="form-label">Location:</label>
                        <input type="text" id="location" name="location" required class="form-control">
                    </div>

                    <div class="mb-1">
                        <label class="form-label">Gender:</label>

                        <div class="form-check">
                            <input type="radio" id="male" name="gender" value="male" required class="form-check-input">
                            <label for="male" class="form-check-label">Male</label>
                        </div>

                        <div class="form-check">
                            <input type="radio" id="female" name="gender" value="female" class="form-check-input">
                            <label for="female" class="form-check-label">Female</label>
                        </div>

                        <div class="form-check">
                            <input type="radio" id="other" name="gender" value="other" class="form-check-input">
                            <label for="other" class="form-check-label">Other</label>
                        </div>
                    </div>

                    <div class="mb-1">
                        <label for="class" class="form-label">Class:</label>
                        <select id="class" name="className" required class="form-select">
                            <option value="">--Select Class--</option>
                            <option value="8">8th</option>
                            <option value="9">9th</option>
                            <option value="10">10th</option>
                            <option value="11">1st PUC</option>
                            <option value="12">2nd PUC</option>
                        </select>
                    </div>

                    <div class="mb-1">
                        <label for="email" class="form-label">Email:</label>
                        <input type="text" id="email" name="email" required class="form-control">
                    </div>

                    <div class="mb-1">
                        <label for="contactNumber" class="form-label">Contact Number:</label>
                        <input type="text" id="contactNumber" name="contactNumber" required class="form-control">
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                    </div>


                </form>


                <h3>Read Data from DataBase</h3>
                <form action="readData" method="post">

                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-lg">Read Data</button>
                    </div>
                </form>
            </div>
        </div>


    </body>

    </html>