import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;


public class Game {
    int gameMode;
    int soma;
    int vezde;

    // PVP               PVC
    String player_1;    int num_player;
    String player_2;    int num_cpu;
    int player_1_type;  int cpu_type;
    int player_2_type;  int player_type;
    int num_p1;         int p_points;
    int num_p2;         int cpu_points;
    int p1_points;
    int p2_points;

    Scanner ler = new Scanner(System.in);
    
    // Title
    public void title(){
        System.out.println("-----GAME:PAR OU IMPAR?-----");
    }

    // Regras
    public void regras(){
        System.out.println("---------------------------REGRAS DE JOGO-------------------------------------------");
        System.out.println("1- O jogador deve escolher se quer ser impar ou par.");
        System.out.println("2- Deve-se escolher um numero entre 0 e 5.");
        System.out.println("3- O jogo, aleatoriamente, escolhe quem comeca.");
        System.out.println("4- A soma dos dois numeros, escolhidos pelos jogadores, sera um numero impar ou par.");
        System.out.println("5- Aquele que fizer 3 pontos primeiro ganha.");
        System.out.println("\nPressione (ENTER) para continuar...");
        ler.nextLine();
    }

    // Modo de jogo
    public int modoJogo(int gm){
        // Limpa terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("--------MODO-DE-JOGO--------");
        System.out.println("--(1)--PLAYER-VS-CPU--------");
        System.out.println("--(2)--PLAYER-VS-PLAYER-----");
        System.out.println("-------------//-------------");

        System.out.print("ESCOLHA O MODO DE JOGO: ");
        gameMode = ler.nextInt();

        return gameMode;
    }

    //-----------------MODE: PLAYER VS CPU-------------------------
    // Impar our Par
    public void playerVSCPU() throws InterruptedException{
       // Limpa terminal
       System.out.print("\033[H\033[2J");
       System.out.flush();

       System.out.println("-PLAYER VS CPU-");
       System.out.println("\n-IMPAR-OU-PAR?-");
       System.out.println("-(1)-IMPAR-----");
       System.out.println("-(2)-PAR-------");
       System.out.println("---------------");
       System.out.print("Escolha o que quer ser: ");
       player_type = ler.nextInt();

       // Limpa terminal
       System.out.print("\033[H\033[2J");
       System.out.flush();

       switch(player_type){
        case 1:
            System.out.println("-DEFINICAO---");
            System.out.println("Player: IMPAR");
            System.out.println("CPU:    PAR");
            cpu_type = 2;
            break;
        case 2:
            System.out.println("-DEFINICAO---");
            System.out.println("Player: PAR");
            System.out.println("CPU:    IMPAR");
            cpu_type = 1;
            break;
        default:
            System.out.println("ERRO! OPCAO INVALIDA!");
       }

       Thread.sleep(3000);
    }

    // Random number CPU
    public int randomNumberCPU(){
        Random rand = new Random();
        num_cpu = rand.nextInt(6);
        return num_cpu;
    }
    
    // Player VS CPU Game
    public int playerVSCPUGame(int vd) throws InterruptedException{
        // Limpa terminal
       System.out.print("\033[H\033[2J");
       System.out.flush();

       // Vez de: CPU
       if(vd == 0){
        System.out.println("Vez de: CPU");
        Thread.sleep(1500);
        System.out.println("Aguarde...");
        randomNumberCPU();
        Thread.sleep(2500);
    
        vezde = 1;
       } else if(vd == 1){
        System.out.println("Vez de: Player");
        System.out.print("Digite um numero entre 0 e 5: ");
        num_player = ler.nextInt();
        
        vezde = 0;
       }

       // Soma
       soma = num_player + num_cpu;
       return soma;
    }


    //-----------------MODE: PLAYER VS PLAYER-------------------------
    // Set player names
    public void playersName() throws InterruptedException{
        // Limpa terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

       System.out.println("-PLAYER VS PLAYER-");

        System.out.print("\n(PLAYER 1) NOME: ");
        player_1 = ler.next();
    
        Thread.sleep(1500);
    
        // Limpa terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    
        System.out.print("(PLAYER 2) NOME: ");
        player_2 = ler.next();
    
        // Limpa terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Thread.sleep(1500);
    }

    // Começo aleatório
    public int comecaJogando(){
        Random rand = new Random();

        vezde = rand.nextInt(2);

        return vezde;
    }

