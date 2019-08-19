<?php

// Connect to MySQL

$connection = mysqli_connect(
    $host='localhost', 
    $user='root', 
    $password='123456',
    $database='messageapp'
);


// Test Connection

if(mysqli_connect_errno()){
    echo 'DB Connection Error: '.mysqli_connect_error();
}