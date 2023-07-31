package marimo.harmonimo.service;

import marimo.harmonimo.repository.Log1Repository;
import marimo.harmonimo.repository.Log2Repository;
import marimo.harmonimo.repository.Log3Repository;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final Log1Repository log1Repository;
    private final Log2Repository log2Repository;
    private final Log3Repository log3Repository;

    public LogService(Log1Repository log1Repository, Log2Repository log2Repository, Log3Repository log3Repository) {
        this.log1Repository = log1Repository;
        this.log2Repository = log2Repository;
        this.log3Repository = log3Repository;
    }


}
