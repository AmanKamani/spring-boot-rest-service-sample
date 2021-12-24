package jb.production.restwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
    
    @Autowired
    private UserDaoService userService;

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = userService.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userService.deleteById(id);
        if(user == null)
            throw new UserNotFoundException("id-"+id);
    }

}
