package br.com.professorisidro.isiLanguage.ast;

import java.util.ArrayList;

public class CommandRepeticaoDoWhile extends AbstractCommand {

    private final String condition;
    private final ArrayList<AbstractCommand> commandDoWhileList;

    public CommandRepeticaoDoWhile(String condition, ArrayList<AbstractCommand> commandDoWhileList) {
        this.condition = condition;
        this.commandDoWhileList = commandDoWhileList;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("do {\n");

        for (AbstractCommand command : commandDoWhileList) {
            stringBuilder.append(command.generateJavaCode());
        }

        stringBuilder.append("} while (")
                .append(condition)
                .append(");\n");

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "CommandRepeticaoDoWhile [do=" + commandDoWhileList + " condition=" + condition +"]";
    }
}
