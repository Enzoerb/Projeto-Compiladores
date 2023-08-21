package br.com.professorisidro.main;


import br.com.professorisidro.isiLanguage.datastructures.IsiSymbol;
import br.com.professorisidro.isiLanguage.datastructures.IsiVariable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.professorisidro.isiLanguage.exceptions.IsiSemanticException;
import br.com.professorisidro.isiLanguage.parser.IsiLangLexer;
import br.com.professorisidro.isiLanguage.parser.IsiLangParser;

/* esta é a classe que é responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 *
 * Arquivo fonte: extensao .isi
 *
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            IsiLangLexer lexer;
            IsiLangParser parser;
            int a;
            a = 2;

            // leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
            lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));
            // crio um "fluxo de tokens" para passar para o PARSER
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            // crio meu parser a partir desse tokenStream
            parser = new IsiLangParser(tokenStream);

            parser.prog();

            System.out.println("Compilation Successful");

            parser.exibeComandos();

            parser.generateCode();
            parser.showWarnings();

        } catch (IsiSemanticException ex) {
            System.err.println("Semantic error - " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("ERROR " + ex.getMessage());
        }
    }

}
