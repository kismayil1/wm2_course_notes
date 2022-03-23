<html>
  <body>
    <h2>Hello World!</h2>

    <!-- Create a form with POST method to the same action (URL) -->
    <form action="database-servlet" method="POST">
      <input type="text" name="fname" /> <br />
      <input type="text" name="lname" /> <br />
      <input type="text" name="gpa" /> <br />
      <input type="text" name="school" /> <br />
      <input type="submit" name="submit" value="Save student" />
    </form>

    <form action="database-servlet" method="GET">
      <input type="text" name="school" />
      <input type="submit" value="List students" />
    </form>
  </body>
</html>
