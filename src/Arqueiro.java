import java.util.Scanner;

public class Arqueiro extends Personagem{
    public Arqueiro() {
        super(20, 30, 160);
    }

    @Override
    public void escolherArma() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Qual arma você prefere (Digite o numero): \n1 - Arco Longo \n2 - Balestra");
            System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
            int arma = s.nextInt();
            if (arma == 1 || arma == 2){
                if(arma == 1){
                    Arma a = new Arma(12,13,"Arco Longo");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    System.out.println("Você escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Total Stats: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }else{
                    Arma a = new Arma(15,10,"Balestra");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    System.out.println("Você escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Atributos: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }
            }else{
                System.out.println("Escolha uma opção valida: " + arma);
            }
        }
    }
}
