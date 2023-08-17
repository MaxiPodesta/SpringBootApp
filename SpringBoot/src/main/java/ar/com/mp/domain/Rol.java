
package ar.com.mp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author maxip
 */
@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Because in Mysql I indicated that it will be of type AutoIncrement in jpa I can use IDENTITY for mapping it
    private Long idRol;//Primary key in the DB
    
    @NotEmpty
    private String name;//name of the second column in the table 
}