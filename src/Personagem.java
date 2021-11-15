import java.util.List;
import java.util.Scanner;

public abstract class Personagem {
    private int atq;
    private int def;
    private int pvd;
    private String nome;

    public Personagem(int atq, int def, int pvd) {
        this.atq = atq;
        this.def = def;
        this.pvd = pvd;
    }

    public void atacar(Dragao dragao) {
        int atq = getAtq();
        int pvd = dragao.getPvd();
        int def = dragao.getDef();

        pvd -= (atq - def);
        dragao.setPvd(pvd);
        System.out.println("Você deu " + (atq - def) + " de dano!");
        System.out.println("Vida atual do " + dragao.getNome() + " é: " + dragao.getPvd());
    }

    public void escolherArma(){};

    public void atacarDrag(List<Personagem> personagens){};

    public void escolherNome() {
        System.out.println("Me diga seu nome bravo Heroi: ");
        Scanner s = new Scanner(System.in);
        setNome(s.nextLine());
        System.out.println("Seu nome é " + getNome());
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
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

}
