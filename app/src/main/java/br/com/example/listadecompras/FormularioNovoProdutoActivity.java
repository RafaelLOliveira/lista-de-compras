package br.com.example.listadecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FormularioNovoProdutoActivity extends AppCompatActivity {

    private EditText campoNomeProduto;
    private EditText campoQuantidadeProduto;

    produtoDAO dao = new produtoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fomulario_novo_produto);
        setTitle("Novo produto");
        inicializaoCampos();
        configuracaoBotaoSalvar();
    }





    private void configuracaoBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_novo_produto_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormularioNovoProdutoActivity.this, "Dados Salvos", Toast.LENGTH_SHORT);
                Produto produtoCriado = criaProduto(campoNomeProduto,campoQuantidadeProduto);
                salva(produtoCriado);
                finish();
            }
        });
    }

    private void inicializaoCampos() {
        campoNomeProduto = findViewById(R.id.activity_formulario_novo_produto_nome);
        campoQuantidadeProduto = findViewById(R.id.activity_formulario_novo_produto_quantidade);
    }


    private Produto criaProduto(EditText campoNomeProduto, EditText campoQuantidadeProduto) {
        String nome = campoNomeProduto.getText().toString();
        String quantidade = campoQuantidadeProduto.getText().toString();

        Produto produtoCriado = new Produto(nome, quantidade);
        return produtoCriado;
    }

    private void salva(Produto produtoCriado) {
        dao.salva(produtoCriado);
    }
}
