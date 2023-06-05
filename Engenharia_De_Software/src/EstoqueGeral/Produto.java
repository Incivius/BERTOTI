package EstoqueGeral;
public class Produto {

	String nomeProduto;
	String descrição;
	int códigoProduto;
	Double preço;
	Categoria catego;
	Localização local;
	Fabricante marca;

public Produto(String nomeProduto,  String descrição, int códigoProduto, double preço, Categoria catego, Localização local, Fabricante marca){
    this.nomeProduto = nomeProduto;
    this.descrição = descrição;
    this.códigoProduto = códigoProduto;
    this.preço = preço;
    this.catego = catego;
    this.local = local;
    this.marca = marca;
}

public String getNomeProduto(){
    return nomeProduto;
}
public void setNomePorduto(String nomeProduto){
    this.nomeProduto = nomeProduto;
}
public String getDescricao(){
    return descrição;
}
public void setDescricao(String descrição){
    this.descrição = descrição;
}

public int getCodigoProduto(){
    return códigoProduto;
}
public void setCodigoProduto(int códigoProduto){
    this.códigoProduto = códigoProduto;
}
public double getPreço(){
    return preço;
}
public void setPreço(double preço){
    this.preço = preço;
}
public Categoria getCategoria(){
    return catego;
}
public void setCategoria(Categoria catego){
    this.catego = catego;
}
public Localização getLocal(){
    return local;
}
public void setLocal(Localização local){
    this.local = local;
}
public Fabricante getMarca(){
    return marca;
}
public void setMarca(Fabricante marca){
    this.marca = marca;
}

}