package app.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Buzzd_Clients")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "client_id")
public class ClientsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "client_first")
    private String firstName;

    @Column(name = "client_last")
    private String lastName;

    @Column(name = "client_phone")
    private String phone;

    @Column(name = "client_email")
    private String email;

    @OneToMany(
            mappedBy = "clientId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AppointmentsEntity> appointment = new ArrayList<>();

    public int getId() {
        return clientId;
    }

    public void setId(int id) {
        this.clientId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public ClientsEntity(){}

    public ClientsEntity(int id, String firstName, String lastName, String phone, String email) {
        this.clientId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName;

    }
}
