package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Repairg;
import com.lihai.biyesheji.domain.RepairgTotal;
import com.lihai.biyesheji.mapper.RepairgMapper;
import com.lihai.biyesheji.mapper.RepairgTotalMapper;
import com.lihai.biyesheji.service.RepairgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Service
public class RepairgServiceImpl implements RepairgService {
    @Resource
    private RepairgMapper repairgMapper;
    @Resource
    private RepairgTotalMapper repairgTotalMapper;

    // 条件查询报修信息
    @Override
    public List<Repairg> findall(String search) {
        List<Repairg> findall = repairgMapper.findall(search);
        return findall;
    }
    //新增一个报修单信息
    @Override
    public boolean insertRepairg(Repairg repairg) {
        boolean b = repairgMapper.insertRepairg(repairg);

        Calendar calendar = Calendar.getInstance(); //通过Calendar类的实例对象来获取年月
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH)+1;
        RepairgTotal oneRepairgTotal = repairgTotalMapper.findOne(year, month); ////查找到当前月的公共维修记录
        Integer count = oneRepairgTotal.getCount(); //获取当月公共维修次数
        count = count +1;       //公共维修次数增加
        oneRepairgTotal.setCount(count);
        repairgTotalMapper.update(oneRepairgTotal);     //更新数据库

        return b;
    }
    // 根据id删除报修单信息
    @Override
    public boolean deleteRepairg(Integer repairgId) {
        boolean b = repairgMapper.deleteRepairg(repairgId);
        return b;
    }
    //更新报修单信息
    @Override
    public boolean updateRepairg(Repairg repairg) {
        boolean b = repairgMapper.updateRepairg(repairg);
        return b;
    }
}
