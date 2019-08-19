<?php 
// Start Session
session_start();

// Config file
require_once 'config.php';

// Include Helpers
require_once 'helpers/system_helper.php';

// Auto-load classes so we don't have to REQUIRE every time
function __autoload($class_name){
    require_once 'lib/'.$class_name.'.php';
}

//echo 'test';