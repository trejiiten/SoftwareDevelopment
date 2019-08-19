import UIKit

// Logical NOT Operator - Unary Prefix Operator

// Constant = let

let allowedEntry = false
if !allowedEntry {
    print("Access Denied")
}

let enteredDoorCode = true
let passedRetinalScan = false
let iAmTCfromMI = false

if enteredDoorCode && passedRetinalScan || iAmTCfromMI {
    print("Welcome")
} else {
    print("ACCESS DENIED AGAIN!")
}

let hasDoorKey = false
let knowsOverridePW = false

if hasDoorKey || knowsOverridePW {
    print("Welcome")
} else {
    print("You're still denied!")
}

