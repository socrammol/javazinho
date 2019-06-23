package analisador;
import java.util.Collections;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class No {

    // Atributos da classe No
    private Token pai;
    private final ArrayList<No> listaFilhos;
    private static int espaco = 0;

    // Constantes para tipos
    public static Integer TIPO_VAZIO	= 111;
    public static Integer TIPO_BOOLEAN  = 100;
    public static Integer TIPO_INT      = 101;
    public static Integer TIPO_STRING	= 102;
    public static Integer TIPO_DOUBLE	= 103;
    public static Integer TIPO_ERRO	= 104;
    
    public int tipo = TIPO_VAZIO;
    

    public No(Token token) {
        this.pai = token;
        this.listaFilhos = new ArrayList<>();
    }

    public Token getPai() {
        return pai;
    }
    
    public void setPai(Token token) {
        this.pai = token;
    }

    public ArrayList<No> getFilhos() {
        return listaFilhos;
    }

    public void addTodos(ArrayList<No> listaFilhos) {
        this.listaFilhos.addAll(listaFilhos);
    }

    public void addFilho(No filho) {
        this.listaFilhos.add(filho);
    }

    // metodo nao necessario para o TP3: Apenas para visualizacao da arvore anotada
    public void imprimeConteudo() {
        if(this.pai != null) {
            for(int i = 0; i < espaco; i++) {
                System.out.print(".   ");
            }
            System.out.print(this.pai.toString() + " - Tipo: " + this.tipo + "\n");
            espaco++;
        }
        for(No filho : listaFilhos) {
            filho.imprimeConteudo();
        }
        if (this.pai != null) {
            espaco--;
        }
    }
}
