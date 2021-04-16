package com.m2u.interview.security;

import com.m2u.interview.db.entity.User;
import com.m2u.interview.db.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AuthenticationService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository _userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = _userRepository.findByUserName(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email : " + username));

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) throws Exception {
        User user = _userRepository.findById(id).orElseThrow(
            () -> new Exception("User id [" + id.toString() + "] not found")
        );

        return UserPrincipal.create(user);
    }
}
