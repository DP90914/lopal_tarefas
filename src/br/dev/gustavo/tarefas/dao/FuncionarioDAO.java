package br.dev.gustavo.tarefas.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.dev.gustavo.tarefas.model.Funcionario;

public class FuncionarioDAO {
	private Funcionario funcionario;
	private FileWriter fw;
	private BufferedWriter bw;
	private String arquivo = "/Users/25132581/tarefasDS1TA/funcionarios.csv";
	
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
		try {
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
		}
	public void salvar() {
		try {
			bw.write(funcionario.toString());
			bw.flush();
			System.out.println(funcionario.getNome() + " gravado com sucelso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
