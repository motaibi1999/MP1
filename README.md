# MP1
SE4367 001 - MP1

Part 1: Control Flow Analysis - Finding Dominators

Your task : given a method  m  and a statement  s , to find all the statements in  m  that dominate  s. You are provided with sample code  TestDominatorFinder.java, DominatorFinder.java  and a test program  GCD.java  that computes the greatest common divisor of two integers.  TestDominatorFinder  first uses Soot to build a control flow graph for each method, and constructs a object for each control flow graph. For each statement, it then computes its dominators via the object and prints them out.

Answer: 

The DoAnalysis applied works correctly compared to manually comparing the results from the code with my work. The GCD file was correct and also I created an additional and simpler test class called Sum. 


![Screen Shot 2021-03-18 at 3 26 29 PM](https://user-images.githubusercontent.com/61093335/111693236-615f2380-87fe-11eb-8d2d-afe6764210dd.png)

![Screen Shot 2021-03-18 at 3 26 41 PM](https://user-images.githubusercontent.com/61093335/111693257-658b4100-87fe-11eb-9129-75e3faa51b8d.png)

Sum.java is a replication of the pseudocode we had in our class and knowing for sure that the return statement is dominated by steps 1,2,3 and 6(itself), the output from TestDominatorFinder.java outputs the same result. 

![Screen Shot 2021-03-18 at 3 21 53 PM](https://user-images.githubusercontent.com/61093335/111693486-ae42fa00-87fe-11eb-8e81-3586161f7dd1.png)

We also know that step 1 is only dominated by itself which is further proved by this screenshot. 

![Screen Shot 2021-03-18 at 3 22 05 PM](https://user-images.githubusercontent.com/61093335/111693560-c155ca00-87fe-11eb-896b-d50771f4d5cc.png)



Part 2: Data Flow Analysis - Call Graph Construction

Your task : run  TestSootCallGraph  on  Example  (add both  TestSootCallGraph.java  and  Example.java  to your project source folder) to compare the precision and speed between CHA and PTA. In addition, you need to read the Soot code of CHA and PTA to understand how they work.

Running with no CHA or PTA: 

![Screen Shot 2021-03-19 at 9 50 52 AM](https://user-images.githubusercontent.com/61093335/111799601-2b22b200-8899-11eb-8dbe-6294baf8dd10.png)

Number of edges: 12
Speed: 7 seconds

I had to uncomment the following to run each of CHA and PTA 

![Screen Shot 2021-03-18 at 3 46 41 PM](https://user-images.githubusercontent.com/61093335/111695508-2f02f580-8801-11eb-98fc-72cf6c135f95.png)


CHA Running:

![Screen Shot 2021-03-19 at 10 00 32 AM](https://user-images.githubusercontent.com/61093335/111800765-47731e80-889a-11eb-890e-a031b385a5f8.png)

Number of edges: 12
Speed: 3 seconds

PTA Running:

![Screen Shot 2021-03-19 at 10 02 39 AM](https://user-images.githubusercontent.com/61093335/111800780-4a6e0f00-889a-11eb-9013-4c0eef4d968f.png)

Number of edges: 7
Speed: 3 seconds


Conclusion: 

CHA is not very precise class hierarchy analysis that at call o.f() identifies the type of o and all its subtypes, and returns all the methods f() defined in these types. This is shown by the fact that it expanded 16 edges when it ran. While PTA is more precise and proven by the 9 edges expanded, but PTA is not as simple as CHA as it needs to analyze the data flow in the whole program, and takes more time and memory than CHA. In simple words, PTA is more precise but slower than CHA. 

Part 3: Program Instrumentation with Soot


Your task :

1)  Understand the code in  TestSootLogging.java  and run it. It will generate a file Example.jimple in a folder "sootOutput" under your project directory. Read and understand the Jimple code in Example.jimple

2)  In the main method of TestSootLogging, comment the statement Options.v().set_output_format(1); and run again. It will generate a Java class file Example.class in "sootOutput". Run java Example to see the output. 

![Screen Shot 2021-03-18 at 1 01 51 PM](https://user-images.githubusercontent.com/61093335/111674803-6a45fa00-87ea-11eb-8cb2-a18b8e703f6d.png)


Your task : write code to instrument every field access in  HelloThread  to print out the access information. For example, a typical execution of the instrumented  HelloThread  will print:
