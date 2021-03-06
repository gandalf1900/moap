package no.frodo.moap.domain;
import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {

    @Id
    @SequenceGenerator(name="city_seq", sequenceName="city_seq", allocationSize=1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="city_seq")
    @Column(name = "id", updatable=false)
    private Long id;

    @Column(unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
