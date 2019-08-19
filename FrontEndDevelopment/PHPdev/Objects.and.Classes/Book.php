<?php
  class Book{
    // Properties
    //Normally you set properties to private, and have functions be public
    //When protected, you can access through a child class
    //public = access anywhere
    protected $price;
    protected $title;
    public static $store = 'My Store';
    // Constructor Function
    public function __construct($title, $price){
      $this->title= $title;
      $this->price = $price;
      // __CLASS__ is a "magic methods"
      echo '<br>The class "',__CLASS__,'" was instantiated!<br>';
    }

    public function __destruct(){
      echo '<br>The class "',__CLASS__,'" was destructed!<br>';
    }

    public function __toString(){
      return $this->getTitle();
    }

    // Methods
    public function setTitle($title){
      $this->title = $title;
    }

    public function getTitle(){
      return $this->title;
    }

    public function setPrice($price){
      $this->price = price;
    }

    public function getPrice(){
      return $this->price;
    }

    public static function getStore(){
      //with static properties, use "self" not "$this"
      return self::$store;
    }
  }

class Magazine extends Book {
  public $month;
  public $year;

  //Constructor
  public function __construct($title, $price, $month, $year){
    $this->month=$month;
    $this->year=$year;

    parent::__construct($title,$price);
    echo '<br>The class "',__CLASS__,'" was instantiated!<br>';
  }
  public function getYear(){
    return $this->year;
  }
}
