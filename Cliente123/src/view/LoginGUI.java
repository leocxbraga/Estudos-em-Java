package view;

import javax.swing.*;

import model.Cliente;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
/*
 * Classe criada para criar o LoginGUI 
 * Data de criação: 10/12/2023
 * @author Laura Carneiro de Azevedo e Leonnardo Calixto Braga
 */
public class LoginGUI extends JFrame {
    private JTextField loginField;
    private JPasswordField senhaField;
/*
 * Criação da estrutura do LoginGUI bem como seus botôes e caixas de texto
 */
    public LoginGUI() {
    	getContentPane().setBackground(new Color(192, 190, 195));
        setTitle("Tela de Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginField = new JTextField();
        loginField.setBounds(45, 1, 132, 23);
        senhaField = new JPasswordField();
        senhaField.setBounds(45, 44, 132, 23);

        JButton entrarButton = new JButton("ENTRAR");
        entrarButton.setBounds(152, 88, 132, 23);
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        JButton limparButton = new JButton("LIMPAR");
        limparButton.setBounds(0, 88, 132, 23);
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Login:");
        label.setBounds(0, 1, 107, 23);
        getContentPane().add(label);
        getContentPane().add(loginField);
        JLabel label_1 = new JLabel("Senha:");
        label_1.setBounds(0, 44, 132, 23);
        getContentPane().add(label_1);
        getContentPane().add(senhaField);
        getContentPane().add(entrarButton);
        getContentPane().add(limparButton);

        setLocationRelativeTo(null); // para centralizar a caixinha na tela. Sem isso, ela aparece no canto superior esquerdo.
        setVisible(true);
    }
/*
 * Método para realizar o login
 */
    private void realizarLogin() {
        String login = loginField.getText();
        String senha = new String(senhaField.getPassword());

        if (login.equals("user") && senha.equals("12345")) {
            abrirTelaCadastro();
        } else {
            JOptionPane.showMessageDialog(this, "Login ou senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }
/*
 * Método para abrir a tela de cadastro
 */
    private void abrirTelaCadastro() {
        ClienteGUI clienteGUI = new ClienteGUI();
        clienteGUI.setVisible(true);
        this.dispose();
    }
/*
 * Método para limpar os campos da tela de login
 */
    public void limparCampos() {
        loginField.setText("");
        senhaField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginGUI());
    }
    public String getLogin() {
        return loginField.getText();
    }
    public String getSenha() {
        return new String(senhaField.getPassword());
    }
    public void addEntrarButtonListener(ActionListener listener) {
        JButton entrarButton = new JButton("ENTRAR");
		entrarButton.addActionListener(listener);
    }

    public void addLimparButtonListener(ActionListener listener) {
        JButton limparButton = new JButton("Limpar");
		limparButton.addActionListener(listener);
    }
    /*
     *Mensagem de erro 
     */
    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro de Login", JOptionPane.ERROR_MESSAGE);
        
    }
}