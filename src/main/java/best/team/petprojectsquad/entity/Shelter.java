package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
@Table(name = "shelter")
@Data
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private String number;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "work_schedule")
    private String workSchedule;
    @Column(name = "shelter_type")
    private ShelterType shelterType;

    public Shelter(String number, String name, String address, String telephoneNumber, String workSchedule, ShelterType shelterType) {
        this.number = number;
        this.name = name;
        this.address = address;
        if (telephoneNumber.length() == 12 || telephoneNumber.length() == 13) {
            this.telephoneNumber = telephoneNumber;
        } else {
            throw new IllegalArgumentException("Telephone number has been entered incorrectly");
        }
        this.workSchedule = workSchedule;
        this.shelterType = shelterType;
    }

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
