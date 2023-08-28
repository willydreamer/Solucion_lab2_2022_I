package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/distribuidoras")
public class DistributorsController {
    final DistributorsRepository distributorsRepository;

    public DistributorsController(DistributorsRepository distributorsRepository) {
        this.distributorsRepository = distributorsRepository;
    }
    @GetMapping(value = {"", "/listar"})
    public String listaDistribuidoras (Model model){
        model.addAttribute("lista", distributorsRepository.findAll());
        return "distribuidoras/lista";
    };

    @GetMapping("/editar")
    public String editarDistribuidoras(@RequestParam("id") int id,Model model){
        System.out.println(id);
        Optional<Distributors> optional =distributorsRepository.findById(id);
        if(optional.isPresent()){
            Distributors distributors = optional.get();
            model.addAttribute("distributor",distributors);
            return "distribuidoras/editar";
        }else{
            return "redirect:/distribuidoras/listar";
        }
    };

    @GetMapping(value="/nuevo")
    public String nuevaDistribuidora(){ return "distribuidoras/nuevo";};

    @PostMapping("/guardar")
    public String guardarDistribuidora(Distributors distributors){
        distributors.setDescripcion("Nuevo");
        distributorsRepository.save(distributors);
        return "redirect:/distribuidoras/listar";
    };

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("id") int id){
        Optional<Distributors> optional = distributorsRepository.findById(id);

        if (optional.isPresent()) {
            distributorsRepository.deleteById(id);
        }
        return "redirect:/distribuidoras/listar";
    };

}
