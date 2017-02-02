package at.fhj.swengs.controller;

import at.fhj.swengs.model.UserRepository;
import at.fhj.swengs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@RestController
@RequestMapping("/rest")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("user/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value="/user/userName", method = RequestMethod.POST)
    public User findByUserName(@RequestBody String userName) {
        return userRepository.findByUserName(userName);
    }

    @RequestMapping(value = "/user/update", method=RequestMethod.POST)
    public void updateUser(@RequestBody User user) {
        User currentUser = userRepository.findOne(user.getUserID());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        userRepository.save(user);
    }

    @RequestMapping(value = "/user/delete", method=RequestMethod.POST)
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }

}
