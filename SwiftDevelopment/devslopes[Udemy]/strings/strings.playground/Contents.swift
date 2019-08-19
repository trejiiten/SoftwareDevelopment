import UIKit

var str: String = "Hello, playground" // Explicity Declared Type
//var str = "Hello, playground" // Type Inference

var firstName = "Todd"
var lastName = "Rings"

var age = 37
var fullName = firstName + " " + lastName
var fullName2 = "\(firstName) \(lastName) is \(age)" //String Interpolation

fullName.append(" III")

var bookTitle = "a midwinter's brunch"
bookTitle = bookTitle.capitalized

var annoyingCaps = "HAHAHAHA PLZ HLP ME NOW"
var lowercasedChat = annoyingCaps.lowercased()

var sentence = "What the fetch! Heck that is crazy"

if sentence.contains("fetch") || sentence.contains("Heck") {
    sentence.replacingOccurrences(of: "fetch", with: "tuna")
    sentence.replacingOccurrences(of: "Heck", with: "Salmon")
}

