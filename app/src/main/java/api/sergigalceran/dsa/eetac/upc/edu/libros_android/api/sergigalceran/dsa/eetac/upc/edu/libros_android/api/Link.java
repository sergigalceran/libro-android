package api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.sergigalceran.dsa.eetac.upc.edu.libros_android.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergi1 on 08/05/2015.
 */
public class Link {

    private String target;
    private Map<String, String> parameters;

    public Link() {
        parameters = new HashMap<String, String>();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}