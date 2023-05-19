package model;

public class Produto implements Comparable<Produto> {
	
	private int id;
	private int quantidade;
	private double preco;
	private String nome;
	private String categoria;
	
	public Produto() {}
	public Produto(int id, int quantidade, double preco, String nome, String categoria) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
		this.nome = nome;
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", quantidade=" + quantidade + ", preco=" + preco + ", nome=" + nome
				+ ", categoria=" + categoria + "]";
	}
	
	@Override
    public int compareTo(Produto outroProduto) {
        return this.nome.compareTo(outroProduto.nome);
    }	
	
}
