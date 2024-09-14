import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppSistemaElevadorLista {


    static List<Elevador> elevadores = new ArrayList<Elevador>();
    static Scanner input = new Scanner(System.in);

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


    public static Elevador pesquisaElevadorPorCodigo(int codigo) {
        for (Elevador elevador : elevadores) {
            if (codigo == elevador.getCodigo()) {
                return elevador;
            }
        }
        return null;

    }


    public static void mostrarElevador(Elevador elevador) {
        System.out.printf("\nCódigo...............: %d\n", elevador.getCodigo());
        System.out.printf("Limite de pessoas....: %d\n", elevador.getLimitePessoas());
        System.out.printf("Pessoas transportadas: %d\n", elevador.getPessoasTransportadas());
        System.out.printf("Situação.............: %s\n", elevador.getStatus());
    }

    public static void entradaPessoas() {
        /* De maneira recorrente realizar os seguintes passos:
         * 1 - Mostrar o título "Entrada de Pessoas"
         * 2 - Verificar e informar se o vetor estiver vazio
         * 3 - Solicitar o código do elevador onde as pessoas entraram
         *     - Se o código for 0: Retornar ao menu principal
         *     - Se o código não for encontrado, informar ao usuário e
         *       retornar ao passo 3
         *     - Mostrar o status do elevador
         *     - Se o elevador não estiver em operação, informar ao usuário e
         *       retornar ao passo 3
         * 4 - De maneira recorrente solicitar a quantidade de pessoas que entraram no elevador
         *     - Se a quantidade for 0, retornar ao passo 3
         *     - Registrar a entrada da quantidade de pessoas no elevador
         *     - Mostrar os dados do elevador
         *     - Mostrar mensagem de entrada efetuada
         *     - Se o elevador não foi bloqueado retornar ao passo 4
         *     - Se o elevador foi bloqueado, alertar ao usuário e retornar ao passo 3
         */

        System.out.println("\n ***   Entrada de Pessoas   *** ");
        if (elevadores.isEmpty()){
            System.out.println("Vetor Vazio");
        }

        do {
            System.out.print("\nCódigo do Elevador ou [0] para retornar: ");

            int codigo = input.nextInt();
            if (codigo == 0){
                return;
            }

            if (pesquisaElevadorPorCodigo(codigo) == null){
                System.out.println("Código não encontrado");
                continue;
            }
            Elevador elevador = pesquisaElevadorPorCodigo(codigo);

            String status = elevador.getStatus();
            System.out.println("\nStatus do Elevador: " + status);
            if (status != "Em operação"){
                System.out.println("Elevador não está em operação");
                continue;
            }

            do{
                System.out.print("Quantidade de pessoas: ");
                int quantidadeEntradas = input.nextInt();
                if (quantidadeEntradas == 0){
                    break;
                }

                elevador.registraEntrada(quantidadeEntradas);
                System.out.println("\nCódigo: " + elevador.getCodigo());
                System.out.println("Pessoas Transportadas: " + elevador.getPessoasTransportadas());
                System.out.println("Limite de Pessoas: " + elevador.getLimitePessoas());
                System.out.println("Status: " + elevador.getStatus());
                System.out.println("\nEntrada Efetuada");

                if (elevador.getStatus() != "Bloqueado"){
                    continue;
                }
                System.out.println("Elevador Bloqueado!");

                break;
            } while (true);

        } while (true);
    }

    public static void saidaPessoas() {
        /* De maneira recorrente realizar os seguintes passos:
         * 1 - Mostrar o título "Saída de Pessoas"
         * 2 - Verificar e informar se o vetor estiver vazio
         * 3 - Solicitar o código do elevador de onde as pessoas saíram
         *     - Se o código for 0: Retornar ao menu principal
         *     - Se o código não for encontrado, informar ao usuário e
         *       retornar ao passo 3
         *     - Mostrar o status do elevador
         *     - Se o elevador não estiver em operação, informar ao usuário e
         *       retornar ao passo 3
         * 4 - De maneira recorrente solicitar a quantidade de pessoas que saíram do elevador
         *     - Se a quantidade for 0, retornar ao passo 3
         *     - Se a quantidade for maior que a quantidade de pessoas transportada,
         *       informar ao usuário e retornar ao passo 4
         *     - Registrar a saída da quantidade de pessoas no elevador
         *     - Mostrar os dados do elevador
         *     - Mostrar mensagem de saída efetuada
         *     - Retornar ao passo 4
         */

        System.out.println("\n ***   Saída de Pessoas   *** ");
        if (elevadores.isEmpty()){
            System.out.println("Vetor Vazio");
        }

        do {
            System.out.print("\nCódigo do Elevador ou [0] para retornar: ");

            int codigo = input.nextInt();
            if (codigo == 0){
                break;
            }

            if (pesquisaElevadorPorCodigo(codigo) == null){
                System.out.println("Código não encontrado");
                continue;
            }
            Elevador elevador = pesquisaElevadorPorCodigo(codigo);

            String status = elevador.getStatus();
            System.out.println("\nStatus do Elevador: " + status);
            if (status != "Em operação"){
                System.out.println("Elevador não está em operação");
                continue;
            }

            do{
                System.out.print("Quantidade de pessoas: ");
                int quantidadeSaidas = input.nextInt();
                if (quantidadeSaidas == 0){
                    break;
                }
                else if (quantidadeSaidas > elevador.getPessoasTransportadas()){
                    System.out.println("\nSaída maior que pessoas no elevador");
                    break;
                }

                elevador.registraSaida(quantidadeSaidas);
                System.out.println("\nCódigo: " + elevador.getCodigo());
                System.out.println("Pessoas Transportadas: " + elevador.getPessoasTransportadas());
                System.out.println("Limite de Pessoas: " + elevador.getLimitePessoas());
                System.out.println("Status: " + elevador.getStatus());
                System.out.println("\nSaída Efetuada");

                break;

            } while (true);

        } while (true);
    }


    public static void cadastraElevador() {

        do {

            System.out.println("\n*** Cadastro de Elevador ***\n");

            System.out.printf("\nCódigo do elevador para cadastro ou [0] para retornar: ");
            int codigo = input.nextInt();

            if (codigo == 0) {
                return;
            }

            if (pesquisaElevadorPorCodigo(codigo) != null) {
                System.out.println("\n-- Código já cadastrado --\n");
                continue;
            }

            elevadores.add(new Elevador(codigo));

            System.out.println("\n-- Cadastro efetuado --\n");

        } while (true);
    }


    public static void consultaElevador() {

        do {
            System.out.println("\n*** Consulta de Elevador ***\n");
            if (elevadores.size() == 0) {
                System.out.println("Lista vazia");
                return;
            }

            System.out.printf("\nCódigo do elevador para consultar ou [0] para retornar: ");
            int codigo = input.nextInt();
            if (codigo == 0) {
                return;
            }

            Elevador elevadorEncontrado = pesquisaElevadorPorCodigo(codigo);

            if (elevadorEncontrado == null) {
                System.out.println("\n-- Código não cadastrado --\n");
                continue;
            }
            mostrarElevador(elevadorEncontrado);
        } while (true);
    }


    public static void excluiElevador() {
        System.out.println("\n*** Exclusão de Elevador ***\n");
        if (elevadores.size() == 0) {
            System.out.println("Lista vazia");
            return;
        }

        System.out.printf("\nCódigo do elevador excluir ou [0] para finalizar: ");
        int codigo = input.nextInt();

        if (codigo == 0) {
            return;
        }

        Elevador elevadorEncontrado = pesquisaElevadorPorCodigo(codigo);

        if (elevadorEncontrado == null) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }
        mostrarElevador(elevadorEncontrado);

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
            elevadores.remove(elevadorEncontrado);
            System.out.println("-- Exclusão efetuada");
        }
        else {
            System.out.println("-- Exclusão cancelada");
        }
    }


    public static void mantemElevador() {
        System.out.println("\n*** Coloca Elevador em Manutenção ***\n");
        if (elevadores.size() == 0) {
            System.out.println("Lista vazia");
            return;
        }

        System.out.printf("\nCódigo do elevador: ");
        int codigo = input.nextInt();

        Elevador elevadorEncontrado = pesquisaElevadorPorCodigo(codigo);

        if (elevadorEncontrado == null) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }
        mostrarElevador(elevadorEncontrado);

        if (elevadorEncontrado.getStatus().equals("Em manutenção")) {
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
            elevadorEncontrado.registraManutencao();
            mostrarElevador(elevadorEncontrado);
            System.out.println("\n-- Elevador colocado em manutenção");
        }
        else {
            System.out.println("-- Manutenção cancelada");
        }
    }


    public static void operaElevador() {
        System.out.println("\n*** Coloca Elevador em Operação ***\n");
        if (elevadores.size() == 0) {
            System.out.println("Lista vazia");
            return;
        }

        System.out.printf("\nCódigo do elevador: ");
        int codigo = input.nextInt();

        Elevador elevadorEncontrado = pesquisaElevadorPorCodigo(codigo);

        if (elevadorEncontrado == null) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }
        mostrarElevador(elevadorEncontrado);

        if (!elevadorEncontrado.getStatus().equals("Em manutenção")) {
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
            elevadorEncontrado.registraOperacao();
            mostrarElevador(elevadorEncontrado);
            System.out.println("\n-- Elevador colocado em operação");
        }
        else {
            System.out.println("-- Manutenção cancelada");
        }
    }


    public static void alteraLimite() {
        System.out.println("\n*** Altera Limite de Pessoas ***\n");
        if (elevadores.size() == 0) {
            System.out.println("Lista vazia");
            return;
        }

        System.out.printf("\nCódigo do elevador: ");
        int codigo = input.nextInt();

        Elevador elevadorEncontrado = pesquisaElevadorPorCodigo(codigo);

        if (elevadorEncontrado == null) {
            System.out.println("\n-- Código não cadastrado --\n");
            return;
        }
        mostrarElevador(elevadorEncontrado);

        System.out.println("\nNovo limite: ");
        int novoLimite = input.nextInt();
        if (elevadorEncontrado.alteraLimite(novoLimite)) {
            System.out.println("Elevador não encontra-se em manutenção");
        }
        else {
            mostrarElevador(elevadorEncontrado);
            System.out.println("\n-- Limite de pessoas no elevador alterado");
        }
    }


    public static void listaElevadores() {
        System.out.println("\n*** Listagem de Elevador ***\n");

        if (elevadores.size() == 0) {
            System.out.println("Lista vazia");
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

        for (Elevador elevador: elevadores) {
            if (status=='B' && elevador.getStatus().equals("Bloqueado") ||
                    status=='M' && elevador.getStatus().equals("Em manutenção") ||
                    status=='O' && elevador.getStatus().equals("Em operação") ||
                    status=='T' ) {

                System.out.printf("%-6d %-13s %10d %7d\n",
                        elevador.getCodigo(),
                        elevador.getStatus(),
                        elevador.getLimitePessoas(),
                        elevador.getPessoasTransportadas());
            }
            else {
                //System.out.printf("%dº Elemento nulo\n", i);
            }
        }

        System.out.println("=======================================");
    }

}