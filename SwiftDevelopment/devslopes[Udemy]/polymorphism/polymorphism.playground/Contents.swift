import UIKit

//Polymorphism allows the expression of some sort of contract, with potentially many types
// implementing that contract (whether through class inheritance or not) in different ways, each
// according to their own purpose. Code using that contract should not(*) have to care about which
// implementation is involved, only that the contract will be obeyed.


class Shape {
    var area: Double?
    
    func calculateArea(valA: Double, valB: Double) {
        
    } // the contract
}

class Triangle: Shape {
    
    override func calculateArea(valA: Double, valB: Double) {
        area = (valA * valB) / 2
    } // contract variation
}

class Rectange: Shape {
    
    override func calculateArea(valA: Double, valB: Double) {
        area = valA * valB
    } // contract variation
}
