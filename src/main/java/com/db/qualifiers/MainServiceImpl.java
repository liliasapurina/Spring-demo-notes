package com.db.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.db.qualifiers.DBType.MONGO;
import static com.db.qualifiers.DBType.ORACLE;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    @DBRepo(MONGO)
    private Dao mainDao;

    @Autowired
    @DBRepo(ORACLE)
    private Dao backupDao;

    @Override
    @Scheduled(cron = "1/1 * * * * ?")
    public void doWork() {
        System.out.println("Working...");
        mainDao.crud();
    }

    @Override
    @Scheduled(cron = "1/3 * * * * ?")
    public void doBackup() {
        System.out.println("backuping...");
        backupDao.crud();
    }
}




