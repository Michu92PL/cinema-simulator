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

    @OneToMany(mappedBy = "cinema",cascade = CascadeType.ALL)
    private List<Screening> screenings;

    public Cinema() {
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

    public String getAdress() {
        return adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public Long getId() {
        return id;
    }

    public Double getExpectedIncome(){
        if(!screenings.isEmpty()) {
            return screenings.stream().mapToDouble(Screening::getExpectedIncome).reduce(0.0, Double::sum);
        } else
            return 0.0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
