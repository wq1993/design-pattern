package com.pattern.prototype.business;

/**
 * Created by wq on 2019/3/18
 */
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao;

    public boolean updateCustomerByPrimaryKey(CustomerVo customerVo) {
        try {
            CustomerPo customer = (CustomerPo) customerVo.clone();
            customerDao.updateCustomerByPrimaryKey(customer);
            return true;
        } catch (Exception e) {
            // log.error(e.getMessage())
            return false;
        }
    }
}
