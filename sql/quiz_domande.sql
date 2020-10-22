INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (524, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are valid Java identifiers? (Choose all that apply)', null, 'A, B, E', ' 
			Option A is valid because you can use the dollar sign in identifiers. Option B is
			valid because you can use an underscore in identifiers. Option C is not a valid identifier
			because true is a Java reserved word. Option D is not valid because the dot (.) is not
			allowed in identifiers. Option E is valid because Java is case sensitive, so Public is not
			a reserved word and therefore a valid identifier. Option F is not valid because the first
			character is not a letter, $, or _.
		', 1, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (525, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following program?
			1: public class WaterBottle {
			2: private String brand;
			3: private boolean empty;
			4: public static void main(String[] args) {
			5: WaterBottle wb = new WaterBottle();
			6: System.out.print("Empty = " + wb.empty);
			7: System.out.print(", Brand = " + wb.brand);
			8: } } 
		', 'checkbox', 'D', ' 
			Boolean fields initialize to false and references initialize to null, so empty is false and brand is null.
			Brand = null is output. 
		', 1, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (526, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
			4: short numPets = 5;
			5: int numGrains = 5.6;
			6: String name = "Scruffy";
			7: numPets.length();
			8: numGrains.length();
			9: name.length(); 
		', 'checkbox', 'B, D, E', ' 
			Option A (line 4) compiles because short is an integral type. Option B (line
			5) generates a compiler error because int is an integral type, but 5.6 is a floating-point
			type. Option C (line 6) compiles because it is assigned a String. Options D and E (lines
			7 and 8) do not compile because short and int are primitives. Primitives do not allow
			methods to be called on them. Option F (line 9) compiles because length() is defined
			on String. 
		', 1, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (527, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following class, which of the following is true? (Choose all that apply)
			
			 1: public class Snake {
			 2:
			 3: public void shed(boolean time) {
			 4:
			 5: if (time) {
			 6:
			 7: }
			 8: System.out.println(result);
			 9:
			10: }
			11: }
		', 'checkbox', 'A, B', ' 
			Adding the variable at line 2 makes result an instance variable. Since instance
			variables are in scope for the entire life of the object, option A is correct. Option B is
			correct because adding the variable at line 4 makes result a local variable with a scope
			of the whole method. Adding the variable at line 6 makes result a local variable with
			a scope of lines 6–7. Since it is out of scope on line 8, the println does not compile and
			option C is incorrect. Adding the variable at line 9 makes result a local variable with
			a scope of lines 9 and 10. Since line 8 is before the declaration, it does not compile and
			option D is incorrect. Finally, option E is incorrect because the code can be made to
			compile. 
		', 1, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (528, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following classes, which of the following can independently replace INSERT
			IMPORTS HERE to make the code compile? (Choose all that apply)
			
			package aquarium;
			public class Tank { }
			
			package aquarium.jellies;
			public class Jelly { }
			
			package visitor;
			INSERT IMPORTS HERE
			public class AquariumVisitor {
				public void admire(Jelly jelly) { } }
		', 'checkbox', 'C, D', ' 
			Option C is correct because it imports Jelly by classname. Option D is correct because it imports all the classes in the jellies package, which includes Jelly.
			Option A is incorrect because it only imports classes in the aquarium package—Tank
			in this case—and not those in lower-level packages. Option B is incorrect because you
			cannot use wildcards anyplace other than the end of an import statement. Option E is
			incorrect because you cannot import parts of a class with a regular import statement.
			Option F is incorrect because options C and D do make the code compile. 
		', 1, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (529, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following classes, what is the maximum number of imports that can be removed
			and have the code still compile?
			
			package aquarium; public class Water { }
			
			package aquarium;
			import java.lang.*;
			import java.lang.System;
			import aquarium.Water;
			import aquarium.*;
			public class Tank {
				public void print(Water water) {
					System.out.println(water); } }
		', 'checkbox', 'E', ' 
			The first two imports can be removed because java.lang is automatically imported.
			The second two imports can be removed because Tank and Water are in the same package, making the correct answer E. If Tank and Water were in different packages, one of
			these two imports could be removed. In that case, the answer would be option D.  
		', 1, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (530, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following classes, which of the following snippets can be inserted in place of
			INSERT IMPORTS HERE and have the code compile? (Choose all that apply)
			
			package aquarium;
			public class Water {
				boolean salty = false;
			}
			
			package aquarium.jellies;
			public class Water {
				boolean salty = true;
			}
			
			package employee;
				INSERT IMPORTS HERE
			public class WaterFiller {
				Water water;
			}
		', 'checkbox', 'A, B, C', ' 
			Option A is correct because it imports all the classes in the aquarium package
			including aquarium.Water. Options B and C are correct because they import Water by
			classname. Since importing by classname takes precedence over wildcards, these compile. Option D is incorrect because Java doesn’t know which of the two wildcard Water
			classes to use. Option E is incorrect because you cannot specify the same classname in
			two imports 
		', 1, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (531, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following class, which of the following calls print out Blue Jay? (Choose all that
			apply)
			
			public class BirdDisplay {
				public static void main(String[] name) {
					System.out.println(name[1]);
			} }
		', 'checkbox', 'B', ' 
			Option B is correct because arrays start counting from zero and strings with spaces
			must be in quotes. Option A is incorrect because it outputs Blue. C is incorrect because
			it outputs Jay. Option D is incorrect because it outputs Sparrow. Options E and F are
			incorrect because they output Error: Could not find or load main class BirdDisplay.class.
		', 1, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (532, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following legally fill in the blank so you can run the main() method from the
			command line? (Choose all that apply)
			
			public static void main(______________) 
		', 'checkbox', 'A, C, D, E', ' 
			Option A is correct because it is the traditional main() method signature
			and variables may begin with underscores. Options C and D are correct because the
			array operator may appear after the variable name. Option E is correct because
			varargs are allowed in place of an array. Option B is incorrect because variables are
			not allowed to begin with a digit. Option F is incorrect because the argument must be
			an array or varargs. Option F is a perfectly good method. However, it is not one that
			can be run from the command line because it has the wrong parameter type. 
		', 1, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (533, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are legal entry point methods that can be run from the command
			line? (Choose all that apply)
		', 'checkbox', 'E', ' 
			Option E is the canonical main() method signature. You need to memorize it.
			Option A is incorrect because the main() method must be public. Options B and F
			are incorrect because the main() method must have a void return type. Option C is
			incorrect because the main() method must be static. Option D is incorrect because the
			main() method must be named main.  
		', 1, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (534, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'C, D', ' 
			Option C is correct because all non-primitive values default to null. Option D is
			correct because float and double primitives default to 0.0. Options B and E are incorrect because int primitives default to 0.  
		', 1, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (535, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'G', ' 
			Option G is correct because local variables do not get assigned default values. The
			code fails to compile if a local variable is not explicitly initialized. If this question
			were about instance variables, options D and F would be correct. A boolean primitive
			defaults to false and a float primitive defaults to 0.0.
		', 1, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (536, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'A, D', ' 
			Options A and D are correct because boolean primitives default to false and
			int primitives default to 0. 
		', 1, 13, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (537, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following class in the file /my/directory/named/A/Bird.java:
			
			INSERT CODE HERE
			public class Bird { }
			
			Which of the following replaces INSERT CODE HERE if we compile from /my/directory?(Choose all that apply)
		', 'checkbox', 'D', ' 
			The package name represents any folders underneath the current path, which is
			named.A in this case. Option B is incorrect because package names are case sensitive,
			just like variable names and other identifiers. 
		', 1, 14, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (538, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following lines of code compile? (Choose all that apply)
		', 'checkbox', 'A, D', ' 
			Underscores are allowed as long as they are directly between two other digits.
			This means options A and E are correct. Options B and C are incorrect because the
			underscore is adjacent to the decimal point. Option D is incorrect because the underscore is the last character.  
		', 1, 15, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (539, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following class, which of the following lines of code can replace INSERT CODE
			HERE to make the code compile? (Choose all that apply)
			
			public class Price {
				public void admission() {
					INSERT CODE HERE
					System.out.println(amount);
			 } }
		', 'checkbox', 'B, C, D', ' 
			0b is the prefix for a binary value and is correct. 0x is the prefix for a hexadecimal value. This value can be assigned to many primitive types, including int and
			double, making options C and D correct. Option A is incorrect because 9L is a long
			value. long amount = 9L would be allowed. Option E is incorrect because the underscore is immediately before the decimal. Option F is incorrect because the underscore is
			the very last character. 
		', 1, 16, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (540, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
			
			public class Bunny {
				public static void main(String[] args) {
					Bunny bun = new Bunny();
			} }
		', 'checkbox', 'A, E', ' 
			Bunny is a class, which can be seen from the declaration: public class Bunny. bun
			is a reference to an object. main() is a method.
		', 1, 17, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (541, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which represent the order in which the following statements can be assembled into a program that will compile successfully? (Choose all that apply)
			
			A: class Rabbit {}
			B: import java.util.*;
			C: package animals;
		', 'checkbox', 'C, D, E', ' 
			package and import are both optional. If both are present, the order must
			be package, then import, then class. Option A is incorrect because class is before
			package and import. Option B is incorrect because import is before package. Option
			F is incorrect because class is before package. Option G is incorrect because class is
			before import.
		', 1, 18, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (542, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Suppose we have a class named Rabbit. Which of the following statements are true?
			(Choose all that apply)
			
			1: public class Rabbit {
			2: 	public static void main(String[] args) {
			3: 		Rabbit one = new Rabbit();
			4: 		Rabbit two = new Rabbit();
			5: 		Rabbit three = one;
			6: 		one = null;
			7: 		Rabbit four = one;
			8: 		three = null;
			9: 		two = null;
			10: 	two = new Rabbit();
			11: 	System.gc();
			12: } }

		', 'checkbox', 'B, D', ' 
			The Rabbit object from line 3 has two references to it: one and three. The references are nulled out on lines 6 and 8, respectively. Option B is correct because this
			makes the object eligible for garbage collection after line 8. Line 7 sets the reference
			four to the now null one, which means it has no effect on garbage collection. The Rabbit object from line 4 only has a single reference to it: two. Option D is correct because
			this single reference becomes null on line 9. The Rabbit object declared on line 10
			becomes eligible for garbage collection at the end of the method on line 12. Calling
			System.gc() has no effect on eligibility for garbage collection.
		', 1, 19, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (543, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is true about the following code? (Choose all that apply)
			
			public class Bear {
				protected void finalize() {
					System.out.println("Roar!");
			}

			public static void main(String[] args) {
				Bear bear = new Bear();
				bear = null;
				System.gc();
			} }
		', 'checkbox', 'B, E', ' 
			Calling System.gc() suggests that Java might wish to run the garbage collector.
			Java is free to ignore the request, making option E correct. finalize() runs if an object
			attempts to be garbage collected, making option B correct.
		', 1, 20, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (544, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What does the following code output?
			
			1: public class Salmon {
			2: 	int count;
			3: 	public void Salmon() {
			4: 		count = 4;
			5: }
			6: public static void main(String[] args) {
			7: 	Salmon s = new Salmon();
			8: 	System.out.println(s.count);
			9: } }
		', 'checkbox', 'A', ' 
			While the code on line 3 does compile, it is not a constructor because it has a return
			type. It is a method that happens to have the same name as the class. When the code
			runs, the default constructor is called and count has the default value (0) for an int.
		', 1, 21, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (545, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true statements? (Choose all that apply)
		', 'checkbox', 'B, E', ' 
			C++ has operator overloading and pointers. Java made a point of not having
			either. Java does have references to objects, but these are pointing to an object that can
			move around in memory. Option B is correct because Java is platform independent.
			Option E is correct because Java is object oriented. While it does support some parts of
			functional programming, these occur within a class.
		', 1, 22, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (546, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'C, D', ' 
			Java puts source code in .java files and bytecode in .class files. It does not use
			a .bytecode file. When running a Java program, you pass just the name of the class
			without the .class extension.
		', 1, 23, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (547, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given:
			
			class EJava {
			 //..code
			}
			
			Which of the following options will compile?
		', null, 'E', '
			Explanation: A class that isn’t defined in a package gets implicitly defined in Java’s
			default package. But such classes can’t be accessed by classes or interfaces, which are
			explicitly defined in a package.
			Option a is incorrect. The EJava class isn’t defined in a package, so it can’t be
			accessed by the Guru class, which is defined in the java.oca.associate package.
			Options b, c, and d won’t compile. Option b uses invalid syntax in the import statement. Options c and d try to import classes from nonexistent packages—java.default
			and default. 
		', 1, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (548, 'OCA Java SE 8 Programmer I Certification Guide', '
			The following numbered list of Java class components is not in any particular
			order. Select the correct order of their occurrence in a Java class (choose all that apply):
			
			1 comments
			2 import statement
			3 package statement
			4 methods
			5 class declaration
			6 variables
		', 'checkbox', 'A, B, D', '
			Explanation: The comments can appear anywhere in a class. They can appear before
			and after package and import statements. They can appear before or after a class,
			method, or variable declaration.
			The first statement (if present) in a class should be a package statement. It can’t be
			placed after an import statement or a declaration of a class.
			The import statement should follow a package statement and be followed by a
			class declaration.
			The class declaration follows the import statements, if present. It’s followed by the
			declaration of the methods and variables.
			Answer c is incorrect. None of the variables or methods can be defined before the
			definition of a class or interface.
		', 1, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (549, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following examples defines a correct Java class structure?
		', 'checkbox', 'D', '
			Explanation: Option a is incorrect because #connect isn’t a statement in Java. # is
			used to add comments in UNIX.
			Option b is incorrect because a package name (Java compiler) can’t contain
			spaces. Also, java virtual machine isn’t a valid package name to be imported in a
			class. The package name to be imported can’t contain spaces.
			Option c is incorrect because a package statement (if present) must be placed
			before an import statement.
			Option e is incorrect. #package and $import aren’t valid statements or directives
			in Java.
			Option f is incorrect. Java is case-sensitive, so the word class is not the same as the
			word Class. The correct keyword to define a class is class.
		', 1, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (550, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following contents of the Java source code file MyClass.java, select the
			correct options:
			
			// contents of MyClass.java
			package com.ejavaguru;
			import java.util.Date;
			class Student {}
			class Course {}
		', 'checkbox', 'B, C', '
			Explanation: You can define multiple classes, interfaces, and enums in a Java source
			code file.
			Option a is incorrect. The import statement applies to all the classes, interfaces,
			and enums defined within the same Java source code file.
			Option d is incorrect. If a package statement is defined in the source code file, all
			the classes, interfaces, and enums defined within it will exist in the same Java package. 
		', 1, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (551, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following definition of the class EJavaGuru,
			
			class EJavaGuru {
				public static void main(String[] args) {
					System.out.println(args[1]+":"+ args[2]+":"+ args[3]);
				}
			}

			what is the output of the previous class, if it is executed using the following command?
			
				java EJavaGuru one two three four
		', 'checkbox', 'D', '
			Explanation: The command-line arguments passed to the main method of a class do
			not contain the word Java and the name of the class.
			Because the position of an array is zero-based, the method argument is assigned
			the following values:
				args[0] -> one
				args[1] -> two
				args[2] -> three
				args[3] -> four
			The class prints two:three:four.
		', 1, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (552, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following options, when inserted at //INSERT CODE HERE, will print
			out EJavaGuru?
			
			public class EJavaGuru {
			 // INSERT CODE HERE
			 {
				System.out.println("EJavaGuru");
			 }
			}
		', 'checkbox', 'C', '
			Explanation: Option a is incorrect. This option defines a valid method but not a valid
			main method. The main method should be defined as a static method, which is missing from the method declaration in option a.
			Option b is incorrect. This option is similar to the method defined in option a,
			with one difference. In this option, the square brackets are placed after the name of
			the method argument. The main method accepts an array as a method argument, and
			to define an array, the square brackets can be placed after either the data type or the
			method argument name.
			Option c is correct. Extra spaces in a class are ignored by the Java compiler.
			Option d is incorrect. The main method accepts an array of String as a method
			argument. The method in this option accepts a single String object.
			Option e is incorrect. It isn’t a valid method definition and doesn’t specify the
			return type of the method. This line of code will not compile.
		', 1, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (553, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the meaning of “write once, run anywhere”? Select the correct options:
		', 'checkbox', 'C', '
			Explanation: Platform independence, or “write once, run anywhere,” enables Java
			code to be compiled once and run on any system with a JVM.
			It isn’t for marketing purposes only.
		', 1, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (554, 'OCA Java SE 8 Programmer I Certification Guide', '
			A class Course is defined in a package com.ejavaguru. Given that the physical
			location of the corresponding class file is /mycode/com/ejavaguru/Course.class
			and execution takes place within the mycode directory, which of the following lines
			of code, when inserted at // INSERT CODE HERE, will import the Course class into the
			class MyCourse?
		
			// INSERT CODE HERE
			class MyCourse {
				Course c;
			}
		', 'checkbox', 'B', '
			Explanation: Option a is incorrect. The base directory, mycode, in which package
			com.ejavaguru is defined, must not be included in the import statement.
			Options c and e are incorrect. The class’s physical location isn’t specified in the
			import statement.
			Options d and f are incorrect. ejavaguru is a package. To import a package and its
			members, the package name should be followed by .*, as follows:
			
			import com.ejavaguru.*;
		', 1, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (555, 'OCA Java SE 8 Programmer I Certification Guide', '
			Examine the following code:

			class Course {
			 String courseName;
			}
			class EJavaGuru {
			 public static void main(String args[]) {
				Course c = new Course();
				c.courseName = "Java";
				System.out.println(c.courseName);
			 }
			}
			
			Which of the following statements will be true if the variable courseName is defined as a private variable?
		', 'checkbox', 'C', '
			Explanation: If the variable courseName is defined as a private member, it won’t be
			accessible from the class EJavaGuru. An attempt to do so will cause it to fail at compile
			time. Because the code won’t compile, it can’t execute.
		', 1, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (556, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following definition of the class Course,
			
			package com.ejavaguru.courses;
			class Course {
			 public String courseName;
			}
			
			what’s the output of the following code?
			
			package com.ejavaguru;
			import com.ejavaguru.courses.Course;
			class EJavaGuru {
			 public static void main(String args[]) {
				Course c = new Course();
				c.courseName = "Java";
				System.out.println(c.courseName);
			 }
			}
		', 'checkbox', 'C', '
			Explanation: The class will fail to compile because a nonpublic class can’t be accessed
			outside a package in which it’s defined. The class Course therefore can’t be accessed
			from within the class EJavaGuru, even if it’s explicitly imported into it. If the class itself
			isn’t accessible, there’s no point in accessing a public member of a class.
		', 1, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (557, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following code, select the correct options:
			
			package com.ejavaguru.courses;
			class Course {
			 public String courseName;
			 public void setCourseName(private String name) {
				courseName = name;
			 }
			}
		', 'checkbox', 'A', '
			Explanation: You can’t add an explicit accessibility keyword to the method parameters.
			If you do, the code won’t compile.
		', 1, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (558, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following Java operators can be used with boolean variables? (Choose all that apply)
		', null, 'A, D', ' 
			Option A is the equality operator and can be used on numeric primitives, boolean values, and object references. Options B and C are both arithmetic operators and
			cannot be applied to a boolean value. Option D is the logical complement operator
			and is used exclusively with boolean values. Option E is the modulus operator, which
			can only be used with numeric primitives. Finally, option F is a relational operator that
			compares the values of two numbers.
		', 2, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (559, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What data type (or types) will allow the following code snippet to compile? (Choose all that apply)
			
			byte x = 5;
			byte y = 10;
			_____ z = x + y;
		', 'checkbox', 'A, B, D', ' 
			The value x + y is automatically promoted to int, so int and data types that
			can be promoted automatically from int will work. Options A, B, D are such data
			types. Option C will not work because boolean is not a numeric data type. Options E
			and F will not work without an explicit cast to a smaller data type.
		', 2, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (560, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following application?
			
			1: public class CompareValues {
			2: 	public static void main(String[] args) {
			3: 		int x = 0;
			4: 		while(x++ < 10) {}
			5: 			String message = x > 10 ? "Greater than" : false;
			6: 			System.out.println(message+","+x);
			7: }
			8: }
		', 'checkbox', 'F', ' 
			In this example, the ternary operator has two expressions, one of them a String and
			the other a boolean value. The ternary operator is permitted to have expressions that
			don’t have matching types, but the key here is the assignment to the String reference.
			The compiler knows how to assign the first expression value as a String, but the second boolean expression cannot be set as a String; therefore, this line will not compile.
		', 2, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (561, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What change would allow the following code snippet to compile? (Choose all that apply)
			
			3: long x = 10;
			4: int y = 2 * x;
		', 'checkbox', 'B, C, D, F', ' 
			The code will not compile as is, so option A is not correct. The value 2 * x
			is automatically promoted to long and cannot be automatically stored in y, which is
			in an int value. Options B, C, and D solve this problem by reducing the long value to
			int. Option E does not solve the problem and actually makes it worse by attempting
			to place the value in a smaller data type. Option F solves the problem by increasing the
			data type of the assignment so that long is allowed.
		', 2, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (562, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			3: java.util.List<Integer> list = new java.util.ArrayList<Integer>();
			4: list.add(10);
			5: list.add(14);
			6: for(int x : list) {
			7: 	System.out.print(x + ", ");
			8: 	break;
			9: }
		', 'checkbox', 'C', ' 
			This code does not contain any compilation errors or an infinite loop, so options D,
			E, and F are incorrect. The break statement on line 8 causes the loop to execute once
			and finish, so option C is the correct answer
		', 2, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (563, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			3: int x = 4;
			4: long y = x * 4 - x++;
			5: if(y<10) System.out.println("Too Low");
			6: else System.out.println("Just right");
			7: else System.out.println("Too High");
		', 'checkbox', 'F', ' 
			The code does not compile because two else statements cannot be chained together
			without additional if-then statements, so the correct answer is option F. Option E is
			incorrect as Line 6 by itself does not cause a problem, only when it is paired with Line
			7. One way to fix this code so it compiles would be to add an if-then statement on
			line 6. The other solution would be to remove line 7.
		', 2, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (564, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			1: public class TernaryTester {
			2: 	public static void main(String[] args) {
			3: 		int x = 5;
			4: 		System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);
			5: }}
		', 'checkbox', 'D', ' 
			As you learned in the section “Ternary Operator,” although parentheses are not
			required, they do greatly increase code readability, such as the following equivalent
			statement:
			System.out.println((x > 2) ? ((x < 4) ? 10 : 8) : 7)
			We apply the outside ternary operator fi rst, as it is possible the inner ternary expression
			may never be evaluated. Since (x>2) is true, this reduces the problem to:
			System.out.println((x < 4) ? 10 : 8)
			Since x is greater than 2, the answer is 8, or option D in this case
		', 2, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (565, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			3: boolean x = true, z = true;
			4: int y = 20;
			5: x = (y != 10) ^ (z=false);
			6: System.out.println(x+", "+y+", "+z);
		', 'checkbox', 'B', ' 
			This example is tricky because of the second assignment operator embedded in line
			5. The expression (z=false) assigns the value false to z and returns false for the
			entire expression. Since y does not equal 10, the left-hand side returns true; therefore,
			the exclusive or (^) of the entire expression assigned to x is true. The output reflects
			these assignments, with no change to y, so option B is the only correct answer. The
			code compiles and runs without issue, so option F is not correct.
		', 2, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (566, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			How many times will the following code print "Hello World"?
			
			3: for(int i=0; i<10 ; ) {
			4: 		i = i++;
			5: 		System.out.println("Hello World");
			6: }
		', 'checkbox', 'F', ' 
			In this example, the update statement of the for loop is missing, which is fine as the
			statement is optional, so option D is incorrect. The expression inside the loop increments i but then assigns i the old value. Therefore, i ends the loop with the same value
			that it starts with: 0. The loop will repeat infinitely, outputting the same statement over
			and over again because i remains 0 after every iteration of the loop.
		', 2, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (567, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			3: byte a = 40, b = 50;
			4: byte sum = (byte) a + b;
			5: System.out.println(sum);
		', 'checkbox', 'D', ' 
			Line 4 generates a possible loss of precision compiler error. The cast operator has
			the highest precedence, so it is evaluated first, casting a to a byte. Then, the addition is
			evaluated, causing both a and b to be promoted to int values. The value 90 is an int
			and cannot be assigned to the byte sum without an explicit cast, so the code does not
			compile. The code could be corrected with parentheses around (a + b), in which case
			option C would be the correct answer.
		', 2, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (568, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: public class ArithmeticSample {
			2: 	public static void main(String[] args) {
			3: 		int x = 5 * 4 % 3;
			4: 		System.out.println(x);
			5: }}
		', 'checkbox', 'A', ' 
			The * and % have the same operator precedence, so the expression is evaluated
			from left-to-right. The result of 5 * 4 is 20, and 20 % 3 is 2 (20 divided by 3 is 18, the
			remainder is 2). The output is 2 and option A is the correct answer.
		', 2, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (569, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			3: int x = 0;
			4: String s = null;
			5: if(x == s) System.out.println("Success");
			6: else System.out.println("Failure");
		', 'checkbox', 'D', ' 
			The variable x is an int and s is a reference to a String object. The two data types
			are incomparable because neither variable can be converted to the other variable’s type.
			The compiler error occurs on line 5 when the comparison is attempted, so the answer
			is option D.
		', 2, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (570, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			3: int x1 = 50, x2 = 75;
			4: boolean b = x1 >= x2;
			5: if(b = true) System.out.println("Success");
			6: else System.out.println("Failure");
		', 'checkbox', 'A', ' 
			The code compiles successfully, so options C and D are incorrect. The value of b
			after line 4 is false. However, the if-then statement on line 5 contains an assignment,
			not a comparison. The variable b is assigned true on line 3, and the assignment operator returns true, so line 5 executes and displays Success, so the answer is option A.
		', 2, 13, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (571, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			3: int c = 7;
			4: int result = 4;
			5: result += ++c;
			6: System.out.println(result);
		', 'checkbox', 'C', ' 
			The code compiles successfully, so option F is incorrect. On line 5, the pre-increment operator is used, so c is incremented to 4 and the new value is returned to the
			expression. The value of result is computed by adding 4 to the original value of 8,
			resulting in a new value of 12, which is output on line 6. Therefore, option C is the
			correct answer
		', 2, 14, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (572, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			3: int x = 1, y = 15;
			4: while x < 10
			5: y––;
			6: x++;
			7: System.out.println(x+", "+y);
		', 'checkbox', 'E', ' 
			This is actually a much simpler problem than it appears to be. The while statement
			on line 4 is missing parentheses, so the code will not compile, and option E is the correct answer. If the parentheses were added, though, option F would be the correct
			answer since the loop does not use curly braces to include x++ and the boolean expression never changes. Finally, if curly braces were added around both expressions, the
			output would be 10, 6 and option B would be correct.
		', 2, 15, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (573, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?

			3: do {
			4: int y = 1;
			5: System.out.print(y++ + " ");
			6: } while(y <= 10);
		', 'checkbox', 'D', ' 
			The variable y is declared within the body of the do-while statement, so it is out of
			scope on line 6. Line 6 generates a compiler error, so option D is the correct answer.
		', 2, 16, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (574, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?ù
			
			3: boolean keepGoing = true;
			4: int result = 15, i = 10;
			5: do {
			6: 		i--;
			7: 		if(i==8) keepGoing = false;
			8: 		result -= 2;
			9: } while(keepGoing);
			10: System.out.println(result);

		', 'checkbox', 'D', ' 
			The code compiles without issue, so option F is incorrect. After the first execution of the loop, i is decremented to 9 and result to 13. Since i is not 8, keepGoing is
			false, and the loop continues. On the next iteration, i is decremented to 8 and result
			to 11. On the second execution, i does equal 8, so keepGoing is set to false. At the
			conclusion of the loop, the loop terminates since keepGoing is no longer true. The
			value of result is 11, and the correct answer is option D.
		', 2, 17, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (575, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			3: int count = 0;
			4: ROW_LOOP: for(int row = 1; row <=3; row++)
			5: 	for(int col = 1; col <=2 ; col++) {
			6: 		if(row * col % 2 == 0) continue ROW_LOOP;
			7: 		count++;
			8: 	}
			9: System.out.println(count);
		', 'checkbox', 'A', ' 
			The expression on line 5 is true when row * col is an even number. On the first
			iteration, row = 1 and col = 1, so the expression on line 6 is false, the continue is
			skipped, and count is incremented to 1. On the second iteration, row = 1 and 
			Chapter 3: Core Java APIs 339
			bapp01.indd 1½ 4/2014 Page 339
			col = 2, so the expression on line 6 is true and the continue ends the outer loop with
			count still at 1. On the third iteration, row = 2 and col = 1, so the expression on line
			6 is true and the continue ends the outer loop with count still at 1. On the fourth
			iteration, row = 3 and col = 1, so the expression on line 6 is false, the continue is
			skipped, and count is incremented to 2. Finally, on the fifth and final iteration, row
			= 3 and col = 2, so the expression on line 6 is true and the continue ends the outer
			loop with count still at 2. The result of 2 is displayed, so the answer is option B.
		', 2, 18, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (576, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code snippet?
			
			3: int m = 9, n = 1, x = 0;
			4: while(m > n) {
			5: 		m--;
			6: 		n += 2;
			7: 		x += m + n;
			8: }
			9: System.out.println(x);
		', 'checkbox', 'D', ' 
			Prior to the first iteration, m = 9, n = 1, and x = 0. After the iteration of the first
			loop, m is updated to 8, n to 3, and x to the sum of the new values for m + n, 0 + 11 =
			11. After the iteration of the second loop, m is updated to 7, n to 5, and x to the sum
			of the new values for m + n, 11 + 12 = 23. After the iteration of the third loop, m is
			updated to 6, n to 7, and x to the sum of the new values for m + n, 23 + 13 = 36. On
			the fourth iteration of the loop, m > n evaluates to false, as 6 < 7 is not true. The
			loop ends and the most recent value of x, 36, is output, so the correct answer is option
			D.
		', 2, 19, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (577, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code snippet?
			
			3: final char a = ''A'', d = ''D'';
			4: char grade = ''B'';
			5: switch(grade) {
			6: 	case a:
			7: 	case ''B'': System.out.print("great");
			8: 	case ''C'': System.out.print("good"); break;
			9: 	case d:
			10: case ''F'': System.out.print("not good");
			11: }
		', 'checkbox', 'B', ' 
			The code compiles and runs without issue, so options C, D, and E are not correct.
			The value of grade is ''B'' and there is a matching case statement that will cause "great" to be printed. 
			There is no break statement after the case, though, so the next case statement will be reached, and "good" will be printed.
			There is a break after this case statement, though, so the switch statement will end. The correct answer is thus option B.
		', 2, 20, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (578, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given:
			
			int myChar = 97;
			int yourChar = 98;
			System.out.print((char)myChar + (char)yourChar);
			
			int age = 20;
			System.out.print(" ");
			System.out.print((float)age);
			
			What is the output?
		', null, 'A', '
			Explanation: When a char primitive data type is used as an operand to arithmetic
			operators, its corresponding ASCII value is used in the arithmetic operation. Though
			char)myChar explicitly casts int variable myChar to char type, its value 97 is used in
			the arithmetic operation. When literal value 20 is explicitly cast to a float type, it outputs its value as a decimal number, that is, 20.0. 
		', 2, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (579, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the options are correct for the following code?
			
			public class Prim { 							// line 1
			 public static void main(String[] args) { 		// line 2
				char a = ''a''; 								// line 3
				char b = -10; 								// line 4
				char c = ''1''; 								// line 5
				integer d = 1000; 							// line 6
				System.out.println(++a + b++ * c - d); 		// line 7
			 } 												// line 8
			} 												// line 9
		', 'checkbox', 'A, C, D', '
			Explanation: Option (a) is correct. The code at line 4 fails to compile because you
			can’t assign a negative value to a primitive char data type without casting.
			Option (c) is correct. There is no primitive data type with the name “integer.” The
			valid data types are int and Integer (a wrapper class with I in uppercase).
			Option (d) is correct. The variable d remains undefined on line 7 because its declaration fails to compile on line 6. So the arithmetic expression (++a + b++ * c - d)
			that uses variable d fails to compile. There are no issues with using the variable c of
			the char data type in an arithmetic expression. The char data types are internally
			stored as unsigned integer values and can be used in arithmetic expressions.
		', 2, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (580, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			public class Foo {
			 public static void main(String[] args) {
				int a = 10;
				long b = 20;
				short c = 30;
				System.out.println(++a + b++ * c);
			 }
			}
		', 'checkbox', 'A', '
			Explanation: The prefix increment operator (++) used with the variable a will increment its value before it’s used in the expression ++a + b++ * c. The postfix increment
			operator (++) used with the variable b will increment its value after its initial value is
			used in the expression ++a + b++ * c.
			Therefore, the expression ++a + b++ * c evaluates with the following values:
				11 + 20 * 30
				
			Because the multiplication operator has a higher precedence than the addition operator, the values 20 and 30 are multiplied before the result is added to the value 11.
			The example expression evaluates as follows:
			
				(++a + b++ * c)
				= 11 + 20 * 30
				= 11 + 600
				= 611		
		', 2, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (581, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given:
			
			Boolean buy = new Boolean(true);
			Boolean sell = new Boolean(true);
			System.out.print(buy == sell);
			
			boolean buyPrim = buy.booleanValue();
			System.out.print(!buyPrim);
			
			System.out.print(buy && sell);
			
			What is the output?
		', 'checkbox', 'D', '
			Explanation: The Boolean instances buy and sell are created using constructors.
			Constructors don’t refer to existing instances in cache; they create new instances.
			Because the comparison operator == compares object references and not the primitive value stored by a wrapper instance, buy == sell returns false.
			The method booleanValue() can be used to get the primitive boolean value
			stored by a Boolean wrapper instance. So buy.booleanValue() returns false. Because
			wrapper instances can be used with arithmetic and logical operators, buy && sell compiles, returning true.		
		', 2, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (582, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following options contain correct code to declare and initialize
			variables to store whole numbers?
		', 'checkbox', 'C, D, F, G', '
			Explanation: Options (a) and (b) are incorrect. There are no primitive data types in
			Java with the names bit and integer. The correct names are byte and int.
			 Option (c) is correct. It assigns a hexadecimal literal value to the variable a3.
			 Option (d) is correct. It assigns an octal literal value to the variable a4.
			 Option (e) is incorrect. It defines a variable of type double, which is used to store
			decimal numbers, not integers.
			 Option (f) is correct. -0 is a valid literal value.
			 Option (g) is correct. 123456789 is a valid integer literal value that can be assigned
			to a variable of type long.
		', 2, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (583, 'OCA Java SE 8 Programmer I Certification Guide', '
			Select the options that, when inserted at // INSERT CODE HERE, will make the following code output a value of 11:
			public class IncrementNum {
			 public static void main(String[] args) {
				int ctr = 50;
				// INSERT CODE HERE
				System.out.println(ctr % 20);
			 }
			}
		', 'checkbox', 'A, C', '
			Explanation: To output a value of 11, the value of the variable ctr should be 51
			because 51%20 is 11. Operator % outputs the remainder from a division operation. The
			current value of the variable ctr is 50. It can be incremented by 1 using the correct
			assignment or increment operator.
			 Option (b) is incorrect. Java does not define a =+ operator. The correct operator
			is +=.
			 Option (d) is incorrect because it’s assigning a value of 1 to the variable result,
			not incrementing it by 1.
		', 2, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (584, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			int a = 10;
			int b = 20;
			int c = (a * (b + 2)) - 10-4 * ((2*2) - 6;
			System.out.println(c);
		', 'checkbox', 'D', '
			vuoto
		', 2, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (585, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is true about the following lines of code?
			
			boolean b = false;
			int i = 90;
			System.out.println(i >= b);
		', 'checkbox', 'D', '
			Explanation: The code will fail to compile; hence, it can’t execute. You can’t compare
			incomparable types, such as a boolean value with a number.
		', 2, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (586, 'OCA Java SE 8 Programmer I Certification Guide', '
			Examine the following code and select the correct options:
			public class Prim { 											// line 1
			 public static void main(String[] args) { 						// line 2
				int num1 = 12; 												// line 3
				float num2 = 17.8f; 										// line 4
				boolean eJavaResult = true; 								// line 5
				boolean returnVal = num1 >= 12 && nu<60; 4.567 			// line 6
									|| eJavaResult == true;
				System.out.println(returnVal); 								// line 7
			 } 																// line 8
			} 																// line 9
		', 'checkbox', 'B, C', '
			Explanation: Option (a) is incorrect because the code prints true.
			Option (d) is incorrect because the code prints false.
			The code in option (c) uses parentheses to indicate which expression should evaluate prior to the rest. Here are the steps of execution:
			
				boolean returnVal = (num1 >= 12 && num2 < 4.567) || eJavaResult == true;
				returnVal = false || eJavaResult == true;
				returnVal = true;
			
			The original code in the question doesn’t use parentheses to group the expressions.
			In this case, because the operator && has a higher operator precedence than ||, the
			expression ''num1 >= 12 && num2 < 4.567'' will be the first expression to execute. Here
			are the steps of execution:
			
				boolean returnVal = num1 >= 12 && num2 < 4.567 || eJavaResult == true;
				returnVal = false || eJavaResult == true;
				returnVal = true;
		', 2, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (587, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given:
			
			boolean myBool = false;                    // line 1
			int yourInt = 10;                          // line 2
			float hisFloat = 19.54f;                   // line 3
			System.out.println(hisFloat = yourInt);    // line 4
			System.out.println(yourInt > 10);          // line 5
			System.out.println(myBool = false);        // line 6
		', 'checkbox', 'B', '
			Explanation: The expression myBool = false uses the assignment operator (=) and
			not a comparison operator (==). This expression assigns the boolean literal false to
			myBool; it doesn’t compare false with myBool. Watch out for similar (trick) assignments in the exam, which may seem to be comparing values.
		', 2, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (588, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is output by the following code? (Choose all that apply)
			
			1: public class Fish {
			2: 	public static void main(String[] args) {
			3: 		int numFish = 4;
			4: 		String fishType = "tuna";
			5: 		String anotherFish = numFish + 1;
			6: 		System.out.println(anotherFish + " " + fishType);
			7: 		System.out.println(numFish + " " + 1);
			8: } }
		', null, 'G', ' 
			Line 5 does not compile. This question is checking to see if you are paying attention
			to the types. numFish is an int and 1 is an int. Therefore, we use numeric addition and
			get 5. The problem is that we can’t store an int in a String variable. Supposing line 5
			said String anotherFish = numFish + 1 + "";. In that case, the answer would be
			options A and D. The variable defined on line 5 would be the string "5", and both output statements would use concatenation.
		', 3, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (589, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are output by this code? (Choose all that apply)
			
			3: String s = "Hello";
			4: String t = new String(s);
			5: if ("Hello".equals(s)) System.out.println("one");
			6: if (t == s) System.out.println("two");
			7: if (t.equals(s)) System.out.println("three");
			8: if ("Hello" == s) System.out.println("four");
			9: if ("Hello" == t) System.out.println("five");
		', 'checkbox', 'A, C, D', ' 
			The code compiles fine. Line 3 points to the String in the string pool. Line 4
			calls the String constructor explicitly and is therefore a different object than s. Lines 5
			and 7 check for object equality, which is true, and so print one and three. Line 6 uses
			object reference equality, which is not true since we have different objects. Line 7 also
			compares references but is true since both references point to the object from the string
			pool. Finally, line 8 compares one object from the string pool with one that was explicitly constructed and returns false.
		', 3, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (590, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which are true statements? (Choose all that apply)
		', 'checkbox', 'B, C, E', ' 
			Immutable means the state of an object cannot change once it is created.
			Immutable objects can be garbage collected just like mutable objects.
			String is immutable. StringBuilder can be mutated with methods like append(). Although 
			StringBuffer isn’t on the exam, you should know about it anyway in case older questions haven’t been removed.
		', 3, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (591, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			7: StringBuilder sb = new StringBuilder();
			8: sb.append("aaa").insert(1, "bb").insert(4, "ccc");
			9: System.out.println(sb);
		', 'checkbox', 'B', ' 
			This example uses method chaining. After the call to append(), sb contains "aaa".
			That result is passed to the first insert() call, which inserts at index 1. At this point
			sb contains abbbaa. That result is passed to the final insert(), which inserts at index
			4, resulting in abbaccca.
		', 3, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (592, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			2: String s1 = "java";
			3: StringBuilder s2 = new StringBuilder("java");
			4: if (s1 == s2)
			5:	System.out.print("1");
			6: if (s1.equals(s2))
			7: 	System.out.print("2");
		', 'checkbox', 'F', ' 
			The question is trying to distract you into paying attention to logical equality versus
			object reference equality. It is hoping you will miss the fact that line 4 does not compile. 
			Java does not allow you to compare String and StringBuilder using ==.
		', 3, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (593, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			public class Lion {
				public void roar(String roar1, StringBuilder roar2) {
					roar1.concat("!!!");
					roar2.append("!!!");
			 }
			public static void main(String[] args) {
				String roar1 = "roar";
				StringBuilder roar2 = new StringBuilder("roar");
				new Lion().roar(roar1, roar2);
			 System.out.println(roar1 + " " + roar2);
			} }
		', 'checkbox', 'B', ' 
			TA String is immutable. Calling concat() returns a new String but does not change
			the original. A StringBuilder is mutable. Calling append() adds characters to the
			existing character sequence along with returning a reference to the same object. 
		', 3, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (594, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which are the results of the following code? (Choose all that apply)
			
			String letters = "abcdef";
			System.out.println(letters.length());
			System.out.println(letters.charAt(3));
			System.out.println(letters.charAt(6));
		', 'checkbox', 'B, D, E', ' 
			length() is simply a count of the number of characters in a String. In this
			case, there are six characters. charAt() returns the character at that index. Remember
			that indexes are zero based, which means that index 3 corresponds to d and index 6
			corresponds to 1 past the end of the array. A StringIndexOutOfBoundsException is
			thrown for the last line.
		', 3, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (595, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which are the results of the following code? (Choose all that apply)
			
			String numbers = "012345678";
			System.out.println(numbers.substring(1, 3));
			System.out.println(numbers.substring(7, 7));
			System.out.println(numbers.substring(7));
		', 'checkbox', 'A, D, E', ' 
			substring() has two forms. The first takes the index to start with and the
			index to stop immediately before. The second takes just the index to start with and
			goes to the end of the String. Remember that indexes are zero based. The first call
			starts at index 1 and ends with index 2 since it needs to stop before index 3. The second call starts at index 7 and ends in the same place, resulting in an empty String.
			This prints out a blank line. The final call starts at index 7 and goes to the end of the
			String.
		', 3, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (596, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			3: String s = "purr";
			4: s.toUpperCase();
			5: s.trim();
			6: s.substring(1, 3);
			7: s += " two";
			8: System.out.println(s.length());
		', 'checkbox', 'C', ' 
			This question is trying to see if you know that String objects are immutable. Line
			4 returns "PURR" but the result is ignored and not stored in s. Line 5 returns "purr"
			since there is no whitespace present but the result is again ignored. Line 6 returns "ur"
			because it starts with index 1 and ends before index 3 using zero-based indexes. The
			result is ignored again. Finally, on line 6 something happens. We concatenate four new
			characters to s and now have a String of length 8.
		', 3, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (597, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code? (Choose all that apply)
			
			13: String a = "";
			14: a += 2;
			15: a += ''c'';
			16: a += false;
			17: if ( a == "2cfalse") System.out.println("==");
			18: if ( a.equals("2cfalse")) System.out.println("equals");
		', 'checkbox', 'F', ' 
			a += 2 expands to a = a + 2. A String concatenated with any other type gives
			a String. Lines 14, 15, and 16 all append to a, giving a result of "2cfalse". The if
			statement on line 18 returns false because the values of the two String objects are the
			same using object equality. The if statement on line 17 returns false because the two
			String objects are not the same in memory. One comes directly from the string pool
			and the other comes from building using String operations.
		', 3, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (598, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			4: int total = 0;
			5: StringBuilder letters = new StringBuilder("abcdefg");
			6: total += letters.substring(1, 2).length();
			7: total += letters.substring(6, 6).length();
			8: total += letters.substring(6, 5).length();
			9: System.out.println(total);
		', 'checkbox', 'E', ' 
			Line 6 adds 1 to total because substring() includes the starting index but not
			the ending index. Line 7 adds 0 to total. Line 8 is a problem: Java does not allow the
			indexes to be specified in reverse order and the code throws a StringIndexOutOfBoundsException.
		', 3, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (599, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code? (Choose all that apply)
			
			StringBuilder numbers = new StringBuilder("0123456789");
			numbers.delete(2, 8);
			numbers.append("-").insert(2, "+");
			System.out.println(numbers);
		', 'checkbox', 'A', ' 
			First, we delete the characters at index 2 until the character one before index 8. At
			this point, 0189 is in numbers. The following line uses method chaining. It appends a
			dash to the end of the characters sequence, resulting in 0189–, and then inserts a plus
			sign at index 2, resulting in 01+89–.
		', 3, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (600, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			StringBuilder b = "rumble";
			b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
			System.out.println(b);
		', 'checkbox', 'F', ' 
			This is a trick question. The first line does not compile because you cannot
			assign a String to a StringBuilder. If that line were StringBuilder b = new
			StringBuilder("rumble"), the code would compile and print rum4. Watch out for this
			sort of trick on the exam. You could easily spend a minute working out the character
			positions for no reason at all.
		', 3, 13, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (601, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following can replace line 4 to print "avaJ"? (Choose all that apply)
			
			3: StringBuilder puzzle = new StringBuilder("Java");
			4: // INSERT CODE HERE
			5: System.out.println(puzzle);
		', 'checkbox', 'A, C', ' 
			The reverse() method is the easiest way of reversing the characters in a StringBuilder; therefore, option A is correct. Option B is a nice distraction—it does in fact
			return "avaJ". However, substring() returns a String, which is not stored anywhere.
			Option C uses method chaining. First it creates the value "JavavaJ$". Then it removes
			the first three characters, resulting in "avaJ$". Finally, it removes the last character,
			resulting in "avaJ". Option D throws an exception because you cannot delete the character after the last index. Remember that deleteCharAt() uses indexes that are zero
			based and length() counts starting with 1.
		', 3, 14, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (602, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of these array declarations is not legal? (Choose all that apply)
		', 'checkbox', 'C, E, F', ' 
			Option C uses the variable name as if it were a type, which is clearly illegal.
			Options E and F don’t specify any size. Although it is legal to leave out the size for later
			dimensions of a multidimensional array, the first one is required. Option A declares a
			legal 2D array. Option B declares a legal 3D array. Option D declares a legal 2D array.
			Remember that it is normal to see on the exam types you might not have learned. You
			aren’t expected to know anything about them
		', 3, 15, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (603, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of these compile when replacing line 8? (Choose all that apply)
			
			7: char[]c = new char[2];
			8: // INSERT CODE HERE
		', 'checkbox', 'C', ' 
			Arrays define a property called length. It is not a method, so parentheses are not allowed.
		', 3, 16, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (604, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of these compile when replacing line 8? (Choose all that apply)
			
			7: ArrayList l = new ArrayList();
			8: // INSERT CODE HERE
		', 'checkbox', 'F', ' 
			The ArrayList class defines a method called size().		
		', 3, 17, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (605, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'A, C, D, E', ' 
			An array is not able to change size and can have multiple dimensions. Both
			an array and ArrayList are ordered and have indexes. Neither is immutable. The elements can change in value.	
		', 3, 18, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (606, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply
		', 'checkbox', 'B, C', ' 
			An array does not override equals() and so uses object equality. ArrayList does
			override equals() and defines it as the same elements in the same order. The compiler
			does not know when an index is out of bounds and thus can’t give you a compiler
			error. The code will throw an exception at runtime, though.
		', 3, 19, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (607, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following statements?
			
			6: List<String> list = new ArrayList<String>();
			7: list.add("one");
			8: list.add("two");
			9: list.add(7);
			10:for(String s : list) System.out.print(s);
		', 'checkbox', 'D', ' 
			The code does not compile because list is instantiated using generics. Only String
			objects can be added to list and 7 is an int.
		', 3, 20, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (608, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following statements?
			
			3: ArrayList<Integer> values = new ArrayList<>();
			4: values.add(4);
			5: values.add(5);
			6: values.set(1, 6);
			7: values.remove(0);
			8: for (Integer v : values) System.out.print(v);
		', 'checkbox', 'C', ' 
			After line 4, values has one element (4). After line 5, values has two elements (4,5). 
			After line 6, values has two elements (4, 6) because set() does a replace. After line
			7, values has only one element (6).
		', 3, 21, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (609, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following?
			
			int[] random = { 6, -4, 12, 0, -10 };
			int x = 12;
			int y = Arrays.binarySearch(random, x);
			System.out.println(y);
		', 'checkbox', 'D', ' 
			The code compiles and runs fine. However, an array must be sorted for binarySearch() to return a meaningful result.
		', 3, 22, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (610, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following?
			
			4: List<Integer> list = Arrays.asList(10, 4, -1, 5);
			5: Collections.sort(list);
			6: Integer array[] = list.toArray(new Integer[4]);
			7: System.out.println(array[0]);
		', 'checkbox', 'A', ' 
			Line 4 creates a fixed size array of size 4. Line 5 sorts it. Line 6 converts it back to
			an array. The brackets aren’t in the traditional place, but they are still legal. Line 7
			prints the first element, which is now –1.		
		', 3, 23, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (611, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following?
			
			6: String [] names = {"Tom", "Dick", "Harry"};
			7: List<String> list = names.asList();
			8: list.set(0, "Sue");
			9: System.out.println(names[0]);
		', 'checkbox', 'C', ' 
			Converting from an array to an ArrayList uses Arrays.asList(names). There is
			no asList() method on an array instance. If this code were corrected to compile, the
			answer would be option A		
		', 3, 24, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (612, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following?
			
			List<String> hex = Arrays.asList("30", "8", "3A", "FF");
			Collections.sort(hex);
			int x = Collections.binarySearch(hex, "8");
			int y = Collections.binarySearch(hex, "3A");
			int z = Collections.binarySearch(hex, "4F");
			System.out.println(x + " " + y + " " + z);		
		', 'checkbox', 'D', ' 
			After sorting, hex contains [30, 3A, 8, FF]. Remember that numbers sort before
			letters and strings sort alphabetically. This makes 30 come before 8. A binary search
			correctly finds 8 at index 2 and 3A at index 1. It cannot find 4F but notices it should
			be at index 2. The rule when an item isn’t found is to negate that index and subtract 1.
			Therefore, we get –2–1, which is –3.		
		', 3, 25, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (613, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true statements about the following code? (Choose all that apply)
			
			4: List<Integer> ages = new ArrayList<>();
			5: ages.add(Integer.parseInt("5"));
			6: ages.add(Integer.valueOf("6"));
			7: ages.add(7);
			8: ages.add(null);
			9: for (int age : ages) System.out.print(age);
		', 'checkbox', 'A, B, D', ' 
			Lines 5 and 7 use autoboxing to convert an int to an Integer. Line 6 does
			not because valueOf() returns an Integer. Line 8 does not because null is not an int.
			The code does not compile. However, when the for loop tries to unbox null into an
			int, it fails and throws a NullPointerException.		
		', 3, 26, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (614, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following?
			
			List<String> one = new ArrayList<String>();
			one.add("abc");
			List<String> two = new ArrayList<>();
			two.add("abc");
			if (one == two)
			 System.out.println("A");
			else if (one.equals(two))
			 System.out.println("B");
			else
			 System.out.println("C");
		', 'checkbox', 'B', ' 
			The first if statement is false because the variables do not point to the same object.
			The second if statement is true because ArrayList implements equality to mean the
			same elements in the same order.		
		', 3, 27, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (615, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following can be inserted into the blank to create a date of June 21, 2014? (Choose all that apply)
			
			import java.time.*;
			
			public class StartOfSummer {
				public static void main(String[] args) {
				LocalDate date = ____________________________
				}
			}
		', 'checkbox', 'D, F', ' 
			Options A and B are incorrect because LocalDate does not have a public constructor. Option C is incorrect because months start counting with 1 rather than 0.
			Option E is incorrect because it uses the old pre–Java 8 way of counting months, again
			beginning with 0. Options D and F are both correct ways of specifying the desired
			date.		
		', 3, 28, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (616, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			LocalDate date = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_
			DATE);
			date.plusDays(2);
			date.plusHours(3);
			System.out.println(date.getYear() + " " + date.getMonth() + " "
			+ date.getDayOfMonth());
		', 'checkbox', 'D', ' 
			A LocalDate does not have a time element. Therefore, it has no method to add
			hours and the code does not compile.		
		', 3, 29, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (617, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
			System.out.println(date.getYear() + " " + date.getMonth() + " "
			+ date.getDayOfMonth());
		', 'checkbox', 'F', ' 
			Java throws an exception if invalid date values are passed. There is no 40th day in
			April—or any other month for that matter.		
		', 3, 30, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (618, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
			date.plusDays(2);
			date.plusYears(3);
			System.out.println(date.getYear() + " " + date.getMonth() + " "
			+ date.getDayOfMonth());
		', 'checkbox', 'B', ' 
			 The date starts out as April 30, 2018. Since dates are immutable and the plus methods have their return values ignored, the result is unchanged. Therefore, option B is correct.	
		', 3, 31, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (619, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
			Period p = Period.of(1, 2, 3);
			d = d.minus(p);
			DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
			System.out.println(d.format(f));
		', 'checkbox', 'E', ' 
			Even though d has both date and time, the formatter only outputs time.		
		', 3, 32, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (620, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
			Period p = Period.ofDays(1).ofYears(2);
			d = d.minus(p);
			DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle
			.SHORT);
			System.out.println(f.format(d));
		', 'checkbox', 'B', ' 
			Period does not allow chaining. Only the last Period method called counts, so only
			the two years are subtracted.
		', 3, 33, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (621, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which option defines a well-encapsulated class?
		', null, 'D', '
			Explanation: Options (a), (b), and (c) are incorrect because they all define a public
			instance variable. A well-encapsulated class should be like a capsule, hiding its instance
			variables from the outside world. The only way you should access and modify instance
			variables is through the public methods of a class to ensure that the outside world
			can access only the variables the class allows it to. By defining methods to assign values to its instance variables, a class can control the range of values that can be assigned
			to them. 
		', 3, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (622, 'OCA Java SE 8 Programmer I Certification Guide', '
			Examine the following code and select the correct option(s):
			
			public class Person {
			 public int height;
			 public void setHeight(int newHeight) {
				if (newHeight <= 300)
					height = newHeight;
			 }
			}
		', 'checkbox', 'D', '
			Explanation: This class isn’t well encapsulated because its instance variable height is
			defined as a public member. Because the instance variable can be directly accessed
			by other classes, the variable doesn’t always use the method setHeight to set its
			height. The class Person can’t control the values that can be assigned to its public
			variable height. 
		', 3, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (623, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following methods correctly accepts three integers as method
			arguments and returns their sum as a floating-point number?
		', 'checkbox', 'B, D', '
			Explanation: Option (a) is incorrect. The question specifies the method should return a
			decimal number (type double or float), but this method doesn’t return any value.
			 Option (b) is correct. This method accepts three integer values that can be automatically converted to an integer: byte, int, and int. It computes the sum of these
			integer values and returns it as a decimal number (data type double). Note that the
			name of the method is subtractNumbers, which doesn’t make it an invalid option.
			Practically, you wouldn’t name a method subtractNumbers if it’s adding them. But
			syntactically and technically, this option meets the question’s requirements and is a
			correct option.
			 Option (c) is incorrect. This method doesn’t accept integers as the method arguments. The type of the method argument arg3 is double, which isn’t an integer.
			 Option (d) is correct. Even though the name of the method seems weird, it
			accepts the correct argument list (all integers) and returns the result in the correct
			data type (float).
		', 3, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (624, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following statements are true?
		', 'checkbox', 'A, B, C, D', '
			Explanation: Option (e) is incorrect. There’s no constraint on the number of arguments that can be passed to a method, regardless of whether the method returns a value.
			Option (f) is incorrect. You can’t return the value null for methods that return
			primitive data types. You can return null for methods that return objects (String is a
			class and not a primitive data type).
		', 3, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (625, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following definition of class Person,

			class Person {
			 public String name;
			 public int height;
			}
			what is the output of the following code?
			class EJavaGuruPassObjects1 {
			 public static void main(String args[]) {
			 Person p = new Person();
			 p.name = "EJava";
			WOW! eBook
			www.wowebook.org
			Answers to sample exam questions 215
			 anotherMethod(p);
			 System.out.println(p.name);
			 someMethod(p);
			 System.out.println(p.name);
			 }
			 static void someMethod(Person p) {
			 p.name = "someMethod";
			 System.out.println(p.name);
			 }
			 static void anotherMethod(Person p) {
			 p = new Person();
			 p.name = "anotherMethod";
			 System.out.println(p.name);
			 }
			}
		', 'checkbox', 'B', '
			Explanation: The class EJavaGuruPassObject1 defines two methods, someMethod and
			anotherMethod. The method someMethod modifies the value of the object parameter
			passed to it. Hence, the changes are visible within this method and in the calling
			method (method main). But the method anotherMethod reassigns the reference variable passed to it. Changes to any of the values of this object are limited to this method.
			They aren’t reflected in the calling method (the main method). 
		', 3, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (626, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class EJavaGuruPassPrim {
			 public static void main(String args[]) {
				 int ejg = 10;
				 anotherMethod(ejg);
				 System.out.println(ejg);
				 someMethod(ejg);
				 System.out.println(ejg);
			 }
			 static void someMethod(int val) {
				++val;
				System.out.println(val);
			 }
			 static void anotherMethod(int val) {
				val = 20;
				System.out.println(val);
			 }
			}
		', 'checkbox', 'C', '
			Explanation: When primitive data types are passed to a method, the values of the variables in the calling method remain the same. This behavior doesn’t depend on
			whether the primitive values are reassigned other values or modified by addition, subtraction, or multiplication—or any other operation.
		', 3, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (627, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following signature of method eJava, choose the options that correctly overload this method:
			
				public String eJava(int age, String name, double duration)
		', 'checkbox', 'C, D, E, F, G', '
			Explanation: Option (a) is incorrect. Overloaded methods can change the access modifiers, but changing the access modifier alone won’t make it an overloaded method. This
			option also changes the names of the method parameters, but that doesn’t make any
			difference to a method signature.
			 Option (b) is incorrect. Overloaded methods can change the return type of the
			method, but changing the return type won’t make it an overloaded method.
			 Option (c) is correct. Changing the placement of the types of the method parameters overloads it.
			 Option (d) is correct. Changing the return type of a method and the placement of
			the types of the method parameters overloads it.
			 Option (e) is correct. Changing the return type of a method and making a change
			in the parameter list overloads it.
			 Option (f) is correct. Changing the return type of a method and making a change
			in the parameter list overloads it.
			 Option (g) is correct. Changing the parameter list also overloads a method.
		', 3, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (628, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following code,

			class Course {
			 void enroll(long duration) {
				System.out.println("long");
			 }
			 void enroll(int duration) {
				System.out.println("int");
			 }
			 void enroll(String s) {
				System.out.println("String");
			 }
			 void enroll(Object o) {
				System.out.println("Object");
			 }
			}
			
			what is the output of the following code?
			
			class EJavaGuru {
			 public static void main(String args[]) {
				 Course course = new Course();
				 char c = 10;
				 course.enroll(c);
				 course.enroll("Object");
			 }
			}
		', 'checkbox', 'C', '
			Explanation: No compilation issues exist with the code. You can overload methods by
			changing the type of the method arguments in the list. Using method arguments with
			data types having a base-derived class relationship (Object and String classes) is
			acceptable. Using method arguments with data types for which one can be automatically converted to the other (int and long) is also acceptable.
			 When the code executes course.enroll(c), char can be passed to two overloaded
			enroll methods that accept int and long. The char gets expanded to its nearest
			type—int—so course.enroll(c) calls the overloaded method that accepts int, printing int. The code course.enroll("Object") is passed a String value. Although
			String is also an Object, this method calls the specific (not general) type of the argument passed to it. So course.enroll("Object") calls the overloaded method that
			accepts String, printing String.
		', 3, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (629, 'OCA Java SE 8 Programmer I Certification Guide', '
			Examine the following code and select the correct options:
			
			class EJava {
			 public EJava() {
				 this(7);
				 System.out.println("public");
			 }
			 private EJava(int val) {
				 this("Sunday");
				 System.out.println("private");
			 }
			 protected EJava(String val) {
				System.out.println("protected");
			 }
			}
			class TestEJava {
			 public static void main(String[] args) {
				EJava eJava = new EJava();
			 }
			}
		', 'checkbox', 'A, D', '
			Explanation: You can define overloaded constructors with different access modifiers
			in the same way that you define overloaded methods with different access modifiers.
			But a change in only the access modifier can’t be used to define overloaded methods
			or constructors. private methods and constructors are also counted as overloaded
			methods.
			The following line of code calls EJava’s constructor, which doesn’t accept any
			method argument:
			
				EJava eJava = new EJava();
			
			The no-argument constructor of this class calls the constructor that accepts an int
			argument, which in turn calls the constructor with the String argument. Because the
			constructor with the String constructor doesn’t call any other methods, it prints
			protected and returns control to the constructor that accepts an int argument.
			This constructor prints private and returns control to the constructor that doesn’t
			accept any method argument. This constructor prints public and returns control to
			the main method.
		', 3, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (630, 'OCA Java SE 8 Programmer I Certification Guide', '
			Select the incorrect options:
		', 'checkbox', 'A, C', '
			Explanation: Option (a) is incorrect. If a user defines a constructor for a class with
			any access modifier, it’s no longer an eligible candidate to be provided with a default
			constructor.
			 Option (b) is correct. A class gets a default constructor only when it doesn’t have any
			constructor. A default or an automatic constructor can’t exist with other constructors.
			 Option (c) is incorrect. A default constructor can’t coexist with other constructors.
			A default constructor is automatically created by the Java compiler if the user doesn’t
			define any constructor in a class. If the user reopens the source code file and adds a
			constructor to the class, upon recompilation no default constructor will be created for
			the class.
			 Option (d) is correct. Because this class doesn’t have a constructor, Java will create
			a default constructor for it.
			 Option (e) is also correct. This class also doesn’t have a constructor, so it’s eligible
			for the creation of a default constructor. The following isn’t a constructor because the
			return type of a constructor isn’t void:
			
				void EJava() {}
			
			It’s a regular and valid method, with the same name as its class.
		', 3, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (631, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following can fill in the blank in this code to make it compile? (Choose all that apply)
			
			public class Ant {
			 _____ void method() { }
			}
		', null, 'B, C', ' 
			void is a return type. Only the access modifier or optional specifiers are allowed
			before the return type. Option C is correct, creating a method with private access.
			Option B is correct, creating a method with default access and the optional specifier
			final. Since default access does not require a modifier, we get to jump right to final. 
			Option A is incorrect because default access omits the access modifier rather than specifying default. Option D is incorrect because Java is case sensitive. It would have been
			correct if public were the choice. Option E is incorrect because the method already has
			a void return type. Option F is incorrect because labels are not allowed for methods.
		', 4, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (632, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following compile? (Choose all that apply)
		', 'checkbox', 'A, D', ' 
			Options A and D are correct because the optional specifiers are allowed in any
			order. Options B and C are incorrect because they each have two return types. Options
			E and F are incorrect because the return type is before the optional specifier and access
			modifier, respectively
		', 4, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (633, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following methods compile? (Choose all that apply)
		', 'checkbox', 'A, C, D', ' 
			Options A and C are correct because a void method is allowed to have a
			return statement as long as it doesn’t try to return a value. Options B and G do not
			compile because null requires a reference object as the return type. void is not a reference object since it is a marker for no return type. int is not a reference object since it
			is a primitive. Option D is correct because it returns an int value. Option E does not
			compile because it tries to return a double when the return type is int. Since a double
			cannot be assigned to an int, it cannot be returned as one either. Option F does not
			compile because no value is actually returned.
		', 4, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (634, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following compile? (Choose all that apply)
		', 'checkbox', 'A, B, G', ' 
			Options A and B are correct because the single vararg parameter is the last
			parameter declared. Option G is correct because it doesn’t use any vararg parameters
			at all. Options C and F are incorrect because the vararg parameter is not last. Option
			D is incorrect because two vararg parameters are not allowed in the same method.
			Option E is incorrect because the ... for a vararg must be after the type, not before it.
		', 4, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (635, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following method, which of the method calls return 2? (Choose all that apply)
			
			public int howMany(boolean b, boolean... b2) {
				return b2.length;
			}
		', 'checkbox', 'D, G', ' 
			Option D passes the initial parameter plus two more to turn into a vararg array
			of size 2. Option G passes the initial parameter plus an array of size 2. Option A does
			not compile because it does not pass the initial parameter. Options E and F do not
			compile because they do not declare an array properly. It should be new boolean[]
			{true}. Option B creates a vararg array of size 0 and option C creates a vararg array of
			size 1.
		', 4, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (636, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'D', ' 
			Option D is correct. This is the common implementation for encapsulation by setting all fields to be private and all methods to be public. Option A is incorrect because
			protected access allows everything that package private access allows and additionally
			allows subclasses access. Option B is incorrect because the class is public. This means
			that other classes can see the class. However, they cannot call any of the methods or
			read any of the fields. It is essentially a useless class. Option C is incorrect because
			package private access applies to the whole package. Option E is incorrect because Java
			has no such capability.
		', 4, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (637, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Given the following my.school.ClassRoom and my.city.School class definitions, which line numbers in main() generate a compiler error? (Choose all that apply)
			
			1: package my.school;
			
			2: public class Classroom {
			3: 	private int roomNumber;
			4: 	protected String teacherName;
			5: 	static int globalKey = 54321;
			6: 	public int floor = 3;
			7: 	Classroom(int r, String t) {
			8: 		roomNumber = r;
			9: 		teacherName = t; } }
			
			1: package my.city;
			2: import my.school.*;
			3: public class School {
			4: 	public static void main(String[] args) {
			5: 		System.out.println(Classroom.globalKey);
			6: 		Classroom room = new Classroom(101, ""Mrs. Anderson");
			7: 		System.out.println(room.roomNumber);
			8: 		System.out.println(room.floor);
			9: 		System.out.println(room.teacherName); } }
		', 'checkbox', 'B, C, D, F', ' 
			The two classes are in different packages, which means private access and
			default (package private) access will not compile. Additionally, protected access will
			not compile since School does not inherit from Classroom. Therefore, only line 8 will
			compile because it uses public access.
		', 4, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (638, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'B, C, E', ' 
			Encapsulation requires using methods to get and set instance variables so
			other classes are not directly using them. Instance variables must be private for this
			to work. Immutability takes this a step further, allowing only getters, so the instance
			variables do not change state.
		', 4, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (639, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which are methods using JavaBeans naming conventions for accessors and mutators? (Choose all that apply)
		', 'checkbox', 'C, E', ' 
			Option A is incorrect because the property is of type boolean and getters must
			begin with is for booleans. Options B and D are incorrect because they don’t follow
			the naming convention of beginning with get/is/set. Options C and E follow normal
			getter and setter conventions.
		', 4, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (640, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: package rope;
			2: public class Rope {
			3: 	public static int LENGTH = 5;
			4: 	static {
			5: 		LENGTH = 10;
			6: 	}
			7: 	public static void swing() {
			8: 		System.out.print("swing ");
			9: 	}
			10:}
			
			1: import rope.*;
			2: import static rope.Rope.*;
			3: public class Chimp {
			4: 	public static void main(String[] args) {
			5: 		Rope.swing();
			6: 		new Rope().swing();
			7: 		System.out.println(LENGTH);
			8: 	}
			9: }
		', 'checkbox', 'B', ' 
			Rope runs line 3, setting LENGTH to 5, then immediately after runs the static initializer, which sets it to 10. Line 5 calls the static method normally and prints swing.
			Line 6 also calls the static method. Java allows calling a static method through an
			instance variable. Line 7 uses the static import on line 2 to reference LENGTH.
		', 4, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (641, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which are true of the following code? (Choose all that apply)
			
			1: public class Rope {
			2: 	public static void swing() {
			3: 		System.out.print("swing ");
			4: 	}
			5: 	public void climb() {
			6: 		System.out.println("climb ");
			7: 	}
			8: 	public static void play() {
			9: 		swing();
			10: 	climb();
			11: }
			12: public static void main(String[] args) {
			13: 	Rope rope = new Rope();
			14: 	rope.play();
			15: 	Rope rope2 = null;
			16: 	rope2.play();
			17: }
			18:}
		', 'checkbox', 'B, E', ' 
			Line 10 does not compile because static methods are not allowed to call instance
			methods. Even though we are calling play() as if it were an instance method and an
			instance exists, Java knows play() is really a static method and treats it as such. If line
			10 is removed, the code works. It does not throw a NullPointerException on line 16
			because play() is a static method. Java looks at the type of the reference for rope2 and
			translates the call to Rope.play().
		', 4, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (642, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			import rope.*;
			import static rope.Rope.*;
			public class RopeSwing {
			 private static Rope rope1 = new Rope();
			 private static Rope rope2 = new Rope();
			 {
				System.out.println(rope1.length);
			 }
			 public static void main(String[] args) {
				rope1.length = 2;
				rope2.length = 8;
				System.out.println(rope1.length);
			 }
			}
			package rope;
			public class Rope {
			 public static int length = 0;
			}
		', 'checkbox', 'D', ' 
			There are two details to notice in this code. First, note that RopeSwing has an
			instance initializer and not a static initializer. Since RopeSwing is never constructed,
			the instance initializer does not run. The other detail is that length is static. Changes
			from one object update this common static variable.
		', 4, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (643, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			How many compiler errors are in the following code?

			1: public class RopeSwing {
			2: 	private static final String leftRope;
			3: 	private static final String rightRope;
			4: 	private static final String bench;
			5: 	private static final String name = "name";
			6: 	static {
			7: 		leftRope = "left";
			8: 		rightRope = "right";
			9: 	}
			10: static {
			11: 	name = "name";
			12: 	rightRope = "right";
			13: }
			14: public static void main(String[] args) {
			15: 	bench = "bench";
			16: }
			17:}
		', 'checkbox', 'E', ' 
			static final variables must be set exactly once, and it must be in the declaration
			line or in a static initialization block. Line 4 doesn’t compile because bench is not set
			in either of these locations. Line 15 doesn’t compile because final variables are not
			allowed to be set after that point. Line 11 doesn’t compile because name is set twice:
			once in the declaration and again in the static block. Line 12 doesn’t compile because
			rightRope is set twice as well. Both are in static initialization blocks.
		', 4, 13, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (644, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following can replace line 2 to make this code compile? (Choose all that apply)
			
			1: import java.util.*;
			2: // INSERT CODE HERE
			3: public class Imports {
			4: 	public void method(ArrayList<String> list) {
			5: 		sort(list);
			6: 	}
			7: }
		', 'checkbox', 'B', ' 
			The two valid ways to do this are import static java.util.Collections.*; and
			import static java.util.Collections.sort;. Option A is incorrect because you
			can only do a static import on static members. Classes such as Collections require
			a regular import. Option C is nonsense as method parameters have no business in
			an import. Options D, E, and F try to trick you into reversing the syntax of import
			static.
		', 4, 14, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (645, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following statements?
			
			1: public class Test {
			2: 	public void print(byte x) {
			3: 		System.out.print("byte");
			4: 	}
			5: 	public void print(int x) {
			6: 		System.out.print("int");
			7: 	}
			8: 	public void print(float x) {
			9: 		System.out.print("float");
			10: }
			11: public void print(Object x) {
			12: 	System.out.print("Object");
			13: }
			14: public static void main(String[] args) {
			15: 	Test t = new Test();
			16: 	short s = 123;
			17: 	t.print(s);
			18: 	t.print(true);
			19: 	t.print(6.789);
			20: }
			21:}
		', 'checkbox', 'E', ' 
			The argument on line 17 is a short. It can be promoted to an int, so print() on
			line 5 is invoked. The argument on line 18 is a boolean. It can be autoboxed to a boolean, so print() on line 11 is invoked. The argument on line 19 is a double. It can
			be autoboxed to a double, so print() on line 11 is invoked. Therefore, the output is
			intObjectObject and the correct answer is option E. 
		', 4, 15, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (646, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following program?
			
			1: public class Squares {
			2: 	public static long square(int x) {
			3: 		long y = x * (long) x;
			4: 		x = -1;
			5: 		return y;
			6: 	}
			7: 	public static void main(String[] args) {
			8: 		int value = 9;
			9: 		long result = square(value);
			10: 	System.out.println(value);
			11: } }
		', 'checkbox', 'B', ' 
			Since Java is pass-by-value and the variable on line 8 never gets reassigned, it stays
			as 9. In the method square, x starts as 9. y becomes 81 and then x gets set to –1. Line 9
			does set result to 81. However, we are printing out value and that is still 9. 
		', 4, 16, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (647, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are output by the following code? (Choose all that apply)
			
			public class StringBuilders {
			 public static StringBuilder work(StringBuilder a,StringBuilder b) {
				a = new StringBuilder("a");
				b.append("b");
				return a;
			 }
			 public static void main(String[] args) {
				StringBuilder s1 = new StringBuilder("s1");
				StringBuilder s2 = new StringBuilder("s2");
				StringBuilder s3 = work(s1, s2);
				System.out.println("s1 = " + s1);
				System.out.println("s2 = " + s2);
				System.out.println("s3 = " + s3);
			 }
			}
		', 'checkbox', 'B, D, E', ' 
			Since Java is pass-by-reference, assigning a new object to a does not change the
			caller. Calling append() does affect the caller because both the method parameter and 
			caller have a reference to the same object. Finally, returning a value does pass the reference to the caller for assignment to s3.
		', 4, 17, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (648, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose 2)
		', 'checkbox', 'C, G', ' 
			Since the main() method is in the same class, it can call private methods in the
			class. this() may only be called as the first line of a constructor. this.variableName
			can be called from any instance method to refer to an instance variable. It cannot be
			called from a static method because there is no instance of the class to refer to. Option
			F is tricky. The default constructor is only written by the compiler if no user-defined
			constructors were provided. this() can only be called from a constructor in the same
			class. Since there can be no user-defined constructors in the class if a default constructor was created, it is impossible for option F to be true. 
		', 4, 18, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (649, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of these classes compile and use a default constructor? (Choose all that apply)
		', 'checkbox', 'A, G', ' 
			Options B and C don’t compile because the constructor name must match the
			classname. Since Java is case sensitive, these don’t match. Options D, E, and F all compile and provide one user-defined constructor. 
			Since a constructor is coded, a default constructor isn’t supplied. 
			Option G defines a method, but not a constructor. Option A does not define a constructor, either. 
			Since no constructor is coded, a default constructor is provided for options A and G.
		', 4, 19, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (650, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which code can be inserted to have the code print 2?
			
			public class BirdSeed {
			 private int numberBags;
			 boolean call;
			 
			 public BirdSeed() {
				// LINE 1
				call = false;
				// LINE 2
			 }
			 public BirdSeed(int numberBags) {
				this.numberBags = numberBags;
			 }
			 public static void main(String[] args) {
				BirdSeed seed = new BirdSeed();
				System.out.println(seed.numberBags);
			 } }
		', 'checkbox', 'E', ' 
			Options A and B will not compile because constructors cannot be called without
			new. Options C and D will compile but will create a new object rather than setting the
			fields in this one. Option F will not compile because this() must be the first line of a
			constructor. Option E is correct.
		', 4, 20, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (651, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following complete the constructor so that this code prints out 50? (Choose all that apply)
			
			public class Cheetah {
			 int numSpots;
			 public Cheetah(int numSpots) {
				// INSERT CODE HERE
			 }
			 public static void main(String[] args) {
				System.out.println(new Cheetah(50).numSpots);
			 }
			}
		', 'checkbox', 'C', ' 
			Within the constructor numSpots refers to the constructor parameter. The instance
			variable is hidden because they have the same name. this.numSpots tells Java to use
			the instance variable. In the main() method, numSpots refers to the instance variable.
			Option A sets the constructor parameter to itself, leaving the instance variable as 0.
			Option B sets the constructor parameter to the value of the instance variable, making
			them both 0. Option C is correct, setting the instance variable to the value of the constructor parameter. Options D and E do not compile.
		', 4, 21, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (652, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following?

			1: public class Order {
			2: 	static String result = "";
			3: 	{ result += "c"; }
			4: 	static
			5: 	{ result += "u"; }
			6: 	{ result += "r"; }
			7: }
			1: public class OrderDriver {
			2: 	public static void main(String[] args) {
			3: 		System.out.print(Order.result + " ");
			4: 		System.out.print(Order.result + " ");
			5: 		new Order();
			6: 		new Order();
			7: 		System.out.print(Order.result + " ");
			8: 	}
			9: }
		', 'checkbox', 'E', ' 
			On line 3 of OrderDriver, we refer to Order for the first time. At this point the statics in Order get initialized. In this case, the statics are the static declaration of result
			and the static initializer. result is u at this point. On line 4, result is the same
			because the static initialization is only run once. On line 5, we create a new Order,
			which triggers the instance initializers in the order they appear in the file. Now result
			is ucr. Line 6 creates another Order, triggering another set of initializers. Now result
			is ucrcr. Notice how the static is on a different line than the initialization code in
			lines 4–5 of Order. The exam may try to trick you by formatting the code like this to
			confuse you.
		', 4, 22, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (653, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following?
			
			1: public class Order {
			2: 	String value = "t";
			3: 	{ value += "a"; }
			4: 	{ value += "c"; }
			5: 	public Order() {
			6: 		value += "b";
			7: 	}
			8: 	public Order(String s) {
			9: 		value += s;
			10: }
			11: public static void main(String[] args) {
			12: 	Order order = new Order("f");
			13: 	order = new Order();
			14: 	System.out.println(order.value);
			15: } }
		', 'checkbox', 'A', ' 
			Line 4 instantiates an Order. Java runs the declarations and instance initializers first
			in the order they appear. This sets value to tacf. Line 5 creates another Order and
			initializes value to tacb. The object on line 5 is stored in the same variable line 4 used.
			This makes the object created on line 4 unreachable. When value is printed, it is the
			instance variable in the object created on line 5.
		', 4, 23, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (654, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following will compile when inserted in the following code? (Choose all that apply)
			
			public class Order3 {
			 final String value1 = "1";
			 static String value2 = "2";
			 String value3 = "3";
			 {
				// CODE SNIPPET 1
			 }
			 static {
				// CODE SNIPPET 2
			 }
			}
		', 'checkbox', 'B, C, E', ' 
			value1 is a final instance variable. It can only be set once: in the variable declaration, an instance initializer, or a constructor. Option A does not compile because
			the final variable was already set in the declaration. value2 is a static variable. Both
			instance and static initializers are able to access static variables, making options B
			and E correct. value3 is an instance variable. Options D and F do not compile because
			a static initializer does not have access to instance variables.
		', 4, 24, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (655, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true about the following code? (Choose all that apply)
			
			public class Create {
			 Create() {
				System.out.print("1 ");
			 }
			 Create(int num) {
				System.out.print("2 ");
			 }
			 Create(Integer num) {
				System.out.print("3 ");
			 }
			 Create(Object num) {
				System.out.print("4 ");
			 }
			 Create(int... nums) {
				System.out.print("5 ");
			 }
			 public static void main(String[] args) {
				new Create(100);
				new Create(1000L);
			 }
			}
		', 'checkbox', 'A, E', ' 
			The 100 parameter is an int and so calls the matching int constructor. When
			this constructor is removed, Java looks for the next most specific constructor. Java prefers autoboxing to varargs, and so chooses the Integer constructor. The 100L parameter is a long. Since it can’t be converted into a smaller type, it is autoboxed into a Long
			and then the constructor for Object is called. 
		', 4, 25, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (656, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following class?
			
			1: import java.util.function.*;
			2:
			3: public class Panda {
			4: 	int age;
			5: 	public static void main(String[] args) {
			6: 		Panda p1 = new Panda();
			7: 		p1.age = 1;
			8: 		check(p1, p -> p.age < 5);
			9: 	}
			10: private static void check(Panda panda, Predicate<Panda> pred) {
			11: 	String result = pred.test(panda) ? "match" : "not match";
			12: 	System.out.print(result);
			13: } }
		', 'checkbox', 'A', ' 
			This code is correct. Line 8 creates a lambda expression that checks if the age is less
			than 5. Since there is only one parameter and it does not specify a type, the parentheses
			around the type parameter are optional. Line 10 uses the Predicate interface, which
			declares a test() method.
		', 4, 26, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (657, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			1: interface Climb {
			2:	 boolean isTooHigh(int height, int limit);
			3: }
			4:
			5: public class Climber {
			6: 	public static void main(String[] args) {
			7: 	check((h, l) -> h.append(l).isEmpty(), 5);
			8: }
			9: private static void check(Climb climb, int height) {
			10: if (climb.isTooHigh(height, 10))
			11: 	System.out.println("too high");
			12: else
			13: 	System.out.println("ok");
			14: }
			15:}
		', 'checkbox', 'C', ' 
			The interface takes two int parameters. The code on line 7 attempts to use them as
			if one is a StringBuilder. It is tricky to use types in a lambda when they are implicitly
			specified. Remember to check the interface for the real type.
		', 4, 27, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (658, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following lambda expressions can fill in the blank? (Choose all that apply)
			
			List<String> list = new ArrayList<>();
			list.removeIf(___________________);
		', 'checkbox', 'A, D, F', ' 
			removeIf() expects a Predicate, which takes a parameter list of one parameter using the specified type. Options B and C are incorrect because they do not use the
			return keyword. It is required inside braces for lambda bodies. Option E is incorrect
			because it is missing the parentheses around the parameter list. This is only optional
			for a single parameter with an inferred type.
		', 4, 28, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (659, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which lambda can replace the MySecret class to return the same value? (Choose all that apply)
			
			interface Secret {
			 String magic(double d);
			}
			class MySecret implements Secret {
			 public String magic(double d) {
				return "Poof";
			 }
			}
		', 'checkbox', 'A, F', ' 
			Option B is incorrect because it does not use the return keyword. Options C, D,
			and E are incorrect because the variable e is already in use from the lambda and cannot be redefined. Additionally, option C is missing the return keyword and option E is
			missing the semicolon.
		', 4, 29, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (660, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
		
			class EJavaGuruArray {
			 public static void main(String args[]) {
				 int[] arr = new int[5];
				 byte b = 4; char c = ''c''; long longVar = 10;
				 arr[0] = b;
				 arr[1] = c;
				 arr[3] = longVar;
				 System.out.println(arr[0] + arr[1] + arr[2] + arr[3]);
			 }
			}
		', null, 'E', '
			Explanation: The code in this question won’t compile due to
			
				arr[3] = longVar;
				
			The preceding line of code tries to assign a value of type long to a variable of type int.
			Because Java doesn’t support implicit narrowing conversions (for example, long to
			int in this case), the assignment fails. Also, this code tries to trick you regarding your
			understanding of the following:
				■ Assigning a char value to an int array element (arr[1] = c)
				■ Adding a byte value to an int array element (arr[0] = b)
				■ Whether an unassigned int array element is assigned a default value (arr[2])
				■ Whether arr[0] + arr[1] + arr[2] + arr[3] prints the sum of all these values
					or a concatenated value
			When answering questions in the OCA Java SE 8 Java Programmer I exam, be careful
			about such tactics. If any of the answers lists a compilation error or a runtime exception as an option, look for obvious lines of code that could result in it. In this example,
			arr[3] = longVar will result in a compilation error.
		', 4, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (661, 'OCA Java SE 8 Programmer I Certification Guide', '
			class EJavaGuruArray2 {
			 public static void main(String args[]) {
				 int[] arr1;
				 int[] arr2 = new int[3];
				 char[] arr3 = {''a'', ''b''};
				 arr1 = arr2;
				 arr1 = arr3;
				 System.out.println(arr1[0] + ":" + arr1[1]);
			 }
			}
		', 'checkbox', 'E', '
			Explanation: Because a char value can be assigned to an int value, you might assume
			that a char array can be assigned to an int array. But we’re talking about arrays of int
			and char primitives, which aren’t the same as a primitive int or char. 
			Arrays themselves are reference variables, which refer to a collection of objects of similar type.
		', 4, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (662, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following are valid lines of code to define a multidimensional int array?
		', 'checkbox', 'A, D', '
			Explanation: Option (b) is incorrect. This line of code won’t compile because new
			array() isn’t valid code. Unlike objects of other classes, an array isn’t initialized using
			the keyword new followed by the word array. When the keyword new is used to initialize an array, it’s followed by the type of the array, not the word array.
			Option (c) is incorrect. To initialize a two-dimensional array, all of these values must
			be enclosed within another pair of curly braces, as shown in the code in option (a).
		', 4, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (663, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following statements are correct?
		', 'checkbox', 'D, E', '
			Explanation: Option (a) is incorrect. The default type of a non-floating numeric literal value is int. You can’t add an int to an ArrayList of type Long. You can pass values of type Long or long to its add method.
			Option (b) is incorrect. Starting with Java 7, switch also accepts variables of type
			String. Because a String can be stored in an ArrayList, you can use elements of an
			ArrayList in a switch construct.
			Option (c) is incorrect. Only clear() will remove all elements of an ArrayList.
			Option (d) is correct. An ArrayList internally uses an array to store all its elements.
			Whenever you add an element to an ArrayList, it checks whether the array can
			accommodate the new value. If it can’t, ArrayList creates a larger array, copies all the
			existing values to the new array, and then adds the new value at the end of the array. If
			you frequently add elements to an ArrayList, it makes sense to create an ArrayList
			with a bigger capacity because the previous process isn’t repeated for each ArrayList insertion.
			Option (e) is correct. Calling clone() on an ArrayList will create a separate reference variable that stores the same number of elements as the ArrayList to be cloned.
			But each individual ArrayList element will refer to the same object; that is, the individual ArrayList elements aren’t cloned.
		', 4, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (664, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following statements are correct?
		', 'checkbox', 'A, B, C, E', '
			Explanation: Option (a) is correct. A developer may prefer using an ArrayList over
			an array because it offers all the benefits of an array and a list. For example, you can
			easily add or remove elements from an ArrayList.
			 Option (b) is correct.
			 Option (c) is correct. An ArrayList can be easily searched, sorted, and have its values compared using the methods provided by the Collection framework classes.
			 Option (d) is incorrect. An array requires you to specify the total number of elements before you can add any element to it. But you don’t need to specify the total
			number of elements that you may add to an ArrayList at any time in your code.
			 Option (e) is correct.
		', 4, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (665, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			import java.util.*; 												// line 1
			class EJavaGuruArrayList { 											// line 2
			 public static void main(String args[]) { 							// line 3
				 ArrayList<String> ejg = new ArrayList<>(); 		// line 4
				 ejg.add("One"); 												// line 5
				 ejg.add("Two"); 												// line 6
				 System.out.println(ejg.contains(new String("One"))); 			// line 7
				 System.out.println(ejg.indexOf("Two")); 						// line 8
				 ejg.clear(); 													// line 9
				 System.out.println(ejg); 										// line 10
				 System.out.println(ejg.get(1)); 								// line 11
			 } 																	// line 12
			} 
		', 'checkbox', 'A, D, E, H, J', '
			Explanation: Line 7: The method contains accepts an object and compares it with
			the values stored in the list. It returns true if the method finds a match and false otherwise. This method uses the equals method defined by the object stored in the list.
			In the example, the ArrayList stores objects of class String, which has overridden
			the equals method. The equals method of the String class compares the values
			stored by it. This is why line 7 returns the value true.
			 Line 8: indexOf returns the index position of an element if a match is found; otherwise, it returns -1. This method also uses the equals method behind the scenes to
			compare the values in an ArrayList. Because the equals method in the class String
			compares its values and not the reference variables, the indexOf method finds a
			match in position 1.
			 Line 9: The clear method removes all the individual elements of an ArrayList
			such that an attempt to access any of the earlier ArrayList elements will throw a runtime exception. It doesn’t set the ArrayList reference variable to null.
			 Line 10: ArrayList has overridden the toString method such that it returns a list
			of all its elements enclosed within square brackets. To print each element, the
			toString method is called to retrieve its String representation.
			 Line 11: The clear method removes all the elements of an ArrayList. An attempt
			to access the (nonexistent) ArrayList element throws a runtime IndexOutOfBoundsException exception.
			 This question tests your understanding of ArrayList and determining the equality
			of String objects.
		', 4, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (666, 'OCA Java SE 8 Programmer I Certification Guide', '
			 What is the output of the following code?
			 
			class EJavaGuruString {
			 public static void main(String args[]) {
				 String ejg1 = new String("E Java");
				 String ejg2 = new String("E Java");
				 String ejg3 = "E Java";
				 String ejg4 = "E Java";
				 do
					System.out.println(ejg1.equals(ejg2));
				 while (ejg3 == ejg4);
			 }
			}
		', 'checkbox', 'C', '
			Explanation: String objects that are created without using the new operator are placed
			in a pool of Strings. Hence, the String object referred to by the variable ejg3 is
			placed in a pool of Strings. The variable ejg4 is also defined without using the new
			operator. Before Java creates another String object in the String pool for the variable ejg4, it looks for a String object with the same value in the pool. Because this value
			already exists in the pool, it makes the variable ejg4 refer to the same String object.
			This, in turn, makes the variables ejg3 and ejg4 refer to the same String objects.
			Hence, both of the following comparisons will return true:
				■ ejg3 == ejg4 (compare the object references)
				■ ejg3.equals(ejg4) (compare the object values)
			Even though the variables ejg1 and ejg2 refer to different String objects, they define
			the same values. So ejg1.equals(ejg2) also returns true. Because the loop condition
			(ejg3==ejg4) always returns true, the code prints true in an infinite loop.
		', 4, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (667, 'OCA Java SE 8 Programmer I Certification Guide', '
			 What is the output of the following code?
			 
			class EJavaGuruString2 {
			 public static void main(String args[]) {
				 String ejg = "game".replace(''a'', ''Z'').trim().concat("Aa");
				 ejg.substring(0, 2);
				 System.out.println(ejg);
			 }
			}
		', 'checkbox', 'B', '
			Explanation: When chained, methods are evaluated from left to right. The first method
			to execute is replace, not concat. Strings are immutable. Calling the method substring on the reference variable ejg doesn’t change the contents of the variable ejg.
			It returns a String object that isn’t referred to by any other variable in the code. In
			fact, none of the methods defined in the String class modify the object’s own value.
			They all create and return new String objects.
		', 4, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (668, 'OCA Java SE 8 Programmer I Certification Guide', '
			 What is the output of the following code?
			 
			class EJavaGuruString2 {
			 public static void main(String args[]) {
				 String ejg = "game";
				 ejg.replace(''a'', ''Z'').trim().concat("Aa");
				 ejg.substring(0, 2);
				 System.out.println(ejg);
			 }
			}
		', 'checkbox', 'E', '
			Explanation: String objects are immutable. It doesn’t matter how many methods you
			execute on a String object; its value won’t change. Variable ejg is initialized with the
			String value "game". This value won’t change, and the code prints game.
		', 4, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (669, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class EJavaGuruStringBuilder {
			 public static void main(String args[]) {
				 StringBuilder ejg = new StringBuilder(10 + 2 + "SUN" + 4 + 5);
				 ejg.append(ejg.delete(3, 6));
				 System.out.println(ejg);
			 }
			}
		', 'checkbox', 'A', '
			Explanation: This question tests your understanding of operators, String, and
			StringBuilder. The following line of code returns 12SUN45:
			
				10 + 2 + "SUN" + 4 + 5
				
			The + operator adds two numbers but concatenates the last two numbers. When
			the + operator encounters a String object, it treats all the remaining operands as
			String objects.
			Unlike the String objects, StringBuilder objects are mutable. The append and
			delete methods defined in this class change its value. ejg.delete(3, 6) modifies the
			existing value of the StringBuilder to 12S5. It then appends the same value to itself
			when calling ejg.append(), resulting in the value 12S512S5.
		', 4, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (670, 'OCA Java SE 8 Programmer I Certification Guide', '
			 What is the output of the following code?
			 
			class EJavaGuruStringBuilder2 {
			 public static void main(String args[]) {
				 StringBuilder sb1 = new StringBuilder("123456");
				 sb1.subSequence(2, 4);
				 sb1.deleteCharAt(3);
				 sb1.reverse();
				 System.out.println(sb1);
			 }
			}
		', 'checkbox', 'C', '
			Explanation: Like the method substring, the method subSequence doesn’t modify
			the contents of a StringBuilder. Hence, the value of the variable sb1 remains
			123456, even after the execution of the following line of code:
			
				sb1.subSequence(2, 4);
			
			The method deleteCharAt deletes a char value at position 3. Because the positions
			are zero-based, the digit 4 is deleted from the value 123456, resulting in 12356. The
			method reverse modifies the value of a StringBuilder by assigning to it the reverse
			representation of its value. The reverse of 12356 is 65321.
		', 4, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (671, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			String printDate = LocalDate.parse("2057-08-11")
								.format(DateTimeFormatter.ISO_DATE_TIME);
			System.out.println(printDate);
		', 'checkbox', 'E', '
			Explanation: The example code in this question calls LocalDate.parse(), passing it a
			string value but no DateTimeFormatter instance. In this case, the text 2057-08-11 is
			parsed using DateTimeFormatter.ISO_LOCAL_DATE. LocalDate.parse() returns a
			LocalDate instance.
			 The example code then calls the format method on a LocalDate instance, using
			DateTimeFormatter.ISO_DATE_TIME. The code compiles successfully because the
			format method accepts a DateTimeFormatter instance. But format() throws an exception at runtime because it tries to format a LocalDate instance using a formatter
			(ISO_DATE_TIME) that defines rules for a date/time object. When no matching time
			values are found in a LocalDate object, an exception is thrown.
		', 4, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (672, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What modifiers are implicitly applied to all interface methods? (Choose all that apply)
		', null, 'B', ' 
			All interface methods are implicitly public, so option B is correct and option A is
			not. Interface methods may be declared as static or default but are never implicitly
			added, so options C and F are incorrect. Option D is incorrect—void is not a modifier;
			it is a return type. Option E is a tricky one, because prior to Java 8 all interface methods would be assumed to be abstract. Since Java 8 now includes default and static
			methods and they are never abstract, you cannot assume the abstract modifier will be
			implicitly applied to all methods by the compiler.
		', 5, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (673, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: class Mammal {
			2:	 public Mammal(int age) {
			3: 		System.out.print("Mammal");
			4: 	}
			5: }
			6: public class Platypus extends Mammal {
			7:	 public Platypus() {
			8: 		System.out.print("Platypus");
			9:  }
			10: public static void main(String[] args) {
			11: 	new Mammal(5);
			12: }
			13:}
		', 'checkbox', 'E', ' 
			The code will not compile because the parent class Mammal doesn’t define a no-argument constructor, so the first line of a Platypus constructor should be an explicit call
			to super(int age). If there was such a call, then the output would be MammalPlatypus,
			since the super constructor is executed before the child constructor.
		', 5, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (674, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following statements can be inserted in the blank line so that the code will compile successfully? (Choose all that apply)
			
			public interface CanHop {}
			public class Frog implements CanHop {
				public static void main(String[] args) {
				__________	frog = new TurtleFrog();
				}
			}
			public class BrazilianHornedFrog extends Frog {}
			public class TurtleFrog extends Frog {}
		', 'checkbox', 'A, B, D, E', ' 
			The blank can be filled with any class or interface that is a supertype of
			TurtleFrog. Option A is a superclass of TurtleFrog, and option B is the same class,
			so both are correct. BrazilianHornedFrog is not a superclass of TurtleFrog, so option
			C is incorrect. TurtleFrog inherits the CanHope interface, so option D is correct. All
			classes inherit Object, so option E is correct. Finally, Long is an unrelated class that is
			not a superclass of TurtleFrog, and is therefore incorrect.
		', 5, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (675, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which statement(s) are correct about the following code? (Choose all that apply)
			
			public class Rodent {
				protected static Integer chew() throws Exception {
					System.out.println("Rodent is chewing");
					return 1;
				}
			}
			public class Beaver extends Rodent {
				public Number chew() throws RuntimeException {
					System.out.println("Beaver is chewing on wood");
					return 2;
				}
			}
		', 'checkbox', 'C, E', ' 
			The code doesn’t compile, so option A is incorrect. Option B is also not correct
			because the rules for overriding a method allow a subclass to define a method with an
			exception that is a subclass of the exception in the parent method. Option C is correct because the return types are not covariant; in particular, Number is not a subclass
			of Integer. Option D is incorrect because the subclass defines a method that is more
			accessible than the method in the parent class, which is allowed. Finally, option E is
			correct because the method is declared as static in the parent class and not so in the
			child class. For nonprivate methods in the parent class, both methods must use static
			(hide) or neither should use static (override).
		', 5, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (676, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following may only be hidden and not overridden? (Choose all that apply)
		', 'checkbox', 'A, D, E, F', ' 
			First off, options B and C are incorrect because protected and public methods may be overridden, not hidden. Option A is correct because private methods are
			always hidden in a subclass. Option D is also correct because static methods cannot
			be overridden, only hidden. Options E and F are correct because variables may only be
			hidden, regardless of the access modifier.
		', 5, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (677, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Choose the correct statement about the following code:
			
			1: interface HasExoskeleton {
			2: 	abstract int getNumberOfSections();
			3: }
			4: abstract class Insect implements HasExoskeleton {
			5: 	abstract int getNumberOfLegs();
			6: }
			7: public class Beetle extends Insect {
			8: 	int getNumberOfLegs() { return 6; }
			9: }
		', 'checkbox', 'D', ' 
			The code fails to compile because Beetle, the first concrete subclass, doesn’t implement getNumberOfSections(), which is inherited as an abstract method; therefore,
			option D is correct. Option B is incorrect because there is nothing wrong with this
			interface method definition. Option C is incorrect because an abstract class is not
			required to implement any abstract methods, including those inherited from an interface. Option E is incorrect because the code fails at compilation-time.
		', 5, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (678, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following statements about polymorphism are true? (Choose all that apply)
		', 'checkbox', 'B, C', ' 
			A reference to an object requires an explicit cast if referenced with a subclass,
			so option A is incorrect. If the cast is to a superclass reference, then an explicit cast is
			not required. Because of polymorphic parameters, if a method takes the superclass of
			an object as a parameter, then any subclass references may be used without a cast, so
			option B is correct. All objects extend java.lang.Object, so if a method takes that
			type, any valid object, including null, may be passed; therefore, option C is correct.
			Some cast exceptions can be detected as errors at compile-time, but others can only be
			detected at runtime, so D is incorrect. Due to the nature of polymorphism, a public
			instance method can be overridden in a subclass and calls to it will be replaced even in
			the superclass it was defined, so E is incorrect.
		', 5, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (679, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Choose the correct statement about the following code:
			
			1: public interface Herbivore {
			2: 	int amount = 10;
			3: 	public static void eatGrass();
			4: 	public int chew() {
			5: 		return 13;
			6: 	}
			7: }
		', 'checkbox', 'F', ' 
			The interface variable amount is correctly declared, with public and static being
			assumed and automatically inserted by the compiler, so option B is incorrect. The
			method declaration for eatGrass() on line 3 is incorrect because the method has been
			marked as static but no method body has been provided. The method declaration for
			chew() on line 4 is also incorrect, since an interface method that provides a body must
			be marked as default or static explicitly. Therefore, option F is the correct answer
			since this code contains two compile-time errors.
		', 5, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (680, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			 Choose the correct statement about the following code:
			 
			1: public interface CanFly {
			2: 	void fly();
			3: }
			4: interface HasWings {
			5: 	public abstract Object getWindSpan();
			6: }
			7: abstract class Falcon implements CanFly, HasWings {
			8: }
		', 'checkbox', 'A', ' 
			Although the definition of methods on lines 2 and 5 vary, both will be converted to
			public abstract by the compiler. Line 4 is fine, because an interface can have public or default access. Finally, the class Falcon doesn’t need to implement the interface
			methods because it is marked as abstract. Therefore, the code will compile without
			issue.
		', 5, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (681, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which statements are true for both abstract classes and interfaces? (Choose all that apply)
		', 'checkbox', 'B, C, E, F', ' 
			Option A is wrong, because an abstract class may contain concrete methods. Since Java 8, interfaces may also contain concrete methods in form of static or
			default methods. Although all variables in interfaces are assumed to be public static
			final, abstract classes may contain them as well, so option B is correct. Both abstract
			classes and interfaces can be extended with the extends keyword, so option C is correct. Only interfaces can contain default methods, so option D is incorrect. Both
			abstract classes and interfaces can contain static methods, so option E is correct. Both
			structures require a concrete subclass to be instantiated, so option F is correct. Finally,
			though an instance of an object that implements an interface inherits java.lang.
			Object, the interface itself doesn’t; otherwise, Java would support multiple inheritance
			for objects, which it doesn’t. Therefore, option G is incorrect.
		', 5, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (682, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What modifiers are assumed for all interface variables? (Choose all that apply)
		', 'checkbox', 'A, D, E', ' 
			Interface variables are assumed to be public static final; therefore, options
			A, D, and E are correct. Options B and C are incorrect because interface variables must
			be public—interfaces are implemented by classes, not inherited by interfaces. Option F
			is incorrect because variables can never be abstract.
		', 5, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (683, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: interface Nocturnal {
			2: 	default boolean isBlind() { return true; }
			3: }
			4: public class Owl implements Nocturnal {
			5: 	public boolean isBlind() { return false; }
			6:	public static void main(String[] args) {
			7: 	Nocturnal nocturnal = (Nocturnal)new Owl();
			8: 	System.out.println(nocturnal.isBlind());
			9: }
			10: }
		', 'checkbox', 'B', ' 
			This code compiles and runs without issue, outputting false, so option B is the
			correct answer. The first declaration of isBlind() is as a default interface method,
			assumed public. The second declaration of isBlind() correctly overrides the default
			interface method. Finally, the newly created Owl instance may be automatically cast to
			a Nocturnal reference without an explicit cast, although adding it doesn’t break the
			code.
		', 5, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (684, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: class Arthropod
			2: 	public void printName(double input) { System.out.print("Arthropod"); }
			3: }
			4: public class Spider extends Arthropod {
			5: 	public void printName(int input) { System.out.print("Spider"); }
			6: 	public static void main(String[] args) {
			7: 		Spider spider = new Spider();
			8: 		spider.printName(4);
			9: 		spider.printName(9.0);
			10: }
			11:}
		', 'checkbox', 'A', ' 
			The code compiles and runs without issue, so options E and F are incorrect. The
			printName() method is an overload in Spider, not an override, so both methods may
			be called. The call on line 8 references the version that takes an int as input defined
			in the Spider class, and the call on line 9 references the version in the Arthropod class
			that takes a double. Therefore, SpiderArthropod is output and option A is the correct
			answer.
		', 5, 13, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (685, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which statements are true about the following code? (Choose all that apply)
			
			1: interface HasVocalCords {
			2: 	public abstract void makeSound();
			3: }
			4: public interface CanBark extends HasVocalCords {
			5: 	public void bark();
			6: }
		', 'checkbox', 'C', ' 
			The code compiles without issue, so option A is wrong. Option B is incorrect, since
			an abstract class could implement HasVocalCords without the need to override the
			makeSound() method. Option C is correct; any class that implements CanBark automatically inherits its methods, as well as any inherited methods defined in the parent
			interface. Because option C is correct, it follows that option D is incorrect. Finally, an
			interface can extend multiple interfaces, so option E is incorrect.
		', 5, 14, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (686, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following is true about a concrete subclass? (Choose all that apply)
		', 'checkbox', 'B', ' 
			Concrete classes are, by definition, not abstract, so option A is incorrect. A concrete
			class must implement all inherited abstract methods, so option B is correct. Option C
			is incorrect; a superclass may have already implemented an inherited interface, so the
			concrete subclass would not need to implement the method. Concrete classes can be
			both final and not final, so option D is incorrect. Finally, abstract methods must be
			overridden by a concrete subclass, so option E is incorrect.
		', 5, 15, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (687, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: abstract class Reptile {
			2: 	public final void layEggs() { System.out.println("Reptile laying eggs");
			   }
			3: 		public static void main(String[] args) {
			4: 		Reptile reptile = new Lizard();
			5: 		reptile.layEggs();
			6: 		}
			7: }
			8: public class Lizard extends Reptile {
			9: 	public void layEggs() { System.out.println("Lizard laying eggs"); }
			10:}

		', 'checkbox', 'E', ' 
			The code doesn’t compile, so options A and B are incorrect. The issue with line 9 is
			that layEggs() is marked as final in the superclass Reptile, which means it cannot be
			overridden. There are no errors on any other lines, so options C and D are incorrect.
		', 5, 16, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (688, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: public abstract class Whale {
			2: 	public abstract void dive() {};
			3: 	public static void main(String[] args) {
			4: 		Whale whale = new Orca();
			5: 		whale.dive();
			6: }
			7:}
			8: class Orca extends Whale {
			9: 	public void dive(int depth) { System.out.println("Orca diving"); }
			10:}
		', 'checkbox', 'B', ' 
			This may look like a complex question, but it is actually quite easy. Line 2 contains
			an invalid definition of an abstract method. Abstract methods cannot contain a body,
			so the code will not compile and option B is the correct answer. If the body {} was
			removed from line 2, the code would still not compile, although it would be line 8 that
			would throw the compilation error. Since dive() in Whale is abstract and Orca extends
			Whale, then it must implement an overridden version of dive(). The method on line
			9 is an overloaded version of dive(), not an overridden version, so Orca is an invalid
			subclass and will not compile.
		', 5, 17, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (689, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code? (Choose all that apply)
			
			1: interface Aquatic {
			2: 	public default int getNumberOfGills(int input) { return 2; }
			3: }
			4: public class ClownFish implements Aquatic {
			5: 	public String getNumberOfGills() { return "4"; }
			6: 	public String getNumberOfGills(int input) { return "6"; }
			7: 	public static void main(String[] args) {
			8: 		System.out.println(new ClownFish().getNumberOfGills(-1));
			9: 	}
			10:}
		', 'checkbox', 'E', ' 
			The code doesn’t compile because line 6 contains an incompatible override of the
			getNumberOfGills(int input) method defined in the Aquatic interface. In particular,
			int and String are not covariant returns types, since int is not a subclass of String.
			Note that line 5 compiles without issue; getNumberOfGills() is an overloaded method
			that is not related to the parent interface method that takes an int value.
		', 5, 18, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (690, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following statements can be inserted in the blank so that the code will compile successfully? (Choose all that apply)
			
			public class Snake {}
			public class Cobra extends Snake {}
			public class GardenSnake {}
			public class SnakeHandler {
			 private Snake snake;
			 public void setSnake(Snake snake) { this.snake = snake; }
			 public static void main(String[] args) {
				new SnakeHandler().setSnake( );
			 }
			}
		', 'checkbox', 'A, C, F', ' 
			First off, Cobra is a subclass of Snake, so option A can be used. GardenSnake is
			not defined as a subclass of Snake, so it cannot be used and option B is incorrect. The
			class Snake is not marked as abstract, so it can be instantiated and passed, so option
			C is correct. Next, Object is a superclass of Snake, not a subclass, so it also cannot be
			used and option D is incorrect. The class String is unrelated in this example, so option
			E is incorrect. Finally, a null value can always be passed as an object value, regardless
			of type, so option F is correct.
		', 5, 19, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (691, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			1: public abstract class Bird {
			2: 	private void fly() { System.out.println("Bird is flying"); }
			3: 	public static void main(String[] args) {
			4: 		Bird bird = new Pelican();
			5: 		bird.fly();
			6: 	}
			7: }
			8: class Pelican extends Bird {
			9: 	protected void fly() { System.out.println("Pelican is flying"); }
			10:}
		', 'checkbox', 'A', ' 
			The code compiles and runs without issue, so options C, D, and E are incorrect.
			The trick here is that the method fly() is marked as private in the parent class Bird,
			which means it may only be hidden, not overridden. With hidden methods, the specific
			method used depends on where it is referenced. Since it is referenced within the Bird
			class, the method declared on line 2 was used, and option A is correct. Alternatively,
			if the method was referenced within the Pelican class, or if the method in the parent
			class was marked as protected and overridden in the subclass, then the method on line
			9 would have been used.
		', 5, 20, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (692, 'OCA Java SE 8 Programmer I Certification Guide', '
			What’s the output of the following code?
			 
			class Loop2 {
			 public static void main(String[] args) {
				 int i = 10;
				 do
					 while (i < 15)
						i = i + 20;
				 while (i < 2);
				 System.out.println(i);
			 }
			}
		', null, 'B', '
			Explanation: The condition specified in the do-while loop evaluates to false (because
			10<2 evaluates to false). But the control enters the do-while loop because the do-while
			loop executes at least once—its condition is checked at the end of the loop. The while
			loop evaluates to true for the first iteration and adds 20 to i, making it 30. The while loop
			doesn’t execute for the second time. Hence, the value of the variable i at the end of the
			execution of the previous code is 30.
		', 5, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (693, 'OCA Java SE 8 Programmer I Certification Guide', '
			What’s the output of the following code?
			
			class Loop2 {
			 public static void main(String[] args) {
				 int i = 10;
				 do
					 while (i++ < 15)
						i = i + 20;
				 while (i < 2);
				 System.out.println(i);
			 }
			}
		', 'checkbox', 'D', '
			Explanation: If you attempted to answer question 5-1, it’s likely that you would select
			the same answer for this question. I deliberately used the same question text and
			variable names (with a small difference) because you may encounter a similar pattern
			in the OCA Java SE 8 Programmer I exam. This question includes one difference:
			unlike question 5-1, it uses a postfix unary operator in the while condition.
			 The condition specified in the do-while loop evaluates to false (because 10<2
			evaluates to false). But the control enters the do-while loop because the do-while
			loop executes at least once—its condition is checked at the end of the loop. This question prints out 32, not 30, because the condition specified in the while loop (which
			has an increment operator) executes twice.
			 In this question, the while loop condition executes twice. For the first evaluation,
			i++ < 15 (that is, 10<15) returns true and increments the value of variable i by 1 (due
			to the postfix increment operator). The loop body modifies the value of i to 31. The
			second condition evaluates i++<15 (that is, 31<15) to false. But because of the postfix increment operator value of i, the value increments to 32. The final value is
			printed as 32.
		', 5, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (694, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following statements is true?
		', 'checkbox', 'C', '
			Explanation: The enhanced for loop can be used within all types of looping and conditional constructs. Notice the use of “can” and “can’t” in the answer options. It’s
			important to take note of these subtle differences. 
		', 5, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (695, 'OCA Java SE 8 Programmer I Certification Guide', '
			What’s the output of the following code?
			
			int a = 10;
			if (a++ > 10) {
				System.out.println("true");
			}
			{
				System.out.println("false");
			}
			System.out.println("ABC");
		', 'checkbox', 'B', '
			Explanation: First of all, the code has no compilation errors. This question has a
			trick—the following code snippet isn’t part of the if construct:
			
				{
				 System.out.println("false");
				}
			
			Hence, the value false will print no matter what, regardless of whether the condition
			in the if construct evaluates to true or false.
			Because the opening and closing braces for this code snippet are placed right after
			the if construct, it leads you to believe that this code snippet is the else part of the if
			construct. Also, note that an if construct uses the keyword else to define the else
			part. This keyword is missing in this question.
			The if condition (that is, a++ > 10) evaluates to false because the postfix increment operator (a++) increments the value of the variable a immediately after its earlier value is used. 10 isn’t greater than 10, so this condition evaluates to false. 
		', 5, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (696, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following code, which of the optional lines of code can individually
			replace the //INSERT CODE HERE line so that the code compiles successfully?
			
			class EJavaGuru {
				public static void main(String args[]) {
					int num = 10;
					final int num2 = 20;
					switch (num) {
						// INSERT CODE HERE
						break;
						default: System.out.println("default");
					}
				}
			}
		', 'checkbox', 'A, C, D', '
			Explanation: Option (a) is correct. Compile-time constants, including expressions, are
			permissible in the case labels.
			Option (b) is incorrect. The case labels should be compile-time constants. A nonfinal variable isn’t a compile-time constant because it can be reassigned a value during
			the course of a class’s execution. Although the previous class doesn’t assign a value to
			it, the compiler still treats it as a changeable variable.
			Option (c) is correct. The value specified in the case labels should be assignable to
			the variable used in the switch construct. You may think that 10/3 will return a decimal number, which can’t be assigned to the variable num, but this operation discards
			the decimal part and compares 3 with the variable num.
			Option (d) is correct. The variable num2 is defined as a final variable and assigned
			a value on the same line of code, with its declaration. Hence, it’s considered to be a
			compile-time constant. 
		', 5, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (697, 'OCA Java SE 8 Programmer I Certification Guide', '
			class EJavaGuru {
				public static void main(String args[]) {
					int num = 20;
					final int num2;
					num2 = 20;
					switch (num) {
						default: System.out.println("default");
						case num2: System.out.println(4);
						break;
					}
				}
			}
		', 'checkbox', 'D', '
			Explanation: The code will fail to compile. The case labels require compile-time constant values, and the variable num2 doesn’t qualify as such. Although the variable num2
			is defined as a final variable, it isn’t assigned a value with its declaration. The code
			assigns a literal value 20 to this variable after its declaration, but it isn’t considered to
			be a compile-time constant by the Java compiler.
		', 5, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (698, 'OCA Java SE 8 Programmer I Certification Guide', '
			class EJavaGuru {
				public static void main(String args[]) {
					int num = 120;
					switch (num) {
						default: System.out.println("default");
						case 0: System.out.println("case1");
						case 10*2-20: System.out.println("case2");
						break;
					}
				}
			}
		', 'checkbox', 'D', '
			Explanation: The expressions used for both case labels—0 and 10*2-20—evaluate to
			the constant value 0. Because you can’t define duplicate case labels for the switch
			statement, the code will fail to compile with an error message that states that the code
			defines a duplicate case label.
		', 5, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (699, 'OCA Java SE 8 Programmer I Certification Guide', '
			class EJavaGuru3 {
				public static void main(String args[]) {
					byte foo = 120;
					switch (foo) {
						default: System.out.println("ejavaguru"); break;
						case 2: System.out.println("e"); break;
						case 120: System.out.println("ejava");
						case 121: System.out.println("enum");
						case 127: System.out.println("guru"); break;
					}
				}
			}
		', 'checkbox', 'A', '
			Explanation: For a switch case construct, control enters the case labels when a
			matching case is found. The control then falls through the remaining case labels
			until it’s terminated by a break statement. The control exits the switch construct
			when it encounters a break statement or it reaches the end of the switch construct.
			In this example, a matching label is found for case label 120. The control executes
			the statement for this case label and prints ejava to the console. Because a break
			statement doesn’t terminate the case label, the control falls through to case label 121.
			The control executes the statement for this case label and prints enum to the console.
			Because a break statement doesn’t terminate this case label also, the control falls
			through to case label 127. The control executes the statement for this case label and
			prints guru to the console. This case label is terminated by a break statement, so the
			control exits the switch construct. 
		', 5, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (700, 'OCA Java SE 8 Programmer I Certification Guide', '
			What’s the output of the following code?
			
			class EJavaGuru4 {
				public static void main(String args[]) {
					boolean myVal = false;
					if (myVal=true)
					for (int i = 0; i < 2; i++) System.out.println(i);
					else System.out.println("else");
				}
			}
		', 'checkbox', 'C', '
			Explanation: First of all, the expression used in the if construct isn’t comparing the
			value of the variable myVal with the literal value true—it’s assigning the literal value
			true to it. The assignment operator (=) assigns the literal value. The comparison
			operator (==) is used to compare values. Because the resulting value is a boolean
			value, the compiler doesn’t complain about the assignment in the if construct.
			 The code is deliberately poorly indented because you may encounter similarly
			poor indentation in the OCA Java SE 8 Programmer I exam. The for loop is part of
			the if construct, which prints 0 and 1. The else part doesn’t execute because the if
			condition evaluates to true. The code has no compilation errors.
		', 5, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (701, 'OCA Java SE 8 Programmer I Certification Guide', '
			What’s the output of the following code?
			
			class EJavaGuru5 {
				public static void main(String args[]) {
					int i = 0;
					for (; i < 2; i=i+5) {
						if (i < 5) continue;
						System.out.println(i);
					}
					System.out.println(i);
				}
			}
		', 'checkbox', 'F', '
			Explanation: First, the following line of code has no compilation errors:
			for (; i < 2; i=i+5) {
			Using the initialization block is optional in a for loop. In this case, using a semicolon
			(;) terminates it.
			 For the first for iteration, the variable i has a value of 0. Because this value is less
			than 2, the following if construct evaluates to true and the continue statement
			executes:
			if (i < 5) continue;
			Because the continue statement ignores all the remaining statements in a for loop
			iteration, the control doesn’t print the value of the variable i, which leads the control
			to move on to the next for iteration. In the next for iteration, the value of the variable i is 5. The for loop condition evaluates to false and the control moves out of
			the for loop. After the for loop, the code prints out the value of the variable i, which
			increments once using the code i=i+5
		', 5, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (702, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following statements are true? (Choose all that apply)
		', null, 'B', ' 
			Runtime exceptions are also known as unchecked exceptions. They are allowed
			to be declared, but they don’t have to be. Checked exceptions must be handled or
			declared. Legally, you can handle java.lang.Error subclasses, but it’s not a good idea.
		', 6, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (703, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following pairs fill in the blanks to make this code compile? (Choose all that apply)
			
			7: public void ohNo() _____ Exception {
			8: _____________ Exception();
			9: }
		', 'checkbox', 'B, D', ' 
			In a method declaration, the keyword throws is used. To actually throw an
			exception, the keyword throw is used and a new exception is created.
		', 6, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (704, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			When are you required to use a finally block in a regular try statement (not a try-with-resources)?
		', 'checkbox', 'C', ' 
			A try statement is required to have a catch clause and/or finally clause. If it goes
			the catch route, it is allowed to have multiple catch clauses.
		', 6, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (705, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which exception will the following throw?
			
			Object obj = new Integer(3);
			String str = (String) obj;
			System.out.println(str);
		', 'checkbox', 'B', ' 
			The second line tries to cast an Integer to a String. Since String does not extend
			Integer, this is not allowed and a ClassCastException is thrown.
		', 6, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (706, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following exceptions are thrown by the JVM? (Choose all that apply)
		', 'checkbox', 'A, B, D', ' 
			java.io.IOException is thrown by many methods in the java.io package,
			but it is always thrown programmatically. The same is true for NumberFormatException; it is thrown programmatically by the wrapper classes of java.lang. The other
			three exceptions are all thrown by the JVM when the corresponding problem arises.
		', 6, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (707, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What will happen if you add the statement System.out.println(5 / 0); to a working main() method?
		', 'checkbox', 'C', ' 
			The compiler tests the operation for a valid type but not a valid result, so the code
			will still compile and run. At runtime, evaluation of the parameter takes place before
			passing it to the print() method, so an ArithmeticException object is raised.
		', 6, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (708, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is printed besides the stack trace caused by the NullPointerException from line 16?
			
			1: public class DoSomething {
			2: 	public void go() {
			3: 		System.out.print("A");
			4: 		try {
			5: 			stop();
			6: 		} catch (ArithmeticException e) {
			7: 			System.out.print("B");
			8: 		} finally {
			9: 			System.out.print("C");
			10: 	}
			11: 	System.out.print("D");
			12: }
			13: public void stop() {
			14: 	System.out.print("E");
			15: 	Object x = null;
			16: 	x.toString();
			17: 	System.out.print("F");
			18: }
			19: public static void main(String[] args) {
			20: 	new DoSomething().go();
			21: }
			22:}
		', 'checkbox', 'C', ' 
			The main() method invokes go and A is printed on line 3. The stop method is
			invoked and E is printed on line 14. Line 16 throws a NullPointerException, so stop
			immediately ends and line 17 doesn’t execute. The exception isn’t caught in go, so the
			go method ends as well, but not before its finally block executes and C is printed on
			line 9. Because main() doesn’t catch the exception, the stack trace displays and no further output occurs, so AEC was the output printed before the stack trace. 
		', 6, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (709, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following snippet, assuming a and b are both 0?
			
			3: try {
			4: 	return a / b;
			5: } catch (RuntimeException e) {
			6: 	return -1;
			7: } catch (ArithmeticException e) {
			8: 	return 0;
			9: } finally {
			10: System.out.print("done");
			11: } 
		', 'checkbox', 'E', ' 
			The order of catch blocks is important because they’re checked in the order they
			appear after the try block. Because ArithmeticException is a child class of RuntimeException, the catch block on line 7 is unreachable. (If an ArithmeticException is
			thrown in try try block, it will be caught on line 5.) Line 7 generates a compiler error
			because it is unreachable code.
		', 6, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (710, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following program?
			
			1: public class Laptop {
			2: 	public void start() {
			3: 	try {
			4: 		System.out.print("Starting up ");
			5: 		throw new Exception();
			6: 	} catch (Exception e) {
			7: 		System.out.print("Problem ");
			8: 		System.exit(0);
			9: 	} finally {
			10: 	System.out.print("Shutting down ");
			11: }
			12:}
			13: public static void main(String[] args) {
			14: 	new Laptop().start();
			15: } }
		', 'checkbox', 'B', ' 
			The main() method invokes start on a new Laptop object. Line 4 prints Starting
			up; then line 5 throws an Exception. Line 6 catches the exception, line 7 prints
			Problem, and then line 8 calls System.exit, which terminates the JVM. The finally
			block does not execute because the JVM is no longer running.
		', 6, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (711, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following program?
			
			1: public class Dog {
			2: 	public String name;
			3: 	public void parseName() {
			4: 		System.out.print("1");
			5: 		try {
			6: 			System.out.print("2");
			7: 			int x = Integer.parseInt(name);
			8: 			System.out.print("3");
			9: 		} catch (NumberFormatException e) {
			10: 		System.out.print("4");
			11: 	}
			12: }
			13: public static void main(String[] args) {
			14: 	Dog leroy = new Dog();
			15: 	leroy.name = "Leroy";
			16: 	leroy.parseName();
			17: 	System.out.print("5");
			18: } }
		', 'checkbox', 'E', ' 
			The parseName method is invoked within main() on a new Dog object. Line 4 prints
			1. The try block executes and 2 is printed. Line 7 throws a NumberFormatException, so
			line 8 doesn’t execute. The exception is caught on line 9, and line 10 prints 4. Because the
			exception is handled, execution resumes normally. parseName runs to completion, and
			line 17 executes, printing 5. That’s the end of the program, so the output is 1245.
		', 6, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (712, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following program?
			
			1: public class Cat {
			2: 	public String name;
			3: 	public void parseName() {
			4: 		System.out.print("1");
			5: 		try {
			6: 			System.out.print("2");
			7: 			int x = Integer.parseInt(name);
			8: 			System.out.print("3");
			9: 		} catch (NullPointerException e) {
			10: 		System.out.print("4");
			11: 	}
			12: 	System.out.print("5");
			13: }
			14: public static void main(String[] args) {
			15: 	Cat leo = new Cat();
			16: 	leo.name = "Leo";
			17: 	leo.parseName();
			18: 	System.out.print("6");
			19: }
			20:}
		', 'checkbox', 'A', ' 
			The parseName method is invoked on a new Cat object. Line 4 prints 1. The try
			block is entered, and line 6 prints 2. Line 7 throws a NumberFormatException. It isn’t
			caught, so parseName ends. main() doesn’t catch the exception either, so the program
			terminates and the stack trace for the NumberFormatException is printed.
		', 6, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (713, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is printed by the following? (Choose all that apply)
			
			1: public class Mouse {
			2:	public String name;
			3: 	public void run() {
			4: 		System.out.print("1");
			5: 		try {
			6: 			System.out.print("2");
			7: 			name.toString();
			8: 			System.out.print("3");
			9: 		} catch (NullPointerException e) {
			10: 		System.out.print("4");
			11: 		throw e;
			12: 	}
			13: 	System.out.print("5");
			14: }
			15: public static void main(String[] args) {
			16: 	Mouse jerry = new Mouse();
			17: 		jerry.run();
			18: 		System.out.print("6");
			19: } }
		', 'checkbox', ' A, B, D, G', ' 
			The main() method invokes run on a new Mouse object. Line 4 prints 1 and
			line 6 prints 2, so options A and B are correct. Line 7 throws a NullPointerException,
			which causes line 8 to be skipped, so C is incorrect. The exception is caught on line 9
			and line 10 prints 4, so option D is correct. Line 11 throws the exception again, which
			causes run() to immediately end, so line 13 doesn’t execute and option E is incorrect.
			The main() method doesn’t catch the exception either, so line 18 doesn’t execute and
			option F is incorrect. The uncaught NullPointerException causes the stack trace to be
			printed, so option G is correct.
		', 6, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (714, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following statements are true? (Choose all that apply)
		', 'checkbox', ' A, B, C, E. ', ' 
			Classes listed in the throws part of a method declaration must extend
			java.lang.Throwable. This includes Error, Exception, and RuntimeException. Arbitrary classes such as String can’t go there. Any Java type, including Exception, can
			be declared as the return type. However, this will simply return the object rather than
			throw an exception.
		', 6, 13, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (715, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following can be inserted on line 8 to make this code compile? (Choose all that apply)
			
			7: public void ohNo() throws IOException {
			8: // INSERT CODE HERE
			9: }
		', 'checkbox', 'A, C, D, E', ' 
			A method that declares an exception isn’t required to throw one, making
			option A correct. Runtime exceptions can be thrown in any method, making options
			C and E correct. Option D matches the exception type declared and so is also correct.
			Option B is incorrect because a broader exception is not allowed.
		', 6, 14, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (716, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are unchecked exceptions? (Choose all that apply
		', 'checkbox', ' A, B, D, E', ' 
			ArrayIndexOutOfBoundsException, IllegalArgumentException, and NumberFormatException are runtime exceptions. Sorry, you have to memorize them. Any
			class that extends RuntimeException is a runtime (unchecked) exception. Classes that
			extend Exception but not RuntimeException are checked exceptions.
		', 6, 15, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (717, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which scenario is the best use of an exception?
		', 'checkbox', 'B', ' 
			IllegalArgumentException is used when an unexpected parameter is passed into a
			method. Option A is incorrect because returning null or -1 is a common return value
			for this scenario. Option D is incorrect because a for loop is typically used for this
			scenario. Option E is incorrect because you should find out how to code the method
			and not leave it for the unsuspecting programmer who calls your method. Option C is
			incorrect because you should run! 
		', 6, 16, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (718, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following can be inserted into Lion to make this code compile? (Choose all that apply)
			
			class HasSoreThroatException extends Exception {}
			class TiredException extends RuntimeException {}
			interface Roar {
			 void roar() throws HasSoreThroatException;
			}
			class Lion implements Roar {// INSERT CODE HERE
			}
		', 'checkbox', 'A, C, D, E', ' 
			The method is allowed to throw no exceptions at all, making option A correct. It is also allowed to throw runtime exceptions, making options D and E correct.
			Option C is also correct since it matches the signature in the interface.
		', 6, 17, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (719, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are true? (Choose all that apply)
		', 'checkbox', 'A, B, C, E', ' 
			Checked exceptions are required to be handled or declared. Runtime
			exceptions are allowed to be handled or declared. Errors are allowed to be handled or
			declared, but this is bad practice.
		', 6, 18, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (720, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following can be inserted in the blank to make the code compile? (Choose all that apply)
			
			public static void main(String[] args) {
			 try {
				System.out.println("work real hard");
			 } catch (____________ e) {
			 } catch (RuntimeException e) {
			 }
			}
		', 'checkbox', 'C, E', ' 
			Option C is allowed because it is a more specific type than RuntimeException.
			Option E is allowed because it isn’t in the same inheritance tree as RuntimeException. It’s not a good idea to catch either of these. Option B is not allowed because the
			method called inside the try block doesn’t declare an IOException to be thrown. The
			compiler realizes that IOException would be an unreachable catch block. Option D
			is not allowed because the same exception can’t be specified in two different catch
			blocks. Finally, option A is not allowed because it’s more general than RuntimeException and would make that block unreachable.
		', 6, 19, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (721, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What does the output of the following contain? (Choose all that apply)
			
			12: public static void main(String[] args) {
			13: 	System.out.print("a");
			14: 	try {
			15: 		System.out.print("b");
			16: 		throw new IllegalArgumentException();
			17: 	} catch (IllegalArgumentException e) {
			18: 		System.out.print("c");
			19: 		throw new RuntimeException("1");
			20: 	} catch (RuntimeException e) {
			21: 		System.out.print("d");
			22: 		throw new RuntimeException("2");
			23: 	} finally {
			24: 		System.out.print("e");
			25: 		throw new RuntimeException("3");
			26: 	}
			27: }
		', 'checkbox', 'A, E', ' 
			The code begins normally and prints a on line 13, followed by b on line 15. On
			line 16, it throws an exception that’s caught on line 17. Remember, only the most specific matching catch is run. Line 18 prints c, and then line 19 throws another exception. Regardless, the finally block runs, printing e. Since the finally block also
			throws an exception, that’s the one printed.
		', 6, 20, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (722, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class Animal {
				void jump() { System.out.println("Animal"); }
			}
			class Cat extends Animal {
				void jump(int a) { System.out.println("Cat"); }
			}
			class Rabbit extends Animal {
				void jump() { System.out.println("Rabbit"); }
			}
			class Circus {
				public static void main(String args[]) {
					Animal cat = new Cat();
					Rabbit rabbit = new Rabbit();
					cat.jump();
					rabbit.jump();
				}
			}
		', null, 'A', '
			Explanation: Although the classes Cat and Rabbit seem to override the method
			jump, the class Cat doesn’t override the method jump() defined in the class Animal.
			The class Cat defines a method parameter with the method jump, which makes it an
			overloaded method, not an overridden method. Because the class Cat extends the
			class Animal, it has access to the following two overloaded jump methods:
			
				void jump() { System.out.println("Animal"); }
				void jump(int a) { System.out.println("Cat"); }
			
			The following lines of code create an object of class Cat and assign it to a variable of
			type Animal:
			
				Animal cat = new Cat();
			
			When you call the method jump on the previous object, it executes the method jump,
			which doesn’t accept any method parameters, printing the following value:
			
				Animal
			
			The following code will also print Animal and not Cat:
			
				Cat cat = new Cat();
				cat.jump();
		', 6, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (723, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following code, select the correct statements:
			
			class Flower {
				public void fragrance() {System.out.println("Flower"); }
			}
			class Rose {
				public void fragrance() {System.out.println("Rose"); }
			}
			class Lily {
				public void fragrance() {System.out.println("Lily"); }
			}
			class Bouquet {
				public void arrangeFlowers() {
					Flower f1 = new Rose();
					Flower f2 = new Lily();
					f1.fragrance();
				}
			}
		', 'checkbox', 'D', '
			Explanation: Although the code seems to implement polymorphism using classes,
			note that neither of the classes Rose or Lily extends the class Flower. Hence, a variable
			of type Flower can’t be used to store objects of the classes Rose or Lily. The following
			lines of code will fail to compile:

				Flower f1 = new Rose();
				Flower f2 = new Lily();
		', 6, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (724, 'OCA Java SE 8 Programmer I Certification Guide', '
			Examine the following code and select the correct method declaration to be
			inserted at //INSERT CODE HERE:
			
			interface Movable {
				void move();
			}
			class Person implements Movable {
				public void move() { System.out.println("Person move"); }
			}
			class Vehicle implements Movable {
				public void move() { System.out.println("Vehicle move"); }
			}
			class Test {
				// INSERT CODE HERE
					movable.move();
				}
			}
		', 'checkbox', 'A, B, C', '
			Explanation: You need to insert code in the class Test that makes the following line of
			code work:
			
				movable.move();
			
			Hence, option (d) is incorrect. Because class Test doesn’t define any instance methods, the only way that the question’s line of code can execute is when a method
			parameter movable is passed to the method walk.
			Option (a) is correct. Because the interface Movable defines the method move, you
			can pass a variable of its type to the method move.
			Option (b) is correct. Because the class Person implements the interface Movable
			and defines the method move, you can pass a variable of its type to the method walk.
			With this version of the method walk, you can pass it an object of the class Person or
			any of its subclasses.
			Option (c) is correct. Because the class Vehicle implements the interface Movable
			and defines the method move, you can pass a variable of its type to the method walk.
			With this version of method walk, you can pass it an object of the class Vehicle or any
			of its subclasses.
		', 6, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (725, 'OCA Java SE 8 Programmer I Certification Guide', '
			Select the correct statements:
		', 'checkbox', 'B', '
			Option (a) is incorrect. To implement polymorphism with classes, either an abstract
			class or a concrete class can be used as a base class.
			Option (c) is incorrect. First of all, no code execution takes place at compile time.
			Code can only execute at runtime. In polymorphism, the determination of the exact
			method to execute is deferred until runtime and is determined by the exact type of
			the object on which a method needs to be called.
		', 6, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (726, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following code, select the correct statements:
			
			class Person {}
			class Employee extends Person {}
			class Doctor extends Person {}
		', 'checkbox', 'D', '
			Explanation: The given code doesn’t define any method in the class Person that is
			redefined or implemented in the classes Employee and Doctor. Although the classes
			Employee and Doctor extend the class Person, all three polymorphism concepts or
			design principles are based on a method, which is missing in these classes.
		', 6, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (727, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following statements are true?
		', 'checkbox', 'A, B', '
			Explanation: Option (a) is correct. Inheritance can allow you to reuse existing code
			by extending a class. In this way, the functionality that’s already defined in the base
			class need not be defined in the derived class. The functionality offered by the base
			class can be accessed in the derived class as if it were defined in the derived class.
			Option (b) is correct. Common code can be placed in the base class, which can be
			extended by all the derived classes. If any changes need to be made to this common
			code, it can be modified in the base class. The modified code will be accessible to all
			the derived classes.
			Option (c) is incorrect. Polymorphism doesn’t pass any special instructions to the
			compiler to make the Java code execute on multiple platforms. Java code can execute
			on multiple platforms because the Java compiler compiles to virtual machine code,
			which is platform neutral. Different platforms implement this virtual machine.
			Option (d) is incorrect. Polymorphic methods can throw exceptions.
		', 6, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (728, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following code, which of the options are true?
			
			class Satellite {
				void orbit() {}
			}
			class Moon extends Satellite {
				void orbit() {}
			}
			class ArtificialSatellite extends Satellite {
				void orbit() {}
			}
		', 'checkbox', 'A', '
			Explanation: All these options define classes. When methods with the same method
			signature are defined in classes that share an inheritance relationship, the methods
			are considered polymorphic. 
		', 6, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (729, 'OCA Java SE 8 Programmer I Certification Guide', '
			Examine the following code:
			
			class Programmer {
				void print() {
					System.out.println("Programmer - Mala Gupta");
				}
			}
			class Author extends Programmer {
				void print() {
					System.out.println("Author - Mala Gupta");
				}
			}
			class TestEJava {
				Programmer a = new Programmer();
				// INSERT CODE HERE
				a.print();
				b.print();
			}
			
			Which of the following lines of code can be individually inserted at //INSERT CODE
			HERE so that the output of the code is as follows?
			
				Programmer - Mala Gupta
				Author - Mala Gupta
		', 'checkbox', 'B, C', '
			Explanation: Option (a) is incorrect. This code will compile, but because both the reference variable and object are of type Programmer, calling print on this object will
			print Programmer - Mala Gupta, not Author - Mala Gupta.
			Option (d) is incorrect. This code will not compile. You can’t assign an object of a
			base class to a reference variable of a derived class.
			Option (e) is incorrect. This line of code will compile successfully, but it will fail at
			runtime with a ClassCastException. An object of a base class can’t be cast to an
			object of its derived class.
			Option (f) is incorrect. The expression ((Author)new Programmer()) is evaluated
			before it can be assigned to a reference variable of type Author. This line of code also
			tries to cast an object of the base class, Programmer, to an object of its derived class,
			Author. This code will also compile successfully but will fail at runtime with a ClassCastException. Using a reference variable of type Author won’t make a difference
			here. What matters here is the type that follows the new operator.
		', 6, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (730, 'OCA Java SE 8 Programmer I Certification Guide', '
			Given the following code, which of the options, when applied individually, will
			make it compile successfully?
			
			Line1>	 	interface Employee {}
			Line2> 		interface Printable extends Employee {
			Line3> 			String print();
			Line4> 		}
			Line5> 		class Programmer {
			Line6> 			String print() { return("Programmer - Mala Gupta"); }
			Line7> 		}
			Line8> 		class Author extends Programmer implements Printable, Employee {
			Line9> 			String print() { return("Author - Mala Gupta"); }
			Line10>	 	}
		', 'checkbox', 'C', '
			Explanation: The methods in an interface are implicitly public. A non-abstract class
			that implements an interface must implement all the methods defined in the interface. While overriding or implementing the methods, the accessibility of the implemented method must be public. An overriding method can’t be assigned a weaker
			access privilege than public.
			Option (a) is incorrect. There are no issues with the interface Printable extending
			the interface Employee and the class Author implementing both of these interfaces.
			Option (b) is incorrect. Adding the access modifier to the method print on line 3
			won’t make any difference to the existing code. The methods defined in an interface
			are implicitly public.
			Option (d) is incorrect. There are no issues with a class implementing two interfaces when one of the interfaces extends the other interface.
		', 6, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (731, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class Base {
				String var = "EJava";
				void printVar() {
					System.out.println(var);
				}
			}
			class Derived extends Base {
				String var = "Guru";
				void printVar() {
					System.out.println(var);
				}
			}
			class QReference {
				public static void main(String[] args) {
					Base base = new Base();
					Base derived = new Derived();
					System.out.println(base.var);
					System.out.println(derived.var);
					base.printVar();
					derived.printVar();
			}
			}
		', 'checkbox', 'A', '
			Explanation: With inheritance, the instance variables bind at compile time and the
			methods bind at runtime. The following line of code refers to an object of the class
			Base, using a reference variable of type Base. Hence, both of the following lines of
			code print EJava:
				
				System.out.println(base.var);
				base.printVar();
				
			But the following line of code refers to an object of the class Derived using a reference variable of type Base:
			
				Base derived = new Derived();
			
			Because the instance variables bind at compile time, the following line of code
			accesses and prints the value of the instance variable defined in the class Base:
			
				System.out.println(derived.var); // prints EJava
			
			In derived.printVar(), even though the method printVar is called using a reference of type Base, the JVM is aware that the method is invoked on a Derived object
			and so executes the overridden printVar method in the class Derived.
		', 6, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (732, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following class? (Choose all that apply)
			
			1: public class _C {
			2: 	private static int $;
			3: 	public static void main(String[] main) {
			4: 		String a_b;
			5: 		System.out.print($);
			6: 		System.out.print(a_b);
			7: } }
		', null, 'E', ' 
			Option E is correct because local variables require assignment before referencing
			them. Option D is incorrect because class and instance variables have default values
			and allow referencing. a_b defaults to a null value. Options A, B, and C are incorrect
			because identifiers may begin with a letter, underscore, or dollar sign. Options F and
			G are incorrect because the code does not compile. If a_b was an instance variable, the
			code would compile and output 0null. For more information, see Chapter 1.
		', 0, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (733, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			String s1 = "Java";
			String s2 = "Java";
			StringBuilder sb1 = new StringBuilder();
			sb1.append("Ja").append("va");
			System.out.println(s1 == s2);
			System.out.println(s1.equals(s2));
			System.out.println(sb1.toString() == s1);
			System.out.println(sb1.toString().equals(s1));
		', 'checkbox', 'C', ' 
			String literals are used from the string pool. This means that s1 and s2 refer to the
			same object and are equal. Therefore, the first two print statements print true. The
			third print statement prints false because toString() uses a method to compute the
			value and it is not from the string pool. The final print statement again prints true
			because equals() looks at the values of String objects. For more information, see
			Chapter 3.
		', 0, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (734, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code? (Choose all that apply)
			
			1: interface HasTail { int getTailLength(); }
			2: abstract class Puma implements HasTail {
			3: 	protected int getTailLength() {return 4;}
			4: }
			5: public class Cougar extends Puma {
			6: 	public static void main(String[] args) {
			7: 		Puma puma = new Puma();
			8: 		System.out.println(puma.getTailLength());
			9: 	}
			10:
			11: public int getTailLength(int length) {return 2;}
			12:}
		', 'checkbox', 'C, D, E', ' 
			First, the method getTailLength() in the interface HasTail is assumed to be
			public, since it is part of an interface. The implementation of the method on line 3 is
			therefore an invalid override, as protected is a more restrictive access modifier than
			public, so option C is correct. Next, the class Cougar implements an overloaded version of getTailLength(), but since the declaration in the parent class Puma is invalid,
			it needs to implement a public version of the method. Since it does not, the declaration
			of Puma is invalid, so option D is correct. Option E is incorrect, since Puma is marked
			abstract and cannot be instantiated. The overloaded method on line 11 is declared
			correctly, so option F is not correct. Finally, as the code has multiple compiler errors,
			options A, B, and G can be eliminated. For more information, see Chapter 5.
		', 0, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (735, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following program?
			
			1: public class FeedingSchedule {
			2: 	public static void main(String[] args) {
			3: 		boolean keepGoing = true;
			4: 		int count = 0;
			5: 		int x = 3;
			6: 		while(count++ < 3) {
			7: 			 y = (1 + 2 * count) % 3;
			8: 			switch(y) {
			9: 				default:
			10: 			case 0: x -= 1; break;
			11: 			case 1: x += 5;
			12: 		}
			13: 	}
			14: System.out.println(x);
			15: } }
		', 'checkbox', 'C', ' 
			The code compiles and runs without issue; therefore, option F is incorrect. This type
			of problem is best examined one loop iteration at a time:
				■ The loop continues as count loop expression evaluates to 0 < 3, which is true,
				with y taking a new value of 1. The value of y is set to:
				y = (1 + 2 * 1) % 3
				 = (1 + 2) % 3
				 = 3 % 3
				 = 0
				■ The first case block is called and the value of x is then set to:
				x = 3 - 1 = 2
				■ The loop continues as count loop expression evaluates to 1 < 3, which is true,
				with y taking a new value of 2. The value of y is set to:
				y = (1 + 2 * 2) % 3
				 = (1 + 4) % 3
				 = 4 % 3
				 = 2
				xl Introduction
				fl ast.indd 1½ 4/2014 Page xl
				■ The default block is called and the value of x is set to:
				x = 2 - 1 = 1
				■ The loop continues as the count loop expression evaluates to 2 < 3, which is true,
				with y taking a new value of 3. The value of y is set to:
				y = (1 + 2 * 3) % 3
				 = (1 + 6) % 3
				 = 7 % 3
				 = 1
				■ The second case block is called and the value of x is then set to:
				x = 1 + 5 = 6
				■ The loop ends as the count loop expression evaluates to 3 < 3, with y also taking a
				new value of 4. The most recent value of x, 6, is output, so the answer is option C.
			For more information, see Chapter 2.
		', 0, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (736, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code snippet?
			
			13: System.out.print("a");
			14: try {
			15: 	System.out.print("b");
			16: 	throw new IllegalArgumentException();
			17: } catch (RuntimeException e) {
			18: 	System.out.print("c");
			19: } finally {
			20: 	System.out.print("d");
			21: }
			22: System.out.print("e");
		', 'checkbox', 'D', ' 
			The code starts running and prints a and b on lines 13 and 15. Line 16 throws an
			exception, which is caught on line 17. After line 18 prints c, the finally block is run
			and d is printed. Then the try statement ends and e is printed on line 22. For more
			information, see Chapter 6.
		', 0, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (737, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following program?
			
			1: public class MathFunctions {
			2: 	public static void addToInt(int x, int amountToAdd) {
			3: 		x = x + amountToAdd;
			4: 	}
			5: 	public static void main(String[] args) {
			6: 		int a = 15;
			7: 		int b = 10;
			8: 		MathFunctions.addToInt(a, b);
			9: 		System.out.println(a); } }
		', 'checkbox', 'B', ' 
			The code compiles successfully, so options D and E are incorrect. The value of a
			cannot be changed by the addToInt method, no matter what the method does, because
			only a copy of the variable is passed into the parameter x. Therefore, a does not change
			and the output on line 9 is 15. For more information, see Chapter 4.
		', 0, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (738, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following code?
			
			int[] array = {6,9,8};
			List<Integer> list = new ArrayList<>();
			list.add(array[0]);
			list.add(array[2]);
			list.set(1, array[1]);
			list.remove(0);
			System.out.println(list);
		', 'checkbox', 'B', ' 
			The array is allowed to use an anonymous initializer because it is in the same line as
			the declaration. The ArrayList uses the diamond operator allowed since Java 7. This
			specifies the type matches the one on the left without having to re-type it. After adding
			the two elements, list contains [6, 8]. We then replace the element at index 1 with 9,
			resulting in [6, 9]. Finally, we remove the element at index 0, leaving [9]. Option C
			is incorrect because arrays output something like that rather than an ArrayList. For
			more information, see Chapter 3.
		', 0, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (739, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following code?
			
			1: public class Deer {
			2: 	public Deer() { System.out.print("Deer"); }
			3: 	public Deer(int age) { System.out.print("DeerAge"); }
			4: 	private boolean hasHorns() { return false; }
			5: 	public static void main(String[] args) {
			6: 		Deer deer = new Reindeer(5);
			7: 		System.out.println(","+deer.hasHorns());
			8: 	}
			9: }
			10: class Reindeer extends Deer {
			11: 	public Reindeer(int age) { System.out.print("Reindeer"); }
			12: 	public boolean hasHorns() { return true; }
			13: } 
		', 'checkbox', 'A', ' 
			The code compiles and runs without issue, so options G and H are incorrect. First,
			the Reindeer object is instantiated using the constructor that takes an int value. Since
			there is no explicit call to the parent constructor, the default no-argument super()
			is inserted as the first line of the constructor. The output is then Deer, followed by
			Reindeer in the child constructor, so only options A and B can be correct. Next,
			the method hasHorns() looks like an overridden method, but it is actually a hidden
			method since it is declared private in the parent class. Because the hidden method is
			referenced in the parent class, the parent version is used, so the code outputs false,
			and option A is the correct answer.
		', 0, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (740, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following statements are true? (Choose all that apply)
		', 'checkbox', 'B, C', ' 
			Only checked exceptions are required to be handled (caught) or declared. Runtime exceptions are commonly thrown by both the JVM and programmer code.
			Checked exceptions are usually thrown by programmer code. Errors are intended to be 
			thrown by the JVM. While a programmer could throw one, this would be a horrible
			practice. For more information, see Chapter 6.
		', 0, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (741, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which are true of the following code? (Choose all that apply)
			
			1: import java.util.*;
			2: public class Grasshopper {
			3: public Grasshopper(String n) {
			4: 	name = n;
			5: }
			6: public static void main(String[] args) {
			7: 	Grasshopper one = new Grasshopper("g1");
			8: 	Grasshopper two = new Grasshopper("g2");
			9: 	one = two;
			10: two = null;
			11: one = null;
			12:}
			13: private String name; }
		', 'checkbox', 'C, D, F', ' 
			Immediately after line 9, only Grasshopper g1 is eligible for garbage collection
			since both one and two point to Grasshopper g2. Immediately after line 10, we still
			only have Grasshopper g1 eligible for garbage collection. Reference one points to g1
			and reference two is null. Immediately after line 11, both Grasshopper objects are eligible for garbage collection since both one and two point to null. The code does compile. Although it is traditional to declare instance variables early in the class, you don’t
			have to. For more information, see Chapter 1.
		', 0, 10, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (742, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following program?
			
			1: public class FeedingSchedule {
			2: 	public static void main(String[] args) {
			3: 		int x = 5, j = 0;
			4: 		OUTER: for(int i=0; i<3; )
			5: 			INNER: do {
			6: 				i++; x++;
			7: 				if(x > 10) break INNER;
			8: 				x += 4;
			9: 				j++;
			10: 		} while(j <= 2);
			11: 	System.out.println(x);
			12: } }
		', 'checkbox', 'B', ' 
			The code compiles and runs without issue; therefore, options E and F are incorrect.
			This type of problem is best examined one loop iteration at a time:
				■ On the first iteration of the outer loop i is 0, so the loop continues.
				■ On the first iteration of the inner loop, i is updated to 1 and x to 6. The if-then
				statement branch is not executed, and x is increased to 10 and j to 1.
				■ On the second iteration of the inner loop (since j = 1 and 1 <= 2), i is updated
				to 2 and x to 11. At this point, the if-then branch will evaluate to true for the
				remainder of the program run, which causes the flow to break out of the inner
				loop each time it is reached.
				■ On the second iteration of the outer loop (since i = 2), i is updated to 3 and x to
				12. As before, the inner loop is broken since x is still greater than 10.
				■ On the third iteration of the outer loop, the outer loop is broken, as i is already
				not less than 3. The most recent value of x, 12, is output, so the answer is option B.
				For more information, see Chapter 2.
		', 0, 11, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (743, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the result of the following program?
			
			1: public class Egret {
			2: 	private String color;
			3: 	public Egret() {
			4: 		this("white");
			5: 	}
			6: 	public Egret(String color) {
			7: 		color = color;
			8: 	}
			9: 	public static void main(String[] args) {
			10: 	Egret e = new Egret();
			11: 	System.out.println("Color:" + e.color);
			12: 	}
			13: }
		', 'checkbox', 'B', ' 
			Line 10 calls the constructor on lines 3–5. That constructor calls the other constructor. However, the constructor on lines 6–8 assigns the method parameter to itself,
			which leaves the color instance variable on line 2 set to its default value of null. For
			more information, see Chapter 4.
		', 0, 12, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (744, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			What is the output of the following program?
			
			1: public class BearOrShark {
			2: 	public static void main(String[] args) {
			3: 		int luck = 10;
			4: 		if((luck>10 ? luck++: --luck)<10) {
			5: 			System.out.print("Bear");
			6: 		} if(luck<10) System.out.print("Shark");
			7: } }
		', 'checkbox', 'C', ' 
			The code compiles and runs without issue, so options D and E are correct. Remember that only one of the right-hand ternary expressions will be evaluated at runtime.
			Since luck is not less than 10, the second expression, --luck, will be evaluated, and
			since the pre-increment operator was used, the value returned will be 9, which is less
			than 10. So the first if-then statement will be visited and Bear will be output. Notice
			there is no else statement on line 6. Since luck is still less than 10, the second if-then
			statement will also be reached and Shark will be output; therefore, the correct answer
			is option C. For more information, see Chapter 2.
		', 0, 13, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (745, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Assuming we have a valid, non-null HenHouse object whose value is initialized by the
			blank line shown here, which of the following are possible outputs of this application?(Choose all that apply)
			
			1: class Chicken {}
			2: interface HenHouse { public java.util.List<Chicken> getChickens(); }
			3: public class ChickenSong {
			4: 	public static void main(String[] args) {
			5: 		HenHouse house = ______________
			6: 		Chicken chicken = house.getChickens().get(0);
			7: 		for(int i=0; i<house.getChickens().size();
			8: 			chicken = house.getChickens().get(i++)) {
			9: 			System.out.println("Cluck");
			10: } } }
		', 'checkbox', 'D, E, F', ' 
			The code compiles without issue, so options A and B are incorrect. If house
			.getChickens() returns an array of one element, the code will output Cluck once, so
			option D is correct. If house.getChickens() returns an array of multiple elements, the
			code will output Cluck once for each element in the array, so option E is correct. Alternatively, if house.getChickens() returns an array of zero elements, then the code will 
			throw an IndexOutOfBoundsException on the call to house.getChickens().get(0);
			therefore, option C is not possible and option F is correct. The code will also throw an
			exception if the array returned by house.getChickens() is null, so option F is possible
			under multiple circumstances. For more information, see Chapter 2.
		', 0, 14, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (746, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following statements can be inserted in the blank line so that the code will
			compile successfully? (Choose all that apply)
			
			public interface CanSwim {}
			public class Amphibian implements CanSwim {}
			class Tadpole extends Amphibian {}
			public class FindAllTadPole {
			 public static void main(String[] args) {
				List<Tadpole> tadpoles = new ArrayList<Tadpole>();
				for(Amphibian amphibian : tadpoles) {
					___________ tadpole = amphibian;
			} } }
		', 'checkbox', 'A, C, E', ' 
			The for-each loop automatically casts each Tadpole object to an Amphibian
			reference, which does not require an explicit cast because Tadpole is a subclass of
			Amphibian. From there, any parent class or interface that Amphibian inherits from is
			permitted without an explicit cast. This includes CanSwim, the interface Amphibian
			implements, and Object, which all classes extend from, so options A and E are correct.
			Option C is also correct since the reference is being cast to the same type, so no explicit
			cast is required. Option B is incorrect, since Long is not a parent of Amphibian. Option
			D is incorrect as well, although an explicit cast to Tadpole on the right-hand side of the
			expression would be required to allow the code to compile. For more information, see
			Chapter 5.
		', 0, 15, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (747, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
		What individual changes, if any, would allow the following code to compile? (Choose all that apply)
		
		1: public interface Animal { public default String getName() { return null; } }
		2: interface Mammal { public default String getName() { return null; } }
		3: abstract class Otter implements Mammal, Animal {}
		', 'checkbox', 'D, F, G', ' 
			The code does not compile, since a class cannot inherit two interfaces that
			both define default methods with the same signature, unless the class implementing
			the interfaces overrides it with an abstract or concrete method. Therefore, option A is
			incorrect and options F and G are correct. The alternate approach is to make the
			getName() method abstract in the interfaces, because an interface may inherit two
			abstract methods with the same signature. The change must be made to both interfaces, though, so options B and C are incorrect if taken individually, and option D is
			correct since the changes are taken together. For more information, see Chapter 5.
		', 0, 16, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (748, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following lines can be inserted at line 11 to print true? (Choose all that apply)
			
			10: public static void main(String[] args) {
			11: // INSERT CODE HERE
			12: }
			13: private static boolean test(Predicate<Integer> p) {
			14: return p.test(5);
			15: }
		', 'checkbox', 'A, C, F', ' 
			The only functional programming interface you need to memorize for the
			exam is Predicate. It takes a single parameter and returns a boolean. Lambda expressions with one parameter are allowed to omit the parentheses around the parameter
			list, making options A and C correct. The return statement is optional when a single
			statement is in the body, making option F correct. Option B is incorrect because a
			return statement must be used if braces are included around the body. Options D and
			E are incorrect because the type is Integer in the predicate and int in the lambda.
			Autoboxing works for collections not inferring predicates. If these two were changed
			to Integer, they would be correct. For more information, see Chapter 4.
		', 0, 17, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (749, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following print out a date representing April 1, 2015? (Choose all that apply)
		', 'checkbox', ' B, D', ' 
			The new date APIs added in Java 8 use static methods rather than a constructor
			to create a new date, making options E and F incorrect. The months are indexed starting with 1 in these APIs, making options A and C incorrect. Option A uses the old
			Calendar constants which are indexed from 0. Therefore, options B and D are correct.
			For more information, see Chapter 3.
		', 0, 18, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (750, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Bytecode is in a file with which extension?
		', 'checkbox', 'C', ' 
			Files with the .java extension contain the Java source code and are compiled to
			files with the .class extension that contain the bytecode. For more information, see
			Chapter 1.
		', 0, 19, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (751, 'OCA Oracle Certified Associate Java SE 8 [2014]', '
			Which of the following are checked exceptions? (Choose all that apply)
		', 'checkbox', 'A, C', ' 
			Option A is the exception base class, which is a checked exception. Options B,
			D, and E extend RuntimeException directly or indirectly and therefore are unchecked
			exceptions. Option F is a throwable and not an exception, and so should not be caught
			or declared. For more information, see Chapter 6.
		', 0, 20, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (752, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code:
			
			class Course {
				String courseName;
				Course() {
					Course c = new Course();
					c.courseName = "Oracle";
				}
			}
			class EJavaGuruPrivate {
				public static void main(String args[]) {
					Course c = new Course();
					c.courseName = "Java";
					System.out.println(c.courseName);
				}
			}
		', null, 'D', '
			Explanation: This class will throw a StackOverflowError at runtime. The easiest way
			to look for a StackOverflowError is to locate recursive method calls. In the question’s
			code, the constructor of the class Course creates an object of the class Course, which
			will call the constructor again. Hence, this becomes a recursive call and ends up
			throwing a StackOverflowError at runtime. (As you know, an exception or an error
			can be thrown only at runtime, not compile time.)
		', 7, 1, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (753, 'OCA Java SE 8 Programmer I Certification Guide', '
			Select the correct option(s):
		', 'checkbox', 'B, C, D', '
			Explanation: Option (a) is incorrect. You can handle runtime exceptions the way you
			can handle a checked exception in your code: using a try-catch block.
			Option (b) is correct. You shouldn’t try to handle errors in your code. Or, to put it
			another way, you can’t do much when an error is thrown by your code. Instead of trying to handle errors in your code, you should resolve the code that results in these
			errors. For example, StackOverflowError is an error that will be thrown by your code
			if your code executes a method recursively without any exit condition. This repetition
			will consume all the space on the stack and result in a StackOverflowError.
			Option (c) is correct. If you fail to implement either of these options, your code
			won’t compile.
			Option (d) is correct. It isn’t mandatory for runtime exceptions to be included in
			a method’s throws clause. Usually this inclusion is unnecessary, but if you do include
			it, your code will execute without any issues.
			Option (e) is incorrect. A runtime exception and all its subclasses are not checked
			exceptions.
		', 7, 2, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (754, 'OCA Java SE 8 Programmer I Certification Guide', '
			Examine the following code and select the correct option(s):
			
			class EJavaGuruExcep {
				public static void main(String args[]) {
					EJavaGuruExcep var = new EJavaGuruExcep();
					var.printArrValues(args);
			}
				void printArrValues(String[] arr) {
					try {
						System.out.println(arr[0] + ":" + arr[1]);
					} catch (NullPointerException e) {
						System.out.println("NullPointerException");
					} catch (IndexOutOfBoundsException e) {
						System.out.println("IndexOutOfBoundsException");
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("ArrayIndexOutOfBoundsException");
					}
				}
			}
		', 'checkbox', 'D', '
			Explanation: The key to answering this question is to be aware of the following two facts:
				■ Exceptions are classes. If an exception’s base class is used in a catch block, it
				can catch all the exceptions of its derived class. If you try to catch an exception
				from its derived class afterward, the code won’t compile.
				■ ArrayIndexOutOfBoundsException is a derived class of IndexOutOfBoundsException.
			The rest of the points try to trick you into believing that the question is based on the
			arguments passed to a main method.
		', 7, 3, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (755, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class EJava {
				void method() {
					try {
						guru();
						return;
					} finally {
						System.out.println("finally 1");
					}
				}
				void guru() {
					System.out.println("guru");
					throw new StackOverflowError();
				}
				public static void main(String args[]) {
					EJava var = new EJava();
					var.method();
				}
			}
		', 'checkbox', 'B', '
			Explanation: No compilation errors exist with the code.
			The method guru throws StackOverflowError, which is not a checked exception.
			Even though your code shouldn’t throw an error, it is possible syntactically. Your code
			will compile successfully.
			The call to the method guru is immediately followed by the keyword return, which is
			supposed to end the execution of the method method. But the call to guru is placed
			within a try-catch block, with a finally block. Because guru doesn’t handle the error
			StackOverflowError itself, the control looks for the exception handler in the method
			method. This calling method doesn’t handle this error but defines a finally block. The
			control then executes the finally block. Because the code can’t find an appropriate
			handler to handle this error, it propagates to the JVM, which abruptly halts the code. 
		', 7, 4, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (756, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class Quest5 {
				public static void main(String args[]) {
					int arr[] = new int[5];
					arr = new int[]{1,2,3,4};
					int x = arr[1]-- + arr[0]-- /arr[0] * arr[4];
					System.out.println(x);
				}
			}
		', 'checkbox', 'C', '
			Explanation: Apart from testing your exception-handling skills, this question also tests
			you in operator precedence. The code throws an ArithmeticException in an attempt
			to evaluate the following expression:
			
				int x = arr[1]-- + arr[0]-- /arr[0] * arr[4];
			
			Before execution of the preceding line of code, arr[1] stores value 2, arr[0] stores
			value 1, and arr[4] isn’t initialized. So an attempt to access arr[4] would result in an
			ArrayIndexOutOfBoundsException.
			In an arithmetic operation, post- and pre-increment operators have the highest
			precedence. So the first pass reduces this equation to
				
				int x = 2 + 1 /0 * undefined;
			
			Both * and / have equal precedence level here. What matters beyond operator precedence is reading the same-level operations from left to right. This is why / is computed before * in the present expression. So an attempt to execute 1/0 throws an
			ArithmeticException.  
		', 7, 5, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (757, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following methods will not compile?
		', 'checkbox', 'B, D', '
			Explanation: Methods that compile successfully might not be implemented correctly.
			This question only asks about the methods that will follow the syntax rules so that they
			compile successfully.
			Option (a) code compiles successfully. Because IllegalArgumentException is a
			runtime exception, method1() can throw it without declaring it to be thrown in its
			throws statement.
			Option (b) code won’t compile. method2() throws a checked exception, that is,
			Exception, without declaring it to be thrown in its throws statement.
			Although the code in option (c) makes little sense, it will compile successfully. A
			method can throw a StackOverflowError (an unchecked exception) without including it in the throws clause of its method declaration.
			Option (d) code won’t compile. If a method declares to throw a checked exception, its body can’t throw a more general exception in its body. method4() declares to
			throw Exception but throws Throwable, which is not allowed (Exception subclasses
			Throwable).
			Option (e) code will compile successfully. If a method declares to throw Exception,
			it might not actually throw it. This only applies to Exception (because RuntimeException subclasses it), runtime exceptions, and errors. 
		', 7, 6, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (758, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class TryFinally {
				int tryAgain() {
					int a = 10;
					try {
						++a;
					} finally {
						a++;
					}
					return a;
				}
				public static void main(String args[]) {
					System.out.println(new TryFinally().tryAgain());
				}
			}
		', 'checkbox', 'C', '
			Explanation: The try block executes, incrementing the value of variable a to 11. This
			step is followed by execution of the finally block, which also increments the value of
			variable a by 1, to 12. The method tryAgain returns the value 12, which is printed by
			the method main.
			There are no compilation issues with the code. A try block can be followed by a
			finally block without any catch blocks. Even though the try block doesn’t throw
			any exceptions, it compiles successfully. The following is an example of a try-catch
			block that won’t compile because it tries to catch a checked exception that’s never
			thrown by the try block:
				try {
					++a;
				} catch (java.io.FileNotFoundException e) {
				}
		', 7, 7, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (759, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class EJavaBase {
				void myMethod() throws ExceptionInInitializerError {
					System.out.println("Base");
				}
			}
			class EJavaDerived extends EJavaBase {
				void myMethod() throws RuntimeException {
					System.out.println("Derived");
				}
			}
			class EJava3 {
				public static void main(String args[]) {
					EJavaBase obj = new EJavaDerived();
					obj.myMethod();
				}
			}
		', 'checkbox', 'B', '
			Explanation: The rule that if a base class method doesn’t throw an exception, an overriding method in the derived class can’t throw an exception applies only to checked
			exceptions. It doesn’t apply to runtime (unchecked) exceptions or errors. A base or
			overridden method is free to throw any error or runtime exception.
		', 7, 8, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (760, 'OCA Java SE 8 Programmer I Certification Guide', '
			Which of the following statements are true?
		', 'checkbox', 'C, D', '
			Option (a) is incorrect. A user-defined class can throw any exception from the Java API.
			Option (b) is incorrect. An uninitialized instance variable of type String will be
			assigned a default value of null. When you pass this variable to System.out.println
			to print it, it will print null. If you try to access any non-static member (variable or
			method) of this null object, then a NullPointerException will be thrown. 
		', 7, 9, null);
INSERT INTO quiz.domande (id, book_title, testo, answer_type, risposta_esatta, spiegazione, chapter, question, book_id) VALUES (761, 'OCA Java SE 8 Programmer I Certification Guide', '
			What is the output of the following code?
			
			class EJava {
				void foo() {
				try {
					String s = null;
					System.out.println("1");
					try {
						System.out.println(s.length());
					} catch (NullPointerException e) {
						System.out.println("inner");
					}
					System.out.println("2");
					} catch (NullPointerException e) {
						System.out.println("outer");
					}
				}
				public static void main(String args[]) {
					EJava obj = new EJava();
					obj.foo();
				}
			}
		', 'checkbox', 'D', '
			Explanation: First of all, nested try-catch statements don’t throw compilation errors.
			Because the variable s hasn’t been initialized, an attempt to access its method
			length() will throw a NullPointerException. The inner try-catch block handles
			this exception and prints inner. The control then moves on to complete the remaining code in the outer try-catch block, printing 2. Because the NullPointerException
			was already handled in the inner try-catch block, it’s not handled in the outer trycatch block.
		', 7, 10, null);