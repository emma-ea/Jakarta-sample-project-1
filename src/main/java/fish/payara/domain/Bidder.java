package fish.payara.domain;

import jakarta.persistence.*;
import java.util.Objects;

import java.util.List;
import jakarta.json.bind.annotation.JsonbTransient;

@NamedQueries({
    @NamedQuery(name = "Bidder.findByBidderId", query = "SELECT e FROM Bidder e WHERE e.bidderId = :bidderId"),
    @NamedQuery(name = "Bidder.findByName", query = "SELECT e FROM Bidder e WHERE e.name = :name"),
    @NamedQuery(name = "Bidder.findByEmail", query = "SELECT e FROM Bidder e WHERE e.email = :email"),
    @NamedQuery(name = "Bidder.findByPhone", query = "SELECT e FROM Bidder e WHERE e.phone = :phone")
})
@Entity
public class Bidder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bidderId;

    private String name;

    private String email;

    private String phone;

    @JsonbTransient
    @OneToMany(mappedBy = "bidder")
    private List<Bid> bids;


    // Getters and setters

    public Integer getBidderId() {
        return bidderId;
    }

    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.bidderId);
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
        final Bidder other = (Bidder) obj;
        return Objects.equals(this.bidderId, other.bidderId);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

}
