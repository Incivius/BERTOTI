package EstoqueGeral;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

public class Teste extends TestCase {

	@Test
	public void test() {
		
		Estoque etq = new Estoque();
		Localização local = new Localização(2,1);
		Fabricante marca = new Fabricante();
		Categoria catego = new Categoria("Uso diario");
	
		assertEquals(local.getAndar(),1);
		assertEquals(local.getRua(),2);
		
		etq.addProduto(new Produto("Coador", "pano", 1, 3.20, catego, local, marca));
		assertEquals(etq.getProdutos().size(), 1);
		
		local.setAndar(3);
		assertEquals(local.getAndar(),3);

		local.setRua(7);
		assertEquals(local.getRua(),7);

		assertEquals(etq.buscarNomeProdutos("Coador"), 1);
		
		assertEquals(1, 1);
	
		

	}
}