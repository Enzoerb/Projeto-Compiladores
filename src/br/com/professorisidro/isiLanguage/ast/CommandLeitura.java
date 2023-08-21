package br.com.professorisidro.isiLanguage.ast;

import br.com.professorisidro.isiLanguage.datastructures.IsiVariable;

public class CommandLeitura extends AbstractCommand {

    private String id;
    private IsiVariable var;

    public CommandLeitura(String id, IsiVariable var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String generateJavaCode() {

        if (var.getType() == IsiVariable.DOUBLE) return id +"= _key.nextDouble();";
        if (var.getType() == IsiVariable.INT) return id +"= _key.nextInt();";
        if (var.getType() == IsiVariable.TEXT) return id +"= _key.nextLine();";
        else return null;
    }

    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + "]";
    }

}
