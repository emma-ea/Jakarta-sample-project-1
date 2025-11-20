package fish.payara.domain;

import jakarta.persistence.*;
import java.util.Objects;

import java.util.List;
import java.time.LocalDate;
import jakarta.json.bind.annotation.JsonbTransient;

@NamedQueries({
    @NamedQuery(name = "Shipping.findByShippingId", query = "SELECT e FROM Shipping e WHERE e.shippingId = :shippingId"),
    @NamedQuery(name = "Shipping.findByDeliveryDate", query = "SELECT e FROM Shipping e WHERE e.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Shipping.findByTrackingNumber", query = "SELECT e FROM Shipping e WHERE e.trackingNumber = :trackingNumber")
})
@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shippingId;

    private LocalDate deliveryDate;

    private String trackingNumber;

    @JsonbTransient
    @OneToMany(mappedBy = "shipping")
    private List<Item> items;


    // Getters and setters

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.shippingId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Shipping other = (Shipping) obj;
        return Objects.equals(this.shippingId, other.shippingId);
    }

    @Override
    public String toString() {
        return String.valueOf(shippingId);
    }

}
