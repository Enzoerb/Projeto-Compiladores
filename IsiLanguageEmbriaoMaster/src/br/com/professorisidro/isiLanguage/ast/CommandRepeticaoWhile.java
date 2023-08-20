package IsiLanguageEmbriaoMaster.src.br.com.professorisidro.isiLanguage.ast;

import java.util.ArrayList;

public class CommandRepeticaoWhile extends AbstractCommand{

    private final String condition;
    private final ArrayList<AbstractCommand> commandWhileList;

    public CommandRepeticaoWhile(String condition, ArrayList<AbstractCommand> commandWhileList) {
        this.condition = condition;
        this.commandWhileList = commandWhileList;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nwhile (").append(condition).append(") {\n");
        for (AbstractCommand command : commandWhileList) {
            stringBuilder.append(command.generateJavaCode());
        }
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}
