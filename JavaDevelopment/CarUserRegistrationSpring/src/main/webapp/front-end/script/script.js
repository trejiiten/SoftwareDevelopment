const showNav = () => {
    const navLinks = document.querySelector('.navbar');
    const toggle = document.querySelector('.toggle');

    toggle.addEventListener("click", () => {
        if (navLinks.style.display != "block") {
            navLinks.style.display = "block";

        } else {
            navLinks.style.display = "none";

        }
    });

}
showNav();


function checkPassword(password,cPassword){
    password = document.getElementsByName("password");
    cPassword = document.getElementsByName("cPassword");
    let regex = "(?-i)(?=^.{8,}$)((?!.*\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\d){1,})|(?=(.*\W){1,}))^.*$";
    let e = document.getElementById("exception");
    let form = document.getElementsByTagName('form');
    if(!password.match(cPassword)){
        e.innerHTML = "Passwords must match";
        form.clear();
        return false;
    } else if (password.match(regex) || cPassword.match(regex)) {
        e.innerHTML = "Password must have at least 8 characters with a Capital letter, a lower case letter, and a number or special character.";        
      form.clear();  
      return false;
    } else {
        return true;
    }
    
}