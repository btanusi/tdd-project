## Mortgage Lender App
Every day, potential buyers are looking for a lender to finance their new home.
Let's build an app to simulate a potential (and grossly  over-simplified) process for lenders to qualify and approve loan applicants.

#### Background info:
- https://www.moneyunder30.com/how-your-credit-scores-affect-mortgage-rates 	
- https://blog.mint.com/housing/how-lenders-determine-how-much-house-you-can-afford-1013/
- https://www.wikihow.com/Calculate-Mortgage-Payments

### Objectives:

- Give and receive feedback on pairing behaviors - see Pairing Rubric below
- Practice writing tests first
- Practice writing good tests - SEAT pattern
- Practice the `refactor` phase of red, green, refactor, commit
- Practice frequent commits with good messages

### Instructions

1. This exercise is meant to be completed with pair programming.  Discuss when you will change driver/navigator roles.
2. `fork` this repository.
3. `clone` your fork of this repository.
4. Import the `build.gradle` file into idea.
5. Use the acceptance criteria for the first story to write a failing test.
6. Write the **simplest** code needed to make the test pass. 
7. Refactor. 
    - Are any methods more than 5 or 10 lines of code?
    - Is it obvious what each section of code does? If not, how could you make it obvious?
8. Commit with an informative message
9. Move on to the next user story and continue until all stories are completed.

### Currency
This project models all currency as pennies. So, a value of 100 means $1.00. 
This eliminates the possibility of [floating point math errors](https://www.geeksforgeeks.org/rounding-off-errors-java/) 
in out program.

Like anything in programming, this is a trade-off. 
Another option would be to use `BigDecimal` but then the data type is a bit harder to work with.

### User Stories

1. As a lender, I want to be able to get my available funds so I know how much money I can offer as a loan
    - Given that I am a lender
    - when I check my available funds
    - then I should see how much funds I currently have

1. As a lender, I want to be able to add funds so that I have money to offer loans to potential home buyers
    - Given that I am a lender with a means to store funds,
    - when I add funds to my account
    - then I should see my total available funds increase according to how much I added

1. As a lender, I want to deny applicants who request higher loan amounts than I have available in my funds so that I don't go bankrupt
    - Given that an applicant requests a loan,
    - when the requested amount is greater than the amount of funds I have available
    - then I should deny them

1. As a lender, I want to calculate a monthly mortgage payment so that I can assess whether or not an applicant is a good candidate to offer a loan to
    - Given that I have an equation to calculate monthly mortgage payments:		
        monthlyPayment = principal * ((interestRate/12) * (1+(interestRate/12))^numberOfPayments) / ((1 + (interestRate/12))^numberOfPayments - 1)
    - when I am requested of a loan for a given principal amount, monthly interest rate, and # of payments,
    - then I can calculate the minimum monthly mortgage payment for a LoanApplicant
    - Ex. calculating monthly mortgage for a principal amount of 250000, annualRate of .04, numPayments of 360 should return `1193.54`
    
1. As a lender, I want to determine whether or not an applicant is a good candidate to offer a loan to so that I can qualify or deny them for a requested lon amount
    - Given that a loanApplicant has a good debt-to-income ratio (debt-to-income including requested mortgage < 36%), credit score above 620, an amountSaved >= 25% of the requested loanAmount
    - When they apply for a loan
    - then I should qualify them

1. As a lender, I want to offer a loan contract to a qualified applicant if I have enough available funds so that they can choose to review and accept a loan from me
    - Given that I have enough available funds to offer a loan,
    - when an applicant is deemed to be qualified,
    - then I should offer them a loan.

1. As a lender, I want to approve a qualified applicant who accepts a loan offer so that I can make more money
    - Given that I have sent a loan offer to a qualified applicant,
    - When the applicant accepts my loan offer,
    - Then I should approve them for a loan

1. As a lender, I want to send requested loan amounts to borrowers upon approving their applications so that they can buy a home
    - Given that I have approved a borrower for a loan,
    - when I send them the amount requested
    - then I should update my own available/pending funds accordingly.

1. As a lender, I want to set an expiration date of 3 days on all loan contracts so that I can manage my time and money wisely
    - Given that I have a good candidate to offer a loan to,
    - when I offer them a loan
    - then I should set an expiration date of 3 days on the offer.

1. As a lender, I want to keep funds for pending loan contracts in a secondary account so that I don't extend too many offers at once and bankrupt myself
    - Given that I have a good candidate to offer a loan to,
    - when I offer them a loan
    - then I should move the requested loan amount from my available funds to my pending funds

1. As a lender, I want to reclaim funds set aside for pending loan contracts back into my available funds once the offer expires so that I have more funds readily available to offer to other applicants.
    - Given that I sent a loan contract to a qualified applicant,
    - when the loan contract expires with no response,
    - then I want to reclaim the pending funds back into my available funds

