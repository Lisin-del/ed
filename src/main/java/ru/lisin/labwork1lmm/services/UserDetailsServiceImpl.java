package ru.lisin.labwork1lmm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.lisin.labwork1lmm.entities.User;
import ru.lisin.labwork1lmm.security.UserRole;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    // lisinlogin/lisinpassword
    // $2a$12$l//D4fE2CPgmnVKIQN5r9.hjlKVRkLRCQXCx93KspQQQq5OXWPFgS

    // admin/admin
    // $2a$12$F/n8FexuxbH4w.QzksiX1.LEebcgmbOVK9ZlH/4DWNHLe8HeJsTGS
    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = userService.getUser(userLogin);
        Set<GrantedAuthority> userRoles = new HashSet<>();
        UserRole userRole = UserRole.valueOf(user.getRole());
        userRoles.add(new SimpleGrantedAuthority(userRole.name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                userRoles
        );
        return userDetails;
    }
}
