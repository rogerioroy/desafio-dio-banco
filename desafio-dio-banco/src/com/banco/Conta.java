package com.banco;

import java.util.ArrayList;
import java.util.List;

public class Conta extends Cliente {

	private static int SEQUENCIAL = 0;

	protected int numero;
	protected double saldo_cc;
	protected double saldo_cp;
	List<Conta> listaConta = new ArrayList<>();

	public Conta() {
		this.numero = SEQUENCIAL++;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo_cc() {
		return saldo_cc;
	}

	public double getSaldo_cp() {
		return saldo_cp;
	}

	public void setSaldo_cc(double saldo_cc) {
		this.saldo_cc = saldo_cc;
	}

	public void setSaldo_cp(double saldo_cp) {
		this.saldo_cp = saldo_cp;
	}

	public void incluirConta(String nome, String cpf) {
		incluirCliente(nome, cpf);
		listaConta.add(new Conta());
	}

	public void mostraConta(int codigo) {
		for (int i = 0; i < listaConta.size(); i++) {
			if (i == codigo) {
				System.out.println("NUMERO: " + listaConta.get(i).numero);
				System.out.println("SALDO CONTA CORRENTE: " + listaConta.get(i).saldo_cc);
				System.out.println("SALDO CONTA POUPAN?A: " + listaConta.get(i).saldo_cp);
			}
		}
	}

	public void extratoContas(int codigo) {
		codigo -= 1;
		System.out.println("*** EXTRATO DE CONTA ****");
		mostraCliente(codigo);
		mostraConta(codigo);
	}

	public void depositar(String tipo, int numero, double valor) {
		numero -= 1;
		if (tipo == "CC") {
			int saldo = (int) listaConta.get(numero).saldo_cc;
			listaConta.get(numero).setSaldo_cc(saldo + valor);
		} else if (tipo == "CP") {
			int saldo = (int) listaConta.get(numero).saldo_cp;
			listaConta.get(numero).setSaldo_cp(saldo + valor);
		}
	}

	public void sacar(String tipo, int numero, double valor) {
		numero -= 1;
		if (tipo == "CC") {
			int saldo = (int) listaConta.get(numero).saldo_cc;
			if (saldo >= valor) {
				listaConta.get(numero).setSaldo_cc(saldo - valor);
			} else {
				System.out.println("*** Saque n?o realizado - SALDO INSUFICIENTE ***");
			}
		} else if (tipo == "CP") {
			int saldo = (int) listaConta.get(numero).saldo_cp;
			if (saldo >= valor) {
				listaConta.get(numero).setSaldo_cp(saldo - valor);
			} else {
				System.out.println("*** Saque n?o realizado - SALDO INSUFICIENTE ***");
			}
		}
	}

	public void tranferir(String tipoOrigem, int numeroOrigem, String tipoDestino, int numeroDestino, double valor) {
		numeroOrigem -= 1;
		if (tipoOrigem == "CC") {
			int saldo = (int) listaConta.get(numeroOrigem).saldo_cc;
			if (saldo >= valor) {
				listaConta.get(numeroOrigem).setSaldo_cc(saldo - valor);
				
				depositar(tipoDestino, numeroDestino, valor);
			} else {
				System.out.println("*** Transfer?ncia n?o realizada - SALDO INSUFICIENTE ***");
			}
		} else if (tipoOrigem == "CP") {
			int saldo = (int) listaConta.get(numeroOrigem).saldo_cp;
			if (saldo >= valor) {
				listaConta.get(numeroOrigem).setSaldo_cp(saldo - valor);
				
				depositar(tipoDestino, numeroDestino, valor);
			} else {
				System.out.println("*** Transfer?ncia n?o realizada - SALDO INSUFICIENTE ***");
			}
		}				
	}

}
