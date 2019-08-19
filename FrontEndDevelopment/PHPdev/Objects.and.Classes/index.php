<?php
  include 'Book.php';

  //$book1=new Book('My Book', 9.95);
  //$book1->setTitle('My Book');
  //echo $book1->getTitle();
  //echo $book1->getTitle();
  //echo $book1->getPrice();
  //echo $book1;

  //echo Book::getStore();

  $mag1=new Magazine('PC World', 4.95, 'October', '2018');
  echo $mag1->getYear();
