import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private final List<Personagem> personagens;
    private final Personagem d;
    private int numPersonagem;

    public GameController(){
        personagens = new ArrayList<>();
        d = new Dragao();
        numPersonagem = 0;
    }

    public void comecarJogo(){
        Scanner s = new Scanner(System.in);
        System.out.println("""
                ╔╗░╔╗░░░░░░░░░░░░░░
                ║║░║║░░░░░░░░░░░░░░
                ║╚═╝╠══╦═╦══╦══╦══╗
                ║╔═╗║║═╣╔╣╔╗║║═╣══╣
                ║║░║║║═╣║║╚╝║║═╬══║
                ╚╝░╚╩══╩╝╚══╩══╩══╝
                ░░░░╔═╗░░░░░░░░░░░░
                ░░░░║╔╝░░░░░░░░░░░░
                ╔══╦╝╚╗░░░░░░░░░░░░
                ║╔╗╠╗╔╝░░░░░░░░░░░░
                ║╚╝║║║░░░░░░░░░░░░░
                ╚══╝╚╝░░░░░░░░░░░░░
                ╔═══╦═══╦═══╗░░░░░░
                ║╔═╗║╔═╗║╔═╗║░░░░░░
                ║║░║║║░║║╚═╝║░░░░░░
                ║║░║║║░║║╔══╝░░░░░░
                ║╚═╝║╚═╝║║░░░░░░░░░
                ╚═══╩═══╩╝░░░░░░░░░
                """);
        boolean state = true;
        while (state){
            System.out.println("\u001B[1mComeçar Jogo! - Digite 1\nCriar novo Personagem - Digite 2\nSair - Digite 3\n");
            int e = s.nextInt();
            switch (e) {
                case 1 -> {
                    System.out.println("Vamos à batalha!!!");
                    batalha(personagens, (Dragao) d);
                }
                case 2 -> criarPersonagem(personagens);
                case 3 -> {
                    System.out.println("Obrigado por jogar!");
                    state = false;
                }
                default -> System.out.println("Não entendi sua resposta: " + e);
            }
        }
    }//Comecar jogo

    private void batalha(List<Personagem> personagens, Dragao dragao) {
        if (personagens.size() > 0){
            boolean vivos = true;
            while (vivos && dragao.getPvd() > 0){
                vivos = false;
                for(Personagem personagem: personagens){
                    personagem.atacar(dragao);
                }
                dragao.atacarDrag(personagens);
                for(Personagem personagem: personagens){
                    if (personagem.getPvd() >= 0) {
                        vivos = true;
                    }
                }
            }
            if(vivos){
                System.out.println("Você ganhou!\n");
            }else{
                System.out.println("Você perdeu!\n");
            }
        }else {
            System.out.println("Você não criou um personagem\n");
        }
    } //Batalha

    private void criarPersonagem(List<Personagem> personagens){
            if (personagens.size() < 3){
            Scanner s = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Escolha seu tipo:\nGuerreiro - 1\nMago - 2\nArqueiro - 3\n");
            int escolha = s.nextInt();
            switch (escolha){
                case 1 ->{
                    personagens.add(new Guerreiro());
                    personagens.get(numPersonagem).escolherNome();
                    personagens.get(numPersonagem).escolherArma();
                    numPersonagem++;
                }
                case 2 ->{
                    personagens.add(new Mago());
                    personagens.get(numPersonagem).escolherNome();
                    personagens.get(numPersonagem).escolherArma();
                    numPersonagem++;
                }
                case 3->{
                    personagens.add(new Arqueiro());
                    personagens.get(numPersonagem).escolherNome();
                    personagens.get(numPersonagem).escolherArma();
                    numPersonagem++;
                }
            }
        }else{
                System.out.println("Você ja tem 3 personagens");
            }
    }
}
