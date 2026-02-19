
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Visitors form</title>
</head>
<body style="margin:0; height:100vh; display:flex; justify-content:center; align-items:center;">

    <div style="text-align:center; padding:30px; border-radius:10px; box-shadow:0 0 10px rgba(0,0,0,0.1);">

        <h2>Visitors Registration Form</h2>

        <h3 style="color: green;">
            ${dto.name},
            ${success}

            <!-- <% session.removeAttribute("success"); %> -->
        </h3>

        <h3 style="color: red;">
            ${invalid}
            <!-- <% session.removeAttribute("invalid"); %> -->
        </h3>


        <form action="register" method="post">

            <label>Age:</label><br>
            <input type="number" name="age" required><br><br>

            <label>Name:</label><br>
            <input type="text" name="name" required><br><br>

            <label>Location:</label><br>
            <input type="text" name="location" required><br><br>

            <label>Number:</label><br>
            <input type="number" name="number" required><br><br>

            <button type="submit">Submit</button>

        </form>

    </div>

</body>

</html>

