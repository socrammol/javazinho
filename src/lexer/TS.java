/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author gustavo
 */
public class TS {
    
    private HashMap<String, Token> tabelaSimbolos; // Tabela de símbolos do ambiente

    public TS() {
        tabelaSimbolos = new HashMap();

        // Inserindo as palavras reservadas
        Token word;
        word = new Token(Tag.KW, "public", 0, 0);
        this.tabelaSimbolos.put("public", word);
        
        word = new Token(Tag.KW, "class", 0, 0);
        this.tabelaSimbolos.put("class", word);
        
        word = new Token(Tag.KW, "print", 0, 0);
        this.tabelaSimbolos.put("print", word);
        
        word = new Token(Tag.KW, "println", 0, 0);
        this.tabelaSimbolos.put("println", word);
        
        word = new Token(Tag.KW, "int", 0, 0);
        this.tabelaSimbolos.put("int", word);

        word = new Token(Tag.KW, "float", 0, 0);
        this.tabelaSimbolos.put("float", word);
        
        word = new Token(Tag.KW, "string", 0, 0);
        this.tabelaSimbolos.put("string", word);
        
        word = new Token(Tag.KW, "boolean", 0, 0);
        this.tabelaSimbolos.put("boolean", word);
        
        word = new Token(Tag.KW, "static", 0, 0);
        this.tabelaSimbolos.put("static", word);
        
        word = new Token(Tag.KW, "void", 0, 0);
        this.tabelaSimbolos.put("void", word);
        
        word = new Token(Tag.KW, "main", 0, 0);
        this.tabelaSimbolos.put("main", word);
        
        word = new Token(Tag.KW, "return", 0, 0);
        this.tabelaSimbolos.put("return", word);
        
        word = new Token(Tag.KW, "while", 0, 0);
        this.tabelaSimbolos.put("while", word);
        
        word = new Token(Tag.KW, "if", 0, 0);
        this.tabelaSimbolos.put("if", word);
        
        word = new Token(Tag.KW, "else", 0, 0);
        this.tabelaSimbolos.put("else", word);
        
        word = new Token(Tag.KW, "true", 0, 0);
        this.tabelaSimbolos.put("true", word);
        
        word = new Token(Tag.KW, "false", 0, 0);
        this.tabelaSimbolos.put("false", word);
    }
    
    public void put(String s, Token w) {
        tabelaSimbolos.put(s, w);
    }

    // Pesquisa na tabela de símbolos se há algum token com determinado lexema
    // vamos usar esse metodo somente para diferenciar ID e KW
    public Token retornaToken(String lexema) {
		  Token token = tabelaSimbolos.get(lexema); 
		  return token;   	
    }
    
    @Override
    public String toString() {
        String saida = "";
        int i = 1;
        
        for(Map.Entry<String, Token> entry : tabelaSimbolos.entrySet()) {
            saida += ("posicao " + i + ": \t" + entry.getValue().toString()) + "\n";
            i++;
        }
        return saida;
    }
}