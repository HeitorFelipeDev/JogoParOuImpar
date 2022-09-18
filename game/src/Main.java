import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        int jogar_de_novo = 0;
        Scanner ler = new Scanner(System.in);

        // DO WHILE 
        do{
            try {
                // Limpa terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Exibe o titulo do game
                game.title();

                game.regras();

                // Escolha do modo de jogo
                game.modoJogo(game.gameMode);

                // PLAYER VS CONSOLE    
                if(game.gameMode == 1){
                    // Escolha do player em ser impar ou par
                    game.playerVSCPU();

                    // Quem começa jogando
                    game.comecaJogando();

                    while(true){
                        // Jogadas
                        for(int jogada = 0; jogada < 2; jogada++){
                            game.playerVSCPUGame(game.vezde);
                        }

                        // Exibe resultado
                        game.resultado();

                        // Proxímo a jogar
                        game.comecaJogando();

                        // Verifica se algúem já pontuou 3 vezes
                        if(game.p_points == 3 || game.cpu_points == 3){
                            break;
                        } else{
                            continue;
                        }
                    }
                    // Exibe o campeão
                    game.campeao();
                }
                // PLAYER VS PLAYER
                else if(game.gameMode == 2){
                    // Escolha dos nomes
                    game.playersName();

                    // Quem escolhe primeiro
                    game.comecaJogando();

                    // Escolha de impar ou par
                    game.playerVSplayer(game.vezde);

                    // Quem começa jogando
                    game.comecaJogando();

                    // Melhor de 3
                    while(true){

                        // Jogadas
                        for(int jogada = 0; jogada < 2; jogada++){
                            game.playerVSplayerGame(game.vezde);
                        }

                        // Exibe os pontos
                        game.resultado();

                         // Proxímo a jogar
                         game.comecaJogando();

                        // Verifica se algúem já pontuou 3 vezes
                        if(game.p1_points == 3 || game.p2_points == 3){
                            break;
                        } else{
                            continue;
                        }
                    }
                    // Exibe o campeão
                    game.campeao();
                }

                Thread.sleep(3000);

                // Limpa terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // JOGAR DE NOVO
                System.out.println("--OBRIGADO--POR--JOGAR------");
                System.out.println("--(1)-JOGAR-DE-NOVO---------");
                System.out.println("--(2)-SAIR-DO-JOGO----------");
                System.out.print("--Escolha a opcao desejada:");
                jogar_de_novo = ler.nextInt();

            } catch (Exception e) {
                System.out.println("ERRO!");
            }
        } while(jogar_de_novo == 1);

        game.finalizacao();
    }
}
