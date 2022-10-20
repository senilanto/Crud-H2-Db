package com.crud.h2.Service;

import com.crud.h2.Repository.UserRepository;
import com.crud.h2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
  private  UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public User getUserById(int id){
     return userRepository.findById(id).get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        User oldUser=null;
        Optional<User> optionalUser=userRepository.findById(user.getId());
      if(optionalUser.isPresent()){
         oldUser= optionalUser.get();
         oldUser.setName(user.getName());
         oldUser.setAddress(user.getAddress());
         userRepository.save(oldUser);
      }
      else{
          return  new User();
      }
      return  oldUser;
    }



    public String deleteUser(int id){
      userRepository.deleteById(id);
      return "user deleted";

    }

}
