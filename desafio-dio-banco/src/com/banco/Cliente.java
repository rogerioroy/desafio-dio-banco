package com.banco;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Banco {

	private String nome;
	private String cpf;
	List<Cliente> listaCliente = new ArrayList<>();

	public Cliente() {}
	
	public Cliente(String nome , String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void incluirCliente(String nome, String cpf) {
		listaCliente.add(new Cliente(nome , cpf));
		super.incluirBanco();
	}

	public void listarCliente() {
		for (Object object : listaCliente) {
			System.out.println(object.toString());
		}
	}
	
	public void mostraCliente(int codigo) {
		super.mostraBanco(codigo);
		for (int i = 0 ; i < listaCliente.size() ; i++) {
			if (i== codigo) {
				System.out.println("TITULAR: " + listaCliente.get(i).nome+ "  CPF: "+listaCliente.get(i).cpf);
			}
		}

	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + "]";
	}

}
