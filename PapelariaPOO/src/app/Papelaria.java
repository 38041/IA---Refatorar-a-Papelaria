package app;

import model.ItemPedido;

public class Papelaria {

    private static final double VALOR_MINIMO_FRETE_GRATIS = 150.0;
    private static final double VALOR_FRETE = 12.90;

    // a) O bloco repetido era o cálculo do bruto, do desconto e do líquido,
    //    junto com a impressão de cada item.
    // b) As variáveis numeradas eram descricao1...4, valor1...4, qtd1...4,
    //    kit1...4, bruto1...4, abatimento1...4 e liquido1...4.
    // c) Os números mágicos eram 0.15 (15% para kit), 0.08 (8% por quantidade),
    //    10 (quantidade mínima), 150.0 (frete grátis) e 12.90 (valor do frete).
    //    Agora essas regras usam constantes. Os preços são dados dos produtos.

    public static double calcularFrete(double valorItens) {
        if (valorItens >= VALOR_MINIMO_FRETE_GRATIS) {
            return 0.0;
        }
        return VALOR_FRETE;
    }

    public static void main(String[] args) {
        System.out.println("=== PAPELARIA PONTO FINAL ===\n");

        ItemPedido[] itens = {
                new ItemPedido("Caderno 10 materias", 24.90, 1, false),
                new ItemPedido("Lapis grafite", 1.50, 12, false),
                new ItemPedido("Kit escolar basico", 84.00, 1, true),
                new ItemPedido("Caneta azul", 2.80, 10, false)
        };

        double soma = 0.0;
        for (ItemPedido item : itens) {
            item.exibirLinha();
            soma += item.calcularValorLiquido();
        }

        double frete = calcularFrete(soma);
        System.out.printf("%nItens:  R$ %.2f%n", soma);
        System.out.printf("Frete:  R$ %.2f%n", frete);
        System.out.printf("Total do pedido: R$ %.2f%n", soma + frete);
    }
}
