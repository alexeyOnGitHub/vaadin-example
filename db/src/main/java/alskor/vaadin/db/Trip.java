package alskor.vaadin.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRIP")
public class Trip {
    private Long id;
    private String status;
    private String startLocation;
    private String finishLocation;
    private float price;

    public Trip() {
        startLocation = "";
        finishLocation = "";
        status = "";
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String from) {
        this.startLocation = from;
    }

    public String getFinishLocation() {
        return finishLocation;
    }

    public void setFinishLocation(String to) {
        this.finishLocation = to;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", startLocation='" + startLocation + '\'' +
                ", finishLocation='" + finishLocation + '\'' +
                ", price=" + price +
                '}';
    }
}
