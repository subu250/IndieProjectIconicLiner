package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

    /**
     * Class that sends email
     */
    public class SendEmail {

        private final Logger logger = LogManager.getLogger(this.getClass());
        private Properties properties;

        public SendEmail() {
            loadProperties();
        }

        // load properties
        private void loadProperties() {
            properties = new Properties();
            try {
                properties.load(this.getClass().getResourceAsStream("/email.properties"));
            } catch (IOException ioe) {
                logger.error("Database.loadProperties()...Cannot load the properties file.." + ioe);
            } catch (Exception e) {
                logger.error("Database.loadProperties()..." + e);
            }

        }

        public void getInformation(String Subject, String message) {


            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            // creates a new session with authenticator
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(properties.getProperty("sender"), properties.getProperty("password"));
                }
            };

            Session session = Session.getDefaultInstance(props, auth);
            //log.error("Session created");
            EmailUtil.sendEmail(session, properties.getProperty("recipient"), Subject, message);
        }
    }

