//
//  roundedButton.swift
//  dev-profile-app
//
//  Created by Todd Rings on 13/01/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import UIKit

class roundedButton: UIButton {

    override func awakeFromNib() {
        super.awakeFromNib()
        self.layer.cornerRadius = 10
        self.clipsToBounds = true
    }

}
