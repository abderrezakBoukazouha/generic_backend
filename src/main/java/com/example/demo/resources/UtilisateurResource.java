package com.example.demo.resources;

import com.example.demo.Services.UtilisateurService;
import com.example.demo.models.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisateurResource {

    private final UtilisateurService userService;
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUsers() {
        return userService.getUsersFromDataBase();    }

    @PostMapping("/utilisateur")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody Utilisateur user) {
        userService.addUserToDataBase(user);
    }

    @GetMapping("/bar")
    public String greeting() {
        return "football";}
}
