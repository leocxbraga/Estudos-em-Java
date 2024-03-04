package controller;

import java.awt.event.ActionEvent;

import view.ClienteGUI;
import view.LoginGUI;

import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
/*
 * Classe criada como controller da classe login
 * data de criação: 10/12/2023
 * @author Laura Carneiro de Azevedo e Leonnardo Calixto Braga
 */
public class LoginController {
	 private static LoginGUI view;

	    public LoginController(LoginGUI view) {
	        this.view = view;

/*
*Adiciona listeners aos botões
*/
	        view.addEntrarButtonListener(new EntrarButtonListener());
	        view.addLimparButtonListener(new LimparButtonListener());
	    }
/*
 * Cria listener para o botão entrar
 */
	    public class EntrarButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            realizarLogin();
	        }
	    }
/*
 * Cria listener para o botão limpar
 */
	    public class LimparButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            limparCampos();
	        }
	    }
/*
 * Realiza o login fixando-o como Login: "user" ; Senha: "12345".
 */
	    public static void realizarLogin() {
	        String login = view.getLogin();
	        String senha = view.getSenha();

	        if (login.equals("user") && senha.equals("12345")) {
	            abrirTelaCadastro();
	        } else {
	            view.exibirMensagemErro("Login ou senha incorretos.");
	        }
	    }
/*
 * Chama o método para abrir a tela de cadastro
 */
	    private static void abrirTelaCadastro() {
	        ClienteGUI clienteGUI = new ClienteGUI();
	        clienteGUI.setVisible(true);
	    }
/*
 * chama o método para limpar os campos
 */
	    public static void limparCampos() {
	        view.limparCampos();
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            LoginGUI loginGUI = new LoginGUI();
	            new LoginController(loginGUI);
	        });
	    }
}
