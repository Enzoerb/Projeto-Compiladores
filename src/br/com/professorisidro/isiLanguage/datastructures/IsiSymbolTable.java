package br.com.professorisidro.isiLanguage.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class IsiSymbolTable {
	
	private HashMap<String, IsiSymbol> map;
	
	public IsiSymbolTable() {
		map = new HashMap<String, IsiSymbol>();
		
	}
	
	public void add(IsiSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public IsiSymbol get(String symbolName) {
		return map.get(symbolName);
	}

	public boolean verifyInitialization(String id) {
		IsiSymbol isiSymbol = this.get(id);
		return isiSymbol.isInitialized();
	}

	public boolean verifyUseWithoutInitialization(String id) {
		IsiVariable isiVariable = (IsiVariable) this.get(id);
		return isiVariable.getWasUsed();
	}

	public void setAsInitialized(String id) {
		IsiVariable isiVariable = (IsiVariable) this.get(id);
		isiVariable.setInitialized();
	}
	
	public ArrayList<IsiSymbol> getAll(){
		ArrayList<IsiSymbol> lista = new ArrayList<IsiSymbol>();
		for (IsiSymbol symbol : map.values()) {
			lista.add(symbol);
		}
		return lista;
	}

	
	
}
