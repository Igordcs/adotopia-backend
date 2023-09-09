package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.AnimalNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private Fachada fachada;

    @GetMapping("/listar")
    public List<Animal> listarAnimais(){
        return fachada.listarAnimais();
    }

    @GetMapping("/listar/{id}")
    public List<Animal> listarAnimaisPorDono(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        return fachada.listarAnimaisPorDono(id);
    }

    @PostMapping("/adicionar/{id}")
    public Animal salvarAnimal(@RequestBody Animal animal, @PathVariable Long id) throws UsuarioNaoEncontradoException{
        return fachada.salvarAnimal(animal, id);
    }

     @GetMapping("/{id}")
    public Animal encontraAnimal(@PathVariable Long id) throws AnimalNaoEncontradoException{
        return fachada.encontraAnimal(id);
    }

    @PutMapping("/alterar/{id}")
    public Animal alterarAnimal(@RequestBody Animal animal, @PathVariable Long id) throws AnimalNaoEncontradoException, UsuarioNaoEncontradoException {
        return fachada.alterarAnimal(animal, id);
    }

    @DeleteMapping("/{id}")
    public Animal deletarAnimal(@PathVariable Long id) throws AnimalNaoEncontradoException {
        return fachada.deletarAnimal(id);
    
}

}
