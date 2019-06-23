/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

/**
 *
 * @author Marcos Mol
 */
public enum Tag {
    
    // fim de arquivo
    EOF,
    
    //Operadores
    RELOP_LT,       // <
    RELOP_OR,       //||
    RELOP_AND,      //&&
    RELOP_LE,       // <=
    RELOP_GT,       // >
    RELOP_GE,       // >=
    RELOP_EQ,       // ==
    RELOP_NE,       // !=
    RELOP_ASSIGN,   // =
    RELOP_SUM,      // +
    RELOP_MINUS,    // -
    RELOP_MULT,     // *
    RELOP_DIV,      // /
    RELOP_UNNE,     // -
    RELOP_UNESC,    //!
    
    //Simbolos
    SMB_OP,         // (
    SMB_CP,         // )
    SMB_OB,         // {
    SMB_CB,         // }
    SMB_COMMA,      // ,
    SMB_SEMICOLON,  // ;
    SMB_NULL,       // zerar auxnegativo
    
    //identificador
    ID,


    //numeros
    ConstInteira,
    INTEGER,
    FLOAT,
    ConstReal,
    
    //String em aspas simples
    //strings
    char_const,
	
    
    //String em aspas duplas
    STRING,
    ConstString,
    
   // palavra reservada
    KW_public,
    KW_class,
    KW_SystemOutDispln,
    KW_end,
    KW_integer,
    KW_string,
    KW_print,
    KW_println,
    KW_static,
    KW_return,
    KW_else,
    KW_while,
    KW_int,
    KW_float,
    KW_void,
    KW_boolean,
    KW_if,
    KW_main,
    KW;
    
      
}
