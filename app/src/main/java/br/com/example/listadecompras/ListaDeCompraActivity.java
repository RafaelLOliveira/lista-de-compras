package br.com.example.listadecompras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaDeCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);
        setTitle("Lista de Compras");
        abreFormularioNovoProdutoActivity();

        produtoDAO dao = new produtoDAO();




    }




    private void abreFormularioNovoProdutoActivity() {
        FloatingActionButton botaoNovoProduto = findViewById(R.id.activity_main_fab_novo_pruduto);
        botaoNovoProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaDeCompraActivity.this, FormularioNovoProdutoActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        produtoDAO dao = new produtoDAO();
        configuraListaProdutos(dao);
        super.onResume();
    }

    private void configuraListaProdutos(produtoDAO dao) {
        ListView listaDeProdutos = findViewById(R.id.activity_main_lista_de_compras);
        listaDeProdutos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, dao.todos()));
    }
}
