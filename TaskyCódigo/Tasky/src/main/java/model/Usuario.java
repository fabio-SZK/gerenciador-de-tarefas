/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Fabio
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String senha;
    private String email;

    public Usuario(int idUsuario, String nome, String senha, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    
    public Usuario() {
        this.idUsuario = 0;
        this.nome = "";
        this.senha = "";
        this.email = "";
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public void criarUsuario() {
        // Implementação aqui
    }

    public void deletarUsuario() {
        // Implementação aqui
    }

    public void fazerLogin() {
        // Implementação aqui
    }
}
