import java.util.List;
import java.util.LinkedList;

public class Estoque {

    private List<Produto> produto = new LinkedList<Produto>();
	
	public void addLivro(Produto Produto) {
	    produto.add(Produto);
	}

	
	public List<Produto> buscarNomeProdutos(String nome){
		List<Produto> encontrados = new LinkedList<Produto>();
		for(Produto produto:produto) {
			if(produto.getNomeProduto().equals(nome)) encontrados.add(produto); 
		}
		return encontrados;
	}
	
	public List<Produto> getLivros(){
		return produto;
	}
	
}

