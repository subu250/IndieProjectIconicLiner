package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * A utility class for sending e-mail messages
 */

public class EmailUtil {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Utility method to send simple HTML email
     * @param session the session
     * @param recipient the recipient
     * @param subject subject
     * @param body body
     */
    public static void sendEmail(Session session, String recipient, String subject, String body){

        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));

            Transport.send(msg);

        }
        catch (Exception e) {

        }
    }
}