package self.he.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.helpers.AttributesImpl;
import self.he.pojo.Account;
import self.he.pojo.TransactionRecord;
import self.he.service.AccountService;
import self.he.service.TransferRecordService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    //注入UserService
    @Autowired
    private AccountService accountService;



    @RequestMapping("/login")
    public String login(Account account, HttpSession session, Model model){
        //检查账号是否存在
        boolean exit  = accountService.getCardNO(account.getCardNo());

        if(exit){
           //存在，则验证密码
            account = accountService.getAccount(account);
            if (account==null){
                   //密码错误
                  model.addAttribute("errorMsg","密码错误！");
                  return "index";
            }else {
                //检查状态
                if(account.getStatus()==0){
                       //账号冻结
                    model.addAttribute("errorMsg","账户已被冻结！");
                    return "index";

                }else {
                    session.setAttribute("SESSION_ACCOUNT",account);
                    return "jsp/main";
                }

            }
        }else {
            model.addAttribute("errorMsg","账户不存在！");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("SESSION_ACCOUNT");
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/balance/{cardNo}")
    public String balance(@PathVariable("cardNo")String cardNo,Model model){
      double balance=accountService.getBalance(cardNo);
      model.addAttribute("balance",balance);
      model.addAttribute("page","balance");
      return "jsp/main";
    }

    @RequestMapping("/transferTo")
    public String transferTo(Model model){
        model.addAttribute("page","transfer");
        return "jsp/main";
    }

    @RequestMapping("/transfer")
    public String transfer(@RequestParam("cardNo")String cardNo,@RequestParam("transactionAmount")Double transactionAmount, HttpSession session, Model model){
        Account fromAccount = (Account) session.getAttribute("SESSION_ACCOUNT");
        model.addAttribute("page","transfer");
        Map<String,Object> map=accountService.transfer(fromAccount,cardNo,transactionAmount);
        model.addAttribute("code",map.get("code"));
        model.addAttribute("msg",map.get("msg"));
        return "jsp/main";
    }
    @RequestMapping("/changeTo")
    public String changeTo(Model model){
        model.addAttribute("page","changePwd");
        return "jsp/main";
    }
    @RequestMapping("/changePwd")
    public String changePwd(@RequestParam("pwd")String pwd,@RequestParam("pwd1")String pwd1,@RequestParam("pwd2")String pwd2,Model model,HttpSession session){
        model.addAttribute("page","changePwd");
        Account account = (Account) session.getAttribute("SESSION_ACCOUNT");
        int code=accountService.changePwd(account.getCardNo(),pwd,pwd1,pwd2);
        System.out.println(code);
        model.addAttribute("code",code);
        return "jsp/main";
    }

}
