package app.services;

import app.entities.AppointmentsEntity;
import app.repos.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    public AppointmentRepository appointmentRepository;

    public List<AppointmentsEntity> getAllAppointments() {

        List<AppointmentsEntity> appointment = new ArrayList<AppointmentsEntity>();
        appointmentRepository.findAll().forEach(appointment::add);
        return appointment;
    }

    public Optional<AppointmentsEntity> getAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }

    public void updateAppointmentById(int id, AppointmentsEntity appointment) { appointmentRepository.save(appointment);}

    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }

    public void saveAppointment(AppointmentsEntity appointment) {
        appointmentRepository.save(appointment);
    }
}
