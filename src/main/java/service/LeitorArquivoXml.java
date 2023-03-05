package service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Faturamento;

public class LeitorArquivoXml implements LeitorArquivo {

	@Override
	public String caminhoArquivo() {
		return "/dados.xml";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Faturamento> carregarFaturamentos() {
		List<Faturamento> faturamentos = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Faturamento.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			List<Faturamento> faturamento = (List<Faturamento>) unmarshaller
					.unmarshal(new ByteArrayInputStream(arquivoParaString().getBytes(StandardCharsets.UTF_8)));
		} catch (IOException | JAXBException e) {
			System.out.println(
					"Houve um erro ao tentar ler os faturamentos. Tente novamente... Erro : " + e.getMessage());
			e.printStackTrace();
		}
		return faturamentos;
	}

}
