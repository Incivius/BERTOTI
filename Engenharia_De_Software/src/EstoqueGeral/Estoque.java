package EstoqueGeral;
import java.util.List;
import java.util.LinkedList;

public class Estoque {

    private List<Produto> produto = new LinkedList<Produto>();
	
	public void addProduto(Produto Produto) {
	    produto.add(Produto);
	}
	
	public List<Produto> buscarNomeProdutos(String nome){
		List<Produto> encontrados = new LinkedList<Produto>();
		for(Produto produto:produto) {
			if(produto.getNomeProduto().equals(nome))
				encontrados.add(produto); 
		}
		return encontrados;
	}

	public List<Produto> buscarProdutoCodigo(int codigo){
		List<Produto> encontrados = new LinkedList<Produto>();
		for(Produto produto:produto) {
			if(produto.getCodigoProduto() == codigo)
				encontrados.add(produto);
		}
		return encontrados;
	}

	public List<Produto> buscarProdutoDescricao(String descricao){
		List<Produto> encontrados = new LinkedList<Produto>();
		for(Produto produto:produto) {
			if(produto.getDescricao().equals(descricao))
				encontrados.add(produto);
		}
		return encontrados;
	}
	public List<Produto> buscarProdutoMarca(String marca){
		List<Produto> encontrados = new LinkedList<Produto>();
		for(Produto produto:produto) {
			if(produto.getMarca().equals(marca))
				encontrados.add(produto);
		}
		return encontrados;
	}
	public List<Produto> buscarProdutoPreco(Double valor){
		List<Produto> encontrados = new LinkedList<Produto>();
		for(Produto produto:produto) {
			if(produto.getPreço() == valor)
				encontrados.add(produto);
		}
		return encontrados;
	}
	public List<Produto> buscarProdutoLocalizacao(int local, int local_2){
		List<Produto> encontrados = new LinkedList<Produto>();
		for(Produto produto:produto) {
			if(produto.getLocal().getAndar() == local && produto.getLocal().getRua() == local_2)
				encontrados.add(produto);
		}
		return encontrados;
	}

	public List<Produto> getProdutos(){
		return produto;
	}

	
}

