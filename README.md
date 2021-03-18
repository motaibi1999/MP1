# MP1
SE4367 001 - MP1

Part 1: Control Flow Analysis - Finding Dominators

Your task : given a method  m  and a statement  s , to find all the statements in  m  that dominate  s. You are provided with sample code  TestDominatorFinder.java, DominatorFinder.java  and a test program  GCD.java  that computes the greatest common divisor of two integers.  TestDominatorFinder  first uses Soot to build a control flow graph for each method, and constructs a object for each control flow graph. For each statement, it then computes its dominators via the object and prints them out.

Answer: 

r0 := @this: a1.GCD
specialinvoke r0.<java.lang.Object: void <init>()>()
return
r0 := @parameter0: java.lang.String[]
$i2 = lengthof r0
if $i2 >= 2 goto $r1 = r0[0]
$r11 = <java.lang.System: java.io.PrintStream err>
virtualinvoke $r11.<java.io.PrintStream: void println(java.lang.String)>("java GCD int1 int2\nExample: java GCD 876 267")
return
$r1 = r0[0]
i0 = staticinvoke <java.lang.Integer: int parseInt(java.lang.String)>($r1)
$r2 = r0[1]
i1 = staticinvoke <java.lang.Integer: int parseInt(java.lang.String)>($r2)
$r4 = <java.lang.System: java.io.PrintStream out>
$r3 = new java.lang.StringBuilder
specialinvoke $r3.<java.lang.StringBuilder: void <init>(java.lang.String)>("gcd(")
$r5 = virtualinvoke $r3.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i0)
$r6 = virtualinvoke $r5.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(", ")
$r7 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>(i1)
$r8 = virtualinvoke $r7.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>(") = ")
$i3 = staticinvoke <a1.GCD: int gcd(int,int)>(i0, i1)
$r9 = virtualinvoke $r8.<java.lang.StringBuilder: java.lang.StringBuilder append(int)>($i3)
$r10 = virtualinvoke $r9.<java.lang.StringBuilder: java.lang.String toString()>()
virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.String)>($r10)
return
i0 := @parameter0: int
i1 := @parameter1: int
if i0 <= i1 goto i8 = i0
i7 = i1
goto [?= (branch)]
$i5 = i0 % i7
if $i5 != 0 goto i7 = i7 + -1
$i6 = i1 % i7
if $i6 != 0 goto i7 = i7 + -1
return i7
i7 = i7 + -1
if i7 >= 1 goto $i5 = i0 % i7
goto [?= return 1]
i8 = i0
goto [?= (branch)]
$i3 = i0 % i8
if $i3 != 0 goto i8 = i8 + -1
$i4 = i1 % i8
if $i4 != 0 goto i8 = i8 + -1
return i8
i8 = i8 + -1
if i8 >= 1 goto $i3 = i0 % i8
return 1


Part 2: Data Flow Analysis - Call Graph Construction

Your task : run  TestSootCallGraph  on  Example  (add both  TestSootCallGraph.java  and  Example.java  to your project source folder) to compare the precision and speed between CHA and PTA. In addition, you need to read the Soot code of CHA and PTA to understand how they work.


Part 3: Program Instrumentation with Soot


Your task :

1)  Understand the code in  TestSootLogging.java  and run it. It will generate a file Example.jimple in a folder "sootOutput" under your project directory. Read and understand the Jimple code in Example.jimple
2)  In the main method of TestSootLogging, comment the statement Options.v().set_output_format(1); and run again. It will generate a Java class file Example.class in "sootOutput". Run java Example to see the output. 

Your task : write code to instrument every field access in  HelloThread  to print out the access information. For example, a typical execution of the instrumented  HelloThread  will print:
