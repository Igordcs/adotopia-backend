package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoRegistro;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

@Service
public class CadastroRegistro implements InterfaceCadastroRegistro{

    @Autowired
    private InterfaceColecaoRegistro colecaoRegistro;
    @Autowired 
    private CadastroUsuario cadastroUsuario;

    public List <Registro> listarRegistros(){
        return colecaoRegistro.findAll();
    }

   public Registro salvarRegistro(Registro entity) throws UsuarioNaoEncontradoException{
    Usuario usuario = cadastroUsuario.encontraUsuario(entity.getAdotanteId());
        if(usuario == null)
            throw new UsuarioNaoEncontradoException(entity.getAdotanteId());
        return colecaoRegistro.save(entity);
   }
    
   public List<Registro> listarRegistrosporadotante(Long adotanteId) throws UsuarioNaoEncontradoException{
        Usuario usuario = cadastroUsuario.encontraUsuario(adotanteId);
        if (usuario == null)
            throw new UsuarioNaoEncontradoException(adotanteId);
         return colecaoRegistro.findByAdotanteId(adotanteId);
}
}
