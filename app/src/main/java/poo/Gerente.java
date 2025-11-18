package poo;

public class Gerente extends Funcionario {
    private double bonusAnual;

    public Gerente() {
        super();
        this.bonusAnual = 0.0;
    }

    public Gerente(String nome, String cpf, double salarioBase, double bonusAnual) {
        super(nome, cpf, salarioBase);
        setBonusAnual(bonusAnual);
    }

    public double getBonusAnual() {
        return bonusAnual;
    }

    public void setBonusAnual(double bonusAnual) {
        if (bonusAnual < 0) {
            throw new IllegalArgumentException("Bônus anual não pode ser negativo!");
        }
        this.bonusAnual = bonusAnual;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (bonusAnual / 12);
    }

    @Override
    public void exibirDados() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║           DADOS DO GERENTE             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.printf("║ Nome: %-32s ║%n", getNome());
        System.out.printf("║ CPF: %-33s ║%n", formatarCpf(getCpf()));
        System.out.printf("║ Salário Base: R$ %-20.2f ║%n", getSalarioBase());
        System.out.printf("║ Bônus Anual: R$ %-21.2f ║%n", bonusAnual);
        System.out.printf("║ Bônus Mensal: R$ %-20.2f ║%n", bonusAnual / 12);
        System.out.printf("║ Salário Total: R$ %-19.2f ║%n", calcularSalario());
        System.out.println("╚════════════════════════════════════════╝");
    }

    private String formatarCpf(String cpf) {
        return cpf.substring(0, 3) + "." + 
               cpf.substring(3, 6) + "." + 
               cpf.substring(6, 9) + "-" + 
               cpf.substring(9, 11);
    }
}
