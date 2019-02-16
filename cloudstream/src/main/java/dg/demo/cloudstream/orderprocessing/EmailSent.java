package dg.demo.cloudstream.orderprocessing;

public class EmailSent {
    public enum EmailType { ORDER_RECEIVED_EMAIL }
    private String email;
    private EmailType emailType;

    public String getEmail() {
        return email;
    }

    public EmailSent setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public EmailSent setEmailType(EmailType emailType) {
        this.emailType = emailType;
        return this;
    }
}
