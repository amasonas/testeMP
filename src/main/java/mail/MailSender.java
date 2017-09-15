package mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MailSender {

	private static String senderMail     = "mail4position@gmail.com";
	private static String password       = "vaga@123";
	
	public  void sendMail(String subject, String target, String content) {
        Properties mailEngineProperties = getConnectionProperties();
        Session session = getMailProviderSession(mailEngineProperties);
        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(senderMail)); 
              Address[] toUser = InternetAddress
                         .parse(target);  
              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject(subject);
              message.setText(content);
              Transport.send(message);
         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
  }
	
	private Session getMailProviderSession(Properties mailEngineProperties ) {
		return Session.getDefaultInstance(mailEngineProperties,
                new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() 
                     {
                           return new PasswordAuthentication(senderMail, password);
                     }
                });
	}
	private Properties getConnectionProperties() {
		Properties connectionProperties = new Properties();
        connectionProperties.put("mail.smtp.host", "smtp.gmail.com");
        connectionProperties.put("mail.smtp.socketFactory.port", "465");
        connectionProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        connectionProperties.put("mail.smtp.auth", "true");
        connectionProperties.put("mail.smtp.port", "465");
        return connectionProperties;
	}
}
