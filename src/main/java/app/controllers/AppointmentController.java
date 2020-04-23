package app.controllers;

import app.entities.AppointmentsEntity;
import app.entities.ClientsEntity;
import app.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

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
        model.addAttribute("appointment", appointment);
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

    @PostMapping("/appointments/UpdateAppointment/update/{id}")
    public String updateAppointment(@PathVariable int id,
                                    @ModelAttribute("appointment") AppointmentsEntity appointment) {
        appointmentService.updateAppointmentById(id, appointment);
        return "redirect:/appointments/";
    }
}
