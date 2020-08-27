/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaArray;

import java.util.Iterator;

/**
 *
 * @author Jonatas Dourado Porto
 */
public class ListaArray<G> implements IListaArray<G>, Iterable<G>{
    
    private int capacidade;
    private int tamanho;
    private Object[] lista;
    
    
    public ListaArray(){
        tamanho = 0;
        capacidade = 10;
        lista = new Object[capacidade];
    }
    
    @Override
    public void adicionarNoInicio(G objeto) {
        if(objeto == null){
            return;
        }
        if(tamanho + 1 == lista.length){
            capacidade *= 2;
        }
        Object[] listaTemp = new Object[capacidade];
        listaTemp[0] = objeto;
        for(int i = 1; i < tamanho + 1; i++){
            listaTemp[i] = lista[i - 1];
        }
        lista = listaTemp;
        tamanho++;
    }

    @Override
    public void adicionarNoFinal(G objeto) {
        if(objeto == null){
            return;
        }
        
        if(tamanho + 1 == lista.length){
            capacidade *= 2;
            Object[] listaTemp = new Object[capacidade];
            for(int i = 0; i < tamanho; i++){
                listaTemp[i] = lista[i];
            }
            lista = listaTemp;
        }
        lista[tamanho] = objeto;
        tamanho++;
    }

    @Override
    public void adicionarPorIndice(G objeto, int indice) {
        if(objeto == null){
            return;
        }
        if(indice < 0 || indice > tamanho){
            throw new IndexOutOfBoundsException("Tentando acessar um indice nao existente na lista. Metodo adicionarPorIndice .");
        }
        
        if(tamanho + 1 == lista.length){
            capacidade *= 2;
        }
        Object[] listaTemp = new Object[capacidade];
        boolean jaAdicionou = false;
        for(int i = 0; i < tamanho + 1; i++){
            if(i == indice){
                listaTemp[i] = objeto;
                jaAdicionou = true;
                continue;
            }
            if(jaAdicionou){
                listaTemp[i] = lista[i - 1];
                continue;
            }
            listaTemp[i] = lista[i];
            
        }
        lista = listaTemp;
        tamanho++;
    }

    @Override
    public void removerPorIndice(int indice) {
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("Tentando acessar um indice nao existente na lista. Metodo removerPorIndice.");
        }
        
        Object[] listaTemp = new Object[capacidade];
        boolean jaRemoveu = false;
        for(int i = 0; i < tamanho; i++){
            if(i == indice){
                jaRemoveu = true;
                continue;
            }
            if(jaRemoveu){
                listaTemp[i - 1] = lista[i];
                continue;
            }
            listaTemp[i] = lista[i];
        }
        lista = listaTemp;
        tamanho--;
    }

    @Override
    public void removerPorObjeto(G objeto) {
        if(objeto == null){
            throw new NullPointerException("Tentando remover um objeto nulo. Metodo removerPorObjeto");
        }
        Object[] listaTemp = new Object[capacidade];
        boolean jaRemoveu = false;
        for(int i = 0; i < tamanho; i++){
            if(lista[i].equals(objeto)){
                jaRemoveu = true;
                continue;
            }
            if(jaRemoveu){
                listaTemp[i - 1] = lista[i];
                continue;
            }
            listaTemp[i] = lista[i];
        }
        if(jaRemoveu){
            lista = listaTemp;
            tamanho--;
        }        
    }

    @Override
    public G removerERetornar(int indice) {
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("Tentando acessar um indice nao existente na lista. Metodo removerERetornar.");
        }
        Object temp = lista[indice];
        removerPorIndice(indice);
        return (G)temp;
    }

    @Override
    public G retornar(int indice) {
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("Tentando acessar um indice nao existente na lista. Metodo retornar.");
        }
        return (G)lista[indice];
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public Iterator<G> iterator() {
        return new MeuIterador();
    }

    @Override
    public String toString(){
        String s = "|";
        for(int i = 0; i < tamanho; i++){
            s += lista[i].toString()+"|";
        }
       return s;
    }
    
    private class MeuIterador<G> implements Iterator<G>{

        private int cursor;
        MeuIterador(){
            cursor = 0;
        }
        
        @Override
        public boolean hasNext() {
            if(cursor < tamanho){
                return true;
            }
            return false;
        }

        @Override
        public G next() {
            return (G)lista[cursor++];
        }
        
    }
}
