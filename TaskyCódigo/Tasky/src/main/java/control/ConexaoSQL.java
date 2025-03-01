/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author Aluno
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class ConexaoSQL {
    private Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/TaskyTest";
    static String driver = "org.postgresql.Driver";
    static String user = "postgres";
    static String senha = "utfpr";

    public void conectarBD(){
        try{
            System.out.println("Carregando o driver...");
            Class.forName(driver);
            System.out.println("Driver carregado com sucesso!");
        }catch(Exception e){
            System.out.println("Falha no carregamento!");
        }
        try{
            System.out.println("Tentando conectar o BD...");
            conn = DriverManager.getConnection(url,user,senha);
            System.out.println("BD conectado com sucesso!");
        }catch(SQLException e){
            System.out.println("Falha no carregamento!");
        }
    }

    public Connection getConn(){
        return conn;
    }
}
