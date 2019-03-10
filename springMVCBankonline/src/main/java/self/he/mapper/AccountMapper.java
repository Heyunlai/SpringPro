package self.he.mapper;

import org.apache.ibatis.annotations.Param;
import self.he.pojo.Account;

public interface AccountMapper {

    int getCardNo(@Param("cardNo") String cardNo);


    Account getAccount(@Param("cardNo") String cardNo,@Param("password") String password);

    double getBalance(@Param("cardNo") String cardNo);

    /**
     * 返回1为未冻结
     * @param cardNo
     * @return
     */
    int getStatus(@Param("cardNo") String cardNo);

    void plusMoney(@Param("cardNo") String cardNo, @Param("transactionAmount") Double transactionAmount);

    void minusMoney(@Param("cardNo") String cardNo, @Param("transactionAmount") Double transactionAmount);

    String getPassword(@Param("cardNo") String cardNo);

    void updatePwd(@Param("cardNo") String cardNo, @Param("pwd2") String pwd2);
}
