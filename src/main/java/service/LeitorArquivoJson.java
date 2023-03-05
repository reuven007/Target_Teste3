package service;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Faturamento;

public class LeitorArquivoJson implements LeitorArquivo {

	@Override
	public String caminhoArquivo() {
		return "/dados.json";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Faturamento> carregarFaturamentos() {
		List<Faturamento> faturamentos = null;
		try {
			String arquivoParaString = arquivoParaString();
			Gson gson = new Gson();
			TypeToken<List<Faturamento>> token = new TypeToken<List<Faturamento>>() {
			};
			faturamentos = gson.fromJson(arquivoParaString, token.getType());
		} catch (IOException e) {
			System.out.println(
					"Houve um erro ao tentar ler os faturamentos. Tente novamente... Erro : " + e.getMessage());
			e.printStackTrace();
		}
		return faturamentos;
	}

}
