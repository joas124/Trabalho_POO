public class Cafe extends Restauracao {
    private float numMedCafesVendidosDia;
    private float valMedFaturacaoAnualCafeVendidoDia;

    public Cafe(){}

    public Cafe(int numEmpregadosMesa, float custoEmpregadosMesa, float numMedClientesDiario, float numMedCafesVendidosDia, float valMedFaturacaoAnualCafeVendidoDia) {
        super(numEmpregadosMesa, custoEmpregadosMesa, numMedClientesDiario);
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
    public String toString() {
        return "Cafe{" +
                "numMedCafesVendidosDia=" + numMedCafesVendidosDia +
                ", valMedFaturacaoAnualCafeVendidoDia=" + valMedFaturacaoAnualCafeVendidoDia +
                "} " + super.toString();
    }
}