    // Select PAR our IMPAR
    public void playerVSplayer(int vd) throws InterruptedException{
        if(vezde == 0){
            System.out.print("Vez de: " + player_1 + "\nDigite (1) para ser IMPAR, ou (2) para ser PAR: ");
            player_1_type = ler.nextInt();

            if(player_1_type == 1){
                player_2_type = 2;
                System.out.println("--------------------------");
                System.out.println(player_1 + ": IMPAR");
                System.out.println(player_2 + ": PAR");
                System.out.println("---------------------------");

            }
            else if(player_1_type == 2) {
                player_2_type = 1;
                System.out.println("---------------------------");
                System.out.println(player_1 + ": PAR");
                System.out.println(player_2 + ": IMPAR");
                System.out.println("---------------------------");
            }
        }
        else if(vezde == 1){
            System.out.print("Vez de: " + player_2 + "\nDigite (1) para ser IMPAR, ou (2) para ser PAR: ");
            player_2_type = ler.nextInt();  

            if(player_2_type == 1){
                player_1_type = 2;
                System.out.println("---------------------------");
                System.out.println(player_1 + ": PAR");
                System.out.println(player_2 + ": IMPAR");
                System.out.println("---------------------------");
            }
            else if(player_2_type == 2) {
                player_1_type = 1;
                System.out.println("---------------------------");
                System.out.println(player_1 + ": IMPAR");
                System.out.println(player_2 + ": PAR");
                System.out.println("---------------------------");
            }
        }

        Thread.sleep(2000);
    }

    // Player VS player GAME
    public int playerVSplayerGame(int vd) throws InterruptedException{
        // Limpa terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Thread.sleep(1500);

        if(vd == 0){
            System.out.println("VEZ DE: " + player_1);
            System.out.println("Fale para seu amigo tapar os olhos!");
            System.out.print("Digite um numero de 0 a 5: ");
            num_p1 = ler.nextInt();

            vezde = 1;

            if(num_p1 > 5 || num_p1 < 0){
                // Limpa terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("ERRO! O NÚMERO DEVE ESTAR ENTRE 0 E 5");
                Thread.sleep(2500);
                return playerVSplayerGame(vd);
            }

            // Limpa terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();

            Thread.sleep(1500);
        } else{
            System.out.println("VEZ DE: " + player_2);
            System.out.println("Fale para seu amigo tapar os olhos!");
            System.out.print("Digite um numero de 0 a 5: ");
            num_p2 = ler.nextInt();

            vezde = 0;

            if(num_p2 > 5 || num_p2 < 0){
                // Limpa terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("ERRO! O NÚMERO DEVE ESTAR ENTRE 0 E 5");
                Thread.sleep(2500);
                return playerVSplayerGame(vd);
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

            Thread.sleep(1500);
        }
        
        // Soma
        soma = num_p1 + num_p2;
        return soma;
    }


    //------------------------FIM-------------------------
    // Resultado
    public void resultado() throws InterruptedException{

        if(gameMode == 1){
            System.out.println("RESULTADO: " + num_player + " + " + num_cpu + " = " + soma);
            // Verifica se deu impar ou par
            if(soma % 2 == 0 && player_type == 2){
                System.out.println("DEU PAR! VOCE GANHOU UM PONTO");
                p_points++;
            } else if(soma % 2 == 0 &&  cpu_type == 2){
                System.out.println("DEU PAR! PONTO PARA CPU");
                cpu_points++;
            } else if(soma % 2 != 0 && player_type == 1){
                System.out.println("DEU IMPAR! VOCE GANHOU UM PONTO");
                p_points++;
            } else if(soma % 2 != 0 && cpu_type == 1){
                System.out.println("DEU IMPAR! PONTO PARA CPU");
                cpu_points++;
            }
    
            // Exibe os pontos atuais dos jogadores
            System.out.println("---PONTOS---");
            System.out.println("Player: " + p_points);
            System.out.println("CPU: " + cpu_points);

        } else{
            System.out.println("RESULTADO: " + num_p1 + " + " + num_p2 + " = " + soma);
            // Verifica se deu impar ou par
            if(soma % 2 == 0 && player_1_type == 2){
                System.out.println("DEU PAR! PONTO PARA " + player_1);
                p1_points++;
            } else if(soma % 2 == 0 && player_2_type == 2){
                System.out.println("DEU PAR! PONTO PARA " + player_2);
                p2_points++;
            } else if(soma % 2 != 0 && player_1_type == 1){
                System.out.println("DEU IMPAR! PONTO PARA " + player_1);
                p1_points++;
            } else if(soma % 2 != 0 && player_2_type == 1){
                System.out.println("DEU IMPAR! PONTO PARA " + player_2);
                p2_points++;
            }
    
            // Exibe os pontos atuais dos jogadores
            System.out.println("---PONTOS---");
            System.out.println(player_1 + ": " + p1_points);
            System.out.println(player_2 + ": " + p2_points);
        }
        Thread.sleep(4500);
    }

    // Campeão
    public void campeao() throws InterruptedException{

        Thread.sleep(1500);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        if(gameMode == 1){
            System.out.println("FIM DE JOGO!!!");
            if(p_points== 3){
                System.out.println("VENCEDOR(A): Player");
            } else if(cpu_points == 3){
                System.out.println("VENCEDOR: CPU");
            }
        } else{
            System.out.println("FIM DE JOGO!!!");
            if(p1_points == 3){
                System.out.println("VENCEDOR(A): " + player_1);
            } else if(p2_points == 3){
                System.out.println("VENCEDOR(A): " + player_2);
            }
        }
        Thread.sleep(4000);
    }

    // Finalização
    public void finalizacao(){
        // Limpa terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Jogo finalizado.");
        System.out.println("Volte sempre (: ");
        System.out.println("Desenvolvido por: Heitor Felipe");
    }
}

