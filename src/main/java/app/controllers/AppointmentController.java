package app.controllers;

import app.entities.AppointmentsEntity;
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
        return "new-appointment";
    }

    @RequestMapping(value = "/appointments/addAppointment")
    public String addAppointment(@ModelAttribute("appointment") AppointmentsEntity appointments) {
        appointmentService.saveAppointment(appointments);
        return "redirect:/appointments/";
    }

    @RequestMapping(value = "/appointments/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
    }

    @PostMapping("/appointments/save/{id}")
    public String updateAppointment(@PathVariable int id,
                                    @ModelAttribute("appointment") AppointmentsEntity appointment) {
        appointmentService.updateAppointmentById(id, appointment);
        return "redirect:/appointments/";
    }
}
