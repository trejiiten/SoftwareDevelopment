import UIKit

var str = "Hello, playground"

var amICool = true
amICool = false

if true == false || true == true {
    print("Wha....?")
}

var hasDataFinishedDownloading: Bool = false
//.
//..
if !hasDataFinishedDownloading {
    print("Loading data ...")
}
//...
//....
hasDataFinishedDownloading = true
//Load UI and other app features

// Equal to: ==
// Not Equal to: !=
// Greater than: a > b
// Greater than or equal to: a >= b
// Less than or equal to: a <= b
// Less than: a < b

var bankBalance = 400
var itemToBuy = 400

if bankBalance >= itemToBuy {
    print("Purchased Item")
}

if itemToBuy > bankBalance {
    print("You need more money")
}

if itemToBuy == bankBalance {
    print("Your balance is now 0")
}

var bookTitle1 = "Harry Blotter and the Moppet of Mire"
var bookTitle2 = "Harry Blotter and the Moppet of Mire"

if bookTitle1 != bookTitle2 {
    print("Incorrect Spelling")
} else if bookTitle2.characters.count > 40 {
    print("Find a new title")
} else {
    print("Ready to Print")
}
