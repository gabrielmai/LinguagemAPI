package Alura.Linguagens.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemControle {
    

    //private List<Linguagem> linguagens =
    //List.of(
    //    new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 3),
    //    new Linguagem("Python", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/python/python_256x256.png?raw=true", 2),
    //    new Linguagem("JavaScript", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/javascript/javascript_256x256.png?raw=true", 1)
    //    );


    @Autowired
    private LinguagemRepository repositorio;


    //@GetMapping(value = "/linguagem-preferida")
    //public String processaLinguagemPreferida() {
    //    return "Oi, Java!";
    //}

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    } 

}