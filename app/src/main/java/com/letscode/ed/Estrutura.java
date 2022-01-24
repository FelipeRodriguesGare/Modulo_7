package com.letscode.ed;

import com.letscode.dominio.Pessoa;

public interface Estrutura {
    void adicionar(Pessoa pessoa);
    Pessoa buscar(String nome);
    void remover(Pessoa pessoa);
    void remover(int index);
    void listarTodos();
    Pessoa getPessoa(int index);
}
