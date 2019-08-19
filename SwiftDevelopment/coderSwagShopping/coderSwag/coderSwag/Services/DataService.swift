//
//  DataService.swift
//  coderSwag
//
//  Created by Todd Rings on 25/02/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import Foundation

class DataService {
    static let instance = DataService()
    // This is a SINGLETON (design pattern)
    // Creates one copy in memory. Multiple copies & different versions of data is not ideal
    
    
    private let categories = [
    Category(title: "SHIRTS", imageName: "shirts.png"),
    Category(title: "HOODIES", imageName: "hoodies.png"),
    Category(title: "HATS", imageName: "hats.png"),
    Category(title: "DIGITAL", imageName: "digital.png"),
    ]
    
    func getCategories() -> [Category] {
        // Function returns an ARRAY of "Categories"
        return categories
    }
}
