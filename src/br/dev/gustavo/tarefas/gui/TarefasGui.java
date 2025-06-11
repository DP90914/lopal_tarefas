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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.model.Funcionario;

public class TarefasGui {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnFechar;
	private JTable tabelaTarefas;
	private DefaultTableModel modelFuncionarios;
	private JScrollPane scroll;
	
	public TarefasGui(){
		criarTela();
	}
	
	
	private String[] colunas = {"NOME DA TAREFA", "DESCRIACAO", "RESPONSAVEL", "DATA INICIAL", "PRAZO", "DATA PREV. ENTREGA", "STATUS", "DATA ENTREGA"};
	
	
	private void criarTela() {
		
		JFrame tela = new JFrame("Tabela de tarefas");
		tela.setSize(800, 700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setFont(new Font("arial", Font.BOLD, 28));
		labelTitulo.setForeground(new Color(100, 0, 100));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		modelFuncionarios = new DefaultTableModel(colunas, 1);
		carregarDados();
		tabelaTarefas = new JTable(modelFuncionarios);
		scroll = new JScrollPane(tabelaTarefas);
		scroll.setBounds(10, 60, 750, 540);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 610, 150, 40);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CriarTarefaGUI(tela);
				carregarDados();
				
			}
		});
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(610, 610, 150, 40);
		
		btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { {
					int resposta = JOptionPane.showConfirmDialog(tela, "sair do sistema?");
					if(resposta == 0) {
						tela.dispose();
					}		
				}

				
			}
		});
		
		painel.add(labelTitulo);
		painel.add(scroll);
		painel.add(btnNovo);
		painel.add(btnFechar);
		
		
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
	}}