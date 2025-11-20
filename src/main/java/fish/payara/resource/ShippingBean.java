package fish.payara.resource;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import fish.payara.domain.Shipping;
import fish.payara.service.ShippingService;

@Named("shippingBean")
@ViewScoped
public class ShippingBean implements Serializable {

    @Inject
    private transient ShippingService shippingService;

    private Shipping shipping = new Shipping();

    public Shipping getShipping() {
        return shipping;
    }

    public List<Shipping> getAllShippings() {
        return shippingService.findAll();
    }

    public String create() {
      
        return null;
    }
    public String save() {
        if (shipping.getShippingId() == null) {
             shippingService.create(shipping);
        } else {
             shippingService.edit(shipping);
        }
        shipping = new Shipping(); // reset
        return null;
    }

    public String remove(Integer shippingId) {
        shippingService.remove(shippingService.find(shippingId));
        return null;
    }

    public String edit(Shipping p) {
        this.shipping = p;
        return null;
    }

}