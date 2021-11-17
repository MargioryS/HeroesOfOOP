import java.util.Scanner;

public class Mago extends Personagem{
    public Mago() {
        super(20, 10, 200);
    }

    @Override
    public void escolherArma() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Qual arma você prefere (Digite o numero): \n1 - Varinha \n2 - Cajado");
            System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
            int arma = s.nextInt();
            if (arma == 1 || arma == 2){
                if(arma == 1){
                    Arma a = new Arma(16,9,"Varinha");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    System.out.println("Você escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Total Stats: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }else{
                    Arma a = new Arma(13,12,"Cajado");
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
