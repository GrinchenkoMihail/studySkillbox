package TableObjects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListId id;

    private int price;

    @Column(name="subscription_date")
    private Date subscriprionDate;

    public LinkedPurchaseListId getId() {
        return id;
    }

    public void setId(LinkedPurchaseListId id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriprionDate() {
        return subscriprionDate;
    }

    public void setSubscriprionDate(Date subscriptionDate) {
        this.subscriprionDate = subscriptionDate;
    }
}
