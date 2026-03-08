<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>


    <h2>Student Registration Form</h2>
<p>
<h2 style="color:green">${success}</h2>
<h2 style="color:red">${errmsg}</h2>


    <form action="register" method="post">

  <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

          <label for="email">Email:</label><br>
                <input type="text" id="email" name="email" required><br><br>

                  <label for="contactNumber">ContactNumber:</label><br>
                        <input type="number" id="contactNumber" name="contactNumber" required><br><br>

        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age" required><br><br>



        <label for="cllgName">College Name:</label><br>
        <input type="text" id="cllgName" name="cllgName" required><br><br>

        <label for="location">Location:</label><br>
        <input type="text" id="location" name="location" required><br><br>

        <button type="submit">Submit</button>

    </form>

    <div>
         <button type="button"><a href="readAllData">READ ALL</a></button>
    </div>
   

</body>
</html>
