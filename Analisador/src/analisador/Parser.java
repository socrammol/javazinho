/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Marcos Mol
 */

public class Parser extends ParsingTable {
    
    private final Lexer lexer;
    private Token token;
    //constantes para o semantico
   private static String const1 = "const_1";
   private static String const2 = "const_2";
   private static String const3 = "const_3";
   private static String const4 = "const_4";
   private static String const5 = "const_5";
   private static String const6 = "const_6";
   private static String const7 = "const_7";
   private static String const8 = "const_8";
   private static String const9 = "const_9";
   private static String const10 = "const_10";
   private static String const11 = "const_11";
   private static String const12 = "const_12";
   private static String const13 = "const_13";
   private static String const14 = "const_14";
   private static String const15 = "const_15";
   private static String const16 = "const_16";
   private static String const17 = "const_17";
   private static String const18 = "const_18";
   private static String const19 = "const_19";
   private static String const20 = "const_20";
   private static String const21 = "const_21";
   private static String const22 = "const_22";
   private static String const23 = "const_23";
   private static String const24 = "const_24";
   private static String const25 = "const_25";
   private static String const26 = "const_26";
   private static String const27 = "const_27";
   private static String const28 = "const_28";
   private static String const29 = "const_29";
   private static String const30 = "const_30";
   private static String const31 = "const_31";
   private static String const32 = "const_32";
    private String resultadoParser = "";
    private String top;
    private javax.swing.JTextArea textArea3;
    private Stack<String> pilha = new Stack<>();
    private ArrayList<Tag> tagsSincronizantes;
    public boolean synch = false;
    public boolean skip = false;
    
    public int qtdErrosSintaticos = 0;
    
    public Parser(Lexer lexer, javax.swing.JTextArea txA3){
        this.lexer = lexer;
        this.token = lexer.proxToken();
        this.textArea3 = txA3;
        tagsSincronizantes = new ArrayList<Tag>();
    }
    
    // Parser Não Recursivo
    public void nonRecursiveParser(){
        
//        push(token.getLexema());
        push("Programa");
        
        top = null;
        
        do{
            
            // Somente desempilha o elemento do TOPO se skip for false 
            // Porque ai somente avança a entrada 
            if(skip == false){
               top = pop();
               
            }
            
            getTokenByRegra(top, token);
            
            if(isNonTerminal(top)){
                String rule = this.getRegra(top, token.getLexema());
                this.pushRegra(rule);
            } else if(isTerminal(top)){
                if(!top.equals(token.getLexema())){ 
                    resultadoParser += "Erro Sintático (Skip): Token Inesperado: ( " + token.getLexema() + " ) " + "\n";
                    getNextToken();
                    skip = true;
                }else{
                    skip = false;
                    System.out.println("Matching terminal: ( " + token.getLexema() + " )");
                    resultadoParser += "Matching terminal: ( " + token.getLexema() + " )\n";
                    getNextToken();
                    textArea3.setText(resultadoParser);   
                }
            }
            
            if(token.getLexema().equals("EOF")){
                resultadoParser += "Matching terminal: ( " + token.getLexema() + " )\n";
                textArea3.setText(resultadoParser);
                break; // Fim da análise sintática
            }

//      Contador de Erros Sintáticos (Se maior que 5, para a análise)            
            if(qtdErrosSintaticos == 5){
                break; // Encerra a análise sintática
            }
            
            
        } while(true);
        
        
    }
    
    //  Alterando o Lexema caso o TOKEN case com o topo pra avanço da entrada
    //  (Exemplo: se lexema for "varchar", logo, lexema é um id, para comparação
    /*
        Topo da Pilha:
        'literal' para qualquer ASCII entre aspas duplas
        'id' para qualquer palavra começando com letra seguido de letra ou número
        'num_const' para qualquer número (double ou inteiro)
        'char_const' para qualquer caractere ASCII entre aspas simples    
    */
    
    public void getTokenByRegra(String top, Token token){
        
        switch (token.getClasse()) {
            case ID:
                token.setLexema("ID");
                break;
            case STRING:
                token.setLexema("ConstString");
                break;
            case INTEGER:         
                token.setLexema("ConstInteira");
                break;
            case FLOAT:
                token.setLexema("ConstReal");
                break;
            case ConstString:
                token.setLexema("ConstString");
                break;
            default:
                break;
        }
        
    }
    
