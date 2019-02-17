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
Yes, to build it was needed to run `./gradlew build`
It did however fail to build, due to a failing 
stylecheck. All tests worked correctly, when running
`gradlew test`, however. There was therefore
some things that could be improved.
    
(See the assignment for details; if everything works out of the box,
there is no need to write much here.)


## Complexity

1. What are your results for the ten most complex functions? (If ranking
is not easily possible: ten complex functions)?
   * Did all tools/methods get the same result?
    Yes. Many complex functions contain many 
    else if statements, which is pretty easy to calculate.
   * Are the results clear?
    Yes, the results for the complexity is quite clear.


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

2. Are the functions just complex, or also long?
They are not very long, so it is mostly a high complexity.
3. What is the purpose of the functions?


4. Are exceptions taken into account in the given measurements?
5. Is the documentation clear w.r.t. all the possible outcomes?

## Coverage

### Tools

Document your experience in using a "new"/different coverage tool.

How well was the tool documented? Was it possible/easy/difficult to
integrate it with your build environment?

### DYI

Show a patch that show the instrumented code in main (or the unit
test setup), and the ten methods where branch coverage is measured.

The patch is probably too long to be copied here, so please add
the git command that is used to obtain the patch instead:

git diff ...

What kinds of constructs does your tool support, and how accurate is
its output?

### Evaluation

Report of old coverage: [link]

Report of new coverage: [link]

Test cases added:

git diff ...

## Refactoring

Plan for refactoring complex code:

Carried out refactoring (optional)

git diff ...

## Effort spent

For each team member, how much time was spent in

1. plenary discussions/meetings;

2. discussions within parts of the group;

3. reading documentation;

4. configuration;

5. analyzing code/output;

6. writing documentation;

7. writing code;

8. running code?

## Overall experience

What are your main take-aways from this project? What did you learn?

Is there something special you want to mention here?
