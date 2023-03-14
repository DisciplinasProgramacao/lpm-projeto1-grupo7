import java.util.Scanner;

public class Main {

    public static Estoque criarEstoque() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a quantidade de armazenamento do estoque:");
        int quantidadeEstoque = scan.nextInt();
        System.out.println("");

        Estoque estoque = new Estoque(quantidadeEstoque);

        scan.close();

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

    public static void criarProduto(Estoque estoque) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do produto:");
        String produtoNome = scan.nextLine();
        System.out.print("\nDigite o preço de custo do produto:");
        double precoCusto = scan.nextDouble();
        System.out.print("\nDigite a margem de lucro do produto:");
        int margemDeLucro = scan.nextInt();
        System.out.print("\nDigite o minimo de produtos que pode ter em estoque:");
        int estoqueMinimo = scan.nextInt();

        Produto produto = new Produto(produtoNome, precoCusto, margemDeLucro, estoqueMinimo);

        estoque.Guardar(produto);
        System.out.println("Produto criado com sucesso!!!");
        scan.close();

    }

    public static void efetuarCompra(Estoque estoque) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do produto a ser comprado:");
        String nomeProduto = scan.nextLine();
        System.out.print("\nDigite a quantidade de produtos a serem comprados:");
        int quantidadeProdutosCompra = scan.nextInt();

        Produto produto = estoque.procurar(nomeProduto);

        if (produto != null) {
            produto.comprarProduto(quantidadeProdutosCompra);
            System.out.println("Compra do produto feita com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }

        scan.close();

    }

    public static void efetuarVenda(Estoque estoque) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do produto a ser vendido:");
        String nomeProduto = scan.nextLine();
        System.out.print("\nDigite a quantidade de produtos a serem vendidos:");
        int quantidadeProdutosVenda = scan.nextInt();

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

        scan.close();

    }

    public static void imprimeQuantideItensEstoque(Estoque estoque) {

        System.out.println("Quantidade de produtos no estoque é: " + estoque.quantidadeItensEstoque());
        
    }

    public static void imprimeValorEstoque(Estoque estoque) {

        System.out.println("Valor de custo total em estoque: " + estoque.valorTotalEmEstoque());
        
    }

    public static void imprimeProdutosAbaixoEstoque(Estoque estoque) {
        Produto produto = estoque.ProdutosAbaixoEstoqueMinimo();

        System.out.println("Produto abaixo do estoque mínimo: " + produto.getDescricao());
        
    }

    public static void imprimeProdutosDescricao(Estoque estoque) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do produto:");
        String nomeProduto = scan.nextLine();
            
        Produto produto = estoque.procurar(nomeProduto);

        if (produto != null) {
            produto.print();
        } else {
            System.out.println("Produto não encontrado");
        }
        scan.close();
        
    }

    public static void executarMenu(int num, Estoque estoque) throws Exception {

        switch (num) {
            case 1:
                criarProduto(estoque);
                break;
            case 2:
                efetuarCompra(estoque);
                break;
            case 3:
                efetuarVenda(estoque);
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
                imprimeProdutosDescricao(estoque);
                break;
            default:
                System.out.println("Saindo...");
                break;
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Estoque estoque = criarEstoque();

        exibirMenu();

        int numero = scanner.nextInt();
        
        executarMenu(numero, estoque);

        scanner.close();
    }
}
