# CSX42: Assignment 5
## Name: Sagar Toke

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Point to note:

1. input.txt and acceptableWords.text should be in spellCheckerVisitorPlay/ directory 
2. TopK result and SpellCheck result files  will be generated at spellCheckerVisitorPlay/ directory 
3. For acceptable word files I've checked the file contents as one word per line with no spaces as an extra validation.

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in spellCheckerVisitorPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile spellCheckerVisitorPlay/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile spellCheckerVisitorPlay/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

Requirement: input file should be in numberPlay folder
#### Use the below command to run the program.

```commandline
ant run -buildfile spellCheckerVisitorPlay/src/build.xml  
-Dinput=<!-- Name of the input file containing sentences-->
-DacceptableWordsFile=<!--Name of the file containing acceptable words.--> 
-Dk=<!-- Max size of the list containing the most frequent words. Must be > 0. -->
-DtopKOutputFile=<!-- Name of the output file to which the top K words are written for each sentence analyzed -->
-DspellCheckOutputFile= <!-- Name of the output file to which the possible spelling fixes are written -->

-----------------------------------------------------------------------
## Description:
Builder and Visitor pattern implementation



1. Assumption:
  - Input file is well formatted containing sentences which contains characters 'A-Z', 'a-z', 'space' and 'period(.)'.
  - The last sentence in the Input file if does not ends with a period charater, the application considers it as sentence completion.
  - Acceptable words file is well formatted containing sentences which contains characters 'A-Z', 'a-z', 'new lines - (for reading words line-by-line)')'.

2. Data Structures:
  - Map<String, Integer> - For storing words with frequency count while reading each word.

  - TreeMap<String, Integer> - For storing sorted words with frequency count after passing the above to the Comparator.

  - ArrayList<String> - 
    - For storing acceptable words list.
    - For storing the final Word frequency result for a particular sentence
    - For storing the list of spell check words list for the misspelled word
    - For storing the the final result for Spell check analysis on a particular sentence

- ArrayList<ElementI> - For storing the ArrayList of type ElementI


3. External Materials:
    - N/A

4. Compiling:
    - Follow the instructions as mentioned above.

5. Execute Program:
    - Follow the instruction as mentioned above.

6. Code Working:
  - Each line is read from the input file containing sentences where each sentence is then wrapped into a MyElement object and its interface ElementI is stored into the MyArrayList<ElementI>.
  - Each element is fetched where two visitors, SpellCheckAnalyzer and TopKFrequentWordsAnalyzer, visit each element and perform the operations.
  - While performing each operation, the result is stored the Results (SpellCheck and TopKFrequentWords).
  - Once all the elements are visited, the stored output is persisted to respective output files.
 
##References and citation

-----------------------------------------------------------------------


