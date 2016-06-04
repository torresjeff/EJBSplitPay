/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import DTO.MailMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.NamingException;

/**
 *
 * @author Sid
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queueCorreos"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MailMessageBean implements MessageListener {

    @Resource(name = "mail/splitPaySession")
    private Session mailsplitPaySession;
    
    public MailMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        MailMessage mailMessage = (MailMessage) message;
        try {
            sendMail(mailMessage.usuario.getEmail(), "Cierre de grupo - Final Debt Resolution", "Se cerrará el siguiente grupo: "
             + mailMessage.grupo.getName() + "\n\nPor favor dirijase a la paginad e SplitPay para pagar sus deudas");
        } catch (NamingException ex) {
            Logger.getLogger(MailMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendMail(String email, String subject, String body) throws NamingException, MessagingException {
        
            /*Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.user", "splitpays@gmail.com");
            props.put("mail.password", "splitpayarqui");
            props.put("mail.port", "587");//465
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");*/
            
            
            
            /*Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            //MimeMessage message = new MimeMessage(mailsplitPaySession);
            MimeMessage message = new MimeMessage(session);
            message.setSubject(subject);
            message.setFrom(new InternetAddress("splitpays@gmail.com", "Admin SplitPay"));
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(email, false));
            message.setText(body);
            Transport.send(message);*/
            
            /*MimeMessage message = new MimeMessage(mailsplitPaySession);
            message.setSubject(subject);
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(email, false));
            message.setText(body);
            Transport.send(message);*/
            
            
            
            
            
            /*MimeMessage msg = new MimeMessage(Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(
            "splitpays@gmail.com", "splitpayarqui");// Specify the Username and the PassWord
            }));*/
        
        
        final String username = "splitpays@gmail.com";
        final String password = "splitpayarqui";
        Properties props = new Properties();
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.EnableSSL.enable", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject(subject);
        message.setText(body);
        Multipart multipart = new MimeMultipart("related");
        BodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent("<html>HELLO</html>", "text/html");

        multipart.addBodyPart(htmlPart);
        message.setContent(multipart);
        Transport.send(message);
    } catch (Exception e) {

    }
        
         
    }
    
}
