import UIKit

// Inheritance is a principal of OOP

class Vehicle {
    var tires = 4
    var make: String?
    var model: String?
    var currentSpeed: Double = 0
    
    init() {
        print("I am the parent")
    }
    
    func drive(speedIncrease: Double) {
        currentSpeed += speedIncrease * 2
    }
    
    func brake() {
        
    }
}

class Truck: Vehicle {
    
    override init () {
        super.init()
        print("I am the child(truck)")
        make = "Ford"
        model = "F150"
    }
    
    override func drive(speedIncrease: Double) {
        currentSpeed += speedIncrease
    }
}

class SportsCar: Vehicle {
    
    override init () {
        super.init()
        print("I am the child(sports car)")
        make = "BMW"
        model = "3 Series"
    }
    
    override func drive(speedIncrease: Double) {
        currentSpeed += speedIncrease * 3
    }
}

let car = SportsCar()
let truck = Truck()

