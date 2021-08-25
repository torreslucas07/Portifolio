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
public class Trabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco.criar_tabela("Paciente", "problema_de_saude varchar", "nome varchar", "telefones_de_contato varchar", "endereco varchar", "rg varchar", "cpf varchar", "id_consulta varchar");
        Paciente p= new Paciente();
        p.setCpf("136.258.789-58");
        p.setEndereco("Rua dos Pássaros");
        p.setId_consulta("4586");
        p.setNome("Roberta");
        p.setProblema_de_saude("infecção urinária");
        p.setRg("6.789.354");
        p.setTelefones_de_contato("48999658452");
        
        Banco.salvar(p);
        
        Banco.criar_tabela("Medico", "nome varchar", "carga_horaria varchar", "crm varchar", "local_faculdade varchar", "telefone varchar","especializacao varchar", "id_consulta varchar");
        Medico m= new Medico();
        m.setCarga_horaria("40 horas");
        m.setCrm("32.789");
        m.setEspecializacao("Pediatra");
        m.setId_consulta("9877");
        m.setLocal_faculdade("Univali");
        m.setNome("Sofia");
        m.setTelefone("48998445620");
        
        Banco.salvar(m);
        
        Banco.criar_tabela("Consulta", "local varchar", "convenio varchar", "data varchar", "id varchar", "tipo varchar", "resultado varchar", "horario varchar");
        Consulta c= new Consulta();
        c.setConvenio("Unimed");
        c.setData("12/05/2021");
        c.setHorario("15:30 horas");
        c.setId("7852");
        c.setLocal("Clínica Estar Bem");
        c.setResultado("fazer exames");
        c.setTipo("Cardiologista");
        
         Banco.salvar(c);
         System.out.println("tabela Paciente:");
         Banco.visualiza_dados("Paciente", "problema_de_saude", "nome", "telefones_de_contato", "endereco", "rg", "cpf", "id_consulta");
         System.out.println("tabela Medico:");
         Banco.visualiza_dados("Medico", "nome", "carga_horaria", "crm", "local_faculdade", "telefone", "especializacao", "id_consulta");
         System.out.println("tabela Consulta:");
         Banco.visualiza_dados("Consulta", "local", "convenio", "data", "id", "tipo", "resultado", "horario");
        
    }
    
}
