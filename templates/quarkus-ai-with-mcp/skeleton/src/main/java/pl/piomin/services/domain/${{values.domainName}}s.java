package ${{ values.groupId }}.domain;

import java.util.List;

public class ${{values.domainName}}s {

    private List<Account> accounts;

    public Accounts() {
    }

    public Accounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
