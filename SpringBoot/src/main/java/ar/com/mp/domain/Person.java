package ar.com.mp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    @NotEmpty// It doesn't allowed empty fields in the form
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    @Email// Specific email format
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private Double budget;
}
