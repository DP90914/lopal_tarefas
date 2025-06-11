package br.dev.gustavo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.gustavo.tarefas.model.Funcionario;
import br.dev.gustavo.tarefas.model.Tarefas;

public class TarefaDAO {
	private Tarefas tarefa;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String arquivo = "/Users/25132581/tarefasDS1TA/tarefas.csv";
	
	public TarefaDAO(Tarefas tarefa) {
		this.tarefa = tarefa;
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
				bw.write(tarefa.toString());
				bw.flush();
				System.out.println(tarefa.getNome() + " gravado com sucelso!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public List<Tarefas> getTarefa() {
		    List<Tarefas> Tarefas = new ArrayList<>();

		    try {
		        String linha = ""; 
		        
		        while ((linha = br.readLine()) != null) { 
		            String[] tarefaVetor = linha.split(",");
		            
		            
		            if (tarefaVetor.length >= 4) { 
		            	Tarefas tarefa = new Tarefas();
		            	tarefa.setNome(tarefaVetor[0]);
		            	tarefa.setDescricao(tarefaVetor[1]);
//		            	tarefa.setResponsavel(tarefaVetor[2]); 
//		            	tarefa.setDataInicio(tarefaVetor[3]);
//		            	tarefa.setPrazo(tarefaVetor[4]); 
//		            	tarefa.setDataPrevisao(tarefaVetor[5]); 
//		            	tarefa.setStatus(tarefaVetor[6]); 

		            	Tarefas.add(tarefa);
		            } else {
		               
		                System.err.println("Linha malformada ignorada: " + linha);
		            }
		        }
		    } catch (Exception e) {
		        
		        System.err.println("Erro ao ler dados dos funcionários: " + e.getMessage());
		        e.printStackTrace();
		    } 
		    
		    
		    return Tarefas; 
		}
}

