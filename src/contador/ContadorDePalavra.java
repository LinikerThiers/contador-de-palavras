package contador;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContadorDePalavra {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        String frase = ler.nextLine();

        //remove caracteres especiais por espaco em branco
        frase = frase.replaceAll("[,.:;!?'\u201C\u201D\"]", "").toLowerCase();

        //separa a string nos espaços em branco
        String[] palavras = frase.split("\\s+");

        Map<String, Integer> contagemDePalavras = new HashMap<>();

        for(String palavra : palavras) {
            contagemDePalavras.put(palavra, contagemDePalavras.getOrDefault(palavra,  0) + 1);
        }

        Set<Map.Entry<String, Integer>> entries = contagemDePalavras.entrySet();
        System.out.println("Contagem de palavras: ");
        for(Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        //Palavra mais repetida
        Integer qntdMaisCitada = Collections.max(contagemDePalavras.values());
        List<String> palavraMaisCitada = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue().equals(qntdMaisCitada)) {
                palavraMaisCitada.add(entry.getKey());
            }
        }

        //Palavra menos repetida
        Integer qntdMenosCitada = Collections.min(contagemDePalavras.values());
        List<String> palavraMenosCitada = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue().equals(qntdMenosCitada)) {
                palavraMenosCitada.add(entry.getKey());
            }
        }

        System.out.println("");
        System.out.println("Palavra(s) mais citada(s) com " + qntdMaisCitada + " ocorrência(s): ");
        palavraMaisCitada.forEach(System.out::println);


        System.out.println("");
        System.out.println("Palavra(s) menos citada(s) com " + qntdMenosCitada + " ocorrência(s): ");
        palavraMenosCitada.forEach(System.out::println);

        ler.close();
    }


}
