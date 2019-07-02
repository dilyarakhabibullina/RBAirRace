package ru.itpark.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itpark.domain.Pilot;
import ru.itpark.service.PilotsService;
import ru.itpark.service.TeamService;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class Controller {
    private final PilotsService service;
    private final TeamService teamService;

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

//    @GetMapping("/team") // http://localhost:8080/add
//    public String addTeamPage() {
//        return "team";
//    }

    @GetMapping("/team/{id}")
    public String teamDetails(@PathVariable int id, Model model) {
        //var team = teamService.findByPilotesId(id);
        model.addAttribute("pilot", service.findById(id));
        model.addAttribute("team", teamService.findAll());
//TODO реализовать вывод списка команды на страницу team
        return "team";

    }
//        @GetMapping("/team/{id}")
//        public String addTeam ( @PathVariable int id, Model model){
//            model.addAttribute("title", "Team List");
//        model.addAttribute("team", teamService.findByPilotesId(int pilotes_id));
//            return "team";
//        }

//    @GetMapping("/team/{id}")
//    public String addTeam(Model model, @PathVariable int id) {
//        // var заменяется на тот тип, который возвращает service.findById
//        // для локальных переменных, инициализируемых сразу
//        // Note
//        var team = teamService.findByPilotesId(id);
//        model.addAttribute("team", team);
//        return "team";
//
//    }
}

