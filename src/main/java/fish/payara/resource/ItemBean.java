package fish.payara.resource;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import fish.payara.domain.Item;
import fish.payara.service.ItemService;

@Named("itemBean")
@ViewScoped
public class ItemBean implements Serializable {

    @Inject
    private transient ItemService itemService;

    private Item item = new Item();

    public Item getItem() {
        return item;
    }

    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    public String create() {
      
        return null;
    }
    public String save() {
        if (item.getItemId() == null) {
             itemService.create(item);
        } else {
             itemService.edit(item);
        }
        item = new Item(); // reset
        return null;
    }

    public String remove(Integer itemId) {
        itemService.remove(itemService.find(itemId));
        return null;
    }

    public String edit(Item p) {
        this.item = p;
        return null;
    }

}