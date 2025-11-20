package fish.payara.service;

import jakarta.enterprise.context.Dependent;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import fish.payara.domain.Bidder;

@Dependent

public class BidderService extends AbstractService<Bidder, Integer> {

    public BidderService() {
        super(Bidder.class);
    }
    
}
