package poo;

public class Funcionario {
    // Atributos privados (encapsulamento)
    private String nome;
    private String cpf;
    private double salarioBase;

    // Construtor padrão
    public Funcionario() {
        this.nome = "";
        this.cpf = "";
        this.salarioBase = 0.0;
    }

    // Construtor com parâmetros (sobrecarga)
    public Funcionario(String nome, String cpf, double salarioBase) {
        setNome(nome);
        setCpf(cpf);
        setSalarioBase(salarioBase);
    }

    // Getters e Setters com validação
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }
        this.nome = nome.trim();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio!");
        }
        // Remove caracteres não numéricos
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        if (cpfLimpo.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos!");
        }
        this.cpf = cpfLimpo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo!");
        }
        this.salarioBase = salarioBase;
    }

    // Método para calcular salário (será sobrescrito nas subclasses - polimorfismo)
    public double calcularSalario() {
        return salarioBase;
    }

    // Método para exibir dados
    public void exibirDados() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║         DADOS DO FUNCIONÁRIO           ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.printf("║ Nome: %-32s ║%n", nome);
        System.out.printf("║ CPF: %-33s ║%n", formatarCpf(cpf));
        System.out.printf("║ Salário Base: R$ %-20.2f ║%n", salarioBase);
        System.out.printf("║ Salário Total: R$ %-19.2f ║%n", calcularSalario());
        System.out.println("╚════════════════════════════════════════╝");
    }

    // Método auxiliar para formatar CPF
    private String formatarCpf(String cpf) {
        return cpf.substring(0, 3) + "." + 
               cpf.substring(3, 6) + "." + 
               cpf.substring(6, 9) + "-" + 
               cpf.substring(9, 11);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + formatarCpf(cpf) + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
    }
}
