package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import controller.LoginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.Color;

/*
 * Classe criada para criar o ClienteGUI 
 * Data de criação: 10/12/2023
 * @author Laura Carneiro de Azevedo e Leonnardo Calixto Braga
 */
public class ClienteGUI extends JFrame {
    private JTextField cpfField;
    private JTextField nomeField;
    private JTextField logradouroField;
    private JTextField numeroField;
    private JTextField cidadeField;
    private JComboBox estadoField;
    private JTextField telefoneField;

    public DefaultTableModel tableModel;
/*
 * Criação da estrutura do ClienteGUI bem como seus botões e caixas de texto.
 */
    public ClienteGUI() {
    	getContentPane().setBackground(new Color(192, 190, 195));
        setTitle("Cadastro de cliente");
        setSize(334, 361);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cpfField = new JTextField();
        cpfField.setBounds(38, 50, 204, 20);
        nomeField = new JTextField();
        nomeField.setBounds(38, 84, 204, 20);
        logradouroField = new JTextField();
        logradouroField.setBounds(38, 118, 204, 20);
        numeroField = new JTextField();
        numeroField.setBounds(253, 118, 41, 20);
        cidadeField = new JTextField();
        cidadeField.setBounds(38, 153, 204, 20);
     	String[] selections = {"Selecionar estado", "Acre - (AC)", "Alagoas - (AL)", "Amapá - (AP)", "Amazonas - (AM)", "Bahia - (BA)", "Ceará - (CE)", "Espirito Santo - (ES)", "Goiás - (GO)", "Maranhão - (MA)", "Mato Grosso - (MT)", "Mato Grosso do Sul - (MS)", "Minas Gerais - (MG)", "Pará - (PA)", "Paraíba - (PB)", "Paraná - (PR)", "Pernambuco - (PE)", "Piauí - (PI)", "Rio de Janeiro - (RJ)", "Rio Grande do Norte - (RN)", "Rio Grande do Sul - (RS)", "Rondônia - (RO)", "Roraima - (RR)", "Santa Catarina - (SC)", "São Paulo - SP", "Sergipe - (SE)", "Tocantins - (TO)", "Distrito Federal - (DF)"};
		estadoField = new JComboBox(selections);
        estadoField.setBounds(38, 187, 204, 22);
        telefoneField = new JTextField();
        telefoneField.setBounds(38, 223, 204, 20);

        JButton enviarButton = new JButton("ENVIAR");
        enviarButton.setBounds(159, 254, 83, 23);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cadastrarCliente();
            }
        });

        JButton limparButton = new JButton("LIMPAR");
        limparButton.setBounds(38, 254, 83, 23);
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	limparCampos();
            }
        });

        tableModel = new DefaultTableModel();
        JTable tabelaClientes = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        scrollPane.setBounds(0, 295, 318, 27);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("CPF:");
        label.setBounds(38, 36, 204, 14);
        getContentPane().add(label);
        getContentPane().add(cpfField);
        JLabel label_1 = new JLabel("Nome:");
        label_1.setBounds(38, 70, 204, 14);
        getContentPane().add(label_1);
        getContentPane().add(nomeField);
        JLabel label_2 = new JLabel("Logradouro:");
        label_2.setBounds(38, 104, 204, 14);
        getContentPane().add(label_2);
        getContentPane().add(logradouroField);
        JLabel label_3 = new JLabel("Número:");
        label_3.setBounds(253, 104, 55, 14);
        getContentPane().add(label_3);
        getContentPane().add(numeroField);
        JLabel label_4 = new JLabel("Cidade:");
        label_4.setBounds(38, 139, 204, 14);
        getContentPane().add(label_4);
        getContentPane().add(cidadeField);
        JLabel label_5 = new JLabel("Estado:");
        label_5.setBounds(38, 173, 204, 14);
        getContentPane().add(label_5);
        getContentPane().add(estadoField);
        JLabel label_6 = new JLabel("Telefone:");
        label_6.setBounds(38, 209, 204, 14);
        getContentPane().add(label_6);
        getContentPane().add(telefoneField);
        getContentPane().add(enviarButton);
        getContentPane().add(limparButton);
        getContentPane().add(scrollPane);

        setLocationRelativeTo(null); // pra centralizar a caixinha na tela.
        setVisible(true);
    }
/*
 * Método para Cadastrar Clientes
 */
   public void cadastrarCliente() {
        String cpf = cpfField.getText();
        String nome = nomeField.getText();
        String logradouro = logradouroField.getText();
        String numero = numeroField.getText();
        String cidade = cidadeField.getText();
        int estado = estadoField.getSelectedIndex();
        String telefone = telefoneField.getText();

        if (cpf.isEmpty() || nome.isEmpty() || logradouro.isEmpty() || numero.isEmpty() || cidade.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        } else {
            Vector<String> row = new Vector<>();
            row.add(cpf);
            row.add(nome);
            row.add(logradouro);
            row.add(numero);
            row.add(cidade);
            //row.add(estado);
            row.add(telefone);
            tableModel.addRow(row);

            JOptionPane.showMessageDialog(this, "DADOS CADASTRADOS COM SUCESSO!", "Usuário Cadastrado", JOptionPane.INFORMATION_MESSAGE);

            limparCampos();
        }
    }
/*
 * Método para limpar os campos do cliente
 */
    public void limparCampos() {
        cpfField.setText("");
        nomeField.setText("");
        logradouroField.setText("");
        numeroField.setText("");
        cidadeField.setText("");
        estadoField.setSelectedIndex(0);
        telefoneField.setText("");
    }

    public void estadoField() {
    	estadoField.setSelectedIndex(0);
		System.out.println(estadoField.getSelectedItem());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteGUI());
    }

	public DefaultTableModel getTableModel() {
		return null;
	}

}