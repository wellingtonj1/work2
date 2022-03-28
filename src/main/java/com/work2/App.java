package com.work2;
import java. util.ArrayList;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // clear the screen
        helper.print("\033[H\033[2J");
        helper.print("Olá... esta é a resolução do exercício 2");
        
        List<ContaBancaria> contas = new ArrayList<ContaBancaria>();

        int opcao = 0;

        do {
            
            helper.print("Insira o numero de acordo com o que deseja fazer:");
            helper.print("Adicionar nova conta              - 1");
            helper.print("Remover conta                     - 2");
            helper.print("Depositar                         - 3");
            helper.print("Retirar                           - 4");
            helper.print("Transferir para outra conta       - 5");
            helper.print("Mostrar Saldo de todas as contas  - 6");
            helper.print("Sair                              - 0");

            opcao = helper.scan().nextInt();

            switch (opcao) {
                
                case 1:
                
                    helper.print("Insira o nome da conta:");
                    String nomeConta = helper.scan().next();
                    helper.print("Insira o saldo da conta:");
                    double saldo = helper.scan().nextDouble();
                    ContaBancaria conta = new ContaBancaria(nomeConta, saldo);
                    helper.print("\033[H\033[2J");
                    helper.print("Conta adicionada com sucesso!");
                    contas.add(conta);

                    break;
                
                case 2: 

                    // search in list for the name
                    helper.print("Insira o nome da conta:");
                    String nomeConta2 = helper.scan().next();
                    boolean found = false;
                    
                    for (ContaBancaria conta2 : contas) {
                        if (conta2.getNomeConta().equals(nomeConta2)) {
                            contas.remove(conta2);
                            helper.print("\033[H\033[2J");
                            helper.print("Conta removida com sucesso!");
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        helper.print("\033[H\033[2J");
                        helper.print("Conta "+ nomeConta2 +"não encontrada!");
                    }

                    break;

                case 3:

                    // realiza deposito na conta informada
                    helper.print("Insira o nome da conta:");
                    String nomeConta3 = helper.scan().next();
                    helper.print("Insira o valor do deposito:");
                    double valor = helper.scan().nextDouble();
                    boolean found3 = false;

                    for (ContaBancaria conta3 : contas) {
                        if (conta3.getNomeConta().equals(nomeConta3)) {
                            conta3.setSaldo(conta3.getSaldo() + valor);
                            helper.print("\033[H\033[2J");
                            helper.print("Deposito realizado com sucesso!");
                            found3 = true;
                            break;
                        }
                    }

                    if (!found3) {
                        helper.print("\033[H\033[2J");
                        helper.print("Conta "+nomeConta3+" não encontrada!");
                    }

                    break;

                case 4:

                    // realiza retirada na conta informada
                    helper.print("Insira o nome da conta:");
                    String nomeConta4 = helper.scan().next();
                    helper.print("Insira o valor do retirada:");
                    double valor4 = helper.scan().nextDouble();
                    boolean found4 = false;

                    for (ContaBancaria conta4 : contas) {
                        if (conta4.getNomeConta().equals(nomeConta4)) {
                            if (conta4.getSaldo() >= valor4) {
                                conta4.setSaldo(conta4.getSaldo() - valor4);
                                helper.print("\033[H\033[2J");
                                helper.print("Retirada realizada com sucesso!");
                                found4 = true;
                                break;
                            } else {
                                helper.print("\033[H\033[2J");
                                helper.print("Saldo insuficiente!");
                                found4 = true;
                                break;
                            }
                        }
                    }

                    if (!found4) {
                        helper.print("\033[H\033[2J");
                        helper.print("Conta "+nomeConta4+" não encontrada!");
                    }

                    break;

                case 5:
                    
                    // realiza transferencia entre contas
                    helper.print("Insira o nome da conta de origem:");
                    String nomeConta5 = helper.scan().next();
                    helper.print("Insira o nome da conta de destino:");
                    String nomeConta6 = helper.scan().next();
                    helper.print("Insira o valor da transferencia:");
                    double valor5 = helper.scan().nextDouble();
                    boolean found6 = false;

                    for (ContaBancaria conta5 : contas) {

                        if (conta5.getNomeConta().equals(nomeConta5)) {
                            
                            if (conta5.getSaldo() >= valor5) {
                                
                                for (ContaBancaria conta6 : contas) {
                                    if (conta6.getNomeConta().equals(nomeConta6)) {
                                        found6 = true;
                                        conta5.setSaldo(conta5.getSaldo() - valor5);
                                        conta6.setSaldo(conta6.getSaldo() + valor5);
                                        helper.print("\033[H\033[2J");
                                        helper.print("Transferencia realizada com sucesso;");
                                    }
                                }

                                if(!found6) {

                                    helper.print("\033[H\033[2J");
                                    helper.print("Conta "+nomeConta6+" não encontrada!");

                                }

                            } else {
                                helper.print("\033[H\033[2J");
                                helper.print("Saldo insuficiente!");
                            }
                        }

                    }

                    break;
                
                case 6:
                    
                    helper.print("\033[H\033[2J");
                    helper.print("Lista de contas:");
                    for (ContaBancaria conta5 : contas) {
                        helper.print(conta5.getNomeConta() + " => R$" + conta5.getSaldo());
                    }

                    break;
                
                default:
                break;
            }

            
        } while (opcao != 0);

    }
}
