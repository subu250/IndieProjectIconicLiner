package edu.matc.persistence;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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


    }
