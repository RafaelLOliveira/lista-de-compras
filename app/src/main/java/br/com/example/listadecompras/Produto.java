package br.com.example.listadecompras;

public class Produto {

    private String nomeProduto;
    private String quantidadeProduto;

    public Produto(String nome, String quantidade) {
        this.nomeProduto = nome;
        this.quantidadeProduto = quantidade;
    }

    @Override
    public String toString() {
        return nomeProduto;
    }
}
