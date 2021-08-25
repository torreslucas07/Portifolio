/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author SESI_SENAI
 */
public class Paciente {
  private String problema_de_saude;
  private String nome;
  private String telefones_de_contato;
  private String endereco; 
  private String rg;
  private String cpf;
  private String id_consulta;
  
    public String getProblema_de_saude() {
        return problema_de_saude;
    }

    public void setProblema_de_saude(String problema_de_saude) {
        this.problema_de_saude = problema_de_saude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefones_de_contato() {
        return telefones_de_contato;
    }

    public void setTelefones_de_contato(String telefones_de_contato) {
        this.telefones_de_contato = telefones_de_contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(String id_consulta) {
        this.id_consulta = id_consulta;
    }
}



