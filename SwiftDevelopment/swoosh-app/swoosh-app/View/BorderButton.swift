//
//  BorderButton.swift
//  swoosh-app
//
//  Created by Todd Rings on 03/01/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import UIKit

class BorderButton: UIButton {

    override func awakeFromNib() {
        super.awakeFromNib()
        layer.borderWidth = 2.0
        layer.borderColor = UIColor.white.cgColor
    }

}
