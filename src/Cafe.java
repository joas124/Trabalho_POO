public class Cafe extends Restauracao {
    private double numMedCafesVendidosDia;
    private double valMedFaturacaoAnualCafeVendidoDia;

    public Cafe(){}

    public Cafe(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double numMedCafesVendidosDia, double valMedFaturacaoAnualCafeVendidoDia) {
        super("Café", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
        this.numMedCafesVendidosDia = numMedCafesVendidosDia;
        this.valMedFaturacaoAnualCafeVendidoDia = valMedFaturacaoAnualCafeVendidoDia;
    }

    public double getNumMedCafesVendidosDia() {
        return numMedCafesVendidosDia;
    }

    public void setNumMedCafesVendidosDia(double numMedCafesVendidosDia) {
        this.numMedCafesVendidosDia = numMedCafesVendidosDia;
    }

    public double getValMedFaturacaoAnualCafeVendidoDia() {
        return valMedFaturacaoAnualCafeVendidoDia;
    }

    public void setValMedFaturacaoAnualCafeVendidoDia(double valMedFaturacaoAnualCafeVendidoDia) {
        this.valMedFaturacaoAnualCafeVendidoDia = valMedFaturacaoAnualCafeVendidoDia;
    }

    @Override
    public double defReceitaAnual() {
        return numMedCafesVendidosDia * valMedFaturacaoAnualCafeVendidoDia;
    }

    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t•Numero medio de cafes vendidos por dia = " + numMedCafesVendidosDia + '\n' +
                "\t•Valor medio de faturacao anual de cafes vendidos dia = " + valMedFaturacaoAnualCafeVendidoDia + "€\n";
    }

}
