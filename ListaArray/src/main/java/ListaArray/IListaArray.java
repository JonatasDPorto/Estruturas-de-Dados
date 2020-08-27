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
public interface IListaArray<G> {
    public void adicionarNoInicio(G objeto);
    public void adicionarNoFinal(G objeto);
    public void adicionarPorIndice(G objeto, int indice);
    public void removerPorIndice(int indice);
    public void removerPorObjeto(G objeto);
    public G removerERetornar(int indice);
    public G retornar(int indice);
    public int tamanho();
    public Iterator<G> iterator();
}
