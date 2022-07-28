
package mobiquity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;


}
