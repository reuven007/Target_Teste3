import java.util.HashMap;
import java.util.Map;

import service.FaturamentoService;
import service.LeitorArquivo;
import service.LeitorArquivoJson;
import service.LeitorArquivoXml;

public class Application {

	public static final Map<String, LeitorArquivo> TIPO_LEITOR = new HashMap<>();
	
	static {
		TIPO_LEITOR.put("xml", new LeitorArquivoXml());
		TIPO_LEITOR.put("json", new LeitorArquivoJson());
	}
	
	public static void main(String[] args) {

		String tipo = args[0];
		LeitorArquivo leitor = TIPO_LEITOR.get(tipo);
		
		FaturamentoService service = new FaturamentoService(leitor.carregarFaturamentos());
		
		System.out.println("O menor valor de faturamento ocorrido em um dia do mês: "+ service.menorValorFaturamento());
		System.out.println("O maior valor de faturamento ocorrido em um dia do mês: "+ service.maiorValorFaturamento());
		System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: "+ service.numeroDeDiasEmQueOFaturamentoFoiMaiorQueAMedia());
		
	}

}
