package com.senchuuhi.iweb.system.main.service.impl;


import com.github.pagehelper.PageHelper;
import com.senchuuhi.iweb.auto.dao.ResInfoMapper;
import com.senchuuhi.iweb.auto.entity.ResInfo;
import com.senchuuhi.iweb.auto.entity.ResInfoExample;
import com.senchuuhi.iweb.system.main.service.ResInfoService;
import com.senchuuhi.iweb.wsk.entity.WSReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResInfoServiceImpl implements ResInfoService {

    @Autowired
    private ResInfoMapper resInfoMapper;

    /**
     * 获取SS信息
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    public WSReturn getInfo(Integer pageNum, Integer pageSize, String keyword, String type) {
        if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
            pageNum = 1;
            pageSize = 10;
        }
        WSReturn wsr = new WSReturn();
        // 创建查询
        ResInfoExample example = new ResInfoExample();
        ResInfoExample.Criteria cri = example.createCriteria()
                .andDelFlagEqualTo("0");
        if (keyword != null && !"".equals(keyword.trim())) {
            cri.andTitleLike("%" + keyword + "%");
        }
        if (type != null && !"".equals(type.trim())) {
            cri.andTypeEqualTo(type);
        }
        // 计算条数
        long count = resInfoMapper.countByExample(example);
        wsr.setTotal(count);
        PageHelper.startPage(pageNum, pageSize);
        // 计算分页查询
        example.setOrderByClause("PUBLISH_TIME DESC");
        wsr.setData(resInfoMapper.selectByExample(example));
        return wsr;
    }

    /**
     * 获取SS信息
     *
     * @return
     */
    public WSReturn getInfoDetail(Integer id) {
        WSReturn wsr = new WSReturn();
        if (id == null) {
            wsr.setStatus(false);
            wsr.setMessage("id null");
            return wsr;
        }

        ResInfoExample example = new ResInfoExample();
        example.createCriteria().andIdEqualTo(id).andDelFlagEqualTo("0");
        List<ResInfo> list = resInfoMapper.selectByExample(example);
        if (list.size() > 0) {
            wsr.setData(list.get(0));
        }
        return wsr;
    }
}
