# Report for assignment 3

## Branch information
The report is stored in report.md on branch [report-assignment](https://github.com/jcroona/mockito/tree/report-assignment)

The branch with the original jacoco coverage report is stored on branch [original_coverage](https://github.com/jcroona/mockito/tree/original_coverage) in folder 
build/reports/jacoco/test/html

The branch [coverage_before](https://github.com/jcroona/mockito/tree/coverage_before) has our ad-hoc coverage framework before more tests was added.

The branch [coverage_after](https://github.com/jcroona/mockito/tree/coverage_after) has our ad-hoc coverage framework and the additional tests.


## Project

Name: Mockito

URL: https://github.com/mockito/mockito
URL to our fork: https://github.com/jcroona/mockito


Mockito is a popular project for doing mock testing in 
java.

## Onboarding experience

Did it build as documented?  
Yes, to build it was needed to run `./gradlew build`. However, it did fail to build, due to a failing stylecheck. There was therefore
some things that could be improved. All tests worked correctly, when running `gradlew test`. 
    
(See the assignment for details; if everything works out of the box,
there is no need to write much here.)


## Complexity

1. What are your results for the ten most complex functions? (If ranking
is not easily possible: ten complex functions)?
   * Did all tools/methods get the same result?
    The results where generally pretty close,
    as 5 of the 5 functions where at most off by 2
    from the result of lizard, when compared hand 
    calculated.
  
   * Are the results clear?
    Yes, the results for the complexity is quite clear.

### This is the 10 most complex functions,ordered by cyclomatic complexity. The first number is nloc. The second number is CC.
    1.  52     25    525      1      56 ReturnsEmptyValues::returnValueFor@77-132@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsEmptyValues.java

    2.  25     21    370      1      25 ArrayEquals::matches@17-41@src/main/java/org/mockito/internal/matchers/ArrayEquals.java

    3.  27     14    173      1      27 SerializableMethod::equals@90-116@src/main/java/org/mockito/internal/invocation/SerializableMethod.java

    4.  47     14    267      1      51 ValuePrinter::print@25-75@src/main/java/org/mockito/internal/matchers/text/ValuePrinter.java

    5.  26      9    157      2      27 ConstructorInstantiator::evaluateConstructor@159-185@src/main/java/org/mockito/internal/creation/instance/ConstructorInstantiator.java

    6.  34      8    351      1      38 InvocationsPrinter::printInvocations@20-57@src/main/java/org/mockito/internal/debugging/InvocationsPrinter.java

    7.  22      8    160      1      24 ReturnsSmartNulls::answer@49-72@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsSmartNulls.java

    8.  12      8    130      1      12 ValuePrinter::printMap@77-88@src/main/java/org/mockito/internal/matchers/text/ValuePrinter.java

    9.  22      7    181      2      24 SpyAnnotationEngine::process@49-72@src/main/java/org/mockito/internal/configuration/SpyAnnotationEngine.java
    
    10. 21      7    127      1      24 ReturnsSmartNulls::delegateChains@82-105@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsSmartNulls.java

### Hand calculated CC for the top 5 functions
    1. 25 ReturnsEmptyValues::returnValueFor@77-132@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsEmptyValues.java
   
    2. 20 ArrayEquals::matches@17-41@src/main/java/org/mockito/internal/matchers/ArrayEquals.java

    3. 13 SerializableMethod::equals@90-116@src/main/java/org/mockito/internal/invocation/SerializableMethod.java

    4. 12 ValuePrinter::print@25-75@src/main/java/org/mockito/internal/matchers/text/ValuePrinter.java

    5. 9 ConstructorInstantiator::evaluateConstructor@159-185@src/main/java/org/mockito/internal/creation/instance/ConstructorInstantiator.java

2. Are the functions just complex, or also long?  
They are not very long, so it is mostly just high complexity.

3. What is the purpose of the functions?
    1. ReturnsEmptyValues::returnValueFor(): The purpose is to return a default non-null value for the typethat is sent as a parameter. It is done through a large number of else if statements, and a branch is only reached if the type matches, at which point the function returns a default value for that type. If no type matches, null is returned.

    2. ArrayEquals::matches(): Checking if two arrays are equal by checking that the types of the two arrays are the same, and calling another function to
    check that the arrays are equal. Each branch in the matches() function is reached depending on 
    the types of the input array and the wanted array. If the two arrays are of the same type the function Arrays.equals() is called
    to return the result of checking equality of the two arrays. If the type is unsupported or the types are different false is returned.
    3. SerializableMethod::equals(): Checking if the `this` object is equal to another object. The first three branches cover the cases where the objects are equal, 
    where the input object is null and where the two objects have different classes. The next branches cover the cases where the 
    declaringClass of the two objects are different, followed by checking if the objects have a different methodName. Lastly 
    the parameterTypes and returnType of the two objects is checked to see if they are different. The final branch is reached 
    and returns true if none of the previous branches have caught an inequality between the two objects.
    
    4. ValuePrinter::print(): The purpose is to create a printable string reperesentation of an object. The returned string is meant to be readable by humans. Branches are reached depending on the type of the input object, i.e. 11 branches/checks for different types. If the input object is of another type than the tested ones it reaches the last branch witch calls descriptionOf(). The method will try to just return the value of the object otherwise it will cast an exception.


    5. ConstructorInstantiator::evaluateConstructor(): Check if a new found constructor is better than any of the previously found cionstructors. More detailed documentation of the method w.r.t the branches is in the code of the [class itself](https://github.com/jcroona/mockito/blob/07eb9e5644d026260cdf983a6fd6126fb4156b2c/src/main/java/org/mockito/internal/creation/instance/ConstructorInstantiator.java)
    6. InvocationsPrinter::printInvocations(): Prints the methods that have been used on this mock object.
    7. ReturnsSmartNulls::answer(): Returns an object that gives a more useful error message than NPE in the event that the result of a method is null. The method is documented in detail w.r.t. the branches in the code in the [class itself.](https://github.com/jcroona/mockito/blob/coverage_before/src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsSmartNulls.java)
    8. ValuePrinter::printMap(): Returns a string representation of a map in a human readable form to be printed. The interesting branching of the code in this method is based on the iterator parameter. In case the iterator contains one element, the return string will consist of the start and end string parameters, as well as the element. In case the iterator contains more than one element, the string's items will also be separated by the separator string parameter. Additionally, the code will branch in case any of the first three parameters are null, in which case they will be set to standard strings.

    9. SpyAnnotationEngine::process(): The purpose of the function is to process fields that has the @Spy annotation.  The method is documented in detail w.r.t. the branches in the code in the [class itself.](https://github.com/jcroona/mockito/blob/coverage_before/src/main/java/org/mockito/internal/configuration/SpyAnnotationEngine.java)

    10. ReturnsSmartNulls::delegateChains() tries to resolve a non-null empty value for the given type, and tries to use any parent classes and interfaces available to do so. First it is checked if the type passed as a parameter has a non-null empty value, and then the interfaces that the class implements are checked. If none of them are viable, the parent is tried, and the process repeats as long as no non-null type is found or there is a parent class remaining. The branches in the code is described in detail in the [class itself.](https://github.com/jcroona/mockito/blob/coverage_before/src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsSmartNulls.java#L105-L128)



4. Are exceptions taken into account in the given measurements?
Yes.
5. Is the documentation clear w.r.t. all the possible outcomes?
No, the documnentation is very unclear.

## Coverage

### Tools

#### Document your experience in using a "new"/different coverage tool.

How well was the tool documented? Was it possible/easy/difficult to
integrate it with your build environment?

We used Jacoco. It had pretty clear documentation, and
was easy to integrate with gradle.

### DYI

Show a patch that show the instrumented code in main (or the unit
test setup), and the ten methods where branch coverage is measured.

The patch is probably too long to be copied here, so please add
the git command that is used to obtain the patch instead:

git diff release/2.x coverage_before

What kinds of constructs does your tool support, and how accurate is
its output?

### Evaluation

Report of old coverage: https://people.kth.se/~jcroona/coverage/before/

Report of new coverage: https://people.kth.se/~jcroona/coverage/after/

Test cases added:

git diff release/2.x coverage_tests

## Refactoring

Plan for refactoring complex code:

    1. 52     25    525      1      56 ReturnsEmptyValues::returnValueFor@77-132@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsEmptyValues.java  

    Group up the last else if statements java.util.* to one and call a new method to check which one it is. And for example to the same with all diffrerent kinds of Sets.

    2. 85     21    722      1      95 SubclassBytecodeGenerator::mockClass@81-175@src/main/java/org/mockito/internal/creation/bytebuddy/SubclassBytecodeGenerator.java

    Complex method and hard to reduce the complexity but one things you could do is put a while and if-else statement(line 112-133) that are inside an else statement inside its own method.

    3. 25     21    370      1      25 ArrayEquals::matches@17-41@src/main/java/org/mockito/internal/matchers/ArrayEquals.java

    All different if/else-if statements checks different datatypes and 
    it is hard to reduce the complexity. We don't think that you would benefit but you could divide it into to methods which handles some of the checks each.


    4. 27     14    173      1      27 SerializableMethod::equals@90-116@src/main/java/org/mockito/internal/invocation/SerializableMethod.java

    All comparisons (line 97) with the new obejct "other" could be handled by a new method. 

    5. 47     14    267      1      51 ValuePrinter::print@25-75@src/main/java/org/mockito/internal/matchers/text/ValuePrinter.java

    Same as for method 3, all checks are for different kinds of datatypes.

## Effort spent

For each team member, how much time was spent in

1. plenary discussions/meetings; 6h

2. discussions within parts of the group; 5h

3. reading documentation; 4h

4. configuration; 2h

5. analyzing code/output; 5h

6. writing documentation; 4h

7. writing code; 2h

8. running code? 1h

## Overall experience

What are your main take-aways from this project? What did you learn?  
We have learned much about how development works in large scale open-source projects, in particular about the complexity levels and how difficult it can be to get complete branch coverage in functions with high cyclomatic complexity. We have also learned much about refactoring complex functions into smaller, more manageable functions that are significantly easier to run tests on for complete branch coverage.
