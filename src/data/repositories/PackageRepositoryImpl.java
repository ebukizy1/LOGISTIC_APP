package data.repositories;
import data.models.Package;
import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository{
    private int count = 1;
    private List<Package> packages = new ArrayList<>();
    @Override
    public Package save(Package apackage) {
        boolean isCorrect = apackage.getId() == 0;
        if(isCorrect)
            saveNew(apackage);
        else update(apackage);
        return apackage;
    }

    private void saveNew(Package apackage) {
        packages.add(apackage);
        apackage.setId(generateID());
    }

    private void update(Package apackage) {
        int index = packages.indexOf(apackage);
        packages.set(index, apackage);
    }

    @Override
    public void delete(Package aPackage) {
        packages.remove(aPackage);

    }
    private int generateID(){
        return count++;
    }

    @Override
    public void delete(int id) {
        delete(findByID(id));
    }

    @Override
    public long count() {
        return packages.size();
    }

    @Override
    public Package findByID(int id) {
        for (Package apackage : packages) {
            boolean isCorrect = apackage.getId() == id;
            if(isCorrect)return apackage;
        }
        return null;
    }



    @Override
    public List<Package> findAll() {
        return packages;
    }
}
