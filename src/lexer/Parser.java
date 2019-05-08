/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Stack;

/**
 *
 * @author Marocs Mol
 */

public class Parser extends ParsingTable {
    
    private final LexerAluno lexer;
    private Token token;
    private String resultadoParser = "";
    private String top;
    private javax.swing.JTextArea textArea3;
    private Stack<String> pilha = new Stack<>();
    
    public boolean synch = false;
    public boolean skip = false;
    
    public int qtdErrosSintaticos = 0;
    
    public Parser(LexerAluno lexer){
        this.lexer = lexer;
        this.token = lexer.proxToken();
    }
    
    // Parser Não Recursivo
    public void nonRecursiveParser(){
        
//        push(token.getLexema());
        push("prog");
        
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
                token.setLexema("id");
                break;
            case STRING:
                token.setLexema("string");
                break;
            case INTEGER:         
                token.setLexema("int");
                break;
            default:
                break;
        }
        
    }
    
    // Empilha regra da gramática na pilha (ao inverso)
    private void pushRegra(String regra){
        
        // Divide a string contendo a regra em um array
        String[] splitRegra = regra.split("\\s+");
        
        // Saída completa /* (DESCOMENTAR LINHA ABAIXO)*/
        resultadoParser += regra + "\n";
        
        for(int i = splitRegra.length - 1; i >= 0; i--){
            String regraAt = splitRegra[i];
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
    }
    
    // Desempilha elemento do topo
    private String pop(){
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
   


