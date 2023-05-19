package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;

import controller.ProdutoController;
import controller.VendaController;
import model.Produto;
import model.Venda;
import model.Carrinho;

public class FRMVendas extends JFrame implements ActionListener{
	
	JLabel lblTexto, lblCompras, lblIdProduto, lblQuantidade, lblTotal;
	JTable tabela, tabelaCarnes, tabelaHigiene, tabelaRapidos, tabelaVendas;
	DefaultTableModel  modelo, modeloCarnes, modeloHigiente, modeloRapidos, modeloVendas;
	JScrollPane scroll, scrollCarnes, scrollHigiene, scrollRapidos, scrollVendas;
	JButton btnVisualizar,btnLimpar,btnVoltar, btnAdicionar, btnComprar;
	JTextField txtIdProdudo, txtQuantidade, txtTotal;
	private JPanel footerPanel;
	
	ProdutoController produtoController = new ProdutoController();
	VendaController vendaController = new VendaController();

	Venda venda = new Venda();
	double total =0;
	
	public FRMVendas() {
		setTitle("Vendas");
        setResizable(false);
        setBounds(100, 100,1400, 650);
        
        lblTexto=new JLabel("Vendas"); lblTexto.setBounds(300, 2,400, 30);  add(lblTexto);
        lblCompras=new JLabel("Fazer Compras"); lblCompras.setBounds(900, 2,400, 30);  add(lblCompras);
        
        lblIdProduto=new JLabel("ID"); lblIdProduto.setBounds(750, 70,400, 30);  add(lblIdProduto);
        txtIdProdudo=new JTextField();  txtIdProdudo.setBounds(750, 100,170, 20); add(txtIdProdudo);
        lblQuantidade=new JLabel("Quantidade"); lblQuantidade.setBounds(950, 70,400, 30);  add(lblQuantidade);
        txtQuantidade=new JTextField();  txtQuantidade.setBounds(950, 100,170, 20); add(txtQuantidade);
        btnAdicionar=new JButton("Adicionar"); 
        btnAdicionar.setBounds(1130, 100, 100, 20); add(btnAdicionar); btnAdicionar.addActionListener(this);
        
        tabelaVendas = new JTable();
        String conteudosVendas []= {"Produto", "Preço", "Quantide","Total"};
        modeloVendas=new DefaultTableModel(new Object[][]{ },conteudosVendas); 
        
        tabelaVendas=new JTable(modeloVendas); 
        scrollVendas=new JScrollPane(tabelaVendas); scrollVendas.setBounds(750,150, 600,300); add(scrollVendas);
        lblTotal=new JLabel("Total"); lblTotal.setBounds(1070, 445,400, 30);  add(lblTotal);
        txtTotal=new JTextField();  txtTotal.setBounds(1100, 450,250, 20); txtTotal.setEnabled(false);add(txtTotal);
        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(750, 450, 100, 20); add(btnComprar); btnComprar.addActionListener(this);
        
        tabela=new JTable();
        String conteudos[]={"ID ","Nome","Preço", "Quantidade", "Categoria"};
        
        modelo=new DefaultTableModel(new Object[][]{ },conteudos); 
        modeloCarnes=new DefaultTableModel(new Object[][]{ },conteudos); 
        modeloHigiente=new DefaultTableModel(new Object[][]{ },conteudos); 
        modeloRapidos=new DefaultTableModel(new Object[][]{ },conteudos); 
        
        tabela=new JTable(modelo);  
        scroll=new JScrollPane(tabela); scroll.setBounds(50,50, 600,100); add(scroll);
        
        tabelaCarnes = new JTable();
        tabelaCarnes=new JTable(modeloCarnes);  
        scrollCarnes=new JScrollPane(tabelaCarnes); scrollCarnes.setBounds(50,160, 600,100); add(scrollCarnes);
              
        tabelaHigiene = new JTable();
        tabelaHigiene=new JTable(modeloHigiente);  
        scrollHigiene=new JScrollPane(tabelaHigiene); scrollHigiene.setBounds(50,270, 600,100); add(scrollHigiene);
        
        tabelaRapidos = new JTable();
        tabelaRapidos=new JTable(modeloRapidos);  
        scrollRapidos=new JScrollPane(tabelaRapidos); scrollRapidos.setBounds(50,380, 600,100); add(scrollRapidos);
        
        btnVoltar=new JButton("Voltar"); 
        btnVoltar.setBounds(1180, 540, 150, 50); add(btnVoltar); btnVoltar.addActionListener(this);
        
        preencherTabela();
         
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVoltar) {
			dispose();
		}
		if(e.getSource() == btnAdicionar) {
			int idProduto = Integer.parseInt(txtIdProdudo.getText());
			int quantidade = Integer.parseInt(txtQuantidade.getText());
			double preco =0;
			Carrinho carrinho = new Carrinho();
			boolean logica = false;
			carrinho.setId((venda.getCarrinhoList().size()+1));
			for(Produto produto: produtoController.findAll()) {
				if(produto.getId() == idProduto) {
					logica = true;
					if(produto.getQuantidade() < quantidade) {
						JOptionPane.showMessageDialog(null, "Nao existe Stock Suficiente!");
					}else {
						carrinho.setProduto(produto);
						preco = produto.getPreco();
						produto.setQuantidade(produto.getQuantidade() - quantidade);
						
						carrinho.setQuantidade(quantidade);
						carrinho.setValorTotal(quantidade*preco);
						
						venda.getCarrinhoList().add(carrinho);
						preencherTabelaVendas();
						preencherTabela();
						total += carrinho.getValorTotal();
						txtTotal.setText(Double.toString(total)+" mts");
						txtIdProdudo.setText(""); txtQuantidade.setText("");
					}
				}
			}
			if(logica == false) {
				JOptionPane.showMessageDialog(null, "Nenhum Produto foi encontrado com esse Id.");
			}
		}
		if(e.getSource() == btnComprar) {
			vendaController.vender(venda);
			dispose();
			FRMVendas frmVendas = new FRMVendas();
			
						
		}
		
		
	}
	public void preencherTabelaVendas() { 
		  while(modeloVendas.getRowCount()!=0){ modeloVendas.removeRow(0);}
		  for(Carrinho carrinho: venda.getCarrinhoList()) {
			  modeloVendas.addRow(new String[]{carrinho.getProduto().getNome(), Double.toString(carrinho.getProduto().getPreco()),
					  				Integer.toString(carrinho.getQuantidade()),Double.toString(carrinho.getValorTotal())});
		  }
	}
	public void preencherTabela() {
		
		Limpar();
		for(Produto produto: produtoController.findAll()) {
			if(produto.getCategoria().equals("Cereais")) {
				modelo.addRow(new String[]{Integer.toString(produto.getId()), produto.getNome(), Double.toString(produto.getPreco()),
				 					Integer.toString(produto.getQuantidade()), produto.getCategoria()});
			}
		}
		
		for(Produto produto: produtoController.findAll()) {
			if(produto.getCategoria().equals("Carnes")) {
				modeloCarnes.addRow(new String[]{Integer.toString(produto.getId()), produto.getNome(), Double.toString(produto.getPreco()),
				 					Integer.toString(produto.getQuantidade()), produto.getCategoria()});
			}
		}
		for(Produto produto: produtoController.findAll()) {
			if(produto.getCategoria().equals("Higiene")) {
				modeloHigiente.addRow(new String[]{Integer.toString(produto.getId()), produto.getNome(), Double.toString(produto.getPreco()),
				 					Integer.toString(produto.getQuantidade()), produto.getCategoria()});
				}
		}
		for(Produto produto: produtoController.findAll()) {
			if(produto.getCategoria().equals("Rapidos")) {
				modeloRapidos.addRow(new String[]{Integer.toString(produto.getId()), produto.getNome(), Double.toString(produto.getPreco()),
				 					Integer.toString(produto.getQuantidade()), produto.getCategoria()});
			}
		}
	}
	
	 public void Limpar(){
         while(modelo.getRowCount()!=0){ modelo.removeRow(0);}
         while(modeloCarnes.getRowCount()!=0){ modeloCarnes.removeRow(0);}
         while(modeloHigiente.getRowCount()!=0){ modeloHigiente.removeRow(0);}
         while(modeloRapidos.getRowCount()!=0){ modeloRapidos.removeRow(0);}         
    }

	
}
