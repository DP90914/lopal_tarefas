package br.dev.gustavo.tarefas.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.model.Funcionario;

public class CriarTarefaGUI {
	public CriarTarefaGUI(JFrame tela) {
		criarTela(tela);
	}
	
	private void criarTela(JFrame parent){
		JDialog tela = new JDialog(parent, true);
		tela.setSize(400, 800);
		tela.setTitle("cadastro de Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		JLabel labelNomeT = new JLabel("Nome da tarefa:");
		labelNomeT.setBounds(10, 10, 150, 30);
		JTextField txtNomeT = new JTextField();
		txtNomeT.setBounds(10, 40, 200, 30);
		
		JLabel labelDescricao = new JLabel("Descricao:");
		labelDescricao.setBounds(10, 75, 150, 30);
		JTextField txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 105, 150, 30);
		
		JLabel labelResponsavel = new JLabel("Responsavel:");
		labelResponsavel.setBounds(10, 140, 150, 30);
		JTextField txtResponsavel = new JTextField();
		txtResponsavel.setBounds(10, 170, 200, 30);
		
		JLabel dataInicial = new JLabel("Data inicial:");
		dataInicial.setBounds(10, 210, 150, 30);
		
		JTextField txtDI = new JTextField();
		txtDI.setBounds(10, 240, 150, 30);
		
		JLabel labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 270, 150, 30);
		
		JTextField txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 290, 150, 30);
		
		JButton btnSalvar = new JButton("salvar");
		btnSalvar.setBounds(10, 720, 150, 40);
		
		JButton btnSair = new JButton("sair");
		btnSair.setBounds(230, 720, 150, 40);
		
		
		Container painel = tela.getContentPane();
		painel.add(labelNomeT);
		painel.add(txtNomeT);
		painel.add(txtDescricao);
		painel.add(labelDescricao);
		painel.add(labelResponsavel);
		painel.add(btnSalvar);
		painel.add(txtResponsavel);
		painel.add(btnSair);		
		painel.add(labelPrazo);
		painel.add(dataInicial);
		painel.add(txtDI);
		painel.add(txtPrazo);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "sair do sistema?");
				if(resposta == 0) {
					tela.dispose();
				}		
			}
		});
		
		tela.setVisible(true);
		
	}
}
