package data.repositories;


import data.models.Package;

import java.util.List;

public interface PackageRepository {
     Package save (Package aPackage);
    void delete(Package aPackage);
    void  delete(int id);
    long count();
    Package findByID(int id);
    List<Package> findAll();


}
