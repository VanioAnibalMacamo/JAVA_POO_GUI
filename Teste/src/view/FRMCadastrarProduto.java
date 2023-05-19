package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ProdutoController;
import model.Produto;

public class FRMCadastrarProduto extends JFrame implements ActionListener {
	
	 JLabel lblTexto;
	 JButton btnCadastrar, btnVoltar;
	 JTextField txtId,txtPreco, txtNome, txtQuantidade;
	 JLabel lblId,lblPreco,lblNome,lblQuantidade,lblCategoria;
	 JComboBox cboCategoria;
	 
	ProdutoController produtoController = new ProdutoController();
	 
	 public FRMCadastrarProduto() {
		 setTitle("Cadastrar Produto");
	     setResizable(false);
	     setSize(700, 400);
	     setBounds(300, 140,750, 500);
	     
	     lblTexto=new JLabel("CADASTRAR PRODUTOS"); lblTexto.setBounds(300, 2,400, 30);  add(lblTexto);
	     lblId=new JLabel("Id: "); lblId.setBounds(20, 30,80, 30);  add(lblId);
	     txtId=new JTextField();  txtId.setBounds(78, 35,250, 20); txtId.setEnabled(false);add(txtId);
	     lblNome=new JLabel("Nome: "); lblNome.setBounds(20, 70,80, 30);  add(lblNome);
	     txtNome=new JTextField();  txtNome.setBounds(78, 75,250, 20); add(txtNome);
	     lblPreco=new JLabel("Preço: "); lblPreco.setBounds(20, 100,80, 30);  add(lblPreco);
	     txtPreco=new JTextField();  txtPreco.setBounds(78, 105,250, 20); add(txtPreco);
	     lblQuantidade=new JLabel("Quantidade: "); lblQuantidade.setBounds(20, 130,80, 30);add(lblQuantidade);
	     txtQuantidade=new JTextField();  txtQuantidade.setBounds(95, 135,250, 20); add(txtQuantidade);
	     String categorias[]={"Cereais","Carnes","Higiene","Rapidos"};
	     lblQuantidade=new JLabel("Quantidade: "); lblQuantidade.setBounds(20, 160,80, 30);add(lblQuantidade);
	     cboCategoria=new JComboBox(categorias); cboCategoria.setBounds(100, 165, 195, 20); add(cboCategoria);  
	     
	     id();
	     btnCadastrar=new JButton("Cadastrar"); btnCadastrar.setBounds(15, 300, 100, 50); add(btnCadastrar);
	     btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(300, 300, 100, 50); add(btnVoltar);
	          
	     btnCadastrar.addActionListener(this); btnVoltar.addActionListener(this);
	     setLayout(null);
	     setVisible(true);
	     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	 
	 public void id() {
		 txtId.setText(Integer.toString(produtoController.findAll().size()+1000));
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCadastrar) {
			Produto produto = new Produto();
			
			produto.setId(Integer.parseInt(txtId.getText()));
			produto.setNome(txtNome.getText());
			produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
			produto.setPreco(Double.parseDouble(txtPreco.getText()));
			produto.setCategoria(cboCategoria.getSelectedItem().toString());
			produtoController.save(produto);
			dispose();
			FRMCadastrarProduto frmCadastrarProduto = new FRMCadastrarProduto();
			
		}
		if(e.getSource() == btnVoltar) {
			dispose();
		}
		
	}

}
