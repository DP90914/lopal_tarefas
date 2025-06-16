package br.dev.gustavo.tarefas.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.dao.TarefaDAO;
import br.dev.gustavo.tarefas.model.Funcionario;
import br.dev.gustavo.tarefas.model.Status;
import br.dev.gustavo.tarefas.model.Tarefas;

public class CriarTarefaGUI {
	
	private JComboBox<Status> comboStatus;
	private JComboBox<Funcionario> comboFuncionarios;
	
	public CriarTarefaGUI(JFrame tela) {
		criarTela(tela);
	}
	
	private void criarTela(JFrame parent){
		JDialog tela = new JDialog(parent, true);
		tela.setSize(400, 650);
		tela.setTitle("cadastro de Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setResizable(false);
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

		List<Funcionario> funcionarios = new FuncionarioDAO(null).getFuncionarios();
		comboFuncionarios = new JComboBox<>(funcionarios.toArray(new Funcionario[0]));
        comboFuncionarios.setBounds(10, 170, 200, 30);
		
		JLabel dataInicial = new JLabel("Data inicial:");
		dataInicial.setBounds(10, 210, 150, 30);
		JSpinner spinnerDataInicial = criarSpinnerData();
		spinnerDataInicial.setBounds(10, 255, 200, 30);
		
		JLabel labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 290, 150, 30);
		
		JTextField txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 310, 150, 30);
		
		JLabel labelDataConclusao = new JLabel("Data conclusão:");
		labelDataConclusao.setBounds(10, 345, 150, 30);
		
		JSpinner spinnerDataConclusao = criarSpinnerData();
		spinnerDataConclusao.setBounds(10, 385, 200, 30);
		
		JLabel labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 415, 150, 30);
		
		comboStatus = new JComboBox<>(Status.values());
		comboStatus.setBounds(10, 440, 200, 30);
			
		JButton btnSalvar = new JButton("salvar");
		btnSalvar.setBounds(10, 520, 150, 40);
		
		JButton btnSair = new JButton("sair");
		btnSair.setBounds(230, 520, 150, 40);
		
		
		Container painel = tela.getContentPane();
		painel.add(labelNomeT);
		painel.add(txtNomeT);
		painel.add(txtDescricao);
		painel.add(labelDescricao);
		painel.add(labelResponsavel);
		painel.add(btnSalvar);
		painel.add(btnSair);		
		painel.add(labelPrazo);
		painel.add(dataInicial);
		painel.add(txtPrazo);
		painel.add(labelDataConclusao);
		painel.add(spinnerDataConclusao);
		painel.add(labelStatus);
		painel.add(comboStatus);
		painel.add(comboFuncionarios);
		painel.add(spinnerDataInicial);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tarefas t = new Tarefas();
				t.setNome(txtNomeT.getText());
				t.setDescricao(txtDescricao.getText());
				t.setDataInicio(spinnerDataInicial.getToolkit());
				t.setDataPrevisaoEntrega(spinnerDataInicial.setValue(txtPrazo));
				
				
				TarefaDAO dao = new TarefaDAO(t);
				dao.salvar();
				
				JOptionPane.showMessageDialog(tela, t.getNome() + " gravado com sucesso!");
				
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

	private JSpinner criarSpinnerData() {
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
        return spinner;
	}
}
