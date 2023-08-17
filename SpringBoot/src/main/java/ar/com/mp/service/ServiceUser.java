package ar.com.mp.service;

import ar.com.mp.domain.Rol;
import ar.com.mp.dao.daoUser;
import ar.com.mp.domain.Usuario;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailService")//This class is use by spring security
@Slf4j
public class ServiceUser implements UserDetailsService{

    @Autowired
    private daoUser uDao;  //This class interact with interact with the table of user and roles
    
    @Override//This class depends of the daoUser class
    //It upload all the information, recovered of the user, implementening in a proper way that springSecurity acept it 
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario usr = uDao.findByUsername(username);
      if(usr == null){
      throw new UsernameNotFoundException(username);//In case the username is not found
      }
    ArrayList<GrantedAuthority> roles = new ArrayList<>();//The class Role can't be use straight, springSecurity nedds GrantedAuthority
    
    for(Rol rol: usr.getRoles()){
        roles.add(new SimpleGrantedAuthority(rol.getName()));//Every rol recovered is covered with the class SimpleGrantedAuthority
    }
    
return new User(usr.getUsername(),usr.getPassword(),roles);
   
}
    
}

