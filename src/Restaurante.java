public abstract class Restaurante extends Restauracao {
    protected double valMedioFaturacaoMesaDia;
    protected int numDiasFuncionamentoAno;
    protected int numMesasInteriores;

    public Restaurante(){}

    public Restaurante(String categoria, String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores) {
        super(categoria, nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
        this.valMedioFaturacaoMesaDia = valMedioFaturacaoMesaDia;
        this.numDiasFuncionamentoAno = numDiasFuncionamentoAno;
        this.numMesasInteriores = numMesasInteriores;
    }

    public double getValMedioFaturacaoMesa() {
        return valMedioFaturacaoMesaDia;
    }

    public void setValMedioFaturacaoMesa(double valMedioFaturacaoMesa) {
        this.valMedioFaturacaoMesaDia = valMedioFaturacaoMesa;
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
        return super.toString() +
                "\t•Valor médio de faturação por mesa = " + valMedioFaturacaoMesaDia + "€\n" +
                "\t•Número de dias de funcionamento por ano =" + numDiasFuncionamentoAno + '\n' +
                "\t•Número de mesas interiores = " + numMesasInteriores + '\n';
    }

}
