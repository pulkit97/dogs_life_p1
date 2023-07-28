package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.db.grad.javaapi.model.*;

import static org.junit.jupiter.api.Assertions.*;

class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        DogsHandler cut = new DogsHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        int expectedResult = 1;

        long actualResult = cut.getNoOfDogs();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added(){

        DogsHandler cut = new DogsHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog theDog1 = new Dog();
        theDog.setName("ffea");
        cut.addDog( theDog1 );

        Dog theDog2 = new Dog();
        theDog.setName("dadaew");
        cut.addDog( theDog2 );

        Dog theDog3 = new Dog();
        theDog.setName("feaf");
        cut.addDog( theDog3 );

        int expectedResult = 4;

        long actualResult = cut.getNoOfDogs();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getDogByName(){

        DogsHandler cut = new DogsHandler(itsDogRepo);

        Dog expectedResult = new Dog();
        expectedResult.setName("Bruno");
        cut.addDog( expectedResult );


        Dog actualResult = cut.getDogByName("Bruno");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public  void    find_dog_by_name_returns_one_dog() {
        // arrange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog(theDog);
        Dog expectedDog = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        // act
        Dog actualResult = cut.getDogByName(dogToFind);

        // assert
        assertEquals(expectedDog.getId(), actualResult.getId());
        assertEquals(expectedDog.getName(), actualResult.getName());
    }


        @Test
        public  void    find_dog_by_name_returns_null_because_many_dogs_with_same_name()
        {
                    // arrange
            DogsHandler cut = new DogsHandler( itsDogRepo );
                            Dog theDog = new Dog();
                                    theDog.setName("Bruno");
                                            cut.addDog( theDog );

    }

//    @Test
//    public void getDogById(){
//        DogsHandler cut = new DogsHandler(itsDogRepo);
//
//        Dog expectedResult = new Dog();
//        expectedResult.setName("Bruno");
//        expectedResult.setId(2342);
//        cut.addDog( expectedResult );
//
//
//        Dog actualResult = cut.getDogById(2342l);
//
//        assertEquals("Bruno", actualResult.getName());
//
//    }

    @Test
    public  void    find_dog_by_valid_id_returns_one_dog() {
        // arrange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        long uniqueId = cut.addDog(theDog);
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        // act
        Dog actualResult = cut.getDogById(uniqueId);

        // assert
        assertEquals(expectedDog.getId(), actualResult.getId());
        assertEquals(expectedDog.getName(), actualResult.getName());
    }

    @Test
    public  void    find_dog_by_invalid_id_returns_null_dog() {
        // arrange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        long uniqueId = cut.addDog(theDog);
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        // act
        Dog actualResult = cut.getDogById(33);

        // assert
        assertNull(actualResult);
    }
    @Test
    public  void    update_dog_that_exists_returns_dog_id() {
        // arrange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        long expectedResult = cut.addDog(theDog);
        Dog dogToUpdate = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        // act
        dogToUpdate.setName("Charlie");
        long actualResult = cut.updateDogDetails(dogToUpdate);

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public  void    add_dog_and_remove_dog_return_number_of_dogs_is_zero() {
        // arrange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        long uniqueId = cut.addDog(theDog);

        long expectedResult = 0;
        boolean expectedStatus = true;


        // act
        boolean actualStatus = cut.removeDog(uniqueId);
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(expectedStatus, actualStatus);
        assertEquals(expectedResult, actualResult);
    }

    @Test    public  void    add_dog_and_remove_dog_that_doess_not_exist_return_number_of_dogs_is_one() {
        // arrange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        long uniqueId = cut.addDog(theDog);

        long expectedResult = 1;
        boolean expectedStatus = false;


        // act
        // There is no dog with ID == 33
        boolean actualStatus = cut.removeDog(33);
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(expectedStatus, actualStatus);
        assertEquals(expectedResult, actualResult);
    }
    }
