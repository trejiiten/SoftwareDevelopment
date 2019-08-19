<?php
// Start Session
session_start();
?>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Sessions - PHP</title>
  </head>
  <body>
    <?php
      echo $_SESSION['username'].'\'s email is '.$_SESSION['email'];
     ?>
  </body>
</html>
