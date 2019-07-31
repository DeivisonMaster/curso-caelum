package br.com.caelum.livraria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.model.Venda;
import br.com.caelum.livraria.repository.Impl.LivroRepositoryImpl;
import br.com.caelum.repository.LivroRepository;

@Named
@ViewScoped
public class VendaController implements Serializable{
	private static final long serialVersionUID = 1L;
	private Venda venda;
	private LivroRepository livroRepository;
	private BarChartModel barChartModel;
	
	public VendaController() {
		this.livroRepository = new LivroRepositoryImpl();
	}
	
	public BarChartModel getVendasModel(){
		BarChartModel model = new BarChartModel();
		model.setAnimate(true);
		
		ChartSeries vendaSerie2018 = new ChartSeries();
		
		List<Venda> vendas = getVendas(1234);
		vendaSerie2018.setLabel("Vendas 2018");
		for (Venda venda : vendas) {
			vendaSerie2018.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
		
		
		ChartSeries vendaSerie2019 = new ChartSeries();
		vendas = getVendas(4321);
		vendaSerie2019.setLabel("Vendas 2019");
		for (Venda venda : vendas) {
			vendaSerie2019.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
		
		
		model.addSeries(vendaSerie2018);
		model.addSeries(vendaSerie2019);
		return model;
	}
	
	
	public List<Venda> getVendas(long seed){
		List<Venda> vendas = new ArrayList<Venda>();
		Collection<Livro> livros = livroRepository.buscarTodos();
		
		Random random = new Random(seed);
		
		for (Livro livro : livros) {
			int quantidade = random.nextInt(500);
			vendas.add(new Venda(livro, quantidade));
		}
		
		return vendas;
	}
}
