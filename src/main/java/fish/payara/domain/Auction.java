package fish.payara.domain;

import jakarta.persistence.*;
import java.util.Objects;

import java.util.List;
import java.time.LocalDate;
import jakarta.json.bind.annotation.JsonbTransient;

@NamedQueries({
    @NamedQuery(name = "Auction.findByAuctionId", query = "SELECT e FROM Auction e WHERE e.auctionId = :auctionId"),
    @NamedQuery(name = "Auction.findByName", query = "SELECT e FROM Auction e WHERE e.name = :name"),
    @NamedQuery(name = "Auction.findByStartDate", query = "SELECT e FROM Auction e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Auction.findByEndDate", query = "SELECT e FROM Auction e WHERE e.endDate = :endDate"),
    @NamedQuery(name = "Auction.findByStatus", query = "SELECT e FROM Auction e WHERE e.status = :status")
})
@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer auctionId;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    @JsonbTransient
    @OneToMany(mappedBy = "auction")
    private List<Item> items;


    // Getters and setters

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash = 97 * hash + Objects.hashCode(this.auctionId);
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
        final Auction other = (Auction) obj;
        return Objects.equals(this.auctionId, other.auctionId);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

}
