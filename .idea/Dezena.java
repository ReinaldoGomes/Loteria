package br.com.unitins.programas;


import java.util.ArrayList;


public class Dezena {

    private Integer numero;

    public void cadastrar(Integer numero) {
         this.numero= numero;
    }
    // Set = conjunto add() : boolean -> true / false

    //Relacionamento dezena tem apenas uma loteria:

    //contrutor para loteria com atributos:
//Construtores com atributos:

    public Dezena(Integer numero) {
        this.numero = numero;
    }

    //Construtores SEM atributos:

    public Dezena() {
    }

    //Getter and Setter PARA LOTERIA:



    //2 passo print os atributos:

    // public void print() {
    //    System.out.println("numero" + this.numero);
    //  System.out.print("Loteria" + this.loteria);
    // }


    //Getter and Setter:

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer dezena) {
        this.numero = dezena;
    }
}
