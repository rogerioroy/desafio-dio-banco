package com.banco;

public class Main {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.incluirConta("Rogerio", "12345678901");
		conta.incluirConta("Sara", "99999999999");
		
		conta.depositar("CC", 1, 50.00);
		conta.depositar("CC", 2, 100.00);
		conta.depositar("CP", 2, 20.00);
		conta.depositar("CP", 2, 35.00);
		
		conta.sacar("CP", 2, 5);
		conta.sacar("CC", 1, 20);
		
		conta.tranferir("CP", 2, "CP", 1, 120);
		
		conta.extratoContas(1);
		conta.extratoContas(2);

	}
	
}
