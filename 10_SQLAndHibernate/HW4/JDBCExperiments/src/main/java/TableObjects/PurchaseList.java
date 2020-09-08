package TableObjects;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private KeyForPurchaseList key;


    private int price;

    @Column(name="subscription_date")
    private Date subscriptionDate;



    public KeyForPurchaseList getKey() {
        return key;
    }

    public void setKey(KeyForPurchaseList key) {
        this.key = key;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
