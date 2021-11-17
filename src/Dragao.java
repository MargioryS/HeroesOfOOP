import java.util.List;
import java.util.Random;

public class Dragao extends Personagem{
    private String nome;
    public Dragao() {
        super(30, 30, 300);
        this.nome = "Dragão";
    }

    @Override
    public void atacarDrag(List<Personagem> personagens){
        Random rand = new Random();
        Personagem i = personagens.get(rand.nextInt(personagens.size()));;

        int atq = getAtq();
        double def = i.getDef();
        int pvd = i.getPvd();

        pvd -= (atq - def);
        i.setPvd(pvd);
        System.out.println("Você tomou " + (atq - def) + " de dano!");
        System.out.println("Vida atual do " + i.getNome() + " é: " + i.getPvd());
    }

    public String getNome() {
        return nome;
    }
}
