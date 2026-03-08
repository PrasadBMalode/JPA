<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="update" method="post">

<input type="number" name="id" value="${dto.id}" readonly  hidden>
<br>
  <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required value="${dto.name}" ><br><br>

          <label for="email">Email:</label><br>
                <input type="text" id="email" name="email" required  value="${dto.email}" readonly><br><br>

                  <label for="contactNumber">ContactNumber:</label><br>
                        <input type="number" id="contactNumber" name="contactNumber" required value="${dto.contactNumber}" readonly><br><br>

        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age" required value="${dto.age}"><br><br>



        <label for="cllgName">College Name:</label><br>
        <input type="text" id="cllgName" name="cllgName" required value="${dto.cllgName}"><br><br>

        <label for="location">Location:</label><br>
        <input type="text" id="location" name="location" required value="${dto.location}"><br><br>

        <button type="submit">Edit</button>

    </form>
</body>
</html>