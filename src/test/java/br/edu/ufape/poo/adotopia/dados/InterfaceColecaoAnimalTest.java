package br.edu.ufape.poo.adotopia.dados;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ufape.poo.adotopia.comunicacao.AnimalController;
import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Endereco;
import br.edu.ufape.poo.adotopia.negocio.basica.Especie;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;


@SpringBootTest
public class InterfaceColecaoAnimalTest {
    Long id;  
    @Test
    public void testSalvarAnimal() throws UsuarioNaoEncontradoException {
        Fachada fachada = mock(Fachada.class);

        Endereco endereco = new Endereco("Rua Principal", "123", "Bairro Central", "12345-678", "Cidade Exemplo", "UF");
        Usuario usuario = new Usuario();
        usuario.setNome("João da Silva");
        usuario.setTelefone("123456789");
        usuario.setEmail("joao.silva@example.com");
        usuario.setEndereco(endereco);
        usuario.setDescricao("Descrição do usuário");

        Animal animal = new Animal("Joaquin", "correria", usuario, Arrays.asList("vdd"), Arrays.asList("aaaa"), Especie.CACHORRO, false, false, false, "PITBULL", "medio", "vdd", (float) 3.5);
        

        when(fachada.salvarAnimal(animal, id)).thenReturn(animal);

        AnimalController controlador = new AnimalController(fachada);

        ResponseEntity<?> response = controlador.salvarAnimal(animal, id);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
