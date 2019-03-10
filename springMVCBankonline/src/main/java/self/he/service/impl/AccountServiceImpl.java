package self.he.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.he.constant.Code;
import self.he.mapper.AccountMapper;
import self.he.mapper.TransactionRecordMapper;
import self.he.pojo.Account;
import self.he.pojo.TransactionRecord;
import self.he.service.AccountService;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    //注入Mapper
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    @Override
    public Account getAccount(Account account) {
        return accountMapper.getAccount(account.getCardNo(),account.getPassword());
    }

    @Override
    public boolean getCardNO(String cardNo) {
        int num =accountMapper.getCardNo(cardNo);
        return num==1 ? true :false;

    }

    @Override
    public double getBalance(String cardNo) {

        return accountMapper.getBalance(cardNo);
    }

    @Override
    public Map<String, Object> transfer(Account fromAccount, String cardNo, Double transactionAmount) {
        Map<String, Object> map=new HashMap<>();
        boolean code=false;
        String msg="";
        //1.检查账号是否存在
        int num = accountMapper.getCardNo(cardNo);
        if (num==1){
           num= accountMapper.getStatus(cardNo);
           if(num == 1){
               //激活
               //检查余额够不够
               double balance = accountMapper.getBalance(fromAccount.getCardNo());
               if (balance-transactionAmount>=0){
                   //余额够，转账
                   //1.加钱
                   accountMapper.plusMoney(cardNo,transactionAmount);
                   //2.减钱
                   accountMapper.minusMoney(fromAccount.getCardNo(),transactionAmount);
                   //3.产生记录
                   TransactionRecord transactionRecord = new TransactionRecord();
                   transactionRecord.setCardNo(fromAccount.getCardNo());
                   transactionRecord.setTransactionAmount(transactionAmount);
                   transactionRecord.setTransactionType("转账");
                   transactionRecord.setTransactionDate(new java.sql.Date(new Date().getTime()));
                   transactionRecord.setBalance(balance-transactionAmount);
                   transactionRecordMapper.insert(transactionRecord);
                   transactionRecord.setCardNo(cardNo);
                   transactionRecord.setTransactionAmount(transactionAmount);
                   transactionRecord.setTransactionType("收入");
                   transactionRecord.setTransactionDate(new java.sql.Date(new Date().getTime()));
                   transactionRecord.setBalance(accountMapper.getBalance(cardNo));
                   transactionRecordMapper.insert(transactionRecord);
                   code=true;
                   msg="转账成功！";
               }else{
                   //余额不足
                   msg="余额不足!";
               }
           }else{
               //冻结
               msg="该账户已冻结！";
           }
        }else {
           //不存在
            msg="转入账号不存在！";
        }
        map.put("code",code);
        map.put("msg",msg);

        return map;
    }

    @Override
    public int changePwd(String cardNo, String pwd, String pwd1, String pwd2) {
        if(pwd1.equals(pwd2)&&pwd1.length()==6){
            pwd1=accountMapper.getPassword(cardNo);
            if(pwd1.equals(pwd)){
                accountMapper.updatePwd(cardNo,pwd2);
                return Code.SUCCESS;
            }
        }
        return Code.FAIL;
    }


}
