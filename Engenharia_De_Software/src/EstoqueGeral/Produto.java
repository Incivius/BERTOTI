package EstoqueGeral;
public class Produto {

	String nomeProduto;
	String descrição;
	int códigoProduto;
	Double preço;
	Categoria catego;
	Localização Local;
	Fabricante Marca;

public Produto(String nomeProduto,  String descrição, int códigoProduto, double preço){
    this.nomeProduto = nomeProduto;
    this.descrição = descrição;
    this.códigoProduto = códigoProduto;
    this.preço = preço;
    
    

}

public String getNomeProduto(){
    return nomeProduto;
}
public void setNomePorduto(String nomeProduto){
    this.nomeProduto = nomeProduto;
}
public String getDescrição(){
    return descrição;
}
public void setDescrição(String descrição){
    this.descrição = descrição;
}

public int getCódigoProduto(){
    return códigoProduto;
}
public void setCódigoProduto(int códigoProduto){
    this.códigoProduto = códigoProduto;
}
public double getPreço(){
    return preço;
}
public void setPreço(double preço){
    this.preço = preço;
}

 

}