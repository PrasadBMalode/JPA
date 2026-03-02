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

                <form action="update" method="post">

                    <div class="mb-1">
                        <label for="id" class="form-label">ID:</label>
                        <input type="number" id="id" name="id" required value="${byId.id}" class="form-control"
                            readonly>
                    </div>


                    <div class="mb-1">
                        <label for="age" class="form-label">Age:</label>
                        <input type="number" id="age" name="age" value="${byId.age}" class="form-control">
                    </div>

                    <div class="mb-1">
                        <label for="name" class="form-label">Name:</label>
                        <input type="text" id="name" name="name" value="${byId.name}" class="form-control">
                    </div>

                    <div class="mb-1">
                        <label for="cllgName" class="form-label">School/College Name:</label>
                        <input type="text" id="cllgName" name="cllgName" value="${byId.cllgName}" class="form-control">
                    </div>

                    <div class="mb-1">
                        <label for="location" class="form-label">Location:</label>
                        <input type="text" id="location" name="location" value="${byId.location}" class="form-control">
                    </div>

                    <div class="mb-1">
                        <label class="form-label">Gender:</label>

                        <div class="form-check">
                            <input type="radio" id="male" name="gender" value="Male" ${byId.gender=='Male' ? 'checked'
                                : '' } required class="form-check-input">
                            <label for="male" class="form-check-label">Male</label>
                        </div>

                        <div class="form-check">
                            <input type="radio" id="female" name="gender" value="Female" ${byId.gender=='Female'
                                ? 'checked' : '' } class="form-check-input">
                            <label for="female" class="form-check-label">Female</label>
                        </div>

                        <div class="form-check">
                            <input type="radio" id="other" name="gender" value="Other" ${byId.gender=='Other'
                                ? 'checked' : '' } class="form-check-input">
                            <label for="other" class="form-check-label">Other</label>
                        </div>
                    </div>

                    <div class="mb-1">
                        <label for="class" class="form-label">Class:</label>
                        <select id="class" name="className" required class="form-select">
                            <option >${byId.className}</option>
                            <option >8th</option>
                            <option >9th</option>
                            <option >10th</option>
                            <option >1st PUC</option>
                            <option >2nd PUC</option>
                        </select>
                    </div>

                    <div class="mb-1">
                        <label for="email" class="form-label">Email:</label>
                        <input type="text" id="email" name="email" value="${byId.email}" required class="form-control"
                            readonly>
                    </div>

                    <div class="mb-1">
                        <label for="contactNumber" class="form-label">Contact Number:</label>
                        <input type="text" id="contactNumber" name="contactNumber" value="${byId.contactNumber}"
                            required class="form-control" readonly>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-lg">Update</button>
                    </div>


                </form>
    </body>

    </html>