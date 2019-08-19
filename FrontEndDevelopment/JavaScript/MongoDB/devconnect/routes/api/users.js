const express = require('express');
const router = express.Router();
const gravatar = require('gravatar');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const keys = require('../../config/keys');
const passport = require('passport');

// Load User Model
const user = require('../../models/Users');

// @route   GET api/users/test @desc    Tests Users route @access  PUBLIC
router.get('/test', (req, res) => res.json({msg: "Users Works"}));

// @route   GET api/users/register @desc    Register Users route @access  PUBLIC
router.post('/register', (req, res) => {
    // Check if email is in DB
    User
        .findOne({email: req.body.email})
        .then(user => {
            if (user) {
                return res
                    .status(400)
                    .json({email: 'Email already exists'})
            } else {
                const avatar = gravatar.url(req.body.email, {
                    s: '200', // Avatar Size
                    r: 'pg', // Avatar Rating (MPAA rating)
                    d: 'mm' // Default Avatar (mm = "no picture" icon)
                });

                const newUser = new User({name: req.body.name, email: req.body.email, avatar, password: req.body.password});

                bcrypt.genSalt(10, (err, salt) => {
                    bcrypt.hash(newUser.password, salt, (err, hash) => {
                        if (err) 
                            throw err;
                        newUser.password = hash;
                        newUser
                            .save()
                            .then(user => res.json(user))
                            .catch(err => console.log(err));
                    });
                });
            }
        })
});

// @route   GET api/users/login @desc    Login Users / Return JWT Token @access
// PUBLIC
router.post('/login', (req, res) => {
    const email = req.body.email;
    const password = req.body.password;

    // Find User By Email
    User
        .findOne({email})
        .then(user => {
            // Check for User
            if (!user) {
                return res
                    .status(404)
                    .json({email: 'User Not Found'})
            }
            // Check Password (match PW in DB)
            bcrypt
                .compare(password, user.password)
                .then(isMatch => {
                    if (isMatch) {
                        // User Matched

                        const payload = {
                            id: user.id,
                            name: user.name,
                            avatar: user.avatar
                        } // Create JWT Payload

                        // Sign Token
                        jwt.sign(payload, keys.secretOrKey, {
                            expiresIn: 600
                        }, (err, token) => {
                            res.json({
                                success: true,
                                token: 'Bearer ' + token
                            });
                        });
                    } else {
                        return res
                            .status(400)
                            .json({password: 'Password Is Incorrect'});
                    }
                });
        });
});

// @route   GET api/users/current @desc    Return Current User @access  Private
router.get('/current', passport.authenticate('jwt', {session: false}), (req, res) => {
    res.json({msg: 'Success'});
});

module.exports = router;