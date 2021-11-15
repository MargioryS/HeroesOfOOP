import java.util.Scanner;

public class Guerreiro extends Personagem{

    public Guerreiro() {
        super(30 , 20 , 180);
    }

    @Override
    public void escolherArma() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Qual arma você prefere (Digite o numero): \n1 - Espada \n2 - Machado\n");
            int arma = s.nextInt();
            if (arma == 1 || arma == 2){
                if(arma == 1){
                    Arma a = new Arma(10,15,"Espada");
                    setAtq(getAtq()+a.getAtqArma());
                    setDef(getDef()+a.getDefArma());
                    System.out.println("Você escolheu a " + a.getNome() + " e ganhou " + a.getAtqArma() + " de ATQ e " + a.getDefArma() + " de DEF!\n");
                    System.out.println("Atributos: \n" + getAtq()+" ATK \n" + getDef() + " DEF\n" + getNome() + "\n");
                    break;
                }else{
                    Arma a = new Arma(17,8,"Machado");
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
