import UIKit

// Optionals : think "wrapper" or "box". It can hold something, or be empty
// Optionals can have a value, or they can't
// They can be safely used without worrying "what's inside"

let optionalImage: UIImage? // able to be nil, able to have a value

let nonOptionalImage: UIImage

var optionalNumber: Int? = 5
var number: Int = 5

// Force Unwrapping
if optionalNumber != nil {
    print("optionalNumber has a value of \(optionalNumber!)") // add ! for Force Unwrapping
} else {
    // handle errors
}

// Optional Binding : take optional value and bind to a non-optional constant
if let constantNumber = optionalNumber {
    print("constantNumber has a value of \(constantNumber)")
} else {
    print("optionalNumber is nil.")
}

func intPrinter() {
    guard let constantNumber = optionalNumber else { return }
    print("constantNumber has a value of \(constantNumber)")
}

intPrinter()

// Implictly Unwrapped Optional : Force unwrap a value from the beginning
// MUST be 100% certain there is a value
let assumedValue: Int! = 5
let implicitValue: Int = assumedValue

// Nil Coalescing & Using Ternary Operator
let optionalInt: Int? = nil
let result = optionalInt ?? 0


// Optional Chaining
class ComicConAtendee {
    var admissionBadge: AdmissionBadge?
    
    init(badge: AdmissionBadge?) {
        self.admissionBadge = badge
    }
    
}

class AdmissionBadge {
    var numberOfDays: Int
    
    init(numberOfDays: Int){
        self.numberOfDays = numberOfDays
    }
}

let admissionBadge = AdmissionBadge(numberOfDays: 3)
let atendee = ComicConAtendee(badge: nil)

if let daysAttendable = atendee.admissionBadge?.numberOfDays {
    print("This attendee can enter Comic Con for \(daysAttendable) days")
} else {
    print("This person has not purchased a ticket. Please refer to the ticketing window.")
}

