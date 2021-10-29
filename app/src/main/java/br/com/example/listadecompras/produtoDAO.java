package br.com.example.listadecompras;

import java.util.ArrayList;
import java.util.List;

public class produtoDAO {

    private final static List<Produto> listaProdutos = new ArrayList<>();

    public void salva(Produto aluno) {
        listaProdutos.add(aluno);
    }
    public List<Produto> todos() {
        return new ArrayList<>(listaProdutos);
    }

}
