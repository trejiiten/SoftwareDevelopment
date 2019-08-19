import UIKit

var namesOfIntegers = [Int: String]()
namesOfIntegers[3] = "three"
namesOfIntegers[56] = "fifty-six"

// Empty dictionary
namesOfIntegers = [:]

var airports: [String: String] = ["YYZ": "Toronto Pearson", "DFW": "Dallas-Fort Worth International", "SAN": "San Diego International"]
print("The airports dictionary has \(airports.count) items")

if airports.isEmpty {
    print("The airports dictionary is empty!")
}

airports["DAL"] = "Dallas-Love"
airports["DAL"] = "Dallas-Love Field"
airports["DEV"] = "Devslopes International"

// To delete item from dictionary:
airports["DEV"] = nil

for (airportCode, airportName) in airports {
    print("\(airportCode): \(airportName)")
}

for key in airports.keys {
    print("Key: \(key)")
}

for val in airports.values {
    print("Value: \(val)")
}

