package fish.payara.service;

import jakarta.enterprise.context.Dependent;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import fish.payara.domain.Item;

@Dependent

public class ItemService extends AbstractService<Item, Integer> {

    public ItemService() {
        super(Item.class);
    }
    
}
