public class Pastelaria extends Restauracao {
    private float numMedBolosVendidosDia;
    private float valMedFaturacaoAnualBoloVendidoDia;

    public Pastelaria(){}

    public Pastelaria(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, float numMedClientesDiario, float custoEmpregadosMesa, float custoSalarioMedioAnual, float numMedBolosVendidosDia, float valMedFaturacaoAnualBoloVendidoDia) {
        super("Pastelaria", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
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
    public float defReceitaAnual() {
        return numMedBolosVendidosDia * valMedFaturacaoAnualBoloVendidoDia;
    }

    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t•Numero medio de bolos vendidos por dia = " + numMedBolosVendidosDia + '\n' +
                "\t•Valor medio de faturacao anual de bolos vendidos por dia = " + valMedFaturacaoAnualBoloVendidoDia + "€\n";
    }

    @Override
    public String toStringFicheiro() {
        return '2' + super.toStringFicheiro() + numMedBolosVendidosDia + ',' + valMedFaturacaoAnualBoloVendidoDia;
    }
}
