package io.mercadopaodesal.dao;

public class Category {

    private int id;
    private String nome;
    private String description;
    
    public Category(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Category() {} // Existing default constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
