package app.controllers;

import app.entities.AppointmentsEntity;
import app.entities.ClientsEntity;
import app.services.AppointmentService;
import app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ClientService  clientService;
    @GetMapping(value = "/appointments")
    public String findAll(Model model) {
        List<AppointmentsEntity> appointment = appointmentService.getAllAppointments();
        model.addAttribute("appointment", appointment);
        return "appointments-page";
    }

    @RequestMapping(value = "/appointments/CreateAppointment")
    public String createAppointment(Model model) {
        AppointmentsEntity appointment = new AppointmentsEntity();
        model.addAttribute("appointment", appointment);
        return "create-appointment";
    }

    @RequestMapping(value = "/appointments/UpdateAppointment/{id}")
    public String updateAppointmentPage(@PathVariable int id, Model model) {
        AppointmentsEntity appointment = appointmentService.getAppointmentById(id).orElse(null);
        assert appointment != null;
        ClientsEntity client = clientService.getClientById(appointment.getIdFromClient()).orElse(null);
                model.addAttribute("appointment", appointment);
                model.addAttribute("client", client);
        System.out.print(client.getId());
        return "update-appointment";
    }

    @RequestMapping(value = "/appointments/AddAppointment")
    public String addAppointment(@ModelAttribute("appointment") AppointmentsEntity appointments) {
        appointmentService.saveAppointment(appointments);
        return "redirect:/appointments/";
    }

    @RequestMapping(value = "/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments/";
    }

    @PostMapping("/appointments/UpdateAppointment/update/{appointmentId}")
    public String updateAppointment(@PathVariable int appointmentId,
                                    @ModelAttribute("appointment") AppointmentsEntity appointment) {
        appointmentService.updateAppointmentById(appointmentId, appointment);
        return "redirect:/appointments/";
    }
}
