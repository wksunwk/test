package lambda;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {

	public static void main(String[] args) {
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine engine = m.getEngineByName("JavaScript");
		System.out.println(engine.getClass().getName());
		try {
			System.out.println(engine.eval("function f() {return 1;}; f() + 1;"));
			
			System.out.println(engine.eval("var print = function(i){ log(i);};[1,2,3].forEach(print);"));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
