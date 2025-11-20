package fish.payara.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import fish.payara.domain.Bidder;
import fish.payara.service.BidderService;

@FacesConverter(value = "bidderConverter", managed = true)
public class BidderConverter implements Converter<Bidder> {

    @Inject
    private BidderService bidderService;

    @Override
    public Bidder getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return bidderService.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Bidder bidder) {
        if (bidder == null || bidder.getBidderId() == null) {
            return "";
        }
        return bidder.getBidderId().toString();
    }
}