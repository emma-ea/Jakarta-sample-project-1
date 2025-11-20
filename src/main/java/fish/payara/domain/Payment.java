package fish.payara.domain;

import jakarta.persistence.*;
import java.util.Objects;

import java.util.List;
import java.time.LocalDate;
import jakarta.json.bind.annotation.JsonbTransient;

@NamedQueries({
    @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT e FROM Payment e WHERE e.paymentId = :paymentId"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT e FROM Payment e WHERE e.amount = :amount"),
    @NamedQuery(name = "Payment.findByPaymentDate", query = "SELECT e FROM Payment e WHERE e.paymentDate = :paymentDate"),
    @NamedQuery(name = "Payment.findByMethod", query = "SELECT e FROM Payment e WHERE e.method = :method")
})
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;

    private Float amount;

    private LocalDate paymentDate;

    private String method;

    @JsonbTransient
    @OneToMany(mappedBy = "payment")
    private List<Bid> bids;


    // Getters and setters

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
        hash = 97 * hash + Objects.hashCode(this.paymentId);
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
        final Payment other = (Payment) obj;
        return Objects.equals(this.paymentId, other.paymentId);
    }

    @Override
    public String toString() {
        return String.valueOf(paymentId);
    }

}
