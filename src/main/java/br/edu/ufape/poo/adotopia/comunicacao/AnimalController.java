package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.AnimalNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private Fachada fachada;

    public AnimalController(Fachada fachada) {
        this.fachada = fachada;
    }


    @GetMapping("/listar")
    public List<Animal> listarAnimais(){
        return fachada.listarAnimais();
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarAnimaisPorDono(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        try {
         return new ResponseEntity<List<Animal>>(fachada.listarAnimaisPorDono(id), HttpStatus.OK);
         }catch(UsuarioNaoEncontradoException e) {
             Map<String, String> response = new HashMap<>();
             response.put("erro", "Usuário não encontrado.");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         }
     }
        

    @PostMapping("/adicionar/{id}")
    public ResponseEntity<?> salvarAnimal(@RequestBody Animal animal, @PathVariable Long id) throws UsuarioNaoEncontradoException{
        try {
         return new ResponseEntity<Animal>(fachada.salvarAnimal(animal, id), HttpStatus.CREATED);
         }catch(UsuarioNaoEncontradoException e) {
             Map<String, String> response = new HashMap<>();
             response.put("erro", "Usuário não encontrado.");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         }
        
        }

     @GetMapping("/{id}")
    public ResponseEntity<?> encontraAnimal(@PathVariable Long id) throws AnimalNaoEncontradoException{
        try {
         return new ResponseEntity<Animal>(fachada.encontraAnimal(id), HttpStatus.OK);
         }catch(AnimalNaoEncontradoException e) {
             Map<String, String> response = new HashMap<>();
             response.put("erro", "Animal não encontrado.");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         }
        
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarAnimal(@RequestBody Animal animal, @PathVariable Long id) throws AnimalNaoEncontradoException, UsuarioNaoEncontradoException {
        try {
        return new ResponseEntity<Animal>(fachada.alterarAnimal(animal, id), HttpStatus.OK);
    } catch (AnimalNaoEncontradoException e) {
        Map<String, String> response = new HashMap<>();
        response.put("erro", "Animal não Encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    } catch (NoSuchElementException e) {
        Map<String, String> response = new HashMap<>();
        response.put("erro", "Usuário não encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAnimal(@PathVariable Long id) throws AnimalNaoEncontradoException {
        try {
         return new ResponseEntity<Animal>(fachada.deletarAnimal(id), HttpStatus.OK);
         }catch(AnimalNaoEncontradoException e) {
             Map<String, String> response = new HashMap<>();
             response.put("erro", "Animal não encontrado.");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         }
       
    
}
}
