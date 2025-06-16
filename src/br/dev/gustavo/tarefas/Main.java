package br.dev.gustavo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.gui.CriarTarefaGUI;
import br.dev.gustavo.tarefas.gui.FuncionarioGUI;
import br.dev.gustavo.tarefas.gui.FuncionariosListaGUI;
import br.dev.gustavo.tarefas.gui.TelaPrincipalGUI;
import br.dev.gustavo.tarefas.model.Funcionario;
import br.dev.gustavo.tarefas.model.Tarefas;

public class Main {

	static String caminho ="/Users/25132581/tarefasDS1TA/tarefas";
	
	public static void main(String[] args) {

//		FuncionarioDAO dao = new FuncionarioDAO(null);
//		dao.getFuncionarios();		
	
//		new FuncionarioGUI(null);
		
		new TelaPrincipalGUI(null);
		
//		new CriarTarefaGUI(null);
		
//		Funcionario f = new Funcionario("Pedro", "Programador");
//		f.setSetor("TI");
//
//		
//		Funcionario f2 = new Funcionario("Homer", "Programador");
//		f2.setSetor("TI");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f2);
//		dao.salvar();
		
	}
	private static void escreverArquivo(){
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(caminho, false);
			
			bw = new BufferedWriter(fw);
			
			bw.append("Logica de programacao \n");
			bw.append("Gustavo\n");
			bw.append("XPTO\n");

			bw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	private static void lerArquivo() {
		String caminho ="/Users/25132581/tarefasDS1TA/tarefas";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(caminho);	
			br = new BufferedReader(fr);
			
			String retorno = br.readLine();
			while(retorno != null) {
				System.out.println(retorno);
				retorno = br.readLine();		
			}
		
		} catch (FileNotFoundException error) {
			// TODO: handle exception
			System.out.println("O arquivo não foi encontrado");
		}catch(Exception error) {
			System.out.println("Ocorreu um erro");
		}
		System.out.println("Fin");
	}
}