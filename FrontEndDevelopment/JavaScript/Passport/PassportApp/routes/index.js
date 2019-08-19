var express = require('express');
var router = express.Router();

router.get('/', ensureAuthenticated, function(req, res){
  res.render('INDEX');
});

function ensureAuthenticated (req, res, next){
  if(req.isAuthenticated()){
    return next();
  }
  // if not authenticated, users "booted out" to login page
  res.redirect('/users/login');
}


module.exports = router;
