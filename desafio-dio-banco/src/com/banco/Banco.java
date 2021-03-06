package com.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static final int AGENCIA_PADRAO = 1;
	private static final String BANCO_PADRAO = "BANCO POPULAR";
	
	protected int agencia;
	protected String nomeBanco;
	List<Banco> listaBanco = new ArrayList<>();
	
	public Banco() {
		this.agencia = AGENCIA_PADRAO;
		this.nomeBanco = BANCO_PADRAO;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public String getNomeBanco() {
		return nomeBanco;
	}
		
	public void incluirBanco() {
		listaBanco.add(new Banco());
	}

	public void listarBanco() {
		for (Object object : listaBanco) {
			System.out.println(object.toString());
		}
	}

	@Override
	public String toString() {
		return "Banco [agencia=" + agencia + ", nomeBanco=" + nomeBanco + "]";
	}
	
	public void mostraBanco(int codigo) {
		for (int i = 0 ; i < listaBanco.size() ; i++) {
			if (i== codigo) {
				System.out.println(listaBanco.get(i).nomeBanco);
				System.out.println("AGENCIA: " + listaBanco.get(i).agencia);
			}
		}
	}	
}
