package EstoqueGeral;
import org.junit.jupiter.api.Test;

import Jopege2.Menu;
import junit.framework.TestCase;

public class Teste extends TestCase {

	@Test
	public void test() {
		
		Estoque etq = new Estoque();
		Localização Local = new Localização(2,1);
		Menu menu = new Menu();
	
		assertEquals(Local.getAndar(),1);
		assertEquals(Local.getRua(),2);
		
		etq.addProduto(new Produto("Coador", "pano", 1, 3.20));
		assertEquals(etq.getProdutos().size(), 1);
		
		etq.addProduto(new Produto("Sabonete", "Cheiro de maçã", 12, 0.9));
		assertEquals(etq.getProdutos().size(), 2);
		
		Local.setAndar(3);
		assertEquals(Local.getAndar(),3);

		Local.setRua(7);
		assertEquals(Local.getRua(),7);
		
		assertEquals(1, 1);
	
		

	}
}