<?php
  /*
  //String
  $myStr = 'Hello World';
  var_dump($myStr);

  // Interger
  $myInt = -55;
  var_dump($myInt);

  // Float
  $myFloat = 4.4;
  var_dump($myFloat);

  // Boolean
  $myBool = true;
  var_dump($myBool);

  // Array
  $myArray = [3,4,5,6];
  var_dump($myArray);

  // Null
  $myNull = null;
  var_dump($myNull);
  */

  $myStr='Hello World';
  // String Length: echo strlen($myStr);
  //String WORD count: echo str_word_count($myStr);
  //String Reverse: echo strrev($myStr);
  //String Position (where the 2nd variable starts in a string, ie. $myStr): echo strpos($myStr, 'World');  RE: 2 Parameters!!
  //Replace 1 variable with another in a string: echo str_replace('World', 'Brad', $myStr);

  // MATHS
  //MAX: echo max(32,2,66,5554,777,3844);
  //MIN: echo min(32,2,66,5554,777,3844);
  //ABSOLUTE: echo abs(5);
  //Math.floor (round down): echo floor(4.3);
  //Math.ceil (rounding up): echo ceil(4.6);
  //RANDOM NUMBER (5 char long): echo rand();
  //RANDOM NUMBER within set range: echo rand(10,35);
  echo "The date is ". date('Y/m/d')."<br>";
  echo "The date is ". date('Y.m.d')."<br>";
  echo "The day is ". date('l')."<br>"; //Day
  echo "The month is ". date('M')."<br>"; //Month abreviated
  echo "The time is ". date('h:i:sa')."<br>"; //Time

  //Set Timezone
  date_default_timezone_set("Asia/Seoul");
  echo "The time is ". date('h:i:sa')."<br>";

  //turn string into date
  $d=strtotime("11:00am January 10 2015");
  echo "The date is ". date('Y.m.d', $d)."<br>";
