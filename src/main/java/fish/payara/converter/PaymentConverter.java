package fish.payara.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import fish.payara.domain.Payment;
import fish.payara.service.PaymentService;

@FacesConverter(value = "paymentConverter", managed = true)
public class PaymentConverter implements Converter<Payment> {

    @Inject
    private PaymentService paymentService;

    @Override
    public Payment getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return paymentService.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Payment payment) {
        if (payment == null || payment.getPaymentId() == null) {
            return "";
        }
        return payment.getPaymentId().toString();
    }
}