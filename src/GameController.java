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
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
░░░░░░░╔════════════════════════════════════════╗░░░░░░
░░░░░░░║░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░║░░░░░░
░░░░░░░║░╔╗░╔╗░░░░░░░░░░░░░╔═══╗╔═╦═══╦═══╦═══╗░║░░░░░░
░░░░░░░║░║║░║║░░░░░░░░░░░░░║╔═╗║║╔╣╔═╗║╔═╗║╔═╗║░║░░░░░░
░░░░░░░║░║╚═╝╠══╦═╦══╦══╦══╣║░║╠╝╚╣║░║║║░║║╚═╝║░║░░░░░░
░░░░░░░║░║╔═╗║║═╣╔╣╔╗║║═╣══╣║░║╠╗╔╣║░║║║░║║╔══╝░║░░░░░░
░░░░░░░║░║║░║║║═╣║║╚╝║║═╬══║╚═╝║║║║╚═╝║╚═╝║║░░░░║░░░░░░
░░░░░░░║░╚╝░╚╩══╩╝╚══╩══╩══╩═══╝╚╝╚═══╩═══╝╝░░░░║░░░░░░
░░░░░░░║░░░░░░░░░░░░░╔══╗░░░░░░░╔╗░░░░░░░░░░░░░░║░░░░░░
░░░░░░░╚═════════════║══╬═╦═╦╦═╗╠╣══════════════╝░░░░░░
░░░░░░░░░░░░░░░░░░░░░╠══║╩╣║║║╬╚╣║░░░░░░░░░░░░░░░░░░░░░
░░░░░░░░░░░░░░░░░░░░░╚══╩═╩╩═╩══╩╝░░░░░░░░░░░░░░░░░░░░░
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                """);
        boolean state = true;
        while (state){
            System.out.println("\u001B[1mComeçar Jogo! - Digite 1\nCriar novo Personagem - Digite 2\nSair - Digite 3");
            System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
            int e = s.nextInt();
            switch (e) {
                case 1 -> {
                    System.out.println("Vamos à batalha!!!");
                    System.out.println("""
                                            ^    ^
                                           / \\  //\\
                             |\\___/|      /   \\//  .\\
                             /O  O  \\__  /    //  | \\ \\
                            /     /  \\/_/    //   |  \\  \\
                            @___@'    \\/_   //    |   \\   \\\s
                               |       \\/_ //     |    \\    \\\s
                               |        \\///      |     \\     \\\s
                              _|_ /   )  //       |      \\     _\\
                             '/,_ _ _/  ( ; -.    |    _ _\\.-~        .-~~~^-.
                             ,-{        _      `-.|.-~-.           .~         `.
                              '/\\      /                 ~-. _ .-~      .-~^-.  \\
                                 `.   {            }                   /      \\  \\
                               .----~-.\\        \\-'                 .~         \\  `. \\^-.
                              ///.----..>    c   \\             _ -~             `.  ^-`   ^-_
                                ///-._ _ _ _ _ _ _}^ - - - - ~                     ~--,   .-~
                                                                                      /.-'""");
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

                    escolherAcao(personagem);
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
                System.out.println("" +
                        "╔╗░░╔╗╔╗░░░░░░░░░╔╗\n" +
                        "║╚╗╔╝╠╝╚╗░░░░░░░░║║\n" +
                        "╚╗║║╔╬╗╔╬══╦═╦╦══╣║\n" +
                        "░║╚╝╠╣║║║╔╗║╔╬╣╔╗╠╝\n" +
                        "░╚╗╔╣║║╚╣╚╝║║║║╔╗╠╗\n" +
                        "░░╚╝╚╝╚═╩══╩╝╚╩╝╚╩╝\n");
            }else{
                System.out.println("" +
                        "╔═══╗░░░░░░░░░╔╗░░░╔╗\n" +
                        "╚╗╔╗║░░░░░░░░╔╝╚╗░░║║\n" +
                        "░║║║╠══╦═╦═╦═╩╗╔╬══╣║\n" +
                        "░║║║║║═╣╔╣╔╣╔╗║║║╔╗╠╝\n" +
                        "╔╝╚╝║║═╣║║║║╚╝║╚╣╔╗╠╗\n" +
                        "╚═══╩══╩╝╚╝╚══╩═╩╝╚╩╝\n");
            }
            for (int i = personagens.size(); i <= personagens.size(); i++){
                personagens.remove(i-1);
            }
        }else {
            System.out.println("Você não criou um personagem\n");
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
                    case 1 ->{
                        personagens.add(new Guerreiro());
                        personagens.get(numPersonagem).escolherNome();
                        personagens.get(numPersonagem).escolherArma();
                        numPersonagem++;
                        state = false;
                    }
                    case 2 ->{
                        personagens.add(new Mago());
                        personagens.get(numPersonagem).escolherNome();
                        personagens.get(numPersonagem).escolherArma();
                        numPersonagem++;
                        state = false;
                    }
                    case 3->{
                        personagens.add(new Arqueiro());
                        personagens.get(numPersonagem).escolherNome();
                        personagens.get(numPersonagem).escolherArma();
                        numPersonagem++;
                        state = false;
                    }
                    default -> System.out.println("Desculpe não entendi!");
                }
            }
        }else{
                System.out.println("Você ja tem 3 personagens");
            }
    }//Criar personagem

    private void escolherAcao(Personagem personagem){
        Scanner s = new Scanner(System.in);
        System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");
        System.out.println("Vez de " + personagem.getNome());
        System.out.println("Escolha sua ação(Digite o numero): \nAtacar - 1\nDefender - 2");
        System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>");

        boolean state = true;
        while (state){
            int acao = s.nextInt();
            switch (acao){
                case 1 -> {
                    personagem.atacar((Dragao) d);
                    state = false;
                }
                case 2 -> {
                    personagem.defender();
                    state = false;
                }
                default -> System.out.println("Desculpe não entendi!");
            }
        }
    }
}
