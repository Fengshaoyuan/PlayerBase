package com.kk.taurus.playerbase.record;

import com.kk.taurus.playerbase.entity.DataSource;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface RecordKeyProvider {

    String generatorKey(DataSource dataSource);

}
