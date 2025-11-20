package fish.payara.domain;

import jakarta.persistence.*;
import java.util.Objects;


@NamedQueries({
    @NamedQuery(name = "Item.findByItemId", query = "SELECT e FROM Item e WHERE e.itemId = :itemId"),
    @NamedQuery(name = "Item.findByName", query = "SELECT e FROM Item e WHERE e.name = :name"),
    @NamedQuery(name = "Item.findByDescription", query = "SELECT e FROM Item e WHERE e.description = :description"),
    @NamedQuery(name = "Item.findByStartingPrice", query = "SELECT e FROM Item e WHERE e.startingPrice = :startingPrice"),
    @NamedQuery(name = "Item.findByCategory", query = "SELECT e FROM Item e WHERE e.category = :category")
})
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    private String name;

    private String description;

    private Float startingPrice;

    private String category;

    @ManyToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;


    // Getters and setters

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Float startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.itemId);
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
        final Item other = (Item) obj;
        return Objects.equals(this.itemId, other.itemId);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

}