    // Empilha regra da gramática na pilha (ao inverso)
    private void pushRegra(String regra){
        String[] splitRegra;
        //ArrayList<String> Aux = new ArrayList<String> ;
        switch (regra){
            case "public class ID { ListaMetodo Main }":
                splitRegra = regra.split("\\s+");
                List lista = Arrays.asList(splitRegra);
                ArrayList Aux = new ArrayList(lista);
                Aux.add(3,const1);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
                break;
            case "Tipo ID":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(2,const2);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
                break;
            case "Tipo ID ( RegexListaParam ) { RegexDeclaraVar ListaCmd Retorno }":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(2,const3);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
                break;
            case "return Expressao;":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(2,const4);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
                break;
            case "ε":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const5);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
                break;
            case "boolean":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const6);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
                break;
            case "int":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const7);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "string":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const8);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "float":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const9);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "void":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const10);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "CmdAtrib":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const11);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "CmdMetodo":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const11);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "Exp1 Exp’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(2,const12);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "&& Exp1 Exp’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(3,const13);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "|| Exp1 Exp’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(3,const13);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "ID Cmd’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(2,const14);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "Exp2 Exp1’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(2,const15);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "< Exp2 Exp1’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(3,const16);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "<= Exp2 Exp1’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(4,const16);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case ">":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(1,const16);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case ">= Exp2 Exp1’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(4,const16);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "== Exp2 Exp1’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(4,const16);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "!= Exp2 Exp1’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(4,const16);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "Exp3 Exp2’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(2,const17);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "+ Exp3 Exp2’":
                splitRegra = regra.split("\\s+");
                lista = Arrays.asList(splitRegra);
                Aux = new ArrayList(lista);
                Aux.add(3,const18);
                splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "- Exp3 Exp2":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(3,const18);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "Exp4 Exp3’":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(2,const19);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "* Exp4 Exp3’":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(3,const20);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "/ Exp4 Exp3’":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(3,const21);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break; 
            case "ID Exp4’":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(2,const22);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break; 
            case "ConstInteira":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(1,const23);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break; 
            case "ConstReal":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(1,const24);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break; 
            case "ConstString":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(1,const25);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "true":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(1,const26);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "false":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(1,const27);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "OpUnario Expressao":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(2,const28);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "( Expressao )":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(2,const29);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "( RegexExp4 )":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(3,const30);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "-":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(1,const31);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            case "!":
               splitRegra = regra.split("\\s+");
               lista = Arrays.asList(splitRegra);
               Aux = new ArrayList(lista);
               Aux.add(1,const32);
               splitRegra=(String[])Aux.toArray(new String[Aux.size()]);
               resultadoParser += regra + "\n";
               break;
            default:
            
                // Divide a string contendo a regra em um array
                splitRegra = regra.split("\\s+");
                // Saída completa /* (DESCOMENTAR LINHA ABAIXO)*/
                resultadoParser += regra + "\n";
                    break;
        }
        

                // Divide a string contendo a regra em um array
               // String[] splitRegra = regra.split("\\s+");

                // Saída completa /* (DESCOMENTAR LINHA ABAIXO)*/
                //resultadoParser += regra + "\n";

        for(int i = splitRegra.length - 1; i >= 0; i--){
            
            String regraAt = splitRegra[i];
//            System.out.println("regra:" + Arrays.toString(splitRegra) );
            push(regraAt);
        }
        
    }
    
    // Verifica se elemento do topo é um terminal
    private boolean isTerminal(String s){
        
        for (String terminal : terminals) {
            if (s.equals(terminal)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Verifica se elemento do topo é um não-terminal
    private boolean isNonTerminal(String s){
        
        for (String nonTerminal : nonTerminals) {
            if (s.equals(nonTerminal)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Advance
    // Recebe o próximo Token
    private String getNextToken(){
        
        token = lexer.proxToken();
        String tokenLexema = token.getLexema();
        
        return tokenLexema;
        
    }
   
    // Empilha elemento no topo da pilha
    private void push(String s){
        this.pilha.push(s);
//        System.out.println("regra:" + s);
        
    }
    
    // Desempilha elemento do topo
    private String pop(){
        System.out.println("regra1:" + this.pilha);
        String s = this.pilha.lastElement();
        switch(s) {
            case "const_1":
                
            break;
        }
        return this.pilha.pop();
    
    }
    
    
    // Exibe mensagem de erro
    private void exibeErro(String message){
        resultadoParser += message + "\n";
        System.out.println(resultadoParser);
        textArea3.setText(resultadoParser);
    }
    
    // Recupera a regra da tabela conforme o index[nonTerm][term]
    private String getRegra(String nonTerminal, String terminal){
        
        int row = getNonTerminalIndex(nonTerminal);
        int column = getTerminalIndex(terminal);
        
        String regra = preditiveTable[row][column];
        
        switch (regra) {
            case "synch":
                exibeErro("Erro Sintático (Synch): Token Inesperado: ( " + token.getLexema() + " ) ");
                qtdErrosSintaticos++;
                top = pop();
                String rule = this.getRegra(top, token.getLexema());
                this.pushRegra(rule);
                skip = false;
                break;
            case "skip":
                exibeErro("Erro Sintático (Skip): Token Inesperado: ( " + token.getLexema() + " ) ");
                qtdErrosSintaticos++;
                getNextToken();
                skip = true;
                break;
            default:
                skip = false;
                break;
        }
        
        return regra;
    }
    
    // Recupera o index do não terminal de interesse
    private int getNonTerminalIndex(String nonTerminal){
                
        for(int i = 0; i < nonTerminals.length; i++){
            if(nonTerminal.equals(nonTerminals[i])){
                return i;
            }
        }
        
        exibeErro(nonTerminal + " não é um nonTerminal");
        
        return -1;
    }
    
    // Recupera o index do terminal de interesse
    private int getTerminalIndex(String terminal){
        
        for(int i = 0; i < terminals.length; i++){
            if(terminal.equals(terminals[i])){
                return i;
            }
        }
        
        exibeErro(terminal + " não é um Terminal");
        
        return -1;
    }
    
}


