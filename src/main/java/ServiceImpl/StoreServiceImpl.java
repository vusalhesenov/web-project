package ServiceImpl;

import Dao.StoreDao;
import DaoImpl.StoreDaoImpl;
import Model.Store;
import Service.StoreService;

import java.util.List;

public class StoreServiceImpl implements StoreService {

    StoreDao storeDao = new StoreDaoImpl();
    @Override
    public List<Store> findAll() {
        return storeDao.findAll();
    }
}
