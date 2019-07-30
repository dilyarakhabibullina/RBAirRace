package ru.itpark.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.domain.dto.PilotAdd;
import ru.itpark.repository.UserRepository;
import ru.itpark.service.PilotsService;
import ru.itpark.service.TeamService;


import java.sql.Date;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class Controller {
    private final PilotsService service;
    private final TeamService teamService;
    private final UserRepository userRepository;

    @GetMapping
    public String addAll(Model model) {
        model.addAttribute("title", "Pilot List");
        model.addAttribute("pilotes", service.findAll());
        model.addAttribute("user", userRepository.findAll());
        return "pilotes";
    }

    @GetMapping("/login")
    public String addloginPage() {
        return "login";
    }

    @GetMapping("/details")
    public String addPage() {
        return "details";
    }

    @GetMapping("/edit")
    public String addPilotesForEdit(Model model) {
        model.addAttribute("title", "Pilot List");
        model.addAttribute("pilotes", service.findAll());
        return "edit";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("pilot", service.findById(id));
        return "details";
    }
//    @GetMapping("/edit")
//    public String addEditPage() {
//        return "edit";
//    }
//@GetMapping("/editeach")
//public String editEach() {
//    return "editeach";
//}


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("pilot", service.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String savePilot(
            @PathVariable int id,
            @RequestParam String pilotname,
            @RequestParam Date birthdate,
            @RequestParam int experience,
            @RequestParam String aircraft
    ) {
        service.updateById(id, pilotname, birthdate, experience, aircraft);
        return "redirect:/";
    }

    @GetMapping("/searchresult")
    public String searchingPage(@RequestParam String search, Model model) {
        model.addAttribute("pilotes", service.searchByName(search));
        model.addAttribute("search", search);
        return "searchresult";
    }

    @PostMapping("/{id}/remove")
    public String removeById(@PathVariable int id) {
        service.removeById(id);
        return "redirect:/";
    }


    @GetMapping("/pilot-add")
    public String addPage(Model model) {
        model.addAttribute("title", "New pilot");
        return "pilot-add";
    }

    @PostMapping("/pilot-add")
    public String add(@ModelAttribute PilotAdd dto) { // NoteAddForm -> name, content
        // @ModelAttribute собирает объект Note из полей формы вместо того, чтобы для каждого параметра писать @RequestParam
        // @RequestParam String name;
        // @RequestParam String content;
        service.add(dto);
        return "redirect:/";
    }

//    @GetMapping("/team") // http://localhost:8080/add
//    public String addTeamPage() {
//        return "team";
//    }

    @GetMapping("/teamMS")
    public String teamMS(Model model) {
        //var team = teamService.findByPilotesId(id);
        // model.addAttribute("pilot", service.findById(id));
        model.addAttribute("teamMS", teamService.findMSTeam());

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

}

