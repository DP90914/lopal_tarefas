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
import br.dev.gustavo.tarefas.dao.TarefaDAO;
import br.dev.gustavo.tarefas.model.Funcionario;
import br.dev.gustavo.tarefas.model.Tarefas;

public class TarefasGui {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnFechar;
	private JTable tabelaTarefas;
	private DefaultTableModel modelTarefas;
	private JScrollPane scroll;
	
	public TarefasGui(){
		criarTela();
	}
	
	
	private String[] colunas = {"CODIGO", "NOME DA TAREFA", "RESPONSAVEL",};
	
	
	private void criarTela() {
		
		JFrame tela = new JFrame("Tabela de tarefas");
		tela.setSize(1000, 700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setFont(new Font("arial", Font.BOLD, 28));
		labelTitulo.setForeground(new Color(100, 0, 100));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		modelTarefas = new DefaultTableModel(colunas, 1);
		carregarDados();
		tabelaTarefas = new JTable(modelTarefas);
		scroll = new JScrollPane(tabelaTarefas);
		scroll.setBounds(10, 60, 950, 540);
		
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
		btnFechar.setBounds(810, 610, 150, 40);
		
		btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { {
					int resposta = JOptionPane.showConfirmDialog(tela, "sair do sistema?");
					if(resposta == 0) {
						tela.dispose();
						new TelaPrincipalGUI(null);
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
		TarefaDAO dao = new TarefaDAO(null);
		List<Tarefas> Tarefa = dao.getTarefa();
		
		Object[][] dados = new Object[Tarefa.size()][3];
		
		int i = 0;
		for(Tarefas t : Tarefa) {
			
			dados[i][0] = t.getCodigo();
			dados[i][1] = t.getNome();
			dados[i][2] = t.getResponsavel();
			
			i++;
		}
		modelTarefas.setDataVector(dados, colunas);
		return dados;
	}}