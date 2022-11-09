public class Restauracao extends Empresa{
    protected int numEmpregadosMesa;
    protected float numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual;

    public Restauracao(){}

    public Restauracao(int numEmpregadosMesa, float custoEmpregadosMesa, float numMedClientesDiario) {
        this.custoEmpregadosMesa = custoEmpregadosMesa;
        this.numEmpregadosMesa = numEmpregadosMesa;
        this.numMedClientesDiario = numMedClientesDiario;
        custoSalarioMedioAnual = custoEmpregadosMesa/numEmpregadosMesa;
    }

    public int getNumEmpregadosMesa() {
        return numEmpregadosMesa;
    }

    public void setNumEmpregadosMesa(int numEmpregadosMesa) {
        this.numEmpregadosMesa = numEmpregadosMesa;
    }

    public float getCustoEmpregadosMesa() {
        return custoEmpregadosMesa;
    }

    public void setCustoEmpregadosMesa(float custoEmpregadosMesa) {
        this.custoEmpregadosMesa = custoEmpregadosMesa;
    }

    public float getCustoSalarioMedioAnual() {
        return custoSalarioMedioAnual;
    }

    public void setCustoSalarioMedioAnual(float custoSalarioMedioAnual) {
        this.custoSalarioMedioAnual = custoSalarioMedioAnual;
    }

    public float getNumMedClientesDiario() {
        return numMedClientesDiario;
    }

    public void setNumMedClientesDiario(float numMedClientesDiario) {
        this.numMedClientesDiario = numMedClientesDiario;
    }

    @Override
    public String toString() {
        return "Restauracao{" +
                "numEmpregadosMesa=" + numEmpregadosMesa +
                ", custoEmpregadosMesa=" + custoEmpregadosMesa +
                ", custoSalarioMedioAnual=" + custoSalarioMedioAnual +
                '}';
    }
}
