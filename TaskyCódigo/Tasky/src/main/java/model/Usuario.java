/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String senha;
    private String email;
    private Perfil perfilUsuario;
    
    private List<Projeto> projetosUsuario;
    private List<Equipe> equipesUsuario;
    private List<Tarefa> listaTarefasUsuario;

    public Usuario(int idUsuario, String nome, String senha, String email, Perfil perfilUsuario, List<Projeto> projetosUsuario, List<Equipe> equipesUsuario, List<Tarefa> listaTarefasUsuario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.perfilUsuario = perfilUsuario;
        this.projetosUsuario = projetosUsuario;
        this.equipesUsuario = equipesUsuario;
        this.listaTarefasUsuario = listaTarefasUsuario;
    }
    
    public Usuario() {
        this.idUsuario = 0;
        this.nome = "";
        this.senha = "";
        this.email = "";
        this.perfilUsuario = new Perfil();
        this.projetosUsuario = new ArrayList<>();
        this.equipesUsuario = new ArrayList<>();
        this.listaTarefasUsuario = new ArrayList<>();
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

    public Perfil getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(Perfil perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public List<Projeto> getProjetosUsuario() {
        return projetosUsuario;
    }

    public void setProjetosUsuario(List<Projeto> projetosUsuario) {
        this.projetosUsuario = projetosUsuario;
    }

    public List<Equipe> getEquipesUsuario() {
        return equipesUsuario;
    }

    public void setEquipesUsuario(List<Equipe> equipesUsuario) {
        this.equipesUsuario = equipesUsuario;
    }

    public List<Tarefa> getListaTarefasUsuario() {
        return listaTarefasUsuario;
    }

    public void setListaTarefasUsuario(List<Tarefa> listaTarefasUsuario) {
        this.listaTarefasUsuario = listaTarefasUsuario;
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
