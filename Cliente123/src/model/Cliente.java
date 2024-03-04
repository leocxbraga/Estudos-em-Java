package model;
/**
 * Classe criada para representar um Cliente.
 * Data da criação: 10/12/2023
 * @author Laura Carneiro de Azevedo e Leonnardo Calixto Braga
 */
public class Cliente {
    private String cpf;
    private String nome;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String telefone;
/*
 * construtor vazio
 */
    public Cliente() {
    }
/*
 * Construtor cheio e getters e setters para o model cliente
 */
    public Cliente(String cpf, String nome, String logradouro, String numero, String cidade, String estado, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
/*
 * Validador de campos
 */
    public boolean validarCampos() {
        return cpf != null && !cpf.isEmpty() &&
               nome != null && !nome.isEmpty() &&
               logradouro != null && !logradouro.isEmpty() &&
               numero != null && !numero.isEmpty() &&
               cidade != null && !cidade.isEmpty() &&
               estado != null && !estado.isEmpty() &&
               telefone != null && !telefone.isEmpty();
    }
}