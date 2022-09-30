package br.sc.senai.produtos.view;

import br.sc.senai.produtos.model.entities.Pessoa;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultTableModelArrayListPessoas extends AbstractTableModel {

    List<Pessoa> dados;
    String[] colunas;

    public DefaultTableModelArrayListPessoas(Collection<Pessoa> lista) {
        this.dados = new ArrayList<>(lista);
        colunas = new String[]{"Id", "Nome", "CPF", "Email", "Tipo pessoa"};
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
        Pessoa pessoa = dados.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return pessoa.getNumeroPessoa();
            }
            case 1 -> {
                return pessoa.getNomePessoa();
            }
            case 2 -> {
                return pessoa.getCpfPessoa();
            }
            case 3 -> {
                return pessoa.getEmailPessoa();
            }
            case 4 -> {
                return pessoa.getTipoPessoa();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
}
