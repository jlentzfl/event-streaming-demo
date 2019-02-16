package dg.demo.cloudstream.orderprocessing;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EmailProcessor {
    String ORDER_CUSTOMERS_TO_EMAIL = "orderCustomersToEmail";
    String EMAILS_SENT = "emailsSent";

    @Input(ORDER_CUSTOMERS_TO_EMAIL)
    SubscribableChannel orderCustomersToEmail();

    @Output(EMAILS_SENT)
    MessageChannel emailsSent();
}
