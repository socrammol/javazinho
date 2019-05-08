package lexer;

/**
 *
 * @author Marcos Mol
 */
public class Compiladores {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      
      LexerAluno lexer = new LexerAluno("testeJavinha.jvn");
      Parser parser = new Parser(lexer);

      // primeiro procedimento do Javinha: Programa()
      //parser.Programa();

      //parser.fechaArquivos();
      
      //Imprimir a tabela de simbolos
      lexer.printTS();

      System.out.println("Compilação de Programa Realizada!");
   }
   
}
