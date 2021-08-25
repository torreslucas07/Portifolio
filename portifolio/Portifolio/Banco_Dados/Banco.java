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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author SESI_SENAI
 */
public class Banco {
    private static Connection connection;
   
    public static Connection getConnection(){
        if(connection == null){
            try{
                //Class.forName("com.mysql.jdbc.Driver"); //para mysql
                Class.forName("org.postgresql.Driver");//para postgresql
                String host = "localhost";
                String port = "5432";
                String database = "postgres";
                String user = "postgres";
                String pass = "senai";//digitar a senha do seu banco
                //String url = "jdbc:mysql://"+host+":"+port+"/"+database; //para mysql
                String url = "jdbc:postgresql://"+host+":"+port+"/"+database;//para postgresql
                connection = DriverManager.getConnection(url, user, pass);                
               
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void close(){
        if (connection == null){
            throw new RuntimeException("Nenhuma conexão aberta!");
        }
        else{
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
 
    public static void salvar (Paciente paciente){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO paciente (problema_de_saude, nome, telefones_de_contato, endereco, rg, cpf, id_consulta) values(?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, paciente.getProblema_de_saude());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getTelefones_de_contato());
            ps.setString(4, paciente.getEndereco());
            ps.setString(5, paciente.getRg());
            ps.setString(6, paciente.getCpf());
            ps.setString(7, paciente.getId_consulta());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public static void salvar (Medico medico){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO medico (nome, carga_horaria, crm, local_faculdade, telefone, especializacao, id_consulta) values(?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCarga_horaria());
            ps.setString(3, medico.getCrm());
            ps.setString(4, medico.getLocal_faculdade());
            ps.setString(5, medico.getTelefone());
            ps.setString(6, medico.getEspecializacao());
            ps.setString(7, medico.getId_consulta());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public static void salvar (Consulta consulta){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO consulta (local, convenio, data, id, tipo, resultado, horario) values(?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, consulta.getLocal());
            ps.setString(2, consulta.getConvenio());
            ps.setString(3, consulta.getData());
            ps.setString(4, consulta.getId());
            ps.setString(5, consulta.getTipo());
            ps.setString(6, consulta.getResultado());
            ps.setString(7, consulta.getHorario());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   public static void criar_tabela (String tabela, String... atributo){
        try{
            Connection con = Banco.getConnection();
            
            String comando = "CREATE TABLE " + tabela + "(";
            
            for (String i: atributo){
                comando = comando + i + ",";
            }
            comando = comando.substring(0, comando.length()-1);
            comando = comando + ");";
            //System.out.println(comando);
           PreparedStatement ps = con.prepareStatement(comando);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
   

  public static void visualiza_dados (String tabela, String... atributo){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tabela);
            ResultSet rs = ps.executeQuery();
            
            String resultado = "";
            while(rs.next()){
                for(String i : atributo){
                    resultado = resultado + " | " + rs.getString(i);
                }
resultado = resultado + "\n";
            }
            System.out.println(resultado);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}

