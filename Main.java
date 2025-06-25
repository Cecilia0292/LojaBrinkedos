import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<String> brinquedos = new ArrayList<>();
    static ArrayList<Double> precos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.print("--------Menu de Consulta de Brinquedos--------\n");
            System.out.println();
            System.out.print("1 - Cadastrar brinquedo\n");
            System.out.print("2 - Listar todos os brinquedos\n");
            System.out.print("3 - Mostrar o brinquedo mais caro\n");
            System.out.print("4 - Calcular a média de preço dos brinquedos\n");
            System.out.print("5 - Listar os brinquedos acima da média\n");
            System.out.print("6 - Remover um brinquedo pelo nome\n");
            System.out.print("7 - Atualizar preço de um brinquedo\n");
            System.out.print("8 - Exibir soma de todos os preços\n");
            System.out.print("0 - SAIR\n");

            System.out.println("---------------------------------------------\n");
            System.out.print("--> ");

            int opcao = 0;
            try {
                opcao = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite uma opção válida.");
                scan.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    cadastrarBrinquedo(scan);
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 2:
                    listarBrinquedos();
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 3:
                    mostrarBrinquedoMaisCaro();
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 4:
                    calcularMediaPrecos();
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 5:
                    listarAcimaDaMedia();
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 6:
                    System.out.println();
                    removerBrinquedo(scan);
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 7:
                    System.out.println();
                    atualizarPrecoBrinquedo(scan);
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 8:
                    exibirTotalPrecos();
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scan.nextLine();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        }
    }

    public static void cadastrarBrinquedo(Scanner scan) {
        try {
            System.out.println();
            System.out.print("Digite o nome do brinquedo: ");
            String brinquedo = scan.nextLine().trim();
            brinquedo = brinquedo.substring(0, 1).toUpperCase() + brinquedo.substring(1).toLowerCase();

            if (brinquedo.isEmpty()) {
                System.out.println("O nome do brinquedo não pode estar vazio!");
                return;
            }

            if (brinquedos.contains(brinquedo)) {
                System.out.println("Este brinquedo já está cadastrado!");
                return;
            }

            System.out.print("Digite o preço do brinquedo: R$");
            String precoString = scan.nextLine().replace(",", ".");
            double preco = 0;
            if (precoString.matches("^\\d+(\\.\\d*)?$")) {
                preco = Double.parseDouble(precoString);

                if (preco < 0) {
                    System.out.println("O preço do brinquedo não pode ser negativo!");
                    return;
                }
            } else {
                System.out.println("Entrada inválida! Digite um número válido, ex: 599.90");
                return;
            }

            brinquedos.add(brinquedo);
            precos.add(preco);
            System.out.println("Brinquedo cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Preço inválido! Digite um valor válido.");
            scan.nextLine();
        }
    }

    public static void listarBrinquedos() {
        if (brinquedos.isEmpty()) {
            System.out.println("Nenhum brinquedo cadastrado.");
        } else {
            System.out.println("---- LISTA DE BRINQUEDOS ----");
            for (int i = 0; i < brinquedos.size(); i++) {
                System.out.printf("%d - %s: R$ %.2f%n", i, brinquedos.get(i), precos.get(i));

            }
        }
    }

    public static void mostrarBrinquedoMaisCaro() {
        if (brinquedos.isEmpty()) {
            System.out.println("Nenhum briquedo cadastrado.");
            return;
        }

        double maiorPreco = precos.get(0);
        int indiceMaisCaro = 0;

        for (int i = 1; i < precos.size(); i++) {
            if (precos.get(i) > maiorPreco) {
                maiorPreco = precos.get(i);
                indiceMaisCaro = i;
            }
        }

        System.out.println("O brinquedo mais caro é:");
        System.out.printf("%s: R$ %.2f%n", brinquedos.get(indiceMaisCaro), maiorPreco);
    }

    public static void calcularMediaPrecos() {
        if (precos.isEmpty()) {
            System.out.println("Nenhum Brinquedo cadastrado.");
            return;
        }

        double soma = 0;
        for (double preco : precos) {
            soma += preco;
        }

        double media = soma / precos.size();
        System.out.printf("Média de preços: R$ %.2f%n", media);
    }

    public static void listarAcimaDaMedia() {
        if (precos.isEmpty()) {
            System.out.println("Nenhum briquedo cadastrado.");
            return;
        }

        double soma = 0;
        for (double preco : precos) {
            soma += preco;
        }
        double media = soma / precos.size();

        System.out.printf("Produtos com preço acima da média (R$ %.2f):%n", media);
        boolean encontrou = false;

        for (int i = 0; i < precos.size(); i++) {
            if (precos.get(i) > media) {
                System.out.printf("%s: R$ %.2f%n", brinquedos.get(i), precos.get(i));
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum brinquedo tem preço acima da média.");
        }
    }

    public static void removerBrinquedo(Scanner scan) {
        if (brinquedos.isEmpty()) {
            System.out.println("Nenhum brinquedo cadastrado.");
            return;
        }

        System.out.println("Brinquedos cadastrados:");
        System.out.println();
        for (int i = 0; i < brinquedos.size(); i++) {
            System.out.printf("%d - %s: R$ %.2f%n", i + 1, brinquedos.get(i), precos.get(i));
        }
        System.out.println();

        System.out.print("Digite o nome do brinquedo que deseja remover OU ENTER para voltar: ");
        scan.nextLine();
        String nome = scan.nextLine().trim();
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

        int indice = brinquedos.indexOf(nome);
        if (indice == -1) {
            System.out.println("Brinquedo não encontrado!");
            return;
        }
        brinquedos.remove(indice);
        precos.remove(indice);
        System.out.println("Brinquedo removido com sucesso!");
    }

    public static void atualizarPrecoBrinquedo(Scanner scan) {
        if (brinquedos.isEmpty()) {
            System.out.println("Nenhum brinquedo cadastrado.");
            return;
        }

        System.out.println("Brinquedos cadastrados:");
        System.out.println();
        for (int i = 0; i < brinquedos.size(); i++) {
            System.out.printf("%d - %s: R$ %.2f%n", i + 1, brinquedos.get(i), precos.get(i));
        }
        System.out.println();

        System.out.print("Digite o nome do brinquedo que deseja atualizar o preço: ");
        String nome = scan.nextLine().trim();
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

        int indice = brinquedos.indexOf(nome);
        if (indice == -1) {
            System.out.println("Brinquedo não encontrado!");
            return;
        }

        System.out.print("Digite o novo preço: ");
        try {
            double novoPreco = scan.nextDouble();
            scan.nextLine();

            if (novoPreco < 0) {
                System.out.println("O preço não pode ser negativo!");
                return;
            }

            precos.set(indice, novoPreco);
            System.out.println("Preço atualizado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Preço inválido! Digite um valor válido.");
            scan.nextLine();
        }
    }

    public static void exibirTotalPrecos() {
        if (precos.isEmpty()) {
            System.out.println("Nenhum Brinquedo cadastrado.");
            return;
        }
        double soma = 0;
        for (double preco : precos) {
            soma += preco;
        }
        System.out.println("O valor de todos os preços somados é de: R$ %.2f%n" + soma);
    }
}