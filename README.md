# MP1
SE4367 001 - MP1

Part 1: Control Flow Analysis - Finding Dominators

Your task : given a method  m  and a statement  s , to find all the statements in  m  that dominate  s. You are provided with sample code  TestDominatorFinder.java, DominatorFinder.java  and a test program  GCD.java  that computes the greatest common divisor of two integers.  TestDominatorFinder  first uses Soot to build a control flow graph for each method, and constructs a object for each control flow graph. For each statement, it then computes its dominators via the object and prints them out.

Answer: 

![Screen Shot 2021-03-18 at 11 46 10 AM](https://user-images.githubusercontent.com/61093335/111664315-a758bf00-87df-11eb-829d-0bed8089c74d.png)


Part 2: Data Flow Analysis - Call Graph Construction

Your task : run  TestSootCallGraph  on  Example  (add both  TestSootCallGraph.java  and  Example.java  to your project source folder) to compare the precision and speed between CHA and PTA. In addition, you need to read the Soot code of CHA and PTA to understand how they work.

CHA Running:
![Screen Shot 2021-03-18 at 1 47 33 PM](https://user-images.githubusercontent.com/61093335/111680790-92385c00-87f0-11eb-81f1-a790931aa113.png)

PTA Running:
![Screen Shot 2021-03-18 at 1 47 55 PM](https://user-images.githubusercontent.com/61093335/111680819-995f6a00-87f0-11eb-9355-675049a46d90.png)




Part 3: Program Instrumentation with Soot


Your task :

1)  Understand the code in  TestSootLogging.java  and run it. It will generate a file Example.jimple in a folder "sootOutput" under your project directory. Read and understand the Jimple code in Example.jimple

2)  In the main method of TestSootLogging, comment the statement Options.v().set_output_format(1); and run again. It will generate a Java class file Example.class in "sootOutput". Run java Example to see the output. 

![Screen Shot 2021-03-18 at 1 01 51 PM](https://user-images.githubusercontent.com/61093335/111674803-6a45fa00-87ea-11eb-8cb2-a18b8e703f6d.png)


Your task : write code to instrument every field access in  HelloThread  to print out the access information. For example, a typical execution of the instrumented  HelloThread  will print:
