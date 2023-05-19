package model;

import java.util.ArrayList;

public class Venda {
	
	private int id;
	private ArrayList <Carrinho> carrinhoList = new ArrayList<>();
	
	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venda(int id, ArrayList<Carrinho> carrinhoList) {
		super();
		this.id = id;
		this.carrinhoList = carrinhoList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Carrinho> getCarrinhoList() {
		return carrinhoList;
	}

	public void setCarrinhoList(ArrayList<Carrinho> carrinhoList) {
		this.carrinhoList = carrinhoList;
	}
	
	
	
}
