# window-shopper
Fully Functional iOS 12 app for the iPhone

Sixth Commit: Added location-based currency symble to labels using DrawRect
-this is the code entered to add a custom currency icon based upon the device's location inside both text boxes
<code>
override func draw(_ rect: CGRect) {
let size: CGFloat = 20
let currencyLabel = UILabel(frame: CGRect(x: 5, y: (frame.size.height / 2) - size / 2, width: size, height: size))
currencyLabel.backgroundColor = #colorLiteral(red: 0.9093061852, green: 0.9093061852, blue: 0.9093061852, alpha: 0.8)
currencyLabel.textAlignment = .center
currencyLabel.textColor = #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1)
currencyLabel.layer.cornerRadius = 5.0
currencyLabel.clipsToBounds = true
let formatter = NumberFormatter()
formatter.numberStyle = .currency
formatter.locale = .current
currencyLabel.text = formatter.currencySymbol
addSubview(currencyLabel)
}
</code>

-Note: due to using DrawRect, the customView function (for the hours & price labels) border radius have reverted to a radius of 0.0. To fix, just add the following code inside of the customView() functionality
<code>
clipsToBounds = true
</code>

Fifth Commit: Added Calculation Functionality
-Added Total Hours Needed to work
-Added Clear Caluclator UIButton fuctionality
-Need to add currency...

Fourth Commit: Added some logic and unit testing

Third Commit: Created UIButton with code. Added InputAccessoryView for 2 text fields.


Second Commit: Created Customized Text Fields for a UITextField Class
- inserted this code for cleaner coding practices:
<code>
override func awakeFromNib() {
super.awakeFromNib()
backgroundColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0.25)
layer.cornerRadius = 5.0
textAlignment = .center
/* Old Version
if placeholder == nil {
 placeholder = " "
}*/

// Better, Cleaner, Mo' BETTER version
if let p = placeholder {
let place = NSAttributedString(string: p, attributes: [.foregroundColor: #colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)])
attributedPlaceholder = place
textColor = #colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)
}


}
</code>

First Commit: Initialized xcode Project Files
