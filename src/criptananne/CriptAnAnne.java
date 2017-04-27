package criptananne;

import java.util.Random;
import java.util.Scanner;

public class CriptAnAnne {

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

    public static String Criptografar(String tPlano, int chave) {
        String texto = "";
        tPlano = tPlano.replaceAll(" ", "");

        if (tPlano.length() % chave != 0) {
            tPlano += CompletarTexto(texto, chave - (tPlano.length() % chave));
        }
        for (int i = 0; i < tPlano.length(); i += chave) {
            String pedaco = tPlano.substring(i, i + chave);
            pedaco = new StringBuilder(pedaco).reverse().toString();
            //System.out.println("Pedaco: " + pedaco);
            texto += pedaco;
        }

        return texto.toUpperCase();
    }

    public static String CompletarTexto(String texto, int falta) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
        int index = 0;
        Random random = new Random();

        for (int i = 0; i < (falta); i++) {
            index = random.nextInt(letras.length());
            texto += letras.substring(index, index + 1);
        }
        return texto;
    }

    public static String Descriptografar(String cript, int chave) {
        return Criptografar(cript, chave).toLowerCase();
    }

}
