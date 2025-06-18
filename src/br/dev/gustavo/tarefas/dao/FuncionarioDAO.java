package br.dev.gustavo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.gustavo.tarefas.model.Funcionario;

public class FuncionarioDAO {
	private Funcionario funcionario;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String arquivo = "/Users/25132581/tarefasDS1TA/funcionarios.csv";
//	private String arquivo = "C:\\Users\\25132581\\Desktop\\tarefasDS1TA\\funcionarios.csv";
	
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
		try {
			fw = new FileWriter(arquivo, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);
		} catch (Exception e) {
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
	
	public List<Funcionario> getFuncionarios() {
	    List<Funcionario> funcionarios = new ArrayList<>();

	    try {
	        String linha = ""; 
	        
	        while ((linha = br.readLine()) != null) { 
	            String[] funcionarioVetor = linha.split(",");
	            
	            
	            if (funcionarioVetor.length >= 4) { 
	                Funcionario funcionario = new Funcionario();
	                funcionario.setMatricula(funcionarioVetor[0]);
	                funcionario.setNome(funcionarioVetor[1]);
	                funcionario.setCargo(funcionarioVetor[2]);
	                funcionario.setSetor(funcionarioVetor[3]); 
	                funcionarios.add(funcionario);
	            } else {
	               
	                System.err.println("Linha malformada ignorada: " + linha);
	            }
	        }
	    } catch (Exception e) {
	        
	        System.err.println("Erro ao ler dados dos funcionários: " + e.getMessage());
	        e.printStackTrace();
	    } 
	    
	    
	    return funcionarios; 
	}
}