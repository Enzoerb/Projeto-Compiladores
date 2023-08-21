package br.com.professorisidro.isiLanguage.datastructures;

public class IsiVariable extends IsiSymbol {

    public static final int DOUBLE = 0;
    public static final int TEXT = 1;
    public static final int INT = 2;

    private int type;
    private String value;
    private Boolean wasUsed;

    public IsiVariable(String name, int type, String value) {
        super(name);
        wasUsed = false;
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setWasUsed(Boolean wasInitialized) {
        this.wasUsed = wasInitialized;
    }

    public Boolean getWasUsed() {
        return this.wasUsed;
    }

    @Override
    public String toString() {
        return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
    }

    public String generateJavaCode() {
        String str;
        if (type == DOUBLE) str = "double ";
        else if (type == INT) str = "int ";
        else if (type == TEXT) str = "String ";
        else str = null;

        return str + " " + super.name + ";";
    }


}
