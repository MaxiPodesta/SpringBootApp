package ar.com.mp.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data//Create automatically the method getRoles
@Table(name="user")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;//Primary Key in the DB
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @OneToMany//This indicates that one user can have multiple Roles
    @JoinColumn(name="id_user")//this is the column that will be related beetwen the table of user and the table of rol
   //id_user is the foreing key
    private List<Rol> roles;//Recover the roles associated to an user

    

    

  
   

 
}

