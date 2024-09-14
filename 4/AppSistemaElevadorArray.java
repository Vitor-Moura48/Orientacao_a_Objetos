import java.util.Scanner;

public class AppSistemaElevadorArray {

    static Elevador elevadores[] = new Elevador[5];
    static Scanner input = new Scanner(System.in);
    static int contElevador=0;

    public static void main(String[] args) {

        int opcao = 0;
        do {
            System.out.println("\n*** Elevador - Seletor de Opções ***");
            System.out.println();
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Por em Manutenção");
            System.out.println("5 - Por em Operação");
            System.out.println("6 - Alterar Limite de Pessoas");
            System.out.println("7 - Listar");
            System.out.println("8 - Entrada de pessoas");
            System.out.println("9 - Saída de pessoas");
            System.out.println("0 - Finalizar");

            System.out.print("\nOpção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    cadastraElevador();
                    break;
                case 2:
                    consultaElevador();
                    break;
                case 3:
                    excluiElevador();
                    break;
                case 4:
                    mantemElevador();
                    break;
                case 5:
                    operaElevador();
                    break;
                case 6:
                    alteraLimite();
                    break;
                case 7:
                    listaElevadores();
                    break;
                case 8:
                    entradaPessoas();
                    break;
                case 9:
                    saidaPessoas();
                    break;
                case 0:
                    System.out.println("\n--- PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("\nOpção incorreta");

            }

        } while (opcao !=0);
        input.close();
    }


    public static int pesquisaElevadorPorCodigo(int codigo) {
        for (int i = 0; i < elevadores.length; i++) {
            if (elevadores[i] != null && codigo == elevadores[i].getCodigo()) {
                return i;
            }
        }
        return -1;
    }


    public static void mostrarElevador(int posicaoEncontrada) {
        System.out.printf("\nCódigo...............: %d\n", elevadores[posicaoEncontrada].getCodigo());
        System.out.printf("Limite de pessoas....: %d\n", elevadores[posicaoEncontrada].getLimitePessoas());
        System.out.printf("Pessoas transportadas: %d\n", elevadores[posicaoEncontrada].getPessoasTransportadas());
        System.out.printf("Situação.............: %s\n", elevadores[posicaoEncontrada].getStatus());
    }

    public static void entradaPessoas() {
        /* De maneira recorrente realizar os seguintes passos:
         * 1 - Mostrar o título "Entrada de Pessoas"                                             9
         * 2 - Verificar e informar se o vetor estiver vazio                                     9
         * 3 - Solicitar o código do elevador onde as pessoas entraram
         *     - Se o código for 0: Retornar ao menu principal                                   9
         *     - Se o código não for encontrado, informar ao usuário e
         *       retornar ao passo 3
         *     - Mostrar o status do elevador                                                    9
         *     - Se o elevador não estiver em operação, informar ao usuário e
         *       retornar ao passo 3
         * 4 - De maneira recorrente solicitar a quantidade de pessoas que entraram no elevador  9
         *     - Se a quantidade for 0, retornar ao passo 3
         *     - Registrar a entrada da quantidade de pessoas no elevador                        9
         *     - Mostrar os dados do elevador                                                    9
         *     - Mostrar mensagem de entrada efetuada
         *     - Se o elevador não foi bloqueado retornar ao passo 4
         *     - Se o elevador foi bloqueado, alertar ao usuário e retornar ao passo 3
         */

        System.out.println("Entrada de Pessoas");
        if (this.contElevador == 0){
            System.out.println("Vetor Vazio");
        }

        do {
            System.out.print("Código do Elevador ou 0 para retornar: ");

            int codigo = input.nextInt();
            if (codigo == 0){
                return
            }

            if (pesquisaElevadorPorCodigo(codigo) == -1){
                System.out.println("Código não encontrado");
                continue;
            }

            String status = elevadores[codigo].getStatus()
            System.out.println("Status do Elevador: " + status);
            if (status != "Em Operação"){
                System.out.println("Elevador não está em operação");
                continue;
            }

            do{
                System.out.println("Quantidade de pessoas: ");
                int quantidadeEntradas = input.nextInt();
                if (quantidadeEntradas == 0){
                    break;
                }

                elevadores[codigo].registrarEntrada(quantidadeEntradas)
                System.out.println("Código: " + elevadores[codigo].getCodigo());
                System.out.println("Pessoas Transportadas: " + elevadores[codigo].getPessoasTransportadas);
                System.out.println("Limite de Pessoas: " + elevadores[codigo].getLimitePessoas());
                System.out.println("Status: " + elevadores[codigo].getStatus());
                System.out.println("\nEntrada Efetuada");

                if (elevadores[codigo].getStatus != "Bloqueado"){
                    continue;
                }
                System.out.println("Elevador Bloqueado!");

                break;
            } while (true)

            break;
        } while (true)

    }

    public static void saidaPessoas() {
        /* De maneira recorrente realizar os seguintes passos:
         * 1 - Mostrar o título "Saída de Pessoas"                                              9
         * 2 - Verificar e informar se o vetor estiver vazio                                    9
         * 3 - Solicitar o código do elevador de onde as pessoas saíram
         *     - Se o código for 0: Retornar ao menu principal
         *     - Se o código não for encontrado, informar ao usuário e
         *       retornar ao passo 3
         *     - Mostrar o status do elevador
         *     - Se o elevador não estiver em operação, informar ao usuário e
         *       retornar ao passo 3
         * 4 - De maneira recorrente solicitar a quantidade de pessoas que saíram do elevador
         *     - Se a quantidade for 0, retornar ao passo 3                                     9
         *     - Se a quantidade for maior que a quantidade de pessoas transportada,
         *       informar ao usuário e retornar ao passo 4                                      9
         *     - Registrar a saída da quantidade de pessoas no elevador                         9
         *     - Mostrar os dados do elevador
         *     - Mostrar mensagem de saída efetuada
         *     - Retornar ao passo 4
         */

        System.out.println("Saída de Pessoas");
        if (this.contElevador == 0){
            System.out.println("Vetor Vazio");
        }

        do {
            System.out.print("Código do Elevador ou 0 para retornar: ");

            int codigo = input.nextInt();
            if (codigo == 0){
                break;
            }

            if (pesquisaElevadorPorCodigo(codigo) == -1){
                System.out.println("Código não encontrado");
                continue;
            }

            String status = elevadores[codigo].getStatus()
            System.out.println("Status do Elevador: " + status);
            if (status != "Em Operação"){
                System.out.println("Elevador não está em operação");
                continue;
            }

            do{
                System.out.println("Quantidade de pessoas: ");
                int quantidadeSaidas = input.nextInt();
                if (quantidadeSaidas == 0){
                    break;
                }
                else if (quantidadeSaidas > elevadores[codigo].getPessoasTransportadas()){
                    System.out.println("Saída maior que pessoas no elevador");
                    break;
                }

                elevadores[codigo].registraSaida(quantidadeSaidas)
                System.out.println("Código: " + elevadores[codigo].getCodigo());
                System.out.println("Pessoas Transportadas: " + elevadores[codigo].getPessoasTransportadas);
                System.out.println("Limite de Pessoas: " + elevadores[codigo].getLimitePessoas());
                System.out.println("Status: " + elevadores[codigo].getStatus());
                System.out.println("\nSaída Efetuada");

                break;

            } while (true)

        } while (true)

    }


    public static void cadastraElevador() {

        do {

            System.out.println("\n*** Cadastro de Elevador ***\n");

            if (contElevador == elevadores.length) {
                System.out.println("Vetor cheio");
                return;
            }

            System.out.printf("\nCódigo do elevador para cadastro ou [0] para retornar: ");
            int codigo = input.nextInt();

            if (codigo == 0) {
                return;
            }

            if (pesquisaElevadorPorCodigo(codigo) != -1) {
                System.out.println("\n-- Código já cadastrado --\n");
                continue;
            }

            for (int i = 0; i < elevadores.length; i++) {
                if (elevadores[i] == null) {
                    elevadores[i]= new Elevador(codigo);
                    contElevador++;
                    System.out.println("\n-- Cadastro efetuado --\n");
                    break;
                }
            }
        } while (true);
    }


    public static void consultaElevador() {

        do {
            System.out.println("\n*** Consulta de Elevador ***\n");
            if (contElevador == 0) {
                System.out.println("Vetor vazio");
                return;
            }

            System.out.printf("\nCódigo do elevador para consultar ou [0] para retornar: ");
            int codigo = input.nextInt();
            if (codigo == 0) {
                return;
            }

            int posicaoEncontrada = pesquisaElevadorPorCodigo(codigo);

            if (posicaoEncontrada == -1) {
                System.out.println("\n-- Código não cadastrado --\n");
                continue;
            }
            mostrarElevador(posicaoEncontrada);
        } while (true);
    }


    public static void excluiElevador() {
        System.out.println("\n*** Exclusão de Elevador ***\n");
        if (contElevador == 0) {
            System.out.println("Vetor vazio");
            return;
        }

        System.out.printf("\nCódigo do elevador excluir ou [0] para finalizar: ");
        int codigo = input.nextInt();

        if (codigo == 0) {
            return;
        }

        int posicaoEncontrada = pesquisaElevadorPorCodigo(codigo);

        if (posicaoEncontrada == -1) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }

        mostrarElevador(posicaoEncontrada);

        input.nextLine();
        char confirma;
        do {
            System.out.printf("\nConfirma exclusão [S/N]: ");
            confirma = input.nextLine().charAt(0);
            confirma = Character.toUpperCase(confirma);
            if(confirma!='S' && confirma!='N') {
                continue;
            }
            break;
        } while (true);
        if (confirma=='S') {
            elevadores[posicaoEncontrada] = null;
            System.out.println("-- Exclusão efetuada");
            contElevador--;
        }
        else {
            System.out.println("-- Exclusão cancelada");
        }
    }


