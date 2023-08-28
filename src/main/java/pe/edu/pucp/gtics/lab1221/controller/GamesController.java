package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;

import java.util.Optional;

@Controller
@RequestMapping("/juegos")
public class GamesController {
    final GamesRepository gamesRepository;

    public GamesController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }
    @GetMapping(value = {"", "/listar"})
    public String listaJuegos (Model model){
        model.addAttribute("lista", gamesRepository.findAll());
        return "juegos/lista";
    };

    @GetMapping("/editar")
    public String editarJuegos(@RequestParam("id") int id, Model model){
        System.out.println(id);
        Optional<Games> optional =gamesRepository.findById(id);
        if(optional.isPresent()){
            Games games = optional.get();
            model.addAttribute("game",games);
            return "juegos/editar";
        }else{
            return "redirect:/juegos/listar";
        }
    };


    @PostMapping("/guardar")
    public String guardarJuegos(Games games){
        gamesRepository.save(games);
        return "redirect:/juegos/listar";
    };

    @GetMapping("/borrar")
    public String borrarJuegos(@RequestParam("id") int id){
        Optional<Games> optional = gamesRepository.findById(id);

        if (optional.isPresent()) {
            gamesRepository.deleteById(id);
        }
        return "redirect:/juegos/listar";
    };
}
