package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @GetMapping
    public List<User> findAll(){
       return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findAll(@PathVariable long id){
        return ResponseEntity.of(userService.findById(id));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        userService.deleteById(id);
    }
}
