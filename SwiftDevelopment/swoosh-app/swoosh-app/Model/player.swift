//
//  player.swift
//  swoosh-app
//
//  Created by Todd Rings on 04/01/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import Foundation

struct Player {
    var desiredLeague: String!
    var selectedSkillLevel: String!
}

// Remember This:
//     var myData: String! is an Implicitly Unwrapped Optional
// Use ONLY when you can guarantee that the variable will have data in it before used
//-------------------------------------------------------------------------------------
//     var myData: String? is an Optional
// Use when there MAY or MAY NOT be data in the variable at runtime

