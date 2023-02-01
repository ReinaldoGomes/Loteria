package loteria;

import java.util.*;
import java.util.stream.Collectors;


public class AssociacaoLoteria {
    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);


        //Imput loteria.Loteria:

        System.out.println("informe o nome da loteria");
        String nome = teclado.next();

        System.out.println("informe a quantidade de dezenas");
        Integer quantidade_dezenas = teclado.nextInt();


        Loteria loteria = new Loteria();
        loteria.cadastrar(nome, quantidade_dezenas); //o atributo vai para a classe loteria.Loteria

        System.out.println("digite as dezenas possiveis a serem sorteada");
        //Imput Dezenas cadastrar
        Set<Integer> dezenas = selecionarDezenas(teclado, loteria, false);

        List<Dezena> dezenasList = dezenas.stream()
                .map(Dezena::new)
                .collect(Collectors.toList());

        loteria.setDezenas(dezenasList);

        //Realizar combinacoes:

        System.out.println("informe a quantidade de combincoes");
        Integer quantidade_combinacoes = teclado.nextInt();

        System.out.println("deseja escolher dezenas para constar na combinação?\n1-Sim\n2-Não");
        Integer escolher_combinacoes = teclado.nextInt();

        Set<Integer> dezenasObrigatorias = null;
        if (escolher_combinacoes.equals(1)) {

            dezenasObrigatorias = selecionarDezenas(teclado, loteria, false);



        }

        Set<Integer> dezenasCombinacoes = selecionarDezenas(teclado, loteria, true);

        if (dezenasCombinacoes.size() < loteria.getQuantidade_dezenas()) {

            for (int i = dezenasCombinacoes.size(); i < loteria.getQuantidade_dezenas(); i++) {
                dezenasCombinacoes.add(new Random().nextInt());
            }

        }

        int min = loteria.getDezenas().stream().mapToInt(Dezena::getNumero).min().getAsInt();
        int max = loteria.getDezenas().stream().mapToInt(Dezena::getNumero).max().getAsInt();

        List<int[]> combinacoes = generate(min, max);

        Set<Integer> constar = dezenasObrigatorias;
        combinacoes.stream().map(Arrays::asList).filter(e -> e.containsAll(constar)).reduce(new ArrayList<int[]>(), (a, b) -> a.addAll(b));

    }

    private static Set<Integer> selecionarDezenas(Scanner teclado, Loteria loteria, boolean interromper) {
        Set<Integer> dezenas = new HashSet<>();
        for (int i = 0; i < loteria.getQuantidade_dezenas(); i++) {

            System.out.println("dezena " + i + " de " + loteria.getQuantidade_dezenas());
            Integer numero = teclado.nextInt();

            boolean adicionado = dezenas.add(numero);

            while (!adicionado) {
                System.out.println("[ERRO] Número já cadastrado, tente novamente");
                numero = teclado.nextInt();
                adicionado = dezenas.add(numero);
            }

            if (interromper) {
                System.out.println("deseja finalizar sua escolha?\n1-Sim\n2-Não");
                Integer escolha = teclado.nextInt();

                if (escolha.equals(1)) {
                    break;
                }

            }
        }
        return dezenas;
    }

    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }

    private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
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
