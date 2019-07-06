package ru.itpark.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/searchresult") // http://localhost:8080/add
    public String searchingPage(@RequestParam String search, Model model) {
        model.addAttribute("pilotes", service.searchByName(search));
        model.addAttribute("search", search);
        return "searchresult";
    }


//    @GetMapping("/team") // http://localhost:8080/add
//    public String addTeamPage() {
//        return "team";
//    }

    @GetMapping("/{id }/teamMS")
    public String teamMS(Model model) {
        //var team = teamService.findByPilotesId(id);
        // model.addAttribute("pilot", service.findById(id));
        model.addAttribute("teamMS", teamService.findMSTeam());
//TODO реализовать вывод списка команды на страницу team
        return "teamMS";

    }

    @GetMapping("/teamYM")
    public String teamYM(Model model) {
        model.addAttribute("teamYM", teamService.findYMTeam());
        return "teamYM";
    }

    @GetMapping("/teamPL")
    public String teamPL(Model model) {
        model.addAttribute("teamPL", teamService.findPLTeam());
        return "teamPL";
    }
    @GetMapping("/teamNI")
    public String teamNI(Model model) {
        model.addAttribute("teamNI", teamService.findNITeam());
        return "teamNI";
    }
//    @GetMapping("/teamdetails") // http://localhost:8080/add
//    public String addTeamDetails() {
//        return "teamdetails";
//    }

//    @GetMapping("/{id}")
//    public String teamdetails(Model model) {
//        model.addAttribute("member", service.findMemberById(id));
//        return "teamdetails";
//    }


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

