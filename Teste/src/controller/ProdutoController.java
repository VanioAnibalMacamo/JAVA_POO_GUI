package controller;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import model.Produto;

public class ProdutoController {
	
	static ArrayList <Produto> produtosList = new ArrayList<>();
	
	
	public static void save(Produto produto) {
		produtosList.add(produto);
		JOptionPane.showMessageDialog(null, "Produto Registrao com Sucesso!");
	}
	public ArrayList<Produto> findAll(){
		Collections.sort(produtosList);
		return produtosList;
	}
	public static void remove(int id) {
		boolean logica = false;
		
		for(Produto produto: produtosList) {
			if(produto.getId() == id) {
				produtosList.remove(produto);
				logica = true;
			}
		}
		if(logica == true) {
			JOptionPane.showMessageDialog(null, "Produto Removido!");
		}else {
			JOptionPane.showMessageDialog(null, "O ID colocado não existe!");
		}
	}

}
