package fish.payara.domain;

import jakarta.persistence.*;
import java.util.Objects;

import java.time.LocalDate;

@NamedQueries({
    @NamedQuery(name = "Bid.findByBidId", query = "SELECT e FROM Bid e WHERE e.bidId = :bidId"),
    @NamedQuery(name = "Bid.findByAmount", query = "SELECT e FROM Bid e WHERE e.amount = :amount"),
    @NamedQuery(name = "Bid.findByBidTime", query = "SELECT e FROM Bid e WHERE e.bidTime = :bidTime")
})
@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bidId;

    private Float amount;

    private LocalDate bidTime;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "bidder_id")
    private Bidder bidder;


    // Getters and setters

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDate getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDate bidTime) {
        this.bidTime = bidTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.bidId);
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
        final Bid other = (Bid) obj;
        return Objects.equals(this.bidId, other.bidId);
    }

    @Override
    public String toString() {
        return String.valueOf(bidId);
    }

}
