import java.io.Serializable;

/**
 * Classe para a gestão de uma Empresa
 */
public abstract class Empresa implements Serializable {
    /**
     * Categoria da empresa (Mercearia/Restauração)
     */
    protected String categoria;
    /**
     * Nome da empresa
     */
    protected String nome;
    /**
     * Distrito da empresa
     */
    protected String distrito;
    /**
     * Localizacao da empresa
     */
    protected GPS localizacao;

    /**
     * Construtor default para a classe Empresa
     */
    public Empresa(){}

    /**
     * Construtor para a classe Empresa
     * @param categoria String com categoria da empresa (Mercearia/Restauração)
     * @param nome String com o nome da empresa
     * @param distrito String com o distrito onde a empresa esta localizada
     * @param localizacao Objeto GPS com as coordenadas da localizacao da empresa
     */
    public Empresa(String categoria, String nome, String distrito, GPS localizacao) {
        this.categoria = categoria;
        this.nome = nome;
        this.distrito = distrito;
        this.localizacao = localizacao;
    }

    /**
     * Metodo para obter a categoria da empresa
     * @return String com a categoria da empresa
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Metodo para definir a categoria da empresa
     * @param categoria String com a categoria da empresa
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Metodo para obter o nome da empresa
     * @return String com o nome da empresa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo para definir o nome da empresa
     * @param nome String com o nome da empresa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo para obter o distrito da empresa
     * @return String com o distrito da empresa
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Metodo para definir o distrito da empesa
     * @param distrito String com o nome da empresa
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Metodo para obter as coordenadas GPS da localizacao da empresa
     * @return Objeto GPS com as coordenadas da localizacao da empresa
     */
    public GPS getLocalizacao() {
        return localizacao;
    }
    /**
     * Metodo para obter as coordenadas GPS da localizacao da empresa
     * @param localizacao Objeto GPS com as coordenadas da localizacao da empresa
     */
    public void setLocalizacao(GPS localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Metodo para calcular a despesa anual da empresa
     * @return Float com o calculo da despesa anual da empresa
     */
    public abstract double defDespesaAnual();

    /**
     * Metodo para calcular a receita anual da empresa
     * @return Float com o calculo da receita anual da empresa
     */
    public abstract double defReceitaAnual();

    /**
     * Metodo para verificar se a empresa teve lucro ou não
     * @return <i>True</i> caso a empresa tenha tido lucro, <i>False</i> caso contrário
     */
    public abstract boolean lucro();
    public abstract double capacidadeRestauracao();
    /**
     * Método para converter a classe Empresa em String
     * @return String com as caracteristicas da empresa
     */
    @Override
    public String toString() {
        return "Empresa:\n" +
                "\t•Nome = '" + nome + "'\n" +
                "\t•Categoria = '" + categoria + "'\n" +
                "\t•Distrito = '" + distrito + "'\n" +
                "\t•Localizacao = " + localizacao + "\n" +
                "\t•Despesa Anual = " + defDespesaAnual() + "€\n" +
                "\t•Receita Anual = " + defReceitaAnual() + "€\n" +
                "\t•Lucro = " + lucro() +"\n";
    }

    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    public String toStringFicheiro(){
        return nome + ',' + categoria + ',' + distrito + ',' + localizacao + ',';
    }
}