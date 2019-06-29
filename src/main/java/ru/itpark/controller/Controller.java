package ru.itpark.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itpark.domain.Pilot;
import ru.itpark.service.PilotsService;

@org.springframework.stereotype.Controller
@RequestMapping ("/")
@RequiredArgsConstructor
public class Controller {
private final PilotsService service;

@GetMapping
    public String addAll(Model model) {
    model.addAttribute("title", "Pilot List");
    model.addAttribute("pilotes", service.findAll());
    return "pilotes";
}

    @GetMapping("/details") // http://localhost:8080/add
    public String addPage() {
        return "details";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("pilot", service.findById(id));
        return "details";
    }

}
