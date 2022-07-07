package dio.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Address address;
}
