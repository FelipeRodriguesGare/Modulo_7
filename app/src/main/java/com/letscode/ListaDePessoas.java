package com.letscode;

import com.letscode.dominio.Pessoa;
import com.letscode.ed.Estrutura;

import java.util.Arrays;


public class ListaDePessoas implements Estrutura {

    private Pessoa[] pessoas = new Pessoa[10];
    private int index = 0;

    @Override
    public void adicionar(Pessoa pessoa) {
        this.pessoas[this.index] = pessoa;
        this.index++;
    }

    public void adicionar(int index, Pessoa pessoa) {

        Pessoa[] arrAux = new Pessoa[this.pessoas.length];

        if (this.index >= this.pessoas.length || index >= this.pessoas.length) {
            if (index > this.pessoas.length){
                arrAux = new Pessoa[index+1];
            }
            else {
                arrAux = new Pessoa[this.pessoas.length + 1];
            }
        }

        if (index > this.pessoas.length){
            System.arraycopy(this.pessoas, 0, arrAux, 0, this.pessoas.length);
            arrAux[index] = pessoa;
        }else {
            System.arraycopy(this.pessoas, 0, arrAux, 0, index);
            arrAux[index] = pessoa;
            System.arraycopy(this.pessoas, index, arrAux, index+1, arrAux.length-index-1);
        }
            System.out.println(Arrays.toString(arrAux));
            this.index++;
    }

    @Override
    public Pessoa buscar(String nome){
        for(int i = 0; i < this.index; i++){
            if(this.pessoas[i].getNome().equals(nome)) return this.pessoas[i];
        }
        throw new java.lang.RuntimeException("Nenhuma pessoa encontrada com este nome");
    }

    private void reorganize(){
        for (int i =0; i <= this.index; i++){
            if(this.pessoas[i] == null && i < this.index) {
                for (int j=i; j <= this.index-i; j++){
                    this.pessoas[j] = this.pessoas[j+1];
                }
            }
        }
        this.index--;
    }

    @Override
    public void remover(Pessoa pessoa) {
//        System.arraycopy(temp, 0, this.pessoas, 0, this.index);
        for(int i = 0; i < this.index; i++){
            if(this.pessoas[i].getNome().equals(pessoa.getNome()) && this.pessoas[i].getIdade() == pessoa.getIdade()) this.pessoas[i] = null;
        }
        reorganize();
    }

    @Override
    public void remover(int index) {
        this.pessoas[index] = null;
        reorganize();
    }

    @Override
    public void listarTodos() {
        for(int i = 0; i < this.index; i++){
            if (this.pessoas[i] != null) System.out.println(this.pessoas[i].getNome());
        }
    }

    @Override
    public Pessoa getPessoa(int index) {
        return this.pessoas[index];
    }
}
