package com.luis.springboot.citas_medicas.medicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicosController {
    @Autowired
    private MedicosService service;

    @GetMapping("/medicos")
    public String showMedicosList(Model model){
        List<Medicos> listMedicos = service.listAll();
        model.addAttribute("listMedicos", listMedicos);

        return "medicos";
    }

    @GetMapping("/medicos/new")
    public String showNewForm(Model model){
        model.addAttribute("medico", new Medicos());
        model.addAttribute("pageTitle", "Añadir Medico");
        return "medicos_form";
    }

    @PostMapping ("/medicos/save")
    public String saveMedico(Medicos medico, RedirectAttributes ra){
        service.save(medico);
        ra.addFlashAttribute("message", "El usuario ha sido añadido correctamente");
        return "redirect:/medicos";
    }

    @GetMapping("/medicos/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Medicos medico = service.get(id);
            model.addAttribute("medico", medico);
            model.addAttribute("pageTitle", "Editar Medico (ID: " + id +")");
            return "medicos_form";
        } catch (MedicoNotFoundException e){
            ra.addFlashAttribute("message", "El usuario ha sido añadido correctamente");
            return "redirect:/medicos";
        }

    }
}
