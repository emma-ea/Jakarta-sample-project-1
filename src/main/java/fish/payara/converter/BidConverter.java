package fish.payara.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import fish.payara.domain.Bid;
import fish.payara.service.BidService;

@FacesConverter(value = "bidConverter", managed = true)
public class BidConverter implements Converter<Bid> {

    @Inject
    private BidService bidService;

    @Override
    public Bid getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return bidService.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Bid bid) {
        if (bid == null || bid.getBidId() == null) {
            return "";
        }
        return bid.getBidId().toString();
    }
}