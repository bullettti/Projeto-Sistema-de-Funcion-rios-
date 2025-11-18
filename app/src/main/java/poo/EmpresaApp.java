package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpresaApp {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GERENCIAMENTO DE FUNCIONÁRIOS   ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println();

        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    cadastrarGerente();
                    break;
                case 3:
                    cadastrarEstagiario();
                    break;
                case 4:
                    exibirTodosFuncionarios();
                    break;
                case 5:
                    exibirEstatisticas();
                    break;
                case 6:
                    demonstracaoCompleta();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n✓ Sistema encerrado com sucesso!");
                    break;
                default:
                    System.out.println("\n✗ Opção inválida! Tente novamente.");
            }

            if (continuar && opcao != 6) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║                  MENU PRINCIPAL               ║");
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.println("║  1 - Cadastrar Funcionário Padrão             ║");
        System.out.println("║  2 - Cadastrar Gerente                        ║");
        System.out.println("║  3 - Cadastrar Estagiário                     ║");
        System.out.println("║  4 - Exibir Todos os Funcionários             ║");
        System.out.println("║  5 - Exibir Estatísticas                      ║");
        System.out.println("║  6 - Demonstração Completa (Dados Exemplo)    ║");
        System.out.println("║  0 - Sair                                     ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.print("\nEscolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║          CADASTRO DE FUNCIONÁRIO              ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF (apenas números): ");
            String cpf = scanner.nextLine();

            System.out.print("Salário Base: R$ ");
            double salario = Double.parseDouble(scanner.nextLine());

            Funcionario funcionario = new Funcionario(nome, cpf, salario);
            funcionarios.add(funcionario);

            System.out.println("\n✓ Funcionário cadastrado com sucesso!");
            funcionario.exibirDados();

        } catch (Exception e) {
            System.out.println("\n✗ Erro: " + e.getMessage());
        }
    }

    private static void cadastrarGerente() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║             CADASTRO DE GERENTE               ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF (apenas números): ");
            String cpf = scanner.nextLine();

            System.out.print("Salário Base: R$ ");
            double salario = Double.parseDouble(scanner.nextLine());

            System.out.print("Bônus Anual: R$ ");
            double bonus = Double.parseDouble(scanner.nextLine());

            Gerente gerente = new Gerente(nome, cpf, salario, bonus);
            funcionarios.add(gerente);

            System.out.println("\n✓ Gerente cadastrado com sucesso!");
            gerente.exibirDados();

        } catch (Exception e) {
            System.out.println("\n✗ Erro: " + e.getMessage());
        }
    }

    private static void cadastrarEstagiario() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║           CADASTRO DE ESTAGIÁRIO              ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF (apenas números): ");
            String cpf = scanner.nextLine();

            System.out.print("Salário Base: R$ ");
            double salario = Double.parseDouble(scanner.nextLine());

            System.out.print("Carga Horária Semanal (máx 40h): ");
            int cargaHoraria = Integer.parseInt(scanner.nextLine());

            Estagiario estagiario = new Estagiario(nome, cpf, salario, cargaHoraria);
            funcionarios.add(estagiario);

            System.out.println("\n✓ Estagiário cadastrado com sucesso!");
            estagiario.exibirDados();

        } catch (Exception e) {
            System.out.println("\n✗ Erro: " + e.getMessage());
        }
    }

    private static void exibirTodosFuncionarios() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║          LISTA DE FUNCIONÁRIOS                ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        if (funcionarios.isEmpty()) {
            System.out.println("\n⚠ Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\nTotal de funcionários: " + funcionarios.size());
        System.out.println();

        // Demonstração de polimorfismo
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("Funcionário #" + (i + 1));
            funcionarios.get(i).exibirDados();
            System.out.println();
        }
    }

    private static void exibirEstatisticas() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║              ESTATÍSTICAS                     ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        if (funcionarios.isEmpty()) {
            System.out.println("\n⚠ Nenhum funcionário cadastrado.");
            return;
        }

        int totalFunc = 0, totalGer = 0, totalEst = 0;
        double totalSalarios = 0;

        for (Funcionario f : funcionarios) {
            totalSalarios += f.calcularSalario();
            
            if (f instanceof Gerente) {
                totalGer++;
            } else if (f instanceof Estagiario) {
                totalEst++;
            } else {
                totalFunc++;
            }
        }

        System.out.println("\n📊 Resumo:");
        System.out.println("   • Funcionários Padrão: " + totalFunc);
        System.out.println("   • Gerentes: " + totalGer);
        System.out.println("   • Estagiários: " + totalEst);
        System.out.println("   • Total: " + funcionarios.size());
        System.out.printf("   • Folha de Pagamento Total: R$ %.2f%n", totalSalarios);
        System.out.printf("   • Salário Médio: R$ %.2f%n", totalSalarios / funcionarios.size());
    }

    private static void demonstracaoCompleta() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║          DEMONSTRAÇÃO COMPLETA                ║");
        System.out.println("║        (Cadastrando dados exemplo)            ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        // Limpar lista atual
        funcionarios.clear();

        try {
            // Criando funcionários usando diferentes construtores (sobrecarga)
            System.out.println("\n➤ Cadastrando Funcionário Padrão...");
            Funcionario func1 = new Funcionario("João Silva", "12345678901", 3000.00);
            funcionarios.add(func1);
            func1.exibirDados();

            System.out.println("\n➤ Cadastrando Gerente...");
            Gerente gerente1 = new Gerente("Maria Santos", "98765432109", 8000.00, 24000.00);
            funcionarios.add(gerente1);
            gerente1.exibirDados();

            System.out.println("\n➤ Cadastrando outro Gerente...");
            Gerente gerente2 = new Gerente("Carlos Oliveira", "11122233344", 9500.00, 30000.00);
            funcionarios.add(gerente2);
            gerente2.exibirDados();

            System.out.println("\n➤ Cadastrando Estagiário...");
            Estagiario est1 = new Estagiario("Ana Costa", "55566677788", 1500.00, 30);
            funcionarios.add(est1);
            est1.exibirDados();

            System.out.println("\n➤ Cadastrando outro Estagiário...");
            Estagiario est2 = new Estagiario("Pedro Almeida", "99988877766", 1200.00, 20);
            funcionarios.add(est2);
            est2.exibirDados();

            // Demonstração de polimorfismo
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║       DEMONSTRAÇÃO DE POLIMORFISMO            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            System.out.println("\nChamando calcularSalario() para cada funcionário:");
            System.out.println("(Cada tipo calcula de forma diferente)\n");

            for (Funcionario f : funcionarios) {
                String tipo = f.getClass().getSimpleName();
                System.out.printf("%-15s %-25s: R$ %10.2f%n", 
                    tipo, f.getNome(), f.calcularSalario());
            }

            // Exibir estatísticas
            exibirEstatisticas();

            System.out.println("\n✓ Demonstração completa finalizada!");
            System.out.println("  Você pode usar as opções 4 e 5 do menu para visualizar os dados.");

        } catch (Exception e) {
            System.out.println("\n✗ Erro na demonstração: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
