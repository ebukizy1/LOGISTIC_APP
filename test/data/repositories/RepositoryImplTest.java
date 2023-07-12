package data.repositories;

import data.models.Package;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryImplTest {
            PackageRepository repository;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { repository = new PackageRepositoryImpl();
    }

 @Test
 public  void testSaveOne_CountIsOne(){
        Package aPackage = new Package();
        repository.save(aPackage);
   assertEquals(1, repository.count() );
    }
    @Test
    public void testSaveTwo_CountIsTwo(){
        Package aPackage = new Package();
        Package packages = new Package();
        repository.save(aPackage);
        repository.save(packages);
        assertEquals(2, repository.count());
    }
    @Test
    public void testSaveOnePackage_PackageIsOne(){
        Package packages = new Package();
        assertEquals( 1, repository.save(packages).getId());
    }
    @Test
    public void testSaveOne_FindByIdReturnsSame(){
        Package aPackage = new Package();
        Package packages = new Package();
        repository.save(aPackage);
        repository.save(packages);
        assertSame(packages, repository.findByID(2));
    }
    @Test
    public void testSaveOneUpdateOne_CountIsOne(){
        Package aPackage = new Package();
        repository.save(aPackage);
        aPackage.setId(1);
        repository.save(aPackage);
        assertEquals(1, repository.count());
    }
    @Test
    public void testSaveTwo_FindAll_SizeIsTwo(){
        Package aPackage = new Package();
        Package packages = new Package();
        repository.save(aPackage);
        repository.save(packages);
        assertEquals(2, repository.findAll().size());
    }
    @Test
    public void testSaveTwo_DeleteOne_CountIsOne(){
        Package aPackage = new Package();
        Package packages = new Package();
        repository.save(aPackage);
        repository.save(packages);
        repository.delete(aPackage);
        assertEquals(1, repository.count());
    }
    @Test
    public void testSaveTwo_DeleteOneWithID_CountIsOne(){
        Package aPackage = new Package();
        Package packages = new Package();
        repository.save(aPackage);
        repository.save(packages);
        repository.delete(2);
        assertEquals(1, repository.count());
    }
    @Test
    public void testSaveOneUpdateOne_CountIsOneAndSetDescription(){
        Package aPackage = new Package();
        repository.save(aPackage);
        repository.save(aPackage);
        assertEquals(1, repository.count());

    }





}