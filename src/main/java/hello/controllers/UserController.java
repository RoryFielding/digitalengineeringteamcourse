package hello.controllers;

import hello.entities.User;
import hello.error.NotFoundException;
import hello.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping(value = "/")
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User>  getUserById(@PathVariable("id") ObjectId id){

        User user = repository.findBy_id(id);
        if(user == null){
            logger.error("UserController");
            throw new NotFoundException();
        }
        return new ResponseEntity<User>(repository.findBy_id(id), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
        user.set_id(id);
        repository.save(user);
    }

    @PostMapping(value = "/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.set_id(ObjectId.get());
        return new ResponseEntity<User>(repository.save(user), HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
