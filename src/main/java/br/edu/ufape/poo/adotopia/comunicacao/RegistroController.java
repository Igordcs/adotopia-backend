package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private Fachada fachada;

    @GetMapping()
    public List<Registro> listarRegistros(){
        return fachada.listarRegistros();
    }

    @PostMapping("/salvar")
    public Registro salvarRegistro(@RequestBody Registro registro) throws UsuarioNaoEncontradoException{
        return fachada.salvarRegistro(registro);
    }

    @GetMapping("/{id}")
    public List<Registro> listarAnimaisPorDono(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        return fachada.listarRegistrosporadotante(id);
    }

    
}
