package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private Fachada fachada;

   

    @GetMapping()
    public ResponseEntity<List<Registro>> listarRegistros(){
        return new ResponseEntity<List<Registro>>( fachada.listarRegistros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarRegistrosporadotante(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        try {
            return new ResponseEntity<List<Registro>>(fachada.listarRegistrosporadotante(id), HttpStatus.OK);
        }catch(UsuarioNaoEncontradoException e) {
            Map<String, String> response = new HashMap<>();
            response.put("erro", "Usuário não encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
       
    }

    
}
