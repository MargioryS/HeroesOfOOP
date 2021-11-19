import java.util.Scanner;

public class Arqueiro extends Personagem{
    private Arma a;
    public Arqueiro() {
        super(20, 30, 160);
    }

    @Override
    public void escolherArma() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Qual arma voce prefere (Digite o numero): \n1 - Arco Longo \n2 - Balestra");
            System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
            int arma = s.nextInt();
            if (arma == 1 || arma == 2){
                if(arma == 1){
                    a = new Arma(12,13,"Arco Longo");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    setRealDef(getRealDef()+a.getDefArma());
                    System.out.println("Voce escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Total Stats: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }else{
                    a = new Arma(15,10,"Balestra");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    setRealDef(getRealDef()+a.getDefArma());
                    System.out.println("Você escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Atributos: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }
            }else{
                System.out.println("Escolha uma opção valida: " + arma);
            }
        }
    }
    public void atacar(Dragao dragao) {
        int atq = getAtq();
        int pvd = dragao.getPvd();
        double def = dragao.getDef();

        pvd -= (atq - def);
        dragao.setPvd(pvd);
        System.out.println("Você deu " + (atq - def) + " de dano com " + a.getNome());
        System.out.println("Vida atual do " + dragao.getNome() + " e: " + dragao.getPvd() + "\n");
    }
}
