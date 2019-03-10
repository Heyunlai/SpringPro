package self.he.service;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import self.he.dto.RecordDto;
import self.he.pojo.TransactionRecord;

import java.util.Date;
import java.util.List;

public interface TransferRecordService {
    PageInfo<TransactionRecord> getRecords(RecordDto recordDto);
}
