
package mobiquity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Geo {

    public String lat;
    public String lng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



}
