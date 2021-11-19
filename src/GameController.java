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
        boolean state = true;
        while (state){
            System.out.println("Começar Jogo! - Digite 1\nCriar novo Personagem - Digite 2\nSair - Digite 3");
            System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
            int e = s.nextInt();
            switch (e) {
                case 1 : {
                    System.out.println("Vamos a batalha!!!");
                    System.out.println("a");
                    batalha(personagens, (Dragao) d);
                    break;
                }
                case 2 : {criarPersonagem(personagens); break;}
                case 3 : {
                    System.out.println("Obrigado por jogar!");
                    state = false;
                    break;
                }
                default :{ System.out.println("Nao entendi sua resposta: " + e); break;}
            }
        }
    }//Comecar jogo

    private void batalha(List<Personagem> personagens, Dragao dragao) {
        if (personagens.size() > 0){
            boolean vivos = true;
            Turno:
            while (vivos && dragao.getPvd() > 0){
                vivos = false;
                for(Personagem personagem: personagens){
                    if(personagem.getPvd() > 0){
                        Scanner s = new Scanner(System.in);
                        System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
                        System.out.println("Vez de " + personagem.getNome());
                        System.out.println("\nEscolha sua ação(Digite o numero): \nAtacar - 1\nDefender - 2\nSair da batalha - 3");
                        System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");

                        boolean state = true;
                        while (state){
                            int acao = s.nextInt();
                            switch (acao){
                                case 1 : {
                                    personagem.atacar((Dragao) d);
                                    state = false;
                                    break;
                                }
                                case 2 : {
                                    personagem.defender();
                                    state = false;
                                    break;
                                }
                                case 3 : {
                                    state = false;
                                    break Turno;
                                }
                                default :{ System.out.println("Desculpe nao entendi!"); break;}
                            }
                        }
                    }else{System.out.println(personagem.getNome() + "esta morto");}
                }
                dragao.atacarDrag(personagens);
                for(Personagem personagem: personagens){
                    if (personagem.getPvd() >= 0) {
                        vivos = true;
                    }
                }
                for(Personagem personagem: personagens){
                    personagem.setDef(personagem.getRealDef());
                }
            }
            if(vivos){
                System.out.println("\nGanhou!\n");
            }else{
                System.out.println("\nPerdeu!\n");
            }
            for (int i = personagens.size(); i <= personagens.size(); i++){
                personagens.remove(i-1);
            }
            vivos = false;
        }else {
            System.out.println("Você nao criou um personagem\n");
        }
    } //Batalha

    private void criarPersonagem(List<Personagem> personagens){
        if (personagens.size() < 3){
            // Create a Scanner object
            System.out.println("Escolha seu tipo:\nGuerreiro - 1\nMago - 2\nArqueiro - 3");
            System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
            boolean state = true;

            while (state) {
                Scanner s = new Scanner(System.in);
                int escolha = s.nextInt();
                switch (escolha){
                    case 1 :{
                        personagens.add(new Guerreiro());
                        personagens.get(numPersonagem).escolherNome();
                        personagens.get(numPersonagem).escolherArma();
                        numPersonagem++;
                        state = false;
                        break;
                    }
                    case 2 :{
                        personagens.add(new Mago());
                        personagens.get(numPersonagem).escolherNome();
                        personagens.get(numPersonagem).escolherArma();
                        numPersonagem++;
                        state = false;
                        break;
                    }
                    case 3:{
                        personagens.add(new Arqueiro());
                        personagens.get(numPersonagem).escolherNome();
                        personagens.get(numPersonagem).escolherArma();
                        numPersonagem++;
                        state = false;
                        break;
                    }
                    default : {System.out.println("Desculpe nao entendi!");break;}
                }
            }
        }else{
            System.out.println("Você ja tem 3 personagens");
        }
    }//Criar personagem
}

