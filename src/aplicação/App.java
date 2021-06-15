package aplicação;

import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entidades.Cliente;
import entidades.Reserva;
import entidades.auxiliares.ClienteAuxiliar;
import entidades.auxiliares.FuncionarioAuxiliar;
import entidades.auxiliares.ReservaAuxiliar;
import menu.MenuCliente;
import menu.MenuFuncionario;
import menu.MenuPrincipal;
import menu.MenuReserva;
import util.BaseJson;
import org.json.JSONException;
import org.json.JSONObject;

public class App {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// criando usuário admin
		
			String login = "admin";
			String senha = "admin";
			String email = "admin";
			String cpf = "admin";
			String nome = "admin";
			String telefone = "admin";
			FuncionarioAuxiliar.cadastrar(nome, cpf, telefone, login, senha);

	
		String loginAutenticar;
		String senhaAutenticar;
		JOptionPane.showMessageDialog(null, "Informe os dados de restrição");

		loginAutenticar = JOptionPane.showInputDialog(null, "Infome o login", "login", 3);
		senhaAutenticar = JOptionPane.showInputDialog(null, "Infome o senha", "senha", 3);

		if (FuncionarioAuxiliar.getListaFuncionario().get(0).autenticarFuncionario(loginAutenticar, senhaAutenticar)) {
			JOptionPane.showMessageDialog(null, "Acesso Concedido");

			try {
				MenuPrincipal.exibirMenuPrincipal();

			} catch (Exception e) {
				System.out.println("ERRO");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Confira as informações e tente novamente");
		}

	}

}