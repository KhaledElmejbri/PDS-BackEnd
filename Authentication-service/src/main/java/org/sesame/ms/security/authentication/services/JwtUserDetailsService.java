package org.sesame.ms.security.authentication.services;

import org.sesame.ms.security.authentication.models.DAOUser;
import org.sesame.ms.security.authentication.models.UserCredentiel;
import org.sesame.ms.security.authentication.models.UserDTO;
import org.sesame.ms.security.authentication.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<DAOUser> user = userDao.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        DAOUser luser=user.get();

        return UserCredentiel.create(luser);
    }

    //trans ==/
    @Transactional
    public UserDetails loadUserById(Long id) {
        DAOUser user = userDao.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("Userid" + id)
        );

        DAOUser luser=user;


        return UserCredentiel.create(luser);
    }


    public DAOUser save(UserDTO userDTO) {

        try {

            DAOUser user = new DAOUser(
                    userDTO.getFirstName(),
                    userDTO.getLastName(),
                    userDTO.getSex(),
                    userDTO.getProfilePicture(),
                    userDTO.getEmail(),
                    userDTO.getPortfolioId(),
                    userDTO.getJob(),
                    userDTO.getSesameClasse(),
                    userDTO.getProfBackground(),
                    userDTO.getAssignedClasses(),
                    userDTO.getUserrole()
            );

            if(!user.getAssignedClasses().isEmpty()){

                user.getAssignedClasses().forEach(i->{
                    i.setUsers(user);
                });

            }


            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String password = userDTO.getPassword();

            String bcrpassword = passwordEncoder.encode(password);

            user.setFailedattempt(0);

            user.setLocked(false);

            user.setPassword(bcrpassword);
            DAOUser result = userDao.save(user);
            return result;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
