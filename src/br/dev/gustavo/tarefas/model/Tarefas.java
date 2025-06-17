package br.dev.gustavo.tarefas.model;

import java.awt.Toolkit;
import java.time.LocalDate;

public class Tarefas {

	private String nome;
	private String descricao;
	private Toolkit dataInicio;
	private int prazo;
	private Toolkit dataPrevisaoEntrega;
	private LocalDate dataPrevisao;
	private Status status;
	private Funcionario responsavel;
	
	public Tarefas() {
		System.out.println("criando uma trarefa...");
	}
	public Tarefas(String nome) {
		System.out.println("criando a trarefa" + nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Toolkit getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Toolkit toolkit) {
		
		this.dataInicio = toolkit;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public Toolkit getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}

	public void setDataPrevisaoEntrega(Toolkit toolkit) {
		this.dataPrevisaoEntrega = toolkit;
	}

	public LocalDate getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(LocalDate dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	public String toString() {
		return nome + "," + descricao + "," + responsavel + "," + dataInicio + "," + prazo + "," + dataPrevisaoEntrega + "," + status +"\n";
	}
}


