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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.model.Funcionario;

public class FuncionariosListaGUI {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnFechar;
	private JTable tabelaFuncionarios;
	private DefaultTableModel modelFuncionarios;
	private JScrollPane scroll;
	
	
	private String[] colunas = {"CÓDIGO", "NOME DO FUNCIONARIO", "CARGO"};
	
	public FuncionariosListaGUI() {
		// TODO Auto-generated constructor stub
		criarTela();
	} 
	
		private void criarTela() {
			
			JFrame tela = new JFrame("Lista de funcionários");
			tela.setSize(600, 500);
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
			tabelaFuncionarios = new JTable(modelFuncionarios);
			scroll = new JScrollPane(tabelaFuncionarios);
			scroll.setBounds(10, 60, 550, 340);
			
			btnNovo = new JButton("Novo");
			btnNovo.setBounds(10, 410, 150, 40);
			
			btnNovo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new FuncionarioGUI(tela);
					carregarDados();
					
				}
			});
			
			btnFechar = new JButton("Fechar");
			btnFechar.setBounds(410, 410, 150, 40);
			
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
			modelFuncionarios.setDataVector(dados, colunas);;
			return dados;
		}
		

	}