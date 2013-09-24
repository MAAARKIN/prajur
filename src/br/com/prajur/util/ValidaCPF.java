package br.com.prajur.util;

public class ValidaCPF {
	
	String cpfWrong1 = "000.000.000-00";
	String cpfWrong2 = "111.111.111-11";
	String cpfWrong3 = "222.222.222-22";
	String cpfWrong4 = "333.333.333-33";
	String cpfWrong5 = "444.444.444-44";
	String cpfWrong6 = "555.555.555-55";
	String cpfWrong7 = "666.666.666-66";
	String cpfWrong8 = "777.777.777-77";
	String cpfWrong9 = "888.888.888-88";
	String cpfWrong10 = "999.999.999-99";
	
	public ValidaCPF() {
		
	}
	
	public boolean verificaCpf(String cpf) {
		if(cpf.equals(cpfWrong1) || cpf.equals(cpfWrong2) || 
		   cpf.equals(cpfWrong3) || cpf.equals(cpfWrong4) || 
		   cpf.equals(cpfWrong5) ||	cpf.equals(cpfWrong6) || 
		   cpf.equals(cpfWrong7) || cpf.equals(cpfWrong8) || 
		   cpf.equals(cpfWrong9) || cpf.equals(cpfWrong10)) {
			return false;
		}
		return true;
		
	}

}
