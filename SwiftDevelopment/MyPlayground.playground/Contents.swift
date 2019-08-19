import UIKit

let name = "Todd Rings"
let age = 37
let location = "Fort Worth"

"Your name is \(name), you are \(age), you live in \(location)."
"You are \(age) right now, but in 15 years, you will be \(age + 15)."

//var songs = ["Shake it Off", "You Belong with Me", "Love Story"]
//var songs2 = ["Today was a Fairytale", "Welcome to New York", "Fifteen"]
//var both = songs + songs2
//both += ["Girls Not Grey"]


//dictionary (js Object)
let person = [
    "first": "Todd",
    "middle": "Alan",
    "last": "Rings",
    "month": "October",
    "website": "toddandseohee.co.nf"
]

person["middle"]
person["month"]

//print("1 x 10 is \(1 * 10)")
//print("2 x 10 is \(2 * 10)")
//print("3 x 10 is \(3 * 10)")
//print("4 x 10 is \(4 * 10)")
//print("5 x 10 is \(5 * 10)")
//print("6 x 10 is \(6 * 10)")
//print("7 x 10 is \(7 * 10)")
//print("8 x 10 is \(8 * 10)")
//print("9 x 10 is \(9 * 10)")
//print("10 x 10 is \(10 * 10)")

for i in 1...10 {
    print("\(i) x 10 is \(i * 10)")
}

var str = "We won the league at"

for _ in 1..<3 {
    str += " SHITE HEART LANE"
}

print(str)

var songs = ["Shake it Off", "You Belong with Me", "Look What You Made Me Do"]

for song in songs {
    print("My favorite song is \(song)")
}

var people = ["players", "haters", "heart-breakers", "fakers"]
var actions = ["play", "hate", "break", "fake"]

//for i in 0 ..< people.count {
//    print("\(people[i]) gonna \(actions[i])")
//}
for i in 0 ..< people.count {
    var str2 = "\(people[i]) gonna"
    
    for _ in 1 ... 5 {
        str2 += " \(actions[i])"
    }
    
    print(str2)
}

var counter = 0

while true {
    print("Counter is now \(counter)")
    counter += 1
    
    if counter == 556 {
        break
    }
}

for song in songs {
    if song == "You Belong with Me" {
        continue
    }
    
    print("My favorite song is \(song)")
}

let liveAlbums = 2

switch liveAlbums {
case 0:
    print("You're just starting out")
    
case 1:
    print("You just released iTunes Live From SoHo")
    
case 2:
    print("You just released Speak Now World Tour")
    
default:
    print("Have you done something new?")
}

let studioAlbums = 5

switch studioAlbums {
case 0...1:
    print("You're just starting out")
    
case 2...3:
    print("You're a rising star")
    
case 4...5:
    print("You're world famous!")
    
default:
    print("Have you done something new?")
}

func favoriteAlbum(name: String) {
    print("My favorite is \(name)")
}

favoriteAlbum(name: "그대에게")

func printAlbumRelease(name: String, year: Int) {
    print("\(name) was released in \(year)")
}

printAlbumRelease(name: "Fearless", year: 2008)
printAlbumRelease(name: "Speak Now", year: 2010)
printAlbumRelease(name: "Red", year: 2012)

func countLettersInString(_ str: String) {
    print("The string \(str) has \(str.count) letters.")
}

countLettersInString("Hello")

func countLetters(in string: String) {
    print("The string \(string) has \(string.count) letters.")
}

countLetters(in: "Mariners")

func albumIsTaylor(name: String) -> Bool {
    if name == "Taylor Swift" { return true }
    if name == "Fearless" { return true }
    if name == "Speak Now" { return true }
    if name == "Red" { return true }
    if name == "1989" { return true }
    
    if albumIsTaylor(name: "Red") {
        print("That's one of hers!")
    } else {
        print("Who made that?!")
    }
    
    if albumIsTaylor(name: "Blue") {
        print("That's one of hers!")
    } else {
        print("Who made that?!")
    }
    
    return false
}

func getHaterStatus(weather: String) -> String? {
    if weather == "sunny" {
        return nil
    } else {
        return "Hate"
    }
}

func takeHaterAction(status: String) {
    if status == "Hate" {
        print("Hating")
    }
}

if let haterStatus = getHaterStatus(weather: "rainy") {
    takeHaterAction(status: haterStatus)
}

