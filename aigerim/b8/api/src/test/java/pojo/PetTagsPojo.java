package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @JsonIgnoreProperties(ignoreUnknown = true)
public class PetTagsPojo {
    private int id;
    private String name;

}
