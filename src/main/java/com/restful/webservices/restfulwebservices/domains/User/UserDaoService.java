package com.restful.webservices.restfulwebservices.domains.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 4;

    static {
        users.add(new User(1,"ball",new Date()));
        users.add(new User(2,"sall",new Date()));
        users.add(new User(3,"fall",new Date()));
        users.add(new User(4,"ndiaye",new Date()));
    }

    /**
     * @return List<User>
     */
    public List<User> findAll(){
        return users;
    }

    /**
     * @param user
     * @return user
     */
    public User save(User user){
        if(user.getId() == 0){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    /**
     * @param id
     * @return user
     */
    public User findOne(int id){
        for(User user: users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    
}
