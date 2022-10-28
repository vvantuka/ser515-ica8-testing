# ser515-ica8-testing


The unwritten rule in urinals is that you leave at least one urinal space between you and the next person peeing. So, our 
task is to count the maximum number of free urinals according to the unwritten rule.

### Input
The input is a string containing 0s and 1s, where 0s denote unoccupied urinal and 1s denote occupied urinal. 

### Output
The output is the maximum number of free urinals as an integer.

We are reading the string of inputs from the input file "test_files/urinal.dat"

After calculating the output, it is appended in "test_files/rule.txt"
_________________________________________________________________________
For the class "urinals", there are five functions
1) **Main** - main method called on execution.
2) **checkString** - Verifies if the given string is valid i.e it only has 0s and 1s.
3) **readFile** - reads the file. Each individual line(string) in the file is an element in the ArrayList of strings i.e output
of the function.
4) **writeFile** - writes the results obtained into a text file.
5) **goodString** - Counts the maximum number of free urinals present according to the unwritten rule.

### Unit Tests - 
- **Test 1** - demo test checks true
- **Test 2** - happyPath for goodString function
- **Test 3** - badPath for goodString function
- **Test 4** - happyPath for checkString function
- **Test 5** - badPath for checkString function
- **Test 6** - happyPath for readFile function
- **Test 7** - readFile function throws IOException
- **Test 8** - happyPath for writeFile function
- **Test 9** - writeFile function throws NULLPointerException