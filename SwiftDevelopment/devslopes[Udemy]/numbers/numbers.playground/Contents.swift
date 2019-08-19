import UIKit

//Numbers
var age = 30 //Type Inference

//Explicitly Declared Type
var weight: Int = 90 //Integer

var someNum: Double = 12345678987654321
//use Double for long numbers as Int has a limit (15 decimal digits, Float has 6 decimal digits)

//Double represents 64-bit floating-point number
//Float represents 32-bit floating-point number

var milesRan = 56.45

var pi: Float = 3.14

// Arithmetic Operators: + - / *
var area = 15 * 20
var sum = 5 + 6
var diff = 10 - 3
var div = 12 / 3
var div1 = 13 / 5

var remainder = 13 % 5
var result = "The result of 13 / 5 is \(div1) with a remainder of \(remainder)."

var randomNmbr = 12

if randomNmbr % 2 == 0 {
    print("This is an even number")
} else {
    print("This is an odd number")
}

var result2 = 15 * ((5 + 7) / 3)
