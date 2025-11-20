package fish.payara.service;

import jakarta.enterprise.context.Dependent;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import fish.payara.domain.Shipping;

@Dependent

public class ShippingService extends AbstractService<Shipping, Integer> {

    public ShippingService() {
        super(Shipping.class);
    }
    
}
