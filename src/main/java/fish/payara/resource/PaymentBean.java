package fish.payara.resource;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import fish.payara.domain.Payment;
import fish.payara.service.PaymentService;

@Named("paymentBean")
@ViewScoped
public class PaymentBean implements Serializable {

    @Inject
    private transient PaymentService paymentService;

    private Payment payment = new Payment();

    public Payment getPayment() {
        return payment;
    }

    public List<Payment> getAllPayments() {
        return paymentService.findAll();
    }

    public String create() {
      
        return null;
    }
    public String save() {
        if (payment.getPaymentId() == null) {
             paymentService.create(payment);
        } else {
             paymentService.edit(payment);
        }
        payment = new Payment(); // reset
        return null;
    }

    public String remove(Integer paymentId) {
        paymentService.remove(paymentService.find(paymentId));
        return null;
    }

    public String edit(Payment p) {
        this.payment = p;
        return null;
    }

}