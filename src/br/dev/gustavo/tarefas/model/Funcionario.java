package br.dev.gustavo.tarefas.model;

import java.util.UUID;

import br.dev.gustavo.tarefas.utils.Utils;

public class Funcionario {
	private String nome;
	private String setor;
	private String matricula;
	private String cargo;
	
	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
		this.matricula = Utils.gerarUUID8();
	}	
	public Funcionario(String nome) {
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();
		
	}
	public Funcionario() {
		this.matricula = Utils.gerarUUID8();
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		return matricula + "," + nome + "," + cargo + "," + setor + "\n";
	}
}
