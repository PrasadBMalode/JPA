<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

    <h2>Customer Portal</h2>

    <form action="register" method="post">

        <label for="customerAge">Customer Age:</label><br>
        <input type="number" id="customerAge" name="customerAge" required><br><br>

        <label for="customerName">Customer Name:</label><br>
        <input type="text" id="customerName" name="customerName" required><br><br>

        <label for="customerLocation">Customer Location:</label><br>
        <input type="text" id="customerLocation" name="customerLocation" required><br><br>

        <label for="customerReview">Customer Review:</label><br>
        <input type="text" id="customerReview" name="customerReview" required><br><br>

        <label for="customerNumber">Customer Number:</label><br>
        <input type="text" id="customerNumber" name="customerNumber" required><br><br>

        <button type="submit">Submit</button>

    </form>

</body>
</html>
