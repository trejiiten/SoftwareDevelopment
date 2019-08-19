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
      // Set Session Variable
      $_SESSION['username']='devuser';
      $_SESSION['email']='devuser@gmail.com';
      echo 'Session vars set';
     ?>
  </body>
</html>
