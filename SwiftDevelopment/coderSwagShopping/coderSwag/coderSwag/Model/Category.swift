//
//  Category.swift
//  coderSwag
//
//  Created by Todd Rings on 25/02/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import Foundation

struct Category {
    private(set) public var title: String
    private(set) public var imageName: String
    // CANNOT set these variables from other classes/ViewControllers/etc
    // CAN ONLY be retrieved and used
    // Allows for better control of Data
    
    init(title: String, imageName: String) {
        // These are Parameters, not the same as the variables above
        self.title = title
        self.imageName = imageName
    }

}
