// Generated from .\IsiLang.g4 by ANTLR 4.7.1
package IsiLanguageEmbriaoMaster.src.br.com.professorisidro.isiLanguage.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declarar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarar(IsiLangParser.DeclararContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declarar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarar(IsiLangParser.DeclararContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(IsiLangParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(IsiLangParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(IsiLangParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(IsiLangParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(IsiLangParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(IsiLangParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdRepeticaoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdRepeticaoWhile(IsiLangParser.CmdRepeticaoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdRepeticaoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdRepeticaoWhile(IsiLangParser.CmdRepeticaoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttr(IsiLangParser.CmdAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttr(IsiLangParser.CmdAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(IsiLangParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(IsiLangParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termol}.
	 * @param ctx the parse tree
	 */
	void enterTermol(IsiLangParser.TermolContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termol}.
	 * @param ctx the parse tree
	 */
	void exitTermol(IsiLangParser.TermolContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(IsiLangParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(IsiLangParser.FatorContext ctx);
}