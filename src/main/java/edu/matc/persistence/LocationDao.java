package edu.matc.persistence;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.location.LocationResponseList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Location Dao.
 */
public class LocationDao {


    private Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Location Dao.
     */
    public LocationDao() {
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/restful.properties"));
        } catch (IOException ioe) {
            logger.error("SmartyStreets.loadProperties()...Cannot load the properties file");
        } catch (Exception e) {
            logger.error("SmartyStreets.loadProperties()..." + e);
        }
    }

    /**
     * Get city response smarty response item [ ].
     *
     * @param city  the city
     * @param state the state
     * @return the smarty response item [ ]
     */
    public LocationResponseList[] getResponse(String city, String state)  {

      // city = city.replaceAll(" ", "%20");

        Client client = ClientBuilder.newClient();
        String auth = properties.getProperty("auth");
        String token = properties.getProperty("token");
        String url = "https://us-zipcode.api.smartystreets.com/lookup?auth-id=" + auth + "&auth-token=" + token + "&city=" + city + "&state=" + state;
        WebTarget target = client.target(url);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        LocationResponseList[] locationResponse = null;
        ObjectMapper mapper = new ObjectMapper();
     //   try {
          //  locationResponse = mapper.readValue(response,LocationDao[].class);
//
      //  } catch (JsonProcessingException e) {
      //      logger.error("JsonProcessingException" + e);
      //  }
        return locationResponse ;
    }
}

