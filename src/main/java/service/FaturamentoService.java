package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.OptionalDouble;

import model.Faturamento;

public class FaturamentoService {

	protected List<Faturamento> faturamentos;

	public FaturamentoService(List<Faturamento> faturamentos) {
		this.faturamentos = faturamentos;
	}

	public double menorValorFaturamento() {
		return faturamentos.stream().map(Faturamento::getValor).filter(b -> b.compareTo(BigDecimal.ZERO) > 0)
				.mapToDouble(BigDecimal::doubleValue).min().getAsDouble();
	}

	public double maiorValorFaturamento() {
		return faturamentos.stream().map(Faturamento::getValor).filter(b -> b.compareTo(BigDecimal.ZERO) > 0)
				.mapToDouble(BigDecimal::doubleValue).max().getAsDouble();
	}

	public long numeroDeDiasEmQueOFaturamentoFoiMaiorQueAMedia() {
		OptionalDouble average = faturamentos.stream().map(Faturamento::getValor)
				.filter(b -> b.compareTo(BigDecimal.ZERO) > 0).mapToDouble(BigDecimal::doubleValue).average();
		return faturamentos.stream().filter(fat -> fat.getValor().doubleValue() > average.getAsDouble() ? true : false)
				.count();
	}

}
