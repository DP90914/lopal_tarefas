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


public class TelaPrincipalGUI {
	public TelaPrincipalGUI(JFrame tela) {
		criarTela(tela);
	}
	
	private void criarTela(JFrame parent){
		
		JFrame tela = new JFrame();
		tela.setSize(400, 100);
		tela.setTitle("Tela principal");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		
		JButton btnFuncionarios = new JButton("Funcionario");
		btnFuncionarios.setBounds(10, 20, 150, 40);
		
		JButton btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(230, 20, 150, 40);
		
		
		Container painel = tela.getContentPane();

		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionariosListaGUI();
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
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

