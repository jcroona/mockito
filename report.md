# Report for assignment 3

This is a template for your report. You are free to modify it as needed.
It is not required to use markdown for your report either, but the report
has to be delivered in a standard, cross-platform format.

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
    1. 52     25    525      1      56 ReturnsEmptyValues::returnValueFor@77-132@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsEmptyValues.java

    2. 85     21    722      1      95 SubclassBytecodeGenerator::mockClass@81-175@src/main/java/org/mockito/internal/creation/bytebuddy/SubclassBytecodeGenerator.java

    3. 25     21    370      1      25 ArrayEquals::matches@17-41@src/main/java/org/mockito/internal/matchers/ArrayEquals.java

    4. 27     14    173      1      27 SerializableMethod::equals@90-116@src/main/java/org/mockito/internal/invocation/SerializableMethod.java

    5. 47     14    267      1      51 ValuePrinter::print@25-75@src/main/java/org/mockito/internal/matchers/text/ValuePrinter.java

    6. 70     13    609      4      70 ModuleHandler::ModuleSystemFound::adjustModuleGraph@137-206@src/main/java/org/mockito/internal/creation/bytebuddy/ModuleHandler.java

    7. 26      9    157      2      27 ConstructorInstantiator::evaluateConstructor@159-185@src/main/java/org/mockito/internal/creation/instance/ConstructorInstantiator.java

    8. 34      8    351      1      38 InvocationsPrinter::printInvocations@20-57@src/main/java/org/mockito/internal/debugging/InvocationsPrinter.java

    9. 22      8    160      1      24 ReturnsSmartNulls::answer@49-72@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsSmartNulls.java

    10. 12      8    130      1      12 ValuePrinter::printMap@77-88@src/main/java/org/mockito/internal/matchers/text/ValuePrinter.java

### Hand calculated CC for the top 5 functions
    1.    25   ReturnsEmptyValues::returnValueFor@77-132@src/main/java/org/mockito/internal/stubbing/defaultanswers/ReturnsEmptyValues.java
    2. 21 SubclassBytecodeGenerator::mockClass@81-175@src/main/java/org/mockito/internal/creation/bytebuddy/SubclassBytecodeGenerator.java

    3. 20 ArrayEquals::matches@17-41@src/main/java/org/mockito/internal/matchers/ArrayEquals.java

    4. 13     SerializableMethod::equals@90-116@src/main/java/org/mockito/internal/invocation/SerializableMethod.java

     5. 12   ValuePrinter::print@25-75@src/main/java/org/mockito/internal/matchers/text/ValuePrinter.java

2. Are the functions just complex, or also long?  
They are not very long, so it is mostly just high complexity.

3. What is the purpose of the functions?
    1. The purpose is to return a default value for many of the classes and types that can be mocked.
    2. The purpose is to create a mocked class that is very close to the class that is being mocked.
    
    3. Checking if arrays of certain types are equal.
    4. Checking if the `this` object is equal to another object.
    5. The purpose is to create a printable string reperesentation of an object.
    6. The goal of the function is to adjust the module graph for a certain class, if it is required.
    7. Check if a new found constructor is better than any of tge previously found cionstructors.
    8. Prints the methods that have been used on this mock object.
    9. Returns an object that gives a more useful error message than NPE in the event that the result of a method is null.
    10. Returns a string representation of a map in a human readable form to be printed.


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

Report of old coverage: [link]

Report of new coverage: [link]

Test cases added:

git diff ...

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
