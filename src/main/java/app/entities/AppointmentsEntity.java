package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "Buzzd_Appointments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "client_id")
public class AppointmentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int appointmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    public ClientsEntity clientId;

    @Column(name="appointment_date")
    private String date;

    @Column(name="appointment_time")
    private String time;

    @Column(name="appointment_service")
    private String service;

    @Column(name="appointment_status")
    private boolean status;

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public ClientsEntity getClientId() {
        return clientId;
    }

    public void setClientId(ClientsEntity clientId) {
        this.clientId = clientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AppointmentsEntity(){}

    public AppointmentsEntity(int appointmentId, ClientsEntity client_id, String date, String time, String service, boolean status) {
        this.appointmentId = appointmentId;
        this.clientId = clientId;
        this.date = date;
        this.time = time;
        this.service = service;
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppointmentsEntity{" +
                "appointmentId=" + appointmentId +
                ", clientId=" + clientId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", service='" + service + '\'' +
                ", status=" + status +
                '}';
    }
}
