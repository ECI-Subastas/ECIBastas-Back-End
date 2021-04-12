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

    @RequestMapping(value = "/user/createNewUser", method = RequestMethod.POST)
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        try {
            userService.createNewUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/changeRole", method = RequestMethod.POST)
    public ResponseEntity<?> changeUserRole(@PathVariable(name = "nickname") String nickname, @PathVariable(name = "email") String email, @PathVariable(name = "role") String role) {
        try {
            userService.changeUserRole(nickname, email, role);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/user/nickname", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByNickname(@RequestParam(name = "value") String nickname) {
        try {
            return new ResponseEntity<>(userService.getUserByNickname(nickname), HttpStatus.FOUND);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/user/email", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByEmail(@RequestParam(name = "value") String email) {
        try {
            return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.FOUND);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
