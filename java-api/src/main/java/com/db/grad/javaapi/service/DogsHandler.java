package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.model.*;

import java.util.List;

public class DogsHandler {

    private DogsRepository itsDogRepo;

    public DogsHandler(DogsRepository repo) {
        itsDogRepo= repo;
    }

    public long addDog(Dog theDog){
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs(){
        return itsDogRepo.count();
    }

public Dog getDogByName(String dogsName ) {
    Dog dogToFind = new Dog();
    dogToFind.setName(dogsName);
    List<Dog> dogs = itsDogRepo.findByName(dogToFind);
    Dog result = null;

    if (dogs.size() == 1)
        result = dogs.get(0);

    return result;
}

public Dog getDogById(long id){
    return itsDogRepo.findById(id);
}

public long updateDogDetails(Dog dog){
        return itsDogRepo.save(dog);
    }

    public boolean removeDog(long id){

        return itsDogRepo.delete(itsDogRepo.findById(id));
    }

}

