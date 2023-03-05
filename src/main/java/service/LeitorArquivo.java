package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import model.Faturamento;

public interface LeitorArquivo {

	String caminhoArquivo();

	default String arquivoParaString() throws IOException {
		try (InputStream streamData = LeitorArquivo.class.getResourceAsStream(caminhoArquivo())) {
			byte[] bytes = new byte[1024];
			String data = "";
			int len = 0;
			try {
				while ((len = streamData.read(bytes)) != -1) {
					data += new String(bytes, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
		}
	}
	
	List<Faturamento> carregarFaturamentos();

}
