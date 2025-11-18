package poo;

public class Estagiario extends Funcionario {
    private int cargaHorariaSemanal;

    public Estagiario() {
        super();
        this.cargaHorariaSemanal = 0;
    }

    public Estagiario(String nome, String cpf, double salarioBase, int cargaHorariaSemanal) {
        super(nome, cpf, salarioBase);
        setCargaHorariaSemanal(cargaHorariaSemanal);
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        if (cargaHorariaSemanal < 0) {
            throw new IllegalArgumentException("Carga horária não pode ser negativa!");
        }
        if (cargaHorariaSemanal > 40) {
            throw new IllegalArgumentException("Carga horária semanal de estagiário não pode exceder 40 horas!");
        }
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public double calcularValorHora() {
        if (cargaHorariaSemanal == 0) {
            return 0;
        }
        return getSalarioBase() / (cargaHorariaSemanal * 4);
    }

    @Override
    public void exibirDados() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          DADOS DO ESTAGIÁRIO           ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.printf("║ Nome: %-32s ║%n", getNome());
        System.out.printf("║ CPF: %-33s ║%n", formatarCpf(getCpf()));
        System.out.printf("║ Salário Base: R$ %-20.2f ║%n", getSalarioBase());
        System.out.printf("║ Carga Horária: %d horas/semana %8s ║%n", cargaHorariaSemanal, "");
        System.out.printf("║ Valor/Hora: R$ %-22.2f ║%n", calcularValorHora());
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
