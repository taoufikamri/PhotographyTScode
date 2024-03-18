package application;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;

public class MailProjectClass {

public static void main(String[] args) {

    final String username = "contact.photographie.ts@gmail.com";
    final String password = "0767675004Tt";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("contact.photographie.ts@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("amritaoufik1997@gmail.com"));
        message.setSubject("Testing Subject");
        message.setText("PFA");

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        String file = "C:\\Users\\taouf\\Documents\\Contrat_photo_Edit.pdf";
        String fileName = "attachmentName";
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}
//String attachmentFilePath = "C:\\Users\\taouf\\Documents\\Contrat_photo_Edit.pdf"; // Replace with the actual path to your attachment file
//
//sendEmailWithAttachment(to, subject, body, attachmentFilePath);
//}
//
//public static void sendEmailWithAttachment(String to, String subject, String body, String attachmentFilePath) {
//// Set the email properties
//Properties properties = new Properties();
//properties.put("mail.smtp.host", "smtp.gmail.com"); // Replace with your SMTP server host
//properties.put("mail.smtp.port", "587"); // Replace with your SMTP server port
//properties.put("mail.smtp.auth", "true");
//
//// Create a Session object with authentication
//Session session = Session.getInstance(properties, new Authenticator() {
//    @Override
//    protected PasswordAuthentication getPasswordAuthentication() {
//        return new PasswordAuthentication("amritaoufik1997@gmail.com", "0618103620Tt");