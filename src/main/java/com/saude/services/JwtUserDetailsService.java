package com.saude.services;

import java.util.ArrayList;
import java.util.List;

import com.saude.domain.Admin;
import com.saude.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        initialUsers();
        Admin admin = adminRepository.findByEmail(email);

        if (admin.getEmail().equals(email)) {
            return new User(email, admin.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }

    private void initialUsers() {
        Admin adm = new Admin();
        adm.setUsername("Doutor");
        adm.setPassword("doutor1234");
        adm.setEmail("doutor@consultorio");

        Admin adm2 = new Admin();
        adm.setUsername("Enfermeira");
        adm.setPassword("enfermeira1234");
        adm.setEmail("enfermeira@consultorio");

        List<Admin> admins = new ArrayList<Admin>();
        admins.add(adm);
        admins.add(adm2);

        adminRepository.saveAll(admins);
    }

}