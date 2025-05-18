package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;
import interfaces.PaymentService;

public class ContractService {

    public void processContract(Contract contract, Integer months){

        PaymentService paymentService = new PaypalService();

        for(int i = 0; i < months; i++){
            Double initialInstallmentValue = contract.getValue() / months;

            Double installmentValueWithInterest = paymentService.interest(initialInstallmentValue, i+1);

            Double installmentFinalValue = paymentService.paymentFee(installmentValueWithInterest);
            
            LocalDate dueDate = contract.getDate().plusMonths(i+1);

            Installment installment = new Installment(dueDate, installmentFinalValue);

            contract.addInstallment(installment);


            
        }
    }
    
}
