package fish.payara.resource;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import fish.payara.domain.Auction;
import fish.payara.service.AuctionService;

@Named("auctionBean")
@ViewScoped
public class AuctionBean implements Serializable {

    @Inject
    private transient AuctionService auctionService;

    private Auction auction = new Auction();

    public Auction getAuction() {
        return auction;
    }

    public List<Auction> getAllAuctions() {
        return auctionService.findAll();
    }

    public String create() {
      
        return null;
    }
    public String save() {
        if (auction.getAuctionId() == null) {
             auctionService.create(auction);
        } else {
             auctionService.edit(auction);
        }
        auction = new Auction(); // reset
        return null;
    }

    public String remove(Integer auctionId) {
        auctionService.remove(auctionService.find(auctionId));
        return null;
    }

    public String edit(Auction p) {
        this.auction = p;
        return null;
    }

}