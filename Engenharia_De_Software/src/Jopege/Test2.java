package Jopege2;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class Test2 extends TestCase {

	@Test
	public void test() {
			Menu menu = new Menu();
			menu.cadastrar("Marcos", 6);
			menu.criarCarta(1);
			menu.jogadas(1, 0);
			
			assertEquals(1, 1);
			assertEquals(menu.getVidaInimigo(), 920.0, 0);
			assertEquals(menu.getVida(), 1000, 0);
			menu.jogadas(6, 0);
			assertEquals(menu.getVida(), (1000 + (40 * 1.2)), 0);
			assertEquals(menu.getUser().get(0).getNome(),"Marcos");
			menu.jogadas(4, 0);
			assertEquals(menu.getVidaInimigo(), 900.0, 0);
			menu.jogadas(5, 0);
			assertEquals(menu.getVidaInimigo(), 810.0, 0);
			menu.criarCarta(3);
			menu.jogadas(5, 0);
			assertEquals(menu.getVidaInimigo(), (810 - 40) , 0);
			ArrayList<Habilidade> hab = new ArrayList<Habilidade>();
			hab.add(new Habilidade (100,100,100,100,100,100));
			menu.criarCartaUser("Rato de bic", "Cadê meu isqueiro?"," Magia", hab);
			menu.criarCarta(1);
			menu.jogadas(2, 0);
			assertEquals(menu.getVida(), 1098 , 0);
		
			
	}
	
}