package br.sc.senai.produtos.view;

import br.sc.senai.produtos.controller.ProdutoController;
import br.sc.senai.produtos.model.entities.Produto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultTableModelArrayList extends AbstractTableModel {

    List<Produto> dados;
    String[] colunas;

    public DefaultTableModelArrayList(Collection<Produto> lista) {
        this.dados = new ArrayList<>(lista);
        colunas = new String[]{"Id", "Nome", "Quantidade", "Valor"};
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = dados.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return produto.getNumeroProduto();
            }
            case 1 -> {
                return produto.getNomeProduto();
            }
            case 2 -> {
                return produto.getQtdEstoque();
            }
            case 3 -> {
                return produto.getValorProduto();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
}
