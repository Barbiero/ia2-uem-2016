package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Main {
	
	static public void main(String[] args) {
		// Carregar arquivo FCL
		String filename = "fcl/riskmatrix.fcl";
		FIS fis = FIS.load(filename, true);
		
		if(fis == null) {
			System.err.println("Arquivo não pode ser aberto: " + filename);
			return;
		}
		
		
		//Mostrar
		JFuzzyChart.get().chart(fis);
		
		fis.setVariable("possibilidade", 3.98);
		fis.setVariable("impacto", 2.74);
		
		fis.evaluate();
		
		Variable tip = fis.getVariable("risco");
		JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
		
		System.out.println(fis);
		
	}

}

