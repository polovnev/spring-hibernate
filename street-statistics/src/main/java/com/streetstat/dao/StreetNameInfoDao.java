package com.streetstat.dao;



import com.streetstat.model.StreetNameInfo;

import java.util.List;

public interface StreetNameInfoDao extends Dao {

    public List<StreetNameInfo> getStreetNameInfos(int page, int pageSize);

}
