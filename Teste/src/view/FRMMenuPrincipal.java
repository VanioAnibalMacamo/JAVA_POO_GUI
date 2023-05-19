package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class FRMMenuPrincipal extends JFrame implements ActionListener {
	
	
	 JLabel lblTexto;
	 JButton btnCadastrar, btnVisualizar, btnVendas, btnGestao, btnSairPrograma;
	
	public FRMMenuPrincipal() {
		 setTitle("Menu Principal");
	     setResizable(false);
	     setSize(700, 400);
	     setBounds(300, 140,900, 400);
	     
	     lblTexto=new JLabel("MENU PRINCIPAL"); lblTexto.setBounds(300, 2,400, 30);  add(lblTexto);
	     
	     btnCadastrar=new JButton("Cadastrar"); btnCadastrar.setBounds(15, 100, 200, 100); add(btnCadastrar);
	     btnVisualizar=new JButton("Visualizar"); btnVisualizar.setBounds(300, 100, 200, 100); add(btnVisualizar);
	     btnVendas=new JButton("Vendas"); btnVendas.setBounds(600, 100, 200, 100); add(btnVendas);
	     btnGestao=new JButton("Gestão"); btnGestao.setBounds(15, 230, 200, 100); add(btnGestao);
	     btnSairPrograma=new JButton("Sair do Programa"); btnSairPrograma.setBounds(300, 230, 200, 100); add(btnSairPrograma);
	     
	     btnCadastrar.addActionListener(this); btnVisualizar.addActionListener(this); btnVendas.addActionListener(this); 
	     btnGestao.addActionListener(this);  btnSairPrograma.addActionListener(this); 
	     setLayout(null);
	     setVisible(true);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCadastrar) {
			FRMCadastrarProduto frmCadastrarProduto = new FRMCadastrarProduto();
		}
		if(e.getSource() == btnVisualizar) {
			FRMVisualizarProduto frmVisualizarProduto = new FRMVisualizarProduto();
		}
		if(e.getSource() == btnVendas) {
			FRMVendas frmVendas = new FRMVendas();
		}
		if(e.getSource() == btnSairPrograma) {
			System.exit(ABORT);
		}
		
		
	}

}
