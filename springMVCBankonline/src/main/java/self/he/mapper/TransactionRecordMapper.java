package self.he.mapper;


import self.he.dto.RecordDto;
import self.he.pojo.TransactionRecord;


import java.util.List;

public interface TransactionRecordMapper {
    void insert(TransactionRecord transactionRecord);

    List<TransactionRecord> getRecords(RecordDto recordDto);
}

