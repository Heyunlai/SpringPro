package self.he.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import self.he.dto.RecordDto;
import self.he.mapper.TransactionRecordMapper;
import self.he.pojo.Account;
import self.he.pojo.TransactionRecord;

import self.he.service.TransferRecordService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("TransferRecordService")
public class TransferRecordServiceImpl implements TransferRecordService {
    //注入Mapper


    @Autowired
    private TransactionRecordMapper transactionRecordMapper;


    @Override
    public PageInfo<TransactionRecord> getRecords(RecordDto recordDto) {
        PageHelper.startPage(recordDto.getPageNum(),recordDto.getPageSize());
        List<TransactionRecord> list= transactionRecordMapper.getRecords(recordDto);
        PageInfo<TransactionRecord> page = new PageInfo<>(list);

        return page;
    }

}
