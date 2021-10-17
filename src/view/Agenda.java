package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Contato;
import model.ContatoDAO;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTable table;
	
	ContatoDAO dao = new ContatoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Agenda() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/images/agenda.png")));
		setTitle("Minha agenda telef\u00F4nica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agenda Telef\u00F4nica");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ebrima", Font.PLAIN, 44));
		lblNewLabel.setBounds(22, 11, 378, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(32, 90, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("*NOME:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(32, 131, 72, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("*IDADE:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(32, 174, 72, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("*ENDERE\u00C7O:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(32, 218, 89, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("*TELEFONE:");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(32, 259, 72, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(117, 88, 45, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Digite o nome do contato");
		txtNome.setColumns(10);
		txtNome.setBounds(117, 129, 260, 20);
		contentPane.add(txtNome);
		
		txtNome.grabFocus();
		
		txtIdade = new JTextField();
		txtIdade.setToolTipText("Digite a idade do contato");
		txtIdade.setColumns(10);
		txtIdade.setBounds(117, 172, 65, 20);
		contentPane.add(txtIdade);
		
		txtEndereco = new JTextField();
		txtEndereco.setToolTipText("Digite o endere\u00E7o do contato");
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(117, 216, 260, 20);
		contentPane.add(txtEndereco);
				
		txtTelefone = new JTextField();
		txtTelefone.setToolTipText("Digite o telefone do contato");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(117, 257, 120, 20);
		contentPane.add(txtTelefone);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNome.getText().equals("") || txtIdade.getText().equals("") || txtEndereco.getText().equals("") || txtTelefone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Atenção", JOptionPane.WARNING_MESSAGE);
					System.out.println("Vazio");
				} else {
					String nome = txtNome.getText();
					int idade = Integer.parseInt(txtIdade.getText());
					String endereco = txtEndereco.getText();
					String telefone = txtTelefone.getText();
					
					Contato contato = new Contato();
					
					contato.setNome(nome);
					contato.setIdade(idade);
					contato.setEndereco(endereco);
					contato.setTelefone(telefone);
					
					dao.salvarDAO(contato);
									
					JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso.", "Sucesso no cadastro", JOptionPane.INFORMATION_MESSAGE);
					
					limpaRegistros();
				}
			}
		});
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCadastrar.setBounds(32, 293, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Primeiro liste um contato da sua agenda para poder editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
					System.out.println("Vazio");
				} else {
				
					long id = Long.parseLong(txtID.getText());
					String nome = txtNome.getText();
					String endereco = txtEndereco.getText();
					int idade = Integer.parseInt(txtIdade.getText());
					String telefone = txtTelefone.getText();
					
					Contato contato = new Contato();
					
					contato.setId(id);
					contato.setNome(nome);				
					contato.setIdade(idade);
					contato.setEndereco(endereco);
					contato.setTelefone(telefone);
					
					dao.editarDAO(contato);
					
					JOptionPane.showMessageDialog(null, "Contato alterado com sucesso.", "Sucesso na alteração", JOptionPane.INFORMATION_MESSAGE);
					
					limpaRegistros();
				}
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAlterar.setBounds(148, 293, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num = table.getSelectedRow();
				int registro = table.getRowCount();
				
				System.out.println(num + " e " + registro);
				
				if(registro == 0) {
					JOptionPane.showMessageDialog(null, "Agenda sem contatos! Cadastre pelo menos um contato.", "Atenção", JOptionPane.WARNING_MESSAGE);
				} else if(num == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um contato da sua agenda para poder listar.", "Atenção", JOptionPane.WARNING_MESSAGE);
				} else {
								
					txtID.setText(table.getValueAt(num, 0).toString());
					txtNome.setText(table.getValueAt(num, 1).toString());
					txtIdade.setText(table.getValueAt(num, 2).toString());
					txtEndereco.setText(table.getValueAt(num, 3).toString());
					txtTelefone.setText(table.getValueAt(num, 4).toString());		
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnListar.setBounds(32, 327, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num = table.getSelectedRow();
				int registro = table.getRowCount();
				
				if(registro == 0) {
					JOptionPane.showMessageDialog(null, "Não há contatos para deletar!", "Atenção", JOptionPane.WARNING_MESSAGE);
				} else if(num == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um contato da sua agenda para poder deletar.", "Atenção", JOptionPane.WARNING_MESSAGE);
				} else {
				
					System.out.println(table.getValueAt(num, 0));
					
					long id = (long) table.getValueAt(num, 0);
					
					dao.deletarDAO(id);
					
					JOptionPane.showMessageDialog(null, "Contato deletado com sucesso.", "Sucesso na exclusão", JOptionPane.INFORMATION_MESSAGE);
					
					limpaRegistros();
				}
				
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDeletar.setBounds(148, 327, 89, 23);
		contentPane.add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(389, 11, 335, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "IDADE", "ENDERE\u00C7O", "TELEFONE"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setMinWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setMinWidth(30);
		scrollPane.setViewportView(table);
		mostraRegistros();		
		
		JLabel lblNewLabel_2 = new JLabel("*CAMPOS OBRIGAT\u00D3RIOS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(236, 76, 141, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnLimparCampos = new JButton("");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaTela();
			}
		});
		btnLimparCampos.setIcon(new ImageIcon(Agenda.class.getResource("/images/eraser (5).png")));
		btnLimparCampos.setBounds(266, 293, 65, 57);
		contentPane.add(btnLimparCampos);
	
		
	}
	
	//MÉTODOS A SEREM IMPLEMENTADOS NA AGENDA
	public void limpaRegistros(){
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		
		limpaTela();
		mostraRegistros();	
	}
	
	public void limpaTela() {
		txtID.setText("");
		txtNome.setText("");
		txtIdade.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		txtNome.grabFocus();
	} 
	
	public void mostraRegistros() {
		
		List<Contato> contatos = dao.consultarDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		for(Contato contato: contatos) {
			
			modelo.addRow(new Object[] {contato.getId(),
					contato.getNome(),
					contato.getIdade(),
					contato.getEndereco(),
					contato.getTelefone()});
		}
	}
	
	
}
