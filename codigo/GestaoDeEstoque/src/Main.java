import java.util.Scanner;

public class Main {

    public static Estoque criarEstoque(Scanner scanner) {
        System.out.print("Digite a quantidade de armazenamento do estoque:");
        int quantidadeEstoque = scanner.nextInt();
        System.out.println("");

        Estoque estoque = new Estoque(quantidadeEstoque);

        return estoque;

    }

    public static void exibirMenu() {
        System.out.println("#############################################################");
        System.out.println("Para:");
        System.out.println("1) Criar produto.\n");
        System.out.println("2) Efetuar compra.\n");
        System.out.println("3) Efetuar venda.\n");
        System.out.println("4) Quantidade produtos estoque.\n");
        System.out.println("5) Valor total do estoque.\n");
        System.out.println("6) Imprimir produtos abaixo do estoque.\n");
        System.out.println("7) Imprimir produtos por descricao/nome.\n");
        System.out.println("8) Sair.\n");
        System.out.println("#############################################################");
        System.out.println("Digite qual deseja executar:");
    }

    public static void criarProduto(Estoque estoque, Scanner scanner) throws Exception {
        System.out.print("Digite o nome do produto:");
        scanner.nextLine();
        String produtoNome = scanner.nextLine();
        System.out.print("\nDigite o preço de custo do produto:");
        double precoCusto = scanner.nextDouble();
        System.out.print("\nDigite a margem de lucro do produto:");
        int margemDeLucro = scanner.nextInt();
        System.out.print("\nDigite o minimo de produtos que pode ter em estoque:");
        int estoqueMinimo = scanner.nextInt();

        try {
            Produto produto = new Produto(produtoNome, precoCusto, margemDeLucro, estoqueMinimo);

            estoque.Guardar(produto);
            System.out.println("Produto criado com sucesso!!!");
        } catch (Exception e) {
            System.out.println(e);

            System.out.println("Produto não criado !!! Insira uma margem de lucro válida");
        }

    }

    public static void efetuarCompra(Estoque estoque, Scanner scanner) {

        System.out.print("Digite o nome do produto a ser comprado:");
        scanner.nextLine();
        String nomeProduto = scanner.nextLine();
        System.out.print("\nDigite a quantidade de produtos a serem comprados:");
        int quantidadeProdutosCompra = scanner.nextInt();

        Produto produto = estoque.procurar(nomeProduto);

        if (produto != null) {
            produto.comprarProduto(quantidadeProdutosCompra);
            System.out.println("Compra do produto feita com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }

    }

    public static void efetuarVenda(Estoque estoque, Scanner scanner) {

        System.out.print("Digite o nome do produto a ser vendido:");
        scanner.nextLine();
        String nomeProduto = scanner.nextLine();
        System.out.print("\nDigite a quantidade de produtos a serem vendidos:");
        int quantidadeProdutosVenda = scanner.nextInt();

        Produto produto = estoque.procurar(nomeProduto);

        if (produto != null) {
            try {
                produto.venderProduto(quantidadeProdutosVenda);
                System.out.println("Venda do produto feita com sucesso");
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            System.out.println("Produto não encontrado");
        }

    }

    public static void imprimeQuantideItensEstoque(Estoque estoque) {

        System.out.println("Quantidade de produtos no estoque é: " + estoque.quantidadeItensEstoque());

    }

    public static void imprimeValorEstoque(Estoque estoque) {
        String saida = String.format("Valor de custo total em entoque:R$%.2f", estoque.valorTotalEmEstoque());
        System.out.println(saida);
        
    }

    public static void imprimeProdutosAbaixoEstoque(Estoque estoque) {
        if (estoque.ProdutosAbaixoEstoqueMinimo() != null) {
            Produto[] produto = estoque.ProdutosAbaixoEstoqueMinimo();
            for (int i = 0; i < produto.length; i++) {
                if (produto[i] != null) {
                    System.out.println("Produto abaixo do estoque mínimo: " + produto[i].getDescricao());
                } else {
                    System.out.println("Nenhum produto abaixo do estoque minimo!");
                }
            }

        } else {
            System.out.println("Nenhum produto abaixo do estoque minimo!");
        }

    }

    public static void imprimeProdutosDescricao(Estoque estoque, Scanner scanner) {
        System.out.print("Digite o nome do produto:");
        scanner.nextLine();
        String nomeProduto = scanner.nextLine();

        Produto produto = estoque.procurar(nomeProduto);

        if (produto != null) {
            System.out.println(produto.print());
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public static void executarMenu(int num, Estoque estoque, Scanner scanner) throws Exception {
        while (num != 8) {

            switch (num) {
                case 1:
                    criarProduto(estoque, scanner);
                    break;
                case 2:
                    efetuarCompra(estoque, scanner);
                    break;
                case 3:
                    efetuarVenda(estoque, scanner);
                    break;
                case 4:
                    imprimeQuantideItensEstoque(estoque);
                    break;
                case 5:
                    imprimeValorEstoque(estoque);
                    break;
                case 6:
                    imprimeProdutosAbaixoEstoque(estoque);
                    break;
                case 7:
                    imprimeProdutosDescricao(estoque, scanner);
                    break;
                case 8:

                    break;
                default:
                    System.out.println("Entrada Inválida");
                    break;
            }
            exibirMenu();
            num = scanner.nextInt();
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Estoque estoque = criarEstoque(scanner);

        exibirMenu();

        int numero = scanner.nextInt();

        executarMenu(numero, estoque, scanner);

        scanner.close();
    }
}
