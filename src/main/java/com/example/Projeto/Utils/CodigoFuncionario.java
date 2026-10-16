package com.example.Projeto.Utils;
import java.util.Random;

public class CodigoFuncionario {

    public static String gerarCodigoComIniciais(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }

        String[] palavras = nomeCompleto.trim().split("\\s+");
        StringBuilder iniciais = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty() && !palavra.equalsIgnoreCase("da") && !palavra.equalsIgnoreCase("de")) {
                iniciais.append(palavra.charAt(0));
            }
        }

        // Limita o prefixo a 3 letras (caso a pessoa tenha 4 ou mais nomes)
        String prefixo = iniciais.length() > 3 ? iniciais.substring(0, 3) : iniciais.toString();
        prefixo = prefixo.toUpperCase();

        int quantidadeCaracteres = 0;
        StringBuilder caracteresAleatorios = new StringBuilder(quantidadeCaracteres);
        Random random = new Random();

        while((prefixo+caracteresAleatorios.toString()).length()<=5){
            char letra = (char) ('A' + random.nextInt(26));
            caracteresAleatorios.append(letra);
        }

        return prefixo + caracteresAleatorios.toString();
    }

    public static void main(String[] args) {
        System.out.println(gerarCodigoComIniciais("Heloisy Oliveira Mota"));
        System.out.println(gerarCodigoComIniciais("João Carlos Da Silva Valle"));
        System.out.println(gerarCodigoComIniciais("Maria da Silva"));
    }
    }

