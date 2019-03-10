package self.he.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import self.he.dto.RecordDto;
import self.he.pojo.TransactionRecord;
import self.he.service.TransferRecordService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/transferRecord")
public class TransferRecordController {
    @Autowired
    private TransferRecordService transferRecordService;

    @RequestMapping("/index")
    public String transferRecordTo(Model model){
        model.addAttribute("page","transferRecord");
        return "jsp/main";
    }
    @RequestMapping("/query")
    public String transferRecord(RecordDto recordDto, Model model){
        model.addAttribute("page","transferRecord");
        System.out.println(recordDto.getPageNum()+"||"+recordDto.getPageSize());
        PageInfo<TransactionRecord> transactionRecords=transferRecordService.getRecords(recordDto);
        model.addAttribute("records",transactionRecords);
        return "jsp/main";
    }
}
