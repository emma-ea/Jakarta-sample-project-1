package fish.payara.service;

import jakarta.enterprise.context.Dependent;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import fish.payara.domain.Auction;

@Dependent

public class AuctionService extends AbstractService<Auction, Integer> {

    public AuctionService() {
        super(Auction.class);
    }
    
}
