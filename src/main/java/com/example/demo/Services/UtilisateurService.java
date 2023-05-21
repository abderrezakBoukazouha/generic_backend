package com.example.demo.Services;


import com.example.demo.models.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class UtilisateurService {
    private final UtilisateurRepository userRepository;


    public List<Utilisateur> getUsersFromDataBase () {
        return userRepository.findAll();
    }

    public void addUserToDataBase(Utilisateur user) {
        user.setId(new Random().nextLong());
        userRepository.save(user);
    }
}
