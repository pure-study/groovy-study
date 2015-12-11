package net.will.gls.structure

/*
 * if the variable is declared as in the first example, it is a local variable. It will be declared
 * in the run method that the compiler will generate and will not be visible outside of the script 
 * main body. In particular, such a variable will not be visible in other methods of the script.
 */
int x = 1
int y = 2
assert x + y == 3

/*
 * if the variable is undeclared, it goes into the script binding. The binding is visible from the 
 * methods, and is especially important if you use a script to interact with an application and 
 * need to share data between the script and the application.
 */
a = 1
b = 2
assert a + b == 3
//assert a + b != 3

