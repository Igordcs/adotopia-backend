package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private Fachada fachada;

    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return new ResponseEntity<List<Usuario>>(fachada.listarUsuarios(), HttpStatus.OK);
    }
        
    @PostMapping()
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario) throws UsuarioJaCadastradoException {
        try {
            return new ResponseEntity<Usuario>(fachada.salvarUsuario(usuario), HttpStatus.CREATED);
        }catch(UsuarioJaCadastradoException e) {
            Map<String, String> response = new HashMap<>();
            response.put("erro", "Usuário já cadastrado.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @GetMapping("/entrar")
    public ResponseEntity<?> encontraUsuario(@RequestParam("email") String email) throws UsuarioNaoEncontradoException {
        try {
            return new ResponseEntity<Usuario>(fachada.encontraUsuario(email), HttpStatus.OK);
        }catch(UsuarioNaoEncontradoException e) {
            Map<String, String> response = new HashMap<>();
            response.put("erro", "Usuário não encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        
    }

    @PutMapping()
    public ResponseEntity<?> alterarUsuario(@RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
        try {
            return new ResponseEntity<Usuario>(fachada.alterarUsuario(usuario), HttpStatus.OK);
        }catch(UsuarioNaoEncontradoException e) {
            Map<String, String> response = new HashMap<>();
            response.put("erro", "Usuário não encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
      
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        try {
            return new ResponseEntity<Usuario>(fachada.deletarUsuario(id), HttpStatus.OK);
        }catch(UsuarioNaoEncontradoException e) {
            Map<String, String> response = new HashMap<>();
            response.put("erro", "Usuário não encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
      

        
    }
    
    @PostMapping("/adotar/{usuarioId}/{animalId}")
    public Registro adotarAnimal(@PathVariable Long usuarioId, @PathVariable Long animalId){
        return fachada.adotarAnimal(usuarioId, animalId);
    }
}
