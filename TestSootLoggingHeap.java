package a1;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import soot.*;
import soot.jimple.AssignStmt;
import soot.jimple.DefinitionStmt;
import soot.jimple.FieldRef;
import soot.jimple.IdentityStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.NullConstant;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.options.Options;

public class TestSootLoggingHeap extends BodyTransformer {

	private static SootMethodRef logFieldAccMethod;

	public static void main(String[] args)	{

		String mainclass = "a1.HelloThread";

		//output Jimple
		//Options.v().set_output_format(1);

//		//set classpath
	    String javapath = System.getProperty("java.class.path");
	    String jredir = System.getProperty("java.home")+"/lib/rt.jar";
	    String path = javapath+File.pathSeparator+jredir;
	    Scene.v().setSootClassPath(path);

        //add an intra-procedural analysis phase to Soot
	    TestSootLoggingHeap analysis = new TestSootLoggingHeap();
	    PackManager.v().getPack("jtp").add(new Transform("jtp.TestSootLoggingHeap", analysis));

        //load and set main class
	    Options.v().set_app(true);
	    SootClass appclass = Scene.v().loadClassAndSupport(mainclass);
	    Scene.v().setMainClass(appclass);
		SootClass logClass = Scene.v().loadClassAndSupport("a1.Log");
		logFieldAccMethod = logClass.getMethod("void logFieldAcc(java.lang.Object,java.lang.String,boolean,boolean)").makeRef();
	    Scene.v().loadNecessaryClasses();

        //start working
	    PackManager.v().runPacks();

	    PackManager.v().writeOutput();
	}

	@Override
	protected void internalTransform(Body b, String phaseName,
		Map<String, String> options) {

		//we don't instrument Log class
		if(!b.getMethod().getDeclaringClass().getName().equals("a1.Log"))
		{
			Iterator<Unit> it = b.getUnits().snapshotIterator();
		    while(it.hasNext()){
		    	Stmt stmt = (Stmt)it.next();
		    	if (stmt.containsFieldRef()) {
		    		
			    int isStatic = (stmt.getFieldRef().getClass().getName().equals("soot.jimple.StaticFieldRef"))? 1 : 0;
			    String subClassName = stmt.getDefBoxes().get(0).getValue().getClass().getName();
			    int isWrite = (subClassName.equals("soot.jimple.StaticFieldRef") || subClassName.equals("soot.jimple.internal.JInstanceFieldRef")) ? 1 : 0;
			    LinkedList<Value> args = new LinkedList<>();
			    args.add(StringConstant.v(Thread.currentThread().toString()));
			    args.add(StringConstant.v(stmt.getFieldRef().getField().toString()));
			    args.add(IntConstant.v(isStatic));
			    args.add(IntConstant.v(isWrite));
			    InvokeExpr printExpr = Jimple.v().newStaticInvokeExpr(logFieldAccMethod, args);
			    InvokeStmt invokeStmt = Jimple.v().newInvokeStmt(printExpr);
			    b.getUnits().insertBefore(invokeStmt,stmt);
                    
		    	}
		    }
		}
	}
}
