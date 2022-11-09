public class Pastelaria extends Restauracao {
    private float numMedBolosVendidosDia;
    private float valMedFaturacaoAnualBoloVendidoDia;

    public Pastelaria(){}

    public Pastelaria(int numEmpregadosMesa, float custoEmpregadosMesa, float numMedClientesDiario, float numMedBolosVendidosDia, float valMedFaturacaoAnualBoloVendidoDia) {
        super(numEmpregadosMesa, custoEmpregadosMesa, numMedClientesDiario);
        this.numMedBolosVendidosDia = numMedBolosVendidosDia;
        this.valMedFaturacaoAnualBoloVendidoDia = valMedFaturacaoAnualBoloVendidoDia;
    }

    public float getNumMedBolosVendidosDia() {
        return numMedBolosVendidosDia;
    }

    public void setNumMedBolosVendidosDia(float numMedBolosVendidosDia) {
        this.numMedBolosVendidosDia = numMedBolosVendidosDia;
    }

    public float getValMedFaturacaoAnualBoloVendidoDia() {
        return valMedFaturacaoAnualBoloVendidoDia;
    }

    public void setValMedFaturacaoAnualBoloVendidoDia(float valMedFaturacaoAnualBoloVendidoDia) {
        this.valMedFaturacaoAnualBoloVendidoDia = valMedFaturacaoAnualBoloVendidoDia;
    }

    @Override
    public String toString() {
        return "Pastelaria{" +
                "numMedBolosVendidosDia=" + numMedBolosVendidosDia +
                ", valMedFaturacaoAnualBoloVendidoDia=" + valMedFaturacaoAnualBoloVendidoDia +
                "} " + super.toString();
    }
}
