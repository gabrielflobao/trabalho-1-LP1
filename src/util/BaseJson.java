package util;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseJson {

	public static JSONObject criarJson() throws IOException {
		FileWriter writeFile = null;
		JSONObject baseDados = new JSONObject();
		try {
			baseDados.putOpt("nome", "admin");
			baseDados.putOpt("cpf", "18520512720");
			baseDados.putOpt("endereco", "admin");
			baseDados.putOpt("telefone", "admin");
			baseDados.putOpt("login", "admin");
			baseDados.putOpt("senha", "admin");
			baseDados.putOpt("email", "admin");
			writeFile = new FileWriter("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\BaseJason\\baseJason.json");
			writeFile.write(baseDados.toString());
			writeFile.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseDados;

	}

}
