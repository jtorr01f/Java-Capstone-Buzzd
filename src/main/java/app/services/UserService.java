/*
package app.services;

import app.entities.UserEntity;
import app.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

   */
/* @Autowired
    private PasswordEncoder passwordEncoder;*//*


    public List<UserEntity> getAllUsers() {

        List<UserEntity> users = new ArrayList<UserEntity>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<UserEntity> getUserById(int id) {
        return userRepository.findById(id);
    }
    public Optional<UserEntity> getUserByEmail(String username) {
        return userRepository.findByUsername(username);
    }

    public void updateUserById(int id, UserEntity user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void saveUser(UserEntity user) {
       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
*/
