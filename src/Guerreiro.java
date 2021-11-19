import java.util.Scanner;

public class Guerreiro extends Personagem{
    private Arma a;
    public Guerreiro() {
        super(30 , 20 , 180);
    }

    @Override
    public void escolherArma() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Qual arma você prefere (Digite o numero): \n1 - Espada \n2 - Machado");
            System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
            int arma = s.nextInt();
            if (arma == 1 || arma == 2){
                if(arma == 1){
                    a = new Arma(10,15,"Espada");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    setRealDef(getRealDef()+a.getDefArma());
                    System.out.println("Você escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Atributos: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }else{
                    a = new Arma(17,8,"Machado");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    setRealDef(getRealDef()+a.getDefArma());
                    System.out.println("Você escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Atributos: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }
            }else{
                System.out.println("Escolha uma opçao valida: " + arma);
            }
        }
    }
    public void atacar(Dragao dragao) {
        int atq = getAtq();
        int pvd = dragao.getPvd();
        double def = dragao.getDef();

        pvd -= (atq - def);
        dragao.setPvd(pvd);
        System.out.println("Voce deu " + (atq - def) + " de dano com " + a.getNome());
        System.out.println("Vida atual do " + dragao.getNome() + " e: " + dragao.getPvd() + "\n");
    }
}
