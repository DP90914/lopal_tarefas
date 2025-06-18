package br.dev.gustavo.tarefas.model;

import java.awt.Toolkit;
import java.time.LocalDate;

import br.dev.gustavo.tarefas.utils.Utils;

public class Tarefas {

	private String nome;
	private String descricao;
	private String dataInicio;
	private int prazo;
	private LocalDate dataPrevisao;
	private String status;
	private String responsavel;
	private String codigo;
	
	public Tarefas() {
		System.out.println("criando uma trarefa...");
		this.codigo = Utils.gerarUUID8();
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

	public String getDataInicio() {
		return dataInicio;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void getCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDataInicio(String string) {
		
		this.dataInicio = string;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}


	public LocalDate getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(LocalDate dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String string) {
		this.status = string;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String string) {
		this.responsavel = string;
	}
	public String toString() {
		return codigo + "," + nome + "," + responsavel + "," + descricao + "," + dataInicio + "," + prazo + "," + dataPrevisao + "," + status +"\n";
	}
}


