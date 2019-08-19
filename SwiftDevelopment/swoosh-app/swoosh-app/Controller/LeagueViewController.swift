//
//  LeagueViewController.swift
//  swoosh-app
//
//  Created by Todd Rings on 04/01/2019.
//  Copyright © 2019 Todd Rings. All rights reserved.
//

import UIKit

class LeagueViewController: UIViewController {

    var player: Player!
    
    @IBOutlet weak var nextBtn: BorderButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        player = Player()
        
    }
    

    @IBAction func onNextTapped(_ sender: Any) {
        performSegue(withIdentifier: "skillVCSegue", sender: self)
    }
    
    
    @IBAction func onMensTapped(_ sender: Any) {
        selectLeague(leagueType: "mens")
    }
    
    @IBAction func onWomensTapped(_ sender: Any) {
        selectLeague(leagueType: "womens")
    }
    
    @IBAction func onCoedTapped(_ sender: Any) {
        selectLeague(leagueType: "coed")
    }
    
    func selectLeague (leagueType: String) {
        player.desiredLeague = leagueType
        nextBtn.isEnabled = true
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // prepare(for segue..) is always called BEFORE viewDidLoad() on the destination view controller
        
        if let skillVC = segue.destination as? SkillViewController {
            // Storying data in LeagueViewController Player()
            skillVC.player = player
        }
    }
    
}
