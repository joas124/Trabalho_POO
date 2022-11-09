public class Cafe extends Restauracao {
    private float numMedCafesVendidosDia;
    private float valMedFaturacaoAnualCafeVendidoDia;

    public Cafe(){}

    public Cafe(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, float numMedClientesDiario, float custoEmpregadosMesa, float custoSalarioMedioAnual, float numMedCafesVendidosDia, float valMedFaturacaoAnualCafeVendidoDia) {
        super("Café", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
        this.numMedCafesVendidosDia = numMedCafesVendidosDia;
        this.valMedFaturacaoAnualCafeVendidoDia = valMedFaturacaoAnualCafeVendidoDia;
    }

    public float getNumMedCafesVendidosDia() {
        return numMedCafesVendidosDia;
    }

    public void setNumMedCafesVendidosDia(float numMedCafesVendidosDia) {
        this.numMedCafesVendidosDia = numMedCafesVendidosDia;
    }

    public float getValMedFaturacaoAnualCafeVendidoDia() {
        return valMedFaturacaoAnualCafeVendidoDia;
    }

    public void setValMedFaturacaoAnualCafeVendidoDia(float valMedFaturacaoAnualCafeVendidoDia) {
        this.valMedFaturacaoAnualCafeVendidoDia = valMedFaturacaoAnualCafeVendidoDia;
    }

    @Override
    public float defReceitaAnual() {
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
