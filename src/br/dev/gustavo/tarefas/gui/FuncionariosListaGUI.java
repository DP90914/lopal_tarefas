package br.dev.gustavo.tarefas.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.model.Funcionario;

public class FuncionariosListaGUI {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	private JTable tabelaFuncionarios;
	private DefaultTableModel modelFuncionarios;
	private JScrollPane scroll;
	
		public FuncionariosListaGUI() {
			// TODO Auto-generated constructor stub
			criarTela();
		} 
		
		private String[] colunas = {"CÓDIGO", "NOME DO FUNCIONARIO", "CARGO"};
			
	
		private void criarTela(){
			JFrame tela = new JFrame("tabela de Funcionarios");
			tela.setSize(600, 500);
			
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tela.setLayout(null);
			tela.setLocationRelativeTo(null);
			tela.setResizable(false);
			
			Container painel = tela.getContentPane();
			
			labelTitulo = new JLabel("cadastro de funcionarios");
			labelTitulo.setBounds(10, 10, 400, 40);
			labelTitulo.setForeground(new Color(100,0,100));
			labelTitulo.setFont(new Font("arial", Font.BOLD, 30));
			
			Object[][] dados = carregarDados();
			
			modelFuncionarios = new DefaultTableModel(dados, colunas);
			tabelaFuncionarios = new JTable(modelFuncionarios);
			scroll = new JScrollPane(tabelaFuncionarios);
			scroll.setBounds(10, 60, 580, 340);
			tabelaFuncionarios.setBounds(10, 60, 580, 340);
			
			btnNovo = new JButton("Novo");
			btnNovo.setBounds(10, 410, 150, 40);
			
			btnNovo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new FuncionarioGUI(tela);
				}
			});
			
			painel.add(labelTitulo);
			painel.add(scroll);
			painel.add(btnNovo);
			
			
			
			
			tela.setVisible(true);
	}


		private Object[][] carregarDados() {
			FuncionarioDAO dao = new FuncionarioDAO(null);
			
			List<Funcionario> funcionarios = dao.getFuncionarios();
			
			Object[][] dados = new Object[funcionarios.size()][3];			
			
			int i = 0;
			
			for(Funcionario f : funcionarios) {
				dados[i][0] = f.getMatricula();
				dados[i][1] = f.getNome();
				dados[i][2] = f.getCargo();
				i++;
				
			} 
			modelFuncionarios.setDataVector(dados, colunas);
			return dados;
		}
	
	
	
	
}
