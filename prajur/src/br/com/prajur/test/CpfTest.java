package br.com.prajur.test;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class CpfTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String cpf = "222.222.222-21";
		
		List<ValidationMessage> messages = new CPFValidator().invalidMessagesFor(cpf);
		
		for(ValidationMessage error : messages ) {
			System.out.println(error.getMessage());
		}
		
		new CPFValidator().assertValid(cpf);

	}

}
