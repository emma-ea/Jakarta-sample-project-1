package fish.payara.service;

import jakarta.enterprise.context.Dependent;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import fish.payara.domain.Bid;

@Dependent

public class BidService extends AbstractService<Bid, Integer> {

    public BidService() {
        super(Bid.class);
    }
    
}
