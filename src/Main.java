
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.Math.random;
import static java.util.Arrays.compare;
import static java.util.Collections.copy;
import static java.util.Collections.sort;


public class Main {
    static List<CHAVES> CHAVES;
    static int contagem = 0;

    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        //MENSAGEM QUE APENAS VAI APARECER QUANDO O PROGRAMA INICIAR
        System.out.println();
        System.out.println("\u001B[34m      - BEM-VIND@ AO SIMULADOR DE EUROMILHOES - \u001B[0m ");

        //LOOP PRINCIPAL
        while (true) {

        // CRIAÇÃO DAS LISTAS DE CHAVE VENCEDORA
        List<Integer> numerosChave = new ArrayList<Integer>();                              //NUMEROS
        List<Integer> estrelasChave = new ArrayList<Integer>();                             //ESTRELAS


        //TAMANHO DAS LISTAS
        int tamListaNumeros = 5;
        int tamListaEstrelas = 2;

        // GERAR 5 NUMEROS ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
        for (int i = 0; i < tamListaNumeros; i++) {
            int rand = random.nextInt(1, 51);
            if (!numerosChave.contains(rand)) {
                numerosChave.add(rand);
            } else {
                // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 5 ELEMENTOS DIFERENTES
                tamListaNumeros++;
            }
        }

        // GERAR 2 NUMEROS("ESTRELAS") ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
        for (int i = 0; i < tamListaEstrelas; i++) {
            int rand = random.nextInt(1, 12);
            if (!estrelasChave.contains(rand)) {
                estrelasChave.add(rand);
            } else {
                // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 2 ELEMENTOS DIFERENTES
                tamListaEstrelas++;
            }
        }

        // ORDENAR A LISTA DOS NUMEROS DE FORMA CRESCENTE
        sort(numerosChave);
        // ORDENAR A LISTA DAS ESTRELAS DE FORMA CRESCENTE
        sort(estrelasChave);

        // CRIAÇÃO/INSERÇAO
        CHAVES = new ArrayList<>();
        CHAVES.add(new CHAVES(numerosChave.get(0), numerosChave.get(1), numerosChave.get(2), numerosChave.get(3), numerosChave.get(4), estrelasChave.get(0), estrelasChave.get(1)));



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                            // P A R A    O    P O F E S S O R !

            //No caso de querer exibir a chave vencedora no topo da página, para fazer o teste
            //da escolha [ 1 ] (input manual das chaves do MENU PRINCIPAL) , é so tirar o comentário ("//") da linha abaixo.


           //System.out.println(CHAVES.get(0));      // <------ CHAVE VENCEDORA

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        // MENU PRINCIPAL
        linha();
        int escolha = 0;
        MenuPrincipal();

            //TRATAMENTO DE ERROS E EXCEÇOES
            while (true) {
                try {
                    System.out.println("Sua opção: ");
                    escolha = in.nextInt();
                    if (escolha > -1 && escolha < 4) {
                        break;
                    } else {
                        System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 3.\u001B[0m");            //// VERIFICAR
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                }
                in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
            }
            while (true) {

                int quantidadeBoletins = 0;

                if (escolha == 1) {                             // OPÇÃO DE UTILIZADOR INSERIR CHAVE MANUALMENTE
                    int n1,n2,n3,n4,n5,es1,es2;

                    //Nº DE BOLETINS A JOGAR PELO UTILIZADOR
                    linha();
                    while (true) {
                        try {
                            System.out.println("Insira a quantidade de boletins que deseja adquirir (max. 5 uni.)");
                            quantidadeBoletins = in.nextInt();
                            if (quantidadeBoletins > 0 && quantidadeBoletins < 6) {
                                linha();
                                break;
                            } else {
                                System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 5.\u001B[0m");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                        }
                        in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                    }

                    for (int i = 0; i < quantidadeBoletins; i++) {

                        //LISTAS DE ARMAZENAMENTO TEMPORÁRIO.
                        List<Integer> listaNumTemp = new ArrayList<Integer>();
                        List<Integer> listaEsTemp = new ArrayList<Integer>();

                        /////////////
                        System.out.println("\t\t\t\t\t\u001B[34mBoletim Nº " + (i + 1)+"\u001B[0m");
                        System.out.println();


                        //TRATAMENTO DE ERROS DE INPUT DA CHAVE //////////////////////////////////////////////////////////////////////////////////////
                        while (true) {
                            try {
                                System.out.println("1º Número: ");
                                n1 = in.nextInt();
                                if (n1 > 0 && n1 < 51) {
                                    listaNumTemp.add(n1);
                                    break;
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }
                        while (true) {
                            try {
                                System.out.println("2º Número: ");
                                n2 = in.nextInt();
                                if (n2 > 0 && n2 < 51) {
                                    if (listaNumTemp.contains(n2)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n2);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("3º Número: ");
                                n3 = in.nextInt();
                                if (n3 > 0 && n3 < 51) {
                                    if (listaNumTemp.contains(n3)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n3);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("4º Número: ");
                                n4 = in.nextInt();
                                if (n4 > 0 && n4 < 51) {
                                    if (listaNumTemp.contains(n4)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n4);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("5º Número: ");
                                n5 = in.nextInt();
                                if (n5 > 0 && n5 < 51) {
                                    if (listaNumTemp.contains(n5)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n5);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("1ª Estrela: ");
                                es1 = in.nextInt();
                                if (es1 > 0 && es1 < 51) {
                                    if (listaEsTemp.contains(es1)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaEsTemp.add(es1);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 11.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("2ª Estrela: ");
                                es2 = in.nextInt();
                                if (es2 > 0 && es2 < 51) {
                                    if (listaEsTemp.contains(es2)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaEsTemp.add(es2);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 11.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }
                    //////////////////////////////////////////////////////////////////////////////////////////////////////// FIM TRATAMENTO DE ERROS


                        contagem++;

                        //ORDENAR AS LISTAS TEMPORARIAS DE INPUT EM FORMA CRESCENTE
                        sort(listaNumTemp);
                        sort(listaEsTemp);

                        //INSERÇÃO DA CHAVE PARA DENTRO DE ORIENTADOR DE OBJETO
                        CHAVES.add(new CHAVES(listaNumTemp.get(0), listaNumTemp.get(1), listaNumTemp.get(2), listaNumTemp.get(3), listaNumTemp.get(4), listaEsTemp.get(0), listaEsTemp.get(1)));

                        //LIMPAR AS LISTAS TEMPORARIAS, PARA NÃO EXISITIR A ACUMULAÇÃO DOS VALORES DA VOLTA ANTERIOR
                        listaNumTemp.clear();
                        listaEsTemp.clear();

                        //APENAS MOSTRAR A SEGUINTE MENSAGEM NO CASO DO JOGADOR ADQUIRIR MAIS QUE UM VALOR, PARA O UTILIZADOR VISUALIZAR OS VALORES QUE ACABOU DE INTRODUZIR NA CHAVE.
                        if (quantidadeBoletins > 1) {
                            System.out.println("\u001B[32mA sua chave foi registada com SUCESSO. Boa sorte! :)\u001B[0m\n" + CHAVES.get(contagem));

                        }
                        linha();


                    }

                    // APRESENTAÇÃO DO RESULTADO

                    System.out.println("\u001B[32mCHAVE VENCEDORA: \u001B[0m");
                    System.out.println(CHAVES.get(0));
                    System.out.println();
                    System.out.println("\u001B[32mAS SUAS CHAVES JOGADAS: \u001B[0m");
                    System.out.println();

                    //VARIÁVEIS DE CONTAGEM DE NÚMEROS/ESTRELAS ACERTADOS
                    int numAcertados;
                    int estrelasAcertadas;

                    //NÚMEROS ACERTADOS
                    for (int i = 1; i < quantidadeBoletins + 1; i++) {
                        numAcertados = 0;
                        estrelasAcertadas = 0;
                        System.out.println("\t\t\u001B[34mBoletim Nº " + i+"\u001B[0m");
                        System.out.println();
                        System.out.println(CHAVES.get(i));
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(1).getNr3()) || numerosChave.contains(CHAVES.get(1).getNr4()) || numerosChave.contains(CHAVES.get(1).getNr5())) {
                            //Acertou 1 numero
                            numAcertados = 1;
                        }
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(1).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(1).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(1).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(1).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr4())) {
                            //Acertou 2 numeros
                            numAcertados = 2;

                        }
                        if (numerosChave.contains(CHAVES.get(1).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2())
                                || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr3())
                                || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(1).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1())
                                || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(1).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1())
                                || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(1).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr3())) {
                            //Acertou 3 numeros
                            numAcertados = 3;
                        }
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(1).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3())
                                || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3())
                                || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4())
                                || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1())
                                || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1())) {
                            //Acertou 4 numeros
                            numAcertados = 4;

                        }
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5())) {
                            numAcertados = 5;
                            //Acertou 5 numeros
                        }

                        //ESTRELAS ACERTADAS
                        if (estrelasChave.contains(CHAVES.get(i).getE1()) || estrelasChave.contains(CHAVES.get(i).getE2())) {
                            estrelasAcertadas = 1;
                            //Acertou 1 estrela"
                        }
                        if (estrelasChave.contains(CHAVES.get(i).getE1()) && estrelasChave.contains(CHAVES.get(i).getE2()) || estrelasChave.contains(CHAVES.get(i).getE2()) && estrelasChave.contains(CHAVES.get(i).getE1())) {
                            estrelasAcertadas = 2;
                            //Acertou 2 estrelas")
                        }

                        //OUTPUT RESULTADO FINAL
                        if (numAcertados == 0 && estrelasAcertadas == 0) {
                            System.out.println("\u001B[31mInfelizmente, não acertou em nenhum dos valores.\u001B[0m");
                        }
                        if (numAcertados == 0 && estrelasAcertadas == 1) {
                            System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                            System.out.println("Prémio: € 0 ");
                        }
                        if (numAcertados == 0 && estrelasAcertadas == 2) {
                            System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                            System.out.println("Prémio: € 0 ");
                        }
                        if (numAcertados == 1) {
                            System.out.println("\u001B[32mAcertou 1 Número!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("Prémio: € 0 ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("11º Prémio: € 7,29 ");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("Prémio: € 0 ");
                            }
                        }
                        if (numAcertados == 2) {
                            System.out.println("\u001B[32mAcertou 2 números!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("12º Prémio: € 5,49 ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("8º Prémio: € 16,77 ");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("13.º Prémio: € 4,40 ");
                            }
                        }
                        if (numAcertados == 3) {
                            System.out.println("\u001B[32mAcertou 3 números!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("9.º Prémio: € 11,80  ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("6.º Prémio: € 76,27  ");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("10.º Prémio: € 10,68  ");
                            }
                        }
                        if (numAcertados == 4) {
                            System.out.println("\u001B[32mAcertou 4 número!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("5.º Prémio: € 120,59 ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("4.º Prémio: € 2.047,37");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("7.º Prémio: € 47,44 ");
                            }
                        }
                        if (numAcertados == 5) {
                            System.out.println("\u001B[32mAcertou 5 número!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("2.º Prémio: € 750.000,00 ");

                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("1.º Prémio: € 100.000.000,00 ");

                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("3.º Prémio: € 152.669,50");
                            }
                        }
                    }
                    in.nextLine();      // SERVE PARA REANICIAR O LOOP LIMPO!
                    CHAVES.clear();     // REANICIA AS LISTAS DE OBJETOS
                    contagem = 0;       //REANICIA A CONTAGEM
                    break;

                } else if (escolha == 0){
                    linha();
                    System.out.println("\u001B[31m<< Programa Encerrado >>\u001B[0m");
                    return;
                }



                //////////////////////////////////////////////////////////////////////////////////////////////////////
                else if (escolha == 2) {
                    int n1;
                    int n2;
                    int n3;
                    int n4;
                    int n5;
                    int es1;
                    int es2;


                    //Nº DE BOLETINS A SOLICITAR PELO UTILIZADOR
                    linha();
                    while (true) {
                        try {
                            System.out.println("Insira a quantidade de boletins que deseja adquirir (max. 5 uni.)");
                            quantidadeBoletins = in.nextInt();
                            if (quantidadeBoletins > 0 && quantidadeBoletins < 6) {
                                linha();
                                break;
                            } else {
                                System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 5.\u001B[0m");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                        }
                        in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                    }

                    for (int i = 0; i < quantidadeBoletins; i++) {

                        //LISTAS DE ARMAZENAMENTO TEMPORÁRIO.
                        List<Integer> listaNumTemp = new ArrayList<Integer>();
                        List<Integer> listaEsTemp = new ArrayList<Integer>();

                        /////////////
                        System.out.println("\t\t\t\t\t\u001B[34mBoletim Nº " + (i + 1)+"\u001B[0m");
                        System.out.println();

                        // GERAR 5 NUMEROS ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                        for (int j = 0; j < tamListaNumeros; j++) {
                            int rand = random.nextInt(1, 51);
                            if (!listaNumTemp.contains(rand)) {
                                listaNumTemp.add(rand);
                            } else {
                                // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 5 ELEMENTOS DIFERENTES
                                tamListaNumeros++;
                            }
                        }

                        // GERAR 2 NUMEROS("ESTRELAS") ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                        for (int k = 0; k < tamListaEstrelas; k++) {
                            int rand = random.nextInt(1, 12);
                            if (!listaEsTemp.contains(rand)) {
                                listaEsTemp.add(rand);
                            } else {
                                // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 2 ELEMENTOS DIFERENTES
                                tamListaEstrelas++;
                            }
                        }

                        contagem++;

                        //ORDENAR AS LISTAS TEMPORARIAS DE INPUT EM FORMA CRESCENTE
                        sort(listaNumTemp);
                        sort(listaEsTemp);

                        //INSERÇÃO DA CHAVE PARA DENTRO DE ORIENTADOR DE OBJETO
                        CHAVES.add(new CHAVES(listaNumTemp.get(0), listaNumTemp.get(1), listaNumTemp.get(2), listaNumTemp.get(3), listaNumTemp.get(4), listaEsTemp.get(0), listaEsTemp.get(1)));

                        //LIMPAR AS LISTAS TEMPORARIAS, PARA NÃO EXISITIR A ACUMULAÇÃO DOS VALORES DA VOLTA ANTERIOR
                        listaNumTemp.clear();
                        listaEsTemp.clear();

                        //APENAS MOSTRAR A SEGUINTE MENSAGEM NO CASO DO JOGADOR ADQUIRIR MAIS QUE UM VALOR, PARA O UTILIZADOR VISUALIZAR OS VALORES QUE ACABOU DE INTRODUZIR NA CHAVE.
                        if (quantidadeBoletins > 1) {
                            System.out.println("\u001B[32mA sua chave foi registada com SUCESSO. Boa sorte! :)\u001B[0m\n" + CHAVES.get(contagem));
                            Thread.sleep(1000);
                        }
                        linha();

                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("\u001B[32mCHAVE VENCEDORA: \u001B[0m");
                    System.out.println(CHAVES.get(0));
                    System.out.println();
                    System.out.println("\u001B[32mAS SUAS CHAVES JOGADAS: \u001B[0m");
                    System.out.println();


                    //VARIÁVEIS DE CONTAGEM DE NÚMEROS/ESTRELAS ACERTADOS
                    int numAcertados;
                    int estrelasAcertadas;

                    //NÚMEROS ACERTADOS
                    for (int i = 1; i < quantidadeBoletins + 1; i++) {
                        Thread.sleep(1000);
                        numAcertados = 0;
                        estrelasAcertadas = 0;
                        System.out.println("\t\t\u001B[34mBoletim Nº " + i+"\u001B[0m");
                        System.out.println();
                        System.out.println(CHAVES.get(i));
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(1).getNr3()) || numerosChave.contains(CHAVES.get(1).getNr4()) || numerosChave.contains(CHAVES.get(1).getNr5())) {
                            //Acertou 1 numero
                            numAcertados = 1;
                        }
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(1).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(1).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(1).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5())
                                || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(1).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr4())) {
                            //Acertou 2 numeros
                            numAcertados = 2;

                        }
                        if (numerosChave.contains(CHAVES.get(1).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2())
                                || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr3())
                                || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(1).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1())
                                || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(1).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1())
                                || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(1).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr3())) {
                            //Acertou 3 numeros
                            numAcertados = 3;
                        }
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(1).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3())
                                || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3())
                                || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) || numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4())
                                || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) || numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1())
                                || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr3()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr4()) || numerosChave.contains(CHAVES.get(i).getNr5()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr1())) {
                            //Acertou 4 numeros
                            numAcertados = 4;

                        }
                        if (numerosChave.contains(CHAVES.get(i).getNr1()) && numerosChave.contains(CHAVES.get(i).getNr2()) && numerosChave.contains(CHAVES.get(i).getNr3()) && numerosChave.contains(CHAVES.get(i).getNr4()) && numerosChave.contains(CHAVES.get(i).getNr5())) {
                            numAcertados = 5;
                            //Acertou 5 numeros
                        }

                        //ESTRELAS ACERTADAS
                        if (estrelasChave.contains(CHAVES.get(i).getE1()) || estrelasChave.contains(CHAVES.get(i).getE2())) {
                            estrelasAcertadas = 1;
                            //Acertou 1 estrela
                        }
                        if (estrelasChave.contains(CHAVES.get(i).getE1()) && estrelasChave.contains(CHAVES.get(i).getE2()) || estrelasChave.contains(CHAVES.get(i).getE2()) && estrelasChave.contains(CHAVES.get(i).getE1())) {
                            estrelasAcertadas = 2;
                            //Acertou 2 estrelas
                        }

                        //OUTPUT RESULTADO
                        if (numAcertados == 0 && estrelasAcertadas == 0) {
                            System.out.println("\u001B[31mInfelizmente, não acertou em nenhum dos valores.\u001B[0m");
                        }
                        if (numAcertados == 0 && estrelasAcertadas == 1) {
                            System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                            System.out.println("Prémio: € 0 ");
                        }
                        if (numAcertados == 0 && estrelasAcertadas == 2) {
                            System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                            System.out.println("Prémio: € 0 ");
                        }
                        if (numAcertados == 1) {
                            System.out.println("\u001B[32mAcertou 1 Número!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("Prémio: € 0 ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("11º Prémio: € 7,29 ");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("Prémio: € 0 ");
                            }
                        }
                        if (numAcertados == 2) {
                            System.out.println("\u001B[32mAcertou 2 números!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("12º Prémio: € 5,49 ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("8º Prémio: € 16,77 ");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("13.º Prémio: € 4,40 ");
                            }
                        }
                        if (numAcertados == 3) {
                            System.out.println("\u001B[32mAcertou 3 números!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("9.º Prémio: € 11,80  ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("6.º Prémio: € 76,27  ");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("10.º Prémio: € 10,68  ");
                            }
                        }
                        if (numAcertados == 4) {
                            System.out.println("\u001B[32mAcertou 4 número!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("5.º Prémio: € 120,59 ");
                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("4.º Prémio: € 2.047,37");
                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("7.º Prémio: € 47,44 ");
                            }
                        }
                        if (numAcertados == 5) {
                            System.out.println("\u001B[32mAcertou 5 número!\u001B[0m");
                            if (estrelasAcertadas == 1) {
                                System.out.println("\u001B[32mAcertou 1 Estrela!\u001B[0m");
                                System.out.println("2.º Prémio: € 750.000,00 ");

                            }
                            if (estrelasAcertadas == 2) {
                                System.out.println("\u001B[32mAcertou 2 Estrelas!\u001B[0m");
                                System.out.println("1.º Prémio: € 100.000.000,00 ");

                            }
                            if(estrelasAcertadas == 0) {
                                System.out.println("3.º Prémio: € 152.669,50");
                            }
                        }
                    }
                    in.nextLine();      // SERVE PARA REANICIAR O LOOP!
                    CHAVES.clear();     // REANICIA AS LISTAS DE OBJETOS
                    contagem = 0;       //REANICIA A CONTAGEM
                    break;

                }

                // TENTATIVAS SIMULADOR 1º PREMIO
                else if (escolha == 3) {
                    System.out.println();
                    System.out.println(" \u001B[36m[ 1 ]\u001B[0m - \u001B[33mINSERIR CHAVE MANUALMENTE\u001B[0m");
                    System.out.println(" \u001B[36m[ 2 ]\u001B[0m - \u001B[33mGERAR CHAVE ALEATORIA\u001B[0m");
                    System.out.println(" \u001B[36m[ 0 ]\u001B[0m - \u001B[33mVOLTAR AO MENU PRINCIPAL\u001B[0m");

                    System.out.println();
                    linha();
                    int escolhaManualAleatoria;

                    //VERIFICAÇÃO DE ERROS E EXCEÇÕES
                    while (true) {

                        try {
                            System.out.println("Sua opção: ");
                            escolhaManualAleatoria = in.nextInt();
                            if (escolhaManualAleatoria > -1 && escolhaManualAleatoria < 3) {
                                break;
                            } else {
                                System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 2.\u001B[0m");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                        }
                        in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                    }

                    if (escolhaManualAleatoria == 1) {

                        int n1, n2, n3, n4, n5, es1, es2;

                        //LISTAS DE ARMAZENAMENTO TEMPORÁRIO.
                        List<Integer> listaNumTemp = new ArrayList<Integer>();
                        List<Integer> listaEsTemp = new ArrayList<Integer>();
                        System.out.println();

                        //TRATAMENTO DE ERROS //////////////////////////////////////////////////////////////////////////////////////////////
                        while (true) {
                            try {
                                System.out.println("1º Número: ");
                                n1 = in.nextInt();
                                if (n1 > 0 && n1 < 51) {
                                    listaNumTemp.add(n1);
                                    break;
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }
                        while (true) {
                            try {
                                System.out.println("2º Número: ");
                                n2 = in.nextInt();
                                if (n2 > 0 && n2 < 51) {
                                    if (listaNumTemp.contains(n2)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n2);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("3º Número: ");
                                n3 = in.nextInt();
                                if (n3 > 0 && n3 < 51) {
                                    if (listaNumTemp.contains(n3)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n3);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("4º Número: ");
                                n4 = in.nextInt();
                                if (n4 > 0 && n4 < 51) {
                                    if (listaNumTemp.contains(n4)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n4);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("5º Número: ");
                                n5 = in.nextInt();
                                if (n5 > 0 && n5 < 51) {
                                    if (listaNumTemp.contains(n5)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaNumTemp.add(n5);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 50.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("1ª Estrela: ");
                                es1 = in.nextInt();
                                if (es1 > 0 && es1 < 51) {
                                    if (listaEsTemp.contains(es1)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaEsTemp.add(es1);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 11.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }

                        while (true) {
                            try {
                                System.out.println("2ª Estrela: ");
                                es2 = in.nextInt();
                                if (es2 > 0 && es2 < 51) {
                                    if (listaEsTemp.contains(es2)) {
                                        System.out.println("\u001B[31mEste número já foi registado! Por favor, selecione outro valor.\u001B[0m");
                                    } else {
                                        listaEsTemp.add(es2);
                                        break;
                                    }
                                } else {
                                    System.out.println("\u001B[31mERRO! Por favor, insira valor entre 1 a 11.\u001B[0m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\u001B[31mERRO! Por favor, insira um valor válido.\u001B[0m");
                            }
                            in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        }
                        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                        //ORDENAR AS LISTAS TEMPORARIAS DE INPUT EM FORMA CRESCENTE
                        sort(listaNumTemp);
                        sort(listaEsTemp);

                        //INSERÇÃO DA CHAVE PARA DENTRO DE ORIENTADOR DE OBJETO
                        CHAVES.add(new CHAVES(listaNumTemp.get(0), listaNumTemp.get(1), listaNumTemp.get(2), listaNumTemp.get(3), listaNumTemp.get(4), listaEsTemp.get(0), listaEsTemp.get(1)));


                        linha();
                        System.out.println("\u001B[32mA sua chave foi registada com SUCESSO!\u001B[0m\n" + CHAVES.get(1));
                        linha();
                        System.out.println("\u001B[37mCuriosidade: A chance de ganhar o 1º Prémio de Euromilhões é de 0.0000007%, ou 1 em 139,838,160. BOA SORTE! :)\u001B[0m");
                        System.out.println();
                        System.out.println("DESEJA INICIAR O SIMULADOR? [S/N]");
                        System.out.println();
                        in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        String escolha2;
                        while (true) {
                            System.out.println("Sua escolha: ");
                            escolha2 = in.nextLine().toUpperCase(Locale.ROOT);
                            if (escolha2.contains("S")) {
                                int totaltentativas = 0;
                                while (true) {
                                    totaltentativas ++;
                                    List<Integer> numerosChaveTentativa = new ArrayList<Integer>();                              //NUMEROS
                                    List<Integer> estrelasChaveTentativa = new ArrayList<Integer>();                            //ESTRELAS

                                    //REANICIAR A VARIAVEL
                                    tamListaNumeros = 5;
                                    tamListaEstrelas = 2;

                                    // GERAR 5 NUMEROS ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                                    for (int q = 0; q < tamListaNumeros; q++) {
                                        int rand = random.nextInt(1, 51);
                                        if (!numerosChaveTentativa.contains(rand)) {
                                            numerosChaveTentativa.add(rand);
                                        } else {
                                            // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 5 ELEMENTOS DIFERENTES
                                            tamListaNumeros++;
                                        }
                                    }

                                    // GERAR 2 NUMEROS("ESTRELAS") ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                                    for (int w = 0; w < tamListaEstrelas; w++) {
                                        int rand = random.nextInt(1, 12);
                                        if (!estrelasChaveTentativa.contains(rand)) {
                                            estrelasChaveTentativa.add(rand);
                                        } else {
                                            // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 2 ELEMENTOS DIFERENTES
                                            tamListaEstrelas++;
                                        }
                                    }

                                    // ORDENAR A LISTA DOS NUMEROS DE FORMA CRESCENTE
                                    sort(numerosChaveTentativa);
                                    // ORDENAR A LISTA DAS ESTRELAS DE FORMA CRESCENTE
                                    sort(estrelasChaveTentativa);

                                    // CRIAÇÃO
                                    CHAVES.add(new CHAVES(numerosChaveTentativa.get(0), numerosChaveTentativa.get(1), numerosChaveTentativa.get(2), numerosChaveTentativa.get(3), numerosChaveTentativa.get(4), estrelasChaveTentativa.get(0), estrelasChaveTentativa.get(1)));

                                    boolean igual = CHAVES.get(1).equals(CHAVES.get(2));
                                    if (igual) {

                                        //PROVAVELMENTE NUNCA IRÁ ACONTECER
                                        linha();
                                        System.out.println("\u001B[34mPREMIO 1!!!\u001B[0m");
                                        System.out.println();
                                        System.out.println("\u001B[32mA SUA CHAVE JOGADA: \u001B[0m");
                                        System.out.println(CHAVES.get(1));
                                        System.out.println();
                                        System.out.println("\u001B[32mCHAVE VENCEDORA: \u001B[0m");
                                        System.out.println();
                                        System.out.println(CHAVES.get(2));
                                        System.out.println("\u001B[31mNº de tentativas: "+ totaltentativas+"\u001B[0m");
                                        return;
                                    } else {
                                        linha();
                                        System.out.println("\u001B[32mA SUA CHAVE JOGADA: \u001B[0m");
                                        System.out.println(CHAVES.get(1));
                                        System.out.println();
                                        System.out.println("\u001B[32mCHAVE VENCEDORA: \u001B[0m");
                                        System.out.println();
                                        System.out.println(CHAVES.get(2));
                                        System.out.println("\u001B[31mNº de tentativas: "+ totaltentativas+"\u001B[0m");
                                        CHAVES.remove(2);
                                    }

                                    //LIMPAR AS LISTAS
                                    numerosChaveTentativa.clear();
                                    estrelasChaveTentativa.clear();
                            }



                        } else if (escolha2.contains("N")) {
                            CHAVES.remove(1);
                            contagem = 0;
                            break;
                        } else {
                            System.out.println("\u001B[31mERRO! Por favor, insira uma opção válido.\u001B[0m");
                        }
                    }

                    }if (escolhaManualAleatoria == 2) {                         // GERAR UMA CHAVE ALEATORIA PARA O SIMULADOR DO 1º PREMIO

                        int n1, n2, n3, n4, n5, es1, es2;

                        //LISTAS DE ARMAZENAMENTO TEMPORÁRIO.
                        List<Integer> listaNumTemp = new ArrayList<Integer>();
                        List<Integer> listaEsTemp = new ArrayList<Integer>();
                        System.out.println();

                        //REANICIAR AS VARIAVEIS PARA NÃO EXISTIR ACUMULAÇÃO
                        tamListaNumeros = 5;
                        tamListaEstrelas = 2;

                        // GERAR 5 NUMEROS ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                        for (int j = 0; j < tamListaNumeros; j++) {
                            int rand = random.nextInt(1, 51);
                            if (!listaNumTemp.contains(rand)) {
                                listaNumTemp.add(rand);
                            } else {
                                // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 5 ELEMENTOS DIFERENTES
                                tamListaNumeros++;
                            }
                        }

                        // GERAR 2 NUMEROS("ESTRELAS") ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                        for (int k = 0; k < tamListaEstrelas; k++) {
                            int rand = random.nextInt(1, 12);
                            if (!listaEsTemp.contains(rand)) {
                                listaEsTemp.add(rand);
                            } else {
                                // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 2 ELEMENTOS DIFERENTES
                                tamListaEstrelas++;
                            }
                        }

                        //ORDENAR A LISTA TEMPORARIA RANDOM EM FORMA CRESCENTE
                        sort(listaNumTemp);
                        sort(listaEsTemp);

                        //INSERÇÃO DA CHAVE PARA DENTRO DE ORIENTADOR DE OBJETO
                        CHAVES.add(new CHAVES(listaNumTemp.get(0), listaNumTemp.get(1), listaNumTemp.get(2), listaNumTemp.get(3), listaNumTemp.get(4), listaEsTemp.get(0), listaEsTemp.get(1)));

                        linha();
                        System.out.println("\u001B[32mA sua chave foi registada com SUCESSO!\u001B[0m\n" + CHAVES.get(1));
                        linha();
                        System.out.println("\u001B[37mCuriosidade: A chance de ganhar o 1º Prémio de Euromilhões é de 0.0000007%, ou 1 em 139,838,160. BOA SORTE! :)\u001B[0m");
                        System.out.println();
                        System.out.println("DESEJA INICIAR O SIMULADOR? [S/N]");
                        System.out.println();
                        in.nextLine();  // OBRIGATORIO PARA NÃO FICAR EM LOOP INFINITO!
                        String escolha2;
                        while (true) {
                            System.out.println("Sua escolha: ");
                            escolha2 = in.nextLine().toUpperCase(Locale.ROOT);
                            if (escolha2.contains("S")) {
                                int totaltentativas = 0;
                                while (true) {
                                    totaltentativas++;
                                    List<Integer> numerosChaveTentativa = new ArrayList<Integer>();                              //NUMEROS
                                    List<Integer> estrelasChaveTentativa = new ArrayList<Integer>();                            //ESTRELAS

                                    //REANICIAR A VARIAVEL
                                    tamListaNumeros = 5;
                                    tamListaEstrelas = 2;

                                    // GERAR 5 NUMEROS ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                                    for (int q = 0; q < tamListaNumeros; q++) {
                                        int rand = random.nextInt(1, 51);
                                        if (!numerosChaveTentativa.contains(rand)) {
                                            numerosChaveTentativa.add(rand);
                                        } else {
                                            // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 5 ELEMENTOS DIFERENTES
                                            tamListaNumeros++;
                                        }
                                    }

                                    // GERAR 2 NUMEROS("ESTRELAS") ALEATORIOS E ENVIAR PARA DENTRO DA LISTA
                                    for (int w = 0; w < tamListaEstrelas; w++) {
                                        int rand = random.nextInt(1, 12);
                                        if (!estrelasChaveTentativa.contains(rand)) {
                                            estrelasChaveTentativa.add(rand);
                                        } else {
                                            // FAZ COM QUE A LISTA NUNCA TENHA MENOS QUE 2 ELEMENTOS DIFERENTES
                                            tamListaEstrelas++;
                                        }
                                    }

                                    // ORDENAR A LISTA DOS NUMEROS DE FORMA CRESCENTE
                                    sort(numerosChaveTentativa);
                                    // ORDENAR A LISTA DAS ESTRELAS DE FORMA CRESCENTE
                                    sort(estrelasChaveTentativa);

                                    // CRIAÇÃO
                                    CHAVES.add(new CHAVES(numerosChaveTentativa.get(0), numerosChaveTentativa.get(1), numerosChaveTentativa.get(2), numerosChaveTentativa.get(3), numerosChaveTentativa.get(4), estrelasChaveTentativa.get(0), estrelasChaveTentativa.get(1)));

                                    boolean igual = CHAVES.get(1).equals(CHAVES.get(2));
                                    if (igual) {

                                        //PROVAVELMENTE NUNCA IRÁ ACONTECER
                                        linha();
                                        System.out.println("\u001B[34mPREMIO 1!!!\u001B[0m");
                                        System.out.println();
                                        System.out.println("\u001B[32mA SUA CHAVE JOGADA: \u001B[0m");
                                        System.out.println(CHAVES.get(1));
                                        System.out.println();
                                        System.out.println("\u001B[32mCHAVE VENCEDORA: \u001B[0m");
                                        System.out.println(CHAVES.get(2));
                                        System.out.println("\u001B[31mNº de tentativas: " + totaltentativas + "\u001B[0m");
                                        return;
                                    } else {
                                        linha();
                                        System.out.println("\u001B[32mA SUA CHAVE JOGADA: \u001B[0m");
                                        System.out.println(CHAVES.get(1));
                                        System.out.println();
                                        System.out.println("\u001B[32mCHAVE VENCEDORA: \u001B[0m");
                                        System.out.println(CHAVES.get(2));
                                        System.out.println("\u001B[31mNº de tentativas: " + totaltentativas + "\u001B[0m");
                                        CHAVES.remove(2);
                                    }

                                    numerosChaveTentativa.clear();
                                    estrelasChaveTentativa.clear();
                                }


                            } else if (escolha2.contains("N")) {
                                CHAVES.remove(1);
                                contagem = 0;
                                break;
                            } else {
                                System.out.println("\u001B[31mERRO! Por favor, insira uma opção válido.\u001B[0m");
                            }
                        }
                    } else if (escolhaManualAleatoria == 0) {
                        break;
                    }

                }
            }
        }

    }

    public static void linha() {
        System.out.println("\u001B[36m =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\u001B[0m ");
    }

    public static void MenuPrincipal() {

        System.out.println("\t\t\t\t\tMENU PRINCIPAL");
        System.out.println();
        System.out.println(" \u001B[36m[ 1 ]\u001B[0m - \u001B[33mJOGAR MANUALMENTE (1 A 5 CHAVES)\u001B[0m");
        System.out.println(" \u001B[36m[ 2 ]\u001B[0m - \u001B[33mJOGAR ALEATORIAMENTE (1 A 5 CHAVES)\u001B[0m");
        System.out.println(" \u001B[36m[ 3 ]\u001B[0m - \u001B[33mSIMULADOR TENTANTIVAS 1º PREMIO\u001B[0m");
        System.out.println(" \u001B[36m[ 0 ]\u001B[0m - \u001B[33mENCERRAR PROGRAMA\u001B[0m");
        System.out.println();
        linha();
    }

}
