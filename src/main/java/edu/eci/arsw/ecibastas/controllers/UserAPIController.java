package edu.eci.arsw.ecibastas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.services.UserService;
import edu.eci.arsw.ecibastas.services.exceptions.UserServiceException;

@RestController
@CrossOrigin(origins = "*")
public class UserAPIController {
    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/createNewUser", method = RequestMethod.POST)
    public ResponseEntity<?> createNewUserEntity(@RequestBody User user) {
        try {
            userService.createNewUser(user);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/user/changeRole", method = RequestMethod.POST)
    public ResponseEntity<?> changeUserRoleEntity(@PathVariable(name = "nickname") String nickname, @PathVariable(name = "email") String email, @PathVariable(name = "role") String role) {
        try {
            userService.changeUserRole(nickname, email, role);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByNicknameEntity(@RequestParam(name = "nickname") String nickname) {
        try {
            return new ResponseEntity<>(userService.getUserByNickname(nickname), HttpStatus.FOUND);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByEmailEntity(@RequestParam(name = "email") String email) {
        try {
            return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.FOUND);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
