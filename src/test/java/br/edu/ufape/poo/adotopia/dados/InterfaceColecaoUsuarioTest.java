package br.edu.ufape.poo.adotopia.dados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.basica.Endereco;


@SpringBootTest
class InterfaceColecaoUsuarioTest {
	@Autowired
	private InterfaceColecaoUsuario colecaoUsuario;

	@Test
	void cadastrarTest() {
		//Inicialização
		long qtdUsuario = colecaoUsuario.count();
        Endereco e = new Endereco("rua a", "centro", "verdade", "15", "pe", "5282092");
		Usuario u = new Usuario("Igor","12345678", "igor@gmail.com", e, "muito legal");
	
		u.setEndereco(e);
		
		//Interação
		colecaoUsuario.save(u);
		long qtdUsuario2 = colecaoUsuario.count();
		
		//Verificação
		assertEquals(qtdUsuario + 1, qtdUsuario2);
	}
}