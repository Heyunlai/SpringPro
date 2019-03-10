package self.he.service;


import self.he.pojo.Account;

import java.util.Map;

public interface AccountService {
    /**
     * 根据account去检查数据库是否存在用户
     * @param user
     * @return
     */

//    User get(User user);
    Account getAccount(Account account);

    boolean getCardNO(String cardNo);

    double getBalance(String cardNo);

    Map<String,Object> transfer(Account fromAccount, String cardNo, Double transactionAmount);


    int changePwd(String cardNo, String pwd, String pwd1, String pwd2);
}
