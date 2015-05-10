package api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.sergigalceran.dsa.eetac.upc.edu.libros_android.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergi1 on 08/05/2015.
 */
public class LibrosRootAPI {
    private Map<String, Link> links;

    public LibrosRootAPI() {
        links = new HashMap<String, Link>();
    }

    public Map<String, Link> getLinks() {
        return links;
    }
}
