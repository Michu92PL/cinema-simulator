package pl.michu.cinemasimulator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 40, message = "Nazwa musi mieć między 2 a 40 znaków")
    private String name;
    @NotNull
    @Size(min = 5, max = 50, message = "Adres musi mieć między 5 a 50 znaków")
    private String adress;
    @NotNull
    @Size(min = 5, max = 12, message = "Nr telefonu musi mieć między 5 a 12 znaków")
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

    public String getExpectedIncome(){
        if(!screenings.isEmpty()) {
            Double income = screenings.stream().mapToDouble(Screening::getExpectedIncome).reduce(0.0, Double::sum);
            String roundOff = String.format("%.2f", income).replaceAll(",", ".");
            return roundOff;
        } else
            return "0.00";
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
