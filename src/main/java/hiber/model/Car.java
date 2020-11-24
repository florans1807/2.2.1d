package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serie_s")
    private int series;

    @Column(name = "mode_l")
    private String model;

    @OneToOne(optional = false, mappedBy = "car")
    private User owner;

    public Car() {}

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public Car(int series, String model, User owner) {
        this.series = series;
        this.model = model;
        this.owner = owner;
    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }
}
