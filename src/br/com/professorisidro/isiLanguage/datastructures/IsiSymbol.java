package br.com.professorisidro.isiLanguage.datastructures;

public abstract class IsiSymbol {
	
	protected String name;
	protected boolean initialized = false;
	
	public abstract String generateJavaCode();
	public IsiSymbol(String name) {
		this.name = name;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized() {
		this.initialized = true;
	}
	@Override
	public String toString() {
		return "IsiSymbol [name=" + name + "]";
	}
	
	
	

}
