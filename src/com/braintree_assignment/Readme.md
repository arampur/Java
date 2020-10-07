#Assignment - Basic Credit Card Processing

#Main Objective Of the Program
    a. Program will add new Credit Card accounts, process charges and credits against them.
    b. Display total summary information


#Input Assumptions:

- All input will be valid. For example, you don't need to check for or gracefully handle:
  - Illegal characters
  - Malformed commands
  - Capitalization changes
  - Multiple "Add" commands for the same name
  - Different names with the same credit card number
  - "Charge" or "Credit" commands without a preceding "Add" command
- All input will be space delimited.
- Credit card numbers may vary in length up to 19 characters.
- Credit card numbers will always be numeric.
- Amounts will always be prefixed with "$" and will be in whole dollars (no
  decimals).
  
  #Sample Input and Output
  Given the following input:

  ```
  Add Tom 4111111111111111 $1000
  Add Lisa 5454545454545454 $3000
  Add Quincy 1234567890123456 $2000
  Charge Tom $500
  Charge Tom $800
  Charge Lisa $7
  Credit Lisa $100
  Credit Quincy $200
  ```

  Your program must produce the following output:

  ```
  Lisa: $-93
  Quincy: error
  Tom: $500
  ```

#Design Decision
    1.  Collections/Data Structures used:
                a. TreeMap: To store the account name as the key and the Credit card information as the List Object. Reason to chose treeMap is to achieve the sorted order while displaying the summary information.
                b. List: To hold the Credit Card Detail POJO Class.
    2.  I have decided to create a POJO class which holds the information to process which includes account name, card number, Balance, limit and the transaction type (Charge, Add, Credit).
    3. The program logic is in the main program.
    4. Depending on the transaction type, I have three different loops (Charge, Add and Credit)
    5. For Credit Card Verification, I have used the Luhn's Algorithm to validate the credit card number. I only make an insert into the map, after successfull validation. Else the map will have an entry with the Account name and error as the balance. (The reason behind this is, no matter what type of transaction I run against the invalid credit card number, the total balance wil always be an error or basically ignored)
    6. Add Functionality:
                a. Inserts into the map after successful Credit card number validation.
    7. Charge Functionality:
                a. I get the transaction list by searching for the account name from the hashmap.
                b. If account name is found, I gather the transaction information and calculate the limit with the balance and update the new balance.
    8. Credit Functionality:
                a. After I get the transaction list, I check for the old balance (from the map) and the new balance from the given input and the value is positive if there is sufficient balance. 
                b. If not the balance will be negative as the credit that decrease the balance below 0$ will create a negative balance.
                

#Programming Language
JAVA - I have chosen JAVA as my programming language as Java is platform independent. The only requirement is to have an installed JRE  and the program can be easily executed. Majority of the machines are compatible with JRE (Windows, Macintosh, Unix or Linux Computers). With the requirement being able to execute the program on either a Mac or Linux, I prefer to use JAVA as my programming language. Apart from that I have been working on JAVA over the last few years and I am comfortable building applications in JAVA. It is also my preferred programming language.
        
#Installation Requirements
This program is run on JAVA 8 and expects java 8 verison to be installed.

#Instructions for Program Execution.
    1. Make sure all the files (input.txt, MainProgram.java, CreditDebitDtl.java) are in the same folder. It is easier to compile, else the files path will have to be specified.
    2. Compile the MainProgram.java using java compiler to create the class files.
        Command: javac MainProgram.java (This will create both the MainProgram.java and CreditDebitDtl.java class files)
    3. Run the main program including the input.txt as the command line argument as per below command to see the summary information:
        java MainProgram input.txt
    4. Test Cases: I have created several test cases named as (input.txt, input1.txt, input2.txt, input3.txt, input4.txt). To re-run the same tests again, pass the arguments along with the progam file accoringly.
        


© AMITH RAMPUR - BRAINTREE 
