import java.util.List;
import java.util.Random;

public class Dragao extends Personagem{
    private String nome;
    public Dragao() {
        super(30, 30, 300);
        this.nome = "Dragão";
    }

    public void atacarDrag(List<Personagem> personagens){
        Random rand = new Random();
        Personagem i = personagens.get(rand.nextInt(personagens.size()));;

        int atq = getAtq();
        double def = i.getDef();
        int pvd = i.getPvd();
        pvd -= (atq - def);
        if((atq - def) >= 0) {
            i.setPvd(pvd);
            System.out.println("Você tomou " + (atq - def) + " de dano!");
            System.out.println("Vida atual do " + i.getNome() + " é: " + i.getPvd());
        }else{
            System.out.println("Você tomou 0 de dano!");
            System.out.println("Vida atual do " + i.getNome() + " é: " + i.getPvd());
        }
    }

    @Override
    public void atacar(Dragao dragao) {}

    @Override
    public void escolherArma() {}

    public String getNome() {
        return nome;
    }
}
