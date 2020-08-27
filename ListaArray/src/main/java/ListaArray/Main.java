/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaArray;
/**
 *
 * @author Jonatas Dourado Porto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListaArray<String> lista = new ListaArray();
        
        lista.adicionarPorIndice("a", 0);
        System.out.println("Adicionando 'a' por indice ->"+lista);
        
        lista.adicionarNoInicio("b");
        System.out.println("Adicionando 'b' no inicio ->"+lista);
        
        lista.adicionarNoFinal("c");
        System.out.println("Adicionando 'c' no final ->"+lista);
        
        String retorno = lista.retornar(0);
        System.out.println("Retornando item na posicao '0' ->"+retorno);
        
        int tamanho = lista.tamanho();
        System.out.println("Retornando o tamanho da lista ->"+tamanho);
       
        System.out.println("Demostrando o iterator.");
        for (String string : lista) {
            System.out.println(string);
        }
        
        String remover = lista.removerERetornar(0);
        System.out.println("Removendo e retornando o item na posicao 0 ->"+remover);
        
        lista.removerPorIndice(0);
        System.out.println("Removendo item na posicao 0 ->"+lista);
        
        lista.removerPorObjeto("c");
        System.out.println("Removendo o obejto 'c' ->"+lista);
        
    }
    
}
