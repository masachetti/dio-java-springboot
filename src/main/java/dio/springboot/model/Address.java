package dio.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
@Data
public class Address {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private HashMap<String, Object> additionalProperties = new HashMap<String, Object>();
}
