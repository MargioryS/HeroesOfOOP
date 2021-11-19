import java.util.List;
import java.util.Scanner;

public abstract class Personagem {
    private int atq;
    private double def;
    private int pvd;
    private String nome;
    private double realDef;

    public Personagem(int atq, int def, int pvd) {
        this.atq = atq;
        this.def = def;
        this.pvd = pvd;
        this.realDef = def;
    }

    public void defender(){
        System.out.println("Defendendo!");
        def += (def * 0.10);
    }

    public abstract void atacar(Dragao dragao);

    public abstract void escolherArma();

    public void escolherNome() {
        System.out.println("Me diga seu nome bravo Heroi: ");
        Scanner s = new Scanner(System.in);
        setNome(s.nextLine());
        System.out.println("Seu nome é " + getNome());
        System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public int getPvd() {
        return pvd;
    }

    public void setPvd(int pvd) {
        this.pvd = pvd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRealDef() {
        return realDef;
    }

    public void setRealDef(double realDef) {
        this.realDef = realDef;
    }
}
