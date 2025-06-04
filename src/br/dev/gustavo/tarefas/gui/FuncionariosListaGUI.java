package br.dev.gustavo.tarefas.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
			
			modelFuncionarios = new DefaultTableModel(colunas, 1000);
			tabelaFuncionarios = new JTable(modelFuncionarios);
			scroll = new JScrollPane(tabelaFuncionarios);
			scroll.setBounds(10, 60, 580, 340);
			tabelaFuncionarios.setBounds(10, 60, 580, 340);
		
			painel.add(labelTitulo);
			painel.add(scroll);
			
	
			tela.setVisible(true);
	}
	
	
	
	
}
