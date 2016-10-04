package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Main {
	
	static public void main(String[] args) {
		// Carregar arquivo FCL
		String filename = "fcl/tipper.fcl";
		FIS fis = FIS.load(filename, true);
		
		if(fis == null) {
			System.err.println("Arquivo não pode ser aberto: " + filename);
			return;
		}
		
		
		//Mostrar
		JFuzzyChart.get().chart(fis);
		
		fis.setVariable("service", 3);
		fis.setVariable("food", 7);
		
		fis.evaluate();
		
		Variable tip = fis.getVariable("tip");
		JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
		
		System.out.println(fis);
		
	}

}

