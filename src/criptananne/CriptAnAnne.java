package criptananne;

import java.util.Random;
import java.util.Scanner;

public class CriptAnAnne {

    /*
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean cont = true;
        while (cont) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a opção:\n 1 para criptografar\n 2 para descriptografar\n 3 para encerrar");
            int op = scan.nextInt();
            if (op == 1) {
                System.out.println("Digite o texto para ser criptografado: ");
                String texto = scanner.nextLine().toLowerCase();
                System.out.println("Digite a chave: ");
                int chave = scanner.nextInt();
                System.out.println("Texto Criptografado: " + Criptografar(texto, chave));
            }
            if (op == 2) {
                System.out.println("Digite o texto para ser descriptografado: ");
                String texto = scanner.nextLine().toLowerCase();
                System.out.println("Digite a chave: ");
                int chave = scanner.nextInt();
                System.out.println("Texto Plano: " + Descriptografar(texto, chave));
            }
            if (op == 3){
                cont = false;
            }
        }
    
    }
     */
    public static String Criptografar(String texto, int chave) {
        texto = texto.replaceAll(" ", "");

        for (int i = 0; i < chave; i++) {
            texto = TrocarLetras(texto);
            texto = EmbaralharLetras(texto, 3);
        }
        return texto.toUpperCase();
    }

    public static String Descriptografar(String texto, int chave) {
        texto = texto.replaceAll(" ", "");

        for (int i = 0; i < chave; i++) {
            texto = EmbaralharLetras(texto, 3);
            texto = VoltarLetras(texto);
        }

        return texto.toLowerCase();
    }

    public static String CompletarTexto(String texto, int falta) {
        String letras = "abcdefghijklmnopqrstuvwxyz";
        int index = 0;
        Random random = new Random();

        for (int i = 0; i < (falta); i++) {
            index = random.nextInt(letras.length());
            texto += letras.substring(index, index + 1);
        }
        return texto;
    }

    public static String TrocarLetras(String texto) {
        String novo = "";
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            int l = (int) (letra);
            int j = l;
            l += i + 1;
            if (j >= 97 && j <= 122) {
                while (l > 122) {
                    l -= 26;
                }
            }
            if (j >= 0 && j <= 9) {
                while (l > 9) {
                    l -= 10;
                }
            }

            letra = (char) (l);
            novo += letra;
        }
        return novo;
    }

    public static String VoltarLetras(String texto) {
        String novo = "";
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            int l = (int) (letra);
            int j = l;
            l -= i + 1;

            if (j >= 97 && j <= 122) {
                while (l < 97) {
                    l += 26;
                }
            }
            if (j >= 0 && j <= 9) {
                while (l < 0) {
                    l += 10;
                }
            }

            letra = (char) (l);
            novo += letra;
        }
        return novo;
    }

    public static String EmbaralharLetras(String texto, int chave) {
        String novo = "";

        if (texto.length() % chave != 0) {
            texto = CompletarTexto(texto, chave - (texto.length() % chave));
        }
        for (int i = 0; i < texto.length(); i += chave) {
            String pedaco = texto.substring(i, i + chave);
            pedaco = new StringBuilder(pedaco).reverse().toString();
            novo += pedaco;
        }

        return novo;
    }

}
