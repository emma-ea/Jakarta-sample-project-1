package fish.payara.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import fish.payara.domain.Shipping;
import fish.payara.service.ShippingService;

@FacesConverter(value = "shippingConverter", managed = true)
public class ShippingConverter implements Converter<Shipping> {

    @Inject
    private ShippingService shippingService;

    @Override
    public Shipping getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return shippingService.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Shipping shipping) {
        if (shipping == null || shipping.getShippingId() == null) {
            return "";
        }
        return shipping.getShippingId().toString();
    }
}