public class Restaurante extends Restauracao {
    protected float valMedioFaturacaoMesa;
    protected int numDiasFuncionamentoAno, numMesasInteriores;
    public Restaurante(){}

    public Restaurante(int numEmpregadosMesa, float custoEmpregadosMesa, float numMedClientesDiario, float valMedioFaturacaoMesa, int numDiasFuncionamentoAno, int numMesasInteriores) {
        super(numEmpregadosMesa, custoEmpregadosMesa, numMedClientesDiario);
        this.valMedioFaturacaoMesa = valMedioFaturacaoMesa;
        this.numDiasFuncionamentoAno = numDiasFuncionamentoAno;
        this.numMesasInteriores = numMesasInteriores;
    }

    public float getValMedioFaturacaoMesa() {
        return valMedioFaturacaoMesa;
    }

    public void setValMedioFaturacaoMesa(float valMedioFaturacaoMesa) {
        this.valMedioFaturacaoMesa = valMedioFaturacaoMesa;
    }

    public int getNumDiasFuncionamentoAno() {
        return numDiasFuncionamentoAno;
    }

    public void setNumDiasFuncionamentoAno(int numDiasFuncionamentoAno) {
        this.numDiasFuncionamentoAno = numDiasFuncionamentoAno;
    }

    public int getNumMesasInteriores() {
        return numMesasInteriores;
    }

    public void setNumMesasInteriores(int numMesasInteriores) {
        this.numMesasInteriores = numMesasInteriores;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "valMedioFaturacaoMesa=" + valMedioFaturacaoMesa +
                ", numDiasFuncionamentoAno=" + numDiasFuncionamentoAno +
                ", numMesasInteriores=" + numMesasInteriores +
                "} " + super.toString();
    }
}
