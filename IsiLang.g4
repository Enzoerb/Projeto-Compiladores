grammar IsiLang;

@header{
    import br.com.professorisidro.isiLanguage.datastructures.IsiSymbol;
    import br.com.professorisidro.isiLanguage.datastructures.IsiVariable;
    import br.com.professorisidro.isiLanguage.datastructures.IsiSymbolTable;
    import br.com.professorisidro.isiLanguage.exceptions.IsiSemanticException;
    import br.com.professorisidro.isiLanguage.ast.IsiProgram;
    import br.com.professorisidro.isiLanguage.ast.AbstractCommand;
    import br.com.professorisidro.isiLanguage.ast.CommandLeitura;
    import br.com.professorisidro.isiLanguage.ast.CommandEscrita;
    import br.com.professorisidro.isiLanguage.ast.CommandAtribuicao;
    import br.com.professorisidro.isiLanguage.ast.CommandDecisao;
    import br.com.professorisidro.isiLanguage.ast.CommandRepeticaoWhile;
    import br.com.professorisidro.isiLanguage.ast.CommandRepeticaoDoWhile;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<Integer> _varsType = new ArrayList<Integer>();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private String _exprRepeticaoWhile;
	private String _exprRepeticaoDoWhile;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<AbstractCommand> commandWhileList;
	private ArrayList<AbstractCommand> commandDoWhileList;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		}
	}
	
	public String getTypeName(int type) {
		switch (isiType) {
			case 0:
				return "DOUBLE";
			case 1:
				return "TEXT";
			case 2:
				return "INT";
			default:
				return "";
		}
	}
	
	public void verificaTipos(ArrayList<Integer> varTypes) {
		int first = varTypes.get(0);
		for (int type: varTypes) {
			if (first != type) {
				varTypes.removeAll(varTypes);
				throw new IsiSemanticException("Type mismatch: getTypeName(first) and getTypeName(type)");
			}
		}
		varTypes.removeAll(varTypes);
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}

	public void showWarnings(){
        for (IsiSymbol isiSymbol: symbolTable.getAll()) {

            if (isiSymbol instanceof IsiVariable
                && ((IsiVariable)isiSymbol).getWasInitialized().equals(Boolean.FALSE)) {
                System.out.println("Warning: The variable " + isiSymbol.getName() + " was declared but it is not used");
            }

        }
    }
}

prog	: 'programa' decl bloco  'fimprog;'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	 
           } 
		;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'inteiro' { _tipo = IsiVariable.INT;  }
           | 'decimal' { _tipo = IsiVariable.DOUBLE;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao
 		|  cmdrepeticaodowhile
 		|  cmdrepeticaowhile
		;
		
cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable isiVariable = (IsiVariable)symbolTable.get(_readID);
              	isiVariable.setWasInitialized(true);

              	CommandLeitura cmd = new CommandLeitura(_readID, isiVariable);

              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'escreva' 
                 AP 
                 ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
                     } 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);

               	  IsiVariable isiVariable = (IsiVariable)symbolTable.get(_readID);
                  isiVariable.setWasInitialized(true);

               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                    int idType = ((IsiVariable) symbolTable.get(_exprID)).getType();
                    _varsType.add(idType);
                   } 
               ATTR { _exprContent = ""; } 
               expr 
               SC
               {
               	verificaTipos(_varsType);
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);

                 IsiVariable isiVariable = (IsiVariable)symbolTable.get(_exprID);
               	 isiVariable.setWasInitialized(true);

               	 stack.peek().add(cmd);
               }
			;
			
			
cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); 
                    verificaID(_input.LT(-1).getText());
                     int idType = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
                    _varsType.add(idType);
                    }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER | STRING) {
                    _exprDecision += _input.LT(-1).getText(); 
                    if (_input.LT(-1).getText().matches("\\d+(\\.\\d+)?"))
										_varsType.add(IsiVariable.DOUBLE);
					elif(_input.LT(-1).getText().matches("\\d+"))
										_varsType.add(IsiVariable.INT);
					elif(_input.LT(-1).getText().startsWith("\""))
										_varsType.add(IsiVariable.TEXT);
						else {
									verificaID(_input.LT(-1).getText());
									int idType = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
                  					  _varsType.add(idType);
									}
                    }
                    FP 
                    ACH 
                    { verificaTipos(_varsType);
                      curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;

cmdrepeticaodowhile : 'faca'
                ACH{
                    curThread = new ArrayList<AbstractCommand>();
                    stack.push(curThread);
				}

				(cmd)+

				FCH
				'enquanto' AP

				expr {
				    _exprRepeticaoDoWhile = _input.LT(-1).getText();
				}

				OPREL{
				    _exprRepeticaoDoWhile += _input.LT(-1).getText();
				}

				expr {
				    _exprRepeticaoDoWhile += _input.LT(-1).getText();
				}

				FP
					{ 
					
					verificaTipos(_varsType);   
					commandDoWhileList = stack.pop();
						CommandRepeticaoDoWhile cmd = new CommandRepeticaoDoWhile(_exprRepeticaoDoWhile, commandDoWhileList);
						stack.peek().add(cmd);
					}
                SC
            ;

cmdrepeticaowhile : 'enquanto' 	AP

                ID {
                    verificaID( _input.LT(-1).getText() );
                    _exprRepeticaoWhile = _input.LT(-1).getText();
                    int idType = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
                    _varsType.add(idType);
                }

                OPREL {
                    _exprRepeticaoWhile += _input.LT(-1).getText();
                }

                (ID | NUMBER | STRING) {
                    _exprRepeticaoWhile += _input.LT(-1).getText();
                    
                     if (_input.LT(-1).getText().matches("\\d+(\\.\\d+)?")){
										_varsType.add(IsiVariable.DOUBLE);}
					elif(_input.LT(-1).getText().matches("\\d+")){
										_varsType.add(IsiVariable.INT);}
					elif(_input.LT(-1).getText().startsWith("\"")){
										_varsType.add(IsiVariable.TEXT);}
						else {
									verificaID(_input.LT(-1).getText());
									int idType = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
                  					  _varsType.add(idType);
									}
                    
                    verificaTipos(_varsType);
                    
                }

                FP

                ACH {
                    curThread = new ArrayList<AbstractCommand>();
                    stack.push(curThread);
                }

                (cmd)+

                FCH {
                    commandWhileList = stack.pop();
                    CommandRepeticaoWhile cmd = new CommandRepeticaoWhile(_exprRepeticaoWhile, commandWhileList);
                    stack.peek().add(cmd);
                }

            ;


expr		:  termo ( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;
			
termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
	               int idType = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
                  _varsType.add(idType);
                 } 
            | 
              NUMBER
              {
                 _varsType.add(IsiVariable.DOUBLE);
              	_exprContent += _input.LT(-1).getText();
              }
            |
              STRING {
					    _varsType.add(IsiVariable.TEXT);
              		    _exprContent += _input.LT(-1).getText();
              }
			;
			
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
	
STRING : '"' ( '\\"' | . )*? '"'
	   ;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;