// package com.example.demo.service;

// import com.example.demo.entity.User;

// public interface AuthService {

//     String login(String email, String password);

//     User register(User user);
// }


package com.example.demo.service;

import com.example.demo.entity.User;

public interface AuthService {

    User register(User user);

    String login(String email, String password);
}
