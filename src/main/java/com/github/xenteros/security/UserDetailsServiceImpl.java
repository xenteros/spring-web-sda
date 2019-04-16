package com.github.xenteros.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

class UserDetailsServiceImpl implements UserDetailsService {

    //tutaj potrzebne jest UserDAO - można/trzeba autowireować.

    List<User> users;


    public UserDetailsServiceImpl() {
        users = asList(new User("Jan", "pass", "jan@gmail.com"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //tutaj wyciągamy jednego użytkownika z dao i sprawdzamy, czy nie jest nullem.
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return new UserDetailsImpl(
                        user.getLogin(),
                        user.getPassword(),
                        user.getEmail());
            }
        }
        throw new UsernameNotFoundException(username);
    }
}
