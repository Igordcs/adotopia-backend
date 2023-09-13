package br.edu.ufape.poo.adotopia.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Endereco;
import br.edu.ufape.poo.adotopia.negocio.basica.Especie;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class CadastroAnimalTest {

    @Autowired
    private CadastroAnimal controlador;

    @MockBean
    private Fachada fachada; 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarAnimal_UsuarioNaoEncontrado() throws UsuarioNaoEncontradoException {
       
        doThrow(new UsuarioNaoEncontradoException("email@exemplo.com")).when(fachada).salvarAnimal(any(), anyLong());
        
        Endereco endereco = new Endereco("Rua Principal", "123", "Bairro Central", "12345-678", "Cidade Exemplo", "UF");
        Usuario usuario = new Usuario();
        usuario.setNome("João da Silva");
        usuario.setTelefone("123456789");
        usuario.setEmail("joao.silva@example.com");
        usuario.setEndereco(endereco);
        usuario.setDescricao("Descrição do usuário");

        Animal animal = new Animal("Joaquin", "correria", usuario, Arrays.asList("vdd"), Arrays.asList("aaaa"), Especie.CACHORRO, false, false, false, "PITBULL", "medio", "vdd", (float) 3.5);


        Exception exception = assertThrows(UsuarioNaoEncontradoException.class, () -> {
            controlador.salvarAnimal(animal,8489l);
        });

        assertEquals("Usuario nao foi encontrado", exception.getMessage());
    }
}
