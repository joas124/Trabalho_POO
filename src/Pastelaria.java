public class Pastelaria extends Restauracao {
    private double numMedBolosVendidosDia;
    private double valMedFaturacaoAnualBoloVendidoDia;

    public Pastelaria(){}

    public Pastelaria(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double numMedBolosVendidosDia, double valMedFaturacaoAnualBoloVendidoDia) {
        super("Pastelaria", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
        this.numMedBolosVendidosDia = numMedBolosVendidosDia;
        this.valMedFaturacaoAnualBoloVendidoDia = valMedFaturacaoAnualBoloVendidoDia;
    }

    public double getNumMedBolosVendidosDia() {
        return numMedBolosVendidosDia;
    }

    public void setNumMedBolosVendidosDia(double numMedBolosVendidosDia) {
        this.numMedBolosVendidosDia = numMedBolosVendidosDia;
    }

    public double getValMedFaturacaoAnualBoloVendidoDia() {
        return valMedFaturacaoAnualBoloVendidoDia;
    }

    public void setValMedFaturacaoAnualBoloVendidoDia(double valMedFaturacaoAnualBoloVendidoDia) {
        this.valMedFaturacaoAnualBoloVendidoDia = valMedFaturacaoAnualBoloVendidoDia;
    }

    @Override
    public double defReceitaAnual() {
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
