package pl.luczak.przemyslaw.pracadomowatydzien9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.luczak.przemyslaw.pracadomowatydzien9.aop.UserAnnotation;
import pl.luczak.przemyslaw.pracadomowatydzien9.model.User;
import pl.luczak.przemyslaw.pracadomowatydzien9.repository.UserRepository;

import java.util.List;

@Service
public class UserMongoService {

    private final UserRepository userRepository;

    @Autowired
    public UserMongoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @UserAnnotation
    public void saveAll(List<User> user) {
        userRepository.saveAll(user);
    }

    @UserAnnotation
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
