package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import view.ClienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
/*
 * Classe criada como controller da classe Cliente.
 * Data da criação: 10/12/2023
 * @author Laura Carneiro de Azevedo e Leonnardo Calixto Braga
 */
public class ClienteController {
	 private ClienteGUI clienteGUI;
	    private DefaultTableModel tableModel;
	    private Vector<Cliente> clientes;

	    public ClienteController(ClienteGUI clienteGUI) {
	        this.clienteGUI = clienteGUI;
	        this.tableModel = clienteGUI.getTableModel();
	        this.clientes = new Vector<>();

	        // Adicione os listeners necessários aos botões na classe ClienteGUI
	        JButton enviarButton = new JButton("ENVIAR");
	        enviarButton.setBounds(159, 254, 83, 23);
	        enviarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	cadastrarClienteViaMetodo();
	            }
	        });
	        
	        JButton limparButton = new JButton("LIMPAR");
	        limparButton.setBounds(38, 254, 83, 23);
	        limparButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	limparCamposViaMetodo();
	            }
	        });
	        enviarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	cadastrarClienteViaMetodo();
	            }
	        });

	        limparButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	limparCamposViaMetodo();
	            }
	        });
	    }

	   private void cadastrarClienteViaMetodo() {
		   SwingUtilities.invokeLater(() -> clienteGUI.cadastrarCliente());
	   }
	   private void limparCamposViaMetodo() {
		   SwingUtilities.invokeLater(() -> clienteGUI.limparCampos());
	   }
	    

	    private String getEstado(int index) {
	        // Lógica para obter o estado a partir do índice selecionado
	    	
	        String[] estados = {"Selecionar Estado", "Acre - (AC)", "Alagoas - (AL)", "Amapá - (AP)", "Amazonas - (AM)", "Bahia - (BA)", "Ceará - (CE)", "Espírito Santo - (ES)", "Goiás - (GO)",
	                "Maranhão - (MA)", "Mato Grosso - (MT)", "Mato Grosso do Sul - (MS)", "Minas Gerais - (MG)", "Pará - (PA)", "Paraíba - (PB)", "Paraná - (PR)", 
	                "Pernambuco - (PE)", "Piauí - (PI)", "Rio de Janeiro - (RJ)", "Rio Grande do Norte - (RN)", "Rio Grande do Sul - (RS)", "Rondônia - (RO)", 
	                "Roraima - (RR)", "Santa Catarina - (SC)", "São Paulo - (SP)", "Sergipe - (SE)", "Tocantins - (TO)", "Distrito Federal - (DF)"};
	        
	        if (index >= 0 && index < estados.length) {
	            return estados[index];
	        } else {
	            return "Selevionar Estado";
	        }
	    }
	   
}