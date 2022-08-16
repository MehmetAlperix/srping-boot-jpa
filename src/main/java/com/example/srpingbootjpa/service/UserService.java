package com.example.srpingbootjpa.service;

import com.example.srpingbootjpa.dao.UserRepository;
import com.example.srpingbootjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public  List<User> createUsers(List<User> users)
    {
        return userRepository.saveAll(users);
    }

    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User updateUser(User user)
    {
        User oldUser;
        Optional<User> optionalUser;

        optionalUser = userRepository.findById(user.getId());

        if( optionalUser.isPresent() )
        {
            oldUser = optionalUser.get();
            oldUser.setAddress(user.getAddress());
            oldUser.setName(user.getName() );
            userRepository.save(oldUser);
        }
        else
        {
            return new User();
        }
        return oldUser;
    }

    public boolean deleteUserById(Long id)
    {
        if( userRepository.existsById( id) )
        {
            userRepository.deleteById(id);
            return true;
        }
        else
        {
            return  false;
        }
    }
}

