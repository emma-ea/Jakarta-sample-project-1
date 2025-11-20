package fish.payara.resource;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import fish.payara.domain.Bidder;
import fish.payara.service.BidderService;

@Named("bidderBean")
@ViewScoped
public class BidderBean implements Serializable {

    @Inject
    private transient BidderService bidderService;

    private Bidder bidder = new Bidder();

    public Bidder getBidder() {
        return bidder;
    }

    public List<Bidder> getAllBidders() {
        return bidderService.findAll();
    }

    public String create() {
      
        return null;
    }
    public String save() {
        if (bidder.getBidderId() == null) {
             bidderService.create(bidder);
        } else {
             bidderService.edit(bidder);
        }
        bidder = new Bidder(); // reset
        return null;
    }

    public String remove(Integer bidderId) {
        bidderService.remove(bidderService.find(bidderId));
        return null;
    }

    public String edit(Bidder p) {
        this.bidder = p;
        return null;
    }

}