package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import services.ContractService;

public class Main{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ContractService contractService = new ContractService();
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        Integer number = sc.nextInt();
        System.out.print("Data (dd/mm/aaaa): ");
        sc.nextLine();
        String date = sc.nextLine();
        System.out.print("Valor do contrato: ");
        double value = sc.nextDouble();
        System.out.print("Número de parcelas: ");
        Integer installments_quantity = sc.nextInt();

        Contract contract = new Contract(number, LocalDate.parse(date, fmt), value);

        contractService.processContract(contract, installments_quantity);

        System.out.println("Parcelas: ");
        for(int i = 0; i < installments_quantity; i++){
            String dateShown = contract.getInstallments().get(i).getDueDate().format(fmt);
            Double amountShown = contract.getInstallments().get(i).getAmount();

            System.out.println(dateShown + " - " + amountShown);
        }

        sc.close();
    }
}