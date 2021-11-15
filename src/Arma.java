public class Arma {
    private int atqArma;
    private int defArma;
    private String nome;

    public Arma(int atqArma, int defArma, String nome) {
        this.atqArma = atqArma;
        this.defArma = defArma;
        this.nome = nome;
    }

    public int getAtqArma() {
        return atqArma;
    }

    public int getDefArma() {
        return defArma;
    }

    public String getNome() {
        return nome;
    }
}
