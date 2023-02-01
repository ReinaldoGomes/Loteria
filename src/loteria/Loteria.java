package loteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Loteria {

    private String nome;  // de acordo com o UML
    private Integer quantidade_dezenas; // de acordo com o UML

    //Relacionamento loteria tem varias dezenas:
    private List<Dezena> dezenas;


    public void cadastrar(String nome, Integer quantidade_dezenas) {

        this.nome = nome;
        this.quantidade_dezenas = quantidade_dezenas;

    }


    public Boolean realizar_combinacao(Integer qtde) {
        return null;
    }

    public void imprimir_combinacao(List dezenas) {

    }

    //Contrutores para Dezenas com atributos
    public Loteria(List<Dezena> dezenas) {
        this.dezenas = dezenas;
    }


    //Getter and Setter para Dezenas:


    public List<Dezena> getDezenas() {
        return dezenas;
    }

    public void setDezenas(List<Dezena> dezenas) {
        this.dezenas = dezenas;
    }

    //Construtores com atributos:

    public Loteria(String nome, Integer quantidade_dezenas) {
        this.nome = nome;
        this.quantidade_dezenas = quantidade_dezenas;
    }

    // Construtores SEM atributos:

    public Loteria() {
    }


    // 2 passo print os atributos que será executado no main:

    public void print() {
        System.out.println("nome:" + this.nome);
        System.out.print("quantidade de dezenas" + this.quantidade_dezenas);


    }
    // Getter and Setter:

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade_dezenas() {
        return quantidade_dezenas;
    }

    public void setQuantidade_dezenas(Integer quantidade_dezenas) {
        this.quantidade_dezenas = quantidade_dezenas;
    }

    public static void main(String[] args) {

        new Loteria().generate(10, 4).stream().forEach(e -> System.out.println(Arrays.toString(e)));
    }

    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }

    private void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

  }
