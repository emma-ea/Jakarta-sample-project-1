package fish.payara.resource;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import fish.payara.domain.Bid;
import fish.payara.service.BidService;

@Named("bidBean")
@ViewScoped
public class BidBean implements Serializable {

    @Inject
    private transient BidService bidService;

    private Bid bid = new Bid();

    public Bid getBid() {
        return bid;
    }

    public List<Bid> getAllBids() {
        return bidService.findAll();
    }

    public String create() {
      
        return null;
    }
    public String save() {
        if (bid.getBidId() == null) {
             bidService.create(bid);
        } else {
             bidService.edit(bid);
        }
        bid = new Bid(); // reset
        return null;
    }

    public String remove(Integer bidId) {
        bidService.remove(bidService.find(bidId));
        return null;
    }

    public String edit(Bid p) {
        this.bid = p;
        return null;
    }

}