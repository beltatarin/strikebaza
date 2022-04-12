package strikebaza.strikebaza.service;



import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.MimeMessage;

import strikebaza.strikebaza.entity.Event;
import strikebaza.strikebaza.entity.User;
import strikebaza.strikebaza.form.EmailForm;

public class SimpleEmailManager {

    final String from ="beltatarinpol@gmail.com";
    	    final  String password ="121P_u121";

    	    public void sendEmail(EmailForm emailForm) {
    	    	Properties props = new Properties();

    	        props.put("mail.smtp.host", "smtp.gmail.com");
    	        props.put("mail.from", from);
    	        props.put("mail.smtp.starttls.enable", "true");
    	        props.put("mail.smtp.port", "587");
    	        props.setProperty("mail.debug", "true");

    	        Session session = Session.getInstance(props, null);
    	        MimeMessage msg = new MimeMessage(session);

    	        try {
					msg.setRecipients(Message.RecipientType.TO, emailForm.getEmail());
				
    	        msg.setSubject(emailForm.getLogin());
    	        msg.setSentDate(new Date());
    	        msg.setText("Ваше соообщение "+emailForm.getText()+" доставлено");

    	        Transport transport = session.getTransport("smtp");

    	        transport.connect(from, password);
    	        transport.sendMessage(msg, msg.getAllRecipients());
    	        transport.close();
    	        } catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }
    	    public void sendEmail(User user, Event event) {
    	    	Properties props = new Properties();

    	        props.put("mail.smtp.host", "smtp.gmail.com");
    	        props.put("mail.from", from);
    	        props.put("mail.smtp.starttls.enable", "true");
    	        props.put("mail.smtp.port", "587");
    	        props.setProperty("mail.debug", "true");

    	        Session session = Session.getInstance(props, null);
    	        MimeMessage msg = new MimeMessage(session);

    	        try {
					msg.setRecipients(Message.RecipientType.TO, user.getEmail());
				
    	        msg.setSubject(user.getLogin());
    	        msg.setSentDate(new Date());
    	        msg.setText("Создано новое мероприятие "+event.getEventName()+" "+event.getEventDate()+" "+event.getEventLocation()+" ");

    	        Transport transport = session.getTransport("smtp");

    	        transport.connect(from, password);
    	        transport.sendMessage(msg, msg.getAllRecipients());
    	        transport.close();
    	        } catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }
}
