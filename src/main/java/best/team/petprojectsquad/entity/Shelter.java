package best.team.petprojectsquad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Shelter {

    @Id
    private String number;
    private String name;
    private String address;
    private String telephoneNumber;
    private String workSchedule;
    private ShelterType shelterType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public ShelterType getShelterType() {
        return shelterType;
    }

    public void setShelterType(ShelterType shelterType) {
        this.shelterType = shelterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return Objects.equals(number, shelter.number) && Objects.equals(name, shelter.name)
                && Objects.equals(address, shelter.address) && Objects.equals(telephoneNumber, shelter.telephoneNumber)
                && Objects.equals(workSchedule, shelter.workSchedule) && shelterType == shelter.shelterType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, address, telephoneNumber, workSchedule, shelterType);
    }
}
