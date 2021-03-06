package edu.eci.arsw.ecibastas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public ResponseEntity<?> changeUserRole(@RequestParam(name = "nickname") String nickname,
            @RequestParam(name = "email") String email, @RequestParam(name = "role") String role) {
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
            return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.ACCEPTED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/user/nickname/userId", method = RequestMethod.GET)
    public ResponseEntity<?> getUserNicknameById(@RequestParam(name = "value") int userId) {
        try {
            return new ResponseEntity<>(userService.getUserNicknameById(userId), HttpStatus.ACCEPTED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/user/id", method = RequestMethod.GET)
    public ResponseEntity<?> getUserIdByEmail(@RequestParam(name = "email") String email) {
        try {
            return new ResponseEntity<>(userService.getUserIdByEmail(email), HttpStatus.FOUND);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/user/credit", method = RequestMethod.GET)
    public ResponseEntity<?> getCreditByUserId(@RequestParam(name = "userId") int id) {
        try {
            return new ResponseEntity<>(userService.getCreditByUserId(id), HttpStatus.FOUND);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/user/sumCredits", method = RequestMethod.PUT)
    public ResponseEntity<?> sumCredits(@RequestParam(name = "userId") int id,@RequestParam(name = "credits") int credits ) {
        try {
            userService.sumCredits(id, credits);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
