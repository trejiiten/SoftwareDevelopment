//
//  Wage.swift
//  window-shopper
//
//  Created by Todd Rings on 23/02/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import Foundation
class Wage {
                    // ParamenterName_space_variableName: Type
    class func getHours (forWage wage: Double, andPrice price: Double) -> Int {
        return Int(ceil(price / wage)) // ceil=Math.ceiling, Int(code)=convert to Int
        // Why ceil() and not round()?
        // if a number is .499999...n, round() will always round DOWN
        // For this example, we want to always round UP
        // (You know, give a little bit of extra as a remainder)
        // round() does not pass the testing logic we have made
    }
}
