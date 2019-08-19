//
//  ViewController.swift
//  coderSwag
//
//  Created by Todd Rings on 25/02/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import UIKit

class CategoriesViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    @IBOutlet weak var categoryTable: UITableView!

    override func viewDidLoad() {
        super.viewDidLoad()
        categoryTable.dataSource = self
        categoryTable.delegate = self
        categoryTable.rowHeight = 165
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return DataService.instance.getCategories().count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell = tableView.dequeueReusableCell(withIdentifier: "CategoryCell") as? CategoryCell {
            let category = DataService.instance.getCategories()[indexPath.row]
            // Grabbing specific Item[ROW] from Array[Category]
                // let categories = DataService.instance.getCategories()
                // let category = categories[indexPath.row]
            cell.updateViews(category: category)
            return cell
            
        } else {
            return CategoryCell()
        }
        // Don't forget to add "CategoryCell" to the Table View Cell's Identified in StoryBoard!
    }

}

