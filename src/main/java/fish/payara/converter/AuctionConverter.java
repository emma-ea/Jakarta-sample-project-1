package fish.payara.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import fish.payara.domain.Auction;
import fish.payara.service.AuctionService;

@FacesConverter(value = "auctionConverter", managed = true)
public class AuctionConverter implements Converter<Auction> {

    @Inject
    private AuctionService auctionService;

    @Override
    public Auction getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return auctionService.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Auction auction) {
        if (auction == null || auction.getAuctionId() == null) {
            return "";
        }
        return auction.getAuctionId().toString();
    }
}