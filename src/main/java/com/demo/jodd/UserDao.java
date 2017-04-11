package com.demo.jodd;

import jodd.db.DbQuery;
import jodd.db.DbSession;

/**
 * Created by liliang on 2017/4/5.
 */
public class UserDao {

    private DbSession session;

    public UserDao(DbSession session) {
        super();
        this.session = session;
    }

    public void update(LopLocalPlan lopLocalPlan){
        String sql = "SELECT * FROM lop_local_plan where 1=1 ";
        DbQuery query = new DbQuery(session,sql);
        //.......

        query.executeUpdate();
    }
}