var items = ["James", "John", "Sally"]

func position(of string: String, in array: [String]) -> Int {
    for i in 0 ..< array.count {
        if array[i] == string {
            return i
        }
    }
    
    return 0
}

let jamesPosition = position(of: "James", in: items)
let johnPosition = position(of: "John", in: items)
let sallyPosition = position(of: "Sally", in: items)
let bobPosition = position(of: "Bob", in: items)


func yearAlbumReleased(name: String) -> Int? {
    if name == "Taylor Swift" { return 2006 }
    if name == "Fearless" { return 2008 }
    if name == "Speak Now" { return 2010 }
    if name == "Red" { return 2012 }
    if name == "1989" { return 2014 }
    
    return nil
}

var year = yearAlbumReleased(name: "Fearless")

if year == nil {
    print("There was an error")
} else {
    print("It was released in \(year!)")
}


func albumReleased(year: Int) -> String? {
    switch year {
    case 2006: return "Taylor Swift"
    case 2008: return "Fearless"
    case 2010: return "Speak Now"
    case 2012: return "Red"
    case 2014: return "1989"
    default: return nil
    }
}

let album = albumReleased(year: 2006) ?? "unknown"
print("The album is \(album)")


enum WeatherType {
    case sun
    case cloud
    case rain
    case wind(speed: Int)
    case snow
}

func getHaterStatus(weather: WeatherType) -> String? {
    switch weather {
    case .sun:
        return nil
    case .wind(let speed) where speed < 10:
        return "meh"
    case .cloud, .wind:
        return "dislike"
    case .rain, .snow:
        return "hate"
    }
}

getHaterStatus(weather: WeatherType.wind(speed: 5))


//struct Person {
//    var clothes: String
//    var shoes: String
//
//    func describe() {
//        print("I like wearing \(clothes) with \(shoes)")
//    }
//}
//
//let taylor = Person(clothes: "T-shirts", shoes: "sneakers")
//let other = Person(clothes: "short skirts", shoes: "high heels")
//
//var taylorCopy = taylor
//taylorCopy.shoes = "flip flops"
//
//print(taylor)

//class Person {
//    var clothes: String
//    var shoes: String
//
//    init(clothes: String, shoes: String) {
//        self.clothes = clothes
//        self.shoes = shoes
//    }
//}


class Singer {
    var name: String
    var age: Int
    
    init(name: String, age: Int) {
        self.name = name
        self.age = age
    }
    
    func sing() {
        print("La la la la")
    }
}

//var taylor = Singer(name: "Taylor", age: 25)
//taylor.name
//taylor.age
//taylor.sing()

class CountrySinger: Singer {
    override func sing() {
        print("Trucks, guitars, and liquor")
    }
}

//var taylor = CountrySinger(name: "Taylor", age: 25)
//taylor.sing()

class HeavyMetalSinger: Singer {
    var noiseLevel: Int
    
    init(name: String, age: Int, noiseLevel: Int) {
        self.noiseLevel = noiseLevel
        super.init(name: name, age: age)
    }
    
    override func sing() {
        print("Grrrrr rargh rargh rarrrrgh!")
    }
}

//var taylor = HeavyMetalSinger(name: "Taylor", age: 25, noiseLevel: 120)
//taylor.sing()

//struct Person {
//    var clothes: String
//    var shoes: String
//
//    func describe() {
//        print("I like wearing \(clothes) with \(shoes)")
//    }
//}
//
//let taylor = Person(clothes: "T-shirts", shoes: "sneakers")
//let other = Person(clothes: "short skirts", shoes: "high heels")
//taylor.describe()
//other.describe()

//struct Person {
//    var clothes: String {
//        willSet {
//            updateUI(msg: "I'm changing from \(clothes) to \(newValue)")
//        }
//
//        didSet {
//            updateUI(msg: "I just changed from \(oldValue) to \(clothes)")
//        }
//    }
//}
//
//func updateUI(msg: String) {
//    print(msg)
//}
//
//var taylor = Person(clothes: "T-shirts")
//taylor.clothes = "short skirts"

struct Person {
    var age: Int
    
    var ageInDogYears: Int {
        get {
            return age * 7
        }
    }
}

var fan = Person(age: 25)
print(fan.ageInDogYears)
