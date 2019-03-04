package pl.michu.cinemasimulator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String adress;
    private String telephone;

    @OneToMany(mappedBy = "cinema",cascade = CascadeType.PERSIST)
    private List<Screening> screenings;

    private Cinema() {
    }

    public Cinema(String name, String adress, String telephone) {
        this.name = name;
        this.adress = adress;
        this.telephone = telephone;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(Screening screening){
        screenings.add(screening);
    }

    public String getName() {
        return name;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }
}
