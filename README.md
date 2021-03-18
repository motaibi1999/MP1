# MP1
SE4367 001 - MP1

Part 1: Control Flow Analysis - Finding Dominators

Your task : given a method  m  and a statement  s , to find all the statements in  m  that dominate  s. You are provided with sample code  TestDominatorFinder.java, DominatorFinder.java  and a test program  GCD.java  that computes the greatest common divisor of two integers.  TestDominatorFinder  first uses Soot to build a control flow graph for each method, and constructs a object for each control flow graph. For each statement, it then computes its dominators via the object and prints them out.


The class  DominatorFinder  has been partially implemented. You will need to complete the method  doAnalysis . You may also add new fields and methods.



Part 2: Data Flow Analysis - Call Graph Construction

Your task : run  TestSootCallGraph  on  Example  (add both  TestSootCallGraph.java  and  Example.java  to your project source folder) to compare the precision and speed between CHA and PTA. In addition, you need to read the Soot code of CHA and PTA to understand how they work.


Part 3: Program Instrumentation with Soot


Your task :

● Understand the code in  TestSootLogging.java  and run it. It will generate a file Example.jimple in a folder "sootOutput" under your project directory. Read and understand the Jimple code in Example.jimple
● In the main method of TestSootLogging, comment the statement Options.v().set_output_format(1); and run again. It will generate a Java class file Example.class in "sootOutput". Run java Example to see the output. 

Your task : write code to instrument every field access in  HelloThread  to print out the access information. For example, a typical execution of the instrumented  HelloThread  will print:
