/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author gustavo
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
    
    
    //identificador
    ID,
    
    //numeros
    INTEGER,
    FLOAT,
    
    //strings
    STRING,
    
    // palavra reservada
    KW;
}
