# swoosh-app - Introduction fo Interface Building and Auto Layout

This Introductory app is just to showcase the following:
    1. How to create ViewControllers, add images, labels, and buttons
    2. Created a custome UIButton (reusable component)
    3. Utilize frames to make the design "pixel perfect"
    4. Utilize constraints to make the app easier to design for auto layout
    5. Utilize UIStackView to make spacing between various elements more uniform
    6. Create ViewController segues from one VC to the next. Added a Back Segueq with a simple line of code:
        <code>@IBAction func unwindFromSkillVC(unwindSegue: UIStoryboardSegue) { }</code>
    7. Created Programmatic Segue for the 2nd to third screen
    8. Created a Model (struct Player) to store data centrally
    9. Pass data between ViewControllers using "prepare(for segue..)"

Eighth Commit: Pass data between ViewControllers (Final)

Seventh Commit: Created a (struct) model, Player, to store data to satisfy requirement for "desired league"

Sixth Commit: Programmatic segue from 2nd to 3rd screen

Fifth Commit: Storyboard transitions (next). Working on Segues back (for 3rd screen)

Fourth Commit: Utilized UIStackView for the remaining layouts (2nd and 3rd screen)

Third Commit: Used constraints to apply proper auto layout as per Apple recommendations

Second Commit: Use frames to "auto layout" (portrait-mode only) across all iOS devices for swoosh logo and background image

First Commit: Design the welcome screen for iPhone Xs Resolution
-created a custom UIButton called: BorderButton to add a 2.0 width white border to all buttons
