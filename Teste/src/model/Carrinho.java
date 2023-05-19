package model;

public class Carrinho {
	private int id;
	private Produto produto;
	private double valorTotal;
	private int quantidade;
	
	public Carrinho(Produto produto, double valorTotal, int id, int quantidade) {
		super();
		this.produto = produto;
		this.valorTotal = valorTotal;
		this.id = id;
		this.quantidade = quantidade;
	}

	public Carrinho() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
