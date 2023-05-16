public class VerificadorExpressao {

    public static boolean verificarExpressao(String expressao) {
        int tamanho = expressao.length();
        int abertos = 0;

        for (int i = 0; i < tamanho; i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                abertos++;
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                abertos--;

                if (abertos < 0 || !verificarPar(expressao.charAt(i - abertos - 1), caractere)) {
                    return false;
                }
            }
        }

        return abertos == 0;
    }

    private static boolean verificarPar(char aberto, char fechado) {
        return (aberto == '(' && fechado == ')') ||
               (aberto == '[' && fechado == ']') ||
               (aberto == '{' && fechado == '}');
    }

    public static void main(String[] args) {
        String expressao1 = "x+y*(3+z)";
        String expressao2 = "x+y*(3+";

        System.out.println(expressao1 + " está correta: " + verificarExpressao(expressao1));
        System.out.println(expressao2 + " está correta: " + verificarExpressao(expressao2));
    }
}
