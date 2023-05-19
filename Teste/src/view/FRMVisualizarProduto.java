package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoController;
import model.Produto;

public class FRMVisualizarProduto extends JFrame implements ActionListener{
	
	JLabel lblTexto;
	JTable tabela;
	DefaultTableModel  modelo;
	JScrollPane scroll;
	JButton btnVisualizar,btnLimpar,btnVoltar;
	
	ProdutoController produtoController = new ProdutoController();
	
	public FRMVisualizarProduto() {
		setTitle("Visualizar Produtos");
        setResizable(false);
        setBounds(300, 140,750, 500);
        
        lblTexto=new JLabel("VISUALIZAR PRODUTOS"); lblTexto.setBounds(300, 2,400, 30);  add(lblTexto);
        
        tabela=new JTable();
        String conteudos[]={"ID ","Nome","Preço", "Quantidade", "Categoria"};
        modelo=new DefaultTableModel(new Object[][]{ },conteudos); 
        tabela=new JTable(modelo);  
        scroll=new JScrollPane(tabela); scroll.setBounds(50,120, 600,250); add(scroll);
        
        
        btnVisualizar=new JButton("Visualizar"); 
        btnVisualizar.setBounds(50, 400, 150, 50); add(btnVisualizar); btnVisualizar.addActionListener(this);
        btnLimpar=new JButton("Limpar");  
        btnLimpar.setBounds(280, 400, 150, 50); add(btnLimpar); btnLimpar.addActionListener(this);
        btnVoltar=new JButton("Voltar"); 
        btnVoltar.setBounds(500, 400, 150, 50); add(btnVoltar); btnVoltar.addActionListener(this);
        
        
        preencherTabela();
        
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void preencherTabela() {
		
		for(Produto produto: produtoController.findAll())
		    modelo.addRow(new String[]{Integer.toString(produto.getId()), produto.getNome(), Double.toString(produto.getPreco()),
				 					Integer.toString(produto.getQuantidade()), produto.getCategoria()});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVoltar) {
			dispose();
		}
		
	}

}
