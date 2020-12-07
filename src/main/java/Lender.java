final class Lender {
    private long availableFunds = 0;

    long getAvailableFunds() {
        return this.availableFunds;
    }

    void addFunds(final long funds) {
        if(funds <= 0) {
            throw new IllegalArgumentException("Amount added must be greater than zero.");
        }
        this.availableFunds = Math.addExact(this.availableFunds, funds);
    }

    public boolean requestedLoanAvailable(long loanAmount) {
        if(this.getAvailableFunds() < loanAmount){
            return false;
        } else {
            return true;
        }
    }
}