    public static void mantemElevador() {
        System.out.println("\n*** Coloca Elevador em Manutenção ***\n");
        if (contElevador ==0) {
            System.out.println("Vetor vazio");
            return;
        }

        System.out.printf("\nCódigo do elevador: ");
        int codigo = input.nextInt();

        int posicaoEncontrada = pesquisaElevadorPorCodigo(codigo);

        if (posicaoEncontrada == -1) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }

        mostrarElevador(posicaoEncontrada);

        if (elevadores[posicaoEncontrada].getStatus().equals("Em manutenção")) {
            System.out.println("-- Elevador já encontra-se em manutenção");
            return;
        }

        input.nextLine();
        char confirma;
        do {
            System.out.printf("\nConfirma manutenção [S/N]: ");
            confirma = input.nextLine().charAt(0);
            confirma = Character.toUpperCase(confirma);
            if(confirma!='S' && confirma!='N') {
                continue;
            }
            break;
        } while (true);
        if (confirma=='S') {
            elevadores[posicaoEncontrada].registraManutencao();
            mostrarElevador(posicaoEncontrada);
            System.out.println("\n-- Elevador colocado em manutenção");
        }
        else {
            System.out.println("-- Manutenção cancelada");
        }
    }


    public static void operaElevador() {
        System.out.println("\n*** Coloca Elevador em Operação ***\n");
        if (contElevador ==0) {
            System.out.println("Vetor vazio");
            return;
        }

        System.out.printf("\nCódigo do elevador: ");
        int codigo = input.nextInt();

        int posicaoEncontrada = pesquisaElevadorPorCodigo(codigo);

        if (posicaoEncontrada == -1) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }

        mostrarElevador(posicaoEncontrada);

        if (!elevadores[posicaoEncontrada].getStatus().equals("Em manutenção")) {
            System.out.println("-- Elevador não encontra-se em manutenção");
            return;
        }

        input.nextLine();
        char confirma;
        do {
            System.out.printf("\nConfirma retorno a operação [S/N]: ");
            confirma = input.nextLine().charAt(0);
            confirma = Character.toUpperCase(confirma);
            if(confirma!='S' && confirma!='N') {
                continue;
            }
            break;
        } while (true);

        if (confirma=='S') {
            elevadores[posicaoEncontrada].registraOperacao();
            mostrarElevador(posicaoEncontrada);
            System.out.println("\n-- Elevador colocado em operação");
        }
        else {
            System.out.println("-- Manutenção cancelada");
        }
    }


    public static void alteraLimite() {
        System.out.println("\n*** Altera Limite de Pessoas ***\n");
        if (contElevador ==0) {
            System.out.println("Vetor vazio");
            return;
        }

        System.out.printf("\nCódigo do elevador: ");
        int codigo = input.nextInt();

        int posicaoEncontrada = pesquisaElevadorPorCodigo(codigo);

        if (posicaoEncontrada == -1) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }

        mostrarElevador(posicaoEncontrada);

        System.out.println("\nNovo limite: ");
        int novoLimite = input.nextInt();
        if (elevadores[posicaoEncontrada].alteraLimite(novoLimite)) {
            System.out.println("Elevador não encontra-se em manutenção");
        }
        else {
            mostrarElevador(posicaoEncontrada);
            System.out.println("\n-- Limite de pessoas no elevador alterado");
        }
    }


    public static void listaElevadores() {
        System.out.println("\n*** Listagem de Elevador ***\n");

        if (contElevador == 0) {
            System.out.println("Vetor vazio");
            return;
        }

        input.nextLine();
        char status;
        do {
            System.out.printf("\nSituação para listagem : ");
            System.out.printf("\nB - Bloqueado");
            System.out.printf("\nM - Manutenção");
            System.out.printf("\nO - Operação");
            System.out.printf("\nT - Todos");
            System.out.print("\nFiltar por situação: ");
            status = input.nextLine().charAt(0);
            status = Character.toUpperCase(status);
            if(status!='B' && status!='M' && status!='O' && status!='T') {
                System.out.println("-- Opção inválida");
                continue;
            }
            break;
        } while (true);

        System.out.println("=======================================");
        System.out.println("Código Status        Capacidade Pessoas");
        System.out.println("=======================================");

        for (int i = 0; i < elevadores.length; i++) {
            if (elevadores[i] != null  && (
                    status=='B' && elevadores[i].getStatus().equals("Bloqueado") ||
                            status=='M' && elevadores[i].getStatus().equals("Em manutenção") ||
                            status=='O' && elevadores[i].getStatus().equals("Em operação") ||
                            status=='T' )) {

                System.out.printf("%-6d %-13s %10d %7d\n",
                        elevadores[i].getCodigo(),
                        elevadores[i].getStatus(),
                        elevadores[i].getLimitePessoas(),
                        elevadores[i].getPessoasTransportadas());
            }
            else {
                //System.out.printf("%dº Elemento nulo\n", i);
            }
        }

        System.out.println("=======================================");
    }
}