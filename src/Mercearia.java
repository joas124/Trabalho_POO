public abstract class Mercearia extends Empresa{
    protected double custoAnualLimpezaEstabelecimento;

    public Mercearia(){}

    public Mercearia(String categoria, String nome, String distrito, GPS localizacao, double custoAnualLimpezaEstabelecimento) {
        super(categoria, nome, distrito, localizacao);
        this.custoAnualLimpezaEstabelecimento = custoAnualLimpezaEstabelecimento;
    }

    public double getCustoAnualLimpezaEstabelecimento(){
        return custoAnualLimpezaEstabelecimento;
    }

    public void setCustoAnualLimpezaEstabelecimento(double custoAnualLimpezaEstabelecimento) {
        this.custoAnualLimpezaEstabelecimento = custoAnualLimpezaEstabelecimento;
    }

    @Override
    public double defDespesaAnual() {
        return custoAnualLimpezaEstabelecimento;
    }

    @Override
    public double capacidadeRestauracao() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t•Custo anual de limpeza do estabelecimento = " + custoAnualLimpezaEstabelecimento + "€\n";
    }

    @Override
    public String toStringFicheiro() {
        return super.toStringFicheiro() + custoAnualLimpezaEstabelecimento + ',';
    }
}
