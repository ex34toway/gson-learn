package com.demo.jodd;

import jodd.db.DbSession;
import jodd.db.DbTransactionMode;
import jodd.db.connection.ConnectionProvider;
import jodd.db.connection.DriverManagerConnectionProvider;
import jodd.db.oom.sqlgen.DbSqlBuilder;

/**
 * Created by liliang on 2017/4/5.
 */
public class UserService {

    public static void  main(String [] argv){
        ConnectionProvider cp = new DriverManagerConnectionProvider(
                "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.34.210:3306/nh-lp",
                "root", "root");
        cp.init();      //初始化，实际上就是加载驱动的过程。
        DbSession session = new DbSession(cp);
        session.beginTransaction(new DbTransactionMode().setReadOnly(false));        //设置事务的方式，需要作更新的操作。
        UserDao userDao = new UserDao(session);
        try{
            //userDao.update();
            session.commitTransaction();
            session.closeSession();
        }catch(jodd.db.DbSqlException e){
            session.rollbackTransaction();
        }finally{
            session.closeSession();        //注意关掉session，其他的Connection等会自动被关闭。
        }

        DbSqlBuilder sqlBuilder  = DbSqlBuilder.sql()._();


    }
}
