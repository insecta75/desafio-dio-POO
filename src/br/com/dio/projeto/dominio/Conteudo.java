package br.com.dio.projeto.dominio;

public abstract class Conteudo {//Abstract: para ser usado nas classe filhas (Heranca);
    protected static final double XP_PADRAO = 10d;
    private String titulo;//Encapsulamento (private, protected e public);
    private String descricao;
    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
