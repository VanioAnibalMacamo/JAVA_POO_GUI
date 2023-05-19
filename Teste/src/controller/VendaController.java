package controller;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Venda;
import model.Carrinho;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VendaController {
	
	ArrayList <Venda> vendaList = new ArrayList<>();
	

	public void vender(Venda venda) {
		if(venda.getCarrinhoList().size() > 0) {
			venda.setId(vendaList.size()+1000);
			JOptionPane.showMessageDialog(null, "Venda Registrada");
			baixarFicheiro(venda);
		}else {
			JOptionPane.showMessageDialog(null, "Impossivel Efectuar a compra sem nada no carrinho");
		}
	}
	
	public void baixarFicheiro(Venda venda) {
		Document document = new Document();
		
        try {
        	

            PdfWriter.getInstance(document, new FileOutputStream("recibo "+Math.random()+".pdf"));

            document.open();
            
            document.add(new Phrase("Recibo Processado no dia: "+new Date()));
            
            PdfPTable table = new PdfPTable(4);
            
            table.addCell(new PdfPCell(new Phrase("Nome")));
            table.addCell(new PdfPCell(new Phrase("Preço")));
            table.addCell(new PdfPCell(new Phrase("Quantidade")));
            table.addCell(new PdfPCell(new Phrase("Total")));
            double total=0;
            for(Carrinho carrinho: venda.getCarrinhoList()) {
                table.addCell(carrinho.getProduto().getNome());
                table.addCell(Double.toString(carrinho.getProduto().getPreco()));
                table.addCell(Integer.toString(carrinho.getQuantidade()));
                table.addCell(Double.toString(carrinho.getValorTotal()));
                total += carrinho.getValorTotal();
            }
            table.addCell("Total");
            table.addCell("");
            table.addCell("");
            table.addCell(Double.toString(total));

            document.add(table);

            document.close();

            JOptionPane.showMessageDialog(null,"PDF gerado com sucesso!");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
	

	
	

