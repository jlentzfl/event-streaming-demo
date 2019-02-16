package dg.demo.cloudstream.orderprocessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(EmailProcessor.class)
public class OrderEmailProcessor {

    @Autowired
    JavaMailSender emailSender;

    @StreamListener(EmailProcessor.ORDER_CUSTOMERS_TO_EMAIL)
    @SendTo(EmailProcessor.EMAILS_SENT)
    public EmailSent sendOrderEmail(OrderCustomerMessage orderCustomerMessage){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(orderCustomerMessage.getCustomerEmail());
        message.setSubject("Thank You!");
        message.setText("Dear " + orderCustomerMessage.getFirstName() + ", thank you for ordering with us!");
        emailSender.send(message);

        EmailSent emailSent = new EmailSent();
        emailSent.setEmail(orderCustomerMessage.getCustomerEmail());
        emailSent.setEmailType(EmailSent.EmailType.ORDER_RECEIVED_EMAIL);
        return emailSent;
    }
}
