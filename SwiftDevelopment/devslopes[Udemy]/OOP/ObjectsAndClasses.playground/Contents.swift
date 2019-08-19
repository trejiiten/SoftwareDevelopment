import UIKit

// define class
class Vehicle {
    var tires = 4
    var headlights = 2
    var horsepower = 468
    var model = ""
    var trim = ""
    
    func drive () {
        // accelerate the vehicle
    }
    
    func brake () {
        // stop the vehicle
    }
}

// Instantiating instance of Vehicle Class
let bmw = Vehicle()
bmw.model = "328i"

let honda = Vehicle()
honda.model = "CR-V"
honda.trim = "EX-L"

func passByReference (vehicle: Vehicle) {
    vehicle.model = "cheese"
}

print(bmw.model)

passByReference(vehicle: bmw) // pass by reference

print(bmw.model)
// You CANNOT copy an object, you can pass on their values by REFERENCE

var personAge = 20

func passByValue(age: Int) {
    let newAge = age
}

passByValue(age: personAge)
