/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velha.jogador;

/**
 *
 * @author paulo
 */
public class Jogador {
    private final String nome;
    private final int id;
    private Estado estado;
    private int numeroDeVitorias;
    private int numeroDeDerrotas;
    private int numeroDeEmpates;
    
    public Jogador(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    
    
    public String getNome() {
        return this.nome;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setNumeroDeVitorias(int numeroDeVitorias) {
        this.numeroDeVitorias = numeroDeVitorias;
    }
    
    public int getNumeroDeVitorias() {
        return this.numeroDeVitorias;
    }
    
    public void setNumeroDeDerrotas(int numeroDeDerrotas) {
        this.numeroDeDerrotas = numeroDeDerrotas;
    }
    
    public int getNumeroDeDerrotas() {
        return this.numeroDeDerrotas;
    }
    
    public void setNumeroDeEmpates(int numeroDeEmpates) {
        this.numeroDeEmpates = numeroDeEmpates;
    }
    
    public int getNumeroDeEmpates() {
        return this.numeroDeEmpates;
    }
    
    
}
